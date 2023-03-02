/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct VaultLockedNonFungibleSubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    #[serde(rename = "non_fungible_ids")]
    pub non_fungible_ids: Vec<crate::core_api::generated::models::NonFungibleId>,
}

impl VaultLockedNonFungibleSubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, non_fungible_ids: Vec<crate::core_api::generated::models::NonFungibleId>) -> VaultLockedNonFungibleSubstate {
        VaultLockedNonFungibleSubstate {
            substate_type,
            non_fungible_ids,
        }
    }
}


