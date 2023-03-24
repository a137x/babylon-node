/*
 * Babylon Core API
 * This API is exposed by the Babylon Radix node to give clients access to the Radix Engine, Mempool and State in the node. It is intended for use by node-runners on a private network, and is not intended to be exposed publicly. Heavy load may impact the node's function.  If you require queries against historical ledger state, you may also wish to consider using the [Gateway API](https://betanet-gateway.redoc.ly/). 
 *
 * The version of the OpenAPI document: 0.3.0
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
import com.radixdlt.api.core.generated.models.EntityReference;
import com.radixdlt.api.core.generated.models.EventEmitterIdentifier;
import com.radixdlt.api.core.generated.models.EventEmitterIdentifierType;
import com.radixdlt.api.core.generated.models.FunctionEventEmitterIdentifier;
import com.radixdlt.api.core.generated.models.FunctionEventEmitterIdentifierAllOf;
import com.radixdlt.api.core.generated.models.MethodEventEmitterIdentifier;
import com.radixdlt.api.core.generated.models.ModuleType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.radixdlt.api.core.generated.client.JSON;
/**
 * FunctionEventEmitterIdentifier
 */
@JsonPropertyOrder({
  FunctionEventEmitterIdentifier.JSON_PROPERTY_ENTITY,
  FunctionEventEmitterIdentifier.JSON_PROPERTY_MODULE_TYPE,
  FunctionEventEmitterIdentifier.JSON_PROPERTY_BLUEPRINT_NAME
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonIgnoreProperties(
  value = "type", // ignore manually set type, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the type to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = FunctionEventEmitterIdentifier.class, name = "Function"),
  @JsonSubTypes.Type(value = MethodEventEmitterIdentifier.class, name = "Method"),
})

public class FunctionEventEmitterIdentifier extends EventEmitterIdentifier {
  public static final String JSON_PROPERTY_ENTITY = "entity";
  private EntityReference entity;

  public static final String JSON_PROPERTY_MODULE_TYPE = "module_type";
  private ModuleType moduleType;

  public static final String JSON_PROPERTY_BLUEPRINT_NAME = "blueprint_name";
  private String blueprintName;

  public FunctionEventEmitterIdentifier() { 
  }

  public FunctionEventEmitterIdentifier entity(EntityReference entity) {
    this.entity = entity;
    return this;
  }

   /**
   * Get entity
   * @return entity
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_ENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public EntityReference getEntity() {
    return entity;
  }


  @JsonProperty(JSON_PROPERTY_ENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setEntity(EntityReference entity) {
    this.entity = entity;
  }


  public FunctionEventEmitterIdentifier moduleType(ModuleType moduleType) {
    this.moduleType = moduleType;
    return this;
  }

   /**
   * Get moduleType
   * @return moduleType
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_MODULE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public ModuleType getModuleType() {
    return moduleType;
  }


  @JsonProperty(JSON_PROPERTY_MODULE_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setModuleType(ModuleType moduleType) {
    this.moduleType = moduleType;
  }


  public FunctionEventEmitterIdentifier blueprintName(String blueprintName) {
    this.blueprintName = blueprintName;
    return this;
  }

   /**
   * Blueprint name.
   * @return blueprintName
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "Blueprint name.")
  @JsonProperty(JSON_PROPERTY_BLUEPRINT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public String getBlueprintName() {
    return blueprintName;
  }


  @JsonProperty(JSON_PROPERTY_BLUEPRINT_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setBlueprintName(String blueprintName) {
    this.blueprintName = blueprintName;
  }


  /**
   * Return true if this FunctionEventEmitterIdentifier object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FunctionEventEmitterIdentifier functionEventEmitterIdentifier = (FunctionEventEmitterIdentifier) o;
    return Objects.equals(this.entity, functionEventEmitterIdentifier.entity) &&
        Objects.equals(this.moduleType, functionEventEmitterIdentifier.moduleType) &&
        Objects.equals(this.blueprintName, functionEventEmitterIdentifier.blueprintName) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(entity, moduleType, blueprintName, super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FunctionEventEmitterIdentifier {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    sb.append("    moduleType: ").append(toIndentedString(moduleType)).append("\n");
    sb.append("    blueprintName: ").append(toIndentedString(blueprintName)).append("\n");
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
  mappings.put("Function", FunctionEventEmitterIdentifier.class);
  mappings.put("Method", MethodEventEmitterIdentifier.class);
  mappings.put("FunctionEventEmitterIdentifier", FunctionEventEmitterIdentifier.class);
  JSON.registerDiscriminator(FunctionEventEmitterIdentifier.class, "type", mappings);
}
}

