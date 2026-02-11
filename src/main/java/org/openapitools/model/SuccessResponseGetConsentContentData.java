package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/**
 * SuccessResponseGetConsentContentData
 */

@JsonTypeName("SuccessResponseGetConsentContentData")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:30:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public class SuccessResponseGetConsentContentData {

  @JsonProperty("consentContent")
  private Object consentContent;

  @JsonProperty("responseHeaders")
  private Object responseHeaders;

  public SuccessResponseGetConsentContentData consentContent(Object consentContent) {
    this.consentContent = consentContent;
    return this;
  }

  /**
   * The consent content data retrieved
   * @return consentContent
  */
  
  @Schema(name = "consentContent", description = "The consent content data retrieved", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Object getConsentContent() {
    return consentContent;
  }

  public void setConsentContent(Object consentContent) {
    this.consentContent = consentContent;
  }

  public SuccessResponseGetConsentContentData responseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
    return this;
  }

  /**
   * Headers to be included in the response
   * @return responseHeaders
  */
  
  @Schema(name = "responseHeaders", description = "Headers to be included in the response", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Object getResponseHeaders() {
    return responseHeaders;
  }

  public void setResponseHeaders(Object responseHeaders) {
    this.responseHeaders = responseHeaders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseGetConsentContentData successResponseGetConsentContentData = (SuccessResponseGetConsentContentData) o;
    return Objects.equals(this.consentContent, successResponseGetConsentContentData.consentContent) &&
        Objects.equals(this.responseHeaders, successResponseGetConsentContentData.responseHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentContent, responseHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseGetConsentContentData {\n");
    sb.append("    consentContent: ").append(toIndentedString(consentContent)).append("\n");
    sb.append("    responseHeaders: ").append(toIndentedString(responseHeaders)).append("\n");
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
