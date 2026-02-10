package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EventSubscriptionRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public class EventSubscriptionRequest {

  /**
   * Gets or Sets eventType
   */
  public enum EventTypeEnum {
    SUBSCRIPTIONCREATION("SubscriptionCreation"),
    
    SINGLESUBSCRIPTIONRETRIEVAL("SingleSubscriptionRetrieval"),
    
    BULKSUBSCRIPTIONRETRIEVAL("BulkSubscriptionRetrieval"),
    
    SUBSCRIPTIONRETRIEVALFOREVENTTYPES("SubscriptionRetrievalForEventTypes"),
    
    SUBSCRIPTIONUPDATE("SubscriptionUpdate"),
    
    SUBSCRIPTIONDELETE("SubscriptionDelete");

    private String value;

    EventTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EventTypeEnum fromValue(String value) {
      for (EventTypeEnum b : EventTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private EventTypeEnum eventType;

  private Object eventSubscriptionData;

  public EventSubscriptionRequest eventType(EventTypeEnum eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * Get eventType
   * @return eventType
  */
  
  @Schema(name = "eventType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventType")
  public EventTypeEnum getEventType() {
    return eventType;
  }

  public void setEventType(EventTypeEnum eventType) {
    this.eventType = eventType;
  }

  public EventSubscriptionRequest eventSubscriptionData(Object eventSubscriptionData) {
    this.eventSubscriptionData = eventSubscriptionData;
    return this;
  }

  /**
   * Event Subscription Payload
   * @return eventSubscriptionData
  */
  
  @Schema(name = "eventSubscriptionData", description = "Event Subscription Payload", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("eventSubscriptionData")
  public Object getEventSubscriptionData() {
    return eventSubscriptionData;
  }

  public void setEventSubscriptionData(Object eventSubscriptionData) {
    this.eventSubscriptionData = eventSubscriptionData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventSubscriptionRequest eventSubscriptionRequest = (EventSubscriptionRequest) o;
    return Objects.equals(this.eventType, eventSubscriptionRequest.eventType) &&
        Objects.equals(this.eventSubscriptionData, eventSubscriptionRequest.eventSubscriptionData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventType, eventSubscriptionData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventSubscriptionRequest {\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    eventSubscriptionData: ").append(toIndentedString(eventSubscriptionData)).append("\n");
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

