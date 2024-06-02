# Understanding JPA

You cannote persist Java objects without having to format them in a shape that the database can understand and accept.

Working with Java Objects instead of relational databases is a good thing in the object-oriented programming realm.

JPA is the answer for the following question, **How easy would it be if I could save the object by simply calling a save method instead of writing JDBC code?**

## ORM (Object-Relational Mapping)

The main of ORM tools is to transform the Java objects to relational data and vice versa.

There are quite a few ORMs available. One that has gained a serious following is Hibernate.

Hibernate is an ORM framework that lets you work on Java objects without having to worry about SQL queries, database connections, datasources, and resource management issues.

Hibernate is a framework that takes the burden of object persistence in a relational database.

Hibernate takes care if the object-relational mismatch problem.

**Steps involved in using Hibernate:**

1. Configuring the Session Factory and Datasources.
2. Setting the Hibernate properties.
3. Creating the POJO and relevant mappings.

**Sample Use Cases:** Persist `Trades` to the database.

## Transactions

Think of Transactions as a unit of work that either should succeed or fail.

---

JPA is a higher-level abstraction for database access, built on top of JDBC. It allows developers to work with persistent entities and relationships using object-oriented principles, reducing the need for manual SQL queries and result set handling.

Hibernate is an ORM (Object-Relational Mapping) framework that implements JPA specifications. It abstracts away the details of database interactions, allowing developers to work with plain old Java objects (POJOs) while transparently handling database operations.

---

EXTRA:

Hibernate requires a `Session` object in order to access the database. A `Session` is created from the `SessionFactory`.
