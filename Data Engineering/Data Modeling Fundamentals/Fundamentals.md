
Q. Explain **Relational Model.**

In relational model, the data is organised into **relations** (called tables in SQL).

The roots of relational databases lie in business data processing, typically transaction processing (entering sales or banking transactions, airline reservations, stock-keeping in warehouses) and batch processing (customer invoicing, payroll, reporting).

> **NOTE:** The relational model was proposed by Edgar Codd in 1970.

---

Q. Explain **Object-Relational Mismatch**.

Most application development today is done in object-oriented programming languages, which leads to a common criticism of the SQL data model.

In other words, if data is stored in relational tables, an awkward translation layer is required between the objects in the application code and the database model of tables, rows and columns. The disconnect between the models is sometimes called an **impedance mismatch**.

> **NOTE:** Object-relational mapping (ORM) frameworks like Hibernate reduce the amount of boilerplate code required for this translation layer, but they can't completely hide the differences between the two models.

For example, consider a resume expressed in a relational schema:

- The profile as a whole can be identified by a unique identifier: `user_id`.
- Fields like `first_name` and `last_name` appear exactly once per user, so that can be modelled as columns on the `users` table.
- Fields like `positions (jobs)`, `education`, `contact_information` have a **one-to-many** relationship with the `users` table. In traditional SQL model, the most common normalised representation is to put `positions`, `education`, and `contact_information` in **separate tables**, with a foreign key reference to the `users` table.

Relational model for use cases like resume becomes quite constraint. 

---

Q. Explain **Document Model.**

For a data structure like resume, which is mostly a self-contained document, a `JSON` representation can be quite appropriate.

The `JSON` representation has better locality than the multi-table schema. If you want to fetch a profile in the relational example, you need to either perform multiple queries (query for each table by `user_id`) or perform messy multiway join between the `users` table and its subordinate tables. In the `JSON` representation, all the relevant information is on one place, and one query is sufficient.

---

Q. Explain the problems with **JSON** as a data encoding format.

**Many-to-One** relationship don't fit nicely into the document model. Since, document model does not support joins, you have to emulate a join in application code by making multiple queries to the database.

> **NOTE:** Even if the initial version of an application fits well in a join-free document model, data has a tendency of becoming more interconnected as features are added to applications.

---

Q. Explain the limitations of **Document Model**.

A document is usually stored as a single continuous string, encoded in `JSON`, `XML`, or a binary variant (such as `BSON` in MongoDB). The database typically needs to load the entire document, even if you access only a small portion of it, which can be wasteful on large documents. On updates to a document, the entire document usually needs to be rewritten (only modifications that don't change the encoded size of a document can easily be performed in place). For these reasons, it is generally recommended that you keep documents fairly small and avoid writes that increase the size of a document.

These performance limitations significantly reduce the set of situations in which document databases are useful.

---

Q. When to use **Document Model**?

If the data in your application has a document-like structure (i.e., a tree of one-to-many relationships), then it's probably a good idea to use a document model. The poor support for joins in document databases may or may not be a problem, depending on the application. For example, many-to-many relationships may never be needed in an **analytics application** which is simply recording which events occurred at which time.

If your application does use many-to-many relationships, the document model becomes less appealing. It's possible to reduce the need for joins by **denormalising**, but the application code need to do additional work to keep the denormalised data consistent.

> **NOTE:** If you're mostly reading data rather than frequently updating it (read-heavy workloads), document databases can be highly efficient.

---
