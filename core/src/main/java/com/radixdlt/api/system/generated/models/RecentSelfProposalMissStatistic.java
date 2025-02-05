/*
 * Radix System API - Babylon
 * This API is exposed by the Babylon Radix node to give clients access to information about the node itself, its configuration, status and subsystems.  It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against ledger state, you may also wish to consider using the [Core API or Gateway API instead](https://docs-babylon.radixdlt.com/main/apis/api-specification.html). 
 *
 * The version of the OpenAPI document: v1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.system.generated.models;

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
 * RecentSelfProposalMissStatistic
 */
@JsonPropertyOrder({
  RecentSelfProposalMissStatistic.JSON_PROPERTY_MISSED_COUNT,
  RecentSelfProposalMissStatistic.JSON_PROPERTY_RECENT_PROPOSALS_TRACKED_COUNT
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RecentSelfProposalMissStatistic {
  public static final String JSON_PROPERTY_MISSED_COUNT = "missed_count";
  private Long missedCount;

  public static final String JSON_PROPERTY_RECENT_PROPOSALS_TRACKED_COUNT = "recent_proposals_tracked_count";
  private Long recentProposalsTrackedCount;


  public RecentSelfProposalMissStatistic missedCount(Long missedCount) {
    this.missedCount = missedCount;
    return this;
  }

   /**
   * A number of missed proposals among [&#x60;recent_proposals_tracked_count&#x60;] most recent ones.
   * minimum: 0
   * maximum: 4294967295
   * @return missedCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A number of missed proposals among [`recent_proposals_tracked_count`] most recent ones.")
  @JsonProperty(JSON_PROPERTY_MISSED_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getMissedCount() {
    return missedCount;
  }


  @JsonProperty(JSON_PROPERTY_MISSED_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setMissedCount(Long missedCount) {
    this.missedCount = missedCount;
  }


  public RecentSelfProposalMissStatistic recentProposalsTrackedCount(Long recentProposalsTrackedCount) {
    this.recentProposalsTrackedCount = recentProposalsTrackedCount;
    return this;
  }

   /**
   * A configured length of proposal miss tracking history.
   * minimum: 0
   * maximum: 4294967295
   * @return recentProposalsTrackedCount
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A configured length of proposal miss tracking history.")
  @JsonProperty(JSON_PROPERTY_RECENT_PROPOSALS_TRACKED_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Long getRecentProposalsTrackedCount() {
    return recentProposalsTrackedCount;
  }


  @JsonProperty(JSON_PROPERTY_RECENT_PROPOSALS_TRACKED_COUNT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecentProposalsTrackedCount(Long recentProposalsTrackedCount) {
    this.recentProposalsTrackedCount = recentProposalsTrackedCount;
  }


  /**
   * Return true if this RecentSelfProposalMissStatistic object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecentSelfProposalMissStatistic recentSelfProposalMissStatistic = (RecentSelfProposalMissStatistic) o;
    return Objects.equals(this.missedCount, recentSelfProposalMissStatistic.missedCount) &&
        Objects.equals(this.recentProposalsTrackedCount, recentSelfProposalMissStatistic.recentProposalsTrackedCount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(missedCount, recentProposalsTrackedCount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecentSelfProposalMissStatistic {\n");
    sb.append("    missedCount: ").append(toIndentedString(missedCount)).append("\n");
    sb.append("    recentProposalsTrackedCount: ").append(toIndentedString(recentProposalsTrackedCount)).append("\n");
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

