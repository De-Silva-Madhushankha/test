# Consent Status Request Guide - Berlin Group Compliance

## Overview

This document describes the Consent Status Request functionality supported by this API, fulfilling the Berlin Group specification requirement **REQ_0008**: 

> "As shown in the Account Information Consent Flow diagram: The AISP MUST support Consent Status Request functionality"

## Consent Status Request Support

The API provides comprehensive support for AISPs (Account Information Service Providers) to query the status of consents through the consent retrieval and status query mechanisms.

## API Endpoints for Consent Status

### Primary Endpoint: `/consent-status-request`

**Purpose**: Allows AISPs to explicitly request the current status of a consent.

**HTTP Method**: POST

**Request Format**:
```json
{
  "requestId": "Ec1wMjmiG8",
  "data": {
    "consentId": "550e8400-e29b-41d4-a716-446655440000",
    "clientId": "client123",
    "requestHeaders": {
      "X-Request-ID": "99391c7e-ad88-49ec-a2ad-99ddcb1f7721"
    }
  }
}
```

**Successful Response (200 OK)**:
```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "SUCCESS",
  "data": {
    "consentId": "550e8400-e29b-41d4-a716-446655440000",
    "consentStatus": "authorised",
    "statusUpdateDateTime": "2024-02-10T10:30:00Z",
    "consentDetails": {
      "type": "accounts",
      "validityTime": 1707566200,
      "recurringIndicator": true,
      "frequency": 90
    }
  }
}
```

**Error Response (400 Bad Request)**:
```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "ERROR",
  "errorMessage": "invalid_request",
  "errorDescription": "Consent ID is missing or invalid"
}
```

**Error Response (404 Not Found)**:
```json
{
  "responseId": "Ec1wMjmiG8",
  "status": "ERROR",
  "errorMessage": "consent_not_found",
  "errorDescription": "The requested consent does not exist"
}
```

## Consent Status Values

The API supports the following consent status values in accordance with the Berlin Group specification:

| Status | Description |
|--------|-------------|
| `received` | Consent has been received but not yet authorized by the PSU |
| `valid` | Consent is authorized and valid for use |
| `rejected` | Consent has been rejected by the PSU |
| `revoked` | Consent has been revoked by the PSU |
| `expired` | Consent validity period has expired |
| `terminatedByTpp` | Consent has been terminated by the TPP |

## AISP Integration Guide

### Step 1: Obtain Consent ID

After creating a consent through the consent initiation flow, store the consent ID returned by the API.

### Step 2: Query Consent Status

Use the `/consent-status-request` endpoint to query the current status:

```bash
curl -X POST https://api.example.com/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_ACCESS_TOKEN" \
  -d '{
    "requestId": "unique-request-id",
    "data": {
      "consentId": "YOUR_CONSENT_ID",
      "clientId": "YOUR_CLIENT_ID"
    }
  }'
```

### Step 3: Handle the Response

```javascript
// Example: JavaScript/Node.js
const checkConsentStatus = async (consentId, clientId) => {
  const response = await fetch('https://api.example.com/consent-status-request', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${accessToken}`
    },
    body: JSON.stringify({
      requestId: generateUniqueId(),
      data: {
        consentId,
        clientId
      }
    })
  });
  
  const result = await response.json();
  
  if (result.status === 'SUCCESS') {
    const consentStatus = result.data.consentStatus;
    
    switch(consentStatus) {
      case 'valid':
        // Consent is active, proceed with account information request
        return { canProceed: true, status: consentStatus };
      case 'expired':
      case 'revoked':
      case 'terminatedByTpp':
        // Consent is no longer valid, require new consent
        return { canProceed: false, status: consentStatus };
      case 'received':
        // Consent is pending authorization
        return { canProceed: false, status: consentStatus, pending: true };
      case 'rejected':
        // Consent was rejected, cannot proceed
        return { canProceed: false, status: consentStatus };
      default:
        return { canProceed: false, status: consentStatus };
    }
  } else {
    // Handle error
    throw new Error(`Failed to check consent status: ${result.errorDescription}`);
  }
};
```

### Example: Python Implementation

```python
import requests
import uuid

def check_consent_status(consent_id, client_id, access_token):
    """
    Check the status of a consent
    
    Args:
        consent_id: The unique identifier of the consent
        client_id: The AISP client ID
        access_token: Valid access token for authentication
    
    Returns:
        dict: Consent status information
    """
    url = "https://api.example.com/consent-status-request"
    
    headers = {
        "Content-Type": "application/json",
        "Authorization": f"Bearer {access_token}"
    }
    
    payload = {
        "requestId": str(uuid.uuid4()),
        "data": {
            "consentId": consent_id,
            "clientId": client_id
        }
    }
    
    response = requests.post(url, json=payload, headers=headers)
    
    if response.status_code == 200:
        result = response.json()
        if result["status"] == "SUCCESS":
            return {
                "success": True,
                "consentStatus": result["data"]["consentStatus"],
                "details": result["data"]["consentDetails"]
            }
    
    return {
        "success": False,
        "error": response.json()
    }

# Usage example
status = check_consent_status(
    consent_id="550e8400-e29b-41d4-a716-446655440000",
    client_id="my-aisp-client",
    access_token="your-access-token"
)

if status["success"] and status["consentStatus"] == "valid":
    print("Consent is valid, proceeding with account information request")
else:
    print(f"Cannot proceed: {status.get('consentStatus', 'unknown')}")
```

## Account Information Consent Flow

The following diagram illustrates how consent status requests fit into the Berlin Group Account Information Consent Flow:

```
┌──────────┐                          ┌──────────┐                          ┌──────────┐
│   AISP   │                          │   ASPSP  │                          │   PSU    │
└────┬─────┘                          └────┬─────┘                          └────┬─────┘
     │                                     │                                     │
     │ 1. POST /consents                   │                                     │
     │────────────────────────────────────>│                                     │
     │                                     │                                     │
     │ 2. Consent Created (consentId)      │                                     │
     │<────────────────────────────────────│                                     │
     │                                     │                                     │
     │ 3. Redirect PSU to authorization    │                                     │
     │─────────────────────────────────────┼────────────────────────────────────>│
     │                                     │                                     │
     │                                     │ 4. PSU Authenticates & Authorizes   │
     │                                     │<────────────────────────────────────│
     │                                     │                                     │
     │ 5. Authorization Complete           │                                     │
     │<────────────────────────────────────┼─────────────────────────────────────│
     │                                     │                                     │
     │ 6. POST /consent-status-request     │                                     │
     │────────────────────────────────────>│                                     │
     │                                     │                                     │
     │ 7. Status Response (valid)          │                                     │
     │<────────────────────────────────────│                                     │
     │                                     │                                     │
     │ 8. GET /accounts (with consent)     │                                     │
     │────────────────────────────────────>│                                     │
     │                                     │                                     │
     │ 9. Account Information              │                                     │
     │<────────────────────────────────────│                                     │
     │                                     │                                     │
```

## Best Practices

### 1. Check Status Before Account Access

Always verify consent status before attempting to access account information:

```java
// Example: Java implementation
public class ConsentStatusChecker {
    
    public boolean canAccessAccounts(String consentId) {
        ConsentStatusResponse response = checkConsentStatus(consentId);
        
        if (response.getStatus().equals("SUCCESS")) {
            String consentStatus = response.getData().getConsentStatus();
            return "valid".equals(consentStatus);
        }
        
        return false;
    }
    
    public ConsentStatusResponse checkConsentStatus(String consentId) {
        // Implementation to call the API
        // Returns ConsentStatusResponse object
    }
}
```

### 2. Handle Status Changes

Monitor for status changes and handle them appropriately:

- **expired**: Request new consent from PSU
- **revoked**: Inform user and stop processing
- **rejected**: Do not retry, inform user

### 3. Cache Status Appropriately

- Cache status responses for short periods (e.g., 1-5 minutes)
- Always check status before critical operations
- Invalidate cache on errors or when consent is used

### 4. Implement Retry Logic

```python
import time

def check_consent_with_retry(consent_id, max_retries=3):
    for attempt in range(max_retries):
        try:
            status = check_consent_status(consent_id)
            return status
        except Exception as e:
            if attempt < max_retries - 1:
                time.sleep(2 ** attempt)  # Exponential backoff
                continue
            raise
```

## Security Considerations

1. **Authentication**: All consent status requests must be authenticated with valid access tokens
2. **Authorization**: Only the AISP that created the consent can query its status
3. **Rate Limiting**: Implement appropriate rate limiting to prevent abuse
4. **Audit Logging**: All status requests should be logged for audit purposes
5. **Data Privacy**: Consent status responses should not expose sensitive PSU data

## Error Handling

### Common Error Scenarios

| Error Code | Scenario | Recommended Action |
|------------|----------|-------------------|
| 400 | Invalid request format | Validate request payload |
| 401 | Unauthorized | Refresh access token |
| 404 | Consent not found | Verify consent ID |
| 500 | Server error | Retry with exponential backoff |

### Error Handling Example

```typescript
async function robustConsentStatusCheck(consentId: string): Promise<ConsentStatus> {
  try {
    const response = await checkConsentStatus(consentId);
    return response.data.consentStatus;
  } catch (error) {
    if (error.statusCode === 404) {
      throw new Error('Consent not found - may have been deleted');
    } else if (error.statusCode === 401) {
      // Refresh token and retry
      await refreshAccessToken();
      return robustConsentStatusCheck(consentId);
    } else if (error.statusCode >= 500) {
      // Server error - retry with backoff
      await delay(1000);
      return robustConsentStatusCheck(consentId);
    }
    throw error;
  }
}
```

## Compliance Verification

### Test Criteria

To verify AISP can send consent status requests and handle responses:

1. ✅ AISP can successfully send a consent status request with valid consent ID
2. ✅ AISP receives accurate status in the response
3. ✅ AISP can handle all possible consent status values
4. ✅ AISP properly handles error responses (400, 404, 500)
5. ✅ AISP verifies consent status before accessing account information

### Sample Test Cases

```gherkin
Feature: Consent Status Request

  Scenario: Successfully check status of valid consent
    Given an AISP has created a consent
    And the consent has been authorized by the PSU
    When the AISP sends a consent status request
    Then the response status should be "SUCCESS"
    And the consent status should be "valid"
    
  Scenario: Check status of expired consent
    Given an AISP has an expired consent
    When the AISP sends a consent status request
    Then the response status should be "SUCCESS"
    And the consent status should be "expired"
    
  Scenario: Check status of non-existent consent
    Given an AISP provides an invalid consent ID
    When the AISP sends a consent status request
    Then the response status code should be 404
    And the error message should indicate "consent_not_found"
```

## Additional Resources

- [Berlin Group NextGenPSD2 Framework](https://www.berlin-group.org/)
- [PSD2 Regulatory Technical Standards](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32018R0389)
- [WSO2 Open Banking Documentation](https://ob.docs.wso2.com/)

## Support

For questions or issues regarding consent status request functionality:
- Review the OpenAPI specification in `/src/main/resources/openapi.yaml`
- Check the API endpoint documentation at `/consent-status-request`
- Contact the API support team

## Changelog

### Version 1.0.3
- Added explicit consent status request endpoint `/consent-status-request`
- Added comprehensive documentation for Berlin Group REQ_0008 compliance
- Added request/response schemas for consent status operations
- Added support for all Berlin Group consent status values
- Added integration examples in JavaScript, Python, Java, and TypeScript

---

**Document Version**: 1.0  
**Last Updated**: 2024-02-11  
**Compliance**: Berlin Group NextGenPSD2 Framework  
**Requirement**: REQ_0008 - AISP Consent Status Request Support
