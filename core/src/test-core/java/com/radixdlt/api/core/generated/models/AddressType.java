/*
 * Radix Core API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  The default configuration is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function. The node exposes a configuration flag which allows disabling certain endpoints which may be problematic, but monitoring is advised. This configuration parameter is `api.core.flags.enable_unbounded_endpoints` / `RADIXDLT_CORE_API_FLAGS_ENABLE_UNBOUNDED_ENDPOINTS`.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` have high guarantees of forward compatibility in future node versions. We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  Other endpoints may be changed with new node versions carrying protocol-updates, although any breaking changes will be flagged clearly in the corresponding release notes.  All responses may have additional fields added, so clients are advised to use JSON parsers which ignore unknown fields on JSON objects. 
 *
 * The version of the OpenAPI document: v1.0.4
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
 * AddressType
 */
@JsonPropertyOrder({
  AddressType.JSON_PROPERTY_HRP_PREFIX,
  AddressType.JSON_PROPERTY_ENTITY_TYPE,
  AddressType.JSON_PROPERTY_ADDRESS_BYTE_PREFIX,
  AddressType.JSON_PROPERTY_ADDRESS_BYTE_LENGTH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AddressType {
  public static final String JSON_PROPERTY_HRP_PREFIX = "hrp_prefix";
  private String hrpPrefix;

  public static final String JSON_PROPERTY_ENTITY_TYPE = "entity_type";
  private EntityType entityType;

  public static final String JSON_PROPERTY_ADDRESS_BYTE_PREFIX = "address_byte_prefix";
  private Integer addressBytePrefix;

  public static final String JSON_PROPERTY_ADDRESS_BYTE_LENGTH = "address_byte_length";
  private Integer addressByteLength;

  public AddressType() { 
  }

  public AddressType hrpPrefix(String hrpPrefix) {
    this.hrpPrefix = hrpPrefix;
    return this;
  }

   /**
   * Get hrpPrefix
   * @return hrpPrefix
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_HRP_PREFIX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getHrpPrefix() {
    return hrpPrefix;
  }


  @JsonProperty(JSON_PROPERTY_HRP_PREFIX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setHrpPrefix(String hrpPrefix) {
    this.hrpPrefix = hrpPrefix;
  }


  public AddressType entityType(EntityType entityType) {
    this.entityType = entityType;
    return this;
  }

   /**
   * Get entityType
   * @return entityType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityType getEntityType() {
    return entityType;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntityType(EntityType entityType) {
    this.entityType = entityType;
  }


  public AddressType addressBytePrefix(Integer addressBytePrefix) {
    this.addressBytePrefix = addressBytePrefix;
    return this;
  }

   /**
   * Get addressBytePrefix
   * minimum: 0
   * maximum: 255
   * @return addressBytePrefix
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS_BYTE_PREFIX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getAddressBytePrefix() {
    return addressBytePrefix;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS_BYTE_PREFIX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddressBytePrefix(Integer addressBytePrefix) {
    this.addressBytePrefix = addressBytePrefix;
  }


  public AddressType addressByteLength(Integer addressByteLength) {
    this.addressByteLength = addressByteLength;
    return this;
  }

   /**
   * Get addressByteLength
   * minimum: 0
   * maximum: 255
   * @return addressByteLength
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ADDRESS_BYTE_LENGTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getAddressByteLength() {
    return addressByteLength;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS_BYTE_LENGTH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddressByteLength(Integer addressByteLength) {
    this.addressByteLength = addressByteLength;
  }


  /**
   * Return true if this AddressType object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressType addressType = (AddressType) o;
    return Objects.equals(this.hrpPrefix, addressType.hrpPrefix) &&
        Objects.equals(this.entityType, addressType.entityType) &&
        Objects.equals(this.addressBytePrefix, addressType.addressBytePrefix) &&
        Objects.equals(this.addressByteLength, addressType.addressByteLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hrpPrefix, entityType, addressBytePrefix, addressByteLength);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressType {\n");
    sb.append("    hrpPrefix: ").append(toIndentedString(hrpPrefix)).append("\n");
    sb.append("    entityType: ").append(toIndentedString(entityType)).append("\n");
    sb.append("    addressBytePrefix: ").append(toIndentedString(addressBytePrefix)).append("\n");
    sb.append("    addressByteLength: ").append(toIndentedString(addressByteLength)).append("\n");
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

