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
 * RequestForEnrichFileUploadResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:37:25.744256203Z[Etc/UTC]")
public class RequestForEnrichFileUploadResponse {

  private String consentId;

  private String fileUploadCreatedTime;

  public RequestForEnrichFileUploadResponse consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * To identify consent.
   * @return consentId
  */
  
  @Schema(name = "consentId", description = "To identify consent.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public RequestForEnrichFileUploadResponse fileUploadCreatedTime(String fileUploadCreatedTime) {
    this.fileUploadCreatedTime = fileUploadCreatedTime;
    return this;
  }

  /**
   * Timestamp which the file was stored in the database.
   * @return fileUploadCreatedTime
  */
  
  @Schema(name = "fileUploadCreatedTime", description = "Timestamp which the file was stored in the database.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileUploadCreatedTime")
  public String getFileUploadCreatedTime() {
    return fileUploadCreatedTime;
  }

  public void setFileUploadCreatedTime(String fileUploadCreatedTime) {
    this.fileUploadCreatedTime = fileUploadCreatedTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestForEnrichFileUploadResponse requestForEnrichFileUploadResponse = (RequestForEnrichFileUploadResponse) o;
    return Objects.equals(this.consentId, requestForEnrichFileUploadResponse.consentId) &&
        Objects.equals(this.fileUploadCreatedTime, requestForEnrichFileUploadResponse.fileUploadCreatedTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, fileUploadCreatedTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestForEnrichFileUploadResponse {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    fileUploadCreatedTime: ").append(toIndentedString(fileUploadCreatedTime)).append("\n");
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

