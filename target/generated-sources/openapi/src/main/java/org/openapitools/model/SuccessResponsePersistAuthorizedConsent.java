package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.model.SuccessResponsePersistAuthorizedConsentData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponsePersistAuthorizedConsent
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class SuccessResponsePersistAuthorizedConsent implements Response200ForPersistAuthorizedConsent {

  private String responseId;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    SUCCESS("SUCCESS");

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private SuccessResponsePersistAuthorizedConsentData data;

  public SuccessResponsePersistAuthorizedConsent() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SuccessResponsePersistAuthorizedConsent(String responseId, StatusEnum status, SuccessResponsePersistAuthorizedConsentData data) {
    this.responseId = responseId;
    this.status = status;
    this.data = data;
  }

  public SuccessResponsePersistAuthorizedConsent responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Get responseId
   * @return responseId
  */
  @NotNull 
  @Schema(name = "responseId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("responseId")
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public SuccessResponsePersistAuthorizedConsent status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SuccessResponsePersistAuthorizedConsent data(SuccessResponsePersistAuthorizedConsentData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public SuccessResponsePersistAuthorizedConsentData getData() {
    return data;
  }

  public void setData(SuccessResponsePersistAuthorizedConsentData data) {
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePersistAuthorizedConsent successResponsePersistAuthorizedConsent = (SuccessResponsePersistAuthorizedConsent) o;
    return Objects.equals(this.responseId, successResponsePersistAuthorizedConsent.responseId) &&
        Objects.equals(this.status, successResponsePersistAuthorizedConsent.status) &&
        Objects.equals(this.data, successResponsePersistAuthorizedConsent.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePersistAuthorizedConsent {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

