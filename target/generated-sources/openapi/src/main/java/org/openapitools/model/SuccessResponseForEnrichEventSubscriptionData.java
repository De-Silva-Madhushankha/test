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
 * SuccessResponseForEnrichEventSubscriptionData
 */

@JsonTypeName("SuccessResponseForEnrichEventSubscription_data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class SuccessResponseForEnrichEventSubscriptionData {

  private Object eventSubscriptionResponse;

  public SuccessResponseForEnrichEventSubscriptionData eventSubscriptionResponse(Object eventSubscriptionResponse) {
    this.eventSubscriptionResponse = eventSubscriptionResponse;
    return this;
  }

  /**
   * Event Subscription Response
   * @return eventSubscriptionResponse
  */
  
  @Schema(name = "eventSubscriptionResponse", description = "Event Subscription Response", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventSubscriptionResponse")
  public Object getEventSubscriptionResponse() {
    return eventSubscriptionResponse;
  }

  public void setEventSubscriptionResponse(Object eventSubscriptionResponse) {
    this.eventSubscriptionResponse = eventSubscriptionResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForEnrichEventSubscriptionData successResponseForEnrichEventSubscriptionData = (SuccessResponseForEnrichEventSubscriptionData) o;
    return Objects.equals(this.eventSubscriptionResponse, successResponseForEnrichEventSubscriptionData.eventSubscriptionResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventSubscriptionResponse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForEnrichEventSubscriptionData {\n");
    sb.append("    eventSubscriptionResponse: ").append(toIndentedString(eventSubscriptionResponse)).append("\n");
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

