# Query 4: Employees Bonus

**Problem Statement:** Given tables: `Employee(empId, name, supervisor, salary)` and `Bonus(emp_id, bonus)`, return a dataframe containing the name and bonus amount of employees whose bonus is less than 1000.

## Algorithm

1. Merge `Employee` and `Bonus` using left join: `df = pd.merge(employee, bonus, on='empId', how='left')`

2. Filter rows where **bonus is less than 1000** or **missing**: `df = df[ (df['bonus']<1000) | df['bonus'].isnull() ]`

3. Select **name** and **bonus** columns: `df = df[['name', 'bonus']]`
