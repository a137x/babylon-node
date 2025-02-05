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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.EncryptedTransactionMessage;
import com.radixdlt.api.core.generated.models.PlaintextMessageContent;
import com.radixdlt.api.core.generated.models.PlaintextTransactionMessage;
import com.radixdlt.api.core.generated.models.PlaintextTransactionMessageAllOf;
import com.radixdlt.api.core.generated.models.TransactionMessage;
import com.radixdlt.api.core.generated.models.TransactionMessageType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * PlaintextTransactionMessage
 */
@JsonPropertyOrder({
  PlaintextTransactionMessage.JSON_PROPERTY_MIME_TYPE,
  PlaintextTransactionMessage.JSON_PROPERTY_CONTENT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = EncryptedTransactionMessage.class, name = "Encrypted"),
  @JsonSubTypes.Type(value = PlaintextTransactionMessage.class, name = "Plaintext"),
})

public class PlaintextTransactionMessage extends TransactionMessage {
  public static final String JSON_PROPERTY_MIME_TYPE = "mime_type";
  private String mimeType;

  public static final String JSON_PROPERTY_CONTENT = "content";
  private PlaintextMessageContent content;

  public PlaintextTransactionMessage() { 
  }

  public PlaintextTransactionMessage mimeType(String mimeType) {
    this.mimeType = mimeType;
    return this;
  }

   /**
   * Intended to represent the RFC 2046 MIME type of the &#x60;content&#x60;. A client cannot trust that this field is a valid mime type - in particular, the choice between &#x60;String&#x60; or &#x60;Binary&#x60; representation of the content is not enforced by this &#x60;mime_type&#x60;. 
   * @return mimeType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Intended to represent the RFC 2046 MIME type of the `content`. A client cannot trust that this field is a valid mime type - in particular, the choice between `String` or `Binary` representation of the content is not enforced by this `mime_type`. ")
  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMimeType() {
    return mimeType;
  }


  @JsonProperty(JSON_PROPERTY_MIME_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }


  public PlaintextTransactionMessage content(PlaintextMessageContent content) {
    this.content = content;
    return this;
  }

   /**
   * Get content
   * @return content
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public PlaintextMessageContent getContent() {
    return content;
  }


  @JsonProperty(JSON_PROPERTY_CONTENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setContent(PlaintextMessageContent content) {
    this.content = content;
  }


  /**
   * Return true if this PlaintextTransactionMessage object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlaintextTransactionMessage plaintextTransactionMessage = (PlaintextTransactionMessage) o;
    return Objects.equals(this.mimeType, plaintextTransactionMessage.mimeType) &&
        Objects.equals(this.content, plaintextTransactionMessage.content) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mimeType, content, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlaintextTransactionMessage {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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
  mappings.put("Encrypted", EncryptedTransactionMessage.class);
  mappings.put("Plaintext", PlaintextTransactionMessage.class);
  mappings.put("PlaintextTransactionMessage", PlaintextTransactionMessage.class);
  JSON.registerDiscriminator(PlaintextTransactionMessage.class, "type", mappings);
}
}

