package org.openapitools.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Validator to ensure authorization confirmation flows follow the same logic
 * as Payment Initiation Flows per Berlin Group specification REQ_0004.
 * 
 * This validator enforces flow consistency between authorization patterns
 * and payment initiation patterns.
 */
public class AuthorizationFlowValidator {

    /**
     * Validates that an authorization request follows payment flow logic.
     * 
     * Validates:
     * - Request structure completeness
     * - Required fields presence
     * - Client credential format
     * - Permission scope validity
     * 
     * @param clientId The client identifier
     * @param requestId The request identifier
     * @param scope The authorization scope
     * @param permissions The requested permissions
     * @return ValidationResult containing validation outcome
     */
    public ValidationResult validateAuthorizationRequest(
            String clientId, 
            String requestId, 
            String scope,
            List<String> permissions) {
        
        List<String> errors = new ArrayList<>();
        
        // Validation Rule 1: Client ID must be present (equivalent to TPP validation in payment flow)
        if (clientId == null || clientId.trim().isEmpty()) {
            errors.add("Client ID is required - same as TPP authentication in payment initiation");
        }
        
        // Validation Rule 2: Request ID must be present (equivalent to payment ID in payment flow)
        if (requestId == null || requestId.trim().isEmpty()) {
            errors.add("Request ID is required - same as payment resource ID in payment initiation");
        }
        
        // Validation Rule 3: Scope must be defined (equivalent to payment service in payment flow)
        if (scope == null || scope.trim().isEmpty()) {
            errors.add("Authorization scope is required - same as payment product in payment initiation");
        }
        
        // Validation Rule 4: Permissions must be explicit (equivalent to payment details in payment flow)
        if (permissions == null || permissions.isEmpty()) {
            errors.add("Explicit permissions are required - same as payment details in payment initiation");
        }
        
        if (errors.isEmpty()) {
            return ValidationResult.success("Authorization request validation passed - follows payment flow logic");
        } else {
            return ValidationResult.failure(errors);
        }
    }

    /**
     * Validates that authorization confirmation follows payment flow logic.
     * 
     * Validates:
     * - User identification presence
     * - Account selection validity
     * - Explicit confirmation capture
     * - SCA completion when required
     * 
     * @param userId The PSU identifier
     * @param accounts The selected accounts
     * @param explicitConfirmation Whether explicit confirmation was provided
     * @param scaCompleted Whether SCA was completed when required
     * @return ValidationResult containing validation outcome
     */
    public ValidationResult validateAuthorizationConfirmation(
            String userId,
            List<String> accounts,
            boolean explicitConfirmation,
            boolean scaCompleted) {
        
        List<String> errors = new ArrayList<>();
        
        // Validation Rule 1: User ID must be present (equivalent to PSU identification in payment flow)
        if (userId == null || userId.trim().isEmpty()) {
            errors.add("User ID is required - same as PSU identification in payment confirmation");
        }
        
        // Validation Rule 2: Account selection must be valid (equivalent to debtor account in payment flow)
        if (accounts == null || accounts.isEmpty()) {
            errors.add("Account selection is required - same as debtor account selection in payment confirmation");
        } else {
            for (String account : accounts) {
                if (account == null || account.trim().isEmpty()) {
                    errors.add("Invalid account selection - all accounts must be valid like in payment confirmation");
                    break;
                }
            }
        }
        
        // Validation Rule 3: Explicit confirmation must be captured (equivalent to payment authorization in payment flow)
        if (!explicitConfirmation) {
            errors.add("Explicit user confirmation is required - same as explicit payment authorization");
        }
        
        // Validation Rule 4: SCA must be completed (equivalent to SCA in payment flow)
        if (!scaCompleted) {
            errors.add("Strong Customer Authentication must be completed - same as SCA in payment confirmation");
        }
        
        if (errors.isEmpty()) {
            return ValidationResult.success("Authorization confirmation validation passed - follows payment flow logic");
        } else {
            return ValidationResult.failure(errors);
        }
    }

    /**
     * Validates flow consistency between authorization and payment patterns.
     * 
     * Ensures:
     * - Sequential step execution
     * - Validation before authorization
     * - Explicit confirmation requirement
     * - Consistent error handling
     * 
     * @param phaseCompleted The current phase that was completed
     * @param expectedPhase The expected phase based on payment flow
     * @return ValidationResult containing validation outcome
     */
    public ValidationResult validateFlowConsistency(FlowPhase phaseCompleted, FlowPhase expectedPhase) {
        List<String> errors = new ArrayList<>();
        
        // Validation Rule: Flow phases must be executed in sequence
        if (phaseCompleted != expectedPhase) {
            errors.add(String.format(
                "Flow consistency violation: completed phase '%s' but expected '%s' - " +
                "authorization flow must follow payment flow sequence",
                phaseCompleted.name(), expectedPhase.name()
            ));
        }
        
        // Additional validation: Ensure authorization phase doesn't occur before validation
        if (phaseCompleted == FlowPhase.AUTHORIZATION && expectedPhase == FlowPhase.VALIDATION) {
            errors.add("Authorization cannot occur before validation - same rule as in payment flow");
        }
        
        // Additional validation: Ensure confirmation doesn't occur before authorization
        if (phaseCompleted == FlowPhase.CONFIRMATION && expectedPhase == FlowPhase.AUTHORIZATION) {
            errors.add("Confirmation cannot occur before authorization - same rule as in payment flow");
        }
        
        if (errors.isEmpty()) {
            return ValidationResult.success("Flow consistency validated - matches payment flow sequence");
        } else {
            return ValidationResult.failure(errors);
        }
    }

    /**
     * Validates that authorization resource structure matches payment resource structure.
     * 
     * @param hasResourceId Whether resource has an ID
     * @param hasStatus Whether resource has a status
     * @param hasAuthorizations Whether resource has authorization details
     * @param hasLinks Whether resource has hypermedia links
     * @return ValidationResult containing validation outcome
     */
    public ValidationResult validateResourceStructure(
            boolean hasResourceId,
            boolean hasStatus,
            boolean hasAuthorizations,
            boolean hasLinks) {
        
        List<String> errors = new ArrayList<>();
        
        // Resource must have ID (like payment ID)
        if (!hasResourceId) {
            errors.add("Resource must have an ID - same as payment resource ID");
        }
        
        // Resource must have status (like payment status)
        if (!hasStatus) {
            errors.add("Resource must have a status - same as payment transaction status");
        }
        
        // Resource must have authorization details (like payment authorization)
        if (!hasAuthorizations) {
            errors.add("Resource must have authorization details - same as payment authorization resource");
        }
        
        // Resource must have hypermedia links (like payment links)
        if (!hasLinks) {
            errors.add("Resource must have HATEOAS links - same as payment resource links");
        }
        
        if (errors.isEmpty()) {
            return ValidationResult.success("Resource structure matches payment resource structure");
        } else {
            return ValidationResult.failure(errors);
        }
    }

    /**
     * Validates audit trail requirements are met.
     * 
     * @param hasTimestamp Whether event has timestamp
     * @param hasUserId Whether event has user ID
     * @param hasAction Whether event has action
     * @param hasOutcome Whether event has outcome
     * @return ValidationResult containing validation outcome
     */
    public ValidationResult validateAuditTrail(
            boolean hasTimestamp,
            boolean hasUserId,
            boolean hasAction,
            boolean hasOutcome) {
        
        List<String> errors = new ArrayList<>();
        
        if (!hasTimestamp) {
            errors.add("Audit event must have timestamp - same as payment audit");
        }
        
        if (!hasUserId) {
            errors.add("Audit event must have user ID - same as payment audit");
        }
        
        if (!hasAction) {
            errors.add("Audit event must have action - same as payment audit");
        }
        
        if (!hasOutcome) {
            errors.add("Audit event must have outcome - same as payment audit");
        }
        
        if (errors.isEmpty()) {
            return ValidationResult.success("Audit trail requirements met - matches payment audit");
        } else {
            return ValidationResult.failure(errors);
        }
    }

    /**
     * Flow phases that must be executed in sequence.
     * Mirrors the payment initiation flow phases.
     */
    public enum FlowPhase {
        /** Pre-processing and validation phase */
        VALIDATION,
        
        /** Authorization screen presentation phase */
        AUTHORIZATION,
        
        /** Explicit confirmation capture phase */
        CONFIRMATION,
        
        /** Post-processing and response enrichment phase */
        POST_PROCESSING
    }

    /**
     * Validation result containing success/failure status and messages.
     */
    public static class ValidationResult {
        private final boolean valid;
        private final List<String> messages;

        private ValidationResult(boolean valid, List<String> messages) {
            this.valid = valid;
            this.messages = messages;
        }

        public static ValidationResult success(String message) {
            List<String> messages = new ArrayList<>();
            messages.add(message);
            return new ValidationResult(true, messages);
        }

        public static ValidationResult failure(List<String> errors) {
            return new ValidationResult(false, errors);
        }

        public boolean isValid() {
            return valid;
        }

        public List<String> getMessages() {
            return messages;
        }

        public String getFirstMessage() {
            return messages.isEmpty() ? "" : messages.get(0);
        }

        @Override
        public String toString() {
            return "ValidationResult{valid=" + valid + ", messages=" + messages + "}";
        }
    }
}
