/*
 * Babylon Core API - RCnet v3.1
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the fourth release candidate of the Radix Babylon network (\"RCnet v3.1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code. 
 *
 * The version of the OpenAPI document: 0.5.1
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
import com.radixdlt.api.core.generated.models.SystemTransaction;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GenesisLedgerTransactionAllOf
 */
@JsonPropertyOrder({
  GenesisLedgerTransactionAllOf.JSON_PROPERTY_IS_FLASH,
  GenesisLedgerTransactionAllOf.JSON_PROPERTY_SYSTEM_TRANSACTION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class GenesisLedgerTransactionAllOf {
  public static final String JSON_PROPERTY_IS_FLASH = "is_flash";
  private Boolean isFlash;

  public static final String JSON_PROPERTY_SYSTEM_TRANSACTION = "system_transaction";
  private SystemTransaction systemTransaction;

  public GenesisLedgerTransactionAllOf() { 
  }

  public GenesisLedgerTransactionAllOf isFlash(Boolean isFlash) {
    this.isFlash = isFlash;
    return this;
  }

   /**
   * The first genesis \&quot;transaction\&quot; flashes state into the database to prepare for the bootstrap transaction. Such a transaction does not have an associated &#x60;system_transaction&#x60; 
   * @return isFlash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The first genesis \"transaction\" flashes state into the database to prepare for the bootstrap transaction. Such a transaction does not have an associated `system_transaction` ")
  @JsonProperty(JSON_PROPERTY_IS_FLASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Boolean getIsFlash() {
    return isFlash;
  }


  @JsonProperty(JSON_PROPERTY_IS_FLASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsFlash(Boolean isFlash) {
    this.isFlash = isFlash;
  }


  public GenesisLedgerTransactionAllOf systemTransaction(SystemTransaction systemTransaction) {
    this.systemTransaction = systemTransaction;
    return this;
  }

   /**
   * Get systemTransaction
   * @return systemTransaction
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SYSTEM_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public SystemTransaction getSystemTransaction() {
    return systemTransaction;
  }


  @JsonProperty(JSON_PROPERTY_SYSTEM_TRANSACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSystemTransaction(SystemTransaction systemTransaction) {
    this.systemTransaction = systemTransaction;
  }


  /**
   * Return true if this GenesisLedgerTransaction_allOf object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GenesisLedgerTransactionAllOf genesisLedgerTransactionAllOf = (GenesisLedgerTransactionAllOf) o;
    return Objects.equals(this.isFlash, genesisLedgerTransactionAllOf.isFlash) &&
        Objects.equals(this.systemTransaction, genesisLedgerTransactionAllOf.systemTransaction);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isFlash, systemTransaction);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GenesisLedgerTransactionAllOf {\n");
    sb.append("    isFlash: ").append(toIndentedString(isFlash)).append("\n");
    sb.append("    systemTransaction: ").append(toIndentedString(systemTransaction)).append("\n");
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

