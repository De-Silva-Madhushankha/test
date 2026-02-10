# Payment Initiation Flow Reference Implementation

## Overview

This document provides the reference implementation logic for Payment Initiation Flows as specified in the Berlin Group standard. This serves as the baseline pattern that all explicit authorization confirmation flows must follow to ensure compliance with REQ_0004.

## Berlin Group Payment Initiation Standard

The Payment Initiation Service (PIS) allows Third Party Payment Service Providers (TPPs) to initiate payments on behalf of Payment Service Users (PSUs). The flow ensures secure, standardized payment processing across all financial institutions.

## Payment Initiation Flow Sequence

### Step 1: Payment Initiation Request

**Endpoint:** POST /v1/{payment-service}/{payment-product}

**Request Components:**
- Debtor Account (PSU account to be debited)
- Creditor Account (Beneficiary account)
- Instructed Amount (Amount and currency)
- Remittance Information (Payment reference)
- Payment Purpose (Optional)

**Validation Requirements:**
1. Valid TPP certificate and authorization
2. Debtor account format validation
3. Creditor account format validation
4. Amount and currency validation
5. Regulatory checks (sanctions, AML)
6. Account access permission verification

**Response:**
- Payment Initiation ID
- Transaction Status
- Authorization links (if SCA required)
- Self link to payment resource

### Step 2: Payment Authorization Request

**Endpoint:** GET /v1/consents/{consentId}/authorisations

**Purpose:** Obtain authorization from PSU for the payment

**Process:**
1. Redirect PSU to ASPSP authorization endpoint
2. PSU authenticates with ASPSP
3. Display payment details to PSU
4. Request explicit confirmation

**Authorization Screen Must Display:**
- Payment amount and currency
- Debtor account details
- Creditor account details
- Payment reference
- Execution date
- Charges (if applicable)
- Terms and conditions

**User Actions:**
- Select debtor account (if multiple accounts)
- Review payment details
- Perform Strong Customer Authentication (SCA)
- Provide explicit consent/confirmation
- Or cancel/reject the payment

### Step 3: Authorization Confirmation

**Endpoint:** PUT /v1/consents/{consentId}/authorisations/{authorisationId}

**Process:**
1. Capture SCA authentication result
2. Validate authentication data
3. Persist authorization decision
4. Update payment status

**SCA Methods (One or more required):**
- Knowledge (PIN, Password)
- Possession (SMS OTP, Hardware Token)
- Inherence (Biometric - Fingerprint, Face Recognition)

**Persistence Requirements:**
- Store authorization timestamp
- Record PSU identifier
- Save selected debtor account
- Log authentication method
- Store authorization status
- Create audit trail

**Status Transitions:**
- RCVD (Received) → ACTC (Accepted Technical Correct)
- ACTC → ACWC (Accepted with Change)
- ACWC → ACSC (Accepted Settlement Completed)
- Any → RJCT (Rejected)

### Step 4: Payment Resource Creation

**Endpoint:** GET /v1/{payment-service}/{payment-product}/{paymentId}

**Response Components:**
1. **Payment Resource:**
   - Payment ID
   - Transaction Status
   - Debtor Account
   - Creditor Account
   - Instructed Amount
   - Authorization details

2. **Authorization Resource:**
   - Authorization ID
   - PSU identification
   - Authentication method
   - Authorization timestamp
   - Selected accounts

3. **Links:**
   - Self (payment resource)
   - Status (payment status endpoint)
   - Authorization (if multi-step SCA)

### Step 5: Status Updates and Notifications

**Status Query Endpoint:** GET /v1/{payment-service}/{payment-product}/{paymentId}/status

**Status Values:**
- RCVD: Payment received
- PDNG: Pending
- ACTC: Accepted
- ACSC: Settlement completed
- RJCT: Rejected
- CANC: Cancelled

## Flow Logic Components

### 1. Request Validation Logic

```java
class PaymentValidationLogic {
    // Validate request structure
    validateRequestStructure(PaymentRequest request);
    
    // Validate client credentials
    validateClientCredentials(String clientId, String certificate);
    
    // Validate account permissions
    validateAccountAccess(String account, String clientId);
    
    // Validate payment parameters
    validatePaymentDetails(PaymentDetails details);
    
    // Regulatory checks
    performRegulatoryChecks(PaymentRequest request);
}
```

### 2. Authorization Logic

```java
class PaymentAuthorizationLogic {
    // Prepare authorization screen
    prepareAuthorizationScreen(PaymentId paymentId);
    
    // Request SCA
    initiateSCA(String psuId, SCMethod method);
    
    // Validate SCA
    validateSCA(String scaData, String psuId);
    
    // Capture explicit confirmation
    captureConfirmation(String psuId, boolean confirmed);
}
```

### 3. Persistence Logic

```java
class PaymentPersistenceLogic {
    // Create payment resource
    createPaymentResource(PaymentRequest request);
    
    // Persist authorization
    persistAuthorization(AuthorizationData data);
    
    // Update payment status
    updatePaymentStatus(PaymentId id, Status status);
    
    // Create audit trail
    logAuditEvent(AuditEvent event);
}
```

### 4. Response Logic

```java
class PaymentResponseLogic {
    // Build payment response
    buildPaymentResponse(PaymentResource resource);
    
    // Add authorization links
    addAuthorizationLinks(Response response, PaymentId id);
    
    // Enrich response data
    enrichResponse(Response response, AdditionalData data);
    
    // Format error response
    formatErrorResponse(Error error);
}
```

## Flow Consistency Rules

### Rule 1: Sequential Processing
- All steps must be executed in order
- No step can be skipped
- Previous step must complete before next step starts

### Rule 2: Validation Before Authorization
- All validation must occur before authorization request
- Invalid requests must be rejected at validation phase
- Authorization screen must only show valid payment details

### Rule 3: Explicit Confirmation Required
- PSU must provide explicit confirmation
- Implicit consent is not sufficient
- Confirmation must be captured and logged

### Rule 4: SCA Enforcement
- SCA must be performed when required by regulation
- SCA method must meet regulatory requirements
- SCA result must be validated and logged

### Rule 5: Consistent Error Handling
- Errors must follow standard format
- Error codes must be from Berlin Group standard
- Error responses must include actionable information

### Rule 6: Audit Trail
- All actions must be logged
- Logs must include timestamp, user, action
- Audit trail must be immutable

## Data Model

### Payment Resource
```json
{
  "paymentId": "string",
  "transactionStatus": "ACTC",
  "debtorAccount": {
    "iban": "string",
    "currency": "EUR"
  },
  "creditorAccount": {
    "iban": "string",
    "currency": "EUR"
  },
  "instructedAmount": {
    "amount": "100.00",
    "currency": "EUR"
  },
  "remittanceInformationUnstructured": "Payment reference",
  "requestedExecutionDate": "2024-01-01",
  "_links": {
    "self": "/v1/payments/sepa-credit-transfers/paymentId",
    "status": "/v1/payments/sepa-credit-transfers/paymentId/status"
  }
}
```

### Authorization Resource
```json
{
  "authorisationId": "string",
  "scaStatus": "finalised",
  "psuData": {
    "psuId": "string",
    "psuIdType": "string"
  },
  "selectedScaMethod": {
    "authenticationType": "SMS_OTP",
    "authenticationMethodId": "string"
  },
  "scaAuthenticationData": "string",
  "_links": {
    "scaStatus": "/v1/payments/sepa-credit-transfers/paymentId/authorisations/authorisationId"
  }
}
```

## Security Requirements

### 1. Authentication
- Qualified certificate (eIDAS) for TPP
- OAuth2 token for API access
- PSU authentication at ASPSP

### 2. Authorization
- PSU explicit consent required
- SCA when regulatory threshold exceeded
- Account access permission validation

### 3. Data Protection
- TLS 1.2+ for all communications
- No sensitive data in logs
- PCI DSS compliance for payment data

### 4. Non-Repudiation
- Cryptographic signatures on requests
- Audit trail of all actions
- Legal evidence of authorization

## Integration Points

### External Systems
1. **Core Banking System** - Account validation and payment execution
2. **SCA Provider** - Strong Customer Authentication
3. **AML/Sanctions Screening** - Regulatory compliance checks
4. **Audit System** - Immutable audit trail

### Internal Services
1. **Token Service** - OAuth2 token management
2. **Certificate Service** - TPP certificate validation
3. **Consent Management** - Authorization persistence
4. **Notification Service** - Status updates to TPP

## Error Scenarios

### Validation Errors
- FORMAT_ERROR: Invalid request format
- PARAMETER_NOT_SUPPORTED: Unsupported parameter
- PRODUCT_INVALID: Invalid payment product
- PRODUCT_UNKNOWN: Unknown payment product

### Authorization Errors
- UNAUTHORIZED: Invalid TPP credentials
- CONSENT_UNKNOWN: Invalid consent ID
- CONSENT_INVALID: Consent not valid
- CONSENT_EXPIRED: Consent expired

### Business Errors
- PAYMENT_FAILED: Payment execution failed
- INSUFFICIENT_FUNDS: Insufficient account balance
- BLOCKED_ACCOUNT: Account blocked
- CONSENT_INVALID: PSU did not authorize

### Technical Errors
- INTERNAL_SERVER_ERROR: Unexpected system error
- SERVICE_UNAVAILABLE: Core banking unavailable
- TIMEOUT: Request timeout

## Compliance Checklist

- [ ] TPP authenticated with qualified certificate
- [ ] Payment request validated per Berlin Group standard
- [ ] PSU redirected to authorization endpoint
- [ ] Payment details displayed to PSU
- [ ] Explicit PSU confirmation captured
- [ ] SCA performed when required
- [ ] Authorization persisted with audit trail
- [ ] Payment status updated correctly
- [ ] Response follows Berlin Group format
- [ ] Error handling per Berlin Group standard

## Conclusion

This Payment Initiation Flow reference implementation provides the baseline logic that all authorization confirmation flows must follow. The key principles are:

1. **Sequential Processing** - Steps must be completed in order
2. **Explicit Confirmation** - PSU must explicitly consent
3. **Strong Customer Authentication** - SCA when required
4. **Consistent Validation** - Same checks across all flows
5. **Audit Trail** - Complete logging of all actions

Any authorization confirmation flow must implement these same principles to ensure compliance with Berlin Group specification REQ_0004.
