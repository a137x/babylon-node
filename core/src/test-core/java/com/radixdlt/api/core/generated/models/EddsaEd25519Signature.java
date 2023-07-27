/*
 * Babylon Core API - RCnet v3
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v3\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.0
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
import com.radixdlt.api.core.generated.models.EcdsaSecp256k1Signature;
import com.radixdlt.api.core.generated.models.EddsaEd25519Signature;
import com.radixdlt.api.core.generated.models.EddsaEd25519SignatureAllOf;
import com.radixdlt.api.core.generated.models.PublicKeyType;
import com.radixdlt.api.core.generated.models.Signature;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * EddsaEd25519Signature
 */
@JsonPropertyOrder({
  EddsaEd25519Signature.JSON_PROPERTY_SIGNATURE_HEX
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "key_type", // ignore manually set key_type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the key_type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "key_type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = EcdsaSecp256k1Signature.class, name = "EcdsaSecp256k1"),
  @JsonSubTypes.Type(value = EddsaEd25519Signature.class, name = "EddsaEd25519"),
})

public class EddsaEd25519Signature extends Signature {
  public static final String JSON_PROPERTY_SIGNATURE_HEX = "signature_hex";
  private String signatureHex;

  public EddsaEd25519Signature() { 
  }

  public EddsaEd25519Signature signatureHex(String signatureHex) {
    this.signatureHex = signatureHex;
    return this;
  }

   /**
   * A hex-encoded EdDSA Ed25519 signature (64 bytes). This is &#x60;CONCAT(R, s)&#x60; where &#x60;R&#x60; and &#x60;s&#x60; are each 32-bytes in padded big-endian format.
   * @return signatureHex
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A hex-encoded EdDSA Ed25519 signature (64 bytes). This is `CONCAT(R, s)` where `R` and `s` are each 32-bytes in padded big-endian format.")
  @JsonProperty(JSON_PROPERTY_SIGNATURE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getSignatureHex() {
    return signatureHex;
  }


  @JsonProperty(JSON_PROPERTY_SIGNATURE_HEX)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSignatureHex(String signatureHex) {
    this.signatureHex = signatureHex;
  }


  /**
   * Return true if this EddsaEd25519Signature object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EddsaEd25519Signature eddsaEd25519Signature = (EddsaEd25519Signature) o;
    return Objects.equals(this.signatureHex, eddsaEd25519Signature.signatureHex) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(signatureHex, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EddsaEd25519Signature {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    signatureHex: ").append(toIndentedString(signatureHex)).append("\n");
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
  mappings.put("EcdsaSecp256k1", EcdsaSecp256k1Signature.class);
  mappings.put("EddsaEd25519", EddsaEd25519Signature.class);
  mappings.put("EddsaEd25519Signature", EddsaEd25519Signature.class);
  JSON.registerDiscriminator(EddsaEd25519Signature.class, "key_type", mappings);
}
}

