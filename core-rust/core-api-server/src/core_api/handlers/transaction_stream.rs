use crate::core_api::*;

use radix_engine::types::hash;
use scrypto::address::Bech32Encoder;
use scrypto::buffer::scrypto_decode;
use scrypto::core::NetworkDefinition;

use state_manager::jni::state_manager::ActualStateManager;
use state_manager::store::traits::*;
use state_manager::LedgerTransactionReceipt;
use std::cmp;
use std::collections::HashMap;
use transaction::manifest;
use transaction::model::NotarizedTransaction;

pub(crate) async fn handle_transaction_stream(
    state: Extension<CoreApiState>,
    request: Json<models::CommittedTransactionsRequest>,
) -> Result<Json<models::CommittedTransactionsResponse>, RequestHandlingError> {
    core_api_handler(state, request, handle_transaction_stream_internal)
}

fn handle_transaction_stream_internal(
    state_manager: &mut ActualStateManager,
    request: models::CommittedTransactionsRequest,
) -> Result<models::CommittedTransactionsResponse, RequestHandlingError> {
    assert_matching_network(&request.network, &state_manager.network)?;

    let from_state_version: u64 = extract_api_state_version(request.from_state_version)
        .map_err(|err| err.into_response_error("from_state_version"))?;

    let limit: u64 = request
        .limit
        .try_into()
        .map_err(|_| client_error("limit cannot be negative"))?;

    let state_version_at_limit: u64 = from_state_version
        .checked_add(limit)
        .and_then(|v| v.checked_sub(1))
        .ok_or_else(|| client_error("start_state_version + limit - 1 out of u64 bounds"))?;

    let max_state_version = state_manager.store.max_state_version();

    let up_to_state_version_inclusive = cmp::min(state_version_at_limit, max_state_version);

    let mut txns = vec![];
    let mut state_version = from_state_version;
    while state_version <= up_to_state_version_inclusive {
        let next_tid = state_manager.store.get_tid(state_version).ok_or_else(|| {
            server_error(&format!(
                "A transaction is missing at state version {}",
                state_version
            ))
        })?;
        let next_tx = state_manager.store.get_transaction(&next_tid);
        txns.push((next_tx, state_version));
        state_version += 1;
    }

    let network = state_manager.network.clone();

    let api_txns = txns
        .into_iter()
        .map(|((tx, receipt), state_version)| {
            let notarized_tx = if !tx.is_empty() {
                Some(scrypto_decode::<NotarizedTransaction>(&tx).map_err(|_| {
                    server_error("Internal server error: invalid committed transaction payload")
                })?)
            } else {
                // Temporary workaround for Genesis - fix later
                None
            };

            let api_tx =
                to_api_committed_transaction(&network, notarized_tx, receipt, state_version)?;

            Ok(api_tx)
        })
        .collect::<Result<Vec<models::CommittedTransaction>, RequestHandlingError>>()?;

    let start_state_version = if api_txns.is_empty() {
        0
    } else {
        from_state_version
    };

    Ok(models::CommittedTransactionsResponse {
        from_state_version: to_api_state_version(start_state_version)?,
        to_state_version: to_api_state_version(up_to_state_version_inclusive)?,
        max_state_version: to_api_state_version(max_state_version)?,
        transactions: api_txns,
    })
}

fn to_api_committed_transaction(
    network: &NetworkDefinition,
    tx: Option<NotarizedTransaction>,
    receipt: LedgerTransactionReceipt,
    state_version: u64,
) -> Result<models::CommittedTransaction, MappingError> {
    let bech32_encoder = Bech32Encoder::new(network);
    let receipt = to_api_receipt(&bech32_encoder, receipt)?;
    let api_notarized_transaction = match tx {
        Some(tx) => Some(Box::new(to_api_notarized_transaction(tx, network)?)),
        None => None,
    };

    Ok(models::CommittedTransaction {
        state_version: to_api_state_version(state_version)?,
        notarized_transaction: api_notarized_transaction,
        receipt: Box::new(receipt),
    })
}

fn to_api_notarized_transaction(
    tx: NotarizedTransaction,
    network: &NetworkDefinition,
) -> Result<models::NotarizedTransaction, MappingError> {
    let payload = tx.to_bytes();
    let payload_hash = tx.hash();
    let signed_intent = tx.signed_intent;
    let signed_intent_hash = signed_intent.hash();
    let intent = signed_intent.intent;
    let intent_hash = intent.hash();
    let header = intent.header;

    Ok(models::NotarizedTransaction {
        hash: to_hex(payload_hash),
        payload: to_hex(payload),
        signed_intent: Box::new(models::SignedTransactionIntent {
            hash: to_hex(signed_intent_hash),
            intent: Box::new(models::TransactionIntent {
                hash: to_hex(intent_hash),
                header: Box::new(models::TransactionHeader {
                    version: header.version.into(),
                    network_id: header.network_id.into(),
                    start_epoch_inclusive: to_api_epoch(header.start_epoch_inclusive)?,
                    end_epoch_exclusive: to_api_epoch(header.end_epoch_exclusive)?,
                    nonce: to_api_u64_as_string(header.nonce),
                    notary_public_key: Some(to_api_public_key(header.notary_public_key)),
                    notary_as_signatory: header.notary_as_signatory,
                    cost_unit_limit: to_api_u32_as_i64(header.cost_unit_limit),
                    tip_percentage: to_api_u32_as_i64(header.tip_percentage),
                }),
                manifest: manifest::decompile(&intent.manifest, network)
                    .expect("Failed to decompile a transaction manifest"),
                blobs: intent
                    .manifest
                    .blobs
                    .into_iter()
                    .map(|blob| (to_hex(hash(&blob)), to_hex(blob)))
                    .collect::<HashMap<String, String>>(),
            }),
            intent_signatures: signed_intent
                .intent_signatures
                .into_iter()
                .map(to_api_signature_with_public_key)
                .collect(),
        }),
        notary_signature: Some(to_api_signature(tx.notary_signature)),
    })
}
