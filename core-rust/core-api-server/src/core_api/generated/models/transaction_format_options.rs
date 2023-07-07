/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */

/// TransactionFormatOptions : Requested transaction formats to include in the response



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct TransactionFormatOptions {
    /// Whether to return the raw manifest (default true)
    #[serde(rename = "manifest", skip_serializing_if = "Option::is_none")]
    pub manifest: Option<bool>,
    /// Whether to return the hex-encoded blobs (default false)
    #[serde(rename = "blobs", skip_serializing_if = "Option::is_none")]
    pub blobs: Option<bool>,
    /// Whether to return the transaction message (default false)
    #[serde(rename = "message", skip_serializing_if = "Option::is_none")]
    pub message: Option<bool>,
    /// Whether to return the raw hex-encoded system transaction bytes (default false)
    #[serde(rename = "raw_system_transaction", skip_serializing_if = "Option::is_none")]
    pub raw_system_transaction: Option<bool>,
    /// Whether to return the raw hex-encoded notarized transaction bytes (default true)
    #[serde(rename = "raw_notarized_transaction", skip_serializing_if = "Option::is_none")]
    pub raw_notarized_transaction: Option<bool>,
    /// Whether to return the raw hex-encoded ledger transaction bytes (default false)
    #[serde(rename = "raw_ledger_transaction", skip_serializing_if = "Option::is_none")]
    pub raw_ledger_transaction: Option<bool>,
}

impl TransactionFormatOptions {
    /// Requested transaction formats to include in the response
    pub fn new() -> TransactionFormatOptions {
        TransactionFormatOptions {
            manifest: None,
            blobs: None,
            message: None,
            raw_system_transaction: None,
            raw_notarized_transaction: None,
            raw_ledger_transaction: None,
        }
    }
}


