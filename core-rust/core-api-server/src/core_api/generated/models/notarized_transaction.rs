/*
 * Babylon Core API
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct NotarizedTransaction {
    /// The hex-encoded notarized transaction hash. This is known as the Notarized Transaction Hash, Payload Hash or User Payload Hash. This hash is `SHA256(SHA256(compiled_notarized_transaction))`
    #[serde(rename = "hash")]
    pub hash: String,
    /// The hex-encoded full notarized transaction payload
    #[serde(rename = "payload_hex")]
    pub payload_hex: String,
    #[serde(rename = "signed_intent")]
    pub signed_intent: Box<crate::core_api::generated::models::SignedTransactionIntent>,
    #[serde(rename = "notary_signature")]
    pub notary_signature: Option<crate::core_api::generated::models::Signature>, // Using Option permits Default trait; Will always be Some in normal use
}

impl NotarizedTransaction {
    pub fn new(hash: String, payload_hex: String, signed_intent: crate::core_api::generated::models::SignedTransactionIntent, notary_signature: crate::core_api::generated::models::Signature) -> NotarizedTransaction {
        NotarizedTransaction {
            hash,
            payload_hex,
            signed_intent: Box::new(signed_intent),
            notary_signature: Option::Some(notary_signature),
        }
    }
}


