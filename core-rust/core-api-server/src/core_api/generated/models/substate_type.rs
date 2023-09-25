/*
 * Radix Core API - Babylon
 *
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.0
 * 
 * Generated by: https://openapi-generator.tech
 */


/// 
#[derive(Clone, Copy, Debug, Eq, PartialEq, Ord, PartialOrd, Hash, serde::Serialize, serde::Deserialize)]
pub enum SubstateType {
    #[serde(rename = "TypeInfoModuleFieldTypeInfo")]
    TypeInfoModuleFieldTypeInfo,
    #[serde(rename = "RoleAssignmentModuleFieldOwnerRole")]
    RoleAssignmentModuleFieldOwnerRole,
    #[serde(rename = "RoleAssignmentModuleRuleEntry")]
    RoleAssignmentModuleRuleEntry,
    #[serde(rename = "RoleAssignmentModuleMutabilityEntry")]
    RoleAssignmentModuleMutabilityEntry,
    #[serde(rename = "RoyaltyModuleFieldState")]
    RoyaltyModuleFieldState,
    #[serde(rename = "RoyaltyModuleMethodRoyaltyEntry")]
    RoyaltyModuleMethodRoyaltyEntry,
    #[serde(rename = "MetadataModuleEntry")]
    MetadataModuleEntry,
    #[serde(rename = "PackageFieldRoyaltyAccumulator")]
    PackageFieldRoyaltyAccumulator,
    #[serde(rename = "PackageCodeVmTypeEntry")]
    PackageCodeVmTypeEntry,
    #[serde(rename = "PackageCodeOriginalCodeEntry")]
    PackageCodeOriginalCodeEntry,
    #[serde(rename = "PackageCodeInstrumentedCodeEntry")]
    PackageCodeInstrumentedCodeEntry,
    #[serde(rename = "SchemaEntry")]
    SchemaEntry,
    #[serde(rename = "PackageBlueprintDefinitionEntry")]
    PackageBlueprintDefinitionEntry,
    #[serde(rename = "PackageBlueprintDependenciesEntry")]
    PackageBlueprintDependenciesEntry,
    #[serde(rename = "PackageBlueprintRoyaltyEntry")]
    PackageBlueprintRoyaltyEntry,
    #[serde(rename = "PackageBlueprintAuthTemplateEntry")]
    PackageBlueprintAuthTemplateEntry,
    #[serde(rename = "PackageFieldFunctionAccessRules")]
    PackageFieldFunctionAccessRules,
    #[serde(rename = "FungibleResourceManagerFieldDivisibility")]
    FungibleResourceManagerFieldDivisibility,
    #[serde(rename = "FungibleResourceManagerFieldTotalSupply")]
    FungibleResourceManagerFieldTotalSupply,
    #[serde(rename = "NonFungibleResourceManagerFieldIdType")]
    NonFungibleResourceManagerFieldIdType,
    #[serde(rename = "NonFungibleResourceManagerFieldTotalSupply")]
    NonFungibleResourceManagerFieldTotalSupply,
    #[serde(rename = "NonFungibleResourceManagerFieldMutableFields")]
    NonFungibleResourceManagerFieldMutableFields,
    #[serde(rename = "NonFungibleResourceManagerDataEntry")]
    NonFungibleResourceManagerDataEntry,
    #[serde(rename = "FungibleVaultFieldBalance")]
    FungibleVaultFieldBalance,
    #[serde(rename = "FungibleVaultFieldFrozenStatus")]
    FungibleVaultFieldFrozenStatus,
    #[serde(rename = "NonFungibleVaultFieldBalance")]
    NonFungibleVaultFieldBalance,
    #[serde(rename = "NonFungibleVaultFieldFrozenStatus")]
    NonFungibleVaultFieldFrozenStatus,
    #[serde(rename = "NonFungibleVaultContentsIndexEntry")]
    NonFungibleVaultContentsIndexEntry,
    #[serde(rename = "ConsensusManagerFieldConfig")]
    ConsensusManagerFieldConfig,
    #[serde(rename = "ConsensusManagerFieldState")]
    ConsensusManagerFieldState,
    #[serde(rename = "ConsensusManagerFieldCurrentValidatorSet")]
    ConsensusManagerFieldCurrentValidatorSet,
    #[serde(rename = "ConsensusManagerFieldCurrentProposalStatistic")]
    ConsensusManagerFieldCurrentProposalStatistic,
    #[serde(rename = "ConsensusManagerFieldCurrentTimeRoundedToMinutes")]
    ConsensusManagerFieldCurrentTimeRoundedToMinutes,
    #[serde(rename = "ConsensusManagerFieldCurrentTime")]
    ConsensusManagerFieldCurrentTime,
    #[serde(rename = "ConsensusManagerFieldValidatorRewards")]
    ConsensusManagerFieldValidatorRewards,
    #[serde(rename = "ConsensusManagerRegisteredValidatorsByStakeIndexEntry")]
    ConsensusManagerRegisteredValidatorsByStakeIndexEntry,
    #[serde(rename = "ValidatorFieldState")]
    ValidatorFieldState,
    #[serde(rename = "ValidatorFieldProtocolUpdateReadinessSignal")]
    ValidatorFieldProtocolUpdateReadinessSignal,
    #[serde(rename = "AccountFieldState")]
    AccountFieldState,
    #[serde(rename = "AccountVaultEntry")]
    AccountVaultEntry,
    #[serde(rename = "AccountResourcePreferenceEntry")]
    AccountResourcePreferenceEntry,
    #[serde(rename = "AccountAuthorizedDepositorEntry")]
    AccountAuthorizedDepositorEntry,
    #[serde(rename = "AccessControllerFieldState")]
    AccessControllerFieldState,
    #[serde(rename = "GenericScryptoComponentFieldState")]
    GenericScryptoComponentFieldState,
    #[serde(rename = "GenericKeyValueStoreEntry")]
    GenericKeyValueStoreEntry,
    #[serde(rename = "OneResourcePoolFieldState")]
    OneResourcePoolFieldState,
    #[serde(rename = "TwoResourcePoolFieldState")]
    TwoResourcePoolFieldState,
    #[serde(rename = "MultiResourcePoolFieldState")]
    MultiResourcePoolFieldState,
    #[serde(rename = "TransactionTrackerFieldState")]
    TransactionTrackerFieldState,
    #[serde(rename = "TransactionTrackerCollectionEntry")]
    TransactionTrackerCollectionEntry,

}

impl ToString for SubstateType {
    fn to_string(&self) -> String {
        match self {
            Self::TypeInfoModuleFieldTypeInfo => String::from("TypeInfoModuleFieldTypeInfo"),
            Self::RoleAssignmentModuleFieldOwnerRole => String::from("RoleAssignmentModuleFieldOwnerRole"),
            Self::RoleAssignmentModuleRuleEntry => String::from("RoleAssignmentModuleRuleEntry"),
            Self::RoleAssignmentModuleMutabilityEntry => String::from("RoleAssignmentModuleMutabilityEntry"),
            Self::RoyaltyModuleFieldState => String::from("RoyaltyModuleFieldState"),
            Self::RoyaltyModuleMethodRoyaltyEntry => String::from("RoyaltyModuleMethodRoyaltyEntry"),
            Self::MetadataModuleEntry => String::from("MetadataModuleEntry"),
            Self::PackageFieldRoyaltyAccumulator => String::from("PackageFieldRoyaltyAccumulator"),
            Self::PackageCodeVmTypeEntry => String::from("PackageCodeVmTypeEntry"),
            Self::PackageCodeOriginalCodeEntry => String::from("PackageCodeOriginalCodeEntry"),
            Self::PackageCodeInstrumentedCodeEntry => String::from("PackageCodeInstrumentedCodeEntry"),
            Self::SchemaEntry => String::from("SchemaEntry"),
            Self::PackageBlueprintDefinitionEntry => String::from("PackageBlueprintDefinitionEntry"),
            Self::PackageBlueprintDependenciesEntry => String::from("PackageBlueprintDependenciesEntry"),
            Self::PackageBlueprintRoyaltyEntry => String::from("PackageBlueprintRoyaltyEntry"),
            Self::PackageBlueprintAuthTemplateEntry => String::from("PackageBlueprintAuthTemplateEntry"),
            Self::PackageFieldFunctionAccessRules => String::from("PackageFieldFunctionAccessRules"),
            Self::FungibleResourceManagerFieldDivisibility => String::from("FungibleResourceManagerFieldDivisibility"),
            Self::FungibleResourceManagerFieldTotalSupply => String::from("FungibleResourceManagerFieldTotalSupply"),
            Self::NonFungibleResourceManagerFieldIdType => String::from("NonFungibleResourceManagerFieldIdType"),
            Self::NonFungibleResourceManagerFieldTotalSupply => String::from("NonFungibleResourceManagerFieldTotalSupply"),
            Self::NonFungibleResourceManagerFieldMutableFields => String::from("NonFungibleResourceManagerFieldMutableFields"),
            Self::NonFungibleResourceManagerDataEntry => String::from("NonFungibleResourceManagerDataEntry"),
            Self::FungibleVaultFieldBalance => String::from("FungibleVaultFieldBalance"),
            Self::FungibleVaultFieldFrozenStatus => String::from("FungibleVaultFieldFrozenStatus"),
            Self::NonFungibleVaultFieldBalance => String::from("NonFungibleVaultFieldBalance"),
            Self::NonFungibleVaultFieldFrozenStatus => String::from("NonFungibleVaultFieldFrozenStatus"),
            Self::NonFungibleVaultContentsIndexEntry => String::from("NonFungibleVaultContentsIndexEntry"),
            Self::ConsensusManagerFieldConfig => String::from("ConsensusManagerFieldConfig"),
            Self::ConsensusManagerFieldState => String::from("ConsensusManagerFieldState"),
            Self::ConsensusManagerFieldCurrentValidatorSet => String::from("ConsensusManagerFieldCurrentValidatorSet"),
            Self::ConsensusManagerFieldCurrentProposalStatistic => String::from("ConsensusManagerFieldCurrentProposalStatistic"),
            Self::ConsensusManagerFieldCurrentTimeRoundedToMinutes => String::from("ConsensusManagerFieldCurrentTimeRoundedToMinutes"),
            Self::ConsensusManagerFieldCurrentTime => String::from("ConsensusManagerFieldCurrentTime"),
            Self::ConsensusManagerFieldValidatorRewards => String::from("ConsensusManagerFieldValidatorRewards"),
            Self::ConsensusManagerRegisteredValidatorsByStakeIndexEntry => String::from("ConsensusManagerRegisteredValidatorsByStakeIndexEntry"),
            Self::ValidatorFieldState => String::from("ValidatorFieldState"),
            Self::ValidatorFieldProtocolUpdateReadinessSignal => String::from("ValidatorFieldProtocolUpdateReadinessSignal"),
            Self::AccountFieldState => String::from("AccountFieldState"),
            Self::AccountVaultEntry => String::from("AccountVaultEntry"),
            Self::AccountResourcePreferenceEntry => String::from("AccountResourcePreferenceEntry"),
            Self::AccountAuthorizedDepositorEntry => String::from("AccountAuthorizedDepositorEntry"),
            Self::AccessControllerFieldState => String::from("AccessControllerFieldState"),
            Self::GenericScryptoComponentFieldState => String::from("GenericScryptoComponentFieldState"),
            Self::GenericKeyValueStoreEntry => String::from("GenericKeyValueStoreEntry"),
            Self::OneResourcePoolFieldState => String::from("OneResourcePoolFieldState"),
            Self::TwoResourcePoolFieldState => String::from("TwoResourcePoolFieldState"),
            Self::MultiResourcePoolFieldState => String::from("MultiResourcePoolFieldState"),
            Self::TransactionTrackerFieldState => String::from("TransactionTrackerFieldState"),
            Self::TransactionTrackerCollectionEntry => String::from("TransactionTrackerCollectionEntry"),
        }
    }
}

impl Default for SubstateType {
    fn default() -> SubstateType {
        Self::TypeInfoModuleFieldTypeInfo
    }
}




