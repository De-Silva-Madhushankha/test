package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.Account;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner
 */

@JsonTypeName("SuccessResponsePopulateConsentAuthorizeScreenData_consentData_permissions_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:54:49.542208308Z[Etc/UTC]")
public class SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner {

  private String uid;

  @Valid
  private List<String> displayValues = new ArrayList<>();

  @Valid
  private List<@Valid Account> initiatedAccounts;

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner(String uid, List<String> displayValues) {
    this.uid = uid;
    this.displayValues = displayValues;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner uid(String uid) {
    this.uid = uid;
    return this;
  }

  /**
   * Unique ID for the permission
   * @return uid
  */
  @NotNull 
  @Schema(name = "uid", description = "Unique ID for the permission", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("uid")
  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner displayValues(List<String> displayValues) {
    this.displayValues = displayValues;
    return this;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner addDisplayValuesItem(String displayValuesItem) {
    if (this.displayValues == null) {
      this.displayValues = new ArrayList<>();
    }
    this.displayValues.add(displayValuesItem);
    return this;
  }

  /**
   * Permission display values
   * @return displayValues
  */
  @NotNull 
  @Schema(name = "displayValues", description = "Permission display values", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("displayValues")
  public List<String> getDisplayValues() {
    return displayValues;
  }

  public void setDisplayValues(List<String> displayValues) {
    this.displayValues = displayValues;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner initiatedAccounts(List<@Valid Account> initiatedAccounts) {
    this.initiatedAccounts = initiatedAccounts;
    return this;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner addInitiatedAccountsItem(Account initiatedAccountsItem) {
    if (this.initiatedAccounts == null) {
      this.initiatedAccounts = new ArrayList<>();
    }
    this.initiatedAccounts.add(initiatedAccountsItem);
    return this;
  }

  /**
   * Accounts initiated with this permission
   * @return initiatedAccounts
  */
  @Valid 
  @Schema(name = "initiatedAccounts", description = "Accounts initiated with this permission", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("initiatedAccounts")
  public List<@Valid Account> getInitiatedAccounts() {
    return initiatedAccounts;
  }

  public void setInitiatedAccounts(List<@Valid Account> initiatedAccounts) {
    this.initiatedAccounts = initiatedAccounts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner successResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner = (SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner) o;
    return Objects.equals(this.uid, successResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner.uid) &&
        Objects.equals(this.displayValues, successResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner.displayValues) &&
        Objects.equals(this.initiatedAccounts, successResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner.initiatedAccounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uid, displayValues, initiatedAccounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner {\n");
    sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
    sb.append("    displayValues: ").append(toIndentedString(displayValues)).append("\n");
    sb.append("    initiatedAccounts: ").append(toIndentedString(initiatedAccounts)).append("\n");
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

