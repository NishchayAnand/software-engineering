
In PostgreSQL, **every table lives inside a schema**, and **schemas live inside a database**.

- **Database** → contains schemas
- **Schema** → contains tables, views, functions, etc.
- **Table** → the actual data structure

By default:
- When you create a new PostgreSQL database, it comes with a schema called **`public`**.
- If you don’t specify a schema, PostgreSQL assumes **`public`**.

So if you create:

```
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
);
```

Internally, PostgreSQL treats it as:

```
CREATE TABLE public.users (
    id BIGSERIAL PRIMARY KEY,
    name TEXT
);
```

---
### Why do we need schemas?

Schemas help **organize and namespace** database objects:

- You could have `sales.users` and `hr.users` tables in the same database (two different schemas) without conflict.
- You can assign different permissions per schema (e.g., only HR team can access `hr.*`).

> **NOTE:** Schemas are like **folders** in a database.

---
```
psql -h localhost -p 5432 -U nishchayanand hoteldb
```

----

```
TRUNCATE TABLE public.hotels RESTART IDENTITY;
```

- Many tables (like `hotels`) often have an **auto-increment column** (`SERIAL`, `BIGSERIAL`, or `IDENTITY`).
    
- That auto-increment is backed by a **sequence** (hidden counter).

If you `TRUNCATE` a table, the **sequence is NOT reset** → so the next insert continues from the old number.

But with `RESTART IDENTITY`:
- The sequence is reset back to its **start value (usually 1)**.
- So after truncation, inserting a row will start with `id = 1` again.

---
`bigint`: signed eight-byte integer.

---
`bigserial`: auto-incrementing eight-byte integer. 

A special **auto-incrementing column type** used to generate unique integer values automatically, usually for **primary keys**.

> **NOTE:** Only unique within a single database sequence (not globally unique).

---

**BIGSERIAL vs UUID**

- **BIGSERIAL**
    - Numeric (64-bit integer).
    - Auto-increments sequentially using an internal sequence.
    - Example values: `1, 2, 3, 4, …`.
    - ✅ Great for single-node apps or systems where global uniqueness isn’t required.
    - ✅ Best for performance-sensitive workloads.
    - ❌ Not good if you merge databases later (risk of ID collisions).

- **UUID (Universally Unique Identifier)**
    - 128-bit value, represented as a string.
    - Generated independently of the database (by app, or DB function).
    - Globally unique, usually generated using algorithms (`uuid_generate_v4()` for random-based, `uuid_generate_v1()` for time-based, etc.).
    - Example value: `550e8400-e29b-41d4-a716-446655440000`.
    - ✅ Useful in distributed systems where multiple services or databases generate IDs independently.
    - ✅ Good for public APIs (harder to guess than sequential IDs).
    - ❌ Slightly worse performance and larger storage.

> **NOTE:** `BIGSERIAL` is more compact and efficient for indexing compared to `UUID`.

---
`serial`: auto-incrementing four-byte integer.

---
### How to Perform Round Off?

`ROUND()` function rounds a numeric value to its nearest [integer](https://neon.com/postgresql/postgresql-tutorial/postgresql-integer) or a number with the number of decimal places.

```
ROUND (source [ , n ] )
```

The `ROUND()` function accepts 2 arguments:

1) **source**: a number or a numeric expression that is to be rounded.
2) **n**: an integer that determines the number of decimal places after rounding. The n argument is optional. If you omit the n argument, its default value is 0.

---
