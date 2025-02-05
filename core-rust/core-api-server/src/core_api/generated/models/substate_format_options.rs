/*
 * Radix Core API - Babylon
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
 * 
 * Generated by: https://openapi-generator.tech
 */

/// SubstateFormatOptions : Requested substate formats to include in the response



#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct SubstateFormatOptions {
    /// Whether to return the raw substate value bytes (default false)
    #[serde(rename = "raw", skip_serializing_if = "Option::is_none")]
    pub raw: Option<bool>,
    /// Whether to return the raw substate value bytes hash (default false)
    #[serde(rename = "hash", skip_serializing_if = "Option::is_none")]
    pub hash: Option<bool>,
    /// Whether to return the typed substate information (default true)
    #[serde(rename = "typed", skip_serializing_if = "Option::is_none")]
    pub typed: Option<bool>,
    /// Whether to return the previous substate value for updates and deletes (default false)
    #[serde(rename = "previous", skip_serializing_if = "Option::is_none")]
    pub previous: Option<bool>,
}

impl SubstateFormatOptions {
    /// Requested substate formats to include in the response
    pub fn new() -> SubstateFormatOptions {
        SubstateFormatOptions {
            raw: None,
            hash: None,
            typed: None,
            previous: None,
        }
    }
}


