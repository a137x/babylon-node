/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.1.0
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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.EcdsaSecp256k1PublicKey;
import com.radixdlt.api.core.generated.models.EntityReference;
import com.radixdlt.api.core.generated.models.SubstateBase;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.ValidatorSubstateAllOf;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ValidatorSubstate
 */
@JsonPropertyOrder({
  ValidatorSubstate.JSON_PROPERTY_SUBSTATE_TYPE,
  ValidatorSubstate.JSON_PROPERTY_MANAGER,
  ValidatorSubstate.JSON_PROPERTY_ADDRESS,
  ValidatorSubstate.JSON_PROPERTY_KEY,
  ValidatorSubstate.JSON_PROPERTY_STAKE_VAULT,
  ValidatorSubstate.JSON_PROPERTY_IS_REGISTERED
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ValidatorSubstate {
  public static final String JSON_PROPERTY_SUBSTATE_TYPE = "substate_type";
  private SubstateType substateType;

  public static final String JSON_PROPERTY_MANAGER = "manager";
  private String manager;

  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_KEY = "key";
  private EcdsaSecp256k1PublicKey key;

  public static final String JSON_PROPERTY_STAKE_VAULT = "stake_vault";
  private EntityReference stakeVault;

  public static final String JSON_PROPERTY_IS_REGISTERED = "is_registered";
  private Boolean isRegistered;

  public ValidatorSubstate() { 
  }

  public ValidatorSubstate substateType(SubstateType substateType) {
    this.substateType = substateType;
    return this;
  }

   /**
   * Get substateType
   * @return substateType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public SubstateType getSubstateType() {
    return substateType;
  }


  @JsonProperty(JSON_PROPERTY_SUBSTATE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSubstateType(SubstateType substateType) {
    this.substateType = substateType;
  }


  public ValidatorSubstate manager(String manager) {
    this.manager = manager;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the system address
   * @return manager
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the system address")
  @JsonProperty(JSON_PROPERTY_MANAGER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getManager() {
    return manager;
  }


  @JsonProperty(JSON_PROPERTY_MANAGER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setManager(String manager) {
    this.manager = manager;
  }


  public ValidatorSubstate address(String address) {
    this.address = address;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the system address
   * @return address
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the system address")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddress(String address) {
    this.address = address;
  }


  public ValidatorSubstate key(EcdsaSecp256k1PublicKey key) {
    this.key = key;
    return this;
  }

   /**
   * Get key
   * @return key
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EcdsaSecp256k1PublicKey getKey() {
    return key;
  }


  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKey(EcdsaSecp256k1PublicKey key) {
    this.key = key;
  }


  public ValidatorSubstate stakeVault(EntityReference stakeVault) {
    this.stakeVault = stakeVault;
    return this;
  }

   /**
   * Get stakeVault
   * @return stakeVault
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STAKE_VAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityReference getStakeVault() {
    return stakeVault;
  }


  @JsonProperty(JSON_PROPERTY_STAKE_VAULT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStakeVault(EntityReference stakeVault) {
    this.stakeVault = stakeVault;
  }


  public ValidatorSubstate isRegistered(Boolean isRegistered) {
    this.isRegistered = isRegistered;
    return this;
  }

   /**
   * Get isRegistered
   * @return isRegistered
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_IS_REGISTERED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsRegistered() {
    return isRegistered;
  }


  @JsonProperty(JSON_PROPERTY_IS_REGISTERED)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsRegistered(Boolean isRegistered) {
    this.isRegistered = isRegistered;
  }


  /**
   * Return true if this ValidatorSubstate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidatorSubstate validatorSubstate = (ValidatorSubstate) o;
    return Objects.equals(this.substateType, validatorSubstate.substateType) &&
        Objects.equals(this.manager, validatorSubstate.manager) &&
        Objects.equals(this.address, validatorSubstate.address) &&
        Objects.equals(this.key, validatorSubstate.key) &&
        Objects.equals(this.stakeVault, validatorSubstate.stakeVault) &&
        Objects.equals(this.isRegistered, validatorSubstate.isRegistered);
  }

  @Override
  public int hashCode() {
    return Objects.hash(substateType, manager, address, key, stakeVault, isRegistered);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidatorSubstate {\n");
    sb.append("    substateType: ").append(toIndentedString(substateType)).append("\n");
    sb.append("    manager: ").append(toIndentedString(manager)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    stakeVault: ").append(toIndentedString(stakeVault)).append("\n");
    sb.append("    isRegistered: ").append(toIndentedString(isRegistered)).append("\n");
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

}

