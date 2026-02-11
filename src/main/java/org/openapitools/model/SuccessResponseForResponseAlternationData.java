package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:36:18.697163376Z[Etc/UTC]")
public class SuccessResponseForResponseAlternationData {

  private Object responseHeaders;

  private Object modifiedResponse;

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
        Objects.equals(this.modifiedResponse, successResponseForResponseAlternationData.modifiedResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseHeaders, modifiedResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForResponseAlternationData {\n");
    sb.append("    responseHeaders: ").append(toIndentedString(responseHeaders)).append("\n");
    sb.append("    modifiedResponse: ").append(toIndentedString(modifiedResponse)).append("\n");
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

