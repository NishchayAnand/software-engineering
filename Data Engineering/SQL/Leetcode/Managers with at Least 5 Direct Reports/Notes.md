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
- `id` is the primary key (column with unique values) for this table.
- If `managerId` is null, then the employee does not have a manager.
- No employee will be the manager of themself.

## General Observations

- Task is to return the names of managers (employees) whose count of reportees (employees) is greater than or equal to 5. 

## Algorithm

1. Perform self join on Employee table to join each managerId with his/her name.
    ```
    SELECT e.managerId AS managerId, e.id AS reporteeId, m.name AS managerName FROM Employee e JOIN Employee m ON e.managerId = m.id;
    ```

2. Group together rows having same managerId to get the count of employees reporting to each manager. 
    ```
    SELECT m.name, count(e.id) as reporteeCount FROM Employee e JOIN Employee m ON e.managerId = m.id GROUP BY m.managerId;
    ```

3. Filter manager names where the count of reportees is greater than or equal to 5.

    ```
    SELECT m.name FROM Employee e JOIN Employee m ON e.managerId = m.id GROUP BY m.managerId HAVING count(e.id) >= 5;
    ```

## Final Query

```
SELECT 
    m.name
FROM 
	Employee e 
JOIN 
	Employee m 
ON
	e.managerId = m.id
GROUP BY
	e.managerId
HAVING 
	count(e.id) >= 5;
```




 




