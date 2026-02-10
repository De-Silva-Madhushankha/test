package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.StoredBasicConsentResourceData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PreProcessConsentRetrievalData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class PreProcessConsentRetrievalData {

  private String consentId;

  private StoredBasicConsentResourceData consentResource;

  private Object requestHeaders;

  private String consentResourcePath;

  public PreProcessConsentRetrievalData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The consent id
   * @return consentId
  */
  
  @Schema(name = "consentId", description = "The consent id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public PreProcessConsentRetrievalData consentResource(StoredBasicConsentResourceData consentResource) {
    this.consentResource = consentResource;
    return this;
  }

  /**
   * Get consentResource
   * @return consentResource
  */
  @Valid 
  @Schema(name = "consentResource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentResource")
  public StoredBasicConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredBasicConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  public PreProcessConsentRetrievalData requestHeaders(Object requestHeaders) {
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

  public PreProcessConsentRetrievalData consentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
    return this;
  }

  /**
   * Resource url
   * @return consentResourcePath
  */
  
  @Schema(name = "consentResourcePath", description = "Resource url", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    PreProcessConsentRetrievalData preProcessConsentRetrievalData = (PreProcessConsentRetrievalData) o;
    return Objects.equals(this.consentId, preProcessConsentRetrievalData.consentId) &&
        Objects.equals(this.consentResource, preProcessConsentRetrievalData.consentResource) &&
        Objects.equals(this.requestHeaders, preProcessConsentRetrievalData.requestHeaders) &&
        Objects.equals(this.consentResourcePath, preProcessConsentRetrievalData.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, requestHeaders, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PreProcessConsentRetrievalData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
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

