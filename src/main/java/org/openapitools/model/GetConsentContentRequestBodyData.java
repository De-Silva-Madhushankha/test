package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.annotation.Generated;

/**
 * Request data for retrieving consent content
 */
@Schema(name = "GetConsentContentRequestBodyData", description = "Request data for retrieving consent content")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:28:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public class GetConsentContentRequestBodyData {

  @JsonProperty("consentId")
  private String consentId;

  @JsonProperty("requestHeaders")
  private Object requestHeaders;

  @JsonProperty("consentResourcePath")
  private String consentResourcePath;

  public GetConsentContentRequestBodyData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The unique identifier of the consent
   * @return consentId
  */
  @NotNull 
  @Schema(name = "consentId", description = "The unique identifier of the consent", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public GetConsentContentRequestBodyData requestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
    return this;
  }

  /**
   * Request headers sent by the TPP
   * @return requestHeaders
  */
  
  @Schema(name = "requestHeaders", description = "Request headers sent by the TPP", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Object getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  public GetConsentContentRequestBodyData consentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
    return this;
  }

  /**
   * To identify requested consent type
   * @return consentResourcePath
  */
  
  @Schema(name = "consentResourcePath", description = "To identify requested consent type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    GetConsentContentRequestBodyData getConsentContentRequestBodyData = (GetConsentContentRequestBodyData) o;
    return Objects.equals(this.consentId, getConsentContentRequestBodyData.consentId) &&
        Objects.equals(this.requestHeaders, getConsentContentRequestBodyData.requestHeaders) &&
        Objects.equals(this.consentResourcePath, getConsentContentRequestBodyData.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, requestHeaders, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetConsentContentRequestBodyData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    requestHeaders: ").append(toIndentedString(requestHeaders)).append("\n");
    sb.append("    consentResourcePath: ").append(toIndentedString(consentResourcePath)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
