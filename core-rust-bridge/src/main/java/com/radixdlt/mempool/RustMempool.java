/* Copyright 2021 Radix Publishing Ltd incorporated in Jersey (Channel Islands).
 *
 * Licensed under the Radix License, Version 1.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at:
 *
 * radixfoundation.org/licenses/LICENSE-v1
 *
 * The Licensor hereby grants permission for the Canonical version of the Work to be
 * published, distributed and used under or by reference to the Licensor’s trademark
 * Radix ® and use of any unregistered trade names, logos or get-up.
 *
 * The Licensor provides the Work (and each Contributor provides its Contributions) on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT,
 * MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Whilst the Work is capable of being deployed, used and adopted (instantiated) to create
 * a distributed ledger it is your responsibility to test and validate the code, together
 * with all logic and performance of that code under all foreseeable scenarios.
 *
 * The Licensor does not make or purport to make and hereby excludes liability for all
 * and any representation, warranty or undertaking in any form whatsoever, whether express
 * or implied, to any entity or person, including any representation, warranty or
 * undertaking, as to the functionality security use, value or other characteristics of
 * any distributed ledger nor in respect the functioning or value of any tokens which may
 * be created stored or transferred using the Work. The Licensor does not warrant that the
 * Work or any use of the Work complies with any law or regulation in any territory where
 * it may be implemented or used or that it will be appropriate for any specific purpose.
 *
 * Neither the licensor nor any current or former employees, officers, directors, partners,
 * trustees, representatives, agents, advisors, contractors, or volunteers of the Licensor
 * shall be liable for any direct or indirect, special, incidental, consequential or other
 * losses of any kind, in tort, contract or otherwise (including but not limited to loss
 * of revenue, income or profits, or loss of use or data, or loss of reputation, or loss
 * of any economic or other opportunity of whatsoever nature or howsoever arising), arising
 * out of or in connection with (without limitation of any use, misuse, of any ledger system
 * or use made or its functionality or any performance or operation of any code or protocol
 * caused by bugs or programming or logic errors or otherwise);
 *
 * A. any offer, purchase, holding, use, sale, exchange or transmission of any
 * cryptographic keys, tokens or assets created, exchanged, stored or arising from any
 * interaction with the Work;
 *
 * B. any failure in a transmission or loss of any token or assets keys or other digital
 * artefacts due to errors in transmission;
 *
 * C. bugs, hacks, logic errors or faults in the Work or any communication;
 *
 * D. system software or apparatus including but not limited to losses caused by errors
 * in holding or transmitting tokens by any third-party;
 *
 * E. breaches or failure of security including hacker attacks, loss or disclosure of
 * password, loss of private key, unauthorised use or misuse of such passwords or keys;
 *
 * F. any losses including loss of anticipated savings or other benefits resulting from
 * use of the Work or any changes to the Work (however implemented).
 *
 * You are solely responsible for; testing, validating and evaluation of all operation
 * logic, functionality, security and appropriateness of using the Work for any commercial
 * or non-commercial purpose and for any reproduction or redistribution by You of the
 * Work. You assume all risks associated with Your use of the Work and the exercise of
 * permissions under this License.
 */

package com.radixdlt.mempool;

import static com.radixdlt.lang.Tuple.tuple;

import com.google.common.hash.HashCode;
import com.google.common.reflect.TypeToken;
import com.radixdlt.lang.Result;
import com.radixdlt.lang.Tuple;
import com.radixdlt.lang.Unit;
import com.radixdlt.sbor.NativeCalls;
import com.radixdlt.statemanager.StateManager;
import com.radixdlt.transactions.RawNotarizedTransaction;
import com.radixdlt.utils.UInt32;
import java.util.List;
import java.util.Objects;

public class RustMempool implements MempoolReader<RawNotarizedTransaction> {

  public RustMempool(StateManager stateManager) {
    Objects.requireNonNull(stateManager);
    addFunc =
        NativeCalls.Func1.with(
            stateManager, new TypeToken<>() {}, new TypeToken<>() {}, RustMempool::add);
    getTransactionsForProposalFunc =
        NativeCalls.Func1.with(
            stateManager,
            new TypeToken<>() {},
            new TypeToken<>() {},
            RustMempool::getTransactionsForProposal);
    getTransactionsToRelayFunc =
        NativeCalls.Func1.with(
            stateManager,
            new TypeToken<>() {},
            new TypeToken<>() {},
            RustMempool::getTransactionsToRelay);
    getCountFunc =
        NativeCalls.Func1.with(
            stateManager, new TypeToken<>() {}, new TypeToken<>() {}, RustMempool::getCount);
  }

  public RawNotarizedTransaction addTransaction(RawNotarizedTransaction transaction)
      throws MempoolRejectedException {
    var result = addFunc.call(transaction);

    // Handle Errors.
    if (result.isError()) {
      switch (result.unwrapError()) {
        case MempoolError.Full fullStatus -> throw new MempoolFullException(
            fullStatus.currentSize().toNonNegativeLong().unwrap(),
            fullStatus.maxSize().toNonNegativeLong().unwrap());
        case MempoolError.Duplicate ignored -> throw new MempoolDuplicateException(
            String.format("Mempool already has transaction %s", transaction.getPayloadHash()));
        case MempoolError.TransactionValidationError e -> throw new MempoolRejectedException(
            e.errorDescription());
        case MempoolError.Rejected rejected -> throw new MempoolRejectedException(
            rejected.reason());
      }
    }

    return transaction;
  }

  public List<RawNotarizedTransaction> getTransactionsForProposal(
      int count, List<RawNotarizedTransaction> preparedTransactions) {
    if (count <= 0) {
      throw new IllegalArgumentException("State Manager Mempool: count must be > 0: " + count);
    }

    final var hashes =
        preparedTransactions.stream().map(RawNotarizedTransaction::getPayloadHash).toList();

    return getTransactionsForProposalFunc.call(tuple(UInt32.fromNonNegativeInt(count), hashes));
  }

  @Override
  public List<RawNotarizedTransaction> getTransactionsToRelay() {
    return getTransactionsToRelayFunc.call(Unit.unit());
  }

  @Override
  public int getCount() {
    return getCountFunc.call(Unit.unit());
  }

  private static native byte[] add(StateManager stateManager, byte[] payload);

  private final NativeCalls.Func1<
          StateManager, RawNotarizedTransaction, Result<HashCode, MempoolError>>
      addFunc;

  private static native byte[] getTransactionsForProposal(
      StateManager stateManager, byte[] payload);

  private final NativeCalls.Func1<
          StateManager, Tuple.Tuple2<UInt32, List<HashCode>>, List<RawNotarizedTransaction>>
      getTransactionsForProposalFunc;

  private static native byte[] getTransactionsToRelay(StateManager stateManager, byte[] payload);

  private final NativeCalls.Func1<StateManager, Unit, List<RawNotarizedTransaction>>
      getTransactionsToRelayFunc;

  private static native byte[] getCount(Object stateManager, byte[] payload);

  private final NativeCalls.Func1<StateManager, Unit, Integer> getCountFunc;
}
