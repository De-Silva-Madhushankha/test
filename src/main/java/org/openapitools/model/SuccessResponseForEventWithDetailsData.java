package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponseForEventWithDetailsData
 */

@JsonTypeName("SuccessResponseForEventWithDetails_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:39:58.298459337Z[Etc/UTC]")
public class SuccessResponseForEventWithDetailsData {

  private String callbackUrl;

  private String version;

  @Valid
  private List<String> eventTypes;

  public SuccessResponseForEventWithDetailsData callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    return this;
  }

  /**
   * Get callbackUrl
   * @return callbackUrl
  */
  
  @Schema(name = "callbackUrl", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("callbackUrl")
  public String getCallbackUrl() {
    return callbackUrl;
  }

  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  public SuccessResponseForEventWithDetailsData version(String version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
  */
  
  @Schema(name = "version", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public SuccessResponseForEventWithDetailsData eventTypes(List<String> eventTypes) {
    this.eventTypes = eventTypes;
    return this;
  }

  public SuccessResponseForEventWithDetailsData addEventTypesItem(String eventTypesItem) {
    if (this.eventTypes == null) {
      this.eventTypes = new ArrayList<>();
    }
    this.eventTypes.add(eventTypesItem);
    return this;
  }

  /**
   * Get eventTypes
   * @return eventTypes
  */
  
  @Schema(name = "eventTypes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventTypes")
  public List<String> getEventTypes() {
    return eventTypes;
  }

  public void setEventTypes(List<String> eventTypes) {
    this.eventTypes = eventTypes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForEventWithDetailsData successResponseForEventWithDetailsData = (SuccessResponseForEventWithDetailsData) o;
    return Objects.equals(this.callbackUrl, successResponseForEventWithDetailsData.callbackUrl) &&
        Objects.equals(this.version, successResponseForEventWithDetailsData.version) &&
        Objects.equals(this.eventTypes, successResponseForEventWithDetailsData.eventTypes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(callbackUrl, version, eventTypes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForEventWithDetailsData {\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    eventTypes: ").append(toIndentedString(eventTypes)).append("\n");
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

