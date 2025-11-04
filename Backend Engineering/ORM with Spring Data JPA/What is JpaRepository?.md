
Spring Data JPA automatically creates a transaction for that single save() operation at the repository layer when using `JpaRepository` but if you’re doing **more than one related database write or read-modify-write** operation (like saving both a reservation and an idempotency record), then **you absolutely should use a transaction** to ensure atomicity.

---
