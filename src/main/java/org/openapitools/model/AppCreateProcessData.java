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
 * Defines the context data related to the application registration.
 */

@Schema(name = "AppCreateProcessData", description = "Defines the context data related to the application registration.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class AppCreateProcessData {

  private Object appData;

  private Object additionalProperties;

  public AppCreateProcessData() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AppCreateProcessData(Object appData, Object additionalProperties) {
    this.appData = appData;
    this.additionalProperties = additionalProperties;
  }

  public AppCreateProcessData appData(Object appData) {
    this.appData = appData;
    return this;
  }

  /**
   * OAuth Application Data. Mandatory for pre-process-application-creation.
   * @return appData
  */
  @NotNull 
  @Schema(name = "appData", description = "OAuth Application Data. Mandatory for pre-process-application-creation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("appData")
  public Object getAppData() {
    return appData;
  }

  public void setAppData(Object appData) {
    this.appData = appData;
  }

  public AppCreateProcessData additionalProperties(Object additionalProperties) {
    this.additionalProperties = additionalProperties;
    return this;
  }

  /**
   * Additional properties retrieved from devportal UI. Mandatory for pre-process-application-creation.
   * @return additionalProperties
  */
  @NotNull 
  @Schema(name = "additionalProperties", description = "Additional properties retrieved from devportal UI. Mandatory for pre-process-application-creation.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("additionalProperties")
  public Object getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Object additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppCreateProcessData appCreateProcessData = (AppCreateProcessData) o;
    return Objects.equals(this.appData, appCreateProcessData.appData) &&
        Objects.equals(this.additionalProperties, appCreateProcessData.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appData, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppCreateProcessData {\n");
    sb.append("    appData: ").append(toIndentedString(appData)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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

