
import pandas as pd

# Schema
data = [[101, 'John', 'A', None],
        [102, 'Dan', 'A', 101],
        [103, 'James', 'A', 101],
        [104, 'Amy', 'A', 101],
        [105, 'Anne', 'A', 101],
        [106, 'Ron', 'B', 101]]

# Create the DataFrame
employee = pd.DataFrame(data, columns=['id', 'name', 'department', 'managerId'])

# Perform a self-join using merge to link managerId with manager name
merged = pd.merge(employee, employee, left_on='managerId', right_on='id', how='left', suffixes=('_employee', '_manager'))
print(merged)
