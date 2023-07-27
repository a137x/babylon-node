/*
 * Babylon Core API - RCnet v3
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct TransactionCallPreviewRequest {
    /// The logical name of the network
    #[serde(rename = "network")]
    pub network: String,
    #[serde(rename = "target")]
    pub target: Option<crate::core_api::generated::models::TargetIdentifier>, // Using Option permits Default trait; Will always be Some in normal use
    /// Argument list
    #[serde(rename = "arguments")]
    pub arguments: Vec<String>,
}

impl TransactionCallPreviewRequest {
    pub fn new(network: String, target: crate::core_api::generated::models::TargetIdentifier, arguments: Vec<String>) -> TransactionCallPreviewRequest {
        TransactionCallPreviewRequest {
            network,
            target: Option::Some(target),
            arguments,
        }
    }
}


