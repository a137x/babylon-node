/*
 * Babylon Core API - RCnet V2
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 * Generated by: https://openapi-generator.tech
 */



#[derive(Clone, Debug, PartialEq, serde::Serialize, serde::Deserialize)]
#[serde(tag = "substate_type")]
pub enum Substate {
    #[serde(rename="AccessController")]
    AccessControllerSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="AccountVault")]
    AccountVaultSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="Clock")]
    ClockSubstate {
        #[serde(rename = "timestamp_rounded_down_to_minute")]
        timestamp_rounded_down_to_minute: Box<crate::core_api::generated::models::Instant>,
    },
    #[serde(rename="ComponentRoyaltyAccumulator")]
    ComponentRoyaltyAccumulatorSubstate {
        #[serde(rename = "vault_entity", skip_serializing_if = "Option::is_none")]
        vault_entity: Option<Box<crate::core_api::generated::models::EntityReference>>,
    },
    #[serde(rename="ComponentRoyaltyConfig")]
    ComponentRoyaltyConfigSubstate {
        #[serde(rename = "royalty_config")]
        royalty_config: Box<crate::core_api::generated::models::RoyaltyConfig>,
    },
    #[serde(rename="CurrentValidatorSet")]
    CurrentValidatorSetSubstate {
        #[serde(rename = "validator_set")]
        validator_set: Vec<crate::core_api::generated::models::ActiveValidator>,
    },
    #[serde(rename="EpochManager")]
    EpochManagerSubstate {
        /// An integer between `0` and `10^10`, marking the current epoch
        #[serde(rename = "epoch")]
        epoch: i64,
        /// An integer between `0` and `10^10`, marking the current round in an epoch
        #[serde(rename = "round")]
        round: i64,
    },
    #[serde(rename="EpochManagerConfig")]
    EpochManagerConfigSubstate {
        #[serde(rename = "max_validators")]
        max_validators: i64,
        /// An integer between `0` and `10^10`, specifying the number of rounds per epoch
        #[serde(rename = "rounds_per_epoch")]
        rounds_per_epoch: i64,
        #[serde(rename = "num_unstake_epochs")]
        num_unstake_epochs: i64,
    },
    #[serde(rename="FungibleResourceManagerDivisibility")]
    FungibleResourceManagerDivisibilitySubstate {
        #[serde(rename = "divisibility")]
        divisibility: i32,
    },
    #[serde(rename="FungibleResourceManagerTotalSupply")]
    FungibleResourceManagerTotalSupplySubstate {
        /// The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "total_supply")]
        total_supply: String,
    },
    #[serde(rename="FungibleVaultBalance")]
    FungibleVaultBalanceSubstate {
        /// The string-encoded decimal representing the token amount in the vault. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "amount")]
        amount: String,
    },
    #[serde(rename="GenericIndex")]
    GenericIndexSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="GenericKeyValueStore")]
    GenericKeyValueStoreSubstate {
        /// The hex-encoded bytes of its key
        #[serde(rename = "key_hex")]
        key_hex: String,
        #[serde(rename = "key_non_fungible_local_id", skip_serializing_if = "Option::is_none")]
        key_non_fungible_local_id: Option<Box<crate::core_api::generated::models::NonFungibleLocalId>>,
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="GenericScryptoComponentState")]
    GenericScryptoComponentStateSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="GenericSortedU16Index")]
    GenericSortedU16IndexSubstate {
        #[serde(rename = "data_struct")]
        data_struct: Box<crate::core_api::generated::models::DataStruct>,
    },
    #[serde(rename="MetadataValue")]
    MetadataValueSubstate {
        /// The hex-encoded bytes of its key
        #[serde(rename = "key_hex")]
        key_hex: String,
        #[serde(rename = "is_deleted")]
        is_deleted: bool,
        #[serde(rename = "data_struct", skip_serializing_if = "Option::is_none")]
        data_struct: Option<Box<crate::core_api::generated::models::DataStruct>>,
    },
    #[serde(rename="MethodAccessRules")]
    MethodAccessRulesSubstate {
        #[serde(rename = "access_rules")]
        access_rules: Box<crate::core_api::generated::models::AccessRules>,
        #[serde(rename = "child_blueprint_rules")]
        child_blueprint_rules: Vec<crate::core_api::generated::models::MethodAccessRulesSubstateAllOfChildBlueprintRules>,
    },
    #[serde(rename="NonFungibleResourceManagerIdType")]
    NonFungibleResourceManagerIdTypeSubstate {
        #[serde(rename = "non_fungible_id_type")]
        non_fungible_id_type: crate::core_api::generated::models::NonFungibleIdType,
    },
    #[serde(rename="NonFungibleResourceManagerMutableFields")]
    NonFungibleResourceManagerMutableFieldsSubstate {
        /// The field names of the NF Metadata which are mutable. 
        #[serde(rename = "mutable_fields")]
        mutable_fields: Vec<String>,
    },
    #[serde(rename="NonFungibleResourceManagerTotalSupply")]
    NonFungibleResourceManagerTotalSupplySubstate {
        /// The string-encoded decimal representing the total supply of this resource. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "total_supply")]
        total_supply: String,
    },
    #[serde(rename="NonFungibleVaultBalance")]
    NonFungibleVaultBalanceSubstate {
        /// The string-encoded decimal representing the token amount in the vault. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. 
        #[serde(rename = "amount")]
        amount: String,
        #[serde(rename = "ids")]
        ids: Box<crate::core_api::generated::models::EntityReference>,
    },
    #[serde(rename="PackageCode")]
    PackageCodeSubstate {
        /// The hex-encoded package code
        #[serde(rename = "code_hex")]
        code_hex: String,
    },
    #[serde(rename="PackageCodeType")]
    PackageCodeTypeSubstate {
        #[serde(rename = "code_type")]
        code_type: String,
    },
    #[serde(rename="PackageFunctionAccessRules")]
    PackageFunctionAccessRulesSubstate {
        #[serde(rename = "function_auth")]
        function_auth: Vec<crate::core_api::generated::models::PackageFunctionAccessRule>,
        #[serde(rename = "default_auth")]
        default_auth: Box<crate::core_api::generated::models::AccessRule>,
    },
    #[serde(rename="PackageInfo")]
    PackageInfoSubstate {
        #[serde(rename = "package_schema")]
        package_schema: Box<crate::core_api::generated::models::PackageSchema>,
        #[serde(rename = "dependent_resources")]
        dependent_resources: Vec<String>,
        #[serde(rename = "dependent_components")]
        dependent_components: Vec<String>,
    },
    #[serde(rename="PackageRoyalty")]
    PackageRoyaltySubstate {
        #[serde(rename = "vault_entity", skip_serializing_if = "Option::is_none")]
        vault_entity: Option<Box<crate::core_api::generated::models::EntityReference>>,
        #[serde(rename = "blueprint_royalties")]
        blueprint_royalties: Vec<crate::core_api::generated::models::BlueprintRoyaltyConfig>,
    },
    #[serde(rename="RegisteredValidators")]
    SecondaryIndexSubstate {
        #[serde(rename = "value")]
        value: Box<crate::core_api::generated::models::EntityReference>,
    },
    #[serde(rename="TypeInfo")]
    TypeInfoSubstate {
        #[serde(rename = "details")]
        details: Box<crate::core_api::generated::models::TypeInfoDetails>,
    },
    #[serde(rename="Validator")]
    ValidatorSubstate {
        #[serde(rename = "sorted_key", skip_serializing_if = "Option::is_none")]
        sorted_key: Option<Box<crate::core_api::generated::models::SortedKey>>,
        #[serde(rename = "public_key")]
        public_key: Box<crate::core_api::generated::models::EcdsaSecp256k1PublicKey>,
        #[serde(rename = "is_registered")]
        is_registered: bool,
        #[serde(rename = "stake_vault")]
        stake_vault: Box<crate::core_api::generated::models::EntityReference>,
        #[serde(rename = "unstake_vault")]
        unstake_vault: Box<crate::core_api::generated::models::EntityReference>,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "liquid_stake_unit_resource_address")]
        liquid_stake_unit_resource_address: String,
        /// The Bech32m-encoded human readable version of the resource address
        #[serde(rename = "unstake_claim_token_resource_address")]
        unstake_claim_token_resource_address: String,
    },
}




