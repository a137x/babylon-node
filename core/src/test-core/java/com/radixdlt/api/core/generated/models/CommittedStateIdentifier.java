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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.CommittedStateIdentifierAllOf;
import com.radixdlt.api.core.generated.models.LedgerHashes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * CommittedStateIdentifier
 */
@JsonPropertyOrder({
  CommittedStateIdentifier.JSON_PROPERTY_STATE_VERSION,
  CommittedStateIdentifier.JSON_PROPERTY_STATE_TREE_HASH,
  CommittedStateIdentifier.JSON_PROPERTY_TRANSACTION_TREE_HASH,
  CommittedStateIdentifier.JSON_PROPERTY_RECEIPT_TREE_HASH
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class CommittedStateIdentifier {
  public static final String JSON_PROPERTY_STATE_VERSION = "state_version";
  private Long stateVersion;

  public static final String JSON_PROPERTY_STATE_TREE_HASH = "state_tree_hash";
  private String stateTreeHash;

  public static final String JSON_PROPERTY_TRANSACTION_TREE_HASH = "transaction_tree_hash";
  private String transactionTreeHash;

  public static final String JSON_PROPERTY_RECEIPT_TREE_HASH = "receipt_tree_hash";
  private String receiptTreeHash;

  public CommittedStateIdentifier() { 
  }

  public CommittedStateIdentifier stateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
    return this;
  }

   /**
   * Get stateVersion
   * minimum: 1
   * maximum: 100000000000000
   * @return stateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getStateVersion() {
    return stateVersion;
  }


  @JsonProperty(JSON_PROPERTY_STATE_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
  }


  public CommittedStateIdentifier stateTreeHash(String stateTreeHash) {
    this.stateTreeHash = stateTreeHash;
    return this;
  }

   /**
   * The hex-encoded root hash of the state tree. This captures the current state of the state on the ledger. 
   * @return stateTreeHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded root hash of the state tree. This captures the current state of the state on the ledger. ")
  @JsonProperty(JSON_PROPERTY_STATE_TREE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getStateTreeHash() {
    return stateTreeHash;
  }


  @JsonProperty(JSON_PROPERTY_STATE_TREE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStateTreeHash(String stateTreeHash) {
    this.stateTreeHash = stateTreeHash;
  }


  public CommittedStateIdentifier transactionTreeHash(String transactionTreeHash) {
    this.transactionTreeHash = transactionTreeHash;
    return this;
  }

   /**
   * The hex-encoded root hash of the transaction tree. This captures the ledger transactions committed to the ledger. 
   * @return transactionTreeHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded root hash of the transaction tree. This captures the ledger transactions committed to the ledger. ")
  @JsonProperty(JSON_PROPERTY_TRANSACTION_TREE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTransactionTreeHash() {
    return transactionTreeHash;
  }


  @JsonProperty(JSON_PROPERTY_TRANSACTION_TREE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTransactionTreeHash(String transactionTreeHash) {
    this.transactionTreeHash = transactionTreeHash;
  }


  public CommittedStateIdentifier receiptTreeHash(String receiptTreeHash) {
    this.receiptTreeHash = receiptTreeHash;
    return this;
  }

   /**
   * The hex-encoded root hash of the receipt tree. This captures the consensus-agreed output of each transaction on the ledger. 
   * @return receiptTreeHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded root hash of the receipt tree. This captures the consensus-agreed output of each transaction on the ledger. ")
  @JsonProperty(JSON_PROPERTY_RECEIPT_TREE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getReceiptTreeHash() {
    return receiptTreeHash;
  }


  @JsonProperty(JSON_PROPERTY_RECEIPT_TREE_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setReceiptTreeHash(String receiptTreeHash) {
    this.receiptTreeHash = receiptTreeHash;
  }


  /**
   * Return true if this CommittedStateIdentifier object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommittedStateIdentifier committedStateIdentifier = (CommittedStateIdentifier) o;
    return Objects.equals(this.stateVersion, committedStateIdentifier.stateVersion) &&
        Objects.equals(this.stateTreeHash, committedStateIdentifier.stateTreeHash) &&
        Objects.equals(this.transactionTreeHash, committedStateIdentifier.transactionTreeHash) &&
        Objects.equals(this.receiptTreeHash, committedStateIdentifier.receiptTreeHash);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateVersion, stateTreeHash, transactionTreeHash, receiptTreeHash);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommittedStateIdentifier {\n");
    sb.append("    stateVersion: ").append(toIndentedString(stateVersion)).append("\n");
    sb.append("    stateTreeHash: ").append(toIndentedString(stateTreeHash)).append("\n");
    sb.append("    transactionTreeHash: ").append(toIndentedString(transactionTreeHash)).append("\n");
    sb.append("    receiptTreeHash: ").append(toIndentedString(receiptTreeHash)).append("\n");
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

