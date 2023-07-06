/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */




#[derive(Clone, Debug, PartialEq, Default, serde::Serialize, serde::Deserialize)]
pub struct ValidatorFieldStateValue {
    #[serde(rename = "sorted_key", skip_serializing_if = "Option::is_none")]
    pub sorted_key: Option<Box<crate::core_api::generated::models::SubstateKey>>,
    #[serde(rename = "public_key")]
    pub public_key: Box<crate::core_api::generated::models::EcdsaSecp256k1PublicKey>,
    #[serde(rename = "is_registered")]
    pub is_registered: bool,
    #[serde(rename = "accepts_delegated_stake")]
    pub accepts_delegated_stake: bool,
    /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "validator_fee_factor")]
    pub validator_fee_factor: String,
    #[serde(rename = "validator_fee_change_request", skip_serializing_if = "Option::is_none")]
    pub validator_fee_change_request: Option<Box<crate::core_api::generated::models::ValidatorFeeChangeRequest>>,
    /// The Bech32m-encoded human readable version of the resource address
    #[serde(rename = "stake_unit_resource_address")]
    pub stake_unit_resource_address: String,
    #[serde(rename = "stake_xrd_vault")]
    pub stake_xrd_vault: Box<crate::core_api::generated::models::EntityReference>,
    /// The Bech32m-encoded human readable version of the resource address
    #[serde(rename = "unstake_claim_token_resource_address")]
    pub unstake_claim_token_resource_address: String,
    #[serde(rename = "pending_xrd_withdraw_vault")]
    pub pending_xrd_withdraw_vault: Box<crate::core_api::generated::models::EntityReference>,
    #[serde(rename = "locked_owner_stake_unit_vault")]
    pub locked_owner_stake_unit_vault: Box<crate::core_api::generated::models::EntityReference>,
    #[serde(rename = "pending_owner_stake_unit_unlock_vault")]
    pub pending_owner_stake_unit_unlock_vault: Box<crate::core_api::generated::models::EntityReference>,
    #[serde(rename = "pending_owner_stake_unit_withdrawals")]
    pub pending_owner_stake_unit_withdrawals: Vec<crate::core_api::generated::models::PendingOwnerStakeWithdrawal>,
    /// A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
    #[serde(rename = "already_unlocked_owner_stake_unit_amount")]
    pub already_unlocked_owner_stake_unit_amount: String,
}

impl ValidatorFieldStateValue {
    pub fn new(public_key: crate::core_api::generated::models::EcdsaSecp256k1PublicKey, is_registered: bool, accepts_delegated_stake: bool, validator_fee_factor: String, stake_unit_resource_address: String, stake_xrd_vault: crate::core_api::generated::models::EntityReference, unstake_claim_token_resource_address: String, pending_xrd_withdraw_vault: crate::core_api::generated::models::EntityReference, locked_owner_stake_unit_vault: crate::core_api::generated::models::EntityReference, pending_owner_stake_unit_unlock_vault: crate::core_api::generated::models::EntityReference, pending_owner_stake_unit_withdrawals: Vec<crate::core_api::generated::models::PendingOwnerStakeWithdrawal>, already_unlocked_owner_stake_unit_amount: String) -> ValidatorFieldStateValue {
        ValidatorFieldStateValue {
            sorted_key: None,
            public_key: Box::new(public_key),
            is_registered,
            accepts_delegated_stake,
            validator_fee_factor,
            validator_fee_change_request: None,
            stake_unit_resource_address,
            stake_xrd_vault: Box::new(stake_xrd_vault),
            unstake_claim_token_resource_address,
            pending_xrd_withdraw_vault: Box::new(pending_xrd_withdraw_vault),
            locked_owner_stake_unit_vault: Box::new(locked_owner_stake_unit_vault),
            pending_owner_stake_unit_unlock_vault: Box::new(pending_owner_stake_unit_unlock_vault),
            pending_owner_stake_unit_withdrawals,
            already_unlocked_owner_stake_unit_amount,
        }
    }
}


