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
import com.radixdlt.api.core.generated.models.StateComponentDescendentNode;
import com.radixdlt.api.core.generated.models.Substate;
import com.radixdlt.api.core.generated.models.VaultBalance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * StateValidatorResponse
 */
@JsonPropertyOrder({
  StateValidatorResponse.JSON_PROPERTY_ADDRESS,
  StateValidatorResponse.JSON_PROPERTY_STATE,
  StateValidatorResponse.JSON_PROPERTY_OWNER_ROLE,
  StateValidatorResponse.JSON_PROPERTY_VAULTS,
  StateValidatorResponse.JSON_PROPERTY_DESCENDENT_NODES
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class StateValidatorResponse {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  private String address;

  public static final String JSON_PROPERTY_STATE = "state";
  private Substate state;

  public static final String JSON_PROPERTY_OWNER_ROLE = "owner_role";
  private Substate ownerRole;

  public static final String JSON_PROPERTY_VAULTS = "vaults";
  private List<VaultBalance> vaults = new ArrayList<>();

  public static final String JSON_PROPERTY_DESCENDENT_NODES = "descendent_nodes";
  private List<StateComponentDescendentNode> descendentNodes = new ArrayList<>();

  public StateValidatorResponse() { 
  }

  public StateValidatorResponse address(String address) {
    this.address = address;
    return this;
  }

   /**
   * The Bech32m-encoded human readable version of the component address
   * @return address
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "The Bech32m-encoded human readable version of the component address")
  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getAddress() {
    return address;
  }


  @JsonProperty(JSON_PROPERTY_ADDRESS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAddress(String address) {
    this.address = address;
  }


  public StateValidatorResponse state(Substate state) {
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


  public StateValidatorResponse ownerRole(Substate ownerRole) {
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


  public StateValidatorResponse vaults(List<VaultBalance> vaults) {
    this.vaults = vaults;
    return this;
  }

  public StateValidatorResponse addVaultsItem(VaultBalance vaultsItem) {
    this.vaults.add(vaultsItem);
    return this;
  }

   /**
   * Any vaults owned directly or indirectly by the component
   * @return vaults
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any vaults owned directly or indirectly by the component")
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


  public StateValidatorResponse descendentNodes(List<StateComponentDescendentNode> descendentNodes) {
    this.descendentNodes = descendentNodes;
    return this;
  }

  public StateValidatorResponse addDescendentNodesItem(StateComponentDescendentNode descendentNodesItem) {
    this.descendentNodes.add(descendentNodesItem);
    return this;
  }

   /**
   * Any descendent nodes owned directly or indirectly by the component
   * @return descendentNodes
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Any descendent nodes owned directly or indirectly by the component")
  @JsonProperty(JSON_PROPERTY_DESCENDENT_NODES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<StateComponentDescendentNode> getDescendentNodes() {
    return descendentNodes;
  }


  @JsonProperty(JSON_PROPERTY_DESCENDENT_NODES)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDescendentNodes(List<StateComponentDescendentNode> descendentNodes) {
    this.descendentNodes = descendentNodes;
  }


  /**
   * Return true if this StateValidatorResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StateValidatorResponse stateValidatorResponse = (StateValidatorResponse) o;
    return Objects.equals(this.address, stateValidatorResponse.address) &&
        Objects.equals(this.state, stateValidatorResponse.state) &&
        Objects.equals(this.ownerRole, stateValidatorResponse.ownerRole) &&
        Objects.equals(this.vaults, stateValidatorResponse.vaults) &&
        Objects.equals(this.descendentNodes, stateValidatorResponse.descendentNodes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, state, ownerRole, vaults, descendentNodes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StateValidatorResponse {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    ownerRole: ").append(toIndentedString(ownerRole)).append("\n");
    sb.append("    vaults: ").append(toIndentedString(vaults)).append("\n");
    sb.append("    descendentNodes: ").append(toIndentedString(descendentNodes)).append("\n");
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

