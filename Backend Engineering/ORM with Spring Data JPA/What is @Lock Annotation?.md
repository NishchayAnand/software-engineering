
When you annotate a Spring Data JPA repository query with `@Lock(LockModeType.PESSIMISTIC_WRITE)`, JPA will request a pessimistic (exclusive) lock on the returned entity rows from the database.

Under the hood most JPA providers translate this to a `SELECT ... FOR UPDATE` (or the DB equivalent). That prevents other transactions from acquiring conflicting locks on the same rows, effectively preventing concurrent updates to those rows until your transaction commits/rolls back.

---
### Important Conditions

If you call the repository in a non-transactional method, JPA may open/close a transaction around the call and the lock will be released immediately — not what you want.

Locks are held until the transaction ends. Don’t call external services or perform long work while holding the lock; do the minimal work (check -> update -> persist) and commit.

---


