# Understanding JDBC

JDBC has simplified data access in Java applications. Not only it provided independence from database vendor lock-in, but we also have a standard API to access multitude of databases.

JDBC abstracts away the intricacies involved in accessing different databases.

The steps involved in using JDBC are always the same - obtain a connection, create a `Statement`, execute a query, run it through `ResultSet`, and release the resources.

When writing JDBC code, make sure to take care of the following points:

1. Proper **resource management (creating and closing connections and statements).**
2. Catch all the `SQLException` **(both in creation and destruction processes).**

- JDBC returns a `ResultSet` and we need to map each and every column data from the `ResultSet` into our domain objects.

> NOTE: `execute()` methods are usually used for running Data Definition Language (DDL) statements easily.

There are two parts in any JDBC client program: one part gets the connection, creates the statement, and deals with resource management, which is more or less a boilerplate code. The other part is the heart of the application where we code the business logic.

Frameworks like Spring Data hides away the non-business code effeciently in the templates while allowing us to concentrate on the business logic.
