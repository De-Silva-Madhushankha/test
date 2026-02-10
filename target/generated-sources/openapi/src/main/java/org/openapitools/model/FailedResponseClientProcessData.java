package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * FailedResponseClientProcessData
 */

@JsonTypeName("FailedResponseClientProcess_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class FailedResponseClientProcessData {

  /**
   * Provides the error code for error.
   */
  public enum ErrorEnum {
    CLIENT_METADATA("invalid_client_metadata"),
    
    REDIRECT_URI("invalid_redirect_uri"),
    
    SOFTWARE_STATEMENT("invalid_software_statement");

    private String value;

    ErrorEnum(String value) {
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
    public static ErrorEnum fromValue(String value) {
      for (ErrorEnum b : ErrorEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private ErrorEnum error;

  private String errorDescription;

  public FailedResponseClientProcessData error(ErrorEnum error) {
    this.error = error;
    return this;
  }

  /**
   * Provides the error code for error.
   * @return error
  */
  
  @Schema(name = "error", description = "Provides the error code for error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public ErrorEnum getError() {
    return error;
  }

  public void setError(ErrorEnum error) {
    this.error = error;
  }

  public FailedResponseClientProcessData errorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
    return this;
  }

  /**
   * Offers a detailed explanation of the error.
   * @return errorDescription
  */
  
  @Schema(name = "errorDescription", description = "Offers a detailed explanation of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorDescription")
  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FailedResponseClientProcessData failedResponseClientProcessData = (FailedResponseClientProcessData) o;
    return Objects.equals(this.error, failedResponseClientProcessData.error) &&
        Objects.equals(this.errorDescription, failedResponseClientProcessData.errorDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error, errorDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FailedResponseClientProcessData {\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    errorDescription: ").append(toIndentedString(errorDescription)).append("\n");
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

