package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponseApplicationUpdateData
 */

@JsonTypeName("SuccessResponseApplicationUpdate_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class SuccessResponseApplicationUpdateData {

  private Object additionalAppData;

  public SuccessResponseApplicationUpdateData additionalAppData(Object additionalAppData) {
    this.additionalAppData = additionalAppData;
    return this;
  }

  /**
   * Defines the additional properties to store against the application.
   * @return additionalAppData
  */
  
  @Schema(name = "additionalAppData", description = "Defines the additional properties to store against the application.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("additionalAppData")
  public Object getAdditionalAppData() {
    return additionalAppData;
  }

  public void setAdditionalAppData(Object additionalAppData) {
    this.additionalAppData = additionalAppData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseApplicationUpdateData successResponseApplicationUpdateData = (SuccessResponseApplicationUpdateData) o;
    return Objects.equals(this.additionalAppData, successResponseApplicationUpdateData.additionalAppData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalAppData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseApplicationUpdateData {\n");
    sb.append("    additionalAppData: ").append(toIndentedString(additionalAppData)).append("\n");
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

