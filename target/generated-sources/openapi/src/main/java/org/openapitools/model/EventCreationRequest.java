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
 * EventCreationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class EventCreationRequest {

  private Object eventData;

  public EventCreationRequest eventData(Object eventData) {
    this.eventData = eventData;
    return this;
  }

  /**
   * Event creation Payload
   * @return eventData
  */
  
  @Schema(name = "eventData", description = "Event creation Payload", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventData")
  public Object getEventData() {
    return eventData;
  }

  public void setEventData(Object eventData) {
    this.eventData = eventData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventCreationRequest eventCreationRequest = (EventCreationRequest) o;
    return Objects.equals(this.eventData, eventCreationRequest.eventData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventCreationRequest {\n");
    sb.append("    eventData: ").append(toIndentedString(eventData)).append("\n");
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

