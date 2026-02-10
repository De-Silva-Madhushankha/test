package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.AppCreateProcessData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AppCreateProcessRequestBody
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public class AppCreateProcessRequestBody {

  private String requestId;

  private AppCreateProcessData data;

  public AppCreateProcessRequestBody requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * A unique correlation identifier
   * @return requestId
  */
  
  @Schema(name = "requestId", example = "Ec1wMjmiG8", description = "A unique correlation identifier", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestId")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public AppCreateProcessRequestBody data(AppCreateProcessData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("data")
  public AppCreateProcessData getData() {
    return data;
  }

  public void setData(AppCreateProcessData data) {
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
    AppCreateProcessRequestBody appCreateProcessRequestBody = (AppCreateProcessRequestBody) o;
    return Objects.equals(this.requestId, appCreateProcessRequestBody.requestId) &&
        Objects.equals(this.data, appCreateProcessRequestBody.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestId, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AppCreateProcessRequestBody {\n");
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

