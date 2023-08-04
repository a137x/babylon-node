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
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.VaultBalance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StateAccountResponse
 */
@JsonPropertyOrder({
  StateAccountResponse.JSON_PROPERTY_STATE_VERSION,
  StateAccountResponse.JSON_PROPERTY_INFO,
  StateAccountResponse.JSON_PROPERTY_OWNER_ROLE,
  StateAccountResponse.JSON_PROPERTY_STATE,
  StateAccountResponse.JSON_PROPERTY_VAULTS
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StateAccountResponse {
  public static final String JSON_PROPERTY_STATE_VERSION = "state_version";
  private Long stateVersion;

  public static final String JSON_PROPERTY_INFO = "info";
  private Substate info;

  public static final String JSON_PROPERTY_OWNER_ROLE = "owner_role";
  private Substate ownerRole;

  public static final String JSON_PROPERTY_STATE = "state";
  private Substate state;

  public static final String JSON_PROPERTY_VAULTS = "vaults";
  private List<VaultBalance> vaults = new ArrayList<>();

  public StateAccountResponse() { 
  }

  public StateAccountResponse stateVersion(Long stateVersion) {
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


  public StateAccountResponse info(Substate info) {
    this.info = info;
    return this;
  }

   /**
   * Get info
   * @return info
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getInfo() {
    return info;
  }


  @JsonProperty(JSON_PROPERTY_INFO)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setInfo(Substate info) {
    this.info = info;
  }


  public StateAccountResponse ownerRole(Substate ownerRole) {
    this.ownerRole = ownerRole;
    return this;
  }

   /**
   * Get ownerRole
   * @return ownerRole
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_OWNER_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public Substate getOwnerRole() {
    return ownerRole;
  }


  @JsonProperty(JSON_PROPERTY_OWNER_ROLE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setOwnerRole(Substate ownerRole) {
    this.ownerRole = ownerRole;
  }


  public StateAccountResponse state(Substate state) {
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


  public StateAccountResponse vaults(List<VaultBalance> vaults) {
    this.vaults = vaults;
    return this;
  }

  public StateAccountResponse addVaultsItem(VaultBalance vaultsItem) {
    this.vaults.add(vaultsItem);
    return this;
  }

   /**
   * All of the account&#39;s vaults
   * @return vaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "All of the account's vaults")
  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<VaultBalance> getVaults() {
    return vaults;
  }


  @JsonProperty(JSON_PROPERTY_VAULTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setVaults(List<VaultBalance> vaults) {
    this.vaults = vaults;
  }


  /**
   * Return true if this StateAccountResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateAccountResponse stateAccountResponse = (StateAccountResponse) o;
    return Objects.equals(this.stateVersion, stateAccountResponse.stateVersion) &&
        Objects.equals(this.info, stateAccountResponse.info) &&
        Objects.equals(this.ownerRole, stateAccountResponse.ownerRole) &&
        Objects.equals(this.state, stateAccountResponse.state) &&
        Objects.equals(this.vaults, stateAccountResponse.vaults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stateVersion, info, ownerRole, state, vaults);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateAccountResponse {\n");
    sb.append("    stateVersion: ").append(toIndentedString(stateVersion)).append("\n");
    sb.append("    info: ").append(toIndentedString(info)).append("\n");
    sb.append("    ownerRole: ").append(toIndentedString(ownerRole)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    vaults: ").append(toIndentedString(vaults)).append("\n");
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

