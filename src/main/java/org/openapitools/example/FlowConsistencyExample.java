package org.openapitools.example;

import org.openapitools.validator.AuthorizationFlowValidator;
import org.openapitools.validator.AuthorizationFlowValidator.AuthorizationApproach;
import org.openapitools.validator.AuthorizationFlowValidator.FlowValidationException;
import org.openapitools.validator.AuthorizationFlowValidator.ServiceType;

import java.util.Arrays;
import java.util.List;

/**
 * Example demonstrating REQ_0003 compliance validation.
 * 
 * This example shows how the AuthorizationFlowValidator ensures that
 * AIS (Account Information Service) and PIS (Payment Initiation Service)
 * flows follow identical logic.
 */
public class FlowConsistencyExample {

    public static void main(String[] args) {
        AuthorizationFlowValidator validator = new AuthorizationFlowValidator();
        
        System.out.println("=== REQ_0003 Flow Consistency Demonstration ===\n");
        
        // Demonstrate AIS flow with Redirect approach
        demonstrateAisRedirectFlow(validator);
        
        // Demonstrate PIS flow with Redirect approach
        demonstratePisRedirectFlow(validator);
        
        // Demonstrate AIS flow with OAuth2 SCA approach
        demonstrateAisOauth2ScaFlow(validator);
        
        // Demonstrate PIS flow with OAuth2 SCA approach
        demonstratePisOauth2ScaFlow(validator);
        
        // Demonstrate flow validation failure
        demonstrateFlowValidationFailure(validator);
        
        System.out.println("\n=== Conclusion ===");
        System.out.println("Both AIS and PIS flows use the same mandatory sequence:");
        List<String> mandatorySequence = AuthorizationFlowValidator.getMandatoryFlowSequence();
        for (int i = 0; i < mandatorySequence.size(); i++) {
            System.out.println((i + 1) + ". " + mandatorySequence.get(i));
        }
        System.out.println("\nThis demonstrates compliance with Berlin Group REQ_0003.");
    }
    
    private static void demonstrateAisRedirectFlow(AuthorizationFlowValidator validator) {
        System.out.println("1. AIS Flow with Redirect Approach");
        System.out.println("   Service Type: ACCOUNTS");
        System.out.println("   Approach: REDIRECT");
        
        List<String> aisSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );
        
        try {
            boolean isValid = validator.validateFlowSequence(
                ServiceType.ACCOUNTS,
                AuthorizationApproach.REDIRECT,
                aisSteps
            );
            System.out.println("   Result: ✓ VALID - Flow follows correct sequence\n");
        } catch (FlowValidationException e) {
            System.out.println("   Result: ✗ INVALID - " + e.getMessage() + "\n");
        }
    }
    
    private static void demonstratePisRedirectFlow(AuthorizationFlowValidator validator) {
        System.out.println("2. PIS Flow with Redirect Approach");
        System.out.println("   Service Type: PAYMENTS");
        System.out.println("   Approach: REDIRECT");
        
        List<String> pisSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );
        
        try {
            boolean isValid = validator.validateFlowSequence(
                ServiceType.PAYMENTS,
                AuthorizationApproach.REDIRECT,
                pisSteps
            );
            System.out.println("   Result: ✓ VALID - Flow follows correct sequence");
            System.out.println("   Note: Uses IDENTICAL sequence as AIS flow\n");
        } catch (FlowValidationException e) {
            System.out.println("   Result: ✗ INVALID - " + e.getMessage() + "\n");
        }
    }
    
    private static void demonstrateAisOauth2ScaFlow(AuthorizationFlowValidator validator) {
        System.out.println("3. AIS Flow with OAuth2 SCA Approach");
        System.out.println("   Service Type: ACCOUNTS");
        System.out.println("   Approach: OAUTH2_SCA");
        
        List<String> aisSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );
        
        try {
            boolean isValid = validator.validateFlowSequence(
                ServiceType.ACCOUNTS,
                AuthorizationApproach.OAUTH2_SCA,
                aisSteps
            );
            
            // Also validate SCA requirements
            String requestObject = "{\"scope\":\"accounts\",\"response_type\":\"code\",\"acr_values\":\"urn:openbanking:psd2:sca\"}";
            validator.validateScaRequirements(requestObject);
            
            System.out.println("   Result: ✓ VALID - Flow follows correct sequence with SCA\n");
        } catch (FlowValidationException e) {
            System.out.println("   Result: ✗ INVALID - " + e.getMessage() + "\n");
        }
    }
    
    private static void demonstratePisOauth2ScaFlow(AuthorizationFlowValidator validator) {
        System.out.println("4. PIS Flow with OAuth2 SCA Approach");
        System.out.println("   Service Type: PAYMENTS");
        System.out.println("   Approach: OAUTH2_SCA");
        
        List<String> pisSteps = Arrays.asList(
            "validate-authorization-request",
            "populate-consent-authorize-screen",
            "persist-authorized-consent"
        );
        
        try {
            boolean isValid = validator.validateFlowSequence(
                ServiceType.PAYMENTS,
                AuthorizationApproach.OAUTH2_SCA,
                pisSteps
            );
            
            // Also validate SCA requirements
            String requestObject = "{\"scope\":\"payments\",\"response_type\":\"code\",\"acr_values\":\"urn:openbanking:psd2:sca\"}";
            validator.validateScaRequirements(requestObject);
            
            System.out.println("   Result: ✓ VALID - Flow follows correct sequence with SCA");
            System.out.println("   Note: Uses IDENTICAL sequence as AIS flow\n");
        } catch (FlowValidationException e) {
            System.out.println("   Result: ✗ INVALID - " + e.getMessage() + "\n");
        }
    }
    
    private static void demonstrateFlowValidationFailure(AuthorizationFlowValidator validator) {
        System.out.println("5. Example of Flow Validation Failure");
        System.out.println("   Service Type: ACCOUNTS");
        System.out.println("   Approach: REDIRECT");
        System.out.println("   Issue: Missing mandatory step");
        
        // This flow is missing "populate-consent-authorize-screen"
        List<String> invalidSteps = Arrays.asList(
            "validate-authorization-request",
            "persist-authorized-consent"
        );
        
        try {
            validator.validateFlowSequence(
                ServiceType.ACCOUNTS,
                AuthorizationApproach.REDIRECT,
                invalidSteps
            );
            System.out.println("   Result: ✓ VALID\n");
        } catch (FlowValidationException e) {
            System.out.println("   Result: ✗ INVALID - " + e.getMessage());
            System.out.println("   This demonstrates the validator catching non-compliant flows\n");
        }
    }
}
