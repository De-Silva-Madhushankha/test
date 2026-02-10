package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.AuthorizedResources;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserGrantedData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public class UserGrantedData {

  private Object requestParameters;

  private AuthorizedResources authorizedResources;

  private String userId;

  public UserGrantedData requestParameters(Object requestParameters) {
    this.requestParameters = requestParameters;
    return this;
  }

  /**
   * Get requestParameters
   * @return requestParameters
  */
  
  @Schema(name = "requestParameters", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestParameters")
  public Object getRequestParameters() {
    return requestParameters;
  }

  public void setRequestParameters(Object requestParameters) {
    this.requestParameters = requestParameters;
  }

  public UserGrantedData authorizedResources(AuthorizedResources authorizedResources) {
    this.authorizedResources = authorizedResources;
    return this;
  }

  /**
   * Get authorizedResources
   * @return authorizedResources
  */
  @Valid 
  @Schema(name = "authorizedResources", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("authorizedResources")
  public AuthorizedResources getAuthorizedResources() {
    return authorizedResources;
  }

  public void setAuthorizedResources(AuthorizedResources authorizedResources) {
    this.authorizedResources = authorizedResources;
  }

  public UserGrantedData userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  
  @Schema(name = "userId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("userId")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserGrantedData userGrantedData = (UserGrantedData) o;
    return Objects.equals(this.requestParameters, userGrantedData.requestParameters) &&
        Objects.equals(this.authorizedResources, userGrantedData.authorizedResources) &&
        Objects.equals(this.userId, userGrantedData.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requestParameters, authorizedResources, userId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserGrantedData {\n");
    sb.append("    requestParameters: ").append(toIndentedString(requestParameters)).append("\n");
    sb.append("    authorizedResources: ").append(toIndentedString(authorizedResources)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

