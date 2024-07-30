# Normalization

Normalization is the process of dividing data into multiple tables, each with a specific purpose.

It is a crucial concept in relational databases that helps design table structure within the database. It applies certain principles and concepts to ensure efficient data storage.

**The primary objective of normalization is to organize the data in the database by following specific rules or forms of normalization. These rules result in the creation of multiple tables and the establishment of relationships between them.**

One of the key driving factors behind normalization is **reduction of data redundancy**, which means having the same pieces of information in multiple locations in the same database. This redundancy wastes space on the disk and creates problems when maintaining the data.

Normalization allows us to structure the data in such a way that it can't express redundant information.

## How does Normalization works?

Normalization is achieved through a series of steps, each defined by a **"normal form"**. Each subsequent normal form builds upon the previous one, adding more rules and constraints to achieve a higher degree of normalization.

- **Prime Attributes**: A unique identifier for an entity. It is a minimal set of attributes that can uniquely identify any record within a table. They play a crucial role in connecting and organizing data.

- **Non-prime Attributes**: Any attribute which is not prime. It is a descriptive characteristic of an entity that may not be unique. They depend on prime attributes for identification. The purpose of a non-prime attribute is to add details, however, it does not serve as the main identifier.

### First Normal Form (1NF)

This rule ensures that each column in a table constains only `atomic` values, i.e., **no multi-valued attributes (mixed datatypes) in a column.**

- **Atomicity**: Ensure that each column contains only atomic (indivisible) values. **Mixing datatypes within the same column is not permitted**. **Repeating groups are not permitted**.

- **Uniqueness**: Each column should have unique names. **Having a table without a primary key is not permitted**.

- **Order Independence**: The order in which data is stored does not matter. **Using row order to convey information is not permitted**.

> NOTE: There is no such thing as row order within a relational database table.

```
Non-1NF Table:
| OrderID | Product | Quantity |
|---------|---------|----------|
| 1       | A, B    | 2, 3     |

1NF Table:
| OrderID | Product | Quantity |
|---------|---------|----------|
| 1       | A       | 2        |
| 1       | B       | 3        |
```

### Second Normal Form (2NF)

Second Normal Form is about how a table's non-key columns relate to the primary key. **Each non-key attribute must depend on the whole primary key, not just part of it**.

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

- **Second Normal Form Compliance**: The table must be in 2NF.
- **Eliminate Transitive Dependency**: Ensure that non-key attributes are not dependent on other non-key attributes.

```
Non-3NF Table:
| ProductID | ProductName | SupplierID | SupplierName |
|-----------|-------------|------------|--------------|
| 101       | A           | 201        | Supplier X   |
| 102       | B           | 202        | Supplier Y   |

3NF Tables:
Products Table:
| ProductID | ProductName | SupplierID |
|-----------|-------------|------------|
| 101       | A           | 201        |
| 102       | B           | 202        |

Suppliers Table:
| SupplierID | SupplierName |
|------------|--------------|
| 201        | Supplier X   |
| 202        | Supplier Y   |
```

## Links

- https://www.youtube.com/watch?v=GFQaEYEc8_8
