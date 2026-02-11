# Consent Status Endpoint Documentation

## Overview

This document describes the Consent Status endpoint implementation for Berlin Group compliance (REQ_0009). The endpoint provides consent status information with HATEOAS (Hypermedia as the Engine of Application State) links, complying with the Berlin Group PSD2 API specification.

## Endpoint Details

### POST /get-consent-status

Retrieves the current status of a consent with HATEOAS navigation links.

**Endpoint:** `/get-consent-status`  
**Method:** POST  
**Content-Type:** application/json  
**Security:** OAuth2 or BasicAuth

## Request Format

### Request Body

```json
{
  "requestId": "Ec1wMjmiG8",
  "data": {
    "consentId": "7890-asdf-4567",
    "clientId": "client123"
  }
}
```

### Request Parameters

| Field | Type | Required | Description |
|-------|------|----------|-------------|
| requestId | string | Yes | A unique correlation identifier for tracking the request |
| data | object | Yes | Container for the consent status request data |
| data.consentId | string | Yes | The unique identifier of the consent |
| data.clientId | string | No | The client identifier (optional) |

## Response Format

### Success Response (HTTP 200)

The ASPSP returns HTTP Status Code 200 (OK) with the consent status and HATEOAS links:

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "SUCCESS",
  "data": {
    "consentId": "7890-asdf-4567",
    "consentStatus": "authorised",
    "_links": {
      "self": {
        "href": "/consents/7890-asdf-4567/status"
      },
      "consent": {
        "href": "/consents/7890-asdf-4567"
      }
    }
  }
}
```

### Response Fields

| Field | Type | Description |
|-------|------|-------------|
| responseId | string | Correlation identifier matching the request |
| status | string | Outcome of the request (SUCCESS or ERROR) |
| data | object | Container for the consent status data |
| data.consentId | string | The consent identifier |
| data.consentStatus | string | Current status of the consent (see Consent Status Values) |
| data._links | object | HATEOAS navigation links |

### Consent Status Values

The consent can have the following status values:

| Status | Description |
|--------|-------------|
| `received` | The consent has been received but not yet processed |
| `valid` | The consent is valid and can be used |
| `rejected` | The consent has been rejected |
| `authorised` | The consent has been authorised by the PSU |
| `revoked` | The consent has been revoked |
| `expired` | The consent has expired |
| `terminatedByTpp` | The consent has been terminated by the TPP |

### HATEOAS Links

The response includes hypermedia links following the HATEOAS principle:

| Link Name | Description |
|-----------|-------------|
| self | Link to the consent status endpoint itself |
| consent | Link to the full consent resource |
| scaStatus | (Optional) Link to the SCA status endpoint |
| scaOAuth | (Optional) Link to the OAuth SCA endpoint |

## Error Responses

### Bad Request (HTTP 400)

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "ERROR",
  "errorMessage": "invalid_request",
  "errorDescription": "Consent ID is missing or invalid"
}
```

### Server Error (HTTP 500)

```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "ERROR",
  "errorMessage": "server_error",
  "errorDescription": "Failed to retrieve consent status"
}
```

## Usage Examples

### Using cURL

```bash
curl -X POST https://api.example.com/wso2-f5b/OB4/1.0.0/get-consent-status \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
  -d '{
    "requestId": "Ec1wMjmiG8",
    "data": {
      "consentId": "7890-asdf-4567",
      "clientId": "client123"
    }
  }'
```

### Using Java (Spring RestTemplate)

```java
RestTemplate restTemplate = new RestTemplate();
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);
headers.setBearerAuth(accessToken);

ConsentStatusRequestData data = new ConsentStatusRequestData();
data.setConsentId("7890-asdf-4567");
data.setClientId("client123");

ConsentStatusRequestBody requestBody = new ConsentStatusRequestBody();
requestBody.setRequestId("Ec1wMjmiG8");
requestBody.setData(data);

HttpEntity<ConsentStatusRequestBody> entity = new HttpEntity<>(requestBody, headers);

ResponseEntity<ConsentStatusResponse> response = restTemplate.exchange(
    "https://api.example.com/wso2-f5b/OB4/1.0.0/get-consent-status",
    HttpMethod.POST,
    entity,
    ConsentStatusResponse.class
);

ConsentStatusResponse consentStatus = response.getBody();
System.out.println("Consent Status: " + consentStatus.getData().getConsentStatus());
```

### Using JavaScript (Fetch API)

```javascript
const requestBody = {
  requestId: 'Ec1wMjmiG8',
  data: {
    consentId: '7890-asdf-4567',
    clientId: 'client123'
  }
};

fetch('https://api.example.com/wso2-f5b/OB4/1.0.0/get-consent-status', {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'Authorization': 'Bearer YOUR_ACCESS_TOKEN'
  },
  body: JSON.stringify(requestBody)
})
  .then(response => response.json())
  .then(data => {
    console.log('Consent Status:', data.data.consentStatus);
    console.log('HATEOAS Links:', data.data._links);
  })
  .catch(error => console.error('Error:', error));
```

## Berlin Group Compliance

This endpoint implementation addresses the Berlin Group PSD2 API requirement:

**REQ_0009:** "As shown in the Account Information Consent Flow diagram: The ASPSP MUST respond to Consent Status Requests with appropriate status information and HTTP Status Code 200 (OK) with HATEOAS Status"

### Compliance Features

1. ✅ **HTTP 200 Response**: Returns HTTP Status Code 200 for successful requests
2. ✅ **Status Information**: Provides comprehensive consent status values
3. ✅ **HATEOAS Links**: Includes hypermedia links for navigation following REST best practices
4. ✅ **Berlin Group Status Values**: Supports all Berlin Group defined consent statuses

## Implementation Notes

### Extension Point

This endpoint is part of the WSO2 Open Banking Accelerator extension point framework. The implementation can be customized by:

1. Implementing the `GetConsentStatusApi` interface
2. Overriding the `getConsentStatusPost()` method in `GetConsentStatusApiController`
3. Adding custom business logic for consent status retrieval
4. Enriching HATEOAS links based on consent state

### Model Classes

The following model classes are generated from the OpenAPI specification:

- `ConsentStatusRequestBody` - Request wrapper
- `ConsentStatusRequestData` - Request data
- `ConsentStatusResponse` - Response wrapper
- `ConsentStatusData` - Response data with status and HATEOAS links
- `HATEOASLinks` - Container for hypermedia links
- `HATEOASLink` - Individual hypermedia link

## Testing

To test the endpoint:

1. Start the application
2. Obtain a valid OAuth2 access token
3. Send a POST request to `/get-consent-status` with a valid consent ID
4. Verify the response includes:
   - HTTP 200 status code
   - Consent status value
   - HATEOAS `_links` object with at least a `self` link

## References

- [Berlin Group NextGenPSD2 XS2A Framework](https://www.berlin-group.org/)
- [WSO2 Open Banking Documentation](https://ob.docs.wso2.com/)
- [HATEOAS Principle](https://en.wikipedia.org/wiki/HATEOAS)
- [PSD2 Regulatory Technical Standards](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32018R0389)
