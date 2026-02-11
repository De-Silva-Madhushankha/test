package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/**
 * SuccessResponseGetConsentContent
 */

@JsonTypeName("SuccessResponseGetConsentContent")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:30:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public class SuccessResponseGetConsentContent implements Response200ForGetConsentContent {

  @JsonProperty("responseId")
  private String responseId;

  public enum StatusEnum {
    SUCCESS("SUCCESS");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("status")
  private StatusEnum status;

  @JsonProperty("data")
  private SuccessResponseGetConsentContentData data;

  public SuccessResponseGetConsentContent responseId(String responseId) {
    this.responseId = responseId;
    return this;
  }

  /**
   * Get responseId
   * @return responseId
  */
  @NotNull 
  @Schema(name = "responseId", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getResponseId() {
    return responseId;
  }

  public void setResponseId(String responseId) {
    this.responseId = responseId;
  }

  public SuccessResponseGetConsentContent status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public SuccessResponseGetConsentContent data(SuccessResponseGetConsentContentData data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @NotNull @Valid 
  @Schema(name = "data", requiredMode = Schema.RequiredMode.REQUIRED)
  public SuccessResponseGetConsentContentData getData() {
    return data;
  }

  public void setData(SuccessResponseGetConsentContentData data) {
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
    SuccessResponseGetConsentContent successResponseGetConsentContent = (SuccessResponseGetConsentContent) o;
    return Objects.equals(this.responseId, successResponseGetConsentContent.responseId) &&
        Objects.equals(this.status, successResponseGetConsentContent.status) &&
        Objects.equals(this.data, successResponseGetConsentContent.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(responseId, status, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseGetConsentContent {\n");
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
