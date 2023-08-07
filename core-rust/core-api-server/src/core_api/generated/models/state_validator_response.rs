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
pub struct StateValidatorResponse {
    #[serde(rename = "at_ledger_state")]
    pub at_ledger_state: Box<crate::core_api::generated::models::LedgerStateSummary>,
    /// The Bech32m-encoded human readable version of the component address
    #[serde(rename = "address")]
    pub address: String,
    #[serde(rename = "state")]
    pub state: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    #[serde(rename = "owner_role")]
    pub owner_role: Option<crate::core_api::generated::models::Substate>, // Using Option permits Default trait; Will always be Some in normal use
    /// Any vaults owned directly or indirectly by the component
    #[serde(rename = "vaults")]
    pub vaults: Vec<crate::core_api::generated::models::VaultBalance>,
    /// Any descendent nodes owned directly or indirectly by the component
    #[serde(rename = "descendent_nodes")]
    pub descendent_nodes: Vec<crate::core_api::generated::models::StateComponentDescendentNode>,
}

impl StateValidatorResponse {
    pub fn new(at_ledger_state: crate::core_api::generated::models::LedgerStateSummary, address: String, state: crate::core_api::generated::models::Substate, owner_role: crate::core_api::generated::models::Substate, vaults: Vec<crate::core_api::generated::models::VaultBalance>, descendent_nodes: Vec<crate::core_api::generated::models::StateComponentDescendentNode>) -> StateValidatorResponse {
        StateValidatorResponse {
            at_ledger_state: Box::new(at_ledger_state),
            address,
            state: Option::Some(state),
            owner_role: Option::Some(owner_role),
            vaults,
            descendent_nodes,
        }
    }
}


