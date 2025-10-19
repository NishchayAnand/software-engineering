
- Encapsulation: hides persistence internals (JPA proxies, lazy relations, DB ids you don't want public).
- Stability: DTO is the API contract; you can change entity without breaking clients.
- Security: avoid leaking sensitive fields accidentally.
- Serialization safety: avoids cyclic refs / unexpected JSON from lazy-loaded associations.
- Flexibility: add computed fields, formatting or remove fields for different API versions.