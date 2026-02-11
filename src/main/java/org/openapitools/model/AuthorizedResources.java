package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.AuthorizedResourcesAuthorizedDataInner;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
/**
 * AuthorizedResources
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:37:25.744256203Z[Etc/UTC]")
public class AuthorizedResources {

  private Boolean approval;

  private Boolean isReauthorization;

  private String type;

  @Valid
  private List<@Valid AuthorizedResourcesAuthorizedDataInner> authorizedData;

  private Object metadata;

  public AuthorizedResources approval(Boolean approval) {
    this.approval = approval;
    return this;
  }

  /**
   * Whether the user approved the consent
   * @return approval
  */
  
  @Schema(name = "approval", description = "Whether the user approved the consent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("approval")
  public Boolean getApproval() {
    return approval;
  }

  public void setApproval(Boolean approval) {
    this.approval = approval;
  }

  public AuthorizedResources isReauthorization(Boolean isReauthorization) {
    this.isReauthorization = isReauthorization;
    return this;
  }

  /**
   * Indicates if this was a reauthorization flow (optional)
   * @return isReauthorization
  */
  
  @Schema(name = "isReauthorization", description = "Indicates if this was a reauthorization flow (optional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isReauthorization")
  public Boolean getIsReauthorization() {
    return isReauthorization;
  }

  public void setIsReauthorization(Boolean isReauthorization) {
    this.isReauthorization = isReauthorization;
  }

  public AuthorizedResources type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of consent granted (e.g., 'accounts', 'payments', etc.)
   * @return type
  */
  
  @Schema(name = "type", description = "Type of consent granted (e.g., 'accounts', 'payments', etc.)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public AuthorizedResources authorizedData(List<@Valid AuthorizedResourcesAuthorizedDataInner> authorizedData) {
    this.authorizedData = authorizedData;
    return this;
  }

  public AuthorizedResources addAuthorizedDataItem(AuthorizedResourcesAuthorizedDataInner authorizedDataItem) {
    if (this.authorizedData == null) {
      this.authorizedData = new ArrayList<>();
    }
    this.authorizedData.add(authorizedDataItem);
    return this;
  }

  /**
   * List of granted permissions and corresponding user-selected account data
   * @return authorizedData
  */
  @Valid 
  @Schema(name = "authorizedData", description = "List of granted permissions and corresponding user-selected account data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authorizedData")
  public List<@Valid AuthorizedResourcesAuthorizedDataInner> getAuthorizedData() {
    return authorizedData;
  }

  public void setAuthorizedData(List<@Valid AuthorizedResourcesAuthorizedDataInner> authorizedData) {
    this.authorizedData = authorizedData;
  }

  public AuthorizedResources metadata(Object metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Consent authorization related metadata.
   * @return metadata
  */
  
  @Schema(name = "metadata", description = "Consent authorization related metadata.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("metadata")
  public Object getMetadata() {
    return metadata;
  }

  public void setMetadata(Object metadata) {
    this.metadata = metadata;
  }
    /**
    * A container for additional, undeclared properties.
    * This is a holder for any undeclared properties as specified with
    * the 'additionalProperties' keyword in the OAS document.
    */
    private Map<String, Object> additionalProperties;

    /**
    * Set the additional (undeclared) property with the specified name and value.
    * If the property does not already exist, create it otherwise replace it.
    */
    @JsonAnySetter
    public AuthorizedResources putAdditionalProperty(String key, Object value) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<String, Object>();
        }
        this.additionalProperties.put(key, value);
        return this;
    }

    /**
    * Return the additional (undeclared) property.
    */
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    /**
    * Return the additional (undeclared) property with the specified name.
    */
    public Object getAdditionalProperty(String key) {
        if (this.additionalProperties == null) {
            return null;
        }
        return this.additionalProperties.get(key);
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizedResources authorizedResources = (AuthorizedResources) o;
    return Objects.equals(this.approval, authorizedResources.approval) &&
        Objects.equals(this.isReauthorization, authorizedResources.isReauthorization) &&
        Objects.equals(this.type, authorizedResources.type) &&
        Objects.equals(this.authorizedData, authorizedResources.authorizedData) &&
        Objects.equals(this.metadata, authorizedResources.metadata) &&
    Objects.equals(this.additionalProperties, authorizedResources.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(approval, isReauthorization, type, authorizedData, metadata, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizedResources {\n");
    sb.append("    approval: ").append(toIndentedString(approval)).append("\n");
    sb.append("    isReauthorization: ").append(toIndentedString(isReauthorization)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    authorizedData: ").append(toIndentedString(authorizedData)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    
    sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
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

