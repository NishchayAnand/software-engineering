# Normalization

Normalization is a systematic approach to organizing data in a database to **reduce redundancy (duplicate data)** and improve data integrity. It involves dividing a database into smaller tables and defining relationships between them to ensure that data is logically stored and can be efficiently retrieved.

## Normal Forms (NFs)

Normalization is performed in stages called Normal Forms (NFs). Each form builds on the previous one to further reduce redundancy and improve structure. Below are the commonly used Normal Forms:

### First Normal Form (1NF)

- Ensure that each column contains atomic (indivisible) values.

- Ensure that each row is unique.

## EXTRA

Normalization is the process of organizing the data in a table. Normalization implies creating a specific data model consisting of `tables` and `relationships`. Normalization is the process of organizing data in the database. Normalization is the process of dividing data into multiple tables, each with a specific purpose.

Redundant data wastes space and causes maintenance issues. Normalization allows us to avoid data redundancy between tables.

The key feature of the term **normal form** is that it eliminates transitive dependency.

It is a crucial concept in relational databases that helps design table structure within the database. It applies certain principles and concepts to ensure efficient data storage.

**The primary objective of normalization is to organize the data in the database by following specific rules or forms of normalization. These rules result in the creation of multiple tables and the establishment of relationships between them.**

One of the key driving factors behind normalization is **reduction of data redundancy**, which means having the same pieces of information in multiple locations in the same database. This redundancy wastes space on the disk and creates problems when maintaining the data.

Normalization allows us to structure the data in such a way that it can't express redundant information.

Normalization is achieved through a series of steps, each defined by a **"normal form"**. Each subsequent normal form builds upon the previous one, adding more rules and constraints to achieve a higher degree of normalization.

- **Prime Attributes**: A unique identifier for an entity. It is a minimal set of attributes that can uniquely identify any record within a table. They play a crucial role in connecting and organizing data.

- **Non-prime Attributes**: Any attribute which is not prime. It is a descriptive characteristic of an entity that may not be unique. They depend on prime attributes for identification. The purpose of a non-prime attribute is to add details, however, it does not serve as the main identifier.

### First Normal Form (1NF)

We need to get data into rows, and all rows need to have same attributes in the same order. Each attribute also has to be the same data type across all rows. For example, if an attribute is integer type in one row, it must be integer in all other rows.

Each row should have a primary key.

Cannot have an attribute that contains a list or a table or an array. It has to be a single value.

This rule ensures that each column in a table constains only `atomic` values, i.e., **no multi-valued attributes (mixed datatypes) in a column.**

- **Atomicity**: Ensure that each column contains only atomic (indivisible) values. **Mixing datatypes within the same column is not permitted**. **Repeating groups are not permitted**.

- **Uniqueness**: Each column should have unique names. **Having a table without a primary key is not permitted**.

- **Order Independence**: The order in which data is stored does not matter. **Using row order to convey information is not permitted**.

> NOTE: There is no such thing as row order within a relational database table.



### Second Normal Form (2NF)

Every attribute in a row should be dependent on the primary key. If it doesn't depend on the entire key, then it doesn't belong in the row, i.e., it doesn't belong in that entity.

Second Normal Form is about how a table's non-key columns relate to the primary key. **Each non-key attribute `must depend on the whole primary key, not just part of it`**.

Designed to tackle partial dependencies.

- **First Normal Form Compliance**: The table must be in 1NF.
- **Eliminate Partial Dependency**: Ensure that non-key attributes are fully dependent on the entire primary key, not just part of it.

- **Deletion Anomaly**:
- **Update Anomaly**:
- **Insertion Anomly**:

```
Non-2NF Table:
| OrderID | ProductID | ProductName | Quantity |
|---------|-----------|-------------|----------|
| 1       | 101       | A           | 2        |
| 1       | 102       | B           | 3        |

2NF Tables:
Orders Table:
| OrderID | Quantity |
|---------|----------|
| 1       | 2        |
| 1       | 3        |

Products Table:
| ProductID | ProductName |
|-----------|-------------|
| 101       | A           |
| 102       | B           |
```

### Third Normal Form (3NF)

It advises the removal of fields in a table that are independent of the key, guaranteeing that the non-prime attributes are not dependent on other non-prime attributes.

**Every non-key attribute in a table should `depend on the key, the whole key, and nothing but the key`.**

- **Second Normal Form Compliance**: The table must be in 2NF.
- **Eliminate Transitive Dependency**: Ensure that non-key attributes are not dependent on other non-key attributes.



> **NOTE:** There are higher normal forms such as fourth and fifth, however, achieving third normal form is considered necessary in most cases.

## Links

- https://www.youtube.com/watch?v=GFQaEYEc8_8
