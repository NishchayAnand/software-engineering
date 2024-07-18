import pandas as pd

# Query 4: Employee Bonus
data = [[3, 'Brad', None, 4000], [1, 'John', 3, 100], [2, 'Don', 3, 2000], [4, 'Thomas', 3, 4000]]
employee = pd.DataFrame(data, columns=['empId', 'name', 'supervisor', 'salary'])
employee.astype({
    'empId': 'Int64',
    'name': 'object',
    'supervisor': 'Int64',
    'salary': 'Int64'})

data = [[2, 500], [4, 2000]]
bonus = pd.DataFrame(data, columns=['empId', 'bonus'])
bonus.astype({
    'empId': 'Int64',
    'bonus': 'Int64'
})

# Merge Employee and Bonus using left join
df = pd.merge(employee, bonus, how='left', on='empId')

## Filter rows where bonus is less than 1000 or missing
df = df[ (df['bonus']<1000) | df['bonus'].isnull() ]
print(df)

df = df[['name', 'bonus']]
print(df)
