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
pub struct ResourceChange {
    /// The Bech32m-encoded human readable version of the resource address
    #[serde(rename = "resource_address")]
    pub resource_address: String,
    /// The Bech32m-encoded human readable version of the component address
    #[serde(rename = "component_address")]
    pub component_address: String,
    /// The hex-encoded, SBOR-encoded Vault ID
    #[serde(rename = "vault_id")]
    pub vault_id: String,
    /// The XRD amount put or taken from the vault. A fixed-scale 256-bit signed decimal number.
    #[serde(rename = "amount")]
    pub amount: String,
}

impl ResourceChange {
    pub fn new(resource_address: String, component_address: String, vault_id: String, amount: String) -> ResourceChange {
        ResourceChange {
            resource_address,
            component_address,
            vault_id,
            amount,
        }
    }
}


