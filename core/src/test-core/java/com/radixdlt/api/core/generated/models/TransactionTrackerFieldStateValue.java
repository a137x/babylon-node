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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * TransactionTrackerFieldStateValue
 */
@JsonPropertyOrder({
  TransactionTrackerFieldStateValue.JSON_PROPERTY_START_EPOCH,
  TransactionTrackerFieldStateValue.JSON_PROPERTY_START_PARTITION,
  TransactionTrackerFieldStateValue.JSON_PROPERTY_PARTITION_RANGE_START_INCLUSIVE,
  TransactionTrackerFieldStateValue.JSON_PROPERTY_PARTITION_RANGE_END_INCLUSIVE,
  TransactionTrackerFieldStateValue.JSON_PROPERTY_EPOCHS_PER_PARTITION
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class TransactionTrackerFieldStateValue {
  public static final String JSON_PROPERTY_START_EPOCH = "start_epoch";
  private Long startEpoch;

  public static final String JSON_PROPERTY_START_PARTITION = "start_partition";
  private Integer startPartition;

  public static final String JSON_PROPERTY_PARTITION_RANGE_START_INCLUSIVE = "partition_range_start_inclusive";
  private Integer partitionRangeStartInclusive;

  public static final String JSON_PROPERTY_PARTITION_RANGE_END_INCLUSIVE = "partition_range_end_inclusive";
  private Integer partitionRangeEndInclusive;

  public static final String JSON_PROPERTY_EPOCHS_PER_PARTITION = "epochs_per_partition";
  private Long epochsPerPartition;

  public TransactionTrackerFieldStateValue() { 
  }

  public TransactionTrackerFieldStateValue startEpoch(Long startEpoch) {
    this.startEpoch = startEpoch;
    return this;
  }

   /**
   * Get startEpoch
   * minimum: 0
   * maximum: 10000000000
   * @return startEpoch
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_START_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getStartEpoch() {
    return startEpoch;
  }


  @JsonProperty(JSON_PROPERTY_START_EPOCH)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStartEpoch(Long startEpoch) {
    this.startEpoch = startEpoch;
  }


  public TransactionTrackerFieldStateValue startPartition(Integer startPartition) {
    this.startPartition = startPartition;
    return this;
  }

   /**
   * Get startPartition
   * minimum: 0
   * maximum: 255
   * @return startPartition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_START_PARTITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getStartPartition() {
    return startPartition;
  }


  @JsonProperty(JSON_PROPERTY_START_PARTITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStartPartition(Integer startPartition) {
    this.startPartition = startPartition;
  }


  public TransactionTrackerFieldStateValue partitionRangeStartInclusive(Integer partitionRangeStartInclusive) {
    this.partitionRangeStartInclusive = partitionRangeStartInclusive;
    return this;
  }

   /**
   * Get partitionRangeStartInclusive
   * minimum: 0
   * maximum: 255
   * @return partitionRangeStartInclusive
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PARTITION_RANGE_START_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getPartitionRangeStartInclusive() {
    return partitionRangeStartInclusive;
  }


  @JsonProperty(JSON_PROPERTY_PARTITION_RANGE_START_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPartitionRangeStartInclusive(Integer partitionRangeStartInclusive) {
    this.partitionRangeStartInclusive = partitionRangeStartInclusive;
  }


  public TransactionTrackerFieldStateValue partitionRangeEndInclusive(Integer partitionRangeEndInclusive) {
    this.partitionRangeEndInclusive = partitionRangeEndInclusive;
    return this;
  }

   /**
   * Get partitionRangeEndInclusive
   * minimum: 0
   * maximum: 255
   * @return partitionRangeEndInclusive
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_PARTITION_RANGE_END_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Integer getPartitionRangeEndInclusive() {
    return partitionRangeEndInclusive;
  }


  @JsonProperty(JSON_PROPERTY_PARTITION_RANGE_END_INCLUSIVE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPartitionRangeEndInclusive(Integer partitionRangeEndInclusive) {
    this.partitionRangeEndInclusive = partitionRangeEndInclusive;
  }


  public TransactionTrackerFieldStateValue epochsPerPartition(Long epochsPerPartition) {
    this.epochsPerPartition = epochsPerPartition;
    return this;
  }

   /**
   * Get epochsPerPartition
   * minimum: 0
   * maximum: 10000000000
   * @return epochsPerPartition
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_EPOCHS_PER_PARTITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getEpochsPerPartition() {
    return epochsPerPartition;
  }


  @JsonProperty(JSON_PROPERTY_EPOCHS_PER_PARTITION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEpochsPerPartition(Long epochsPerPartition) {
    this.epochsPerPartition = epochsPerPartition;
  }


  /**
   * Return true if this TransactionTrackerFieldStateValue object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransactionTrackerFieldStateValue transactionTrackerFieldStateValue = (TransactionTrackerFieldStateValue) o;
    return Objects.equals(this.startEpoch, transactionTrackerFieldStateValue.startEpoch) &&
        Objects.equals(this.startPartition, transactionTrackerFieldStateValue.startPartition) &&
        Objects.equals(this.partitionRangeStartInclusive, transactionTrackerFieldStateValue.partitionRangeStartInclusive) &&
        Objects.equals(this.partitionRangeEndInclusive, transactionTrackerFieldStateValue.partitionRangeEndInclusive) &&
        Objects.equals(this.epochsPerPartition, transactionTrackerFieldStateValue.epochsPerPartition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startEpoch, startPartition, partitionRangeStartInclusive, partitionRangeEndInclusive, epochsPerPartition);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransactionTrackerFieldStateValue {\n");
    sb.append("    startEpoch: ").append(toIndentedString(startEpoch)).append("\n");
    sb.append("    startPartition: ").append(toIndentedString(startPartition)).append("\n");
    sb.append("    partitionRangeStartInclusive: ").append(toIndentedString(partitionRangeStartInclusive)).append("\n");
    sb.append("    partitionRangeEndInclusive: ").append(toIndentedString(partitionRangeEndInclusive)).append("\n");
    sb.append("    epochsPerPartition: ").append(toIndentedString(epochsPerPartition)).append("\n");
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

