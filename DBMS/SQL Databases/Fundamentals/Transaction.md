# Understanding Transaction

Most relational database management systems (RDBMS) have a built-in feature called a Transaction.

## ACID

ACID stands for `Atomic`, `Consistent`, `Isolated`, `Durable`. These are 4 perspectives to consider about what makes a successful transaction.

- **Atomic:** You can split a transaction even if it consists of multiple parts. **You either do all of it or none of it.**

- **Consistent:** Means the transaction must take the database from one valid state to another valid state. **The DB was valid before, it's valid after.**

- **Isolated:** No one will ever see the results halfway through the transaction. **No-one sees "half completed" results.**

- **Durable:** Once the database confirms that the the transaction is complete, all things are done and persisted. You won't see any discrepancy when if there is any electricity cut just after your transaction completed. **When it's done, it stays done.**
