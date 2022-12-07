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

package com.radixdlt.rev2;

import com.google.common.collect.ImmutableClassToInstanceMap;
import com.radixdlt.consensus.bft.BFTNode;
import com.radixdlt.consensus.bft.VertexStoreState;
import com.radixdlt.environment.EventDispatcher;
import com.radixdlt.lang.Option;
import com.radixdlt.ledger.CommittedTransactionsWithProof;
import com.radixdlt.ledger.LedgerUpdate;
import com.radixdlt.ledger.StateComputerLedger;
import com.radixdlt.mempool.*;
import com.radixdlt.rev1.RoundDetails;
import com.radixdlt.serialization.DsonOutput;
import com.radixdlt.serialization.Serialization;
import com.radixdlt.statecomputer.RustStateComputer;
import com.radixdlt.statecomputer.commit.CommitRequest;
import com.radixdlt.statecomputer.commit.PrepareRequest;
import com.radixdlt.transaction.TransactionBuilder;
import com.radixdlt.transactions.RawLedgerTransaction;
import com.radixdlt.transactions.RawNotarizedTransaction;
import com.radixdlt.utils.UInt64;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** REv2 State Computer implementation */
public final class REv2StateComputer implements StateComputerLedger.StateComputer {
  private static final Logger log = LogManager.getLogger();

  private final RustStateComputer stateComputer;
  private final int transactionsPerProposalCount;
  private final EventDispatcher<LedgerUpdate> ledgerUpdateEventDispatcher;
  private final Serialization serialization;

  public REv2StateComputer(
      RustStateComputer stateComputer,
      int transactionsPerProposalCount,
      EventDispatcher<LedgerUpdate> ledgerUpdateEventDispatcher,
      Serialization serialization) {
    this.stateComputer = stateComputer;
    this.transactionsPerProposalCount = transactionsPerProposalCount;
    this.ledgerUpdateEventDispatcher = ledgerUpdateEventDispatcher;
    this.serialization = serialization;
  }

  @Override
  public void addToMempool(MempoolAdd mempoolAdd, BFTNode origin) {
    mempoolAdd
        .transactions()
        .forEach(
            transaction -> {
              try {
                stateComputer.getMempoolInserter().addTransaction(transaction);
              } catch (MempoolFullException ignored) {
              } catch (MempoolRejectedException e) {
                log.error(e);
              }
            });
  }

  @Override
  public List<RawNotarizedTransaction> getTransactionsForProposal(
      List<StateComputerLedger.ExecutedTransaction> executedTransactions) {
    if (transactionsPerProposalCount == 0) {
      return List.of();
    }

    var transactionsNotToInclude =
        executedTransactions.stream()
            .flatMap(
                executedTx ->
                    TransactionBuilder.convertTransactionBytesToNotarizedTransactionBytes(
                            executedTx.transaction().getPayload())
                        .stream()
                        .map(RawNotarizedTransaction::create))
            .toList();
    return stateComputer.getTransactionsForProposal(
        transactionsPerProposalCount, transactionsNotToInclude);
  }

  @Override
  public StateComputerLedger.StateComputerResult prepare(
      List<StateComputerLedger.ExecutedTransaction> previous,
      List<RawNotarizedTransaction> proposedTransactions,
      RoundDetails roundDetails) {
    var previousTransactions =
        previous.stream()
            .map(StateComputerLedger.ExecutedTransaction::transaction)
            .collect(Collectors.toList());
    var prepareRequest =
        new PrepareRequest(
            previousTransactions,
            proposedTransactions,
            UInt64.fromNonNegativeLong(roundDetails.epoch()),
            UInt64.fromNonNegativeLong(roundDetails.roundNumber()),
            UInt64.fromNonNegativeLong(roundDetails.proposerTimestampMs()));

    var result = stateComputer.prepare(prepareRequest);
    var committableTransactions =
        result.committed().stream()
            .map(RawLedgerTransaction::create)
            .map(REv2ExecutedTransaction::new)
            .map(StateComputerLedger.ExecutedTransaction.class::cast)
            .collect(Collectors.toList());
    var rejectedTransactions =
        result.rejected().stream()
            .collect(
                Collectors.toMap(
                    r -> RawLedgerTransaction.create(r.first()),
                    r -> (Exception) new InvalidREv2Transaction(r.last())));

    return new StateComputerLedger.StateComputerResult(
        committableTransactions, rejectedTransactions);
  }

  @Override
  public void commit(
      CommittedTransactionsWithProof txnsAndProof, VertexStoreState vertexStoreState) {
    var proofBytes = serialization.toDson(txnsAndProof.getProof(), DsonOutput.Output.ALL);
    final Option<byte[]> vertexStoreBytes;
    if (vertexStoreState != null) {
      vertexStoreBytes =
          Option.some(serialization.toDson(vertexStoreState.toSerialized(), DsonOutput.Output.ALL));
    } else {
      vertexStoreBytes = Option.none();
    }

    var stateVersion = UInt64.fromNonNegativeLong(txnsAndProof.getProof().getStateVersion());
    var commitRequest =
        new CommitRequest(
            txnsAndProof.getTransactions(), stateVersion, proofBytes, vertexStoreBytes);

    stateComputer.commit(commitRequest);

    var ledgerUpdate = new LedgerUpdate(txnsAndProof, ImmutableClassToInstanceMap.of());
    ledgerUpdateEventDispatcher.dispatch(ledgerUpdate);
  }
}
