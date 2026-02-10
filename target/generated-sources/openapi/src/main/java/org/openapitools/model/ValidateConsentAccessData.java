package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.StoredDetailedConsentResourceData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ValidateConsentAccessData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T05:01:11.155796089Z[Etc/UTC]")
public class ValidateConsentAccessData {

  private String consentId;

  private StoredDetailedConsentResourceData consentResource;

  private Object dataRequestPayload;

  public ValidateConsentAccessData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The consent id
   * @return consentId
  */
  
  @Schema(name = "consentId", description = "The consent id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public ValidateConsentAccessData consentResource(StoredDetailedConsentResourceData consentResource) {
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
  public StoredDetailedConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredDetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  public ValidateConsentAccessData dataRequestPayload(Object dataRequestPayload) {
    this.dataRequestPayload = dataRequestPayload;
    return this;
  }

  /**
   * The receipt used by Third parties which includes detailed information on data access request
   * @return dataRequestPayload
  */
  
  @Schema(name = "dataRequestPayload", description = "The receipt used by Third parties which includes detailed information on data access request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dataRequestPayload")
  public Object getDataRequestPayload() {
    return dataRequestPayload;
  }

  public void setDataRequestPayload(Object dataRequestPayload) {
    this.dataRequestPayload = dataRequestPayload;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateConsentAccessData validateConsentAccessData = (ValidateConsentAccessData) o;
    return Objects.equals(this.consentId, validateConsentAccessData.consentId) &&
        Objects.equals(this.consentResource, validateConsentAccessData.consentResource) &&
        Objects.equals(this.dataRequestPayload, validateConsentAccessData.dataRequestPayload);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, dataRequestPayload);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateConsentAccessData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
    sb.append("    dataRequestPayload: ").append(toIndentedString(dataRequestPayload)).append("\n");
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

