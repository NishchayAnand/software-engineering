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