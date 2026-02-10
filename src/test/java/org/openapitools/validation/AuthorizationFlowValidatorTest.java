package org.openapitools.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for AuthorizationFlowValidator to ensure compliance with REQ_0004.
 * Tests verify that authorization flows follow payment flow logic.
 */
@DisplayName("Authorization Flow Validator Tests - REQ_0004 Compliance")
class AuthorizationFlowValidatorTest {

    private AuthorizationFlowValidator validator;

    @BeforeEach
    void setUp() {
        validator = new AuthorizationFlowValidator();
    }

    @Test
    @DisplayName("Valid authorization request should pass validation")
    void testValidAuthorizationRequest() {
        // Arrange
        String clientId = "client123";
        String requestId = "req456";
        String scope = "accounts";
        List<String> permissions = Arrays.asList("ReadAccountsBasic", "ReadBalances");

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationRequest(clientId, requestId, scope, permissions);

        // Assert
        assertTrue(result.isValid(), "Valid authorization request should pass");
        assertEquals("Authorization request validation passed - follows payment flow logic", 
                    result.getFirstMessage());
    }

    @Test
    @DisplayName("Authorization request without client ID should fail")
    void testAuthorizationRequestWithoutClientId() {
        // Arrange
        String requestId = "req456";
        String scope = "accounts";
        List<String> permissions = Arrays.asList("ReadAccountsBasic");

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationRequest(null, requestId, scope, permissions);

        // Assert
        assertFalse(result.isValid(), "Authorization request without client ID should fail");
        assertTrue(result.getMessages().get(0).contains("Client ID is required"));
    }

    @Test
    @DisplayName("Authorization request without request ID should fail")
    void testAuthorizationRequestWithoutRequestId() {
        // Arrange
        String clientId = "client123";
        String scope = "accounts";
        List<String> permissions = Arrays.asList("ReadAccountsBasic");

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationRequest(clientId, null, scope, permissions);

        // Assert
        assertFalse(result.isValid(), "Authorization request without request ID should fail");
        assertTrue(result.getMessages().get(0).contains("Request ID is required"));
    }

    @Test
    @DisplayName("Authorization request without scope should fail")
    void testAuthorizationRequestWithoutScope() {
        // Arrange
        String clientId = "client123";
        String requestId = "req456";
        List<String> permissions = Arrays.asList("ReadAccountsBasic");

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationRequest(clientId, requestId, null, permissions);

        // Assert
        assertFalse(result.isValid(), "Authorization request without scope should fail");
        assertTrue(result.getMessages().get(0).contains("Authorization scope is required"));
    }

    @Test
    @DisplayName("Authorization request without permissions should fail")
    void testAuthorizationRequestWithoutPermissions() {
        // Arrange
        String clientId = "client123";
        String requestId = "req456";
        String scope = "accounts";

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationRequest(clientId, requestId, scope, Collections.emptyList());

        // Assert
        assertFalse(result.isValid(), "Authorization request without permissions should fail");
        assertTrue(result.getMessages().get(0).contains("Explicit permissions are required"));
    }

    @Test
    @DisplayName("Valid authorization confirmation should pass validation")
    void testValidAuthorizationConfirmation() {
        // Arrange
        String userId = "user789";
        List<String> accounts = Arrays.asList("ACC123", "ACC456");
        boolean explicitConfirmation = true;
        boolean scaCompleted = true;

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationConfirmation(userId, accounts, explicitConfirmation, scaCompleted);

        // Assert
        assertTrue(result.isValid(), "Valid authorization confirmation should pass");
        assertEquals("Authorization confirmation validation passed - follows payment flow logic", 
                    result.getFirstMessage());
    }

    @Test
    @DisplayName("Authorization confirmation without user ID should fail")
    void testAuthorizationConfirmationWithoutUserId() {
        // Arrange
        List<String> accounts = Arrays.asList("ACC123");
        boolean explicitConfirmation = true;
        boolean scaCompleted = true;

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationConfirmation(null, accounts, explicitConfirmation, scaCompleted);

        // Assert
        assertFalse(result.isValid(), "Authorization confirmation without user ID should fail");
        assertTrue(result.getMessages().get(0).contains("User ID is required"));
    }

    @Test
    @DisplayName("Authorization confirmation without accounts should fail")
    void testAuthorizationConfirmationWithoutAccounts() {
        // Arrange
        String userId = "user789";
        boolean explicitConfirmation = true;
        boolean scaCompleted = true;

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationConfirmation(userId, Collections.emptyList(), explicitConfirmation, scaCompleted);

        // Assert
        assertFalse(result.isValid(), "Authorization confirmation without accounts should fail");
        assertTrue(result.getMessages().get(0).contains("Account selection is required"));
    }

    @Test
    @DisplayName("Authorization confirmation without explicit confirmation should fail")
    void testAuthorizationConfirmationWithoutExplicitConfirmation() {
        // Arrange
        String userId = "user789";
        List<String> accounts = Arrays.asList("ACC123");
        boolean scaCompleted = true;

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationConfirmation(userId, accounts, false, scaCompleted);

        // Assert
        assertFalse(result.isValid(), "Authorization confirmation without explicit confirmation should fail");
        assertTrue(result.getMessages().get(0).contains("Explicit user confirmation is required"));
    }

    @Test
    @DisplayName("Authorization confirmation without SCA should fail")
    void testAuthorizationConfirmationWithoutSCA() {
        // Arrange
        String userId = "user789";
        List<String> accounts = Arrays.asList("ACC123");
        boolean explicitConfirmation = true;

        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationConfirmation(userId, accounts, explicitConfirmation, false);

        // Assert
        assertFalse(result.isValid(), "Authorization confirmation without SCA should fail");
        assertTrue(result.getMessages().get(0).contains("Strong Customer Authentication must be completed"));
    }

    @Test
    @DisplayName("Flow phases in correct sequence should pass validation")
    void testFlowConsistencyValidSequence() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateFlowConsistency(
                AuthorizationFlowValidator.FlowPhase.VALIDATION, 
                AuthorizationFlowValidator.FlowPhase.VALIDATION
            );

        // Assert
        assertTrue(result.isValid(), "Flow phases in correct sequence should pass");
        assertEquals("Flow consistency validated - matches payment flow sequence", 
                    result.getFirstMessage());
    }

    @Test
    @DisplayName("Flow phases out of sequence should fail validation")
    void testFlowConsistencyInvalidSequence() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateFlowConsistency(
                AuthorizationFlowValidator.FlowPhase.CONFIRMATION, 
                AuthorizationFlowValidator.FlowPhase.VALIDATION
            );

        // Assert
        assertFalse(result.isValid(), "Flow phases out of sequence should fail");
        assertTrue(result.getMessages().get(0).contains("Flow consistency violation"));
    }

    @Test
    @DisplayName("Resource with complete structure should pass validation")
    void testValidResourceStructure() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateResourceStructure(true, true, true, true);

        // Assert
        assertTrue(result.isValid(), "Resource with complete structure should pass");
        assertEquals("Resource structure matches payment resource structure", 
                    result.getFirstMessage());
    }

    @Test
    @DisplayName("Resource without ID should fail validation")
    void testResourceStructureWithoutId() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateResourceStructure(false, true, true, true);

        // Assert
        assertFalse(result.isValid(), "Resource without ID should fail");
        assertTrue(result.getMessages().get(0).contains("Resource must have an ID"));
    }

    @Test
    @DisplayName("Resource without status should fail validation")
    void testResourceStructureWithoutStatus() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateResourceStructure(true, false, true, true);

        // Assert
        assertFalse(result.isValid(), "Resource without status should fail");
        assertTrue(result.getMessages().get(0).contains("Resource must have a status"));
    }

    @Test
    @DisplayName("Complete audit trail should pass validation")
    void testValidAuditTrail() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuditTrail(true, true, true, true);

        // Assert
        assertTrue(result.isValid(), "Complete audit trail should pass");
        assertEquals("Audit trail requirements met - matches payment audit", 
                    result.getFirstMessage());
    }

    @Test
    @DisplayName("Audit trail without timestamp should fail validation")
    void testAuditTrailWithoutTimestamp() {
        // Act
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuditTrail(false, true, true, true);

        // Assert
        assertFalse(result.isValid(), "Audit trail without timestamp should fail");
        assertTrue(result.getMessages().get(0).contains("Audit event must have timestamp"));
    }

    @Test
    @DisplayName("Multiple validation errors should be reported")
    void testMultipleValidationErrors() {
        // Act - Missing client ID, request ID, and scope
        AuthorizationFlowValidator.ValidationResult result = 
            validator.validateAuthorizationRequest(null, null, null, Arrays.asList("permission"));

        // Assert
        assertFalse(result.isValid(), "Multiple errors should cause validation to fail");
        assertEquals(3, result.getMessages().size(), "Should report all 3 validation errors");
        assertTrue(result.getMessages().get(0).contains("Client ID is required"));
        assertTrue(result.getMessages().get(1).contains("Request ID is required"));
        assertTrue(result.getMessages().get(2).contains("Authorization scope is required"));
    }
}
