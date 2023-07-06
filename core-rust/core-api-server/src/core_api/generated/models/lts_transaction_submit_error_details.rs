/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "type")]
pub enum LtsTransactionSubmitErrorDetails {
    #[serde(rename="PriorityThresholdNotMet")]
    LtsTransactionSubmitPriorityThresholdNotMetErrorDetails {
        /// Tip percentage of the submitted (and rejected) transaction. 
        #[serde(rename = "tip_percentage")]
        tip_percentage: i32,
        /// A lower bound for tip percentage at current mempool state. Anything lower than this will very likely result in a mempool rejection. A missing value means there is no tip that can guarantee submission. 
        #[serde(rename = "min_tip_percentage_required", skip_serializing_if = "Option::is_none")]
        min_tip_percentage_required: Option<i32>,
    },
    #[serde(rename="Rejected")]
    LtsTransactionSubmitRejectedErrorDetails {
        /// An explanation of the error
        #[serde(rename = "error_message")]
        error_message: String,
        /// Whether (true) this rejected status has just been calculated fresh, or (false) the status is from the pending transaction result cache. 
        #[serde(rename = "is_fresh")]
        is_fresh: bool,
        /// Whether the rejection of this payload is known to be permanent. 
        #[serde(rename = "is_payload_rejection_permanent")]
        is_payload_rejection_permanent: bool,
        /// Whether the rejection of this intent is known to be permanent - this is a stronger statement than the payload rejection being permanent, as it implies any payloads containing the intent will also be permanently rejected. 
        #[serde(rename = "is_intent_rejection_permanent")]
        is_intent_rejection_permanent: bool,
        /// Whether the cached rejection of this intent is due to the intent already having been committed. If so, see the /transaction/receipt endpoint for further information. 
        #[serde(rename = "is_rejected_because_intent_already_committed")]
        is_rejected_because_intent_already_committed: bool,
        #[serde(rename = "retry_from_timestamp", skip_serializing_if = "Option::is_none")]
        retry_from_timestamp: Option<Box<crate::core_api::generated::models::Instant>>,
        /// An integer between `0` and `10^10`, marking the epoch after which the node will consider recalculating the validity of the transaction. Only present if the rejection is temporary due to a header specifying a \"from epoch\" in the future. 
        #[serde(rename = "retry_from_epoch", skip_serializing_if = "Option::is_none")]
        retry_from_epoch: Option<i64>,
        /// An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be permanently rejected. Only present if the rejection isn't permanent. 
        #[serde(rename = "invalid_from_epoch", skip_serializing_if = "Option::is_none")]
        invalid_from_epoch: Option<i64>,
    },
}




