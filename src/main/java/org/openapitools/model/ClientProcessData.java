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
 * Defines the context data related to the client registration.
 */

@Schema(name = "ClientProcessData", description = "Defines the context data related to the client registration.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:37:25.744256203Z[Etc/UTC]")
public class ClientProcessData {

  private Object clientData;

  private Object softwareStatement;

  private Object existingClientData;

  public ClientProcessData clientData(Object clientData) {
    this.clientData = clientData;
    return this;
  }

  /**
   * Client Registration Data. Mandatory for pre-process-client-creation and pre-process-client-update.
   * @return clientData
  */
  
  @Schema(name = "clientData", description = "Client Registration Data. Mandatory for pre-process-client-creation and pre-process-client-update.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientData")
  public Object getClientData() {
    return clientData;
  }

  public void setClientData(Object clientData) {
    this.clientData = clientData;
  }

  public ClientProcessData softwareStatement(Object softwareStatement) {
    this.softwareStatement = softwareStatement;
    return this;
  }

  /**
   * Parameters of the decoded SSA. Mandatory for pre-process-client-creation, pre-process-client-update and pre-process-client-retrieval.
   * @return softwareStatement
  */
  
  @Schema(name = "softwareStatement", description = "Parameters of the decoded SSA. Mandatory for pre-process-client-creation, pre-process-client-update and pre-process-client-retrieval.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("softwareStatement")
  public Object getSoftwareStatement() {
    return softwareStatement;
  }

  public void setSoftwareStatement(Object softwareStatement) {
    this.softwareStatement = softwareStatement;
  }

  public ClientProcessData existingClientData(Object existingClientData) {
    this.existingClientData = existingClientData;
    return this;
  }

  /**
   * properties of the existing client application. Mandatory for pre-process-client-update.
   * @return existingClientData
  */
  
  @Schema(name = "existingClientData", description = "properties of the existing client application. Mandatory for pre-process-client-update.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("existingClientData")
  public Object getExistingClientData() {
    return existingClientData;
  }

  public void setExistingClientData(Object existingClientData) {
    this.existingClientData = existingClientData;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientProcessData clientProcessData = (ClientProcessData) o;
    return Objects.equals(this.clientData, clientProcessData.clientData) &&
        Objects.equals(this.softwareStatement, clientProcessData.softwareStatement) &&
        Objects.equals(this.existingClientData, clientProcessData.existingClientData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientData, softwareStatement, existingClientData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClientProcessData {\n");
    sb.append("    clientData: ").append(toIndentedString(clientData)).append("\n");
    sb.append("    softwareStatement: ").append(toIndentedString(softwareStatement)).append("\n");
    sb.append("    existingClientData: ").append(toIndentedString(existingClientData)).append("\n");
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

