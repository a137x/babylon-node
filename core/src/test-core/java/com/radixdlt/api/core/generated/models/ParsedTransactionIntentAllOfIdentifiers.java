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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ParsedTransactionIntentAllOfIdentifiers
 */
@JsonPropertyOrder({
  ParsedTransactionIntentAllOfIdentifiers.JSON_PROPERTY_INTENT_HASH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ParsedTransactionIntentAllOfIdentifiers {
  public static final String JSON_PROPERTY_INTENT_HASH = "intent_hash";
  private String intentHash;

  public ParsedTransactionIntentAllOfIdentifiers() { 
  }

  public ParsedTransactionIntentAllOfIdentifiers intentHash(String intentHash) {
    this.intentHash = intentHash;
    return this;
  }

   /**
   * The hex-encoded transaction intent hash. This is known as the Intent Hash, Transaction ID or Transaction Identifier for user transactions. This hash is &#x60;SHA256(SHA256(compiled_intent))&#x60;
   * @return intentHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded transaction intent hash. This is known as the Intent Hash, Transaction ID or Transaction Identifier for user transactions. This hash is `SHA256(SHA256(compiled_intent))`")
  @JsonProperty(JSON_PROPERTY_INTENT_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getIntentHash() {
    return intentHash;
  }


  @JsonProperty(JSON_PROPERTY_INTENT_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIntentHash(String intentHash) {
    this.intentHash = intentHash;
  }


  /**
   * Return true if this ParsedTransactionIntent_allOf_identifiers object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ParsedTransactionIntentAllOfIdentifiers parsedTransactionIntentAllOfIdentifiers = (ParsedTransactionIntentAllOfIdentifiers) o;
    return Objects.equals(this.intentHash, parsedTransactionIntentAllOfIdentifiers.intentHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(intentHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ParsedTransactionIntentAllOfIdentifiers {\n");
    sb.append("    intentHash: ").append(toIndentedString(intentHash)).append("\n");
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

