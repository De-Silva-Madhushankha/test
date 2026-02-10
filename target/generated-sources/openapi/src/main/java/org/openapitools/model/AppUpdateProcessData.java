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
 * Defines the context data related to the application update.
 */

@Schema(name = "AppUpdateProcessData", description = "Defines the context data related to the application update.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class AppUpdateProcessData {

  private Object appData;

  private Object additionalProperties;

  private Object existingAppData;

  public AppUpdateProcessData() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AppUpdateProcessData(Object appData, Object additionalProperties, Object existingAppData) {
    this.appData = appData;
    this.additionalProperties = additionalProperties;
    this.existingAppData = existingAppData;
  }

  public AppUpdateProcessData appData(Object appData) {
    this.appData = appData;
    return this;
  }

  /**
   * OAuth Application Data. Mandatory for pre-process-application-update.
   * @return appData
  */
  @NotNull 
  @Schema(name = "appData", description = "OAuth Application Data. Mandatory for pre-process-application-update.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("appData")
  public Object getAppData() {
    return appData;
  }

  public void setAppData(Object appData) {
    this.appData = appData;
  }

  public AppUpdateProcessData additionalProperties(Object additionalProperties) {
    this.additionalProperties = additionalProperties;
    return this;
  }

  /**
   * Additional properties retrieved from devportal UI. Mandatory for pre-process-application-update.
   * @return additionalProperties
  */
  @NotNull 
  @Schema(name = "additionalProperties", description = "Additional properties retrieved from devportal UI. Mandatory for pre-process-application-update.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("additionalProperties")
  public Object getAdditionalProperties() {
    return additionalProperties;
  }

  public void setAdditionalProperties(Object additionalProperties) {
    this.additionalProperties = additionalProperties;
  }

  public AppUpdateProcessData existingAppData(Object existingAppData) {
    this.existingAppData = existingAppData;
    return this;
  }

  /**
   * Existing OAuth Application Data. Mandatory for pre-process-application-update.
   * @return existingAppData
  */
  @NotNull 
  @Schema(name = "existingAppData", description = "Existing OAuth Application Data. Mandatory for pre-process-application-update.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("existingAppData")
  public Object getExistingAppData() {
    return existingAppData;
  }

  public void setExistingAppData(Object existingAppData) {
    this.existingAppData = existingAppData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AppUpdateProcessData appUpdateProcessData = (AppUpdateProcessData) o;
    return Objects.equals(this.appData, appUpdateProcessData.appData) &&
        Objects.equals(this.additionalProperties, appUpdateProcessData.additionalProperties) &&
        Objects.equals(this.existingAppData, appUpdateProcessData.existingAppData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(appData, additionalProperties, existingAppData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppUpdateProcessData {\n");
    sb.append("    appData: ").append(toIndentedString(appData)).append("\n");
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
    sb.append("    existingAppData: ").append(toIndentedString(existingAppData)).append("\n");
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

