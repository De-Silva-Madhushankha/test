# Berlin Group PSD2 Compliance Documentation

## REQ_0003: OAuth2 SCA Flow Consistency

### Overview

This document provides evidence and documentation for Berlin Group compliance requirement REQ_0003, which states:

> The flows for Redirect and OAuth2 SCA Approach with an explicit start of the Authorisation Process follow exactly the flow logic as described in the Payment Initiation Flows

### Compliance Statement

The WSO2 Financial Accelerator implements a **unified authorization flow architecture** that ensures identical flow logic between:
- **Account Information Service (AIS)** flows
- **Payment Initiation Service (PIS)** flows

Both service types utilize the same authorization extension points and flow sequence when using:
- Redirect approach with explicit authorization start
- OAuth2 SCA (Strong Customer Authentication) approach

### Authorization Flow Architecture

#### Unified Flow Sequence

Both AIS and PIS flows follow this identical sequence:

1. **Pre-Authorization Validation** (`/validate-authorization-request`)
   - Validates OAuth2/OIDC authorization request
   - Performs security checks before user authentication
   - Supports both Redirect and OAuth2 approaches
   - Implements SCA requirement validation

2. **Consent Authorization Screen** (`/populate-consent-authorize-screen`)
   - Loads consent data for user authorization
   - Displays permissions and account selection
   - Handles both AIS permissions and PIS payment details
   - Enforces explicit authorization start

3. **Consent Persistence** (`/persist-authorized-consent`)
   - Persists user authorization decision
   - Maps authorized accounts/resources
   - Stores SCA authentication evidence
   - Identical logic for AIS and PIS consent types

#### Flow Logic Consistency

The architecture ensures consistency through:

**1. Shared Extension Points**
- All authorization endpoints are service-type agnostic
- The same API contracts handle both AIS and PIS requests
- Flow logic is determined by consent type metadata, not separate codepaths

**2. Uniform Request/Response Structures**
- Common `ValidateAuthorizationRequestBody` schema
- Unified consent resource model with `type` discriminator
- Consistent error handling across service types

**3. Identical Security Controls**
- OAuth2 and BasicAuth security schemes apply uniformly
- SCA validation occurs at the same extension points
- Redirect flow handling is service-type independent

### Redirect Approach Implementation

#### Explicit Authorization Start

For both AIS and PIS, the explicit authorization flow:

1. **Authorization Request Initiation**
   ```
   Client → /authorize (OAuth2 endpoint)
   → /validate-authorization-request (extension point)
   ```
   - Validates request object parameters
   - Extracts consent reference (AIS) or payment reference (PIS)
   - Performs pre-authentication security checks

2. **User Authentication**
   ```
   → Authentication flow (SCA)
   → User credential validation
   ```
   - Strong Customer Authentication performed
   - Authentication method selection (biometric, OTP, etc.)

3. **Consent Authorization**
   ```
   → /populate-consent-authorize-screen
   → User consent/authorization UI
   → User grants authorization
   ```
   - Displays consent details (AIS permissions or PIS payment)
   - User explicitly authorizes the consent
   - Account selection (if applicable)

4. **Authorization Completion**
   ```
   → /persist-authorized-consent
   → Authorization code issued
   → Redirect to TPP callback
   ```
   - Consent status updated to authorized
   - Authorization code generated
   - Redirect to TPP with authorization code

### OAuth2 SCA Approach Implementation

#### SCA Requirements

The OAuth2 SCA approach enforces Strong Customer Authentication through:

**1. Authentication Context**
- ACR (Authentication Context Class Reference) values in authorization request
- SCA authentication methods: biometric, SMS OTP, hardware token, etc.
- Multi-factor authentication support

**2. SCA Validation Points**
- Pre-authorization: Validates SCA requirements in request
- During authentication: Enforces SCA method execution
- Post-authorization: Validates SCA completion before code issuance

**3. Unified SCA Handling**
Both AIS and PIS flows:
- Use identical OAuth2 authorization endpoint
- Validate SCA requirements at `/validate-authorization-request`
- Enforce authentication strength requirements
- Apply same timeout and session management rules

### Service Type Differentiation

While the **flow logic is identical**, service types are distinguished by:

**Consent Type Metadata**
```json
{
  "consentResource": {
    "type": "accounts" | "payments",
    "permissions": [...],    // AIS: account permissions
    "receipt": {...},        // PIS: payment receipt
    "status": "authorized"
  }
}
```

**Permission Model**
- **AIS**: Permissions array with account access scopes
- **PIS**: Receipt object with payment details

**Resource Authorization**
- **AIS**: Account IDs in authorization resource mapping
- **PIS**: Payment reference in authorization resource mapping

### Evidence of Consistency

#### API Design Evidence

1. **Shared Validation Endpoint**
   - `/validate-authorization-request` handles both AIS and PIS
   - No separate endpoints or flow branches based on service type
   - Single implementation ensures identical logic

2. **Unified Consent Model**
   - `ConsentResource` schema supports both service types
   - Type discriminator enables polymorphic handling
   - Same validation rules and status lifecycle

3. **Common Authorization Extensions**
   - All extension points are service-type agnostic
   - Implementers cannot create divergent flows
   - Framework enforces consistent behavior

#### Configuration Evidence

The OpenAPI specification (v1.0.3) demonstrates:
- No separate tags or paths for AIS vs PIS authorization
- Unified "Authorize" and "Consent" endpoint groups
- Identical security schemes for both service types
- Common error handling patterns

### Test Criteria Validation

#### Verification Approach

To verify AIS and PIS flows implement identical logic:

1. **Flow Sequence Test**
   - Execute AIS authorization flow
   - Execute PIS authorization flow
   - Assert: Same extension points called in same order

2. **Security Control Test**
   - Validate SCA enforcement for AIS
   - Validate SCA enforcement for PIS
   - Assert: Identical authentication requirements

3. **Error Handling Test**
   - Trigger validation errors in AIS flow
   - Trigger validation errors in PIS flow
   - Assert: Same error codes and descriptions

4. **Redirect Flow Test**
   - Complete redirect flow for AIS
   - Complete redirect flow for PIS
   - Assert: Same redirect parameters and behavior

### Compliance Summary

✅ **Flow Logic Consistency**: AIS and PIS use identical authorization flow sequence

✅ **Explicit Authorization Start**: Both service types support explicit authorization initiation via OAuth2 authorize endpoint

✅ **Redirect Approach**: Unified redirect flow implementation for AIS and PIS

✅ **OAuth2 SCA Approach**: Strong Customer Authentication applied uniformly across service types

✅ **Extension Point Consistency**: All customization points are service-type agnostic

### References

- OpenAPI Specification: `src/main/resources/openapi.yaml`
- Authorization Flow Validator: `src/main/java/org/openapitools/validator/AuthorizationFlowValidator.java`
- Berlin Group PSD2 Implementation Guidelines
- WSO2 Open Banking Documentation

---

**Version:** 1.0.0  
**Last Updated:** 2026-02-10  
**Status:** COMPLIANT
