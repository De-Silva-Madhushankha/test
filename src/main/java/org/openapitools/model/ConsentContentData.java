package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.annotation.Generated;

/**
 * Consent content data containing status information (ACTV or RJCT)
 */
@Schema(name = "ConsentContentData", description = "Consent content data containing status information (ACTV or RJCT)")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:28:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public class ConsentContentData {

  /**
   * The status of the consent as per Berlin Group specification: - ACTV: Consent is active and valid - RJCT: Consent has been rejected 
   */
  public enum ConsentStatusEnum {
    ACTV("ACTV"),
    
    RJCT("RJCT"),
    
    RCVD("RCVD"),
    
    PDNG("PDNG"),
    
    EXPD("EXPD");

    private String value;

    ConsentStatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ConsentStatusEnum fromValue(String value) {
      for (ConsentStatusEnum b : ConsentStatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  @JsonProperty("consentStatus")
  private ConsentStatusEnum consentStatus;

  @JsonProperty("consentId")
  private String consentId;

  @JsonProperty("statusDescription")
  private String statusDescription;

  @JsonProperty("consentDetails")
  private Object consentDetails;

  @JsonProperty("rejectionReason")
  private String rejectionReason;

  public ConsentContentData consentStatus(ConsentStatusEnum consentStatus) {
    this.consentStatus = consentStatus;
    return this;
  }

  /**
   * The status of the consent as per Berlin Group specification: - ACTV: Consent is active and valid - RJCT: Consent has been rejected 
   * @return consentStatus
  */
  @NotNull 
  @Schema(name = "consentStatus", description = "The status of the consent as per Berlin Group specification: - ACTV: Consent is active and valid - RJCT: Consent has been rejected ", requiredMode = Schema.RequiredMode.REQUIRED)
  public ConsentStatusEnum getConsentStatus() {
    return consentStatus;
  }

  public void setConsentStatus(ConsentStatusEnum consentStatus) {
    this.consentStatus = consentStatus;
  }

  public ConsentContentData consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * The unique identifier of the consent
   * @return consentId
  */
  @NotNull 
  @Schema(name = "consentId", description = "The unique identifier of the consent", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public ConsentContentData statusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
    return this;
  }

  /**
   * Human-readable description of the consent status
   * @return statusDescription
  */
  
  @Schema(name = "statusDescription", description = "Human-readable description of the consent status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getStatusDescription() {
    return statusDescription;
  }

  public void setStatusDescription(String statusDescription) {
    this.statusDescription = statusDescription;
  }

  public ConsentContentData consentDetails(Object consentDetails) {
    this.consentDetails = consentDetails;
    return this;
  }

  /**
   * Additional consent details
   * @return consentDetails
  */
  
  @Schema(name = "consentDetails", description = "Additional consent details", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Object getConsentDetails() {
    return consentDetails;
  }

  public void setConsentDetails(Object consentDetails) {
    this.consentDetails = consentDetails;
  }

  public ConsentContentData rejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason;
    return this;
  }

  /**
   * Reason for rejection when status is RJCT
   * @return rejectionReason
  */
  
  @Schema(name = "rejectionReason", description = "Reason for rejection when status is RJCT", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public String getRejectionReason() {
    return rejectionReason;
  }

  public void setRejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentContentData consentContentData = (ConsentContentData) o;
    return Objects.equals(this.consentStatus, consentContentData.consentStatus) &&
        Objects.equals(this.consentId, consentContentData.consentId) &&
        Objects.equals(this.statusDescription, consentContentData.statusDescription) &&
        Objects.equals(this.consentDetails, consentContentData.consentDetails) &&
        Objects.equals(this.rejectionReason, consentContentData.rejectionReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentStatus, consentId, statusDescription, consentDetails, rejectionReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentContentData {\n");
    sb.append("    consentStatus: ").append(toIndentedString(consentStatus)).append("\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    statusDescription: ").append(toIndentedString(statusDescription)).append("\n");
    sb.append("    consentDetails: ").append(toIndentedString(consentDetails)).append("\n");
    sb.append("    rejectionReason: ").append(toIndentedString(rejectionReason)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
