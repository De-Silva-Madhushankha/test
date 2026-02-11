package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.annotation.Generated;

/**
 * Response200ForGetConsentContent
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "status", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = SuccessResponseForGetConsentContent.class, name = "SUCCESS"),
  @JsonSubTypes.Type(value = FailedResponse.class, name = "ERROR")
})
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:28:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public class Response200ForGetConsentContent {

  @JsonProperty("responseId")
  private String responseId;

  @JsonProperty("status")
  private String status;

  public Response200ForGetConsentContent responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Get responseId
   * @return responseId
  */
  
  @Schema(name = "responseId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public Response200ForGetConsentContent status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Response200ForGetConsentContent response200ForGetConsentContent = (Response200ForGetConsentContent) o;
    return Objects.equals(this.responseId, response200ForGetConsentContent.responseId) &&
        Objects.equals(this.status, response200ForGetConsentContent.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response200ForGetConsentContent {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
