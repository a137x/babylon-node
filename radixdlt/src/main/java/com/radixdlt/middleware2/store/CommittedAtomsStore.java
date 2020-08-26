/*
 * (C) Copyright 2020 Radix DLT Ltd
 *
 * Radix DLT Ltd licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License.  You may obtain a copy of the
 * License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.  See the License for the specific
 * language governing permissions and limitations under the License.
 */

package com.radixdlt.middleware2.store;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.radixdlt.consensus.Command;
import com.radixdlt.consensus.VertexMetadata;
import com.radixdlt.identifiers.AID;
import com.radixdlt.constraintmachine.Particle;
import com.radixdlt.constraintmachine.Spin;
import com.radixdlt.identifiers.EUID;
import com.radixdlt.middleware2.ClientAtom;
import com.radixdlt.statecomputer.ClientAtomToBinaryConverter;
import com.radixdlt.statecomputer.CommittedAtom;
import com.radixdlt.middleware2.LedgerAtom;
import com.radixdlt.statecomputer.CommittedCommandsReader;
import com.radixdlt.statecomputer.CommittedAtoms;
import com.radixdlt.statecomputer.RadixEngineStateComputer.CommittedAtomSender;
import com.radixdlt.store.SearchCursor;
import com.radixdlt.store.StoreIndex;
import com.radixdlt.store.LedgerSearchMode;
import com.radixdlt.statecomputer.CommandToBinaryConverter;
import com.radixdlt.store.EngineStore;
import com.radixdlt.store.LedgerEntry;
import com.radixdlt.store.LedgerEntryStore;

import com.radixdlt.ledger.CommittedCommand;
import java.util.List;
import java.util.Objects;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.function.Consumer;

public final class CommittedAtomsStore implements EngineStore<CommittedAtom>, CommittedCommandsReader {
	private static final Logger log = LogManager.getLogger();

	private final AtomIndexer atomIndexer;
	private final LedgerEntryStore store;
	private final CommandToBinaryConverter commandToBinaryConverter;
	private final ClientAtomToBinaryConverter clientAtomToBinaryConverter;
	private final CommittedAtomSender committedAtomSender;

	public interface AtomIndexer {
		EngineAtomIndices getIndices(LedgerAtom atom);
	}

	public CommittedAtomsStore(
		CommittedAtomSender committedAtomSender,
		LedgerEntryStore store,
		CommandToBinaryConverter commandToBinaryConverter,
		ClientAtomToBinaryConverter clientAtomToBinaryConverter,
		AtomIndexer atomIndexer
	) {
		this.committedAtomSender = Objects.requireNonNull(committedAtomSender);
		this.store = Objects.requireNonNull(store);
		this.commandToBinaryConverter = Objects.requireNonNull(commandToBinaryConverter);
		this.clientAtomToBinaryConverter = Objects.requireNonNull(clientAtomToBinaryConverter);
		this.atomIndexer = Objects.requireNonNull(atomIndexer);
	}

	@Override
	public void getAtomContaining(Particle particle, boolean isInput, Consumer<CommittedAtom> callback) {
		Optional<CommittedAtom> atomOptional = getAtomByParticle(particle, isInput);
		atomOptional.ifPresent(callback);
	}

	private Optional<CommittedAtom> getAtomByParticle(Particle particle, boolean isInput) {
		final byte[] indexableBytes = EngineAtomIndices.toByteArray(
		isInput ? EngineAtomIndices.IndexType.PARTICLE_DOWN : EngineAtomIndices.IndexType.PARTICLE_UP,
			particle.euid()
		);
		SearchCursor cursor = store.search(StoreIndex.LedgerIndexType.UNIQUE, new StoreIndex(indexableBytes), LedgerSearchMode.EXACT);
		if (cursor != null) {
			return store.get(cursor.get())
				.flatMap(ledgerEntry ->  {
					// TODO: Remove serialization/deserialization
					CommittedCommand committedCommand = commandToBinaryConverter.toCommand(ledgerEntry.getContent());
					ClientAtom clientAtom = committedCommand.getCommand().map(clientAtomToBinaryConverter::toAtom);
					return Optional.of(new CommittedAtom(clientAtom, committedCommand.getVertexMetadata()));
				});
		} else {
			log.debug("getAtomByParticle returned empty result");
			return Optional.empty();
		}
	}

	@Override
	public void storeAtom(CommittedAtom committedAtom) {
		// TODO: Remove serialization/deserialization
		byte[] payload = clientAtomToBinaryConverter.toLedgerEntryContent(committedAtom.getClientAtom());
		Command command = new Command(payload);
		CommittedCommand committedCommand = new CommittedCommand(command, committedAtom.getVertexMetadata());
		byte[] binaryAtom = commandToBinaryConverter.toLedgerEntryContent(committedCommand);
		VertexMetadata vertexMetadata = committedAtom.getVertexMetadata();
		LedgerEntry ledgerEntry = new LedgerEntry(binaryAtom, vertexMetadata.getStateVersion(), committedAtom.getAID());
		EngineAtomIndices engineAtomIndices = atomIndexer.getIndices(committedAtom);

		// TODO: Replace Store + Commit with a single commit
		// TODO: How it's done depends on how mempool and prepare phases are implemented
        store.store(ledgerEntry, engineAtomIndices.getUniqueIndices(), engineAtomIndices.getDuplicateIndices());
        store.commit(committedAtom.getAID());

		final ImmutableSet<EUID> indicies = engineAtomIndices.getDuplicateIndices().stream()
			.filter(e -> e.getPrefix() == EngineAtomIndices.IndexType.DESTINATION.getValue())
			.map(e -> EngineAtomIndices.toEUID(e.asKey()))
			.collect(ImmutableSet.toImmutableSet());

		committedAtomSender.sendCommittedAtom(CommittedAtoms.success(committedAtom, indicies));
    }

    @Override
	public List<CommittedCommand> getCommittedCommands(long stateVersion, int limit) {
		ImmutableList<LedgerEntry> entries = store.getNextCommittedLedgerEntries(stateVersion, limit);
		return entries
				.stream()
				.map(LedgerEntry::getContent)
				.map(commandToBinaryConverter::toCommand)
				.collect(ImmutableList.toImmutableList());
	}

	@Override
	public void deleteAtom(AID atomId) {
		throw new UnsupportedOperationException("Delete operation is not supported by Ledger interface");
	}

	@Override
	public Spin getSpin(Particle particle) {
		if (getAtomByParticle(particle, true).isPresent()) {
			return Spin.DOWN;
		} else if (getAtomByParticle(particle, false).isPresent()) {
			return Spin.UP;
		}
		return Spin.NEUTRAL;
	}
}
