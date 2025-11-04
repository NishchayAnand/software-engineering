
persist reservation before external calls. If not possible, have reconciliation jobs to detect holds without reservations and either release holds or create reservations.

1. Always use a local DB transaction for writes to your service’s DB (reservation row, idempotency record, audit log). This ensures your service’s local state is consistent and recoverable.
    
2. Do not hold DB transactions while calling external services. External calls must happen after the DB transaction commits to avoid long-running locks and resource blocking.
    
3. Do not attempt 2-phase commit (XA) across services. They’re brittle and rarely worth the complexity — use sagas/compensation.
    
4. Make external calls idempotent and compensate on failure. E.g., if payment created but later you fail to confirm inventory, cancel payment or issue refund.
    
5. Use an outbox pattern for reliably publishing events (payment_succeeded, reservation.created) and a separate dispatcher to push to the broker. This prevents message loss when your process crashes after DB commit but before publishing.

> **NOTE:** Make every remote operation idempotent, classify errors, retry only transient failures with exponential backoff + jitter and circuit breakers, and for long-running or multi-step flows use asynchronous retries via sagas/outbox + DLQ rather than blocking database transactions. Compensate with explicit compensating actions where needed.

---
