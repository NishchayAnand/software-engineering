
**`LATERAL`** is a special keyword in **PostgreSQL (and some other SQL databases)** that allows a **subquery in the `FROM`clause** to **reference columns from tables that appear before it in the same `FROM` clause**.

```
SELECT u.id, u.name, o.id AS order_id, o.amount
FROM users u
JOIN LATERAL (
  SELECT *
  FROM orders o
  WHERE o.user_id = u.id
  ORDER BY o.date DESC
  LIMIT 1
) o ON TRUE;
```

**Think of it as:**

> “Run this subquery **once for each row** of the previous tables, using that row’s values as input.”

---
