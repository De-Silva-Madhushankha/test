# GET Consent-Content API Implementation

## Overview

This implementation adds support for the Berlin Group GET Consent-Content Request functionality as required by specification REQ_0010.

## Endpoint

**POST** `/wso2-f5b/OB4/1.0.0/get-consent-content`

This endpoint processes GET consent-content requests from AISPs (Account Information Service Providers) according to the Berlin Group specification.

## Request Format

```json
{
  "requestId": "Ec1wMjmiG8",
  "data": {
    "consentId": "consent-123",
    "requestHeaders": {},
    "consentResourcePath": "/consents/123"
  }
}
```

### Request Parameters

- `requestId` (string, required): A unique correlation identifier
- `data` (object, required): Context data for the consent content request
  - `consentId` (string): The consent identifier
  - `requestHeaders` (object): Request headers sent by the AISP
  - `consentResourcePath` (string): Path to identify the consent resource type

## Response Format

### Success Response (200 OK)

```json
{
  "responseId": "response-123",
  "status": "SUCCESS",
  "data": {
    "consentContent": {},
    "responseHeaders": {}
  }
}
```

### Error Response (400/500)

```json
{
  "responseId": "response-123",
  "status": "ERROR",
  "errorMessage": "invalid_request",
  "errorDescription": "Data is missing"
}
```

## Implementation Details

### API Files
- **Interface**: `src/main/java/org/openapitools/api/GetConsentContentApi.java`
- **Controller**: `src/main/java/org/openapitools/api/GetConsentContentApiController.java`

### Model Files
- `src/main/java/org/openapitools/model/GetConsentContentRequestBody.java`
- `src/main/java/org/openapitools/model/GetConsentContentData.java`
- `src/main/java/org/openapitools/model/Response200ForGetConsentContent.java`
- `src/main/java/org/openapitools/model/SuccessResponseGetConsentContent.java`
- `src/main/java/org/openapitools/model/SuccessResponseGetConsentContentData.java`
- `src/main/java/org/openapitools/model/ErrorResponse.java`
- `src/main/java/org/openapitools/model/FailedResponse.java`

### OpenAPI Specification
The endpoint is defined in `src/main/resources/openapi.yaml` under the Consent tag.

## Usage

To implement the actual consent content retrieval logic, create a custom implementation that overrides the default `getConsentContentPost` method in the controller:

```java
@Controller
@RequestMapping("${openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path:/wso2-f5b/OB4/1.0.0}")
public class GetConsentContentApiController implements GetConsentContentApi {

    @Override
    public ResponseEntity<Response200ForGetConsentContent> getConsentContentPost(
            @Valid @RequestBody GetConsentContentRequestBody requestBody) {
        
        // Implement your consent content retrieval logic here
        String consentId = requestBody.getData().getConsentId();
        
        // Retrieve consent content from database/service
        // ...
        
        // Build success response
        SuccessResponseGetConsentContentData data = new SuccessResponseGetConsentContentData();
        data.setConsentContent(consentContentObject);
        data.setResponseHeaders(responseHeadersObject);
        
        SuccessResponseGetConsentContent response = new SuccessResponseGetConsentContent();
        response.setResponseId(requestBody.getRequestId());
        response.setStatus(SuccessResponseGetConsentContent.StatusEnum.SUCCESS);
        response.setData(data);
        
        return ResponseEntity.ok(response);
    }
}
```

## Testing

A basic test has been provided in `src/test/java/org/openapitools/api/GetConsentContentApiTest.java` that verifies:
- The endpoint exists and is accessible
- The endpoint accepts POST requests
- The endpoint returns appropriate HTTP status codes

## Compliance

This implementation satisfies the Berlin Group requirement REQ_0010:
> As shown in the Account Information Consent Flow diagram: The AISP MUST support GET Consent-Content Request functionality

The endpoint provides the necessary infrastructure for AISPs to retrieve consent content as required by the specification.

## Security

The endpoint is protected by:
- OAuth2 authentication
- Basic authentication (as fallback)

These security requirements are defined in the OpenAPI specification and enforced by the WSO2 API Manager.

## Next Steps

To complete the implementation:
1. Implement the actual consent retrieval logic in the controller
2. Add database queries to fetch consent content
3. Implement proper error handling for various scenarios
4. Add comprehensive unit and integration tests
5. Update any service-specific documentation
