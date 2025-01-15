# Understanding Primary Key

We always need to be able to get directly to one specific row. For example, get data for one customer or update one particular patient or delete one specific user row. The typically way is that in every table, we will have one or more columns to be used as the primary key for that table.

For column(s) to be primary key, it must contain unique values.

> NOTE: For a lot of data, we don't have any column with all unique values. In that case, we usually append a Id column of some kind (for example, customerId, studentId, employeeId etc).

The main benefit of defining a primary key is it will also generate an internal index within the database.
