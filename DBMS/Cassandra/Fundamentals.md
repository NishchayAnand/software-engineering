
Q. Explain the limitations of relational databases.

- Joins are inherent in any relatively normalised relational database of even modest size, and joins can be slow.

- The way that databases gain consistency is typically through the use of **transactions**, which require locking some portion of the database so it’s not available to other clients. This can become untenable under very heavy loads, as the locks mean that competing users start queuing up, waiting for their turn to read or write the data.

---

Q. What are the use cases for ACID?

---

Cassandra data model focuses on writing queries such that we can have constant time data access.

If massive, elastic scalability is not an issue for you, the trade-offs in relative complexity of a system such as Cassandra may simply not be worth it.


The relational database still is clearly one of the most successful software applications in history.

Each node can handle 2-4 TB of data.

CQL is a subset of SQL.

---

Q. Explain the steps to create a logical data model.

1. Create a table schema from the conceptual data model and for each query.
2. Identify **equality search attributes** (e.g., `select .... where user_id = ?`).
3. Identify **inequality search attributes** (e.g., `select .... where uploaded_timestamp > ?`).
4. Identify **ordering attributes** (e.g., `select .... order by uploaded_timestamp desc`).

---
## Data Modelling



In case of concurrency, last write wins, hence, primary keys should be unique. 

Store together what you retrieve together.

Avoid big partitions

Avoid unbounded partitions

Avoid hot partitions

**Denormalisation:** A strategy used on a database to increase read performance, at the expense of losing some write performance, by adding redundant copies of data.

**Data Modelling Workflow:**
- Analyse user behaviour (customer first)
- Identify workflows, their dependencies and needs
- Define queries to fulfill these workflows
- Knowing the queries, design tables, using denormalisation
- Use Batch when inserting or updating denormalised data of multiple tables

Table naming convention: `[payload]_by_[user]`. For example:

1. Find **comments** posted for a **user** with a known id (show most recent first): **comments_by_user**.

```
SELECT * FROM comments_by_user WHERE userid = <some UUID>;
```

1. Find **comments** for a **video** with a known id (show most recent first): **comments_by_video**

```
SELECT * FROM comments_by_video WHERE videoid = <some UUID>;
```
 ---




