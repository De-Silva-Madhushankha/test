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
 * SuccessResponsePreProcessFileUploadData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:36:18.697163376Z[Etc/UTC]")
public class SuccessResponsePreProcessFileUploadData {

  private String consentStatus;

  private String userId;

  public SuccessResponsePreProcessFileUploadData consentStatus(String consentStatus) {
    this.consentStatus = consentStatus;
    return this;
  }

  /**
   * New consent status after the file upload is successful.
   * @return consentStatus
  */
  
  @Schema(name = "consentStatus", description = "New consent status after the file upload is successful.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentStatus")
  public String getConsentStatus() {
    return consentStatus;
  }

  public void setConsentStatus(String consentStatus) {
    this.consentStatus = consentStatus;
  }

  public SuccessResponsePreProcessFileUploadData userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Id of the user doing the file upload. Used for auditing purposes.
   * @return userId
  */
  
  @Schema(name = "userId", description = "Id of the user doing the file upload. Used for auditing purposes.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePreProcessFileUploadData successResponsePreProcessFileUploadData = (SuccessResponsePreProcessFileUploadData) o;
    return Objects.equals(this.consentStatus, successResponsePreProcessFileUploadData.consentStatus) &&
        Objects.equals(this.userId, successResponsePreProcessFileUploadData.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentStatus, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePreProcessFileUploadData {\n");
    sb.append("    consentStatus: ").append(toIndentedString(consentStatus)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

