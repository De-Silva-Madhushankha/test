package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.model.FailedResponseClientProcessData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * FailedResponseClientProcess
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public class FailedResponseClientProcess implements Response200ForClientProcess {

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

  private FailedResponseClientProcessData data;

  public FailedResponseClientProcess() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FailedResponseClientProcess(StatusEnum status, FailedResponseClientProcessData data) {
    this.status = status;
    this.data = data;
  }

  public FailedResponseClientProcess status(StatusEnum status) {
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

  public FailedResponseClientProcess errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * If any HTTP error code to return.
   * @return errorCode
  */
  
  @Schema(name = "errorCode", description = "If any HTTP error code to return.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public FailedResponseClientProcess data(FailedResponseClientProcessData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public FailedResponseClientProcessData getData() {
    return data;
  }

  public void setData(FailedResponseClientProcessData data) {
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
    FailedResponseClientProcess failedResponseClientProcess = (FailedResponseClientProcess) o;
    return Objects.equals(this.status, failedResponseClientProcess.status) &&
        Objects.equals(this.errorCode, failedResponseClientProcess.errorCode) &&
        Objects.equals(this.data, failedResponseClientProcess.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, errorCode, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseClientProcess {\n");
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

