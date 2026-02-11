# API Usage Examples - Consent Status Request

This document provides practical examples of using the Consent Status Request API endpoint for Berlin Group REQ_0008 compliance.

## Quick Start

### Base URL
```
http://localhost:8080/consent-status-request
```

### Authentication
All requests require authentication using either:
- **OAuth2 Bearer Token**: `Authorization: Bearer {token}`
- **Basic Auth**: `Authorization: Basic {base64_credentials}`

---

## Example 1: Basic Status Check (cURL)

### Request
```bash
curl -X POST http://localhost:8080/consent-status-request \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9..." \
  -d '{
    "requestId": "req-2024-02-11-001",
    "data": {
      "consentId": "550e8400-e29b-41d4-a716-446655440000",
      "clientId": "aisp-demo-client"
    }
  }'
```

### Response (Success)
```json
{
  "responseId": "req-2024-02-11-001",
  "status": "SUCCESS",
  "data": {
    "consentId": "550e8400-e29b-41d4-a716-446655440000",
    "consentStatus": "valid",
    "statusUpdateDateTime": "2024-02-11T10:30:00Z",
    "consentDetails": {
      "type": "accounts",
      "validityTime": 1739275800,
      "recurringIndicator": true,
      "frequency": 4
    }
  }
}
```

---

## Example 2: JavaScript/TypeScript with Fetch API

### TypeScript Types
```typescript
interface ConsentStatusRequest {
  requestId: string;
  data: {
    consentId: string;
    clientId: string;
    requestHeaders?: Record<string, string>;
  };
}

interface ConsentStatusResponse {
  responseId: string;
  status: 'SUCCESS' | 'ERROR';
  data?: {
    consentId: string;
    consentStatus: 'received' | 'valid' | 'rejected' | 'revoked' | 'expired' | 'terminatedByTpp';
    statusUpdateDateTime: string;
    consentDetails?: {
      type: string;
      validityTime: number;
      recurringIndicator: boolean;
      frequency?: number;
    };
  };
  errorMessage?: string;
  errorDescription?: string;
}
```

### Implementation
```typescript
async function checkConsentStatus(
  consentId: string,
  clientId: string,
  accessToken: string
): Promise<ConsentStatusResponse> {
  const request: ConsentStatusRequest = {
    requestId: `req-${Date.now()}-${Math.random().toString(36).substr(2, 9)}`,
    data: {
      consentId,
      clientId,
      requestHeaders: {
        'X-Request-ID': crypto.randomUUID()
      }
    }
  };

  const response = await fetch('http://localhost:8080/consent-status-request', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${accessToken}`
    },
    body: JSON.stringify(request)
  });

  if (!response.ok) {
    throw new Error(`HTTP ${response.status}: ${response.statusText}`);
  }

  return await response.json();
}

// Usage
try {
  const result = await checkConsentStatus(
    '550e8400-e29b-41d4-a716-446655440000',
    'my-aisp-client',
    'your-access-token-here'
  );

  if (result.status === 'SUCCESS' && result.data) {
    console.log(`Consent status: ${result.data.consentStatus}`);
    
    if (result.data.consentStatus === 'valid') {
      console.log('✅ Consent is valid, can proceed with account access');
    } else if (result.data.consentStatus === 'expired') {
      console.log('⚠️ Consent has expired, need to request new consent');
    } else if (result.data.consentStatus === 'revoked') {
      console.log('❌ Consent was revoked by user, cannot access accounts');
    }
  }
} catch (error) {
  console.error('Failed to check consent status:', error);
}
```

---

## Example 3: Python with Requests

### Basic Implementation
```python
import requests
import uuid
from datetime import datetime
from typing import Dict, Optional

class ConsentStatusChecker:
    def __init__(self, base_url: str, access_token: str):
        self.base_url = base_url
        self.access_token = access_token
        self.headers = {
            'Content-Type': 'application/json',
            'Authorization': f'Bearer {access_token}'
        }
    
    def check_status(self, consent_id: str, client_id: str) -> Dict:
        """
        Check the status of a consent
        
        Args:
            consent_id: The consent ID to check
            client_id: The AISP client ID
            
        Returns:
            Dictionary containing status response
        """
        url = f'{self.base_url}/consent-status-request'
        
        payload = {
            'requestId': str(uuid.uuid4()),
            'data': {
                'consentId': consent_id,
                'clientId': client_id,
                'requestHeaders': {
                    'X-Request-ID': str(uuid.uuid4())
                }
            }
        }
        
        try:
            response = requests.post(url, json=payload, headers=self.headers)
            response.raise_for_status()
            return response.json()
        except requests.exceptions.RequestException as e:
            print(f'Error checking consent status: {e}')
            raise
    
    def is_consent_valid(self, consent_id: str, client_id: str) -> bool:
        """
        Check if a consent is valid for use
        
        Returns:
            True if consent status is 'valid', False otherwise
        """
        result = self.check_status(consent_id, client_id)
        
        if result.get('status') == 'SUCCESS':
            data = result.get('data', {})
            return data.get('consentStatus') == 'valid'
        
        return False

# Usage example
if __name__ == '__main__':
    checker = ConsentStatusChecker(
        base_url='http://localhost:8080',
        access_token='your-access-token-here'
    )
    
    consent_id = '550e8400-e29b-41d4-a716-446655440000'
    client_id = 'my-aisp-client'
    
    # Check if consent is valid
    if checker.is_consent_valid(consent_id, client_id):
        print('✅ Consent is valid, proceeding with account access')
        # Proceed to access account information
    else:
        print('❌ Consent is not valid, need user authorization')
        # Initiate new consent flow
    
    # Get detailed status
    status_response = checker.check_status(consent_id, client_id)
    if status_response.get('status') == 'SUCCESS':
        data = status_response['data']
        print(f'\nDetailed Status:')
        print(f'  Consent ID: {data["consentId"]}')
        print(f'  Status: {data["consentStatus"]}')
        print(f'  Last Updated: {data["statusUpdateDateTime"]}')
        if 'consentDetails' in data:
            details = data['consentDetails']
            print(f'  Type: {details.get("type")}')
            print(f'  Recurring: {details.get("recurringIndicator")}')
            print(f'  Frequency: {details.get("frequency", "N/A")} per day')
```

---

## Example 4: Java with Spring RestTemplate

### Model Classes
```java
package com.example.aisp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ConsentStatusRequest {
    private String requestId;
    private RequestData data;
    
    @Data
    public static class RequestData {
        private String consentId;
        private String clientId;
        private Map<String, String> requestHeaders;
    }
}

@Data
public class ConsentStatusResponse {
    private String responseId;
    private String status;
    private ResponseData data;
    private String errorMessage;
    private String errorDescription;
    
    @Data
    public static class ResponseData {
        private String consentId;
        private String consentStatus;
        private String statusUpdateDateTime;
        private ConsentDetails consentDetails;
    }
    
    @Data
    public static class ConsentDetails {
        private String type;
        private Long validityTime;
        private Boolean recurringIndicator;
        private Integer frequency;
    }
}
```

### Service Implementation
```java
package com.example.aisp.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.aisp.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ConsentStatusService {
    
    private final RestTemplate restTemplate;
    private final String baseUrl;
    private final String accessToken;
    
    public ConsentStatusService(RestTemplate restTemplate, 
                               String baseUrl, 
                               String accessToken) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
        this.accessToken = accessToken;
    }
    
    public ConsentStatusResponse checkConsentStatus(String consentId, String clientId) {
        String url = baseUrl + "/consent-status-request";
        
        // Build request
        ConsentStatusRequest request = new ConsentStatusRequest();
        request.setRequestId(UUID.randomUUID().toString());
        
        ConsentStatusRequest.RequestData data = new ConsentStatusRequest.RequestData();
        data.setConsentId(consentId);
        data.setClientId(clientId);
        
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Request-ID", UUID.randomUUID().toString());
        data.setRequestHeaders(headers);
        
        request.setData(data);
        
        // Set headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setBearerAuth(accessToken);
        
        HttpEntity<ConsentStatusRequest> entity = new HttpEntity<>(request, httpHeaders);
        
        // Make request
        ResponseEntity<ConsentStatusResponse> response = restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            ConsentStatusResponse.class
        );
        
        return response.getBody();
    }
    
    public boolean isConsentValid(String consentId, String clientId) {
        ConsentStatusResponse response = checkConsentStatus(consentId, clientId);
        
        return "SUCCESS".equals(response.getStatus()) &&
               response.getData() != null &&
               "valid".equals(response.getData().getConsentStatus());
    }
    
    public enum ConsentStatus {
        RECEIVED, VALID, REJECTED, REVOKED, EXPIRED, TERMINATED_BY_TPP
    }
    
    public ConsentStatus getConsentStatus(String consentId, String clientId) {
        ConsentStatusResponse response = checkConsentStatus(consentId, clientId);
        
        if ("SUCCESS".equals(response.getStatus()) && response.getData() != null) {
            String status = response.getData().getConsentStatus();
            return ConsentStatus.valueOf(status.toUpperCase().replace("-", "_"));
        }
        
        throw new RuntimeException("Failed to get consent status");
    }
}
```

### Usage Example
```java
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    
    @Autowired
    private ConsentStatusService consentStatusService;
    
    @Autowired
    private AccountService accountService;
    
    @GetMapping
    public ResponseEntity<?> getAccounts(
            @RequestParam String consentId,
            @RequestParam String clientId) {
        
        // Check consent status before accessing accounts
        if (!consentStatusService.isConsentValid(consentId, clientId)) {
            ConsentStatusResponse status = 
                consentStatusService.checkConsentStatus(consentId, clientId);
            
            return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(Map.of(
                    "error", "invalid_consent",
                    "message", "Consent is not valid",
                    "consentStatus", status.getData().getConsentStatus()
                ));
        }
        
        // Consent is valid, proceed with account access
        List<Account> accounts = accountService.getAccounts(consentId);
        return ResponseEntity.ok(accounts);
    }
}
```

---

## Example 5: Node.js with Axios

```javascript
const axios = require('axios');
const { v4: uuidv4 } = require('uuid');

class ConsentStatusClient {
  constructor(baseURL, accessToken) {
    this.client = axios.create({
      baseURL,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${accessToken}`
      }
    });
  }

  async checkStatus(consentId, clientId) {
    try {
      const response = await this.client.post('/consent-status-request', {
        requestId: uuidv4(),
        data: {
          consentId,
          clientId,
          requestHeaders: {
            'X-Request-ID': uuidv4()
          }
        }
      });

      return response.data;
    } catch (error) {
      if (error.response) {
        // Server responded with error status
        throw new Error(
          `Status check failed: ${error.response.data.errorDescription || error.response.statusText}`
        );
      }
      throw error;
    }
  }

  async isValid(consentId, clientId) {
    const result = await this.checkStatus(consentId, clientId);
    return result.status === 'SUCCESS' && 
           result.data?.consentStatus === 'valid';
  }

  async waitForAuthorization(consentId, clientId, maxAttempts = 60, intervalMs = 5000) {
    for (let attempt = 0; attempt < maxAttempts; attempt++) {
      const result = await this.checkStatus(consentId, clientId);
      
      if (result.status === 'SUCCESS') {
        const status = result.data.consentStatus;
        
        if (status === 'valid') {
          return { authorized: true, status };
        } else if (status === 'rejected') {
          return { authorized: false, status };
        }
        // If 'received', continue waiting
      }
      
      await new Promise(resolve => setTimeout(resolve, intervalMs));
    }
    
    throw new Error('Timeout waiting for consent authorization');
  }
}

// Usage
async function main() {
  const client = new ConsentStatusClient(
    'http://localhost:8080',
    'your-access-token'
  );

  const consentId = '550e8400-e29b-41d4-a716-446655440000';
  const clientId = 'my-aisp-client';

  try {
    // Simple check
    const isValid = await client.isValid(consentId, clientId);
    console.log(`Consent valid: ${isValid}`);

    // Detailed check
    const status = await client.checkStatus(consentId, clientId);
    console.log('Consent details:', JSON.stringify(status, null, 2));

    // Wait for user to authorize
    console.log('Waiting for user authorization...');
    const authResult = await client.waitForAuthorization(consentId, clientId);
    
    if (authResult.authorized) {
      console.log('✅ Consent authorized! Can access accounts.');
    } else {
      console.log('❌ Consent rejected by user.');
    }
  } catch (error) {
    console.error('Error:', error.message);
  }
}

main();
```

---

## Example 6: Postman Collection

Save this as a JSON file and import into Postman:

```json
{
  "info": {
    "name": "Consent Status Request API",
    "description": "Berlin Group REQ_0008 - AISP Consent Status Request",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "variable": [
    {
      "key": "baseUrl",
      "value": "http://localhost:8080"
    },
    {
      "key": "accessToken",
      "value": "your-access-token-here"
    },
    {
      "key": "consentId",
      "value": "550e8400-e29b-41d4-a716-446655440000"
    },
    {
      "key": "clientId",
      "value": "test-aisp-client"
    }
  ],
  "item": [
    {
      "name": "Check Consent Status",
      "request": {
        "method": "POST",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          },
          {
            "key": "Authorization",
            "value": "Bearer {{accessToken}}"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"requestId\": \"{{$guid}}\",\n  \"data\": {\n    \"consentId\": \"{{consentId}}\",\n    \"clientId\": \"{{clientId}}\"\n  }\n}"
        },
        "url": {
          "raw": "{{baseUrl}}/consent-status-request",
          "host": ["{{baseUrl}}"],
          "path": ["consent-status-request"]
        }
      },
      "response": []
    }
  ]
}
```

---

## Common Patterns

### Pattern 1: Pre-flight Check Before Account Access

```javascript
async function getAccountsWithConsentCheck(consentId, clientId) {
  // Always check consent status first
  const statusResponse = await checkConsentStatus(consentId, clientId);
  
  if (statusResponse.status !== 'SUCCESS') {
    throw new Error('Failed to check consent status');
  }
  
  const { consentStatus } = statusResponse.data;
  
  // Handle different statuses
  switch (consentStatus) {
    case 'valid':
      // Proceed with account access
      return await getAccounts(consentId);
      
    case 'expired':
      throw new Error('Consent expired. Please request new consent.');
      
    case 'revoked':
      throw new Error('Consent was revoked by user.');
      
    case 'received':
      throw new Error('Consent pending authorization.');
      
    default:
      throw new Error(`Cannot access accounts. Consent status: ${consentStatus}`);
  }
}
```

### Pattern 2: Periodic Status Monitoring

```python
import time
import threading

class ConsentMonitor:
    def __init__(self, checker, consent_id, client_id, callback):
        self.checker = checker
        self.consent_id = consent_id
        self.client_id = client_id
        self.callback = callback
        self.running = False
        self.last_status = None
    
    def start(self, interval_seconds=300):
        """Monitor consent status every interval_seconds"""
        self.running = True
        thread = threading.Thread(target=self._monitor, args=(interval_seconds,))
        thread.daemon = True
        thread.start()
    
    def stop(self):
        self.running = False
    
    def _monitor(self, interval):
        while self.running:
            try:
                response = self.checker.check_status(
                    self.consent_id,
                    self.client_id
                )
                
                if response.get('status') == 'SUCCESS':
                    current_status = response['data']['consentStatus']
                    
                    # Notify on status change
                    if current_status != self.last_status:
                        self.callback(current_status, self.last_status)
                        self.last_status = current_status
            except Exception as e:
                print(f'Error monitoring consent: {e}')
            
            time.sleep(interval)

# Usage
def on_status_change(new_status, old_status):
    print(f'Consent status changed: {old_status} -> {new_status}')
    if new_status in ['revoked', 'expired']:
        print('⚠️ Consent no longer valid, stopping account access')
        # Stop any ongoing account data fetching

monitor = ConsentMonitor(checker, consent_id, client_id, on_status_change)
monitor.start(interval_seconds=300)  # Check every 5 minutes
```

---

## Error Handling Best Practices

```typescript
class ConsentStatusError extends Error {
  constructor(
    message: string,
    public statusCode: number,
    public errorCode?: string
  ) {
    super(message);
    this.name = 'ConsentStatusError';
  }
}

async function robustStatusCheck(
  consentId: string,
  clientId: string,
  maxRetries: number = 3
): Promise<string> {
  let lastError: Error | null = null;
  
  for (let attempt = 1; attempt <= maxRetries; attempt++) {
    try {
      const response = await checkConsentStatus(consentId, clientId);
      
      if (response.status === 'SUCCESS' && response.data) {
        return response.data.consentStatus;
      }
      
      throw new ConsentStatusError(
        response.errorDescription || 'Unknown error',
        response.statusCode || 500,
        response.errorMessage
      );
    } catch (error) {
      lastError = error as Error;
      
      if (error instanceof ConsentStatusError) {
        // Don't retry client errors (4xx)
        if (error.statusCode >= 400 && error.statusCode < 500) {
          throw error;
        }
      }
      
      // Exponential backoff for server errors
      if (attempt < maxRetries) {
        const delay = Math.pow(2, attempt) * 1000;
        await new Promise(resolve => setTimeout(resolve, delay));
      }
    }
  }
  
  throw lastError || new Error('Failed to check consent status');
}
```

---

**Document Version**: 1.0  
**Last Updated**: 2024-02-11  
**Compliance**: Berlin Group REQ_0008
