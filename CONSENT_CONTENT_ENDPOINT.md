# GET Consent-Content Endpoint - Berlin Group Compliance

## Overview

This document describes the implementation of the **GET Consent-Content** endpoint as required by the Berlin Group PSD2 specification (REQ_0011). This endpoint enables Account Servicing Payment Service Providers (ASPSPs) to respond to consent content requests with HTTP Status Code 200 (OK) containing consent status information.

## Compliance Requirement

**Requirement ID:** REQ_0011  
**Specification:** Berlin Group PSD2  
**Capability:** Consent Management  
**Strength:** MUST

### Requirement Statement

> As shown in the Account Information Consent Flow diagram: The ASPSP MUST respond to GET Consent-Content Requests with HTTP Status Code 200 (OK) containing ACTV, RJCT status information

## API Endpoint

### Endpoint Details

- **Path:** `/get-consent-content`
- **Method:** `POST`
- **Content-Type:** `application/json`
- **Response Type:** `application/json`

### Authentication

The endpoint supports the following authentication methods:
- OAuth2
- Basic Authentication

## Request Format

### Request Body Schema

```json
{
  "requestId": "string",
  "data": {
    "consentId": "string",
    "requestHeaders": {},
    "consentResourcePath": "string"
  }
}
```

### Request Parameters

| Parameter | Type | Required | Description |
|-----------|------|----------|-------------|
| `requestId` | string | Yes | A unique correlation identifier |
| `data.consentId` | string | Yes | The unique identifier of the consent |
| `data.requestHeaders` | object | No | Request headers sent by the TPP |
| `data.consentResourcePath` | string | No | To identify requested consent type |

### Example Request

```json
{
  "requestId": "Ec1wMjmiG8",
  "data": {
    "consentId": "consent-12345",
    "requestHeaders": {},
    "consentResourcePath": "/account-access-consents"
  }
}
```

## Response Format

### Success Response (HTTP 200)

The endpoint returns HTTP 200 for both successful retrievals of consent content, regardless of whether the consent status is ACTV (Active) or RJCT (Rejected).

#### Response Schema

```json
{
  "responseId": "string",
  "status": "SUCCESS",
  "data": {
    "consentStatus": "ACTV|RJCT|RCVD|PDNG|EXPD",
    "consentId": "string",
    "statusDescription": "string",
    "consentDetails": {},
    "rejectionReason": "string"
  }
}
```

#### Response Fields

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| `responseId` | string | Yes | Correlation identifier matching the request |
| `status` | string | Yes | Always "SUCCESS" for HTTP 200 responses |
| `data.consentStatus` | enum | Yes | Consent status: ACTV, RJCT, RCVD, PDNG, or EXPD |
| `data.consentId` | string | Yes | The unique identifier of the consent |
| `data.statusDescription` | string | No | Human-readable description of the consent status |
| `data.consentDetails` | object | No | Additional consent details (e.g., validUntil, permissions) |
| `data.rejectionReason` | string | No | Reason for rejection when status is RJCT |

### Consent Status Values

| Status | Description | Berlin Group Compliance |
|--------|-------------|------------------------|
| **ACTV** | Consent is active and valid | ✅ Required by REQ_0011 |
| **RJCT** | Consent has been rejected | ✅ Required by REQ_0011 |
| RCVD | Consent received but not yet processed | Optional |
| PDNG | Consent pending authorization | Optional |
| EXPD | Consent has expired | Optional |

## Example Responses

### Example 1: Active Consent (ACTV)

**HTTP 200 OK**

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "SUCCESS",
  "data": {
    "consentStatus": "ACTV",
    "consentId": "consent-12345",
    "statusDescription": "Consent is active",
    "consentDetails": {
      "validUntil": "2026-12-31T23:59:59Z",
      "permissions": [
        "ReadAccountsBasic",
        "ReadBalances",
        "ReadTransactions"
      ]
    }
  }
}
```

### Example 2: Rejected Consent (RJCT)

**HTTP 200 OK**

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "SUCCESS",
  "data": {
    "consentStatus": "RJCT",
    "consentId": "consent-12345",
    "statusDescription": "Consent has been rejected",
    "rejectionReason": "User denied consent"
  }
}
```

## Error Responses

### HTTP 400 - Bad Request

Returned when the request is malformed or missing required data.

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "ERROR",
  "errorMessage": "invalid_request",
  "errorDescription": "Data is missing"
}
```

### HTTP 500 - Server Error

Returned when an internal server error occurs.

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "ERROR",
  "errorMessage": "server_error",
  "errorDescription": "Failed to process the response"
}
```

## Implementation Details

### API Interface

The endpoint is implemented using Spring Boot with the following components:

1. **API Interface:** `GetConsentContentApi.java`
   - Defines the REST endpoint contract
   - Includes OpenAPI annotations for documentation
   - Located at: `src/main/java/org/openapitools/api/GetConsentContentApi.java`

2. **API Controller:** `GetConsentContentApiController.java`
   - Implements the API interface
   - Handles HTTP request/response mapping
   - Located at: `src/main/java/org/openapitools/api/GetConsentContentApiController.java`

### Data Models

The endpoint uses the following model classes:

1. **GetConsentContentRequestBody** - Request wrapper
2. **GetConsentContentRequestBodyData** - Request data payload
3. **Response200ForGetConsentContent** - Response wrapper
4. **SuccessResponseForGetConsentContent** - Success response structure
5. **ConsentContentData** - Consent content with status information
6. **ErrorResponse** - Error response structure
7. **FailedResponse** - Failed response structure

All model classes are located in: `src/main/java/org/openapitools/model/`

## OpenAPI Specification

The endpoint is defined in the OpenAPI specification file:
- **Location:** `src/main/resources/openapi.yaml`
- **Path:** `/get-consent-content`
- **Tags:** Consent

The specification includes:
- Detailed request/response schemas
- Example requests and responses for ACTV and RJCT statuses
- Error response definitions
- Security requirements

## Testing

To test the endpoint:

1. **Start the application:**
   ```bash
   mvn spring-boot:run
   ```

2. **Send a test request (Active Consent):**
   ```bash
   curl -X POST http://localhost:8080/wso2-f5b/OB4/1.0.0/get-consent-content \
     -H "Content-Type: application/json" \
     -H "Authorization: Bearer <token>" \
     -d '{
       "requestId": "test-12345",
       "data": {
         "consentId": "consent-active-001",
         "requestHeaders": {},
         "consentResourcePath": "/account-access-consents"
       }
     }'
   ```

3. **Expected Response:**
   - HTTP Status: 200 OK
   - Response Body: JSON with consentStatus of either ACTV or RJCT

## Compliance Verification

This implementation satisfies Berlin Group REQ_0011 by:

✅ **Providing a GET Consent-Content endpoint** that responds with HTTP 200  
✅ **Supporting ACTV status** with appropriate status information  
✅ **Supporting RJCT status** with rejection reason  
✅ **Including proper status descriptions** for both ACTV and RJCT  
✅ **Following Berlin Group consent flow patterns**  
✅ **Providing comprehensive documentation** of the endpoint functionality  
✅ **Including example responses** demonstrating ACTV and RJCT scenarios  

## Configuration

The endpoint uses the following configuration:

- **Base Path:** Configured via `openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path`
- **Default Base Path:** `/wso2-f5b/OB4/1.0.0`

You can override the base path in `application.properties`:

```properties
openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path=/custom/path
```

## Integration Guide

### For Third Party Providers (TPPs)

To integrate with this endpoint:

1. Obtain valid OAuth2 credentials or Basic Auth credentials
2. Make a POST request to `/get-consent-content` with a valid consent ID
3. Handle both ACTV and RJCT status responses appropriately
4. Implement proper error handling for 400 and 500 responses

### For ASPSP Implementers

To implement the business logic:

1. Override the default implementation in `GetConsentContentApiController`
2. Retrieve consent information from your consent management system
3. Map internal consent status to Berlin Group status codes (ACTV, RJCT, etc.)
4. Return appropriate status information and details
5. Ensure compliance with data protection regulations

## Security Considerations

- Always validate the consent ID belongs to the authenticated user/TPP
- Implement proper authorization checks before returning consent details
- Log all consent content access for audit purposes
- Ensure sensitive consent details are protected in transit (HTTPS)
- Follow GDPR and PSD2 data protection requirements

## Support and Maintenance

For questions or issues related to this endpoint:

1. Check the OpenAPI specification at `/api-docs` endpoint
2. Review the Berlin Group PSD2 specification documentation
3. Consult the WSO2 Open Banking documentation
4. Raise issues in the project repository

## Version History

- **v1.0.3** - Initial implementation of GET Consent-Content endpoint
  - Added ACTV and RJCT status support
  - Implemented Berlin Group REQ_0011 compliance
  - Added comprehensive documentation and examples
