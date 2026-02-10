package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.StoredDetailedConsentResourceData;
import org.openapitools.model.UserGrantedData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PersistAuthorizedConsent
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class PersistAuthorizedConsent {

  private String consentId;

  private Boolean isApproved;

  private UserGrantedData userGrantedData;

  private StoredDetailedConsentResourceData consentResource;

  public PersistAuthorizedConsent consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * Get consentId
   * @return consentId
  */
  
  @Schema(name = "consentId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public PersistAuthorizedConsent isApproved(Boolean isApproved) {
    this.isApproved = isApproved;
    return this;
  }

  /**
   * Get isApproved
   * @return isApproved
  */
  
  @Schema(name = "isApproved", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isApproved")
  public Boolean getIsApproved() {
    return isApproved;
  }

  public void setIsApproved(Boolean isApproved) {
    this.isApproved = isApproved;
  }

  public PersistAuthorizedConsent userGrantedData(UserGrantedData userGrantedData) {
    this.userGrantedData = userGrantedData;
    return this;
  }

  /**
   * Get userGrantedData
   * @return userGrantedData
  */
  @Valid 
  @Schema(name = "userGrantedData", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userGrantedData")
  public UserGrantedData getUserGrantedData() {
    return userGrantedData;
  }

  public void setUserGrantedData(UserGrantedData userGrantedData) {
    this.userGrantedData = userGrantedData;
  }

  public PersistAuthorizedConsent consentResource(StoredDetailedConsentResourceData consentResource) {
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
    PersistAuthorizedConsent persistAuthorizedConsent = (PersistAuthorizedConsent) o;
    return Objects.equals(this.consentId, persistAuthorizedConsent.consentId) &&
        Objects.equals(this.isApproved, persistAuthorizedConsent.isApproved) &&
        Objects.equals(this.userGrantedData, persistAuthorizedConsent.userGrantedData) &&
        Objects.equals(this.consentResource, persistAuthorizedConsent.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, isApproved, userGrantedData, consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersistAuthorizedConsent {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    isApproved: ").append(toIndentedString(isApproved)).append("\n");
    sb.append("    userGrantedData: ").append(toIndentedString(userGrantedData)).append("\n");
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

