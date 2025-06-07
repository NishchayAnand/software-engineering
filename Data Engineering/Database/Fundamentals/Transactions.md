# Understanding Transactions in DBMS

A transaction in a Database Management System (DBMS) is a sequence of one or more operations (such as read, write, update, delete) performed on a database. These operations are treated as a single logical unit of work, which must either be completed entirely or not at all to maintain the database's consistency.

## Key Characteristics of Transactions

- **Atomicity (All or Nothing):** Ensures that either all operations in a transaction are executed successfully, or none of them are. If any operation fails, the transaction is rolled back, and the database returns to its previous state.

- **Consistency:** Ensures the database transitions from one valid state to another valid state. It means that any constraints, such as primary keys, foreign keys, or business rules, must remain satisfied after the transaction.

- **Isolation:** Ensures that transactions are executed independently of each other. Intermediate states of a transaction must not be visible to other concurrent transactions.

- **Durability:** Ensures that once a transaction is committed, its changes are permanent, even in the event of a system failure.

These four properties are collectively referred to as the **ACID properties**.

## Lifecycle of a Transaction

- **Begin:** The transaction starts.

- **Execution:** Operations such as INSERT, UPDATE, DELETE, or SELECT are performed.

- **Commit:** If all operations are successful, the changes are permanently applied to the database.

- **Rollback:** If any operation fails, all changes are undone, and the database is restored to its previous state.

## Isolation Levels in Transactions

To handle concurrency, DBMSs provide isolation levels:

- **Read Uncommitted:** Transactions can read uncommitted changes from other transactions (may cause **dirty reads**).

- **Read Committed:** Ensures that only committed data is read during the transaction (default in most databases).

- **Repeatable Read:** Ensures that if a transaction reads the same data twice, the result will not change. This prevents non-repeatable reads (also known as inconsistent reads).

- **Serializable:** Provides the highest level of isolation, ensuring no other transactions interfere during execution. This effectively locks entire ranges of data to maintain consistency.