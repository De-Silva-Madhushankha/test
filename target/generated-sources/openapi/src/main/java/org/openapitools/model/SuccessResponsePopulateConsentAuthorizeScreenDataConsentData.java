package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openapitools.model.Account;
import org.openapitools.model.SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner;
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
 * SuccessResponsePopulateConsentAuthorizeScreenDataConsentData
 */

@JsonTypeName("SuccessResponsePopulateConsentAuthorizeScreenData_consentData")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public class SuccessResponsePopulateConsentAuthorizeScreenDataConsentData {

  private String type;

  @Valid
  private Map<String, List<String>> basicConsentData = new HashMap<>();

  @Valid
  private List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner> permissions;

  @Valid
  private List<@Valid Account> initiatedAccountsForConsent;

  private Boolean allowMultipleAccounts;

  private Boolean handleAccountSelectionSeparately;

  private Boolean isReauthorization;

  private Object consentMetadata;

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type of consent
   * @return type
  */
  
  @Schema(name = "type", description = "The type of consent", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData basicConsentData(Map<String, List<String>> basicConsentData) {
    this.basicConsentData = basicConsentData;
    return this;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData putBasicConsentDataItem(String key, List<String> basicConsentDataItem) {
    if (this.basicConsentData == null) {
      this.basicConsentData = new HashMap<>();
    }
    this.basicConsentData.put(key, basicConsentDataItem);
    return this;
  }

  /**
   * Structured descriptive text shown on the consent page, split into sections. Each key is a section title, and its value is a list of bullet points displayed under that section.
   * @return basicConsentData
  */
  @Valid 
  @Schema(name = "basicConsentData", description = "Structured descriptive text shown on the consent page, split into sections. Each key is a section title, and its value is a list of bullet points displayed under that section.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("basicConsentData")
  public Map<String, List<String>> getBasicConsentData() {
    return basicConsentData;
  }

  public void setBasicConsentData(Map<String, List<String>> basicConsentData) {
    this.basicConsentData = basicConsentData;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData permissions(List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner> permissions) {
    this.permissions = permissions;
    return this;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData addPermissionsItem(SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * List of permissions for the consent (optional)
   * @return permissions
  */
  @Valid 
  @Schema(name = "permissions", description = "List of permissions for the consent (optional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("permissions")
  public List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<@Valid SuccessResponsePopulateConsentAuthorizeScreenDataConsentDataPermissionsInner> permissions) {
    this.permissions = permissions;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData initiatedAccountsForConsent(List<@Valid Account> initiatedAccountsForConsent) {
    this.initiatedAccountsForConsent = initiatedAccountsForConsent;
    return this;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData addInitiatedAccountsForConsentItem(Account initiatedAccountsForConsentItem) {
    if (this.initiatedAccountsForConsent == null) {
      this.initiatedAccountsForConsent = new ArrayList<>();
    }
    this.initiatedAccountsForConsent.add(initiatedAccountsForConsentItem);
    return this;
  }

  /**
   * Initialized accounts for the overall consent (optional)
   * @return initiatedAccountsForConsent
  */
  @Valid 
  @Schema(name = "initiatedAccountsForConsent", description = "Initialized accounts for the overall consent (optional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("initiatedAccountsForConsent")
  public List<@Valid Account> getInitiatedAccountsForConsent() {
    return initiatedAccountsForConsent;
  }

  public void setInitiatedAccountsForConsent(List<@Valid Account> initiatedAccountsForConsent) {
    this.initiatedAccountsForConsent = initiatedAccountsForConsent;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData allowMultipleAccounts(Boolean allowMultipleAccounts) {
    this.allowMultipleAccounts = allowMultipleAccounts;
    return this;
  }

  /**
   * Indicates if multiple consumer accounts can be selected per consent / permission
   * @return allowMultipleAccounts
  */
  
  @Schema(name = "allowMultipleAccounts", description = "Indicates if multiple consumer accounts can be selected per consent / permission", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("allowMultipleAccounts")
  public Boolean getAllowMultipleAccounts() {
    return allowMultipleAccounts;
  }

  public void setAllowMultipleAccounts(Boolean allowMultipleAccounts) {
    this.allowMultipleAccounts = allowMultipleAccounts;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData handleAccountSelectionSeparately(Boolean handleAccountSelectionSeparately) {
    this.handleAccountSelectionSeparately = handleAccountSelectionSeparately;
    return this;
  }

  /**
   * Indicates if account selection must be handled separately in the UI
   * @return handleAccountSelectionSeparately
  */
  
  @Schema(name = "handleAccountSelectionSeparately", description = "Indicates if account selection must be handled separately in the UI", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("handleAccountSelectionSeparately")
  public Boolean getHandleAccountSelectionSeparately() {
    return handleAccountSelectionSeparately;
  }

  public void setHandleAccountSelectionSeparately(Boolean handleAccountSelectionSeparately) {
    this.handleAccountSelectionSeparately = handleAccountSelectionSeparately;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData isReauthorization(Boolean isReauthorization) {
    this.isReauthorization = isReauthorization;
    return this;
  }

  /**
   * Indicates if this is a reauthorization flow (optional)
   * @return isReauthorization
  */
  
  @Schema(name = "isReauthorization", description = "Indicates if this is a reauthorization flow (optional)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isReauthorization")
  public Boolean getIsReauthorization() {
    return isReauthorization;
  }

  public void setIsReauthorization(Boolean isReauthorization) {
    this.isReauthorization = isReauthorization;
  }

  public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData consentMetadata(Object consentMetadata) {
    this.consentMetadata = consentMetadata;
    return this;
  }

  /**
   * Hidden consent metadata to be forwarded to consent persistence.
   * @return consentMetadata
  */
  
  @Schema(name = "consentMetadata", description = "Hidden consent metadata to be forwarded to consent persistence.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentMetadata")
  public Object getConsentMetadata() {
    return consentMetadata;
  }

  public void setConsentMetadata(Object consentMetadata) {
    this.consentMetadata = consentMetadata;
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
    public SuccessResponsePopulateConsentAuthorizeScreenDataConsentData putAdditionalProperty(String key, Object value) {
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
    SuccessResponsePopulateConsentAuthorizeScreenDataConsentData successResponsePopulateConsentAuthorizeScreenDataConsentData = (SuccessResponsePopulateConsentAuthorizeScreenDataConsentData) o;
    return Objects.equals(this.type, successResponsePopulateConsentAuthorizeScreenDataConsentData.type) &&
        Objects.equals(this.basicConsentData, successResponsePopulateConsentAuthorizeScreenDataConsentData.basicConsentData) &&
        Objects.equals(this.permissions, successResponsePopulateConsentAuthorizeScreenDataConsentData.permissions) &&
        Objects.equals(this.initiatedAccountsForConsent, successResponsePopulateConsentAuthorizeScreenDataConsentData.initiatedAccountsForConsent) &&
        Objects.equals(this.allowMultipleAccounts, successResponsePopulateConsentAuthorizeScreenDataConsentData.allowMultipleAccounts) &&
        Objects.equals(this.handleAccountSelectionSeparately, successResponsePopulateConsentAuthorizeScreenDataConsentData.handleAccountSelectionSeparately) &&
        Objects.equals(this.isReauthorization, successResponsePopulateConsentAuthorizeScreenDataConsentData.isReauthorization) &&
        Objects.equals(this.consentMetadata, successResponsePopulateConsentAuthorizeScreenDataConsentData.consentMetadata) &&
    Objects.equals(this.additionalProperties, successResponsePopulateConsentAuthorizeScreenDataConsentData.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, basicConsentData, permissions, initiatedAccountsForConsent, allowMultipleAccounts, handleAccountSelectionSeparately, isReauthorization, consentMetadata, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponsePopulateConsentAuthorizeScreenDataConsentData {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    basicConsentData: ").append(toIndentedString(basicConsentData)).append("\n");
    sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
    sb.append("    initiatedAccountsForConsent: ").append(toIndentedString(initiatedAccountsForConsent)).append("\n");
    sb.append("    allowMultipleAccounts: ").append(toIndentedString(allowMultipleAccounts)).append("\n");
    sb.append("    handleAccountSelectionSeparately: ").append(toIndentedString(handleAccountSelectionSeparately)).append("\n");
    sb.append("    isReauthorization: ").append(toIndentedString(isReauthorization)).append("\n");
    sb.append("    consentMetadata: ").append(toIndentedString(consentMetadata)).append("\n");
    
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

