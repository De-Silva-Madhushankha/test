package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner
 */

@JsonTypeName("SuccessResponsePopulateConsentAuthorizeScreenData_consumerData_accounts_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T05:01:11.155796089Z[Etc/UTC]")
public class SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner {

  private String displayName;

  private Boolean selected;

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner(String displayName, Boolean selected) {
    this.displayName = displayName;
    this.selected = selected;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Account display name
   * @return displayName
  */
  @NotNull 
  @Schema(name = "displayName", description = "Account display name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("displayName")
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner selected(Boolean selected) {
    this.selected = selected;
    return this;
  }

  /**
   * Whether the account is selected by default
   * @return selected
  */
  @NotNull 
  @Schema(name = "selected", description = "Whether the account is selected by default", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("selected")
  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean selected) {
    this.selected = selected;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner successResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner = (SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner) o;
    return Objects.equals(this.displayName, successResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner.displayName) &&
        Objects.equals(this.selected, successResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner.selected);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, selected);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    selected: ").append(toIndentedString(selected)).append("\n");
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

