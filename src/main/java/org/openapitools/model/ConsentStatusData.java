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
 * ConsentStatusData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class ConsentStatusData {

  private String consentId;

  private Object requestHeaders;

  public ConsentStatusData() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ConsentStatusData(String consentId) {
    this.consentId = consentId;
  }

  public ConsentStatusData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The unique identifier of the consent resource
   * @return consentId
  */
  @NotNull 
  @Schema(name = "consentId", description = "The unique identifier of the consent resource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public ConsentStatusData requestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
    return this;
  }

  /**
   * Request headers sent by the TPP
   * @return requestHeaders
  */
  
  @Schema(name = "requestHeaders", description = "Request headers sent by the TPP", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestHeaders")
  public Object getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentStatusData consentStatusData = (ConsentStatusData) o;
    return Objects.equals(this.consentId, consentStatusData.consentId) &&
        Objects.equals(this.requestHeaders, consentStatusData.requestHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, requestHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentStatusData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    requestHeaders: ").append(toIndentedString(requestHeaders)).append("\n");
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

