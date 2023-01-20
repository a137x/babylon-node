/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.2.0
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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ValidatorSubstateAllOf
 */
@JsonPropertyOrder({
  ValidatorSubstateAllOf.JSON_PROPERTY_EPOCH_MANAGER_ADDRESS,
  ValidatorSubstateAllOf.JSON_PROPERTY_VALIDATOR_ADDRESS,
  ValidatorSubstateAllOf.JSON_PROPERTY_KEY
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ValidatorSubstateAllOf {
  public static final String JSON_PROPERTY_EPOCH_MANAGER_ADDRESS = "epoch_manager_address";
  private String epochManagerAddress;

  public static final String JSON_PROPERTY_VALIDATOR_ADDRESS = "validator_address";
  private String validatorAddress;

  public static final String JSON_PROPERTY_KEY = "key";
  private EcdsaSecp256k1PublicKey key;

  public ValidatorSubstateAllOf() { 
  }

  public ValidatorSubstateAllOf epochManagerAddress(String epochManagerAddress) {
    this.epochManagerAddress = epochManagerAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return epochManagerAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_EPOCH_MANAGER_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getEpochManagerAddress() {
    return epochManagerAddress;
  }


  @JsonProperty(JSON_PROPERTY_EPOCH_MANAGER_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpochManagerAddress(String epochManagerAddress) {
    this.epochManagerAddress = epochManagerAddress;
  }


  public ValidatorSubstateAllOf validatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return validatorAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValidatorAddress() {
    return validatorAddress;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidatorAddress(String validatorAddress) {
    this.validatorAddress = validatorAddress;
  }


  public ValidatorSubstateAllOf key(EcdsaSecp256k1PublicKey key) {
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


  /**
   * Return true if this ValidatorSubstate_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidatorSubstateAllOf validatorSubstateAllOf = (ValidatorSubstateAllOf) o;
    return Objects.equals(this.epochManagerAddress, validatorSubstateAllOf.epochManagerAddress) &&
        Objects.equals(this.validatorAddress, validatorSubstateAllOf.validatorAddress) &&
        Objects.equals(this.key, validatorSubstateAllOf.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(epochManagerAddress, validatorAddress, key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidatorSubstateAllOf {\n");
    sb.append("    epochManagerAddress: ").append(toIndentedString(epochManagerAddress)).append("\n");
    sb.append("    validatorAddress: ").append(toIndentedString(validatorAddress)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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

