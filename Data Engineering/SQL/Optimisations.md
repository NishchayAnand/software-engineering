
Using indexes on JOIN columns can significantly improve the performance of the JOIN operation.

Sargable vs Non-Sargable Queries

**Sargable:** `ORDER_DATE >= '2023-01-01'` - this allows database engine to use indexing on the ORDER_DATE column. 

**Non-Sargable:** `WHERE YEAR(ORDER_DATE) >= 2023` - this prevents database engine to use indexing on the ORDER_DATE column. The `YEAR` function must be applied to every row in the table even if the index exists.

**To write sargable queries**:
- avoid using functions or calculations on indexed columns in the **WHERE** clause.
- use direct comparisons when possible, instead of wrapping the column in a function.

```
SELECT   customer id, COUNT(order_id) as total_orders,
	     SUM(order_amount) as total_spent
FROM     customers
JOIN     orders
ON       customer.id = orders.customer_id
WHERE    ORDER_DATE >= '2023-01-01'
GROUP BY customer_id
HAVING   total_spent >= 1000
ORDER BY total_spent DESC
LIMIT    10;

```

**Execution order:** `FROM -> JOIN -> ON -> WHERE -> GROUP BY -> HAVING -> SELECT -> ORDER BY -> LIMIT`.

**Covering Indexes**






