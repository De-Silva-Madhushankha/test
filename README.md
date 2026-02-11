# WSO2 Open Banking API Extension Points

This repository contains the API contract for financial accelerator extension points in WSO2 Identity Server and API Manager.

## Overview

This Spring Boot application implements the OpenAPI specification for extending the WSO2 Open Banking accelerator flow with custom business logic for:

- **Client Management**: Registration and update of clients
- **Application Management**: Portal application lifecycle
- **Consent Management**: Account information and payment consent flows
- **Token Management**: OAuth2 token issuance and refresh
- **Authorization**: Request validation and enrichment
- **Error Handling**: Custom error response mapping

## Berlin Group Compliance

### REQ_0008: Consent Status Request Functionality ✅

This API provides comprehensive support for the Berlin Group specification requirement **REQ_0008**:

> "As shown in the Account Information Consent Flow diagram: The AISP MUST support Consent Status Request functionality"

**Status**: ✅ **COMPLIANT** - Fully implemented with comprehensive documentation

#### Documentation

📖 **[Consent Status Request Guide](CONSENT_STATUS_REQUEST_GUIDE.md)** - Complete implementation guide  
💻 **[API Examples](API_EXAMPLES.md)** - Integration code samples  
🧪 **[Test Cases](TEST_CASES.md)** - Test scenarios and compliance verification  
📋 **[Implementation Summary](IMPLEMENTATION_SUMMARY.md)** - Overview of what was implemented

#### Quick Links

For detailed information on consent status request functionality, please refer to:

📖 **[Consent Status Request Guide](CONSENT_STATUS_REQUEST_GUIDE.md)**

This guide includes:
- API endpoint documentation for `/consent-status-request`
- Request/response formats and examples
- Integration code samples in multiple languages (JavaScript, Python, Java, TypeScript)
- Berlin Group consent status values and their meanings
- Best practices for AISP implementation
- Error handling strategies
- Compliance verification test cases

## Key Features

### Consent Management APIs

- **Pre-process Consent Creation**: `/pre-process-consent-creation`
- **Enrich Consent Creation Response**: `/enrich-consent-creation-response`
- **Pre-process Consent Retrieval**: `/pre-process-consent-retrieval`
- **🆕 Consent Status Request**: `/consent-status-request` - *Berlin Group REQ_0008*
- **Validate Consent Access**: `/validate-consent-access`
- **Validate Consent File Retrieval**: `/validate-consent-file-retrieval`
- **Pre-process Consent Revoke**: `/pre-process-consent-revoke`
- **Enrich Consent Search Response**: `/enrich-consent-search-response`

### Client and Application Management

- **Pre-process Client Creation**: `/pre-process-client-creation`
- **Pre-process Client Update**: `/pre-process-client-update`
- **Pre-process Client Retrieval**: `/pre-process-client-retrieval`
- **Pre-process Application Creation**: `/pre-process-application-creation`
- **Pre-process Application Update**: `/pre-process-application-update`

### Token and Authorization

- **Issue Refresh Token**: `/issue-refresh-token`
- **Validate Authorization Request**: `/validate-authorization-request`
- **Populate Consent Authorize Screen**: `/populate-consent-authorize-screen`
- **Persist Authorized Consent**: `/persist-authorized-consent`

### Error Handling

- **Map Accelerator Error Response**: `/map-accelerator-error-response`

## Project Structure

```
.
├── pom.xml                                   # Maven project configuration
├── src/
│   └── main/
│       ├── java/org/openapitools/
│       │   ├── OpenApiGeneratorApplication.java  # Spring Boot application
│       │   ├── RFC3339DateFormat.java            # Date formatting utility
│       │   └── api/                              # API interfaces and controllers
│       └── resources/
│           ├── openapi.yaml                      # OpenAPI 3.0 specification
│           └── application.properties            # Application configuration
├── CONSENT_STATUS_REQUEST_GUIDE.md          # Berlin Group REQ_0008 documentation
└── README.md                                 # This file
```

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- Spring Boot 2.7.15

### Building the Project

```bash
mvn clean compile
```

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on the default port `8080` (configurable via `application.properties`).

### API Documentation

Once the application is running, you can access the interactive API documentation at:

- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI Spec**: `http://localhost:8080/v3/api-docs`

## Configuration

### Base Path

The API base path can be configured in `application.properties`:

```properties
openapi.aPIContractForFinancialAcceleratorExtensionPointsInWSO2ISAndAPIM.base-path=/wso2-f5b/OB4/1.0.0
```

### Security

The API supports two authentication methods:
- **OAuth2**: Bearer token authentication
- **BasicAuth**: HTTP Basic Authentication

## API Endpoints

### Consent Status Request (Berlin Group REQ_0008)

```http
POST /consent-status-request
Content-Type: application/json
Authorization: Bearer {access_token}

{
  "requestId": "unique-correlation-id",
  "data": {
    "consentId": "consent-uuid",
    "clientId": "aisp-client-id"
  }
}
```

**Response:**
```json
{
  "responseId": "unique-correlation-id",
  "status": "SUCCESS",
  "data": {
    "consentId": "consent-uuid",
    "consentStatus": "valid",
    "statusUpdateDateTime": "2024-02-10T10:30:00Z",
    "consentDetails": {
      "type": "accounts",
      "validityTime": 1707566200,
      "recurringIndicator": true
    }
  }
}
```

For complete documentation, see [CONSENT_STATUS_REQUEST_GUIDE.md](CONSENT_STATUS_REQUEST_GUIDE.md).

## Development

### Code Style

This project follows standard Java and Spring Boot conventions:
- Use meaningful variable and method names
- Follow Spring MVC patterns for controllers
- Implement interfaces for API endpoints
- Use dependency injection via constructor autowiring

### Adding New Endpoints

1. Update `src/main/resources/openapi.yaml` with the new endpoint specification
2. Regenerate API interfaces (if using OpenAPI Generator)
3. Implement the controller by creating a new class that implements the generated interface
4. Add appropriate security annotations and validation

## Testing

### Manual Testing

Use tools like Postman or curl to test API endpoints:

```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer YOUR_TOKEN" \
  -d '{
    "requestId": "test-request-123",
    "data": {
      "consentId": "550e8400-e29b-41d4-a716-446655440000",
      "clientId": "test-client"
    }
  }'
```

### Compliance Testing

For Berlin Group compliance verification, see the test cases in:
- [CONSENT_STATUS_REQUEST_GUIDE.md - Compliance Verification](CONSENT_STATUS_REQUEST_GUIDE.md#compliance-verification)

## Contributing

1. Create a feature branch from `main`
2. Make your changes
3. Ensure all existing functionality still works
4. Update documentation as needed
5. Submit a pull request

## Versioning

Current version: **v1.0.3**

### Changelog

#### v1.0.3 (2024-02-11)
- ✨ Added explicit consent status request endpoint (`/consent-status-request`)
- 📝 Added comprehensive Berlin Group REQ_0008 compliance documentation
- 🔒 Added consent status request request/response schemas
- 📚 Added integration examples in multiple programming languages
- ✅ Implements Berlin Group consent status values (received, valid, rejected, revoked, expired, terminatedByTpp)

## License

Apache License 2.0

See [LICENSE](https://www.apache.org/licenses/LICENSE-2.0.html) for details.

## Resources

- [WSO2 Open Banking](https://wso2.com/solutions/financial-services/open-banking/)
- [Berlin Group NextGenPSD2 Framework](https://www.berlin-group.org/)
- [PSD2 Regulatory Technical Standards](https://eur-lex.europa.eu/legal-content/EN/TXT/?uri=CELEX:32018R0389)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [OpenAPI Specification](https://swagger.io/specification/)

## Support

For questions or issues:
1. Check the [Consent Status Request Guide](CONSENT_STATUS_REQUEST_GUIDE.md) for consent-related questions
2. Review the OpenAPI specification in `src/main/resources/openapi.yaml`
3. Contact the WSO2 Open Banking support team

---

**Maintained by**: WSO2  
**Contact**: https://wso2.com/solutions/financial-services/open-banking/
