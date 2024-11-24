# Understanding Transactions in DBMS

## Isolation Levels

To handle concurrency, DBMSs provide isolation levels:

- **Read Uncommitted:** Transactions can read uncommitted changes from other transactions (may cause dirty reads).

- **Read Committed:** Transactions can only read committed changes.

- **Repeatable Read:** Ensures that if a transaction reads the same data twice, the result will not change.

- **Serializable:** Provides the highest level of isolation, ensuring no other transactions interfere during execution.