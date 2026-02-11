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
 * Defines the success response.
 */

@Schema(name = "SuccessResponseClientProcess_data", description = "Defines the success response.")
@JsonTypeName("SuccessResponseClientProcess_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:39:58.298459337Z[Etc/UTC]")
public class SuccessResponseClientProcessData {

  private Object clientData;

  public SuccessResponseClientProcessData clientData(Object clientData) {
    this.clientData = clientData;
    return this;
  }

  /**
   * Get clientData
   * @return clientData
  */
  
  @Schema(name = "clientData", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientData")
  public Object getClientData() {
    return clientData;
  }

  public void setClientData(Object clientData) {
    this.clientData = clientData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseClientProcessData successResponseClientProcessData = (SuccessResponseClientProcessData) o;
    return Objects.equals(this.clientData, successResponseClientProcessData.clientData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseClientProcessData {\n");
    sb.append("    clientData: ").append(toIndentedString(clientData)).append("\n");
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

