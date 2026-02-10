package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.AmendedResource;
import org.openapitools.model.Resource;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AmendedAuthorization
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T05:01:11.155796089Z[Etc/UTC]")
public class AmendedAuthorization {

  private String id;

  private String type;

  private String status;

  @Valid
  private List<@Valid Resource> resources;

  @Valid
  private List<@Valid AmendedResource> amendedResources;

  public AmendedAuthorization id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AmendedAuthorization type(String type) {
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

  public AmendedAuthorization status(String status) {
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

  public AmendedAuthorization resources(List<@Valid Resource> resources) {
    this.resources = resources;
    return this;
  }

  public AmendedAuthorization addResourcesItem(Resource resourcesItem) {
    if (this.resources == null) {
      this.resources = new ArrayList<>();
    }
    this.resources.add(resourcesItem);
    return this;
  }

  /**
   * Get resources
   * @return resources
  */
  @Valid 
  @Schema(name = "resources", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("resources")
  public List<@Valid Resource> getResources() {
    return resources;
  }

  public void setResources(List<@Valid Resource> resources) {
    this.resources = resources;
  }

  public AmendedAuthorization amendedResources(List<@Valid AmendedResource> amendedResources) {
    this.amendedResources = amendedResources;
    return this;
  }

  public AmendedAuthorization addAmendedResourcesItem(AmendedResource amendedResourcesItem) {
    if (this.amendedResources == null) {
      this.amendedResources = new ArrayList<>();
    }
    this.amendedResources.add(amendedResourcesItem);
    return this;
  }

  /**
   * Get amendedResources
   * @return amendedResources
  */
  @Valid 
  @Schema(name = "amendedResources", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amendedResources")
  public List<@Valid AmendedResource> getAmendedResources() {
    return amendedResources;
  }

  public void setAmendedResources(List<@Valid AmendedResource> amendedResources) {
    this.amendedResources = amendedResources;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AmendedAuthorization amendedAuthorization = (AmendedAuthorization) o;
    return Objects.equals(this.id, amendedAuthorization.id) &&
        Objects.equals(this.type, amendedAuthorization.type) &&
        Objects.equals(this.status, amendedAuthorization.status) &&
        Objects.equals(this.resources, amendedAuthorization.resources) &&
        Objects.equals(this.amendedResources, amendedAuthorization.amendedResources);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, status, resources, amendedResources);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AmendedAuthorization {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    amendedResources: ").append(toIndentedString(amendedResources)).append("\n");
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

