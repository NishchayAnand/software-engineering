
---
### `@Lock(LockModeType.PESSIMISTIC_WRITE)`

This JPA annotation tells Hibernate:

> **“When fetching this record, obtain a database-level lock so that no other transaction can modify it until I’m done.”**

In other words, it enforces **exclusive access** to a database row during a transaction.

---
