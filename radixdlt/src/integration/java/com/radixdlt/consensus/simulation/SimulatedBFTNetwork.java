/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.consensus.simulation;

import com.google.common.collect.ImmutableMap;
import com.radixdlt.consensus.BasicEpochChangeRx;
import com.radixdlt.consensus.ConsensusRunner;
import com.radixdlt.consensus.ConsensusRunner.Event;
import com.radixdlt.consensus.ConsensusRunner.EventType;
import com.radixdlt.consensus.DefaultHasher;
import com.radixdlt.consensus.EmptySyncVerticesRPCSender;
import com.radixdlt.consensus.EpochManager;
import com.radixdlt.consensus.EpochChangeRx;
import com.radixdlt.consensus.Hasher;
import com.radixdlt.consensus.InternalMessagePasser;
import com.radixdlt.consensus.SyncedStateComputer;
import com.radixdlt.consensus.Vertex;
import com.radixdlt.consensus.VertexStore;
import com.radixdlt.consensus.SyncVerticesRPCSender;
import com.radixdlt.consensus.VertexStoreEventsRx;
import com.radixdlt.consensus.VertexStoreFactory;
import com.radixdlt.consensus.liveness.FixedTimeoutPacemaker;
import com.radixdlt.consensus.liveness.ScheduledTimeoutSender;
import com.radixdlt.consensus.liveness.WeightedRotatingLeaders;
import com.radixdlt.counters.SystemCounters;
import com.radixdlt.counters.SystemCountersImpl;
import com.radixdlt.crypto.ECKeyPair;
import com.radixdlt.mempool.EmptyMempool;
import com.radixdlt.mempool.Mempool;

import com.radixdlt.middleware2.CommittedAtom;
import com.radixdlt.middleware2.network.TestEventCoordinatorNetwork;
import com.radixdlt.middleware2.network.TestEventCoordinatorNetwork.SimulatedNetworkReceiver;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.CompletableSubject;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

import static com.radixdlt.utils.ThreadFactories.daemonThreads;

/**
 * A multi-node bft test network where the network and latencies of each message is simulated.
 */
public class SimulatedBFTNetwork {
	private final int pacemakerTimeout;
	private final TestEventCoordinatorNetwork underlyingNetwork;
	private final ImmutableMap<ECKeyPair, SystemCounters> counters;
	private final ImmutableMap<ECKeyPair, InternalMessagePasser> internalMessages;
	private final ImmutableMap<ECKeyPair, ConsensusRunner> runners;
	private final List<ECKeyPair> nodes;
	private final boolean getVerticesRPCEnabled;

	/**
	 * Create a BFT test network with an underlying simulated network.
	 * @param nodes The nodes to populate the network with
	 * @param underlyingNetwork the network simulator
	 * @param pacemakerTimeout a fixed pacemaker timeout used for all nodes
	 */
	public SimulatedBFTNetwork(
		List<ECKeyPair> nodes,
		TestEventCoordinatorNetwork underlyingNetwork,
		int pacemakerTimeout,
		boolean getVerticesRPCEnabled
	) {
		this.nodes = nodes;
		this.getVerticesRPCEnabled = getVerticesRPCEnabled;
		this.underlyingNetwork = Objects.requireNonNull(underlyingNetwork);
		this.pacemakerTimeout = pacemakerTimeout;
		this.counters = nodes.stream().collect(ImmutableMap.toImmutableMap(e -> e, e -> new SystemCountersImpl()));
		this.internalMessages = nodes.stream().collect(ImmutableMap.toImmutableMap(e -> e, e -> new InternalMessagePasser()));
		this.runners = nodes.stream().collect(ImmutableMap.toImmutableMap(e -> e, this::createBFTInstance));
	}

	private ConsensusRunner createBFTInstance(ECKeyPair key) {
		Mempool mempool = new EmptyMempool();
		Hasher hasher = new DefaultHasher();
		ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(daemonThreads("TimeoutSender"));
		ScheduledTimeoutSender timeoutSender = new ScheduledTimeoutSender(scheduledExecutorService);
		EpochChangeRx epochChangeRx = new BasicEpochChangeRx(nodes.stream().map(ECKeyPair::getPublicKey).collect(Collectors.toList()));
		VertexStoreFactory vertexStoreFactory = (v, qc) -> {
			SyncedStateComputer<CommittedAtom> stateComputer = new SingleEpochAlwaysSyncedStateComputer();
			SyncVerticesRPCSender syncVerticesRPCSender = getVerticesRPCEnabled
				? underlyingNetwork.getVerticesRequestSender(key.getPublicKey())
				: EmptySyncVerticesRPCSender.INSTANCE;
			return new VertexStore(
				v,
				qc,
				stateComputer,
				syncVerticesRPCSender,
				this.internalMessages.get(key),
				this.counters.get(key)
			);
		};

		EpochManager epochManager = new EpochManager(
			mempool,
			underlyingNetwork.getNetworkSender(key.getPublicKey()),
			timeoutSender,
			timeoutSender1 -> new FixedTimeoutPacemaker(this.pacemakerTimeout, timeoutSender1),
			vertexStoreFactory,
			proposers -> new WeightedRotatingLeaders(proposers, Comparator.comparing(v -> v.nodeKey().euid()), 5),
			hasher,
			key,
			counters.get(key)
		);

		SimulatedNetworkReceiver rx = underlyingNetwork.getNetworkRx(key.getPublicKey());

		return new ConsensusRunner(epochChangeRx,
			rx,
			timeoutSender,
			internalMessages.get(key),
			Observable::never,
			rx,
			epochManager
		);
	}

	// TODO: Add support for epoch changes
	public interface RunningNetwork {
		Vertex getGenesisVertex();

		List<ECKeyPair> getNodes();

		VertexStoreEventsRx getVertexStoreEvents(ECKeyPair keyPair);

		SystemCounters getCounters(ECKeyPair keyPair);

		TestEventCoordinatorNetwork getUnderlyingNetwork();
	}

	public Single<RunningNetwork> start() {
		// Send start event once all nodes have reached real epoch event
		final CompletableSubject completableSubject = CompletableSubject.create();
		List<Completable> startedList = this.runners.values().stream()
			.map(ConsensusRunner::events)
			.map(o -> o.map(Event::getEventType)
				.filter(e -> e.equals(EventType.EPOCH_CHANGE))
				.firstOrError()
				.ignoreElement()
			).collect(Collectors.toList());

		Completable.merge(startedList).subscribe(completableSubject::onComplete);

		this.runners.values().forEach(ConsensusRunner::start);

		return completableSubject.toSingle(() -> new RunningNetwork() {
			@Override
			public Vertex getGenesisVertex() {
				return Vertex.createGenesis();
			}

			@Override
			public List<ECKeyPair> getNodes() {
				return nodes;
			}

			@Override
			public VertexStoreEventsRx getVertexStoreEvents(ECKeyPair keyPair) {
				return internalMessages.get(keyPair);
			}

			@Override
			public SystemCounters getCounters(ECKeyPair keyPair) {
				return counters.get(keyPair);
			}

			@Override
			public TestEventCoordinatorNetwork getUnderlyingNetwork() {
				return underlyingNetwork;
			}
		});
	}

	public void stop() {
		this.runners.values().forEach(ConsensusRunner::stop);
	}
}
