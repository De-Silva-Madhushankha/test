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
 * SuccessResponseForConsentSearchData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:37:25.744256203Z[Etc/UTC]")
public class SuccessResponseForConsentSearchData {

  private Object enrichedSearchResult;

  public SuccessResponseForConsentSearchData enrichedSearchResult(Object enrichedSearchResult) {
    this.enrichedSearchResult = enrichedSearchResult;
    return this;
  }

  /**
   * Enriched search result
   * @return enrichedSearchResult
  */
  
  @Schema(name = "enrichedSearchResult", description = "Enriched search result", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enrichedSearchResult")
  public Object getEnrichedSearchResult() {
    return enrichedSearchResult;
  }

  public void setEnrichedSearchResult(Object enrichedSearchResult) {
    this.enrichedSearchResult = enrichedSearchResult;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SuccessResponseForConsentSearchData successResponseForConsentSearchData = (SuccessResponseForConsentSearchData) o;
    return Objects.equals(this.enrichedSearchResult, successResponseForConsentSearchData.enrichedSearchResult);
  }

  @Override
  public int hashCode() {
    return Objects.hash(enrichedSearchResult);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SuccessResponseForConsentSearchData {\n");
    sb.append("    enrichedSearchResult: ").append(toIndentedString(enrichedSearchResult)).append("\n");
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

