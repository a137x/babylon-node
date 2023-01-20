/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ComponentRoyaltyConfigSubstate {
    #[serde(rename = "substate_type")]
    pub substate_type: crate::core_api::generated::models::SubstateType,
    #[serde(rename = "royalty_config")]
    pub royalty_config: Box<crate::core_api::generated::models::RoyaltyConfig>,
}

impl ComponentRoyaltyConfigSubstate {
    pub fn new(substate_type: crate::core_api::generated::models::SubstateType, royalty_config: crate::core_api::generated::models::RoyaltyConfig) -> ComponentRoyaltyConfigSubstate {
        ComponentRoyaltyConfigSubstate {
            substate_type,
            royalty_config: Box::new(royalty_config),
        }
    }
}


