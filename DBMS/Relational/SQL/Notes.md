# Understanding SQL (Sequential Querying Language)

SQL is a **declarative query language**. You just have to specify the pattern of the data you want, what conditions the results must meet, how you want the data to be transformed (e.g. sorted, grouped, aggregated), but not how to achieve that goal. It is up to the database system's **query optimizer** to decide which indexes and which join methods to use, and in which order to execute various parts of the query.
