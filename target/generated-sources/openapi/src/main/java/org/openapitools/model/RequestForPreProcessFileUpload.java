package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.StoredDetailedConsentResourceData;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * RequestForPreProcessFileUpload
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:56:14.691566349Z[Etc/UTC]")
public class RequestForPreProcessFileUpload {

  private String consentId;

  private StoredDetailedConsentResourceData consentResource;

  private String fileContent;

  private String consentResourcePath;

  private Object requestHeaders;

  public RequestForPreProcessFileUpload consentId(String consentId) {
    this.consentId = consentId;
    return this;
  }

  /**
   * To identify requested
   * @return consentId
  */
  
  @Schema(name = "consentId", description = "To identify requested", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentId")
  public String getConsentId() {
    return consentId;
  }

  public void setConsentId(String consentId) {
    this.consentId = consentId;
  }

  public RequestForPreProcessFileUpload consentResource(StoredDetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
    return this;
  }

  /**
   * Get consentResource
   * @return consentResource
  */
  @Valid 
  @Schema(name = "consentResource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentResource")
  public StoredDetailedConsentResourceData getConsentResource() {
    return consentResource;
  }

  public void setConsentResource(StoredDetailedConsentResourceData consentResource) {
    this.consentResource = consentResource;
  }

  public RequestForPreProcessFileUpload fileContent(String fileContent) {
    this.fileContent = fileContent;
    return this;
  }

  /**
   * content of the uploaded file
   * @return fileContent
  */
  
  @Schema(name = "fileContent", description = "content of the uploaded file", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("fileContent")
  public String getFileContent() {
    return fileContent;
  }

  public void setFileContent(String fileContent) {
    this.fileContent = fileContent;
  }

  public RequestForPreProcessFileUpload consentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
    return this;
  }

  /**
   * consent resource path
   * @return consentResourcePath
  */
  
  @Schema(name = "consentResourcePath", description = "consent resource path", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("consentResourcePath")
  public String getConsentResourcePath() {
    return consentResourcePath;
  }

  public void setConsentResourcePath(String consentResourcePath) {
    this.consentResourcePath = consentResourcePath;
  }

  public RequestForPreProcessFileUpload requestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
    return this;
  }

  /**
   * Request headers sent by the TPP. Filtered set of headers are sent to the external service.
   * @return requestHeaders
  */
  
  @Schema(name = "requestHeaders", description = "Request headers sent by the TPP. Filtered set of headers are sent to the external service.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestHeaders")
  public Object getRequestHeaders() {
    return requestHeaders;
  }

  public void setRequestHeaders(Object requestHeaders) {
    this.requestHeaders = requestHeaders;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestForPreProcessFileUpload requestForPreProcessFileUpload = (RequestForPreProcessFileUpload) o;
    return Objects.equals(this.consentId, requestForPreProcessFileUpload.consentId) &&
        Objects.equals(this.consentResource, requestForPreProcessFileUpload.consentResource) &&
        Objects.equals(this.fileContent, requestForPreProcessFileUpload.fileContent) &&
        Objects.equals(this.consentResourcePath, requestForPreProcessFileUpload.consentResourcePath) &&
        Objects.equals(this.requestHeaders, requestForPreProcessFileUpload.requestHeaders);
  }

  @Override
  public int hashCode() {
    return Objects.hash(consentId, consentResource, fileContent, consentResourcePath, requestHeaders);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestForPreProcessFileUpload {\n");
    sb.append("    consentId: ").append(toIndentedString(consentId)).append("\n");
    sb.append("    consentResource: ").append(toIndentedString(consentResource)).append("\n");
    sb.append("    fileContent: ").append(toIndentedString(fileContent)).append("\n");
    sb.append("    consentResourcePath: ").append(toIndentedString(consentResourcePath)).append("\n");
    sb.append("    requestHeaders: ").append(toIndentedString(requestHeaders)).append("\n");
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

