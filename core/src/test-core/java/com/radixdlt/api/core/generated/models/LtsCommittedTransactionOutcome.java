/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the first release candidate of the Radix Babylon network (\"RCnet-V1\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
 *
 * The version of the OpenAPI document: 0.4.0
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
import com.radixdlt.api.core.generated.models.LtsCommittedTransactionStatus;
import com.radixdlt.api.core.generated.models.LtsEntityFungibleBalanceChanges;
import com.radixdlt.api.core.generated.models.LtsResultantAccountFungibleBalances;
import com.radixdlt.api.core.generated.models.TransactionIdentifiers;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * For the given transaction, contains the status, total fee summary and individual entity resource balance changes. The balance changes accounts for the fee payments as well. Current implementation does not take into account recalls, but this will change in a future update. For failed transactions, current implementation does not return any balance changes (not even the fee payments). This will also change in a future update. 
 */
@ApiModel(description = "For the given transaction, contains the status, total fee summary and individual entity resource balance changes. The balance changes accounts for the fee payments as well. Current implementation does not take into account recalls, but this will change in a future update. For failed transactions, current implementation does not return any balance changes (not even the fee payments). This will also change in a future update. ")
@JsonPropertyOrder({
  LtsCommittedTransactionOutcome.JSON_PROPERTY_STATE_VERSION,
  LtsCommittedTransactionOutcome.JSON_PROPERTY_ACCUMULATOR_HASH,
  LtsCommittedTransactionOutcome.JSON_PROPERTY_USER_TRANSACTION_IDENTIFIERS,
  LtsCommittedTransactionOutcome.JSON_PROPERTY_STATUS,
  LtsCommittedTransactionOutcome.JSON_PROPERTY_FUNGIBLE_ENTITY_BALANCE_CHANGES,
  LtsCommittedTransactionOutcome.JSON_PROPERTY_RESULTANT_ACCOUNT_FUNGIBLE_BALANCES,
  LtsCommittedTransactionOutcome.JSON_PROPERTY_TOTAL_FEE
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class LtsCommittedTransactionOutcome {
  public static final String JSON_PROPERTY_STATE_VERSION = "state_version";
  private Long stateVersion;

  public static final String JSON_PROPERTY_ACCUMULATOR_HASH = "accumulator_hash";
  private String accumulatorHash;

  public static final String JSON_PROPERTY_USER_TRANSACTION_IDENTIFIERS = "user_transaction_identifiers";
  private TransactionIdentifiers userTransactionIdentifiers;

  public static final String JSON_PROPERTY_STATUS = "status";
  private LtsCommittedTransactionStatus status;

  public static final String JSON_PROPERTY_FUNGIBLE_ENTITY_BALANCE_CHANGES = "fungible_entity_balance_changes";
  private List<LtsEntityFungibleBalanceChanges> fungibleEntityBalanceChanges = new ArrayList<>();

  public static final String JSON_PROPERTY_RESULTANT_ACCOUNT_FUNGIBLE_BALANCES = "resultant_account_fungible_balances";
  private List<LtsResultantAccountFungibleBalances> resultantAccountFungibleBalances = new ArrayList<>();

  public static final String JSON_PROPERTY_TOTAL_FEE = "total_fee";
  private String totalFee;

  public LtsCommittedTransactionOutcome() { 
  }

  public LtsCommittedTransactionOutcome stateVersion(Long stateVersion) {
    this.stateVersion = stateVersion;
    return this;
  }

   /**
   * An integer between &#x60;1&#x60; and &#x60;10^13&#x60;, giving the resultant state version after the transaction has been committed
   * minimum: 1
   * maximum: 100000000000000
   * @return stateVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `1` and `10^13`, giving the resultant state version after the transaction has been committed")
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


  public LtsCommittedTransactionOutcome accumulatorHash(String accumulatorHash) {
    this.accumulatorHash = accumulatorHash;
    return this;
  }

   /**
   * The hex-encoded transaction accumulator hash. This hash captures the order of all transactions on ledger. This hash is &#x60;ACC_{N+1} &#x3D; combine(ACC_N, LEDGER_HASH_{N}))&#x60; (where &#x60;combine()&#x60; is an arbitrary deterministic function we use). 
   * @return accumulatorHash
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The hex-encoded transaction accumulator hash. This hash captures the order of all transactions on ledger. This hash is `ACC_{N+1} = combine(ACC_N, LEDGER_HASH_{N}))` (where `combine()` is an arbitrary deterministic function we use). ")
  @JsonProperty(JSON_PROPERTY_ACCUMULATOR_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAccumulatorHash() {
    return accumulatorHash;
  }


  @JsonProperty(JSON_PROPERTY_ACCUMULATOR_HASH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAccumulatorHash(String accumulatorHash) {
    this.accumulatorHash = accumulatorHash;
  }


  public LtsCommittedTransactionOutcome userTransactionIdentifiers(TransactionIdentifiers userTransactionIdentifiers) {
    this.userTransactionIdentifiers = userTransactionIdentifiers;
    return this;
  }

   /**
   * Get userTransactionIdentifiers
   * @return userTransactionIdentifiers
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_USER_TRANSACTION_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TransactionIdentifiers getUserTransactionIdentifiers() {
    return userTransactionIdentifiers;
  }


  @JsonProperty(JSON_PROPERTY_USER_TRANSACTION_IDENTIFIERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUserTransactionIdentifiers(TransactionIdentifiers userTransactionIdentifiers) {
    this.userTransactionIdentifiers = userTransactionIdentifiers;
  }


  public LtsCommittedTransactionOutcome status(LtsCommittedTransactionStatus status) {
    this.status = status;
    return this;
  }

   /**
   * Get status
   * @return status
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public LtsCommittedTransactionStatus getStatus() {
    return status;
  }


  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(LtsCommittedTransactionStatus status) {
    this.status = status;
  }


  public LtsCommittedTransactionOutcome fungibleEntityBalanceChanges(List<LtsEntityFungibleBalanceChanges> fungibleEntityBalanceChanges) {
    this.fungibleEntityBalanceChanges = fungibleEntityBalanceChanges;
    return this;
  }

  public LtsCommittedTransactionOutcome addFungibleEntityBalanceChangesItem(LtsEntityFungibleBalanceChanges fungibleEntityBalanceChangesItem) {
    this.fungibleEntityBalanceChanges.add(fungibleEntityBalanceChangesItem);
    return this;
  }

   /**
   * THE FEE ASSIGNMENT IS NOT CURRENTLY FULLY ACCURATE FOR SOME TRANSACTIONS. THIS WILL BE FIXED AT RCNET-V2. A list of all fungible balance updates which occurred in this transaction, aggregated by the global entity (such as account) which owns the vaults which were updated. 
   * @return fungibleEntityBalanceChanges
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "THE FEE ASSIGNMENT IS NOT CURRENTLY FULLY ACCURATE FOR SOME TRANSACTIONS. THIS WILL BE FIXED AT RCNET-V2. A list of all fungible balance updates which occurred in this transaction, aggregated by the global entity (such as account) which owns the vaults which were updated. ")
  @JsonProperty(JSON_PROPERTY_FUNGIBLE_ENTITY_BALANCE_CHANGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<LtsEntityFungibleBalanceChanges> getFungibleEntityBalanceChanges() {
    return fungibleEntityBalanceChanges;
  }


  @JsonProperty(JSON_PROPERTY_FUNGIBLE_ENTITY_BALANCE_CHANGES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setFungibleEntityBalanceChanges(List<LtsEntityFungibleBalanceChanges> fungibleEntityBalanceChanges) {
    this.fungibleEntityBalanceChanges = fungibleEntityBalanceChanges;
  }


  public LtsCommittedTransactionOutcome resultantAccountFungibleBalances(List<LtsResultantAccountFungibleBalances> resultantAccountFungibleBalances) {
    this.resultantAccountFungibleBalances = resultantAccountFungibleBalances;
    return this;
  }

  public LtsCommittedTransactionOutcome addResultantAccountFungibleBalancesItem(LtsResultantAccountFungibleBalances resultantAccountFungibleBalancesItem) {
    this.resultantAccountFungibleBalances.add(resultantAccountFungibleBalancesItem);
    return this;
  }

   /**
   * THIS CURRENTLY RETURNS AN EMPTY LIST. THIS FEATURE WILL BE COMING AT RCNET-V2. A list of the resultant balances of any account balances changed in this transaction. Only balances for accounts are returned, not any other kind of entity. 
   * @return resultantAccountFungibleBalances
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "THIS CURRENTLY RETURNS AN EMPTY LIST. THIS FEATURE WILL BE COMING AT RCNET-V2. A list of the resultant balances of any account balances changed in this transaction. Only balances for accounts are returned, not any other kind of entity. ")
  @JsonProperty(JSON_PROPERTY_RESULTANT_ACCOUNT_FUNGIBLE_BALANCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<LtsResultantAccountFungibleBalances> getResultantAccountFungibleBalances() {
    return resultantAccountFungibleBalances;
  }


  @JsonProperty(JSON_PROPERTY_RESULTANT_ACCOUNT_FUNGIBLE_BALANCES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setResultantAccountFungibleBalances(List<LtsResultantAccountFungibleBalances> resultantAccountFungibleBalances) {
    this.resultantAccountFungibleBalances = resultantAccountFungibleBalances;
  }


  public LtsCommittedTransactionOutcome totalFee(String totalFee) {
    this.totalFee = totalFee;
    return this;
  }

   /**
   * The string-encoded decimal representing the total amount of XRD payed as fee (execution, validator tip and royalties). A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(256 - 1) &lt;&#x3D; m &lt; 2^(256 - 1)&#x60;. 
   * @return totalFee
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The string-encoded decimal representing the total amount of XRD payed as fee (execution, validator tip and royalties). A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(256 - 1) <= m < 2^(256 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TOTAL_FEE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTotalFee() {
    return totalFee;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_FEE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalFee(String totalFee) {
    this.totalFee = totalFee;
  }


  /**
   * Return true if this LtsCommittedTransactionOutcome object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LtsCommittedTransactionOutcome ltsCommittedTransactionOutcome = (LtsCommittedTransactionOutcome) o;
    return Objects.equals(this.stateVersion, ltsCommittedTransactionOutcome.stateVersion) &&
        Objects.equals(this.accumulatorHash, ltsCommittedTransactionOutcome.accumulatorHash) &&
        Objects.equals(this.userTransactionIdentifiers, ltsCommittedTransactionOutcome.userTransactionIdentifiers) &&
        Objects.equals(this.status, ltsCommittedTransactionOutcome.status) &&
        Objects.equals(this.fungibleEntityBalanceChanges, ltsCommittedTransactionOutcome.fungibleEntityBalanceChanges) &&
        Objects.equals(this.resultantAccountFungibleBalances, ltsCommittedTransactionOutcome.resultantAccountFungibleBalances) &&
        Objects.equals(this.totalFee, ltsCommittedTransactionOutcome.totalFee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateVersion, accumulatorHash, userTransactionIdentifiers, status, fungibleEntityBalanceChanges, resultantAccountFungibleBalances, totalFee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LtsCommittedTransactionOutcome {\n");
    sb.append("    stateVersion: ").append(toIndentedString(stateVersion)).append("\n");
    sb.append("    accumulatorHash: ").append(toIndentedString(accumulatorHash)).append("\n");
    sb.append("    userTransactionIdentifiers: ").append(toIndentedString(userTransactionIdentifiers)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    fungibleEntityBalanceChanges: ").append(toIndentedString(fungibleEntityBalanceChanges)).append("\n");
    sb.append("    resultantAccountFungibleBalances: ").append(toIndentedString(resultantAccountFungibleBalances)).append("\n");
    sb.append("    totalFee: ").append(toIndentedString(totalFee)).append("\n");
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

