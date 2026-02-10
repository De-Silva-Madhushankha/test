package org.openapitools.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openapitools.config.ScaConfiguration;
import org.openapitools.model.EnrichConsentCreationRequestBody;
import org.openapitools.model.RequestForEnrichConsentCreationResponse;
import org.openapitools.model.Response200ForResponseAlternation;
import org.openapitools.model.SuccessResponseForResponseAlternation;
import org.openapitools.model.SuccessResponseForResponseAlternationData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

/**
 * Unit tests for EnrichConsentCreationResponseApiController
 * Tests the PSD2 Redirect SCA Approach implementation
 */
public class EnrichConsentCreationResponseApiControllerTest {

    private EnrichConsentCreationResponseApiController controller;
    private ScaConfiguration scaConfiguration;
    private NativeWebRequest mockRequest;

    @BeforeEach
    public void setUp() {
        scaConfiguration = new ScaConfiguration();
        scaConfiguration.setEnabled(true);
        scaConfiguration.setScaApproach("REDIRECT");
        scaConfiguration.setAspspAuthUrl("https://aspsp.example.com/sca/authorize");
        
        mockRequest = mock(NativeWebRequest.class);
        controller = new EnrichConsentCreationResponseApiController(mockRequest, scaConfiguration);
    }

    @Test
    public void testScaRedirectEnabled() {
        // Arrange
        EnrichConsentCreationRequestBody requestBody = new EnrichConsentCreationRequestBody();
        requestBody.setRequestId("test-request-123");
        
        RequestForEnrichConsentCreationResponse data = new RequestForEnrichConsentCreationResponse();
        data.setConsentId("consent-456");
        requestBody.setData(data);

        // Act
        ResponseEntity<Response200ForResponseAlternation> response = 
            controller.enrichConsentCreationResponsePost(requestBody);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Response200ForResponseAlternation responseBody = response.getBody();
        assertNotNull(responseBody);
        
        assertTrue(responseBody instanceof SuccessResponseForResponseAlternation);
        SuccessResponseForResponseAlternation successResponse = (SuccessResponseForResponseAlternation) responseBody;
        
        assertEquals("test-request-123", successResponse.getResponseId());
        assertEquals(SuccessResponseForResponseAlternation.StatusEnum.SUCCESS, successResponse.getStatus());
        
        SuccessResponseForResponseAlternationData responseData = successResponse.getData();
        assertNotNull(responseData);
        
        // Verify SCA redirect URL is set
        assertNotNull(responseData.getScaRedirectUrl());
        assertTrue(responseData.getScaRedirectUrl().contains("consent-456"));
        assertEquals("https://aspsp.example.com/sca/authorize?consentId=consent-456", 
                     responseData.getScaRedirectUrl());
        
        // Verify SCA approach is set
        assertEquals(SuccessResponseForResponseAlternationData.ScaApproachEnum.REDIRECT, 
                     responseData.getScaApproach());
        
        // Verify Location header is set
        assertNotNull(responseData.getResponseHeaders());
        Map<?, ?> headers = (Map<?, ?>) responseData.getResponseHeaders();
        assertTrue(headers.containsKey("Location"));
        assertEquals("https://aspsp.example.com/sca/authorize?consentId=consent-456", 
                     headers.get("Location"));
    }

    @Test
    public void testScaRedirectDisabled() {
        // Arrange
        scaConfiguration.setEnabled(false);
        
        EnrichConsentCreationRequestBody requestBody = new EnrichConsentCreationRequestBody();
        requestBody.setRequestId("test-request-789");
        
        RequestForEnrichConsentCreationResponse data = new RequestForEnrichConsentCreationResponse();
        data.setConsentId("consent-999");
        requestBody.setData(data);

        // Act
        ResponseEntity<Response200ForResponseAlternation> response = 
            controller.enrichConsentCreationResponsePost(requestBody);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Response200ForResponseAlternation responseBody = response.getBody();
        assertNotNull(responseBody);
        
        assertTrue(responseBody instanceof SuccessResponseForResponseAlternation);
        SuccessResponseForResponseAlternation successResponse = (SuccessResponseForResponseAlternation) responseBody;
        
        SuccessResponseForResponseAlternationData responseData = successResponse.getData();
        assertNotNull(responseData);
        
        // Verify SCA fields are not set when disabled
        assertNull(responseData.getScaRedirectUrl());
        assertNull(responseData.getScaApproach());
    }

    @Test
    public void testNonRedirectApproach() {
        // Arrange
        scaConfiguration.setScaApproach("EMBEDDED");
        
        EnrichConsentCreationRequestBody requestBody = new EnrichConsentCreationRequestBody();
        requestBody.setRequestId("test-request-embedded");
        
        RequestForEnrichConsentCreationResponse data = new RequestForEnrichConsentCreationResponse();
        data.setConsentId("consent-embedded-123");
        requestBody.setData(data);

        // Act
        ResponseEntity<Response200ForResponseAlternation> response = 
            controller.enrichConsentCreationResponsePost(requestBody);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        
        Response200ForResponseAlternation responseBody = response.getBody();
        assertNotNull(responseBody);
        
        SuccessResponseForResponseAlternation successResponse = (SuccessResponseForResponseAlternation) responseBody;
        SuccessResponseForResponseAlternationData responseData = successResponse.getData();
        
        // Verify SCA redirect is not set for non-REDIRECT approaches
        assertNull(responseData.getScaRedirectUrl());
        assertNull(responseData.getScaApproach());
    }

    @Test
    public void testConsentIdExtraction() {
        // Arrange
        EnrichConsentCreationRequestBody requestBody = new EnrichConsentCreationRequestBody();
        requestBody.setRequestId("fallback-id-123");
        
        // Empty data, should fallback to requestId
        RequestForEnrichConsentCreationResponse data = new RequestForEnrichConsentCreationResponse();
        requestBody.setData(data);

        // Act
        ResponseEntity<Response200ForResponseAlternation> response = 
            controller.enrichConsentCreationResponsePost(requestBody);

        // Assert
        assertNotNull(response);
        Response200ForResponseAlternation responseBody = response.getBody();
        assertNotNull(responseBody);
        
        SuccessResponseForResponseAlternation successResponse = (SuccessResponseForResponseAlternation) responseBody;
        SuccessResponseForResponseAlternationData responseData = successResponse.getData();
        
        // Verify fallback to requestId works
        assertNotNull(responseData.getScaRedirectUrl());
        assertTrue(responseData.getScaRedirectUrl().contains("fallback-id-123"));
    }
}
