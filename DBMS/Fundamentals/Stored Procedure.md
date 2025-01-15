# Understanding Stored Procedures in DBMS

Stored Procedures in DBMS are precompiled sets of SQL statements, stored in the database and executed as a single unit. 

They are used to encapsulate repetitive or complex operations that involve database queries, improving performance, maintainability, and security.

Syntax:

``
CREATE PROCEDURE procedure_name (parameter1 datatype, parameter2 datatype, ...)
AS
BEGIN
  -- SQL statements
END;

``

## Use Case

A procedure to retrieve employee details by department:

```
CREATE PROCEDURE GetEmployeesByDepartment (dept_id INT)
AS
BEGIN
  SELECT employee_id, name, position
  FROM employees
  WHERE department_id = dept_id;
END;
```

To execute this procedure:

```
EXEC GetEmployeesByDepartment 101;
```
