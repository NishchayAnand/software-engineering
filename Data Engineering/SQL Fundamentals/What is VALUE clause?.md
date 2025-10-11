
The **`VALUES` clause** in SQL is used to **construct a set of rows directly within a query**, kind of like creating a small, inline table on the fly.

**Syntax:**

```
VALUES 
	(value1, value2, ...), 
	(value3, value4, ...), 
	...
```

Each parenthesis `()` represents a **row**, and the comma `,` separates multiple rows.

**Example:**

```
VALUES (1, 'Alice'), (2, 'Bob'), (3, 'Charlie');
```

This creates a temporary table with two columns:

| column1 | column2 |
| ------- | ------- |
| 1       | Alice   |
| 2       | Bob     |
| 3       | Charlie |

---
