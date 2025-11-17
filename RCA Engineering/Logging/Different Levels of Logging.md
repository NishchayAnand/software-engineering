
---

Use `log.error()` when the system is in an unexpected, unrecoverable, or dangerous state

Examples:

- An external API call fails after all retries.
- Database is unreachable.
- A required file/config is missing.
- A `NullPointerException` or `RuntimeException` bubbles up.

---
