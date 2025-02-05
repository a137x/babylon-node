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
pub struct StateConsensusManagerResponse {
    #[serde(rename = "at_ledger_state")]
    pub at_ledger_state: Box<crate::core_api::generated::models::LedgerStateSummary>,
    #[serde(rename = "config")]
    pub config: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "state")]
    pub state: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "current_proposal_statistic")]
    pub current_proposal_statistic: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "current_validator_set")]
    pub current_validator_set: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "current_time")]
    pub current_time: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "current_time_rounded_to_minutes")]
    pub current_time_rounded_to_minutes: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
}

impl StateConsensusManagerResponse {
    pub fn new(at_ledger_state: crate::core_api::generated::models::LedgerStateSummary, config: crate::core_api::generated::models::Substate, state: crate::core_api::generated::models::Substate, current_proposal_statistic: crate::core_api::generated::models::Substate, current_validator_set: crate::core_api::generated::models::Substate, current_time: crate::core_api::generated::models::Substate, current_time_rounded_to_minutes: crate::core_api::generated::models::Substate) -> StateConsensusManagerResponse {
        StateConsensusManagerResponse {
            at_ledger_state: Box::new(at_ledger_state),
            config: Option::Some(config),
            state: Option::Some(state),
            current_proposal_statistic: Option::Some(current_proposal_statistic),
            current_validator_set: Option::Some(current_validator_set),
            current_time: Option::Some(current_time),
            current_time_rounded_to_minutes: Option::Some(current_time_rounded_to_minutes),
        }
    }
}


