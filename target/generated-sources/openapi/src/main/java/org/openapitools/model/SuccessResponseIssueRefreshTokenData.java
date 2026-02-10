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
 * SuccessResponseIssueRefreshTokenData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class SuccessResponseIssueRefreshTokenData {

  private Boolean issueRefreshToken;

  private Long refreshTokenValidityPeriod;

  public SuccessResponseIssueRefreshTokenData issueRefreshToken(Boolean issueRefreshToken) {
    this.issueRefreshToken = issueRefreshToken;
    return this;
  }

  /**
   * Get issueRefreshToken
   * @return issueRefreshToken
  */
  
  @Schema(name = "issueRefreshToken", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("issueRefreshToken")
  public Boolean getIssueRefreshToken() {
    return issueRefreshToken;
  }

  public void setIssueRefreshToken(Boolean issueRefreshToken) {
    this.issueRefreshToken = issueRefreshToken;
  }

  public SuccessResponseIssueRefreshTokenData refreshTokenValidityPeriod(Long refreshTokenValidityPeriod) {
    this.refreshTokenValidityPeriod = refreshTokenValidityPeriod;
    return this;
  }

  /**
   * Get refreshTokenValidityPeriod
   * @return refreshTokenValidityPeriod
  */
  
  @Schema(name = "refreshTokenValidityPeriod", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("refreshTokenValidityPeriod")
  public Long getRefreshTokenValidityPeriod() {
    return refreshTokenValidityPeriod;
  }

  public void setRefreshTokenValidityPeriod(Long refreshTokenValidityPeriod) {
    this.refreshTokenValidityPeriod = refreshTokenValidityPeriod;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseIssueRefreshTokenData successResponseIssueRefreshTokenData = (SuccessResponseIssueRefreshTokenData) o;
    return Objects.equals(this.issueRefreshToken, successResponseIssueRefreshTokenData.issueRefreshToken) &&
        Objects.equals(this.refreshTokenValidityPeriod, successResponseIssueRefreshTokenData.refreshTokenValidityPeriod);
  }

  @Override
  public int hashCode() {
    return Objects.hash(issueRefreshToken, refreshTokenValidityPeriod);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseIssueRefreshTokenData {\n");
    sb.append("    issueRefreshToken: ").append(toIndentedString(issueRefreshToken)).append("\n");
    sb.append("    refreshTokenValidityPeriod: ").append(toIndentedString(refreshTokenValidityPeriod)).append("\n");
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

