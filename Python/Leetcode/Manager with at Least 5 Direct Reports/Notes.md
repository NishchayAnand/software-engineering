# Managers with at Least 5 Direct Reports

Given an **Employee** dataframe where each row indicates the **id** of the employee, **name** of an employee, their **department**, and the **id of their manager**. Write a solution to find managers with at least five direct reports (return the result table in any order).

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

## Algorithm

1. Use the **groupby()** method to group rows by managerId and count the number of employees reporting to each manager. 

    ```
    reportee_count = employee.groupby('managerId').size().reset_index(name='reportee_count')
    reportee_count.rename(columns={'managerId': 'id'}, inplace=True)

    | id | reportee_count |
    |----|-----------------|
    |101 |5                |
    ```

2. Filter managerIds where the count of reportees is greater than or equal to 5.
    ```
    reportee_count = reportee_count[reportee_count['reportee_count'] >= 5]

    | id | reportee_count |
    |----|-----------------|
    |101 |5                |
    ```

3. Use the **merge()** function to perform a self-join to associate each managerId with the corresponding manager's name.

    ```
    merged = pd.merge(reportee_count, employee, how='left', on='id')

    | id | reportee_count | name | department | managerId |
    |----|----------------|------|------------|-----------|
    |101 |5               |John  |A           |NaN        | 
    ```








 




