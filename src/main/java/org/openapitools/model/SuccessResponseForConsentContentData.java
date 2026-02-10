package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.StoredBasicConsentResourceData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponseForConsentContentData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class SuccessResponseForConsentContentData {

  private String consentId;

  private StoredBasicConsentResourceData consentResource;

  public SuccessResponseForConsentContentData() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SuccessResponseForConsentContentData(String consentId, StoredBasicConsentResourceData consentResource) {
    this.consentId = consentId;
    this.consentResource = consentResource;
  }

  public SuccessResponseForConsentContentData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The unique identifier of the consent resource
   * @return consentId
  */
  @NotNull 
  @Schema(name = "consentId", description = "The unique identifier of the consent resource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public SuccessResponseForConsentContentData consentResource(StoredBasicConsentResourceData consentResource) {
    this.consentResource = consentResource;
    return this;
  }

  /**
   * Get consentResource
   * @return consentResource
  */
  @NotNull @Valid 
  @Schema(name = "consentResource", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("consentResource")
  public StoredBasicConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredBasicConsentResourceData consentResource) {
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
    SuccessResponseForConsentContentData successResponseForConsentContentData = (SuccessResponseForConsentContentData) o;
    return Objects.equals(this.consentId, successResponseForConsentContentData.consentId) &&
        Objects.equals(this.consentResource, successResponseForConsentContentData.consentResource);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForConsentContentData {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
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

