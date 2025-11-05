
An application that communicates with elements running in the cloud has to be sensitive to the transient faults that can occur in this environment. Faults include the momentary loss of network connectivity to components and services, the temporary unavailability of a service, or timeouts that occur when a service is busy.

These faults are typically self-correcting, and if the action that triggered a fault is repeated after a suitable delay it's likely to be successful. For example, a database service that's processing a large number of concurrent requests can implement a [throttling strategy](https://learn.microsoft.com/en-us/azure/architecture/patterns/throttling) that temporarily rejects any further requests until its workload has eased. An application trying to access the database might fail to connect, but if it tries again after a delay it might succeed.


![retry-patterns](retry-patterns.jpg)

🔹 Cancel: the client can cancel the request. 

🔹 Immediate retry: client immediately resends a request.

🔹 Fixed intervals: wait a fixed amount of time between the time of the failed payment and a new retry attempt.

🔹 Incremental intervals: client waits for a short time for the first retry, and then incrementally increases the time for subsequent retries.

🔹 Exponential backoff: double the waiting time between retries after each failed retry. For example, when a request fails for the first time, we retry after 1 second; if it fails a second time, we wait 2 seconds before the next retry; if it fails a third time, we wait 4 seconds before another retry.

🔹 Exponential backoff with jitter. If all the failed calls back off at the same time, they cause contention or overload again when they retry. Jitter adds some amount of randomness to the backoff to spread the retries.

> **NOTE:** If a request still fails after a significant number of retries, it's better for the application to prevent further requests going to the same resource and simply report a failure immediately. When the period expires, the application can tentatively allow one or more requests through to see whether they're successful. For more information about this strategy, see [Circuit Breaker pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker).

---
### Retry strategies

If an application detects a failure when it tries to send a request to a remote service, it can handle the failure using the following strategies:

- **Cancel**. If the fault indicates that the failure isn't transient or is unlikely to be successful if repeated, the application should cancel the operation and report an exception.
    
- **Retry immediately**. If the specific fault reported is unusual or rare, like a network packet becoming corrupted while it was being transmitted, the best course of action might be to immediately retry the request.
    
- **Retry after delay**. If the fault is caused by one of the more commonplace connectivity or busy failures, the network or service might need a short period while the connectivity issues are corrected or the backlog of work is cleared, so programmatically delaying the retry is a good strategy. In many cases, the period between retries should be chosen to spread requests from multiple instances of the application as evenly as possible to reduce the chance of a busy service continuing to be overloaded.

> **NOTE:** 
> 
> 1. The application should wrap all attempts to access a remote service in code that implements a retry policy matching one of the strategies listed above. Requests sent to different services can be subject to different policies.
> 
> 2. If a service is frequently unavailable or busy, it's often because the service has exhausted its resources. You can reduce the frequency of these faults by scaling out the service. For example, if a database service is continually overloaded, it might be beneficial to partition the database and spread the load across multiple servers.

---

- Classify errors into business (do NOT retry) vs transient infra (retry) vs permanent auth / etc (do not retry).

- Short, bounded retries for synchronous calls. If it still fails, move to async retry or saga continuation.

---
### Where to retry (layers)

1. **Client-side lightweight retry** for idempotent requests (e.g., network blips). Keep limited attempts.
    
2. **Service-side synchronous retry** (orchestrator) for _very short_ transient errors (2–3 attempts).
    
3. **Async / background retry (preferred for long-running)** — persist state and let background workers retry with more sophisticated backoff, alerts, and manual intervention if needed.

> **Rule:** Prefer async retries for anything that might take longer than a few seconds or block resources (DB locks, holds). Synchronous retries only for quick transient fixes.

---
### What to retry — error classification

- **Do NOT retry:** 4xx business errors (e.g., `ROOM_UNAVAILABLE`, `INVALID_REQUEST`), auth (401/403), validation failures.
    
- **Retry (short sync):** <span style="color:red;">ConnectionTimeout, SocketTimeout, 502/503/504, transient DB connection issues.</span>
    
- **Retry (async/longer):** Persistent downstream failures that may recover (e.g., inventory-service is down longer than the sync retry window).
    
- **DLQ & manual:** Poison messages, repeated failures after policy exhausted.

---
### Impact on performance

The retry policy should be tuned to match the business requirements of the application and the nature of the failure. For some noncritical operations, it's better to fail fast rather than retry several times and affect the throughput of the application. 

For example, in an interactive web application accessing a remote service, it's better to fail after a smaller number of retries with only a short delay between retry attempts, and display a suitable message to the user (for example, "please try again later"). 

For a batch application, it might be more appropriate to increase the number of retry attempts with an exponentially increasing delay between attempts.

---
### Synchronous vs Async retry decision guide

- **Use sync retries** if:
    - The call usually succeeds quickly on transient blips.
    - Total retry time is small and doesn't block user experience (e.g., under 2–3s).

---