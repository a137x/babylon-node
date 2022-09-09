/*
 * Babylon Core API
 *
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct FungibleResourceAmount {
    #[serde(rename = "resource_type")]
    pub resource_type: crate::core_api::generated::models::ResourceType,
    /// The Bech32m-encoded human readable version of the resource address
    #[serde(rename = "resource_address")]
    pub resource_address: String,
    /// The string-encoded decimal subunits of the amount (10^-18) in a signed 256-bit integer. This is string-encoded as it doesn't fit well into common numeric types. 
    #[serde(rename = "amount_subunits")]
    pub amount_subunits: String,
}

impl FungibleResourceAmount {
    pub fn new(resource_type: crate::core_api::generated::models::ResourceType, resource_address: String, amount_subunits: String) -> FungibleResourceAmount {
        FungibleResourceAmount {
            resource_type,
            resource_address,
            amount_subunits,
        }
    }
}


