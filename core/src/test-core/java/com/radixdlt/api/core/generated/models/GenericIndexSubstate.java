/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.core.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AccessControllerSubstate;
import com.radixdlt.api.core.generated.models.AccountVaultSubstate;
import com.radixdlt.api.core.generated.models.AccountVaultSubstateAllOf;
import com.radixdlt.api.core.generated.models.ClockSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.CurrentValidatorSetSubstate;
import com.radixdlt.api.core.generated.models.DataStruct;
import com.radixdlt.api.core.generated.models.EpochManagerConfigSubstate;
import com.radixdlt.api.core.generated.models.EpochManagerSubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerDivisibilitySubstate;
import com.radixdlt.api.core.generated.models.FungibleResourceManagerTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.FungibleVaultBalanceSubstate;
import com.radixdlt.api.core.generated.models.GenericIndexSubstate;
import com.radixdlt.api.core.generated.models.GenericKeyValueStoreSubstate;
import com.radixdlt.api.core.generated.models.GenericScryptoComponentStateSubstate;
import com.radixdlt.api.core.generated.models.GenericSortedU16IndexSubstate;
import com.radixdlt.api.core.generated.models.MetadataValueSubstate;
import com.radixdlt.api.core.generated.models.MethodAccessRulesSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerIdTypeSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerMutableFieldsSubstate;
import com.radixdlt.api.core.generated.models.NonFungibleResourceManagerTotalSupplySubstate;
import com.radixdlt.api.core.generated.models.NonFungibleVaultBalanceSubstate;
import com.radixdlt.api.core.generated.models.PackageCodeSubstate;
import com.radixdlt.api.core.generated.models.PackageCodeTypeSubstate;
import com.radixdlt.api.core.generated.models.PackageFunctionAccessRulesSubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltySubstate;
import com.radixdlt.api.core.generated.models.SecondaryIndexSubstate;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.TypeInfoSubstate;
import com.radixdlt.api.core.generated.models.ValidatorSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * GenericIndexSubstate
 */
@JsonPropertyOrder({
  GenericIndexSubstate.JSON_PROPERTY_DATA_STRUCT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "substate_type", // ignore manually set substate_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the substate_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "substate_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AccessControllerSubstate.class, name = "AccessController"),
  @JsonSubTypes.Type(value = AccountVaultSubstate.class, name = "AccountVault"),
  @JsonSubTypes.Type(value = ClockSubstate.class, name = "Clock"),
  @JsonSubTypes.Type(value = ComponentRoyaltyAccumulatorSubstate.class, name = "ComponentRoyaltyAccumulator"),
  @JsonSubTypes.Type(value = ComponentRoyaltyConfigSubstate.class, name = "ComponentRoyaltyConfig"),
  @JsonSubTypes.Type(value = CurrentValidatorSetSubstate.class, name = "CurrentValidatorSet"),
  @JsonSubTypes.Type(value = EpochManagerSubstate.class, name = "EpochManager"),
  @JsonSubTypes.Type(value = EpochManagerConfigSubstate.class, name = "EpochManagerConfig"),
  @JsonSubTypes.Type(value = FungibleResourceManagerDivisibilitySubstate.class, name = "FungibleResourceManagerDivisibility"),
  @JsonSubTypes.Type(value = FungibleResourceManagerTotalSupplySubstate.class, name = "FungibleResourceManagerTotalSupply"),
  @JsonSubTypes.Type(value = FungibleVaultBalanceSubstate.class, name = "FungibleVaultBalance"),
  @JsonSubTypes.Type(value = GenericIndexSubstate.class, name = "GenericIndex"),
  @JsonSubTypes.Type(value = GenericKeyValueStoreSubstate.class, name = "GenericKeyValueStore"),
  @JsonSubTypes.Type(value = GenericScryptoComponentStateSubstate.class, name = "GenericScryptoComponentState"),
  @JsonSubTypes.Type(value = GenericSortedU16IndexSubstate.class, name = "GenericSortedU16Index"),
  @JsonSubTypes.Type(value = MetadataValueSubstate.class, name = "MetadataValue"),
  @JsonSubTypes.Type(value = MethodAccessRulesSubstate.class, name = "MethodAccessRules"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerIdTypeSubstate.class, name = "NonFungibleResourceManagerIdType"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerMutableFieldsSubstate.class, name = "NonFungibleResourceManagerMutableFields"),
  @JsonSubTypes.Type(value = NonFungibleResourceManagerTotalSupplySubstate.class, name = "NonFungibleResourceManagerTotalSupply"),
  @JsonSubTypes.Type(value = NonFungibleVaultBalanceSubstate.class, name = "NonFungibleVaultBalance"),
  @JsonSubTypes.Type(value = PackageCodeSubstate.class, name = "PackageCode"),
  @JsonSubTypes.Type(value = PackageCodeTypeSubstate.class, name = "PackageCodeType"),
  @JsonSubTypes.Type(value = PackageFunctionAccessRulesSubstate.class, name = "PackageFunctionAccessRules"),
  @JsonSubTypes.Type(value = PackageInfoSubstate.class, name = "PackageInfo"),
  @JsonSubTypes.Type(value = PackageRoyaltySubstate.class, name = "PackageRoyalty"),
  @JsonSubTypes.Type(value = SecondaryIndexSubstate.class, name = "RegisteredValidators"),
  @JsonSubTypes.Type(value = TypeInfoSubstate.class, name = "TypeInfo"),
  @JsonSubTypes.Type(value = ValidatorSubstate.class, name = "Validator"),
})

public class GenericIndexSubstate extends Substate {
  public static final String JSON_PROPERTY_DATA_STRUCT = "data_struct";
  private DataStruct dataStruct;

  public GenericIndexSubstate() { 
  }

  public GenericIndexSubstate dataStruct(DataStruct dataStruct) {
    this.dataStruct = dataStruct;
    return this;
  }

   /**
   * Get dataStruct
   * @return dataStruct
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_DATA_STRUCT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public DataStruct getDataStruct() {
    return dataStruct;
  }


  @JsonProperty(JSON_PROPERTY_DATA_STRUCT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDataStruct(DataStruct dataStruct) {
    this.dataStruct = dataStruct;
  }


  /**
   * Return true if this GenericIndexSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenericIndexSubstate genericIndexSubstate = (GenericIndexSubstate) o;
    return Objects.equals(this.dataStruct, genericIndexSubstate.dataStruct) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dataStruct, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenericIndexSubstate {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    dataStruct: ").append(toIndentedString(dataStruct)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("AccessController", AccessControllerSubstate.class);
  mappings.put("AccountVault", AccountVaultSubstate.class);
  mappings.put("Clock", ClockSubstate.class);
  mappings.put("ComponentRoyaltyAccumulator", ComponentRoyaltyAccumulatorSubstate.class);
  mappings.put("ComponentRoyaltyConfig", ComponentRoyaltyConfigSubstate.class);
  mappings.put("CurrentValidatorSet", CurrentValidatorSetSubstate.class);
  mappings.put("EpochManager", EpochManagerSubstate.class);
  mappings.put("EpochManagerConfig", EpochManagerConfigSubstate.class);
  mappings.put("FungibleResourceManagerDivisibility", FungibleResourceManagerDivisibilitySubstate.class);
  mappings.put("FungibleResourceManagerTotalSupply", FungibleResourceManagerTotalSupplySubstate.class);
  mappings.put("FungibleVaultBalance", FungibleVaultBalanceSubstate.class);
  mappings.put("GenericIndex", GenericIndexSubstate.class);
  mappings.put("GenericKeyValueStore", GenericKeyValueStoreSubstate.class);
  mappings.put("GenericScryptoComponentState", GenericScryptoComponentStateSubstate.class);
  mappings.put("GenericSortedU16Index", GenericSortedU16IndexSubstate.class);
  mappings.put("MetadataValue", MetadataValueSubstate.class);
  mappings.put("MethodAccessRules", MethodAccessRulesSubstate.class);
  mappings.put("NonFungibleResourceManagerIdType", NonFungibleResourceManagerIdTypeSubstate.class);
  mappings.put("NonFungibleResourceManagerMutableFields", NonFungibleResourceManagerMutableFieldsSubstate.class);
  mappings.put("NonFungibleResourceManagerTotalSupply", NonFungibleResourceManagerTotalSupplySubstate.class);
  mappings.put("NonFungibleVaultBalance", NonFungibleVaultBalanceSubstate.class);
  mappings.put("PackageCode", PackageCodeSubstate.class);
  mappings.put("PackageCodeType", PackageCodeTypeSubstate.class);
  mappings.put("PackageFunctionAccessRules", PackageFunctionAccessRulesSubstate.class);
  mappings.put("PackageInfo", PackageInfoSubstate.class);
  mappings.put("PackageRoyalty", PackageRoyaltySubstate.class);
  mappings.put("RegisteredValidators", SecondaryIndexSubstate.class);
  mappings.put("TypeInfo", TypeInfoSubstate.class);
  mappings.put("Validator", ValidatorSubstate.class);
  mappings.put("GenericIndexSubstate", GenericIndexSubstate.class);
  JSON.registerDiscriminator(GenericIndexSubstate.class, "substate_type", mappings);
}
}

