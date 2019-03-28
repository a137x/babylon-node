package com.radix.regression.doublespend;

import com.radixdlt.client.application.RadixApplicationAPI;
import com.radixdlt.client.application.translate.Action;
import com.radixdlt.client.application.translate.ApplicationState;
import com.radixdlt.client.application.translate.ShardedAppStateId;
import com.radixdlt.client.application.translate.StatefulActionToParticleGroupsMapper;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction;
import com.radixdlt.client.application.translate.tokens.CreateTokenAction.TokenSupplyType;
import com.radixdlt.client.application.translate.tokens.TokenBalanceState;
import com.radixdlt.client.application.translate.tokens.TokenDefinitionReference;
import com.radixdlt.client.application.translate.tokens.TokenUnitConversions;
import com.radixdlt.client.atommodel.accounts.RadixAddress;
import com.radixdlt.client.atommodel.tokens.ConsumableTokens;
import com.radixdlt.client.atommodel.tokens.TransferredTokensParticle;
import com.radixdlt.client.core.atoms.ParticleGroup;
import com.radixdlt.client.core.atoms.particles.Particle;
import com.radixdlt.client.core.atoms.particles.SpunParticle;
import io.reactivex.Observable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import org.assertj.core.api.Condition;
import org.junit.Test;
import org.radix.common.tuples.Pair;
import org.radix.utils.UInt256;

public class DoubleSpendWithInterDependencyTest {
	private static class SendToSelfTwiceAction implements Action {
		private final RadixAddress self;
		private final TokenDefinitionReference tokDefRef;

		SendToSelfTwiceAction(TokenDefinitionReference tokDefRef, RadixAddress self) {
			this.tokDefRef = tokDefRef;
			this.self = self;
		}
	}

	private static class SendToSelfTwiceActionMapper implements StatefulActionToParticleGroupsMapper {
		@Override
		public Observable<ShardedAppStateId> requiredState(Action action) {
			if (!(action instanceof SendToSelfTwiceAction)) {
				return Observable.empty();
			}

			SendToSelfTwiceAction s = (SendToSelfTwiceAction) action;

			return Observable.just(ShardedAppStateId.of(TokenBalanceState.class, s.self));
		}

		@Override
		public Observable<ParticleGroup> mapToParticleGroups(Action action, Observable<Observable<? extends ApplicationState>> store) {
			if (!(action instanceof SendToSelfTwiceAction)) {
				return Observable.empty();
			}

			SendToSelfTwiceAction s = (SendToSelfTwiceAction) action;

			return store.firstOrError()
				.flatMap(Observable::firstOrError)
				.map(appState -> {
					TokenBalanceState tokenBalanceState = (TokenBalanceState) appState;
					ConsumableTokens consumable = tokenBalanceState.getBalance().get(s.tokDefRef).unconsumedTransferrable()
						.findFirst()
						.orElseThrow(IllegalStateException::new);

					final UInt256 amount = consumable.getAmount();
					final Supplier<TransferredTokensParticle> particleSupplier = () -> new TransferredTokensParticle(
						amount,
						TokenUnitConversions.unitsToSubunits(BigDecimal.ONE),
						s.self,
						System.nanoTime(),
						s.tokDefRef,
						System.currentTimeMillis() / 60000L + 60000L
					);

					TransferredTokensParticle transferredTokensParticle0 = particleSupplier.get();
					TransferredTokensParticle transferredTokensParticle1 = particleSupplier.get();

					return Arrays.asList(
						ParticleGroup.of(
							SpunParticle.down((Particle) consumable),
							SpunParticle.up(transferredTokensParticle0)
						),
						ParticleGroup.of(
							SpunParticle.down(transferredTokensParticle0),
							SpunParticle.up(transferredTokensParticle1)
						)
					);
				})
				.toObservable()
				.flatMapIterable(l -> l);
		}
	}

	private static class DoubleSpendWithInnerDependencyConditions implements DoubleSpendTestConditions {
		private final RadixAddress apiAddress;
		private final TokenDefinitionReference tokenRef;

		DoubleSpendWithInnerDependencyConditions(RadixAddress apiAddress) {
			this.tokenRef = TokenDefinitionReference.of(apiAddress,"JOSH");
			this.apiAddress = apiAddress;
		}

		@Override
		public List<Action> initialActions() {
			return Collections.singletonList(
				CreateTokenAction.create(
					apiAddress,
					"Joshy Token",
					"JOSH",
					"Cool Token",
					BigDecimal.ONE,
					BigDecimal.ONE,
					TokenSupplyType.FIXED
				)
			);
		}

		@Override
		public List<List<Action>> conflictingActions() {
			return Arrays.asList(
				Collections.singletonList(new SendToSelfTwiceAction(tokenRef, apiAddress)),
				Collections.singletonList(new SendToSelfTwiceAction(tokenRef, apiAddress))
			);
		}

		@Override
		public PostConsensusCondition postConsensusCondition() {
			Set<Pair<String, ShardedAppStateId>> stateRequired = new HashSet<>();
			stateRequired.add(Pair.of("Balance", ShardedAppStateId.of(TokenBalanceState.class, apiAddress)));

			return new PostConsensusCondition(
				stateRequired,
				new Condition<>(map -> {
					TokenBalanceState balanceState = (TokenBalanceState) map.get(ShardedAppStateId.of(TokenBalanceState.class, apiAddress));
					return balanceState.getBalance().get(tokenRef).getAmount().compareTo(BigDecimal.ONE) == 0;
				}, "1 JOSH in account")
			);
		}
	}

	@Test
	public void given_an_account__when_the_account_executes_two_send_to_self_atomic_transactions__then_the_account_balances_should_resolve_to_only_one_send_to_self_atomic_transactio() {
		DoubleSpendTestRunner testRunner = new DoubleSpendTestRunner(
			api -> new DoubleSpendWithInnerDependencyConditions(api.getMyAddress()),
			(bootstrap, identity) -> RadixApplicationAPI.defaultBuilder()
				.addStatefulParticlesMapper(new SendToSelfTwiceActionMapper())
				.bootstrap(bootstrap)
				.identity(identity)
				.build()
		);
		testRunner.execute(10);
	}
}
