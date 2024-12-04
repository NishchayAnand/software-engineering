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

Q. Explain `ON DELETE` and `ON UPDATE` clauses. 

Q. Different types of JOIN operations supported by SQL.

1. `INNER JOIN`: Returns rows that have matching values in both tables.

2. `LEFT JOIN (or LEFT OUTER JOIN)`: Returns all rows from the left table, and the matching rows from the right table. Non-matching rows from the right table are filled with **NULL**.

3. `RIGHT JOIN (or RIGHT OUTER JOIN)`: Returns all rows from the right table, and the matching rows from the left table. Non-matching rows from the left table are filled with **NULL**.

4. `FULL JOIN (or FULL OUTER JOIN)`: 

