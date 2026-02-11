package org.openapitools.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test for GetConsentContentApi
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(GetConsentContentApiController.class)
public class GetConsentContentApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetConsentContentEndpointExists() throws Exception {
        String requestBody = "{"
                + "\"requestId\": \"test-request-123\","
                + "\"data\": {"
                + "  \"consentId\": \"consent-123\","
                + "  \"requestHeaders\": {},"
                + "  \"consentResourcePath\": \"/consents/123\""
                + "}"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/wso2-f5b/OB4/1.0.0/get-consent-content")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isNotImplemented());
    }
}
