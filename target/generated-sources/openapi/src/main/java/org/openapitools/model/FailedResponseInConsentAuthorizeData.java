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
 * FailedResponseInConsentAuthorizeData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class FailedResponseInConsentAuthorizeData {

  private String errorMessage;

  private String newConsentStatus;

  public FailedResponseInConsentAuthorizeData() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FailedResponseInConsentAuthorizeData(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public FailedResponseInConsentAuthorizeData errorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Error message to be displayed in the URL
   * @return errorMessage
  */
  @NotNull 
  @Schema(name = "errorMessage", description = "Error message to be displayed in the URL", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorMessage")
  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public FailedResponseInConsentAuthorizeData newConsentStatus(String newConsentStatus) {
    this.newConsentStatus = newConsentStatus;
    return this;
  }

  /**
   * New consent status to be set to the consent
   * @return newConsentStatus
  */
  
  @Schema(name = "newConsentStatus", description = "New consent status to be set to the consent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("newConsentStatus")
  public String getNewConsentStatus() {
    return newConsentStatus;
  }

  public void setNewConsentStatus(String newConsentStatus) {
    this.newConsentStatus = newConsentStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponseInConsentAuthorizeData failedResponseInConsentAuthorizeData = (FailedResponseInConsentAuthorizeData) o;
    return Objects.equals(this.errorMessage, failedResponseInConsentAuthorizeData.errorMessage) &&
        Objects.equals(this.newConsentStatus, failedResponseInConsentAuthorizeData.newConsentStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(errorMessage, newConsentStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseInConsentAuthorizeData {\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
    sb.append("    newConsentStatus: ").append(toIndentedString(newConsentStatus)).append("\n");
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

