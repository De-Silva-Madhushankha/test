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
 * AuthorizedResourcesAuthorizedDataInner
 */

@JsonTypeName("AuthorizedResources_authorizedData_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:52:47.169932113Z[Etc/UTC]")
public class AuthorizedResourcesAuthorizedDataInner {

  @Valid
  private List<String> permissions;

  @Valid
  private List<@Valid Account> accounts = new ArrayList<>();

  public AuthorizedResourcesAuthorizedDataInner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public AuthorizedResourcesAuthorizedDataInner(List<@Valid Account> accounts) {
    this.accounts = accounts;
  }

  public AuthorizedResourcesAuthorizedDataInner permissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  public AuthorizedResourcesAuthorizedDataInner addPermissionsItem(String permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Granted permissions (optional if no permissions exist)
   * @return permissions
  */
  
  @Schema(name = "permissions", description = "Granted permissions (optional if no permissions exist)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("permissions")
  public List<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<String> permissions) {
    this.permissions = permissions;
  }

  public AuthorizedResourcesAuthorizedDataInner accounts(List<@Valid Account> accounts) {
    this.accounts = accounts;
    return this;
  }

  public AuthorizedResourcesAuthorizedDataInner addAccountsItem(Account accountsItem) {
    if (this.accounts == null) {
      this.accounts = new ArrayList<>();
    }
    this.accounts.add(accountsItem);
    return this;
  }

  /**
   * Accounts selected for the permissions
   * @return accounts
  */
  @NotNull @Valid 
  @Schema(name = "accounts", description = "Accounts selected for the permissions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("accounts")
  public List<@Valid Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<@Valid Account> accounts) {
    this.accounts = accounts;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizedResourcesAuthorizedDataInner authorizedResourcesAuthorizedDataInner = (AuthorizedResourcesAuthorizedDataInner) o;
    return Objects.equals(this.permissions, authorizedResourcesAuthorizedDataInner.permissions) &&
        Objects.equals(this.accounts, authorizedResourcesAuthorizedDataInner.accounts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permissions, accounts);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthorizedResourcesAuthorizedDataInner {\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
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

