package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.SuccessResponsePopulateConsentAuthorizeScreenDataConsentData;
import org.openapitools.model.SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponsePopulateConsentAuthorizeScreenData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class SuccessResponsePopulateConsentAuthorizeScreenData {

  private SuccessResponsePopulateConsentAuthorizeScreenDataConsentData consentData;

  private SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData consumerData;

  public SuccessResponsePopulateConsentAuthorizeScreenData consentData(SuccessResponsePopulateConsentAuthorizeScreenDataConsentData consentData) {
    this.consentData = consentData;
    return this;
  }

  /**
   * Get consentData
   * @return consentData
  */
  @Valid 
  @Schema(name = "consentData", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentData")
  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData getConsentData() {
    return consentData;
  }

  public void setConsentData(SuccessResponsePopulateConsentAuthorizeScreenDataConsentData consentData) {
    this.consentData = consentData;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenData consumerData(SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData consumerData) {
    this.consumerData = consumerData;
    return this;
  }

  /**
   * Get consumerData
   * @return consumerData
  */
  @Valid 
  @Schema(name = "consumerData", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consumerData")
  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData getConsumerData() {
    return consumerData;
  }

  public void setConsumerData(SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData consumerData) {
    this.consumerData = consumerData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenData successResponsePopulateConsentAuthorizeScreenData = (SuccessResponsePopulateConsentAuthorizeScreenData) o;
    return Objects.equals(this.consentData, successResponsePopulateConsentAuthorizeScreenData.consentData) &&
        Objects.equals(this.consumerData, successResponsePopulateConsentAuthorizeScreenData.consumerData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentData, consumerData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenData {\n");
    sb.append("    consentData: ").append(toIndentedString(consentData)).append("\n");
    sb.append("    consumerData: ").append(toIndentedString(consumerData)).append("\n");
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

