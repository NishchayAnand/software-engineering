# SQL Cheatsheet

### Define FOREIGN KEY While Creating a Table

```
CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
```