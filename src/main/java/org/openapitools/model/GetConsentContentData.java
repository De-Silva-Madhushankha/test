package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/**
 * Defines the context data for GET consent content requests
 */

@Schema(name = "GetConsentContentData", description = "Defines the context data for GET consent content requests")
@JsonTypeName("GetConsentContentData")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:30:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public class GetConsentContentData {

  @JsonProperty("consentId")
  private String consentId;

  @JsonProperty("requestHeaders")
  private Object requestHeaders;

  @JsonProperty("consentResourcePath")
  private String consentResourcePath;

  public GetConsentContentData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The consent identifier
   * @return consentId
  */
  
  @Schema(name = "consentId", description = "The consent identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public GetConsentContentData requestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
    return this;
  }

  /**
   * Request headers sent by the AISP
   * @return requestHeaders
  */
  
  @Schema(name = "requestHeaders", description = "Request headers sent by the AISP", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Object getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  public GetConsentContentData consentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
    return this;
  }

  /**
   * Path to identify the consent resource type
   * @return consentResourcePath
  */
  
  @Schema(name = "consentResourcePath", description = "Path to identify the consent resource type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    GetConsentContentData getConsentContentData = (GetConsentContentData) o;
    return Objects.equals(this.consentId, getConsentContentData.consentId) &&
        Objects.equals(this.requestHeaders, getConsentContentData.requestHeaders) &&
        Objects.equals(this.consentResourcePath, getConsentContentData.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, requestHeaders, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConsentContentData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
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
