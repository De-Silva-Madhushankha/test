package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * IssueRefreshTokenRequestData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class IssueRefreshTokenRequestData {

  private String grantType;

  private Long consentCreatedTime;

  private Long consentValidityPeriod;

  private Long defaultRefreshTokenValidityPeriod;

  public IssueRefreshTokenRequestData grantType(String grantType) {
    this.grantType = grantType;
    return this;
  }

  /**
   * Get grantType
   * @return grantType
  */
  
  @Schema(name = "grantType", example = "authorization_code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("grantType")
  public String getGrantType() {
    return grantType;
  }

  public void setGrantType(String grantType) {
    this.grantType = grantType;
  }

  public IssueRefreshTokenRequestData consentCreatedTime(Long consentCreatedTime) {
    this.consentCreatedTime = consentCreatedTime;
    return this;
  }

  /**
   * Get consentCreatedTime
   * @return consentCreatedTime
  */
  
  @Schema(name = "consentCreatedTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentCreatedTime")
  public Long getConsentCreatedTime() {
    return consentCreatedTime;
  }

  public void setConsentCreatedTime(Long consentCreatedTime) {
    this.consentCreatedTime = consentCreatedTime;
  }

  public IssueRefreshTokenRequestData consentValidityPeriod(Long consentValidityPeriod) {
    this.consentValidityPeriod = consentValidityPeriod;
    return this;
  }

  /**
   * Get consentValidityPeriod
   * @return consentValidityPeriod
  */
  
  @Schema(name = "consentValidityPeriod", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentValidityPeriod")
  public Long getConsentValidityPeriod() {
    return consentValidityPeriod;
  }

  public void setConsentValidityPeriod(Long consentValidityPeriod) {
    this.consentValidityPeriod = consentValidityPeriod;
  }

  public IssueRefreshTokenRequestData defaultRefreshTokenValidityPeriod(Long defaultRefreshTokenValidityPeriod) {
    this.defaultRefreshTokenValidityPeriod = defaultRefreshTokenValidityPeriod;
    return this;
  }

  /**
   * Get defaultRefreshTokenValidityPeriod
   * @return defaultRefreshTokenValidityPeriod
  */
  
  @Schema(name = "defaultRefreshTokenValidityPeriod", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("defaultRefreshTokenValidityPeriod")
  public Long getDefaultRefreshTokenValidityPeriod() {
    return defaultRefreshTokenValidityPeriod;
  }

  public void setDefaultRefreshTokenValidityPeriod(Long defaultRefreshTokenValidityPeriod) {
    this.defaultRefreshTokenValidityPeriod = defaultRefreshTokenValidityPeriod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IssueRefreshTokenRequestData issueRefreshTokenRequestData = (IssueRefreshTokenRequestData) o;
    return Objects.equals(this.grantType, issueRefreshTokenRequestData.grantType) &&
        Objects.equals(this.consentCreatedTime, issueRefreshTokenRequestData.consentCreatedTime) &&
        Objects.equals(this.consentValidityPeriod, issueRefreshTokenRequestData.consentValidityPeriod) &&
        Objects.equals(this.defaultRefreshTokenValidityPeriod, issueRefreshTokenRequestData.defaultRefreshTokenValidityPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grantType, consentCreatedTime, consentValidityPeriod, defaultRefreshTokenValidityPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IssueRefreshTokenRequestData {\n");
    sb.append("    grantType: ").append(toIndentedString(grantType)).append("\n");
    sb.append("    consentCreatedTime: ").append(toIndentedString(consentCreatedTime)).append("\n");
    sb.append("    consentValidityPeriod: ").append(toIndentedString(consentValidityPeriod)).append("\n");
    sb.append("    defaultRefreshTokenValidityPeriod: ").append(toIndentedString(defaultRefreshTokenValidityPeriod)).append("\n");
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

