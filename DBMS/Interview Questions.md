# DBMS Interview Questions

Q. What is a schema?

A schema is a logical structure within a database that organizes and groups database objects (like tables, views, stored procedures, and indexes) under a common namespace.

---

Q. What is normalization?

Normalization is a systematic approach to organizing data in a database to **reduce redundancy (duplicate data)** and improve data integrity. It involves dividing a database into smaller tables and defining relationships between them to ensure that data is logically stored and can be efficiently retrieved.

> NOTE: In some cases, normalization can make queries more complex due to additional joins. For read-heavy systems or data warehouses, slight denormalization (storing redundant data) is sometimes preferred to improve performance.

---

Q. Explain different Normal Forms (NFs) of Normalization.

Normalization is performed in stages called Normal Forms (NFs). Each form builds on the previous one to further reduce redundancy and improve structure. 

1. **First Normal Form (1NF)**: Ensure that each column contains atomic (indivisible) values and each row is unique.

    ```
    Non-1NF Table:

    | Student_ID |    Name    |      Subject       |
    |------------|------------|--------------------|
    | 1          | Alice      | Maths, Physics     |
    | 2          | Bob        | English, Maths     |

    1NF Table:

    | Student_ID |    Name    |  Subject   |
    |------------|------------|------------|
    | 1          | Alice      | Maths      |
    | 1          | Alice      | Physics    |
    | 2          | Bob        | English    |
    | 2          | Bob        | Maths      |
    ```

2. **Second Normal Form (2NF)**: Ensure that every non-prime attribute (non-primary key column) is fully dependent on the primary key (no partial dependency).

    ```
    Non-2NF Table:

    | Student_ID | Subject_ID | Subject |
    |------------|------------|---------|
    | 1          | 101        | Maths   | 
    | 1          | 102        | English | 

    Problem: Subject depends only on Subject_ID, not the composite key (Student_ID, Subject_ID), causing partial dependency.

    2NF Tables:

    Subject Table:

    | Subject_ID | Subject |
    |------------|---------|
    | 101        | Maths   |
    | 102        | English |

    Student-Subject Table:

    | Student_ID | Subject_ID |
    |-----------|-------------|
    | 1         | 101         |
    | 1         | 102         |
    ```

3. **Third Normal Form (3NF)**: Ensure that no transitive dependency exists (non-prime attributes should depend only on the primary key, not other non-prime attributes).

    ```
    Non-3NF Table:

    | Subject_ID | Instructor | Instructor_Email |
    |------------|------------|------------------|
    | 101        | Dr. Smith  | smith@uni.com    |
    | 102        | Dr. Brown  | brown@uni.com    |

    Problem: Instructor_Email depends on Instructor, not directly on Subject_ID.

    3NF Tables:

    Subject-Instructor Table:

    | Subject_ID | Instructor |
    |----------- |------------|
    | 101        | Dr. Smith  | 
    | 102        | Dr. Brown  | 

    Instructor Table:

    | Instructor | Instructor_Email |
    |------------|------------------|
    | Dr. Smith  | smith@uni.com    |
    | Dr. Brown  | brown@uni.com    |
    ```

---

Q. What are Triggers?

Triggers in DBMS are procedural code automatically executed in response to certain events (e.g. INSERT, UPDATE, DELETE) on a specified table or view. 

They are used to enforce constraints, automate workflows, maintain data integrity, and respond to changes in the database.

> NOTE: Triggers can be executed either BEFORE or AFTER the event.

---

Q. What are Stored Procedures?

Stored Procedures in DBMS are precompiled sets of SQL statements, stored in the database and executed as a single unit. 

They are used to encapsulate repetitive or complex operations that involve database queries, improving performance, maintainability, and security.

---

Q. Difference between SQL and NoSQL databases.

A relational database works well with read-heavy and write-less frequently workflow. 

NoSQL databases are generally optimised for writes and the relational database works well enough for read-heavy workflow.

---



