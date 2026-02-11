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
 * Defines an error object with details.
 */

@Schema(name = "Error", description = "Defines an error object with details.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:37:25.744256203Z[Etc/UTC]")
public class Error {

  private String code;

  private String description;

  private String operation;

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error code identifying the specific issue.
   * @return code
  */
  
  @Schema(name = "code", description = "Error code identifying the specific issue.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Detailed description of the error.
   * @return description
  */
  
  @Schema(name = "description", description = "Detailed description of the error.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Error operation(String operation) {
    this.operation = operation;
    return this;
  }

  /**
   * The operation where the error occurred.
   * @return operation
  */
  
  @Schema(name = "operation", description = "The operation where the error occurred.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("operation")
  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.description, error.description) &&
        Objects.equals(this.operation, error.operation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, operation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
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

