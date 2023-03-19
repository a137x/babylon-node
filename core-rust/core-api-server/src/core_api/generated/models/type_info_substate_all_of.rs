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
pub struct TypeInfoSubstateAllOf {
    #[serde(rename = "details")]
    pub details: Option<crate::core_api::generated::models::TypeInfoDetails>, // Using Option permits Default trait; Will always be Some in normal use
}

impl TypeInfoSubstateAllOf {
    pub fn new(details: crate::core_api::generated::models::TypeInfoDetails) -> TypeInfoSubstateAllOf {
        TypeInfoSubstateAllOf {
            details: Option::Some(details),
        }
    }
}


