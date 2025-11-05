
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
