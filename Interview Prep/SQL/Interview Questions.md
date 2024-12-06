# SQL Interview Questions

Q. Can we use `GROUP BY` clause without an aggregate function?

Some databases allow selecting columns not included in the `GROUP BY` clause without using an aggregate function. 

For example, in databases like MySQL (with default configuration), below query is valid. However, in strict SQL-compliant systems like PostgreSQL, this will throw an error unless an aggregate function is used for name.

```
SELECT name, department
FROM Employee
GROUP BY department;
```

---

Q. What is `HAVING` clause?

The `HAVING` clause in SQL is used to filter the results of grouped data, typically when using the `GROUP BY` clause. 

---

Q. What is the significance of **FOREIGN KEY**?

**FOREIGN KEY** ensures referential integrity by requiring that the value in a foreign key column corresponds to a value in the referenced primary key column or is **NULL**.

---

Q. Explain `ON DELETE` clause. 

The `ON DELETE` clause allows you to control what happens to the rows in a child table when the corresponding row in the parent table is deleted.

It is part of the FOREIGN KEY constraint and specifies the action to take on the child table when a delete operation occurs on the parent table. You can specify one of below mentioned actions using the `ON DELETE` clause:

1. `CASCADE`: When a row in the parent table is deleted, all corresponding rows in the child table (that reference the parent table via the foreign key) are also deleted. For example, deleting a user record should automatically delete all associated orders.

2. `SET NULL`: When a row in the parent table is deleted, the foreign key in the child table is set to NULL. For example, if a product is deleted from the inventory, you may want to set the **product_id** of related orders to **NULL**, indicating that the product is no longer available.

3. `RESTRICT`: Prevents the deletion of a row in the parent table if any child records are referencing it. 

> NOTE: When you define a foreign key constraint and don’t specify an `ON DELETE` action, it defaults to `RESTRICT` in most databases.

--- 

Q. Different types of JOIN operations supported by SQL.

1. `INNER JOIN`: Returns rows that have matching values in both tables.

2. `LEFT JOIN (or LEFT OUTER JOIN)`: Returns all rows from the left table, and the matching rows from the right table. Non-matching rows from the right table are filled with **NULL**.

3. `RIGHT JOIN (or RIGHT OUTER JOIN)`: Returns all rows from the right table, and the matching rows from the left table. Non-matching rows from the left table are filled with **NULL**.

4. `FULL JOIN (or FULL OUTER JOIN)`: Returns all rows from both tables, filling in **NULL** values where matches do not exist.

5. `CROSS JOIN`: Returns the Cartesian product of the two tables. 

> NOTE: Joins in SQL (except `CROSS JOIN`) use the condition specified in the `ON` clause to match rows between two tables.

---

Q. What is `COALESCE`?

The `COALESCE` function in SQL is used to return the first non-NULL value from a list of expressions. It is often used to handle NULL values and provide default values in queries.

---





