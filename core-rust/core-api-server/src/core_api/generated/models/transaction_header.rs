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
pub struct TransactionHeader {
    /// The logical id of the network
    #[serde(rename = "network_id")]
    pub network_id: i32,
    /// An integer between `0` and `10^10`, marking the epoch from which the transaction can be submitted. In the case of uncommitted transactions, a value of `10^10` indicates that the epoch was >= `10^10`. 
    #[serde(rename = "start_epoch_inclusive")]
    pub start_epoch_inclusive: i64,
    /// An integer between `0` and `10^10`, marking the epoch from which the transaction will no longer be valid, and be rejected. In the case of uncommitted transactions, a value of `10^10` indicates that the epoch was >= `10^10`. 
    #[serde(rename = "end_epoch_exclusive")]
    pub end_epoch_exclusive: i64,
    /// An integer between `0` and `2^32 - 1`, chosen to allow a unique intent to be created (to enable submitting an otherwise identical/duplicate intent). 
    #[serde(rename = "nonce")]
    pub nonce: i64,
    #[serde(rename = "notary_public_key")]
    pub notary_public_key: Option<crate::core_api::generated::models::PublicKey>, // Using Option permits Default trait; Will always be Some in normal use
    /// Specifies whether the notary public key should be included in the transaction signers list
    #[serde(rename = "notary_is_signatory")]
    pub notary_is_signatory: bool,
    /// An integer between `0` and `65535`, giving the validator tip as a percentage amount. A value of `1` corresponds to 1% of the fee.
    #[serde(rename = "tip_percentage")]
    pub tip_percentage: i32,
}

impl TransactionHeader {
    pub fn new(network_id: i32, start_epoch_inclusive: i64, end_epoch_exclusive: i64, nonce: i64, notary_public_key: crate::core_api::generated::models::PublicKey, notary_is_signatory: bool, tip_percentage: i32) -> TransactionHeader {
        TransactionHeader {
            network_id,
            start_epoch_inclusive,
            end_epoch_exclusive,
            nonce,
            notary_public_key: Option::Some(notary_public_key),
            notary_is_signatory,
            tip_percentage,
        }
    }
}


