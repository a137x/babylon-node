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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AllOfProofRule;
import com.radixdlt.api.core.generated.models.AllOfProofRuleAllOf;
import com.radixdlt.api.core.generated.models.AmountOfProofRule;
import com.radixdlt.api.core.generated.models.AnyOfProofRule;
import com.radixdlt.api.core.generated.models.CountOfProofRule;
import com.radixdlt.api.core.generated.models.ProofRule;
import com.radixdlt.api.core.generated.models.ProofRuleType;
import com.radixdlt.api.core.generated.models.RequireProofRule;
import com.radixdlt.api.core.generated.models.ResourceOrNonFungible;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * AllOfProofRule
 */
@JsonPropertyOrder({
  AllOfProofRule.JSON_PROPERTY_LIST
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = AllOfProofRule.class, name = "AllOf"),
  @JsonSubTypes.Type(value = AmountOfProofRule.class, name = "AmountOf"),
  @JsonSubTypes.Type(value = AnyOfProofRule.class, name = "AnyOf"),
  @JsonSubTypes.Type(value = CountOfProofRule.class, name = "CountOf"),
  @JsonSubTypes.Type(value = RequireProofRule.class, name = "Require"),
})

public class AllOfProofRule extends ProofRule {
  public static final String JSON_PROPERTY_LIST = "list";
  private List<ResourceOrNonFungible> _list = new ArrayList<>();

  public AllOfProofRule() { 
  }

  public AllOfProofRule _list(List<ResourceOrNonFungible> _list) {
    this._list = _list;
    return this;
  }

  public AllOfProofRule addListItem(ResourceOrNonFungible _listItem) {
    this._list.add(_listItem);
    return this;
  }

   /**
   * Get _list
   * @return _list
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public List<ResourceOrNonFungible> getList() {
    return _list;
  }


  @JsonProperty(JSON_PROPERTY_LIST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setList(List<ResourceOrNonFungible> _list) {
    this._list = _list;
  }


  /**
   * Return true if this AllOfProofRule object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AllOfProofRule allOfProofRule = (AllOfProofRule) o;
    return Objects.equals(this._list, allOfProofRule._list) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_list, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AllOfProofRule {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    _list: ").append(toIndentedString(_list)).append("\n");
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

static {
  // Initialize and register the discriminator mappings.
  Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
  mappings.put("AllOf", AllOfProofRule.class);
  mappings.put("AmountOf", AmountOfProofRule.class);
  mappings.put("AnyOf", AnyOfProofRule.class);
  mappings.put("CountOf", CountOfProofRule.class);
  mappings.put("Require", RequireProofRule.class);
  mappings.put("AllOfProofRule", AllOfProofRule.class);
  JSON.registerDiscriminator(AllOfProofRule.class, "type", mappings);
}
}

