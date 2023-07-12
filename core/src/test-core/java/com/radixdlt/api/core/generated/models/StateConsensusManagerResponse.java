/*
 * Babylon Core API - RCnet V2
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Very heavy load may impact the node's function.  This API exposes queries against the node's current state (see `/lts/state/` or `/state/`), and streams of transaction history (under `/lts/stream/` or `/stream`).  If you require queries against snapshots of historical ledger state, you may also wish to consider using the [Gateway API](https://docs-babylon.radixdlt.com/).  ## Integration and forward compatibility guarantees  This version of the Core API belongs to the second release candidate of the Radix Babylon network (\"RCnet v2\").  Integrators (such as exchanges) are recommended to use the `/lts/` endpoints - they have been designed to be clear and simple for integrators wishing to create and monitor transactions involving fungible transfers to/from accounts.  All endpoints under `/lts/` are guaranteed to be forward compatible to Babylon mainnet launch (and beyond). We may add new fields, but existing fields will not be changed. Assuming the integrating code uses a permissive JSON parser which ignores unknown fields, any additions will not affect existing code.  We give no guarantees that other endpoints will not change before Babylon mainnet launch, although changes are expected to be minimal. 
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
import com.radixdlt.api.core.generated.models.Substate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StateConsensusManagerResponse
 */
@JsonPropertyOrder({
  StateConsensusManagerResponse.JSON_PROPERTY_CONFIG,
  StateConsensusManagerResponse.JSON_PROPERTY_STATE,
  StateConsensusManagerResponse.JSON_PROPERTY_CURRENT_PROPOSAL_STATISTIC,
  StateConsensusManagerResponse.JSON_PROPERTY_CURRENT_VALIDATOR_SET,
  StateConsensusManagerResponse.JSON_PROPERTY_CURRENT_TIME,
  StateConsensusManagerResponse.JSON_PROPERTY_CURRENT_TIME_ROUNDED_TO_MINUTES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StateConsensusManagerResponse {
  public static final String JSON_PROPERTY_CONFIG = "config";
  private Substate config;

  public static final String JSON_PROPERTY_STATE = "state";
  private Substate state;

  public static final String JSON_PROPERTY_CURRENT_PROPOSAL_STATISTIC = "current_proposal_statistic";
  private Substate currentProposalStatistic;

  public static final String JSON_PROPERTY_CURRENT_VALIDATOR_SET = "current_validator_set";
  private Substate currentValidatorSet;

  public static final String JSON_PROPERTY_CURRENT_TIME = "current_time";
  private Substate currentTime;

  public static final String JSON_PROPERTY_CURRENT_TIME_ROUNDED_TO_MINUTES = "current_time_rounded_to_minutes";
  private Substate currentTimeRoundedToMinutes;

  public StateConsensusManagerResponse() { 
  }

  public StateConsensusManagerResponse config(Substate config) {
    this.config = config;
    return this;
  }

   /**
   * Get config
   * @return config
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getConfig() {
    return config;
  }


  @JsonProperty(JSON_PROPERTY_CONFIG)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setConfig(Substate config) {
    this.config = config;
  }


  public StateConsensusManagerResponse state(Substate state) {
    this.state = state;
    return this;
  }

   /**
   * Get state
   * @return state
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getState() {
    return state;
  }


  @JsonProperty(JSON_PROPERTY_STATE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setState(Substate state) {
    this.state = state;
  }


  public StateConsensusManagerResponse currentProposalStatistic(Substate currentProposalStatistic) {
    this.currentProposalStatistic = currentProposalStatistic;
    return this;
  }

   /**
   * Get currentProposalStatistic
   * @return currentProposalStatistic
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_PROPOSAL_STATISTIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getCurrentProposalStatistic() {
    return currentProposalStatistic;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_PROPOSAL_STATISTIC)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentProposalStatistic(Substate currentProposalStatistic) {
    this.currentProposalStatistic = currentProposalStatistic;
  }


  public StateConsensusManagerResponse currentValidatorSet(Substate currentValidatorSet) {
    this.currentValidatorSet = currentValidatorSet;
    return this;
  }

   /**
   * Get currentValidatorSet
   * @return currentValidatorSet
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_VALIDATOR_SET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getCurrentValidatorSet() {
    return currentValidatorSet;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_VALIDATOR_SET)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentValidatorSet(Substate currentValidatorSet) {
    this.currentValidatorSet = currentValidatorSet;
  }


  public StateConsensusManagerResponse currentTime(Substate currentTime) {
    this.currentTime = currentTime;
    return this;
  }

   /**
   * Get currentTime
   * @return currentTime
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getCurrentTime() {
    return currentTime;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_TIME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentTime(Substate currentTime) {
    this.currentTime = currentTime;
  }


  public StateConsensusManagerResponse currentTimeRoundedToMinutes(Substate currentTimeRoundedToMinutes) {
    this.currentTimeRoundedToMinutes = currentTimeRoundedToMinutes;
    return this;
  }

   /**
   * Get currentTimeRoundedToMinutes
   * @return currentTimeRoundedToMinutes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_CURRENT_TIME_ROUNDED_TO_MINUTES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getCurrentTimeRoundedToMinutes() {
    return currentTimeRoundedToMinutes;
  }


  @JsonProperty(JSON_PROPERTY_CURRENT_TIME_ROUNDED_TO_MINUTES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrentTimeRoundedToMinutes(Substate currentTimeRoundedToMinutes) {
    this.currentTimeRoundedToMinutes = currentTimeRoundedToMinutes;
  }


  /**
   * Return true if this StateConsensusManagerResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateConsensusManagerResponse stateConsensusManagerResponse = (StateConsensusManagerResponse) o;
    return Objects.equals(this.config, stateConsensusManagerResponse.config) &&
        Objects.equals(this.state, stateConsensusManagerResponse.state) &&
        Objects.equals(this.currentProposalStatistic, stateConsensusManagerResponse.currentProposalStatistic) &&
        Objects.equals(this.currentValidatorSet, stateConsensusManagerResponse.currentValidatorSet) &&
        Objects.equals(this.currentTime, stateConsensusManagerResponse.currentTime) &&
        Objects.equals(this.currentTimeRoundedToMinutes, stateConsensusManagerResponse.currentTimeRoundedToMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, state, currentProposalStatistic, currentValidatorSet, currentTime, currentTimeRoundedToMinutes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateConsensusManagerResponse {\n");
    sb.append("    config: ").append(toIndentedString(config)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    currentProposalStatistic: ").append(toIndentedString(currentProposalStatistic)).append("\n");
    sb.append("    currentValidatorSet: ").append(toIndentedString(currentValidatorSet)).append("\n");
    sb.append("    currentTime: ").append(toIndentedString(currentTime)).append("\n");
    sb.append("    currentTimeRoundedToMinutes: ").append(toIndentedString(currentTimeRoundedToMinutes)).append("\n");
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

