# Understanding Deadlock Condition in Java

Thread deadlock happens when you have two threads, both of which are holding a key the other thread wants.

> **NOTE:** All it takes for a deadlock are **two objects and two threads**.

Java has no mechanism to handle deadlock.

## EXTRA:

Databases often have a locking mechanism somewhat like synchronization. But a real transaction management system can sometimes deal with deallock. it might assume, for example, that deadlock might have occured when two transactions are taking too long to complete. But unlike Java, the application server can do a "transaction rollback" that returns the state of the rolled-back transaction to where it was before the transaction began.
