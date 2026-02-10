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
 * Request
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:54:49.542208308Z[Etc/UTC]")
public class Request {

  private Object consentInitiationData;

  private Object requestHeaders;

  private String consentResourcePath;

  public Request consentInitiationData(Object consentInitiationData) {
    this.consentInitiationData = consentInitiationData;
    return this;
  }

  /**
   * The initiation payload used by third parties which includes detailed information on data access request.
   * @return consentInitiationData
  */
  
  @Schema(name = "consentInitiationData", description = "The initiation payload used by third parties which includes detailed information on data access request.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentInitiationData")
  public Object getConsentInitiationData() {
    return consentInitiationData;
  }

  public void setConsentInitiationData(Object consentInitiationData) {
    this.consentInitiationData = consentInitiationData;
  }

  public Request requestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
    return this;
  }

  /**
   * Request headers sent by the TPP. Filtered set of headers are sent to the external service.
   * @return requestHeaders
  */
  
  @Schema(name = "requestHeaders", description = "Request headers sent by the TPP. Filtered set of headers are sent to the external service.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestHeaders")
  public Object getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  public Request consentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
    return this;
  }

  /**
   * To identify requested consent type
   * @return consentResourcePath
  */
  
  @Schema(name = "consentResourcePath", description = "To identify requested consent type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentResourcePath")
  public String getConsentResourcePath() {
    return consentResourcePath;
  }

  public void setConsentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Request request = (Request) o;
    return Objects.equals(this.consentInitiationData, request.consentInitiationData) &&
        Objects.equals(this.requestHeaders, request.requestHeaders) &&
        Objects.equals(this.consentResourcePath, request.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentInitiationData, requestHeaders, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Request {\n");
    sb.append("    consentInitiationData: ").append(toIndentedString(consentInitiationData)).append("\n");
    sb.append("    requestHeaders: ").append(toIndentedString(requestHeaders)).append("\n");
    sb.append("    consentResourcePath: ").append(toIndentedString(consentResourcePath)).append("\n");
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

