
Used to mark a field as the primary key of an entity. `@Id` tells JPA, “This field uniquely identifies each record (entity) in the database table.”

---
### How it works?

When JPA interacts with the database:

- It uses the field marked with `@Id` to perform operations like `findById()`, `save()`, `delete()`, etc.
- The `@Id` field must be unique and non-null.

---


