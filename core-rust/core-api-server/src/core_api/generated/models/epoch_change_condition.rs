/*
 * Radix Core API - Babylon
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct EpochChangeCondition {
    /// An integer between `0` and `10^10`, specifying the minimum number of rounds per epoch
    #[serde(rename = "min_round_count")]
    pub min_round_count: i64,
    /// An integer between `0` and `10^10`, specifying the maximum number of rounds per epoch
    #[serde(rename = "max_round_count")]
    pub max_round_count: i64,
    /// An integer between `0` and `10^10`, specifying the target number of milliseconds per epoch, assuming the round number is within the min and max range. 
    #[serde(rename = "target_duration_millis")]
    pub target_duration_millis: i64,
}

impl EpochChangeCondition {
    pub fn new(min_round_count: i64, max_round_count: i64, target_duration_millis: i64) -> EpochChangeCondition {
        EpochChangeCondition {
            min_round_count,
            max_round_count,
            target_duration_millis,
        }
    }
}


