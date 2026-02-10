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
 * SuccessResponseForEnrichEventPollingData
 */

@JsonTypeName("SuccessResponseForEnrichEventPolling_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class SuccessResponseForEnrichEventPollingData {

  private Object eventPollingResponse;

  public SuccessResponseForEnrichEventPollingData eventPollingResponse(Object eventPollingResponse) {
    this.eventPollingResponse = eventPollingResponse;
    return this;
  }

  /**
   * Event Polling Response
   * @return eventPollingResponse
  */
  
  @Schema(name = "eventPollingResponse", description = "Event Polling Response", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventPollingResponse")
  public Object getEventPollingResponse() {
    return eventPollingResponse;
  }

  public void setEventPollingResponse(Object eventPollingResponse) {
    this.eventPollingResponse = eventPollingResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForEnrichEventPollingData successResponseForEnrichEventPollingData = (SuccessResponseForEnrichEventPollingData) o;
    return Objects.equals(this.eventPollingResponse, successResponseForEnrichEventPollingData.eventPollingResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventPollingResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForEnrichEventPollingData {\n");
    sb.append("    eventPollingResponse: ").append(toIndentedString(eventPollingResponse)).append("\n");
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

