# Understanding Joins

- `LEFT JOIN`: Includes all rows from the left table and matching rows from the right table. If there's no match in the right table for a left table row, it will return null values for the right table's columns.

- `INNER JOIN`: Selects records that have matching values in both tables.

- `CROSS JOIN`: Combines every row from one table with every row from another table, i.e., returns _Cartesian Product_ of two tables.

> NOTE: **_INNER JOIN_** is the default join type. If you simply specify **_JOIN_** after the table name, it's implicitly treated as an inner join.
