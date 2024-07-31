# Understanding Groupby

- `GROUP BY`: Used to group together rows that have the same values in one or more columns. This allows you to perform _aggregate functions_ on those groups of rows.

- `HAVING`: Allows you to filter the data after it's been grouped. It's positioned after the **GROUP BY** clause and allows you to specify a condition that the groups must meet to be included in the final result.

> NOTE: The **WHERE** clause is great for filtering individual rows based on column values. However, the WHERE clause can't directly filter data based on aggregate functions (like SUM, COUNT, etc.).

```
SELECT Product, SUM(Price) AS TotalSales
FROM Sales
GROUP BY Product
HAVING SUM(Price) > 1000;
```
