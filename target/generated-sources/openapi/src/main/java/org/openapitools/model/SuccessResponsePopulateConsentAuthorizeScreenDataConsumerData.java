package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner;
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
 * Consumer related data fetched from the banking backend.
 */

@Schema(name = "SuccessResponsePopulateConsentAuthorizeScreenData_consumerData", description = "Consumer related data fetched from the banking backend.")
@JsonTypeName("SuccessResponsePopulateConsentAuthorizeScreenData_consumerData")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:53:43.265236298Z[Etc/UTC]")
public class SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData {

  @Valid
  private List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner> accounts;

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData accounts(List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner> accounts) {
    this.accounts = accounts;
    return this;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData addAccountsItem(SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner accountsItem) {
    if (this.accounts == null) {
      this.accounts = new ArrayList<>();
    }
    this.accounts.add(accountsItem);
    return this;
  }

  /**
   * List of all user accounts/resources selectable in the UI
   * @return accounts
  */
  @Valid 
  @Schema(name = "accounts", description = "List of all user accounts/resources selectable in the UI", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("accounts")
  public List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsumerDataAccountsInner> accounts) {
    this.accounts = accounts;
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
    public SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData putAdditionalProperty(String key, Object value) {
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
    SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData successResponsePopulateConsentAuthorizeScreenDataConsumerData = (SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData) o;
    return Objects.equals(this.accounts, successResponsePopulateConsentAuthorizeScreenDataConsumerData.accounts) &&
    Objects.equals(this.additionalProperties, successResponsePopulateConsentAuthorizeScreenDataConsumerData.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accounts, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenDataConsumerData {\n");
    sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
    
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

