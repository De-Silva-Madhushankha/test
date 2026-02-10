# Authorization Confirmation Flow Documentation

## Overview

This document describes the explicit authorization confirmation flows implemented in compliance with the Berlin Group specification (REQ_0004). The authorization confirmation flows follow the same logical structure as Payment Initiation Flows to ensure consistency across all authorization patterns.

## Berlin Group Specification Compliance

**Requirement ID:** REQ_0004  
**Specification:** Berlin Group  
**Requirement:** The flows with integrating an explicit confirmation of an authorisation resource follow exactly the flow logic as described in the Payment Initiation Flows.

## Flow Architecture

### 1. Authorization Flow Phases

Both Payment Initiation and Authorization Confirmation flows follow the same four-phase pattern:

#### Phase 1: Pre-Processing & Validation
- **Endpoint:** `/validate-authorization-request`
- **Purpose:** Validate authorization request parameters before user interaction
- **Key Actions:**
  - Validate client credentials
  - Verify request parameters
  - Check authorization scope and permissions
  - Ensure compliance with regulatory requirements

#### Phase 2: Resource Presentation
- **Endpoint:** `/populate-consent-authorize-screen`
- **Purpose:** Prepare and display authorization details to the user
- **Key Actions:**
  - Load consent/payment details
  - Prepare account selection options
  - Display authorization scope and permissions
  - Present Terms & Conditions

#### Phase 3: Authorization Confirmation
- **Endpoint:** `/persist-authorized-consent`
- **Purpose:** Process and persist user's explicit authorization
- **Key Actions:**
  - Capture user's explicit consent/confirmation
  - Validate account selections
  - Persist authorization with user mappings
  - Generate authorization tokens

#### Phase 4: Post-Processing & Response Enrichment
- **Endpoints:** `/enrich-consent-creation-response`, `/enrich-consent-file-response`
- **Purpose:** Enrich response with additional data
- **Key Actions:**
  - Add metadata to response
  - Include authorization status
  - Provide resource URLs
  - Return confirmation details

### 2. Payment Initiation Flow Logic

The Payment Initiation Flow follows these steps:

1. **Initiation Request Validation**
   - Validate payment request parameters
   - Check debtor account permissions
   - Verify creditor account details
   - Validate amount and currency

2. **Payment Authorization Screen**
   - Display payment details
   - Show debtor and creditor information
   - Present amount and charges
   - Request SCA (Strong Customer Authentication)

3. **Payment Confirmation**
   - Capture SCA authentication
   - Persist payment authorization
   - Create payment resource
   - Update payment status

4. **Payment Response**
   - Return payment ID
   - Include authorization status
   - Provide status URLs
   - Return confirmation receipt

### 3. Authorization Confirmation Flow Logic

The Authorization Confirmation Flow mirrors the payment flow:

1. **Authorization Request Validation** (Equivalent to Payment Initiation)
   - Validate authorization parameters
   - Check resource permissions
   - Verify scope and permissions
   - Validate client credentials

2. **Authorization Screen** (Equivalent to Payment Authorization)
   - Display consent/authorization details
   - Show requested permissions
   - Present account selection
   - Request SCA if required

3. **Authorization Confirmation** (Equivalent to Payment Confirmation)
   - Capture explicit user confirmation
   - Persist authorization
   - Create consent resource
   - Update authorization status

4. **Authorization Response** (Equivalent to Payment Response)
   - Return consent/authorization ID
   - Include authorization status
   - Provide resource URLs
   - Return confirmation details

## Flow Consistency Requirements

To ensure compliance with REQ_0004, the following consistency requirements must be met:

### 1. Request Validation
- Both flows MUST perform equivalent validation checks
- Both flows MUST validate client credentials
- Both flows MUST check permissions and scope
- Both flows MUST enforce regulatory requirements

### 2. User Interaction
- Both flows MUST present clear authorization details
- Both flows MUST request explicit user confirmation
- Both flows MUST implement SCA when required
- Both flows MUST handle user cancellation identically

### 3. Authorization Persistence
- Both flows MUST persist authorization with same structure
- Both flows MUST include user-to-resource mappings
- Both flows MUST generate equivalent tokens
- Both flows MUST maintain audit trails

### 4. Response Structure
- Both flows MUST return consistent response formats
- Both flows MUST include authorization status
- Both flows MUST provide resource identifiers
- Both flows MUST include next action URLs

## Implementation Details

### Authorization Flow Validator

The `AuthorizationFlowValidator` class ensures flow consistency:

```java
public class AuthorizationFlowValidator {
    
    /**
     * Validates that authorization request follows payment flow logic
     */
    public ValidationResult validateAuthorizationRequest(AuthorizationRequest request);
    
    /**
     * Validates that authorization confirmation follows payment flow logic
     */
    public ValidationResult validateAuthorizationConfirmation(AuthorizationConfirmation confirmation);
    
    /**
     * Validates flow consistency between authorization and payment patterns
     */
    public ValidationResult validateFlowConsistency(FlowType source, FlowType target);
}
```

### Flow Validation Rules

1. **Pre-Validation Rules**
   - Request must contain valid client ID
   - Scope must be properly defined
   - Permissions must be explicit
   - Regulatory checks must pass

2. **Confirmation Rules**
   - User ID must be present
   - Account selection must be valid
   - SCA must be completed when required
   - Explicit confirmation must be captured

3. **Consistency Rules**
   - Authorization flow steps must match payment flow steps
   - Error handling must be consistent
   - Timeout handling must be identical
   - Status transitions must align

## API Endpoints

### 1. Validate Authorization Request
```
POST /validate-authorization-request
```
Validates authorization request before user interaction, following the same validation logic as payment initiation requests.

### 2. Populate Consent Authorize Screen
```
POST /populate-consent-authorize-screen
```
Prepares authorization screen data, mirroring the payment authorization screen preparation.

### 3. Persist Authorized Consent
```
POST /persist-authorized-consent
```
Processes and persists explicit authorization confirmation, following the same logic as payment confirmation.

### 4. Enrich Consent Response
```
POST /enrich-consent-creation-response
```
Enriches authorization response with additional data, consistent with payment response enrichment.

## Testing Requirements

### Unit Tests
- Validate authorization flow validator logic
- Test flow consistency validation
- Verify error handling consistency

### Integration Tests
- Test end-to-end authorization flow
- Verify payment-authorization flow consistency
- Test SCA integration
- Validate audit trail generation

### Compliance Tests
- Verify REQ_0004 compliance
- Test Berlin Group specification adherence
- Validate regulatory requirements

## Error Handling

Both authorization and payment flows implement consistent error handling:

1. **Validation Errors** (HTTP 400)
   - Invalid request parameters
   - Missing required fields
   - Invalid permissions

2. **Authorization Errors** (HTTP 401)
   - Invalid client credentials
   - Expired tokens
   - Insufficient permissions

3. **Business Logic Errors** (HTTP 422)
   - Invalid account selection
   - SCA failure
   - Regulatory violations

4. **Server Errors** (HTTP 500)
   - Database failures
   - External service failures
   - Unexpected exceptions

## Security Considerations

1. **Strong Customer Authentication (SCA)**
   - Both flows must implement SCA when required
   - SCA methods must be consistent
   - Fallback mechanisms must align

2. **Token Management**
   - Authorization tokens must have equivalent structure
   - Token expiration must be consistent
   - Token refresh must work identically

3. **Audit Logging**
   - Both flows must log equivalent events
   - Audit trail format must be consistent
   - Retention policies must align

## Conclusion

This documentation establishes that the explicit authorization confirmation flows follow exactly the same flow logic as described in the Payment Initiation Flows, ensuring full compliance with Berlin Group specification REQ_0004.

All authorization flows implement the four-phase pattern (Pre-Processing, Presentation, Confirmation, Post-Processing) with consistent validation, error handling, and security measures across both payment and authorization patterns.
