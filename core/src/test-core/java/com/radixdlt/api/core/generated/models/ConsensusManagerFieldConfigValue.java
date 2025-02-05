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
import com.radixdlt.api.core.generated.models.EpochChangeCondition;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * ConsensusManagerFieldConfigValue
 */
@JsonPropertyOrder({
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_MAX_VALIDATORS,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_EPOCH_CHANGE_CONDITION,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_NUM_UNSTAKE_EPOCHS,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_VALIDATOR_CREATION_USD_EQUIVALENT_COST,
  ConsensusManagerFieldConfigValue.JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class ConsensusManagerFieldConfigValue {
  public static final String JSON_PROPERTY_MAX_VALIDATORS = "max_validators";
  private Long maxValidators;

  public static final String JSON_PROPERTY_EPOCH_CHANGE_CONDITION = "epoch_change_condition";
  private EpochChangeCondition epochChangeCondition;

  public static final String JSON_PROPERTY_NUM_UNSTAKE_EPOCHS = "num_unstake_epochs";
  private Long numUnstakeEpochs;

  public static final String JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH = "total_emission_xrd_per_epoch";
  private String totalEmissionXrdPerEpoch;

  public static final String JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY = "min_validator_reliability";
  private String minValidatorReliability;

  public static final String JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS = "num_owner_stake_units_unlock_epochs";
  private Long numOwnerStakeUnitsUnlockEpochs;

  public static final String JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS = "num_fee_increase_delay_epochs";
  private Long numFeeIncreaseDelayEpochs;

  public static final String JSON_PROPERTY_VALIDATOR_CREATION_USD_EQUIVALENT_COST = "validator_creation_usd_equivalent_cost";
  private String validatorCreationUsdEquivalentCost;

  public static final String JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST = "validator_creation_xrd_cost";
  private String validatorCreationXrdCost;

  public ConsensusManagerFieldConfigValue() { 
  }

  public ConsensusManagerFieldConfigValue maxValidators(Long maxValidators) {
    this.maxValidators = maxValidators;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the maximum number of validators in the active validator set. 
   * minimum: 0
   * maximum: 10000000000
   * @return maxValidators
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the maximum number of validators in the active validator set. ")
  @JsonProperty(JSON_PROPERTY_MAX_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getMaxValidators() {
    return maxValidators;
  }


  @JsonProperty(JSON_PROPERTY_MAX_VALIDATORS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMaxValidators(Long maxValidators) {
    this.maxValidators = maxValidators;
  }


  public ConsensusManagerFieldConfigValue epochChangeCondition(EpochChangeCondition epochChangeCondition) {
    this.epochChangeCondition = epochChangeCondition;
    return this;
  }

   /**
   * Get epochChangeCondition
   * @return epochChangeCondition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EPOCH_CHANGE_CONDITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EpochChangeCondition getEpochChangeCondition() {
    return epochChangeCondition;
  }


  @JsonProperty(JSON_PROPERTY_EPOCH_CHANGE_CONDITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpochChangeCondition(EpochChangeCondition epochChangeCondition) {
    this.epochChangeCondition = epochChangeCondition;
  }


  public ConsensusManagerFieldConfigValue numUnstakeEpochs(Long numUnstakeEpochs) {
    this.numUnstakeEpochs = numUnstakeEpochs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of epochs before an unstaker can withdraw their XRD. 
   * minimum: 0
   * maximum: 10000000000
   * @return numUnstakeEpochs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of epochs before an unstaker can withdraw their XRD. ")
  @JsonProperty(JSON_PROPERTY_NUM_UNSTAKE_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumUnstakeEpochs() {
    return numUnstakeEpochs;
  }


  @JsonProperty(JSON_PROPERTY_NUM_UNSTAKE_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumUnstakeEpochs(Long numUnstakeEpochs) {
    this.numUnstakeEpochs = numUnstakeEpochs;
  }


  public ConsensusManagerFieldConfigValue totalEmissionXrdPerEpoch(String totalEmissionXrdPerEpoch) {
    this.totalEmissionXrdPerEpoch = totalEmissionXrdPerEpoch;
    return this;
  }

   /**
   * A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return totalEmissionXrdPerEpoch
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getTotalEmissionXrdPerEpoch() {
    return totalEmissionXrdPerEpoch;
  }


  @JsonProperty(JSON_PROPERTY_TOTAL_EMISSION_XRD_PER_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTotalEmissionXrdPerEpoch(String totalEmissionXrdPerEpoch) {
    this.totalEmissionXrdPerEpoch = totalEmissionXrdPerEpoch;
  }


  public ConsensusManagerFieldConfigValue minValidatorReliability(String minValidatorReliability) {
    this.minValidatorReliability = minValidatorReliability;
    return this;
  }

   /**
   * A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return minValidatorReliability
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A string-encoded fixed-precision decimal to 18 decimal places. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getMinValidatorReliability() {
    return minValidatorReliability;
  }


  @JsonProperty(JSON_PROPERTY_MIN_VALIDATOR_RELIABILITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMinValidatorReliability(String minValidatorReliability) {
    this.minValidatorReliability = minValidatorReliability;
  }


  public ConsensusManagerFieldConfigValue numOwnerStakeUnitsUnlockEpochs(Long numOwnerStakeUnitsUnlockEpochs) {
    this.numOwnerStakeUnitsUnlockEpochs = numOwnerStakeUnitsUnlockEpochs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of epochs before an owner can take their stake units after attempting to withdraw them. 
   * minimum: 0
   * maximum: 10000000000
   * @return numOwnerStakeUnitsUnlockEpochs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of epochs before an owner can take their stake units after attempting to withdraw them. ")
  @JsonProperty(JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumOwnerStakeUnitsUnlockEpochs() {
    return numOwnerStakeUnitsUnlockEpochs;
  }


  @JsonProperty(JSON_PROPERTY_NUM_OWNER_STAKE_UNITS_UNLOCK_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumOwnerStakeUnitsUnlockEpochs(Long numOwnerStakeUnitsUnlockEpochs) {
    this.numOwnerStakeUnitsUnlockEpochs = numOwnerStakeUnitsUnlockEpochs;
  }


  public ConsensusManagerFieldConfigValue numFeeIncreaseDelayEpochs(Long numFeeIncreaseDelayEpochs) {
    this.numFeeIncreaseDelayEpochs = numFeeIncreaseDelayEpochs;
    return this;
  }

   /**
   * An integer between &#x60;0&#x60; and &#x60;10^10&#x60;, specifying the minimum number of epochs before a fee increase takes effect. 
   * minimum: 0
   * maximum: 10000000000
   * @return numFeeIncreaseDelayEpochs
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "An integer between `0` and `10^10`, specifying the minimum number of epochs before a fee increase takes effect. ")
  @JsonProperty(JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getNumFeeIncreaseDelayEpochs() {
    return numFeeIncreaseDelayEpochs;
  }


  @JsonProperty(JSON_PROPERTY_NUM_FEE_INCREASE_DELAY_EPOCHS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setNumFeeIncreaseDelayEpochs(Long numFeeIncreaseDelayEpochs) {
    this.numFeeIncreaseDelayEpochs = numFeeIncreaseDelayEpochs;
  }


  public ConsensusManagerFieldConfigValue validatorCreationUsdEquivalentCost(String validatorCreationUsdEquivalentCost) {
    this.validatorCreationUsdEquivalentCost = validatorCreationUsdEquivalentCost;
    return this;
  }

   /**
   * The defining decimal cost of a validator in USD. This is turned into an XRD cost through the current protocol-based USD/XRD multiplier. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return validatorCreationUsdEquivalentCost
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The defining decimal cost of a validator in USD. This is turned into an XRD cost through the current protocol-based USD/XRD multiplier. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_CREATION_USD_EQUIVALENT_COST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValidatorCreationUsdEquivalentCost() {
    return validatorCreationUsdEquivalentCost;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_CREATION_USD_EQUIVALENT_COST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidatorCreationUsdEquivalentCost(String validatorCreationUsdEquivalentCost) {
    this.validatorCreationUsdEquivalentCost = validatorCreationUsdEquivalentCost;
  }


  public ConsensusManagerFieldConfigValue validatorCreationXrdCost(String validatorCreationXrdCost) {
    this.validatorCreationXrdCost = validatorCreationXrdCost;
    return this;
  }

   /**
   * The decimal amount of XRD required to be passed in a bucket to create a validator. A decimal is formed of some signed integer &#x60;m&#x60; of attos (&#x60;10^(-18)&#x60;) units, where &#x60;-2^(192 - 1) &lt;&#x3D; m &lt; 2^(192 - 1)&#x60;. 
   * @return validatorCreationXrdCost
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The decimal amount of XRD required to be passed in a bucket to create a validator. A decimal is formed of some signed integer `m` of attos (`10^(-18)`) units, where `-2^(192 - 1) <= m < 2^(192 - 1)`. ")
  @JsonProperty(JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getValidatorCreationXrdCost() {
    return validatorCreationXrdCost;
  }


  @JsonProperty(JSON_PROPERTY_VALIDATOR_CREATION_XRD_COST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setValidatorCreationXrdCost(String validatorCreationXrdCost) {
    this.validatorCreationXrdCost = validatorCreationXrdCost;
  }


  /**
   * Return true if this ConsensusManagerFieldConfigValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsensusManagerFieldConfigValue consensusManagerFieldConfigValue = (ConsensusManagerFieldConfigValue) o;
    return Objects.equals(this.maxValidators, consensusManagerFieldConfigValue.maxValidators) &&
        Objects.equals(this.epochChangeCondition, consensusManagerFieldConfigValue.epochChangeCondition) &&
        Objects.equals(this.numUnstakeEpochs, consensusManagerFieldConfigValue.numUnstakeEpochs) &&
        Objects.equals(this.totalEmissionXrdPerEpoch, consensusManagerFieldConfigValue.totalEmissionXrdPerEpoch) &&
        Objects.equals(this.minValidatorReliability, consensusManagerFieldConfigValue.minValidatorReliability) &&
        Objects.equals(this.numOwnerStakeUnitsUnlockEpochs, consensusManagerFieldConfigValue.numOwnerStakeUnitsUnlockEpochs) &&
        Objects.equals(this.numFeeIncreaseDelayEpochs, consensusManagerFieldConfigValue.numFeeIncreaseDelayEpochs) &&
        Objects.equals(this.validatorCreationUsdEquivalentCost, consensusManagerFieldConfigValue.validatorCreationUsdEquivalentCost) &&
        Objects.equals(this.validatorCreationXrdCost, consensusManagerFieldConfigValue.validatorCreationXrdCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxValidators, epochChangeCondition, numUnstakeEpochs, totalEmissionXrdPerEpoch, minValidatorReliability, numOwnerStakeUnitsUnlockEpochs, numFeeIncreaseDelayEpochs, validatorCreationUsdEquivalentCost, validatorCreationXrdCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsensusManagerFieldConfigValue {\n");
    sb.append("    maxValidators: ").append(toIndentedString(maxValidators)).append("\n");
    sb.append("    epochChangeCondition: ").append(toIndentedString(epochChangeCondition)).append("\n");
    sb.append("    numUnstakeEpochs: ").append(toIndentedString(numUnstakeEpochs)).append("\n");
    sb.append("    totalEmissionXrdPerEpoch: ").append(toIndentedString(totalEmissionXrdPerEpoch)).append("\n");
    sb.append("    minValidatorReliability: ").append(toIndentedString(minValidatorReliability)).append("\n");
    sb.append("    numOwnerStakeUnitsUnlockEpochs: ").append(toIndentedString(numOwnerStakeUnitsUnlockEpochs)).append("\n");
    sb.append("    numFeeIncreaseDelayEpochs: ").append(toIndentedString(numFeeIncreaseDelayEpochs)).append("\n");
    sb.append("    validatorCreationUsdEquivalentCost: ").append(toIndentedString(validatorCreationUsdEquivalentCost)).append("\n");
    sb.append("    validatorCreationXrdCost: ").append(toIndentedString(validatorCreationXrdCost)).append("\n");
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

