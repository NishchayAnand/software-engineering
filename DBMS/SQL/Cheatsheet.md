# SQL Cheatsheet

## Referential Integrity

- **Foreign Key:** Foreign keys guarantee that data in one table corresponds to valid data in another table. In other words, it prevents situations where a record in one table references a non-existent record in another table. Sample Syntax: `FOREIGN KEY (column3) REFERENCES other_table_name(column_name)`.

## Remove Duplicates

- `DISTINCT`: Used to retrieve unique values from a selected column or set of columns in your query results. You can specify multiple columns after **DISTINCT** to ensure uniqueness across all of them.

## Concatenate Data

- `LEFT JOIN`: Includes all rows from the left table and matching rows from the right table. If there's no match in the right table for a left table row, it will return null values for the right table's columns.

- `INNER JOIN`: Selects records that have matching values in both tables.

- `CROSS JOIN`: Combines every row from one table with every row from another table, i.e., returns _Cartesian Product_ of two tables.

> NOTE: **_INNER JOIN_** is the default join type. If you simply specify **_JOIN_** after the table name, it's implicitly treated as an inner join.

## Filter Data

- `GROUP BY`: Used to group together rows that have the same values in one or more columns. This allows you to perform _aggregate functions_ on those groups of rows.

- `HAVING`: Allows you to filter the data after it's been grouped. It's positioned after the **GROUP BY** clause and allows you to specify a condition that the groups must meet to be included in the final result.

> NOTE: The **WHERE** clause is great for filtering individual rows based on column values. However, the WHERE clause can't directly filter data based on aggregate functions (like SUM, COUNT, etc.).

```
SELECT Product, SUM(Price) AS TotalSales
FROM Sales
GROUP BY Product
HAVING SUM(Price) > 1000;
```

## Restrict Data

- `ENUM`: A data type used to restrict a column's values to a predefined set of options. Sample Syntax: `marital_status ENUM('Single', 'Married')`.
