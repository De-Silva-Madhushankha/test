package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.model.FailedResponseApplicationProcessData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * FailedResponseApplicationProcess
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:39:58.298459337Z[Etc/UTC]")
public class FailedResponseApplicationProcess implements Response200ForApplicationCreation, Response200ForApplicationUpdate {

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

  private FailedResponseApplicationProcessData errorMessage;

  public FailedResponseApplicationProcess() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FailedResponseApplicationProcess(StatusEnum status) {
    this.status = status;
  }

  public FailedResponseApplicationProcess status(StatusEnum status) {
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

  public FailedResponseApplicationProcess errorMessage(FailedResponseApplicationProcessData errorMessage) {
    this.errorMessage = errorMessage;
    return this;
  }

  /**
   * Get errorMessage
   * @return errorMessage
  */
  @Valid 
  @Schema(name = "errorMessage", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorMessage")
  public FailedResponseApplicationProcessData getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(FailedResponseApplicationProcessData errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponseApplicationProcess failedResponseApplicationProcess = (FailedResponseApplicationProcess) o;
    return Objects.equals(this.status, failedResponseApplicationProcess.status) &&
        Objects.equals(this.errorMessage, failedResponseApplicationProcess.errorMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errorMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseApplicationProcess {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    errorMessage: ").append(toIndentedString(errorMessage)).append("\n");
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

