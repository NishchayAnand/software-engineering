
## EXTRA

Each node can handle 2-4 TB of data.

CQL is a subset of SQL.

---
## Data Modeling

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




