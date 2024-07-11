# Query 1

**Customer Who Visited The Mall but Did Not Have Any Transactions**

Table 1: `Visits(visit_id, customer_id)`: Same customer (`customer_id`) can visit multiple times (can have multiple `visit_id`).

Table 2: `Transactions(transaction_id, visit_id, amount)`: A customer can make multiple transactions (`transaction_id`) in a single visit (`visit_id`).
