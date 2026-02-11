# Test Cases for Consent Status Request (REQ_0008)

This document outlines the test cases for verifying Berlin Group REQ_0008 compliance: AISP Consent Status Request Functionality.

## Test Environment Setup

### Prerequisites
- API server running (default: `http://localhost:8080`)
- Valid OAuth2 access token or Basic Auth credentials
- Test consent IDs created through the consent creation flow

### Test Data

```json
{
  "validConsentId": "550e8400-e29b-41d4-a716-446655440000",
  "expiredConsentId": "660e8400-e29b-41d4-a716-446655440001",
  "revokedConsentId": "770e8400-e29b-41d4-a716-446655440002",
  "invalidConsentId": "invalid-consent-id",
  "nonExistentConsentId": "880e8400-e29b-41d4-a716-446655440099",
  "testClientId": "test-aisp-client"
}
```

## Test Suite

### Test Case 1: Successful Consent Status Request for Valid Consent

**Objective**: Verify AISP can successfully query the status of a valid, authorized consent.

**Pre-conditions**:
- A consent has been created and authorized
- AISP has valid authentication credentials

**Test Steps**:
1. Send POST request to `/consent-status-request`
2. Include valid `consentId` and `clientId` in request body
3. Include proper authentication headers

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${ACCESS_TOKEN}" \
  -d '{
    "requestId": "test-001",
    "data": {
      "consentId": "550e8400-e29b-41d4-a716-446655440000",
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- HTTP Status Code: `200 OK`
- Response body contains:
  - `status`: "SUCCESS"
  - `data.consentStatus`: "valid" or "received" or other valid status
  - `data.consentId`: matches request
  - `data.statusUpdateDateTime`: valid ISO 8601 timestamp
  - `data.consentDetails`: object with consent metadata

**Pass Criteria**: ✅
- Response status is 200
- Response structure matches schema
- Consent status is one of the valid Berlin Group values

---

### Test Case 2: Consent Status Request for Expired Consent

**Objective**: Verify AISP receives correct status for an expired consent.

**Pre-conditions**:
- A consent exists that has passed its validity period

**Test Steps**:
1. Send POST request to `/consent-status-request` with expired consent ID
2. Verify response indicates "expired" status

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${ACCESS_TOKEN}" \
  -d '{
    "requestId": "test-002",
    "data": {
      "consentId": "660e8400-e29b-41d4-a716-446655440001",
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- HTTP Status Code: `200 OK`
- `status`: "SUCCESS"
- `data.consentStatus`: "expired"

**Pass Criteria**: ✅
- Expired consent is correctly identified
- Status is "expired"

---

### Test Case 3: Consent Status Request for Revoked Consent

**Objective**: Verify AISP can detect that a consent has been revoked.

**Pre-conditions**:
- A consent that has been revoked by the PSU

**Test Steps**:
1. Send POST request with revoked consent ID
2. Verify response indicates "revoked" status

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${ACCESS_TOKEN}" \
  -d '{
    "requestId": "test-003",
    "data": {
      "consentId": "770e8400-e29b-41d4-a716-446655440002",
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- HTTP Status Code: `200 OK`
- `status`: "SUCCESS"
- `data.consentStatus`: "revoked"

**Pass Criteria**: ✅
- Revoked consent is correctly identified
- AISP can distinguish between expired and revoked consents

---

### Test Case 4: Invalid Request - Missing Consent ID

**Objective**: Verify API properly validates required fields.

**Test Steps**:
1. Send request without `consentId` field
2. Verify appropriate error response

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${ACCESS_TOKEN}" \
  -d '{
    "requestId": "test-004",
    "data": {
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- HTTP Status Code: `400 Bad Request`
- Response body contains:
  - `status`: "ERROR"
  - `errorMessage`: "invalid_request"
  - `errorDescription`: descriptive message about missing consent ID

**Pass Criteria**: ✅
- Request validation works correctly
- Meaningful error message returned

---

### Test Case 5: Consent Not Found

**Objective**: Verify API handles non-existent consent IDs appropriately.

**Test Steps**:
1. Send request with a consent ID that doesn't exist
2. Verify 404 response

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${ACCESS_TOKEN}" \
  -d '{
    "requestId": "test-005",
    "data": {
      "consentId": "880e8400-e29b-41d4-a716-446655440099",
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- HTTP Status Code: `404 Not Found`
- Response body contains:
  - `status`: "ERROR"
  - `errorMessage`: "consent_not_found"
  - `errorDescription`: "The requested consent does not exist"

**Pass Criteria**: ✅
- Non-existent consents result in 404
- Error message is clear

---

### Test Case 6: Unauthorized Request

**Objective**: Verify authentication is required.

**Test Steps**:
1. Send request without authentication headers
2. Verify 401 response

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -d '{
    "requestId": "test-006",
    "data": {
      "consentId": "550e8400-e29b-41d4-a716-446655440000",
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- HTTP Status Code: `401 Unauthorized`
- Appropriate authentication challenge

**Pass Criteria**: ✅
- Authentication is enforced
- Proper HTTP status code returned

---

### Test Case 7: All Consent Status Values

**Objective**: Verify all Berlin Group consent status values are supported.

**Test Steps**:
For each status value (received, valid, rejected, revoked, expired, terminatedByTpp):
1. Create/obtain a consent in that status
2. Query the status
3. Verify the response correctly reflects the status

**Expected Result**:
All six Berlin Group status values can be returned and distinguished:
- ✅ `received`
- ✅ `valid`
- ✅ `rejected`
- ✅ `revoked`
- ✅ `expired`
- ✅ `terminatedByTpp`

**Pass Criteria**: ✅
- All status values are supported
- Each status has distinct meaning
- AISP can make decisions based on each status

---

### Test Case 8: Consent Status with Metadata

**Objective**: Verify response includes consent metadata.

**Test Steps**:
1. Query status for a consent
2. Verify metadata fields are present

**Request**:
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer ${ACCESS_TOKEN}" \
  -d '{
    "requestId": "test-008",
    "data": {
      "consentId": "550e8400-e29b-41d4-a716-446655440000",
      "clientId": "test-aisp-client"
    }
  }'
```

**Expected Result**:
- Response includes `consentDetails` object with:
  - `type`: consent type (e.g., "accounts")
  - `validityTime`: expiration timestamp
  - `recurringIndicator`: boolean
  - `frequency`: integer (optional)

**Pass Criteria**: ✅
- Metadata is included in response
- AISP can use metadata for decision making

---

### Test Case 9: Rate Limiting (Optional)

**Objective**: Verify rate limiting is implemented.

**Test Steps**:
1. Send multiple rapid requests to `/consent-status-request`
2. Observe if rate limiting is enforced

**Expected Result**:
- After exceeding rate limit: HTTP Status `429 Too Many Requests`
- Response includes `Retry-After` header

**Pass Criteria**: ✅ (Optional)
- Rate limiting protects the API
- Clear guidance on retry timing

---

### Test Case 10: Integration Flow Test

**Objective**: Verify complete AISP flow including status check.

**Test Steps**:
1. Create a new consent via consent creation endpoint
2. PSU authorizes the consent
3. AISP checks consent status
4. If status is "valid", AISP accesses account information
5. Later, PSU revokes consent
6. AISP checks status again and receives "revoked"
7. AISP stops accessing account information

**Expected Result**:
- Complete flow works end-to-end
- Status accurately reflects consent lifecycle
- AISP can make appropriate decisions at each stage

**Pass Criteria**: ✅
- Full integration works
- Status changes are immediately reflected
- AISP can rely on status for access decisions

---

## Test Execution Checklist

### Manual Testing
- [ ] Test Case 1: Valid consent status query
- [ ] Test Case 2: Expired consent
- [ ] Test Case 3: Revoked consent
- [ ] Test Case 4: Invalid request
- [ ] Test Case 5: Consent not found
- [ ] Test Case 6: Unauthorized request
- [ ] Test Case 7: All status values
- [ ] Test Case 8: Metadata included
- [ ] Test Case 9: Rate limiting (optional)
- [ ] Test Case 10: Integration flow

### Automated Testing
- [ ] Unit tests for consent status logic
- [ ] Integration tests for API endpoint
- [ ] Schema validation tests
- [ ] Performance tests

### Compliance Verification
- [ ] ✅ AISP can send consent status requests
- [ ] ✅ AISP receives accurate status in responses
- [ ] ✅ AISP can handle all Berlin Group status values
- [ ] ✅ AISP properly handles error responses
- [ ] ✅ Status is verified before account access

## Test Report Template

```markdown
# Test Execution Report

**Date**: YYYY-MM-DD
**Tester**: [Name]
**Environment**: [Test/Staging/Production]

## Summary
- Total Tests: 10
- Passed: X
- Failed: Y
- Blocked: Z

## Test Results

| Test Case | Status | Notes |
|-----------|--------|-------|
| TC-001 | PASS | |
| TC-002 | PASS | |
| TC-003 | FAIL | Status returned as "terminated" instead of "revoked" |
| ... | ... | ... |

## Issues Found
1. [Issue description]
2. [Issue description]

## Compliance Assessment
REQ_0008 Compliance: ✅ PASS / ❌ FAIL

**Justification**: [Explanation of compliance status]
```

## Continuous Testing

### Recommended Test Frequency
- **Every deployment**: Run full test suite
- **Daily**: Automated smoke tests (TC-001, TC-006)
- **Weekly**: Full regression testing
- **After consent model changes**: Complete re-test

### Monitoring
- Set up alerts for consent status request failures
- Monitor response times
- Track error rates by error type
- Log all consent status transitions

---

**Document Version**: 1.0  
**Last Updated**: 2024-02-11  
**Compliance**: Berlin Group REQ_0008  
**Status**: Ready for Execution
