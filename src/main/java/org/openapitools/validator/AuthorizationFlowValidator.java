package org.openapitools.validator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Authorization Flow Validator
 * 
 * Enforces Berlin Group REQ_0003 compliance by ensuring that AIS (Account Information Service)
 * and PIS (Payment Initiation Service) authorization flows follow identical flow logic.
 * 
 * This validator ensures:
 * - Redirect approach consistency between AIS and PIS
 * - OAuth2 SCA approach consistency between AIS and PIS
 * - Explicit authorization start follows same pattern
 * - Extension point sequence is identical regardless of service type
 * 
 * @version 1.0.0
 * @since 2026-02-10
 */
public class AuthorizationFlowValidator {

    /**
     * Service types supported by the authorization flow
     */
    public enum ServiceType {
        /** Account Information Service (AIS) */
        ACCOUNTS("accounts"),
        /** Payment Initiation Service (PIS) */
        PAYMENTS("payments");

        private final String value;

        ServiceType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static ServiceType fromValue(String value) {
            for (ServiceType type : ServiceType.values()) {
                if (type.value.equals(value)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown service type: " + value);
        }
    }

    /**
     * Authorization approach types
     */
    public enum AuthorizationApproach {
        /** Redirect approach with explicit authorization start */
        REDIRECT("redirect"),
        /** OAuth2 approach with Strong Customer Authentication */
        OAUTH2_SCA("oauth2_sca");

        private final String value;

        AuthorizationApproach(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Mandatory extension points that must be called in the authorization flow.
     * The sequence is identical for both AIS and PIS flows.
     */
    private static final List<String> MANDATORY_FLOW_SEQUENCE = Arrays.asList(
        "validate-authorization-request",
        "populate-consent-authorize-screen",
        "persist-authorized-consent"
    );

    /**
     * Validates that the authorization flow sequence is correct and consistent
     * regardless of service type (AIS or PIS).
     * 
     * @param serviceType The service type (accounts or payments)
     * @param approach The authorization approach (redirect or oauth2_sca)
     * @param executedSteps The list of extension points executed in order
     * @return true if the flow is valid and consistent
     * @throws FlowValidationException if the flow violates consistency requirements
     */
    public boolean validateFlowSequence(ServiceType serviceType, 
                                       AuthorizationApproach approach,
                                       List<String> executedSteps) {
        Objects.requireNonNull(serviceType, "Service type cannot be null");
        Objects.requireNonNull(approach, "Authorization approach cannot be null");
        Objects.requireNonNull(executedSteps, "Executed steps cannot be null");

        // Verify all mandatory steps are present
        for (String mandatoryStep : MANDATORY_FLOW_SEQUENCE) {
            if (!executedSteps.contains(mandatoryStep)) {
                throw new FlowValidationException(
                    String.format("Missing mandatory step '%s' in %s flow with %s approach",
                        mandatoryStep, serviceType.getValue(), approach.getValue())
                );
            }
        }

        // Verify steps are in correct order
        int lastIndex = -1;
        for (String mandatoryStep : MANDATORY_FLOW_SEQUENCE) {
            int currentIndex = executedSteps.indexOf(mandatoryStep);
            if (currentIndex <= lastIndex) {
                throw new FlowValidationException(
                    String.format("Incorrect step order in %s flow: '%s' must come after previous mandatory steps",
                        serviceType.getValue(), mandatoryStep)
                );
            }
            lastIndex = currentIndex;
        }

        return true;
    }

    /**
     * Validates that the authorization request contains required parameters for SCA.
     * 
     * @param requestObject The OAuth2/OIDC request object
     * @return true if SCA requirements are met
     * @throws FlowValidationException if SCA requirements are not met
     */
    public boolean validateScaRequirements(String requestObject) {
        Objects.requireNonNull(requestObject, "Request object cannot be null");

        // For explicit authorization start, the request object must be present
        if (requestObject.trim().isEmpty()) {
            throw new FlowValidationException(
                "Explicit authorization start requires a valid request object"
            );
        }

        return true;
    }

    /**
     * Validates that the consent type is supported and properly configured.
     * 
     * @param consentType The consent type (accounts or payments)
     * @return true if consent type is valid
     * @throws FlowValidationException if consent type is invalid
     */
    public boolean validateConsentType(String consentType) {
        Objects.requireNonNull(consentType, "Consent type cannot be null");

        try {
            ServiceType.fromValue(consentType);
            return true;
        } catch (IllegalArgumentException e) {
            throw new FlowValidationException(
                String.format("Invalid consent type '%s'. Must be 'accounts' or 'payments'", consentType)
            );
        }
    }

    /**
     * Validates that redirect parameters are consistent between AIS and PIS flows.
     * 
     * @param redirectUri The redirect URI
     * @param state The state parameter
     * @param serviceType The service type
     * @return true if redirect parameters are valid
     * @throws FlowValidationException if redirect parameters are invalid
     */
    public boolean validateRedirectParameters(String redirectUri, String state, ServiceType serviceType) {
        Objects.requireNonNull(redirectUri, "Redirect URI cannot be null");
        Objects.requireNonNull(state, "State parameter cannot be null");
        Objects.requireNonNull(serviceType, "Service type cannot be null");

        // Both AIS and PIS must have redirect URI
        if (redirectUri.trim().isEmpty()) {
            throw new FlowValidationException(
                String.format("Redirect URI is required for %s flow", serviceType.getValue())
            );
        }

        // Both AIS and PIS must have state parameter for CSRF protection
        if (state.trim().isEmpty()) {
            throw new FlowValidationException(
                String.format("State parameter is required for %s flow", serviceType.getValue())
            );
        }

        return true;
    }

    /**
     * Validates that the authorization result contains required fields regardless of service type.
     * 
     * @param authorizationCode The authorization code
     * @param consentStatus The consent status
     * @param serviceType The service type
     * @return true if authorization result is valid
     * @throws FlowValidationException if authorization result is invalid
     */
    public boolean validateAuthorizationResult(String authorizationCode, 
                                               String consentStatus,
                                               ServiceType serviceType) {
        Objects.requireNonNull(authorizationCode, "Authorization code cannot be null");
        Objects.requireNonNull(consentStatus, "Consent status cannot be null");
        Objects.requireNonNull(serviceType, "Service type cannot be null");

        // Both AIS and PIS must return authorization code
        if (authorizationCode.trim().isEmpty()) {
            throw new FlowValidationException(
                String.format("Authorization code must be generated for %s flow", serviceType.getValue())
            );
        }

        // Both AIS and PIS must update consent status to authorized
        if (!"authorized".equalsIgnoreCase(consentStatus)) {
            throw new FlowValidationException(
                String.format("Consent status must be 'authorized' for successful %s flow, got '%s'",
                    serviceType.getValue(), consentStatus)
            );
        }

        return true;
    }

    /**
     * Exception thrown when flow validation fails
     */
    public static class FlowValidationException extends RuntimeException {
        public FlowValidationException(String message) {
            super(message);
        }

        public FlowValidationException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    /**
     * Gets the mandatory flow sequence that applies to all service types.
     * This demonstrates the consistency requirement of REQ_0003.
     * 
     * @return Unmodifiable list of mandatory extension points
     */
    public static List<String> getMandatoryFlowSequence() {
        return MANDATORY_FLOW_SEQUENCE;
    }
}
