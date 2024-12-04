# Managers with at Least 5 Direct Reports

Given an **Employee** dataframe where each row indicates the **id** of the employee, **name** of an employee, their **department**, and the **id of their manager**. Write a solution to find managers with at least five direct reports (return the result table in any order).

**NOTE:** 
- If `managerId` is null, then the employee does not have a manager.
- No employee will be the manager of themselves.

## General Observations

- Task is to return the names of managers (employees) whose count of reportees (employees) is greater than or equal to 5. 

## Algorithm

1. Perform self join on Employee dataframe to join each managerId with his/her name.
    ```
    result = df.merge(df, how="")
    ```

2. Group together rows having same managerId to get the count of employees reporting to each manager. 
    ```
    SELECT m.name, count(e.id) as reporteeCount FROM Employee e JOIN Employee m ON e.managerId = m.id GROUP BY m.managerId;
    ```

3. Filter manager names where the count of reportees is greater than or equal to 5.
    ```
    SELECT m.name FROM Employee e JOIN Employee m ON e.managerId = m.id GROUP BY m.managerId HAVING count(e.id) >= 5;
    ```

## Final Code






 




