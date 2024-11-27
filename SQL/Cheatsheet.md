# SQL Cheatsheet

### Create Table

```
CREATE TABLE Employee (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    department VARCHAR(50)
);
```

- `DISTINCT`: Used to retrieve unique values from a selected column or set of columns in your query results. You can specify multiple columns after **DISTINCT** to ensure uniqueness across all of them.

- `ENUM`: A data type used to restrict a column's values to a predefined set of options. Sample Syntax: `marital_status ENUM('Single', 'Married')`.

- `ROUND(number, decimal_places)`: Rounds values to a specified number of decimal places

- `COALESCE(value_1, value_2, ...., value_n)`: Return the first value in the list that is non-null (takes in at least one value). 
