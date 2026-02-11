# WSO2 Open Banking - Financial Accelerator Extension Points

This repository contains the API contract for financial accelerator extension points in WSO2 Identity Server (IS) and API Manager (APIM).

## Overview

This project provides REST API contracts for extending the WSO2 Open Banking accelerator flow with custom business logic across various flows:

- **Client Management** - Dynamic client registration and updates
- **Application Management** - Developer portal application lifecycle
- **Consent Management** - Consent flow customization and validation
- **Token Management** - Token issuance and refresh token handling
- **Authorization Flow** - Authorization request validation
- **Error Handling** - Custom error response mapping
- **Event Management** - Event subscription and polling

## Recent Updates

### Berlin Group PSD2 Compliance - GET Consent-Content Endpoint

We've added support for Berlin Group REQ_0011, which requires ASPSPs to respond to GET Consent-Content requests with HTTP 200 containing ACTV or RJCT status information.

**New Endpoint:** `/get-consent-content`

For detailed documentation on this endpoint, see: [CONSENT_CONTENT_ENDPOINT.md](CONSENT_CONTENT_ENDPOINT.md)

Key features:
- ✅ HTTP 200 responses with ACTV (Active) status
- ✅ HTTP 200 responses with RJCT (Rejected) status  
- ✅ Comprehensive consent content information
- ✅ Full OpenAPI specification with examples

## Building the Project

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher

### Build Commands

```bash
# Clean and compile
mvn clean compile

# Run the application
mvn spring-boot:run

# Package as JAR
mvn clean package
```

## API Documentation

Once the application is running, you can access:

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **OpenAPI Spec:** `http://localhost:8080/v3/api-docs`

## Project Structure

```
.
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── openapitools/
│       │           ├── api/          # REST API interfaces and controllers
│       │           └── model/        # Data transfer objects (DTOs)
│       └── resources/
│           └── openapi.yaml          # OpenAPI 3.0 specification
├── pom.xml                           # Maven project configuration
├── CONSENT_CONTENT_ENDPOINT.md      # Detailed endpoint documentation
└── README.md                         # This file
```

## Key Endpoints

### Consent Management

- `POST /pre-process-consent-creation` - Pre-process consent creation
- `POST /enrich-consent-creation-response` - Enrich consent creation response
- `POST /pre-process-consent-retrieval` - Pre-process consent retrieval
- `POST /get-consent-content` - **NEW: Get consent content with status (Berlin Group)**
- `POST /validate-consent-file-retrieval` - Validate consent file retrieval
- `POST /pre-process-consent-revoke` - Pre-process consent revocation
- `POST /enrich-consent-search-response` - Enrich consent search results
- `POST /populate-consent-authorize-screen` - Populate consent authorization screen
- `POST /persist-authorized-consent` - Persist authorized consent
- `POST /validate-consent-access` - Validate consent access

### Client Management

- `POST /pre-process-client-creation` - Pre-process client registration
- `POST /pre-process-client-update` - Pre-process client update
- `POST /pre-process-client-retrieval` - Pre-process client retrieval

### Token Management

- `POST /issue-refresh-token` - Issue refresh token decision
- `POST /validate-authorization-request` - Validate authorization request

### Error Handling

- `POST /map-accelerator-error-response` - Map accelerator errors to custom formats

## Configuration

The application can be configured via `application.properties`:

```properties
# Base path configuration
openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path=/wso2-f5b/OB4/1.0.0

# Server port
server.port=8080
```

## Compliance

This implementation supports the following specifications:

- **Berlin Group PSD2** - Account Information Service Provider requirements
- **WSO2 Open Banking** - Extension point contracts

For specific compliance requirements, see individual endpoint documentation.

## Security

All endpoints support the following authentication methods:

- **OAuth2** - Token-based authentication
- **Basic Authentication** - Username/password authentication

Ensure proper authentication is configured before deploying to production.

## Development

### Adding New Endpoints

1. Update `src/main/resources/openapi.yaml` with new endpoint specification
2. Generate or create API interface in `src/main/java/org/openapitools/api/`
3. Create corresponding controller implementation
4. Add necessary model classes in `src/main/java/org/openapitools/model/`
5. Update documentation

### Code Style

- Follow Java naming conventions
- Use OpenAPI Generator annotations where applicable
- Document all public APIs with JavaDoc
- Keep model classes immutable where possible

## Testing

### Manual Testing

Use the Swagger UI or curl to test endpoints:

```bash
curl -X POST http://localhost:8080/wso2-f5b/OB4/1.0.0/get-consent-content \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer <your-token>" \
  -d '{
    "requestId": "test-123",
    "data": {
      "consentId": "consent-456"
    }
  }'
```

## Support

For issues, questions, or contributions:

1. Check existing documentation
2. Review the OpenAPI specification
3. Consult WSO2 Open Banking documentation at https://wso2.com/solutions/financial-services/open-banking/
4. Open an issue in the repository

## License

Apache License 2.0 - See [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.html)

## Version

Current Version: **v1.0.3**

## Contributors

- WSO2 Open Banking Team
- GitHub Copilot (Berlin Group Compliance Implementation)
