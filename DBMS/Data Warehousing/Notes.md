## Data Warehousing

At first, the same databases were used for both transaction processing and analytic queries. SQL turned out to be quite flexible in this regard: it works well for OLTPtype queries as well as OLAP-type queries. Nevertheless, in the late 1980s and early 1990s, there was a trend for companies to stop using their OLTP systems for analytics purposes, and to run the analytics on a separate database instead. This separate database was called a **data warehouse.**

OLTP systems are usually expected to be highly available and to process transactions with low latency, since they are often critical to the operation of the business.Database administrators therefore closely guard their OLTP databases. They are usually reluctant to let business analysts run ad hoc analytic queries on an OLTP database, since those queries are often expensive, scanning large parts of the dataset, which can harm the performance of concurrently executing transactions.

A data warehouse, by contrast, is a separate database that analysts can query to their hearts’ content, without affecting OLTP operations. The data warehouse contains a read-only copy of the data in all the various OLTP systems in the company. Data is extracted from OLTP databases (using either a periodic data dump or a continuous stream of updates), transformed into an analysis-friendly schema, cleaned up, and then loaded into the data warehouse. This process of getting data into the warehouse is known as **Extract–Transform–Load (ETL)**.

A big advantage of using a separate data warehouse, rather than querying OLTP systems directly for analytics, is that the data warehouse can be optimized for analytic access patterns.

The data model of a data warehouse is most commonly relational, because SQL is generally a good fit for analytic queries.

On the surface, a data warehouse and a relational OLTP database look similar, because they both have a SQL query interface. However, the internals of the systems can look quite different, because they are optimized for very different query patterns.

> **NOTE:** Many database vendors now focus on supporting either transaction processing or analytics workloads, but not both.

## Star Schema

A wide range of different data models are used in the realm of transaction processing, depending on the needs of the application. On the other hand, in analytics, there is much less diversity of data models. Many data warehouses are used in a fairly formulaic style, known as a **star schema (also known as dimensional modeling)**. At the center of the schema is a so-called **fact table**. Each row of the fact table represents an event that occurred at a particular time (e.g. a customer’s purchase of a product, a page view or a click by a user).

Usually, **facts are captured as individual events**, because this allows maximum flexibility of analysis later. Some of the columns in the fact table are attributes, such as the price at which the product was sold and the cost of buying it from the supplier (allowing the profit margin to be calculated). Other columns in the fact table are foreign key references to other tables, called **dimension tables**. As each row in the fact table represents an event, the dimensions represent the `who`, `what`, `where`, `when`, `how`, and `why` of the event.

The name “star schema” comes from the fact that when the table relationships are visualized, the fact table is in the middle, surrounded by its dimension tables, the connections to these tables are like the rays of a star.

## Snowflake Schema

A variation of this template is known as the **snowflake schema**, where dimensions are further broken down into subdimensions. **Snowflake schemas** are more normalized than **star schemas**, but **star schemas** are often preferred because they are simpler for analysts to work with.

## Column-Oriented Storage

In most OLTP databases, storage is laid out in a row-oriented fashion (all the values from one row of a table are stored next to each other). However, `SELECT *` queries are rarely needed for analytics. Document databases are similar: an entire document is typically stored as one contiguous sequence of bytes.

For a `SELECT` query, a row-oriented storage engine needs to load all rows from disk into memory, parse them, and filter out those that don’t meet the required conditions. That can take a long time.

The idea behind column-oriented storage is simple: **don’t store all the values from one row together, but store all the values from each column together instead**. In simple words, **storing relational data by columns, rather than by row**. If each column is stored in a separate file, a query only needs to read and parse those columns that are used in that query, which can save a lot of work.

> **NOTE:** `Parquet` is a columnar storage format that supports a document data model, based on Google’s Dremel.

The column-oriented storage layout relies on **each column file containing the rows in the same order**. For example, if you need to reassemble an entire row, you can take the 23rd entry from each of the individual column files and put them together to form the 23rd row of the table.
