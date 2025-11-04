
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
### Synchronous vs Async retry decision guide

- **Use sync retries** if:
    - The call usually succeeds quickly on transient blips.
    - Total retry time is small and doesn't block user experience (e.g., under 2–3s).


