package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * FailedResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class FailedResponse implements Response200, Response200ForConsentContent, Response200ForConsentRevocation, Response200ForConsentSearch, Response200ForConsentStatus, Response200ForEnrichEventPolling, Response200ForEnrichEventSubscription, Response200ForEventSubscriptionValidation, Response200ForEventValidation, Response200ForIssueRefreshToken, Response200ForPreProcessConsentCreation, Response200ForPreProcessFileUpload, Response200ForResponseAlternation, Response200ForValidateAuthorizationRequest {

  private String responseId;

  /**
   * Indicates the outcome of the request. For a failed operation, this should be set to ERROR.
   */
  public enum StatusEnum {
    ERROR("ERROR");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private Integer errorCode;

  private Object data;

  public FailedResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FailedResponse(String responseId, StatusEnum status, Integer errorCode, Object data) {
    this.responseId = responseId;
    this.status = status;
    this.errorCode = errorCode;
    this.data = data;
  }

  public FailedResponse responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Get responseId
   * @return responseId
  */
  @NotNull 
  @Schema(name = "responseId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("responseId")
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public FailedResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Indicates the outcome of the request. For a failed operation, this should be set to ERROR.
   * @return status
  */
  @NotNull 
  @Schema(name = "status", description = "Indicates the outcome of the request. For a failed operation, this should be set to ERROR.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public FailedResponse errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * If any HTTP error code to return.
   * @return errorCode
  */
  @NotNull 
  @Schema(name = "errorCode", description = "If any HTTP error code to return.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public FailedResponse data(Object data) {
    this.data = data;
    return this;
  }

  /**
   * :\"Custom error object to response back\"
   * @return data
  */
  @NotNull 
  @Schema(name = "data", description = ":\"Custom error object to response back\"", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponse failedResponse = (FailedResponse) o;
    return Objects.equals(this.responseId, failedResponse.responseId) &&
        Objects.equals(this.status, failedResponse.status) &&
        Objects.equals(this.errorCode, failedResponse.errorCode) &&
        Objects.equals(this.data, failedResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, errorCode, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponse {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

