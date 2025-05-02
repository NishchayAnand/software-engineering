
import pandas as pd

# Schema
data = [[101, 'John', 'A', None],
        [102, 'Dan', 'A', 101],
        [103, 'James', 'A', 101],
        [104, 'Amy', 'A', 101],
        [105, 'Anne', 'A', 101],
        [106, 'Ron', 'B', 101]]

# Create the DataFrame
employee = (pd.DataFrame(data, columns=['id', 'name', 'department', 'managerId'])
                .astype({'id': 'int64', 'name': 'object', 'department': 'object', 'managerId': 'Int64'}))

# Step 1: Group by managerId and count the number of employees reporting to each manager.
direct_reports_count = employee.groupby('managerId').size().reset_index(name='direct_reports')

# Step 2: Filter managerIds where the direct report's count is greater than or equal to 5.
direct_reports_count = direct_reports_count[direct_reports_count['direct_reports'] >= 5]

# Step 3: Perform an inner-join between direct_reports_count and employee dataframe to link manager's id with manager's name.
direct_reports_count.rename(columns={'managerId': 'id'}, inplace=True)
merged = pd.merge(direct_reports_count, employee, on='id')
