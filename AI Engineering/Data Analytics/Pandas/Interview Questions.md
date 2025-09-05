# Pandas Interview Questions

Q. Explain `merge()` function.

The `merge()` function allows us to perform join operations on two dataframes, similar to SQL joins. It allows merging based on columns or indices (used rarely) from either or both DataFrames.

```
Syntax: pd.merge(
            left: DataFrame to be merged,
            right: DataFame to be merged,
            how: Type of join to perform (e.g. inner, left, right, outer),
            on: Column(s) common to both DataFrames to merge on,
            left_on: Columns to merge on from the left DataFrame,
            right_on: Columns to merge on from the right DataFrame,
            left_index: use indices from the left DataFrame to merge on,
            right_index: use indices from the right DataFrame to merge on,
            suffixes: Suffixes added to overlapping columns for distinction.
        )
```
---

Q. Explain `groupby()` function.

The `groupby()` function divides the DataFrame into subsets (groups) based on the unique values of a column or a combination of columns.

```
# Example: Split the employee DataFrame into groups based on unique Departments.

import pandas as pd

employee = {'Department': ['A', 'B', 'A', 'B', 'A'],
        'Employee': ['John', 'Dan', 'James', 'Amy', 'Anne'],
        'Salary': [5000, 6000, 7000, 8000, 9000]}

df = pd.DataFrame(employee)

grouped = df.groupby('Department') # would split into two groups: (i) containing rows where Department = 'A' and (ii) containing rows where Department = 'B'.
```

> NOTE: The split data is stored in an intermediate GroupBy object but not materialized (or evaluated) until you apply a function (e.g., aggregation, transformation, or filtering). This lazy evaluation makes `groupby()` efficient, as it avoids unnecessary computations.

---

Q. Explain the types of functions that can be applied to a `GroupBy` object.

- **Aggregation Functions**: Reduces each group to a single scalar value (summarizes the data for each group)  and returns the result as a Series or DataFrame, depending on the aggregation and the columns involved.

    ```
    # Example: Sum of Salaries by Department
    result = df.groupby('Department')['Salary'].sum() # result is a Series with the group labels (Departments) as the index.
    ```

- **Transformation Functions**: These functions return a Series or DataFrame of the same shape as the original data (modifies or processes data within groups without reducing the group's size).

    ```
    # Example: Normalize Salaries Within Each Department
    df['Normalized_Salary'] = df.groupby('Department')['Salary'].transform('mean')
    ```    

- **Filtering functions**: These functions are used to retain or discard entire groups based on some condition.

    ```
    # Example: Keep Departments Where Total Salary Exceeds 15,000
    result = df.groupby('Department').filter(lambda x: x['Salary'].sum() > 15000)
    ``` 

---