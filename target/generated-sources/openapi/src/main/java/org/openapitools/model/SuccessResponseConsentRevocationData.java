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
 * SuccessResponseConsentRevocationData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class SuccessResponseConsentRevocationData {

  private String revocationStatusName;

  private String requireTokenRevocation;

  public SuccessResponseConsentRevocationData revocationStatusName(String revocationStatusName) {
    this.revocationStatusName = revocationStatusName;
    return this;
  }

  /**
   * Name for the revoked status
   * @return revocationStatusName
  */
  
  @Schema(name = "revocationStatusName", description = "Name for the revoked status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("revocationStatusName")
  public String getRevocationStatusName() {
    return revocationStatusName;
  }

  public void setRevocationStatusName(String revocationStatusName) {
    this.revocationStatusName = revocationStatusName;
  }

  public SuccessResponseConsentRevocationData requireTokenRevocation(String requireTokenRevocation) {
    this.requireTokenRevocation = requireTokenRevocation;
    return this;
  }

  /**
   * Require access token to be revoked
   * @return requireTokenRevocation
  */
  
  @Schema(name = "requireTokenRevocation", description = "Require access token to be revoked", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requireTokenRevocation")
  public String getRequireTokenRevocation() {
    return requireTokenRevocation;
  }

  public void setRequireTokenRevocation(String requireTokenRevocation) {
    this.requireTokenRevocation = requireTokenRevocation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseConsentRevocationData successResponseConsentRevocationData = (SuccessResponseConsentRevocationData) o;
    return Objects.equals(this.revocationStatusName, successResponseConsentRevocationData.revocationStatusName) &&
        Objects.equals(this.requireTokenRevocation, successResponseConsentRevocationData.requireTokenRevocation);
  }

  @Override
  public int hashCode() {
    return Objects.hash(revocationStatusName, requireTokenRevocation);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseConsentRevocationData {\n");
    sb.append("    revocationStatusName: ").append(toIndentedString(revocationStatusName)).append("\n");
    sb.append("    requireTokenRevocation: ").append(toIndentedString(requireTokenRevocation)).append("\n");
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

