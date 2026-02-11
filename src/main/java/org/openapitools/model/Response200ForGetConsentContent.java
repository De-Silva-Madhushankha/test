package org.openapitools.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.annotation.Generated;

/**
 * Response200ForGetConsentContent
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "status", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = SuccessResponseGetConsentContent.class, name = "SUCCESS"),
  @JsonSubTypes.Type(value = FailedResponse.class, name = "ERROR"),
})

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-11T10:30:00.000000000Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
public interface Response200ForGetConsentContent {

}
