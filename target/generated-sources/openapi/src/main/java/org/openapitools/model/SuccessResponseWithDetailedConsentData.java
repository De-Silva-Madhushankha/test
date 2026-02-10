package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.DetailedConsentResourceData;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponseWithDetailedConsentData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:54:49.542208308Z[Etc/UTC]")
public class SuccessResponseWithDetailedConsentData implements SuccessResponsePersistAuthorizedConsentData {

  private DetailedConsentResourceData consentResource;

  public SuccessResponseWithDetailedConsentData consentResource(DetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
    return this;
  }

  /**
   * Get consentResource
   * @return consentResource
  */
  @Valid 
  @Schema(name = "consentResource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentResource")
  public DetailedConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(DetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseWithDetailedConsentData successResponseWithDetailedConsentData = (SuccessResponseWithDetailedConsentData) o;
    return Objects.equals(this.consentResource, successResponseWithDetailedConsentData.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseWithDetailedConsentData {\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
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

