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

### Delete a Row from a Table

```
DELETE FROM students
WHERE student_id = 2;
```

### Handle NULL Values using COALESCE

```
SELECT 
    first_name, 
    COALESCE(middle_name, 'No Middle Name') AS middle_name, 
    last_name
FROM student;
```