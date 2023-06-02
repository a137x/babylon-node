/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NotarizedTransaction {
    /// The hex-encoded notarized transaction hash for a user transaction. This hash identifies the full submittable notarized transaction - ie the signed intent, plus the notary signature. 
    #[serde(rename = "hash")]
    pub hash: String,
    /// The hex-encoded full notarized transaction payload. Returning this can be disabled in TransactionFormatOptions on your request (default true).
    #[serde(rename = "payload_hex", skip_serializing_if = "Option::is_none")]
    pub payload_hex: Option<String>,
    #[serde(rename = "signed_intent")]
    pub signed_intent: Box<crate::core_api::generated::models::SignedTransactionIntent>,
    #[serde(rename = "notary_signature")]
    pub notary_signature: Option<crate::core_api::generated::models::Signature>, // Using Option permits Default trait; Will always be Some in normal use
}

impl NotarizedTransaction {
    pub fn new(hash: String, signed_intent: crate::core_api::generated::models::SignedTransactionIntent, notary_signature: crate::core_api::generated::models::Signature) -> NotarizedTransaction {
        NotarizedTransaction {
            hash,
            payload_hex: None,
            signed_intent: Box::new(signed_intent),
            notary_signature: Option::Some(notary_signature),
        }
    }
}


