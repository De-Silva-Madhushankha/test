package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.RequestForEnrichConsentCreationResponse;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * EnrichConsentCreationRequestBody
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:54:49.542208308Z[Etc/UTC]")
public class EnrichConsentCreationRequestBody {

  private String requestId;

  private RequestForEnrichConsentCreationResponse data;

  public EnrichConsentCreationRequestBody() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EnrichConsentCreationRequestBody(String requestId, RequestForEnrichConsentCreationResponse data) {
    this.requestId = requestId;
    this.data = data;
  }

  public EnrichConsentCreationRequestBody requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * A unique correlation identifier
   * @return requestId
  */
  @NotNull 
  @Schema(name = "requestId", example = "Ec1wMjmiG8", description = "A unique correlation identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public EnrichConsentCreationRequestBody data(RequestForEnrichConsentCreationResponse data) {
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
  public RequestForEnrichConsentCreationResponse getData() {
    return data;
  }

  public void setData(RequestForEnrichConsentCreationResponse data) {
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
    EnrichConsentCreationRequestBody enrichConsentCreationRequestBody = (EnrichConsentCreationRequestBody) o;
    return Objects.equals(this.requestId, enrichConsentCreationRequestBody.requestId) &&
        Objects.equals(this.data, enrichConsentCreationRequestBody.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnrichConsentCreationRequestBody {\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
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

