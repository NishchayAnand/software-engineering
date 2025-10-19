
`COALESCE()` is a SQL **function** that returns the **first non-NULL value** from a list of expressions.

```
COALESCE(value1, value2, value3, ..., default_value)
```

- SQL will check each value **from left to right**.
- The **first non-NULL** value it finds is returned.
- If **all values** are `NULL`, it returns `NULL`.

---
