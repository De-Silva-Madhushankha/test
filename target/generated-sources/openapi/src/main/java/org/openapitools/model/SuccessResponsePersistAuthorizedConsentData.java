package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.model.DetailedConsentResourceDataWithAmendments;
import org.openapitools.model.SuccessResponseWithDetailedConsentData;
import org.openapitools.model.SuccessResponseWithDetailedConsentDataAndAmendments;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:59:49.370250334Z[Etc/UTC]")
public interface SuccessResponsePersistAuthorizedConsentData {
}
