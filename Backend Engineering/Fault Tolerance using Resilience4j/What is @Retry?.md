
Feign clients are **dynamic proxies** created by Spring Cloud OpenFeign.  
Resilience4j’s `@Retry` works via **Spring AOP (Aspect-Oriented Programming)** proxies.

If you annotate a Feign client method like this:

```
@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/api/inventory/{id}")
    @Retry(name = "inventoryRetry", fallbackMethod = "fallback") // ❌ Won’t 
															work as expected
    String getInventory(@PathVariable("id") Long id);
}
```

…it **won’t trigger** the retry because:

- Feign generates its own proxy (not a Spring-managed bean of the implementation class).
- Resilience4j annotations need Spring AOP proxies to intercept method calls.
- The Feign proxy doesn’t go through Resilience4j’s AOP layer.

So `@Retry` won’t be applied — it’ll just act as a plain annotation.

---
### Correct Way (Recommended Pattern)

Create a **service layer wrapper** that calls the Feign client, and annotate that method.

**Example**:

```
@FeignClient(name = "inventory-service", url = "http://localhost:8081")
public interface InventoryClient {
    @GetMapping("/api/inventory/{id}")
    String getInventory(@PathVariable("id") Long id);
}
```

Then wrap it like this:

```
@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryClient inventoryClient;

    @Retry(name = "inventoryRetry", fallbackMethod = "fallback")
    public String getInventory(Long id) {
        return inventoryClient.getInventory(id);
    }

    public String fallback(Long id, Throwable t) {
        return "Fallback inventory info for " + id;
    }
}
```

Now Resilience4j can intercept `InventoryService.getInventory()` since this class is a **Spring-managed bean**, and retries will correctly trigger.

**YAML Configuration**:

```
resilience4j:
  retry:
    instances:
      inventoryRetry:
        max-attempts: 3
        wait-duration: 2s
        retry-exceptions:
          - feign.FeignException
          - java.io.IOException
```

✅ Feign exceptions are retried.  
✅ Fallback is invoked after retries fail.

---

|                   **HTTP Status Code** | **Category / Meaning**                      |      **Retry?**      | **Reason**                                                                 |     |
| -------------------------------------: | ------------------------------------------- | :------------------: | -------------------------------------------------------------------------- | --- |
|                                **1xx** | Informational (e.g., 100 Continue)          |         ❌ No         | Rarely seen by clients; not retryable.                                     |     |
|                             **200 OK** | Success                                     |         ❌ No         | Request succeeded.                                                         |     |
|                        **201 Created** | Success                                     |         ❌ No         | Resource already created successfully.                                     |     |
|                       **202 Accepted** | Request accepted for processing             |         ❌ No         | Wait for async completion instead.                                         |     |
|                     **204 No Content** | Success without content                     |         ❌ No         | Completed successfully.                                                    |     |
|                                **3xx** | Redirection                                 |    ❌ No (usually)    | Handled automatically by Feign/HTTP client.                                |     |
|              **301 Moved Permanently** | Resource permanently moved                  |         ❌ No         | Update client configuration instead.                                       |     |
| **302 Found / 307 Temporary Redirect** | Temporary redirect                          |         ❌ No         | Follow redirect automatically if supported.                                |     |
|                   **304 Not Modified** | Cache response                              |         ❌ No         | Nothing to retry.                                                          |     |
|                    **400 Bad Request** | Client sent invalid data                    |         ❌ No         | Client error — fix input, not retry.                                       |     |
|                   **401 Unauthorized** | Missing or invalid credentials              |         ❌ No         | Retry won’t help until token refreshed.                                    |     |
|                      **403 Forbidden** | Access denied                               |         ❌ No         | Permanent authorization failure.                                           |     |
|                      **404 Not Found** | Resource doesn’t exist                      |         ❌ No         | Permanent; retrying won’t help.                                            |     |
|             **405 Method Not Allowed** | Invalid HTTP method                         |         ❌ No         | Client configuration error.                                                |     |
|                       **409 Conflict** | Resource conflict (e.g., duplicate request) |       ⚠️ Maybe       | Retry only if operation is idempotent (e.g., reservation already created). |     |
|                           **410 Gone** | Resource permanently removed                |         ❌ No         | Permanent error.                                                           |     |
|           **422 Unprocessable Entity** | Validation or business rule failed          |         ❌ No         | Logical failure, not transient.                                            |     |
|              **429 Too Many Requests** | Rate limit exceeded                         | ✅ Yes (after delay)  | Transient; retry after `Retry-After` header.                               |     |
|          **500 Internal Server Error** | Server-side error                           |        ✅ Yes         | Transient error, safe to retry.                                            |     |
|                    **502 Bad Gateway** | Upstream dependency failed                  |        ✅ Yes         | Temporary backend failure.                                                 |     |
|            **503 Service Unavailable** | Server temporarily overloaded or down       | ✅ Yes (with backoff) | Classic retry candidate.                                                   |     |
|                **504 Gateway Timeout** | Server didn’t respond in time               |        ✅ Yes         | Transient connectivity issue.                                              |     |
|                     **Network Errors** | Timeouts, Connection refused, I/O errors    |        ✅ Yes         | Transient network issue, safe to retry.                                    |     |
