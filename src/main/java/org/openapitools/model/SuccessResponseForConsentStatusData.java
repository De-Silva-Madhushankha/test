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
 * SuccessResponseForConsentStatusData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class SuccessResponseForConsentStatusData {

  private String consentId;

  private String status;

  private Long createdTime;

  private Long updatedTime;

  public SuccessResponseForConsentStatusData() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SuccessResponseForConsentStatusData(String consentId, String status) {
    this.consentId = consentId;
    this.status = status;
  }

  public SuccessResponseForConsentStatusData consentId(String consentId) {
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

  public SuccessResponseForConsentStatusData status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Current status of the consent (e.g., authorized, revoked, expired)
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Current status of the consent (e.g., authorized, revoked, expired)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public SuccessResponseForConsentStatusData createdTime(Long createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * Timestamp when the consent was created
   * @return createdTime
  */
  
  @Schema(name = "createdTime", description = "Timestamp when the consent was created", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdTime")
  public Long getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Long createdTime) {
    this.createdTime = createdTime;
  }

  public SuccessResponseForConsentStatusData updatedTime(Long updatedTime) {
    this.updatedTime = updatedTime;
    return this;
  }

  /**
   * Timestamp when the consent was last updated
   * @return updatedTime
  */
  
  @Schema(name = "updatedTime", description = "Timestamp when the consent was last updated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedTime")
  public Long getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Long updatedTime) {
    this.updatedTime = updatedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForConsentStatusData successResponseForConsentStatusData = (SuccessResponseForConsentStatusData) o;
    return Objects.equals(this.consentId, successResponseForConsentStatusData.consentId) &&
        Objects.equals(this.status, successResponseForConsentStatusData.status) &&
        Objects.equals(this.createdTime, successResponseForConsentStatusData.createdTime) &&
        Objects.equals(this.updatedTime, successResponseForConsentStatusData.updatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, status, createdTime, updatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForConsentStatusData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdTime: ").append(toIndentedString(createdTime)).append("\n");
    sb.append("    updatedTime: ").append(toIndentedString(updatedTime)).append("\n");
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

