package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.AmendedAuthorization;
import org.openapitools.model.Authorization;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * DetailedConsentResourceDataWithAmendments
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class DetailedConsentResourceDataWithAmendments {

  private String type;

  private String status;

  private Long validityTime;

  private Boolean recurringIndicator;

  private Integer frequency;

  private Object receipt;

  private Object attributes;

  @Valid
  private List<@Valid Authorization> authorizations;

  @Valid
  private List<@Valid AmendedAuthorization> amendments;

  public DetailedConsentResourceDataWithAmendments type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public DetailedConsentResourceDataWithAmendments status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public DetailedConsentResourceDataWithAmendments validityTime(Long validityTime) {
    this.validityTime = validityTime;
    return this;
  }

  /**
   * Get validityTime
   * @return validityTime
  */
  
  @Schema(name = "validityTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("validityTime")
  public Long getValidityTime() {
    return validityTime;
  }

  public void setValidityTime(Long validityTime) {
    this.validityTime = validityTime;
  }

  public DetailedConsentResourceDataWithAmendments recurringIndicator(Boolean recurringIndicator) {
    this.recurringIndicator = recurringIndicator;
    return this;
  }

  /**
   * Get recurringIndicator
   * @return recurringIndicator
  */
  
  @Schema(name = "recurringIndicator", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recurringIndicator")
  public Boolean getRecurringIndicator() {
    return recurringIndicator;
  }

  public void setRecurringIndicator(Boolean recurringIndicator) {
    this.recurringIndicator = recurringIndicator;
  }

  public DetailedConsentResourceDataWithAmendments frequency(Integer frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Get frequency
   * @return frequency
  */
  
  @Schema(name = "frequency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("frequency")
  public Integer getFrequency() {
    return frequency;
  }

  public void setFrequency(Integer frequency) {
    this.frequency = frequency;
  }

  public DetailedConsentResourceDataWithAmendments receipt(Object receipt) {
    this.receipt = receipt;
    return this;
  }

  /**
   * Get receipt
   * @return receipt
  */
  
  @Schema(name = "receipt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("receipt")
  public Object getReceipt() {
    return receipt;
  }

  public void setReceipt(Object receipt) {
    this.receipt = receipt;
  }

  public DetailedConsentResourceDataWithAmendments attributes(Object attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * Get attributes
   * @return attributes
  */
  
  @Schema(name = "attributes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("attributes")
  public Object getAttributes() {
    return attributes;
  }

  public void setAttributes(Object attributes) {
    this.attributes = attributes;
  }

  public DetailedConsentResourceDataWithAmendments authorizations(List<@Valid Authorization> authorizations) {
    this.authorizations = authorizations;
    return this;
  }

  public DetailedConsentResourceDataWithAmendments addAuthorizationsItem(Authorization authorizationsItem) {
    if (this.authorizations == null) {
      this.authorizations = new ArrayList<>();
    }
    this.authorizations.add(authorizationsItem);
    return this;
  }

  /**
   * Get authorizations
   * @return authorizations
  */
  @Valid 
  @Schema(name = "authorizations", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authorizations")
  public List<@Valid Authorization> getAuthorizations() {
    return authorizations;
  }

  public void setAuthorizations(List<@Valid Authorization> authorizations) {
    this.authorizations = authorizations;
  }

  public DetailedConsentResourceDataWithAmendments amendments(List<@Valid AmendedAuthorization> amendments) {
    this.amendments = amendments;
    return this;
  }

  public DetailedConsentResourceDataWithAmendments addAmendmentsItem(AmendedAuthorization amendmentsItem) {
    if (this.amendments == null) {
      this.amendments = new ArrayList<>();
    }
    this.amendments.add(amendmentsItem);
    return this;
  }

  /**
   * Get amendments
   * @return amendments
  */
  @Valid 
  @Schema(name = "amendments", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amendments")
  public List<@Valid AmendedAuthorization> getAmendments() {
    return amendments;
  }

  public void setAmendments(List<@Valid AmendedAuthorization> amendments) {
    this.amendments = amendments;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedConsentResourceDataWithAmendments detailedConsentResourceDataWithAmendments = (DetailedConsentResourceDataWithAmendments) o;
    return Objects.equals(this.type, detailedConsentResourceDataWithAmendments.type) &&
        Objects.equals(this.status, detailedConsentResourceDataWithAmendments.status) &&
        Objects.equals(this.validityTime, detailedConsentResourceDataWithAmendments.validityTime) &&
        Objects.equals(this.recurringIndicator, detailedConsentResourceDataWithAmendments.recurringIndicator) &&
        Objects.equals(this.frequency, detailedConsentResourceDataWithAmendments.frequency) &&
        Objects.equals(this.receipt, detailedConsentResourceDataWithAmendments.receipt) &&
        Objects.equals(this.attributes, detailedConsentResourceDataWithAmendments.attributes) &&
        Objects.equals(this.authorizations, detailedConsentResourceDataWithAmendments.authorizations) &&
        Objects.equals(this.amendments, detailedConsentResourceDataWithAmendments.amendments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, status, validityTime, recurringIndicator, frequency, receipt, attributes, authorizations, amendments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedConsentResourceDataWithAmendments {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    validityTime: ").append(toIndentedString(validityTime)).append("\n");
    sb.append("    recurringIndicator: ").append(toIndentedString(recurringIndicator)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    authorizations: ").append(toIndentedString(authorizations)).append("\n");
    sb.append("    amendments: ").append(toIndentedString(amendments)).append("\n");
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

