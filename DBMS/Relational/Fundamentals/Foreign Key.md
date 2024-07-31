# Understanding Foreign Key

A foreign key is a column or a set of columns in one table that references the primary key columns of another table. This establishes a link between the data in the two tables, ensuring that the value in the foreign key column must exist in the referenced table.

> NOTE: Foreign key can be thought of as a **"key to a different table"**.

Syntax: `FOREIGN KEY (column3) REFERENCES other_table_name(column_name)`.

## Referential Integrity

Referential integrity is a property of data stating that all its references are valid. This means that every value of a foreign key must either match a value of an existing primary key in the referenced table, or be null if allowed. You cannot delete a record from a table if there are records in another table that reference it (unless specific actions like `CASCADE`, `SET NULL`, or `RESTRICT` are defined).

> NOTE: Referential Integrity is the core purpose of a foreign key.
