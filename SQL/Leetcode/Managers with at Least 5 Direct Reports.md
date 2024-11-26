# Managers with at Least 5 Direct Reports

Given an **Employee** table where each row indicates the **name** of an employee, their **department**, and the **id of their manager**. Write a solution to find managers with at least five direct reports (return the result table in any order).

```
Table: Employee

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| id          | int     |
| name        | varchar |
| department  | varchar |
| managerId   | int     |
+-------------+---------+
```

**NOTE:** 
- id is the primary key (column with unique values) for this table.
- If managerId is null, then the employee does not have a manager.
- No employee will be the manager of themself.

## General Observations

- Task is to return the names of managers (employees) whose count of reportees (employees) is greater than or equal to 5. 


 




