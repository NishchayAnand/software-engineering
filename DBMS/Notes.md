# Understanding Database Management Systems (DBMS)

Databases are a logical grouping of schemas, whereas schemas are a logical grouping of tables, views, functions, procedures, etc.

- `Table`: A table is a physical object logically organized in a row-and-column format. The data is stored in a database at a physical location.

- `View`: A view is a virtual or logical table that uses some SQL logic or code to retrieve data. If we wanted to update a record to have a different value, we will not be able to do that in the view, as the view is not storing any data. We will have to go to the source, which is a directory table.
