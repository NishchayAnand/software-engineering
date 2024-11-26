# Understanding Relational Database Management Systems (RDBMS)

In a relational database, the query optimizer automatically decides which parts of the query to execute in which order, and which indexes to use.

Databases are a logical grouping of schemas, whereas schemas are a logical grouping of tables, views, functions, procedures, etc.

- `Table`: A table is a physical object logically organized in a row-and-column format. The data is stored in a database at a physical location.

- `View`: A view is a virtual or logical table that uses some SQL logic or code to retrieve data. If we wanted to update a record to have a different value, we will not be able to do that in the view, as the view is not storing any data. We will have to go to the source, which is a directory table.

## Data Organization Techniques

- **Data Modeling**
- **Data Indexing**
- **Data Normalization**

## Disadvantages

- **Flexibility:** Difficult to modify. Does not have flexible Schema.
- **Scalibility:** Does not support massive scalability.
- **Geographic Distribution:**

## EXTRA

`Oracle` uses a variant of SQL called **PL/SQL, which incorporates procedural programming elements within SQL statements**. This allows for more complex functionalities like loops and conditional logic within queries.

`Snowflake` employs a standard-compliant SQL dialect closer to what you'd find in platforms like **MySQL** or **PostgreSQL**. This makes Snowflake's SQL syntax more familiar and portable across different databases.
