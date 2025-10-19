
In **SQL**, the `CASE` statement is used to apply **conditional logic** in your queries, similar to an `if-else` statement in programming languages.

```
SELECT 
    name,
    salary,
    CASE
        WHEN salary > 100000 THEN 'High'
        WHEN salary BETWEEN 50000 AND 100000 THEN 'Medium'
        ELSE 'Low'
    END AS salary_level
FROM employees;
```

---
### Two Types of `CASE` Expressions

1. **Simple CASE** — compares one expression to multiple possible values.

```
CASE department
    WHEN 'Sales' THEN 'S'
    WHEN 'Engineering' THEN 'E'
    ELSE 'O'
END
```

2. **Searched CASE** — uses full conditions (like `salary > 100000`).

```
CASE 
    WHEN salary > 100000 THEN 'High'
    WHEN salary BETWEEN 50000 AND 100000 THEN 'Medium'
    ELSE 'Low'
END
```

---
