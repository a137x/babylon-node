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
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * UnknownReportedPendingProtocolUpdate
 */
@JsonPropertyOrder({
  UnknownReportedPendingProtocolUpdate.JSON_PROPERTY_PROTOCOL_VERSION,
  UnknownReportedPendingProtocolUpdate.JSON_PROPERTY_REPORTED_BY_NODE_ADDRESSES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UnknownReportedPendingProtocolUpdate {
  public static final String JSON_PROPERTY_PROTOCOL_VERSION = "protocol_version";
  private String protocolVersion;

  public static final String JSON_PROPERTY_REPORTED_BY_NODE_ADDRESSES = "reported_by_node_addresses";
  private List<String> reportedByNodeAddresses = null;


  public UnknownReportedPendingProtocolUpdate protocolVersion(String protocolVersion) {
    this.protocolVersion = protocolVersion;
    return this;
  }

   /**
   * A name identifying a protocol version.
   * @return protocolVersion
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "A name identifying a protocol version.")
  @JsonProperty(JSON_PROPERTY_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getProtocolVersion() {
    return protocolVersion;
  }


  @JsonProperty(JSON_PROPERTY_PROTOCOL_VERSION)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setProtocolVersion(String protocolVersion) {
    this.protocolVersion = protocolVersion;
  }


  public UnknownReportedPendingProtocolUpdate reportedByNodeAddresses(List<String> reportedByNodeAddresses) {
    this.reportedByNodeAddresses = reportedByNodeAddresses;
    return this;
  }

  public UnknownReportedPendingProtocolUpdate addReportedByNodeAddressesItem(String reportedByNodeAddressesItem) {
    if (this.reportedByNodeAddresses == null) {
      this.reportedByNodeAddresses = new ArrayList<>();
    }
    this.reportedByNodeAddresses.add(reportedByNodeAddressesItem);
    return this;
  }

   /**
   * Get reportedByNodeAddresses
   * @return reportedByNodeAddresses
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_REPORTED_BY_NODE_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<String> getReportedByNodeAddresses() {
    return reportedByNodeAddresses;
  }


  @JsonProperty(JSON_PROPERTY_REPORTED_BY_NODE_ADDRESSES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReportedByNodeAddresses(List<String> reportedByNodeAddresses) {
    this.reportedByNodeAddresses = reportedByNodeAddresses;
  }


  /**
   * Return true if this UnknownReportedPendingProtocolUpdate object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnknownReportedPendingProtocolUpdate unknownReportedPendingProtocolUpdate = (UnknownReportedPendingProtocolUpdate) o;
    return Objects.equals(this.protocolVersion, unknownReportedPendingProtocolUpdate.protocolVersion) &&
        Objects.equals(this.reportedByNodeAddresses, unknownReportedPendingProtocolUpdate.reportedByNodeAddresses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(protocolVersion, reportedByNodeAddresses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnknownReportedPendingProtocolUpdate {\n");
    sb.append("    protocolVersion: ").append(toIndentedString(protocolVersion)).append("\n");
    sb.append("    reportedByNodeAddresses: ").append(toIndentedString(reportedByNodeAddresses)).append("\n");
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

