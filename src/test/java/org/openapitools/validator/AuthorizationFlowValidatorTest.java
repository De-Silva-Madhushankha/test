package org.openapitools.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openapitools.validator.AuthorizationFlowValidator.AuthorizationApproach;
import org.openapitools.validator.AuthorizationFlowValidator.FlowValidationException;
import org.openapitools.validator.AuthorizationFlowValidator.ServiceType;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for AuthorizationFlowValidator
 * 
 * Tests Berlin Group REQ_0003 compliance: verifies that AIS and PIS flows
 * follow identical flow logic for Redirect and OAuth2 SCA approaches.
 */
@DisplayName("Authorization Flow Validator Tests - REQ_0003 Compliance")
class AuthorizationFlowValidatorTest {

    private AuthorizationFlowValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AuthorizationFlowValidator();
    }

    @Test
    @DisplayName("AIS flow with redirect approach follows correct sequence")
    void testAisRedirectFlowSequence() {
        // Given
        ServiceType serviceType = ServiceType.ACCOUNTS;
        AuthorizationApproach approach = AuthorizationApproach.REDIRECT;
        List<String> executedSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );

        // When/Then
        assertTrue(validator.validateFlowSequence(serviceType, approach, executedSteps));
    }

    @Test
    @DisplayName("PIS flow with redirect approach follows correct sequence")
    void testPisRedirectFlowSequence() {
        // Given
        ServiceType serviceType = ServiceType.PAYMENTS;
        AuthorizationApproach approach = AuthorizationApproach.REDIRECT;
        List<String> executedSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );

        // When/Then
        assertTrue(validator.validateFlowSequence(serviceType, approach, executedSteps));
    }

    @Test
    @DisplayName("AIS flow with OAuth2 SCA approach follows correct sequence")
    void testAisOauth2ScaFlowSequence() {
        // Given
        ServiceType serviceType = ServiceType.ACCOUNTS;
        AuthorizationApproach approach = AuthorizationApproach.OAUTH2_SCA;
        List<String> executedSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );

        // When/Then
        assertTrue(validator.validateFlowSequence(serviceType, approach, executedSteps));
    }

    @Test
    @DisplayName("PIS flow with OAuth2 SCA approach follows correct sequence")
    void testPisOauth2ScaFlowSequence() {
        // Given
        ServiceType serviceType = ServiceType.PAYMENTS;
        AuthorizationApproach approach = AuthorizationApproach.OAUTH2_SCA;
        List<String> executedSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );

        // When/Then
        assertTrue(validator.validateFlowSequence(serviceType, approach, executedSteps));
    }

    @Test
    @DisplayName("Both AIS and PIS flows use identical mandatory steps")
    void testBothServiceTypesUseSameMandatorySteps() {
        // Given
        List<String> mandatorySteps = AuthorizationFlowValidator.getMandatoryFlowSequence();
        
        // When - Execute flows for both service types
        ServiceType aisType = ServiceType.ACCOUNTS;
        ServiceType pisType = ServiceType.PAYMENTS;
        AuthorizationApproach approach = AuthorizationApproach.REDIRECT;
        
        // Then - Both should succeed with the same steps
        assertTrue(validator.validateFlowSequence(aisType, approach, mandatorySteps));
        assertTrue(validator.validateFlowSequence(pisType, approach, mandatorySteps));
    }

    @Test
    @DisplayName("Flow validation fails when mandatory step is missing")
    void testFlowValidationFailsWhenMandatoryStepMissing() {
        // Given
        ServiceType serviceType = ServiceType.ACCOUNTS;
        AuthorizationApproach approach = AuthorizationApproach.REDIRECT;
        List<String> executedSteps = Arrays.asList(
            "validate-authorization-request",
            "persist-authorized-consent" // Missing: populate-consent-authorize-screen
        );

        // When/Then
        FlowValidationException exception = assertThrows(
            FlowValidationException.class,
            () -> validator.validateFlowSequence(serviceType, approach, executedSteps)
        );
        assertTrue(exception.getMessage().contains("populate-consent-authorize-screen"));
    }

    @Test
    @DisplayName("Flow validation fails when steps are out of order")
    void testFlowValidationFailsWhenStepsOutOfOrder() {
        // Given
        ServiceType serviceType = ServiceType.PAYMENTS;
        AuthorizationApproach approach = AuthorizationApproach.REDIRECT;
        List<String> executedSteps = Arrays.asList(
            "populate-consent-authorize-screen", // Wrong: should be after validate-authorization-request
            "validate-authorization-request",
            "persist-authorized-consent"
        );

        // When/Then
        FlowValidationException exception = assertThrows(
            FlowValidationException.class,
            () -> validator.validateFlowSequence(serviceType, approach, executedSteps)
        );
        assertTrue(exception.getMessage().contains("Incorrect step order"));
    }

    @Test
    @DisplayName("SCA validation requires request object for explicit authorization start")
    void testScaValidationRequiresRequestObject() {
        // Given
        String validRequestObject = "{\"scope\":\"accounts\",\"response_type\":\"code\"}";

        // When/Then
        assertTrue(validator.validateScaRequirements(validRequestObject));
    }

    @Test
    @DisplayName("SCA validation fails with empty request object")
    void testScaValidationFailsWithEmptyRequestObject() {
        // Given
        String emptyRequestObject = "";

        // When/Then
        FlowValidationException exception = assertThrows(
            FlowValidationException.class,
            () -> validator.validateScaRequirements(emptyRequestObject)
        );
        assertTrue(exception.getMessage().contains("Explicit authorization start"));
    }

    @Test
    @DisplayName("Consent type validation accepts 'accounts' for AIS")
    void testConsentTypeValidationAcceptsAccounts() {
        // When/Then
        assertTrue(validator.validateConsentType("accounts"));
    }

    @Test
    @DisplayName("Consent type validation accepts 'payments' for PIS")
    void testConsentTypeValidationAcceptsPayments() {
        // When/Then
        assertTrue(validator.validateConsentType("payments"));
    }

    @Test
    @DisplayName("Consent type validation fails for invalid type")
    void testConsentTypeValidationFailsForInvalidType() {
        // Given
        String invalidType = "invalid-type";

        // When/Then
        FlowValidationException exception = assertThrows(
            FlowValidationException.class,
            () -> validator.validateConsentType(invalidType)
        );
        assertTrue(exception.getMessage().contains("Invalid consent type"));
    }

    @Test
    @DisplayName("Redirect parameters validation for AIS requires redirect URI and state")
    void testRedirectParametersValidationForAis() {
        // Given
        String redirectUri = "https://tpp.example.com/callback";
        String state = "xyz123";
        ServiceType serviceType = ServiceType.ACCOUNTS;

        // When/Then
        assertTrue(validator.validateRedirectParameters(redirectUri, state, serviceType));
    }

    @Test
    @DisplayName("Redirect parameters validation for PIS requires redirect URI and state")
    void testRedirectParametersValidationForPis() {
        // Given
        String redirectUri = "https://tpp.example.com/callback";
        String state = "abc456";
        ServiceType serviceType = ServiceType.PAYMENTS;

        // When/Then
        assertTrue(validator.validateRedirectParameters(redirectUri, state, serviceType));
    }

    @Test
    @DisplayName("Redirect parameters validation fails without redirect URI for both AIS and PIS")
    void testRedirectParametersValidationFailsWithoutRedirectUri() {
        // Given
        String emptyRedirectUri = "";
        String state = "xyz123";

        // When/Then - Test for AIS
        FlowValidationException aisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateRedirectParameters(emptyRedirectUri, state, ServiceType.ACCOUNTS)
        );
        assertTrue(aisException.getMessage().contains("Redirect URI is required"));

        // When/Then - Test for PIS
        FlowValidationException pisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateRedirectParameters(emptyRedirectUri, state, ServiceType.PAYMENTS)
        );
        assertTrue(pisException.getMessage().contains("Redirect URI is required"));
    }

    @Test
    @DisplayName("Redirect parameters validation fails without state parameter for both AIS and PIS")
    void testRedirectParametersValidationFailsWithoutState() {
        // Given
        String redirectUri = "https://tpp.example.com/callback";
        String emptyState = "";

        // When/Then - Test for AIS
        FlowValidationException aisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateRedirectParameters(redirectUri, emptyState, ServiceType.ACCOUNTS)
        );
        assertTrue(aisException.getMessage().contains("State parameter is required"));

        // When/Then - Test for PIS
        FlowValidationException pisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateRedirectParameters(redirectUri, emptyState, ServiceType.PAYMENTS)
        );
        assertTrue(pisException.getMessage().contains("State parameter is required"));
    }

    @Test
    @DisplayName("Authorization result validation for AIS requires authorization code and authorized status")
    void testAuthorizationResultValidationForAis() {
        // Given
        String authorizationCode = "auth_code_123";
        String consentStatus = "authorized";
        ServiceType serviceType = ServiceType.ACCOUNTS;

        // When/Then
        assertTrue(validator.validateAuthorizationResult(authorizationCode, consentStatus, serviceType));
    }

    @Test
    @DisplayName("Authorization result validation for PIS requires authorization code and authorized status")
    void testAuthorizationResultValidationForPis() {
        // Given
        String authorizationCode = "auth_code_456";
        String consentStatus = "authorized";
        ServiceType serviceType = ServiceType.PAYMENTS;

        // When/Then
        assertTrue(validator.validateAuthorizationResult(authorizationCode, consentStatus, serviceType));
    }

    @Test
    @DisplayName("Authorization result validation fails without authorization code for both AIS and PIS")
    void testAuthorizationResultValidationFailsWithoutCode() {
        // Given
        String emptyCode = "";
        String consentStatus = "authorized";

        // When/Then - Test for AIS
        FlowValidationException aisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateAuthorizationResult(emptyCode, consentStatus, ServiceType.ACCOUNTS)
        );
        assertTrue(aisException.getMessage().contains("Authorization code must be generated"));

        // When/Then - Test for PIS
        FlowValidationException pisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateAuthorizationResult(emptyCode, consentStatus, ServiceType.PAYMENTS)
        );
        assertTrue(pisException.getMessage().contains("Authorization code must be generated"));
    }

    @Test
    @DisplayName("Authorization result validation fails with incorrect consent status for both AIS and PIS")
    void testAuthorizationResultValidationFailsWithIncorrectStatus() {
        // Given
        String authorizationCode = "auth_code_123";
        String incorrectStatus = "pending";

        // When/Then - Test for AIS
        FlowValidationException aisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateAuthorizationResult(authorizationCode, incorrectStatus, ServiceType.ACCOUNTS)
        );
        assertTrue(aisException.getMessage().contains("Consent status must be 'authorized'"));

        // When/Then - Test for PIS
        FlowValidationException pisException = assertThrows(
            FlowValidationException.class,
            () -> validator.validateAuthorizationResult(authorizationCode, incorrectStatus, ServiceType.PAYMENTS)
        );
        assertTrue(pisException.getMessage().contains("Consent status must be 'authorized'"));
    }

    @Test
    @DisplayName("Flow validation with additional optional steps is allowed")
    void testFlowValidationWithAdditionalOptionalSteps() {
        // Given
        ServiceType serviceType = ServiceType.ACCOUNTS;
        AuthorizationApproach approach = AuthorizationApproach.REDIRECT;
        List<String> executedSteps = Arrays.asList(
            "pre-process-consent-creation", // Optional step before mandatory flow
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent",
            "enrich-consent-creation-response" // Optional step after mandatory flow
        );

        // When/Then
        assertTrue(validator.validateFlowSequence(serviceType, approach, executedSteps));
    }

    @Test
    @DisplayName("Service type enum correctly maps string values")
    void testServiceTypeEnumMapping() {
        // When/Then
        assertEquals(ServiceType.ACCOUNTS, ServiceType.fromValue("accounts"));
        assertEquals(ServiceType.PAYMENTS, ServiceType.fromValue("payments"));
        assertEquals("accounts", ServiceType.ACCOUNTS.getValue());
        assertEquals("payments", ServiceType.PAYMENTS.getValue());
    }

    @Test
    @DisplayName("Authorization approach enum has correct values")
    void testAuthorizationApproachEnum() {
        // When/Then
        assertEquals("redirect", AuthorizationApproach.REDIRECT.getValue());
        assertEquals("oauth2_sca", AuthorizationApproach.OAUTH2_SCA.getValue());
    }

    @Test
    @DisplayName("Mandatory flow sequence is consistent across all invocations")
    void testMandatoryFlowSequenceIsConsistent() {
        // When
        List<String> sequence1 = AuthorizationFlowValidator.getMandatoryFlowSequence();
        List<String> sequence2 = AuthorizationFlowValidator.getMandatoryFlowSequence();

        // Then
        assertEquals(sequence1, sequence2);
        assertEquals(3, sequence1.size());
        assertEquals("validate-authorization-request", sequence1.get(0));
        assertEquals("populate-consent-authorize-screen", sequence1.get(1));
        assertEquals("persist-authorized-consent", sequence1.get(2));
    }
}
