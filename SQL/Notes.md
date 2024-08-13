# Understanding SQL (Sequential Querying Language)

SQL is a **declarative query language**. You just have to specify the pattern of the data you want, what conditions the results must meet, how you want the data to be transformed (e.g. sorted, grouped, aggregated), but not how to achieve that goal. It is up to the database system's **query optimizer** to decide which indexes and which join methods to use, and in which order to execute various parts of the query.

A declarative query language also hides implementation details of the database engine, which makes it possible for the database system to introduce performance improvements without requiring any changes to queries.

Commonly used for tasks such as inserting, updating, querying, and deleting data within a database (data modifying tasks).

SQL is also used to create and modify database schemas as well as define database access and administration parameters.

When the term **"SQL database"** is used, it refers to a type of database where SQL is the primary programming language used to create and manage that database.
