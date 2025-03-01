## Column-Oriented Storage (Snowflake)

`select *` queries are rarely needed for analytics. 

Although fact tables are often over 100 columns wide, a typical data warehouse query only accesses 4 or 5 of them at one time. Even when we use indexes, the row-oriented storage engine still needs to load all of those rows (each consisting of over 100 attributes) from disk to memory, parse them, and filter out those that don't meet the required conditions.

The idea behind column-oriented storage is simple: don't store all the values from one row together, but store all the values from each column together instead. The kth item in one column belongs to the same row as the kth item in another column.

**If each column is stored in a separate file, a query only needs to read and parse those columns that are used in that query, which can save a lot of work.**

> **NOTE:** Column storage is easiest to understand in a relational data model, but it applies equally to non-relational data. For example, **Parquet*** is a columnar storage format that supports a document data model, based on Google's Dremel.

## How does data retrieval work in column-oriented storage?

The column-oriented storage layout relies on each column file containing the rows in the same order. Thus, if you need to reassemble on entire row, you can take the 23rd entry from each of the individual column files and put them together to form the 23rd row of the table.

> **NOTE:** Bitmap indexes are very well suited for the kinds of queries that are common in a data warehouse. 

## Writing to Column-Oriented Storage

If you want to insert a row in the middle of a sorted table, you would most likely have to rewrite all the column files. As rows are identified by their position within a column, the insertion has to update all columns consistently.

## Materialized Views

Data warehouse queries often involve an aggregate function, such as `COUNT`, `SUM`, `AVG`, `MIN`, `MAX` in SQL. 

Materialized views are based on the idea: **Why not cache some of the counts or sums that queries use most often?**

In relational data model, it is often defined like a standard (virtual) view: a table-like object whose contents are the results of some query. The difference is that a materialized view is an actual copy of the query results, written to disk, whereas a virtual view is just a shortcut for writing queries. **When you read from a virtual view, the SQL engine expands it into the view's underlying query on the fly and then process the expanded query. ????**

When the underlying data changes, a materialized view needs to be updated, because it is a denormalized copy of the data. The database can do that automatically, but such updates make writes more expensive, which is why materialized views are not often used in OLTP databases. 

## Data Replication

Replication means keeping a copy of the same data on multiple machines that are connected via a network. 

### Leaders and Followers




















