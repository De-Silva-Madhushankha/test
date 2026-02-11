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
 * Response200ForErrorMapper
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:36:18.697163376Z[Etc/UTC]")
public class Response200ForErrorMapper {

  private String responseId;

  private Integer errorCode;

  private Object data;

  public Response200ForErrorMapper() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Response200ForErrorMapper(String responseId, Object data) {
    this.responseId = responseId;
    this.data = data;
  }

  public Response200ForErrorMapper responseId(String responseId) {
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

  public Response200ForErrorMapper errorCode(Integer errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorCode
   * @return errorCode
  */
  
  @Schema(name = "errorCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("errorCode")
  public Integer getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(Integer errorCode) {
    this.errorCode = errorCode;
  }

  public Response200ForErrorMapper data(Object data) {
    this.data = data;
    return this;
  }

  /**
   * Defines the custom error response.
   * @return data
  */
  @NotNull 
  @Schema(name = "data", description = "Defines the custom error response.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("data")
  public Object getData() {
    return data;
  }

  public void setData(Object data) {
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
    Response200ForErrorMapper response200ForErrorMapper = (Response200ForErrorMapper) o;
    return Objects.equals(this.responseId, response200ForErrorMapper.responseId) &&
        Objects.equals(this.errorCode, response200ForErrorMapper.errorCode) &&
        Objects.equals(this.data, response200ForErrorMapper.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, errorCode, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Response200ForErrorMapper {\n");
    sb.append("    responseId: ").append(toIndentedString(responseId)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
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

