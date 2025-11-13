
In software and tech idempotency typically refers to the idea that you can perform an operation multiple times without triggering any side effects more than once.

---
### What is Idempotency Key?

Should ideally not be saved in-memory, considering the key will be deleted if the system restarts.

Ideally, the idempotency key is saved for 24 to 48 hours. 

---
### How to create Idempotency Key?

could be a case where the client uses the same idempotency key, however, the request body is entirely different.

---


