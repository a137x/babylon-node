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
pub struct TransactionHeader {
    #[serde(rename = "version")]
    pub version: i32,
    #[serde(rename = "network_id")]
    pub network_id: i32,
    /// A decimal 64-bit unsigned integer.
    #[serde(rename = "start_epoch_inclusive")]
    pub start_epoch_inclusive: String,
    /// A decimal 64-bit unsigned integer.
    #[serde(rename = "end_epoch_exclusive")]
    pub end_epoch_exclusive: String,
    /// A decimal 64-bit unsigned integer.
    #[serde(rename = "nonce")]
    pub nonce: String,
    /// A hex-encoded public key of a notary.
    #[serde(rename = "notary_public_key")]
    pub notary_public_key: String,
    /// Specifies whether the notary's signature should be included in transaction signers list
    #[serde(rename = "notary_as_signatory")]
    pub notary_as_signatory: bool,
    /// Maximum number of cost units available for transaction execution. A decimal 32-bit unsigned integer.
    #[serde(rename = "cost_unit_limit")]
    pub cost_unit_limit: String,
    /// Specifies the validator tip. A decimal 32-bit unsigned integer, representing the percentage amount (a value of \"1\" corresponds to 1%).
    #[serde(rename = "tip_percentage")]
    pub tip_percentage: String,
}

impl TransactionHeader {
    pub fn new(version: i32, network_id: i32, start_epoch_inclusive: String, end_epoch_exclusive: String, nonce: String, notary_public_key: String, notary_as_signatory: bool, cost_unit_limit: String, tip_percentage: String) -> TransactionHeader {
        TransactionHeader {
            version,
            network_id,
            start_epoch_inclusive,
            end_epoch_exclusive,
            nonce,
            notary_public_key,
            notary_as_signatory,
            cost_unit_limit,
            tip_percentage,
        }
    }
}


