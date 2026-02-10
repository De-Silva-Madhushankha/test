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
 * SuccessResponseApplicationCreationData
 */

@JsonTypeName("SuccessResponseApplicationCreation_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public class SuccessResponseApplicationCreationData {

  private String clientId;

  private Object additionalAppData;

  public SuccessResponseApplicationCreationData clientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Unique id to be stored as the clientId
   * @return clientId
  */
  
  @Schema(name = "clientId", description = "Unique id to be stored as the clientId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public SuccessResponseApplicationCreationData additionalAppData(Object additionalAppData) {
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
    SuccessResponseApplicationCreationData successResponseApplicationCreationData = (SuccessResponseApplicationCreationData) o;
    return Objects.equals(this.clientId, successResponseApplicationCreationData.clientId) &&
        Objects.equals(this.additionalAppData, successResponseApplicationCreationData.additionalAppData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, additionalAppData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseApplicationCreationData {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
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

