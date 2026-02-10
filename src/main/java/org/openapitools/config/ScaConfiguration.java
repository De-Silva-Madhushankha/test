package org.openapitools.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for Strong Customer Authentication (SCA)
 * Supports PSD2 Redirect SCA Approach for Account Information Consent Requests
 */
@Configuration
@ConfigurationProperties(prefix = "sca")
public class ScaConfiguration {

    /**
     * The base URL of the ASPSP (Account Servicing Payment Service Provider) SCA authorisation site
     * Example: https://aspsp.example.com/sca
     */
    private String aspspAuthUrl = "https://aspsp.example.com/sca/authorize";

    /**
     * The SCA approach to use: REDIRECT, EMBEDDED, or DECOUPLED
     * Default is REDIRECT for PSD2 compliance
     */
    private String scaApproach = "REDIRECT";

    /**
     * Whether SCA is enabled
     */
    private boolean enabled = true;

    public String getAspspAuthUrl() {
        return aspspAuthUrl;
    }

    public void setAspspAuthUrl(String aspspAuthUrl) {
        this.aspspAuthUrl = aspspAuthUrl;
    }

    public String getScaApproach() {
        return scaApproach;
    }

    public void setScaApproach(String scaApproach) {
        this.scaApproach = scaApproach;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
