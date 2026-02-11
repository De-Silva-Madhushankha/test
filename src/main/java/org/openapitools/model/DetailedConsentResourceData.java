package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.Authorization;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * DetailedConsentResourceData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:36:18.697163376Z[Etc/UTC]")
public class DetailedConsentResourceData {

  private String type;

  private String status;

  private Long validityTime;

  private Boolean recurringIndicator;

  private Integer frequency;

  private Object receipt;

  private Object attributes;

  @Valid
  private List<@Valid Authorization> authorizations;

  public DetailedConsentResourceData type(String type) {
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

  public DetailedConsentResourceData status(String status) {
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

  public DetailedConsentResourceData validityTime(Long validityTime) {
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

  public DetailedConsentResourceData recurringIndicator(Boolean recurringIndicator) {
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

  public DetailedConsentResourceData frequency(Integer frequency) {
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

  public DetailedConsentResourceData receipt(Object receipt) {
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

  public DetailedConsentResourceData attributes(Object attributes) {
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

  public DetailedConsentResourceData authorizations(List<@Valid Authorization> authorizations) {
    this.authorizations = authorizations;
    return this;
  }

  public DetailedConsentResourceData addAuthorizationsItem(Authorization authorizationsItem) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DetailedConsentResourceData detailedConsentResourceData = (DetailedConsentResourceData) o;
    return Objects.equals(this.type, detailedConsentResourceData.type) &&
        Objects.equals(this.status, detailedConsentResourceData.status) &&
        Objects.equals(this.validityTime, detailedConsentResourceData.validityTime) &&
        Objects.equals(this.recurringIndicator, detailedConsentResourceData.recurringIndicator) &&
        Objects.equals(this.frequency, detailedConsentResourceData.frequency) &&
        Objects.equals(this.receipt, detailedConsentResourceData.receipt) &&
        Objects.equals(this.attributes, detailedConsentResourceData.attributes) &&
        Objects.equals(this.authorizations, detailedConsentResourceData.authorizations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, status, validityTime, recurringIndicator, frequency, receipt, attributes, authorizations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DetailedConsentResourceData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    validityTime: ").append(toIndentedString(validityTime)).append("\n");
    sb.append("    recurringIndicator: ").append(toIndentedString(recurringIndicator)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    receipt: ").append(toIndentedString(receipt)).append("\n");
    sb.append("    attributes: ").append(toIndentedString(attributes)).append("\n");
    sb.append("    authorizations: ").append(toIndentedString(authorizations)).append("\n");
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

