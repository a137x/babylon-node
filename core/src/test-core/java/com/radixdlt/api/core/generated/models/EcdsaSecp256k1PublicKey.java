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
import com.radixdlt.api.core.generated.models.PublicKeyType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * EcdsaSecp256k1PublicKey
 */
@JsonPropertyOrder({
  EcdsaSecp256k1PublicKey.JSON_PROPERTY_KEY_TYPE,
  EcdsaSecp256k1PublicKey.JSON_PROPERTY_KEY_HEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class EcdsaSecp256k1PublicKey {
  public static final String JSON_PROPERTY_KEY_TYPE = "key_type";
  private PublicKeyType keyType;

  public static final String JSON_PROPERTY_KEY_HEX = "key_hex";
  private String keyHex;

  public EcdsaSecp256k1PublicKey() { 
  }

  public EcdsaSecp256k1PublicKey keyType(PublicKeyType keyType) {
    this.keyType = keyType;
    return this;
  }

   /**
   * Get keyType
   * @return keyType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_KEY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PublicKeyType getKeyType() {
    return keyType;
  }


  @JsonProperty(JSON_PROPERTY_KEY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyType(PublicKeyType keyType) {
    this.keyType = keyType;
  }


  public EcdsaSecp256k1PublicKey keyHex(String keyHex) {
    this.keyHex = keyHex;
    return this;
  }

   /**
   * The hex-encoded compressed ECDSA Secp256k1 public key (33 bytes)
   * @return keyHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded compressed ECDSA Secp256k1 public key (33 bytes)")
  @JsonProperty(JSON_PROPERTY_KEY_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getKeyHex() {
    return keyHex;
  }


  @JsonProperty(JSON_PROPERTY_KEY_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setKeyHex(String keyHex) {
    this.keyHex = keyHex;
  }


  /**
   * Return true if this EcdsaSecp256k1PublicKey object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EcdsaSecp256k1PublicKey ecdsaSecp256k1PublicKey = (EcdsaSecp256k1PublicKey) o;
    return Objects.equals(this.keyType, ecdsaSecp256k1PublicKey.keyType) &&
        Objects.equals(this.keyHex, ecdsaSecp256k1PublicKey.keyHex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyType, keyHex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EcdsaSecp256k1PublicKey {\n");
    sb.append("    keyType: ").append(toIndentedString(keyType)).append("\n");
    sb.append("    keyHex: ").append(toIndentedString(keyHex)).append("\n");
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

