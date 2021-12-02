/*
 * Radix Gateway API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.9.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.gateway.openapitools.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;


/**
 * TokenDeriveResponse
 */
@JsonPropertyOrder({
  TokenDeriveResponse.JSON_PROPERTY_TOKEN_IDENTIFIER
})
@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2021-12-02T13:05:33.365806-06:00[America/Chicago]")
public class TokenDeriveResponse {
  public static final String JSON_PROPERTY_TOKEN_IDENTIFIER = "token_identifier";
  private TokenIdentifier tokenIdentifier;


  public TokenDeriveResponse tokenIdentifier(TokenIdentifier tokenIdentifier) {
    this.tokenIdentifier = tokenIdentifier;
    return this;
  }

   /**
   * Get tokenIdentifier
   * @return tokenIdentifier
  **/
  @javax.annotation.Nonnull
  @ApiModelProperty(required = true, value = "")
  @JsonProperty(JSON_PROPERTY_TOKEN_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)

  public TokenIdentifier getTokenIdentifier() {
    return tokenIdentifier;
  }


  @JsonProperty(JSON_PROPERTY_TOKEN_IDENTIFIER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setTokenIdentifier(TokenIdentifier tokenIdentifier) {
    this.tokenIdentifier = tokenIdentifier;
  }


  /**
   * Return true if this TokenDeriveResponse object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TokenDeriveResponse tokenDeriveResponse = (TokenDeriveResponse) o;
    return Objects.equals(this.tokenIdentifier, tokenDeriveResponse.tokenIdentifier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenIdentifier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TokenDeriveResponse {\n");
    sb.append("    tokenIdentifier: ").append(toIndentedString(tokenIdentifier)).append("\n");
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

