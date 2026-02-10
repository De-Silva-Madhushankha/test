package org.openapitools.api;

import org.openapitools.config.ScaConfiguration;
import org.openapitools.model.EnrichConsentCreationRequestBody;
import org.openapitools.model.RequestForEnrichConsentCreationResponse;
import org.openapitools.model.ErrorResponse;
import org.openapitools.model.Response200ForResponseAlternation;
import org.openapitools.model.SuccessResponseForResponseAlternation;
import org.openapitools.model.SuccessResponseForResponseAlternationData;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-10T04:27:17.433026664Z[Etc/UTC]", comments = "Generator version: 7.20.0-SNAPSHOT")
@Controller
@RequestMapping("${openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path:/wso2-f5b/OB4/1.0.0}")
public class EnrichConsentCreationResponseApiController implements EnrichConsentCreationResponseApi {

    private final NativeWebRequest request;
    private final ScaConfiguration scaConfiguration;

    @Autowired
    public EnrichConsentCreationResponseApiController(NativeWebRequest request, ScaConfiguration scaConfiguration) {
        this.request = request;
        this.scaConfiguration = scaConfiguration;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    /**
     * Implements PSD2/Berlin Group Redirect SCA Approach for Account Information Consent Requests
     * After consent creation, this method enriches the response with SCA redirect information
     * to redirect the user to the ASPSP SCA authorisation site for strong customer authentication.
     */
    @Override
    public ResponseEntity<Response200ForResponseAlternation> enrichConsentCreationResponsePost(
            @Valid @RequestBody EnrichConsentCreationRequestBody enrichConsentCreationRequestBody) {
        
        try {
            // Check if SCA is enabled and approach is REDIRECT
            if (scaConfiguration.isEnabled() && "REDIRECT".equals(scaConfiguration.getScaApproach())) {
                
                // Extract consent ID from the request
                String consentId = extractConsentId(enrichConsentCreationRequestBody);
                
                // Build the SCA redirect URL
                String scaRedirectUrl = buildScaRedirectUrl(consentId);
                
                // Create response with SCA redirect information
                SuccessResponseForResponseAlternationData data = new SuccessResponseForResponseAlternationData();
                data.setScaApproach(SuccessResponseForResponseAlternationData.ScaApproachEnum.REDIRECT);
                data.setScaRedirectUrl(scaRedirectUrl);
                
                // Add Location header for redirect
                Map<String, String> responseHeaders = new HashMap<>();
                responseHeaders.put("Location", scaRedirectUrl);
                data.setResponseHeaders(responseHeaders);
                
                // Keep the original response body
                data.setModifiedResponse(enrichConsentCreationRequestBody.getData());
                
                SuccessResponseForResponseAlternation response = new SuccessResponseForResponseAlternation();
                response.setResponseId(enrichConsentCreationRequestBody.getRequestId());
                response.setStatus(SuccessResponseForResponseAlternation.StatusEnum.SUCCESS);
                response.setData(data);
                
                return ResponseEntity.ok(response);
            } else {
                // If SCA is not enabled or approach is not REDIRECT, pass through
                return passThrough(enrichConsentCreationRequestBody);
            }
            
        } catch (Exception e) {
            // Log error and return pass-through response
            return passThrough(enrichConsentCreationRequestBody);
        }
    }

    /**
     * Extracts consent ID from the request body
     */
    private String extractConsentId(EnrichConsentCreationRequestBody requestBody) {
        // Try to extract consent ID from the data object
        RequestForEnrichConsentCreationResponse data = requestBody.getData();
        if (data != null && data.getConsentId() != null) {
            return data.getConsentId();
        }
        // Default to using request ID as fallback
        return requestBody.getRequestId();
    }

    /**
     * Builds the ASPSP SCA authorisation URL with consent ID parameter
     */
    private String buildScaRedirectUrl(String consentId) {
        String baseUrl = scaConfiguration.getAspspAuthUrl();
        
        // Add consent ID as query parameter
        if (baseUrl.contains("?")) {
            return baseUrl + "&consentId=" + consentId;
        } else {
            return baseUrl + "?consentId=" + consentId;
        }
    }

    /**
     * Pass-through response when SCA is not applicable
     */
    private ResponseEntity<Response200ForResponseAlternation> passThrough(
            EnrichConsentCreationRequestBody requestBody) {
        
        SuccessResponseForResponseAlternationData data = new SuccessResponseForResponseAlternationData();
        data.setModifiedResponse(requestBody.getData());
        
        SuccessResponseForResponseAlternation response = new SuccessResponseForResponseAlternation();
        response.setResponseId(requestBody.getRequestId());
        response.setStatus(SuccessResponseForResponseAlternation.StatusEnum.SUCCESS);
        response.setData(data);
        
        return ResponseEntity.ok(response);
    }

}

