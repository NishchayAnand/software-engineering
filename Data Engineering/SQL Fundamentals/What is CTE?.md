
A **CTE (Common Table Expression)** in SQL is a **temporary, named result set** that you can reference **within a `SELECT`, `INSERT`, `UPDATE`, or `DELETE`** statement.

It makes complex queries easier to read and maintain, especially when dealing with subqueries or recursive queries.

**Syntax:**

```
WITH cte_name AS (
    SELECT column1, column2, ...
    FROM table_name
    WHERE condition
)
SELECT *
FROM cte_name
WHERE another_condition;
```

**Example:**

```
WITH pair(hotel_id, room_type_id) AS (VALUES (1,1), (2,4), (3,7), (3,8), (5,6))
SELECT * from pair;
```

---
