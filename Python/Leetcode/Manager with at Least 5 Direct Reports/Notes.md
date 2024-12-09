# Managers with at Least 5 Direct Reports

Given an **Employee** dataframe where each row indicates the **id** of the employee, **name** of an employee, their **department**, and the **id of their manager**. Write a solution to find names of managers with at least five direct reports (return the result table in any order).

```
| id | name | department | managerId |
|----|------|------------|-----------|
|101 |John  |A           |NaN        |
|102 |Dan   |A           |101        |
|103 |James |A           |101        |
|104 |Amy   |A           |101        |
|105 |Anne  |A           |101        |
|106 |Ron   |B           |101        |
```

**NOTE:** 
- If `managerId` is null, then the employee does not have a manager.
- No employee will be the manager of themselves.

## General Observations

- Task is to return the names of managers (employees) whose count of reportees (employees) is greater than or equal to 5. 

- Use the **merge()** function to perform a self-join on the Employee dataframe to associate each managerId with the corresponding manager's name.
    ```
    merged = pd.merge(employee, employee how="left", left_on='managerId', right_on='id', suffixes=('_employee', '_manager'))

    | id_employee | name_employee | department_employee |managerId_employee | id_manager | name_manager | department_manager | managerId_manager |
    |-------------|---------------|---------------------|-------------------|------------|--------------|--------------------|-------------------|
    |101          |John           |A                    |NaN                |NaN         |NaN           |NaN                 |NaN                |
    |102          |Dan            |A                    |101                |101         |John          |A                   |NaN                |
    |103          |James          |A                    |101                |101         |John          |A                   |NaN                |
    |104          |Amy            |A                    |101                |101         |John          |A                   |NaN                |
    |105          |Anne           |A                    |101                |101         |John          |A                   |NaN                |
    |106          |Ron            |B                    |101                |101         |John          |A                   |NaN                |
    ```

2. Group together rows having same managerId to get the count of employees reporting to each manager. 
    ```
    SELECT m.name, count(e.id) as reporteeCount FROM Employee e JOIN Employee m ON e.managerId = m.id GROUP BY m.managerId;
    ```

3. Filter manager names where the count of reportees is greater than or equal to 5.
    ```
    SELECT m.name FROM Employee e JOIN Employee m ON e.managerId = m.id GROUP BY m.managerId HAVING count(e.id) >= 5;
    ```

## Algorithm






 




