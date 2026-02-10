package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponseForResponseAlternationData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class SuccessResponseForResponseAlternationData {

  private Object responseHeaders;

  private Object modifiedResponse;

  private String scaRedirectUrl;

  /**
   * The SCA approach to be used (REDIRECT, EMBEDDED, DECOUPLED)
   */
  public enum ScaApproachEnum {
    REDIRECT("REDIRECT"),
    
    EMBEDDED("EMBEDDED"),
    
    DECOUPLED("DECOUPLED");

    private String value;

    ScaApproachEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ScaApproachEnum fromValue(String value) {
      for (ScaApproachEnum b : ScaApproachEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ScaApproachEnum scaApproach;

  public SuccessResponseForResponseAlternationData responseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
    return this;
  }

  /**
   * Headers to be included in the response.
   * @return responseHeaders
  */
  
  @Schema(name = "responseHeaders", description = "Headers to be included in the response.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("responseHeaders")
  public Object getResponseHeaders() {
    return responseHeaders;
  }

  public void setResponseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
  }

  public SuccessResponseForResponseAlternationData modifiedResponse(Object modifiedResponse) {
    this.modifiedResponse = modifiedResponse;
    return this;
  }

  /**
   * Generated custom response body
   * @return modifiedResponse
  */
  
  @Schema(name = "modifiedResponse", description = "Generated custom response body", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("modifiedResponse")
  public Object getModifiedResponse() {
    return modifiedResponse;
  }

  public void setModifiedResponse(Object modifiedResponse) {
    this.modifiedResponse = modifiedResponse;
  }

  public SuccessResponseForResponseAlternationData scaRedirectUrl(String scaRedirectUrl) {
    this.scaRedirectUrl = scaRedirectUrl;
    return this;
  }

  /**
   * URL to redirect to ASPSP SCA authorisation site for Strong Customer Authentication when using Redirect SCA Approach
   * @return scaRedirectUrl
  */
  
  @Schema(name = "scaRedirectUrl", description = "URL to redirect to ASPSP SCA authorisation site for Strong Customer Authentication when using Redirect SCA Approach", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("scaRedirectUrl")
  public String getScaRedirectUrl() {
    return scaRedirectUrl;
  }

  public void setScaRedirectUrl(String scaRedirectUrl) {
    this.scaRedirectUrl = scaRedirectUrl;
  }

  public SuccessResponseForResponseAlternationData scaApproach(ScaApproachEnum scaApproach) {
    this.scaApproach = scaApproach;
    return this;
  }

  /**
   * The SCA approach to be used (REDIRECT, EMBEDDED, DECOUPLED)
   * @return scaApproach
  */
  
  @Schema(name = "scaApproach", description = "The SCA approach to be used (REDIRECT, EMBEDDED, DECOUPLED)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("scaApproach")
  public ScaApproachEnum getScaApproach() {
    return scaApproach;
  }

  public void setScaApproach(ScaApproachEnum scaApproach) {
    this.scaApproach = scaApproach;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForResponseAlternationData successResponseForResponseAlternationData = (SuccessResponseForResponseAlternationData) o;
    return Objects.equals(this.responseHeaders, successResponseForResponseAlternationData.responseHeaders) &&
        Objects.equals(this.modifiedResponse, successResponseForResponseAlternationData.modifiedResponse) &&
        Objects.equals(this.scaRedirectUrl, successResponseForResponseAlternationData.scaRedirectUrl) &&
        Objects.equals(this.scaApproach, successResponseForResponseAlternationData.scaApproach);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeaders, modifiedResponse, scaRedirectUrl, scaApproach);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForResponseAlternationData {\n");
    sb.append("    responseHeaders: ").append(toIndentedString(responseHeaders)).append("\n");
    sb.append("    modifiedResponse: ").append(toIndentedString(modifiedResponse)).append("\n");
    sb.append("    scaRedirectUrl: ").append(toIndentedString(scaRedirectUrl)).append("\n");
    sb.append("    scaApproach: ").append(toIndentedString(scaApproach)).append("\n");
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

