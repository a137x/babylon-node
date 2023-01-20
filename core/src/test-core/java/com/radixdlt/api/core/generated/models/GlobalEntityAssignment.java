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
import com.radixdlt.api.core.generated.models.EntityType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GlobalEntityAssignment
 */
@JsonPropertyOrder({
  GlobalEntityAssignment.JSON_PROPERTY_TARGET_ENTITY_TYPE,
  GlobalEntityAssignment.JSON_PROPERTY_TARGET_ENTITY_ID_HEX,
  GlobalEntityAssignment.JSON_PROPERTY_GLOBAL_ENTITY_ID_HEX,
  GlobalEntityAssignment.JSON_PROPERTY_GLOBAL_ADDRESS_HEX,
  GlobalEntityAssignment.JSON_PROPERTY_GLOBAL_ADDRESS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class GlobalEntityAssignment {
  public static final String JSON_PROPERTY_TARGET_ENTITY_TYPE = "target_entity_type";
  private EntityType targetEntityType;

  public static final String JSON_PROPERTY_TARGET_ENTITY_ID_HEX = "target_entity_id_hex";
  private String targetEntityIdHex;

  public static final String JSON_PROPERTY_GLOBAL_ENTITY_ID_HEX = "global_entity_id_hex";
  private String globalEntityIdHex;

  public static final String JSON_PROPERTY_GLOBAL_ADDRESS_HEX = "global_address_hex";
  private String globalAddressHex;

  public static final String JSON_PROPERTY_GLOBAL_ADDRESS = "global_address";
  private String globalAddress;

  public GlobalEntityAssignment() { 
  }

  public GlobalEntityAssignment targetEntityType(EntityType targetEntityType) {
    this.targetEntityType = targetEntityType;
    return this;
  }

   /**
   * Get targetEntityType
   * @return targetEntityType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TARGET_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityType getTargetEntityType() {
    return targetEntityType;
  }


  @JsonProperty(JSON_PROPERTY_TARGET_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTargetEntityType(EntityType targetEntityType) {
    this.targetEntityType = targetEntityType;
  }


  public GlobalEntityAssignment targetEntityIdHex(String targetEntityIdHex) {
    this.targetEntityIdHex = targetEntityIdHex;
    return this;
  }

   /**
   * The hex-encoded bytes of the target entity id
   * @return targetEntityIdHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded bytes of the target entity id")
  @JsonProperty(JSON_PROPERTY_TARGET_ENTITY_ID_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTargetEntityIdHex() {
    return targetEntityIdHex;
  }


  @JsonProperty(JSON_PROPERTY_TARGET_ENTITY_ID_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTargetEntityIdHex(String targetEntityIdHex) {
    this.targetEntityIdHex = targetEntityIdHex;
  }


  public GlobalEntityAssignment globalEntityIdHex(String globalEntityIdHex) {
    this.globalEntityIdHex = globalEntityIdHex;
    return this;
  }

   /**
   * The hex-encoded bytes of the global entity id
   * @return globalEntityIdHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded bytes of the global entity id")
  @JsonProperty(JSON_PROPERTY_GLOBAL_ENTITY_ID_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGlobalEntityIdHex() {
    return globalEntityIdHex;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ENTITY_ID_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobalEntityIdHex(String globalEntityIdHex) {
    this.globalEntityIdHex = globalEntityIdHex;
  }


  public GlobalEntityAssignment globalAddressHex(String globalAddressHex) {
    this.globalAddressHex = globalAddressHex;
    return this;
  }

   /**
   * The hex-encoded bytes of the assigned global address.
   * @return globalAddressHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded bytes of the assigned global address.")
  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGlobalAddressHex() {
    return globalAddressHex;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobalAddressHex(String globalAddressHex) {
    this.globalAddressHex = globalAddressHex;
  }


  public GlobalEntityAssignment globalAddress(String globalAddress) {
    this.globalAddress = globalAddress;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the assigned global address
   * @return globalAddress
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the assigned global address")
  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getGlobalAddress() {
    return globalAddress;
  }


  @JsonProperty(JSON_PROPERTY_GLOBAL_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGlobalAddress(String globalAddress) {
    this.globalAddress = globalAddress;
  }


  /**
   * Return true if this GlobalEntityAssignment object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GlobalEntityAssignment globalEntityAssignment = (GlobalEntityAssignment) o;
    return Objects.equals(this.targetEntityType, globalEntityAssignment.targetEntityType) &&
        Objects.equals(this.targetEntityIdHex, globalEntityAssignment.targetEntityIdHex) &&
        Objects.equals(this.globalEntityIdHex, globalEntityAssignment.globalEntityIdHex) &&
        Objects.equals(this.globalAddressHex, globalEntityAssignment.globalAddressHex) &&
        Objects.equals(this.globalAddress, globalEntityAssignment.globalAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetEntityType, targetEntityIdHex, globalEntityIdHex, globalAddressHex, globalAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GlobalEntityAssignment {\n");
    sb.append("    targetEntityType: ").append(toIndentedString(targetEntityType)).append("\n");
    sb.append("    targetEntityIdHex: ").append(toIndentedString(targetEntityIdHex)).append("\n");
    sb.append("    globalEntityIdHex: ").append(toIndentedString(globalEntityIdHex)).append("\n");
    sb.append("    globalAddressHex: ").append(toIndentedString(globalAddressHex)).append("\n");
    sb.append("    globalAddress: ").append(toIndentedString(globalAddress)).append("\n");
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

