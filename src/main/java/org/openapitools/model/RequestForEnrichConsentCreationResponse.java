package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.StoredDetailedConsentResourceData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * RequestForEnrichConsentCreationResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:37:25.744256203Z[Etc/UTC]")
public class RequestForEnrichConsentCreationResponse {

  private String consentId;

  private StoredDetailedConsentResourceData consentResource;

  private String consentResourcePath;

  public RequestForEnrichConsentCreationResponse consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * To identify requested
   * @return consentId
  */
  
  @Schema(name = "consentId", description = "To identify requested", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public RequestForEnrichConsentCreationResponse consentResource(StoredDetailedConsentResourceData consentResource) {
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
  public StoredDetailedConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredDetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  public RequestForEnrichConsentCreationResponse consentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
    return this;
  }

  /**
   * consent resource path
   * @return consentResourcePath
  */
  
  @Schema(name = "consentResourcePath", description = "consent resource path", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    RequestForEnrichConsentCreationResponse requestForEnrichConsentCreationResponse = (RequestForEnrichConsentCreationResponse) o;
    return Objects.equals(this.consentId, requestForEnrichConsentCreationResponse.consentId) &&
        Objects.equals(this.consentResource, requestForEnrichConsentCreationResponse.consentResource) &&
        Objects.equals(this.consentResourcePath, requestForEnrichConsentCreationResponse.consentResourcePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, consentResourcePath);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestForEnrichConsentCreationResponse {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
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

