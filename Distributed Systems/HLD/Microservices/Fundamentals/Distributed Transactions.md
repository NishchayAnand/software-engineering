## Understanding Distributed Transactions

Distributed transactions try to span multiple transactions within them, using some overall governing process called **transaction manager**.

The most common algorithm for handling distributed transactions - expecially short-lived transactions, as in the case of handling a customer order - is to use a **two-phase commit**.
