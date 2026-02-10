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
 * PopulateConsentAuthorizeScreenData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class PopulateConsentAuthorizeScreenData {

  private String consentId;

  private String userId;

  private Object requestParameters;

  private StoredDetailedConsentResourceData consentResource;

  public PopulateConsentAuthorizeScreenData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * Get consentId
   * @return consentId
  */
  
  @Schema(name = "consentId", example = "An UUID", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public PopulateConsentAuthorizeScreenData userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  
  @Schema(name = "userId", example = "Username", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public PopulateConsentAuthorizeScreenData requestParameters(Object requestParameters) {
    this.requestParameters = requestParameters;
    return this;
  }

  /**
   * Custom object with request parameters
   * @return requestParameters
  */
  
  @Schema(name = "requestParameters", description = "Custom object with request parameters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestParameters")
  public Object getRequestParameters() {
    return requestParameters;
  }

  public void setRequestParameters(Object requestParameters) {
    this.requestParameters = requestParameters;
  }

  public PopulateConsentAuthorizeScreenData consentResource(StoredDetailedConsentResourceData consentResource) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PopulateConsentAuthorizeScreenData populateConsentAuthorizeScreenData = (PopulateConsentAuthorizeScreenData) o;
    return Objects.equals(this.consentId, populateConsentAuthorizeScreenData.consentId) &&
        Objects.equals(this.userId, populateConsentAuthorizeScreenData.userId) &&
        Objects.equals(this.requestParameters, populateConsentAuthorizeScreenData.requestParameters) &&
        Objects.equals(this.consentResource, populateConsentAuthorizeScreenData.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, userId, requestParameters, consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PopulateConsentAuthorizeScreenData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    requestParameters: ").append(toIndentedString(requestParameters)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
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

