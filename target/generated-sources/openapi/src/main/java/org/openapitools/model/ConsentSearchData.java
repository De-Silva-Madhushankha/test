package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * ConsentSearchData
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:54:49.542208308Z[Etc/UTC]")
public class ConsentSearchData {

  /**
   * Gets or Sets searchType
   */
  public enum SearchTypeEnum {
    BULK_SEARCH("BULK_SEARCH"),
    
    AMENDMENT_HISTORY("AMENDMENT_HISTORY");

    private String value;

    SearchTypeEnum(String value) {
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
    public static SearchTypeEnum fromValue(String value) {
      for (SearchTypeEnum b : SearchTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SearchTypeEnum searchType;

  private Object searchResult;

  private Object enrichmentParams;

  public ConsentSearchData searchType(SearchTypeEnum searchType) {
    this.searchType = searchType;
    return this;
  }

  /**
   * Get searchType
   * @return searchType
  */
  
  @Schema(name = "searchType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("searchType")
  public SearchTypeEnum getSearchType() {
    return searchType;
  }

  public void setSearchType(SearchTypeEnum searchType) {
    this.searchType = searchType;
  }

  public ConsentSearchData searchResult(Object searchResult) {
    this.searchResult = searchResult;
    return this;
  }

  /**
   * payload
   * @return searchResult
  */
  
  @Schema(name = "searchResult", description = "payload", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("searchResult")
  public Object getSearchResult() {
    return searchResult;
  }

  public void setSearchResult(Object searchResult) {
    this.searchResult = searchResult;
  }

  public ConsentSearchData enrichmentParams(Object enrichmentParams) {
    this.enrichmentParams = enrichmentParams;
    return this;
  }

  /**
   * query params
   * @return enrichmentParams
  */
  
  @Schema(name = "enrichmentParams", description = "query params", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("enrichmentParams")
  public Object getEnrichmentParams() {
    return enrichmentParams;
  }

  public void setEnrichmentParams(Object enrichmentParams) {
    this.enrichmentParams = enrichmentParams;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsentSearchData consentSearchData = (ConsentSearchData) o;
    return Objects.equals(this.searchType, consentSearchData.searchType) &&
        Objects.equals(this.searchResult, consentSearchData.searchResult) &&
        Objects.equals(this.enrichmentParams, consentSearchData.enrichmentParams);
  }

  @Override
  public int hashCode() {
    return Objects.hash(searchType, searchResult, enrichmentParams);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsentSearchData {\n");
    sb.append("    searchType: ").append(toIndentedString(searchType)).append("\n");
    sb.append("    searchResult: ").append(toIndentedString(searchResult)).append("\n");
    sb.append("    enrichmentParams: ").append(toIndentedString(enrichmentParams)).append("\n");
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

