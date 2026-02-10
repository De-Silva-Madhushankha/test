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
 * EventPollingRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class EventPollingRequest {

  private Object eventPollingData;

  public EventPollingRequest eventPollingData(Object eventPollingData) {
    this.eventPollingData = eventPollingData;
    return this;
  }

  /**
   * Event polling data
   * @return eventPollingData
  */
  
  @Schema(name = "eventPollingData", description = "Event polling data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventPollingData")
  public Object getEventPollingData() {
    return eventPollingData;
  }

  public void setEventPollingData(Object eventPollingData) {
    this.eventPollingData = eventPollingData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventPollingRequest eventPollingRequest = (EventPollingRequest) o;
    return Objects.equals(this.eventPollingData, eventPollingRequest.eventPollingData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventPollingData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventPollingRequest {\n");
    sb.append("    eventPollingData: ").append(toIndentedString(eventPollingData)).append("\n");
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

