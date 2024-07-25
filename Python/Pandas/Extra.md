Pandas inherits its data types primarily from NumPy. Some of the fundamental data types you'll encounter in Pandas include:

- **int64**: 64-bit integer
- **float64**: 64-bit floating point number
- **object**: This is a catch-all data type. It's often used for strings but can hold other Python objects as well.

## Create a DataFrame

**Example 1:** Using a `dictionary`

```
my_dict = {"Name": ["Nishchay", "Vridhi", "Archie"], "Age": [26, 19, 1]}
df = pd.DataFrame(my_dict)
```

**Example 2:** Using a `2-D list`

```
student_data = [
  [1, 15],
  [2, 11],
  [3, 11],
  [4, 20]
]
df = pd.DataFrame(student_data)
```

## Set Custom Column Names

`columns` parameter:

```
student_data = [
  [1, 15],
  [2, 11],
  [3, 11],
  [4, 20]
]
column_names = ["student_id", "age"]
df = pd.DataFrame(student_data, columns=column_names)
```

## Get Dimensions

`shape` attribute: Returns the dimensions of the DataFrame or Series in the form of a tuple (rows, columns). **Sample Syntax:** `df.shape`.

```
print(df.shape)
```

## Display First 3 Rows

`head()` function: Returns the first n rows. If n is omitted, it defaults to returning the first 5 rows. **Sample Syntax:** `df.head(n)`.

```
print(df.head(3))
```

## Select Data

`loc` attribute: One of the primary ways to select data from a DataFrame. It is label-based, which means you have to specify the name of the rows or columns to select data. **Sample Syntax:** `filtered_df = df.loc[df["Age"]>20]`.

```
filtered_df = df.loc[df["Age"]>20]
print(filtered_df)
```

## Create a New Column

```
employees["bonus"] = employees["salary]*2
```

## Drop Duplicate Rows

`drop_duplicates()` function: Its purpose is to drop duplicate rows. You can specify the criteria based on which the rows are considered duplicates.

**Sample Syntax:** `customers.drop_duplicates(subset='email', keep='first', inplace=True)`

Where:

- **subset:** the column label or sequence of labels to consider for identifying duplicate rows. If not provided, it considers all columns in the DataFrame.
- **keep:** determines which duplicate row to retain.
  - first: (default) Drop duplicates except for the first occurrence.
  - last: Drop duplicates except for the last occurrence.
  - False: Drop all duplicates.
- **inplace:** If set to True, the changes are made directly to the object without returning a new object. If set to False (default), a new object with duplicates dropped will be returned.

```
customers.drop_duplicates(subset="email", keep="first", inplace=True)
```

## Drop Missing Data

`dropna()`: Used to remove missing values. **Sample Syntax:** `DataFrame.dropna(axis=0, subset=None, inplace=False)`

Where:

- **axis:** If axis=0 (default), it drops rows which contain missing values, and if axis=1, it drops columns which contain missing value.
- **subset:** Labels along the other axis to consider. For example, if you are dropping rows, these would be a list of columns to include. This is particularly useful when you only want to consider NA values in certain columns.
- **inplace:** A boolean which makes the changes in dataframe itself if True.

## Rename a Column

`rename()` function: Used to rename column names or index names.

**Sample Syntax:** DataFrame.rename(index=None, columns=None, copy=True, inplace=False, errors='raise')

Where:

- **index:**: Dictionaries you can pass to rename index.
- **columns:** Dictionaries you can pass to rename columns.
- **copy:** If set to True, a new DataFrame is created. If False, the original DataFrame is modified.
- **inplace:** If set to True (default), the renaming will modify the DataFrame in place and nothing will be returned. If False, a new DataFrame with renamed columns will be returned without modifying the original DataFrame.
- **errors:** If 'raise', an error is raised if you try to rename an item that doesn't exist. If set to 'ignore', any failure to rename items will be ignored.

```
students.rename(columns={
  "id": "student_id",
  "first": "first_name",
  "last": "last_name",
  "age": "age_in_years",
})
```

## Change Data Type

`astype()` function: Used to cast a pandas object to a specified dtype (data type). `astype` function does not modify the original DataFrame in place. Instead, it returns a new DataFrame with the specified data type changes.

**Sample Syntax:** `DataFrame.astype(dtype, errors='raise')`

Where:

- **dtype:** Dictionary of column name -> data type.
- **errors:** Controls the raising of exceptions on invalid data for the provided dtype. By default, "raise" is set which means exceptions will be raised.

```
students = students.astype({'grade': int})
```

## Fill Missing Data

`fillna()` function: Used with pandas Series and DataFrame objects to fill NA/NaN values.

**Sample Syntax:** `DataFrame.fillna(value, inplace=True)`

Where:

- **value:** Value to use to fill holes (e.g. 0).
- **inplace:** If True, fills in place (Default is False).

```
products['quantity'].fillna(0, inplace=True)
```

## Concatenate Two DataFrames Having Same Structure

`pd.concat()` function: Used to concatenate DataFrames either vertically (by rows) or horizontally (by columns).

**Sample Syntax:** `pd.concat(objs=[df1, df2], axis=0)`

Where:

- **objs:** A sequence or mapping of Series or DataFrame objects to be concatenated.
- **axis:** Determines the direction of concatenation. **axis=0** is set as the default value, which means it will concatenate DataFrames **vertically (by rows)**. **axis=1** will concatenate DataFrames **horizontally (by columns)**.

```
stacked_df = pd.concat([df1, df2], axis=0)
```

## Pivot (Normalize) Data

`pivot()` function: Used to reshape data based on column values and get a new DataFrame out of it.

**Sample Syntax:** `df.pivot(index, columns, values)`

Where:

- **index:** Determines the rows in the new DataFrame.
- **columns:** Determines the columns in the new DataFrame.
- **values:** Specifies the values to be used when the table is reshaped.

```
ans = weather.pivot(index='month', columns='city', values='temperature')
```

For the above example,

- `index='month'` means the pivoted table will have one row for each unique value in the month column.
- `columns='city'` means the pivoted table will have one column for each unique value in the city column.
- `values='temperature'` means the pivoted table will use the temperature column as the new data.

## Melt (Denormalize) Data

`melt()` function: Used to transform or reshape data. It changes the DataFrame from a wide format, where columns represent multiple variables, to a long format, where each row represents a unique variable.

**Sample Syntax:** `df.melt(id_vars, value_vars, var_name, value_name)`

Where:

- **id_vars:** Specifies the columns that should remain unchanged.
- **value_vars:** Specifies the columns that we want to "melt" or reshape into rows.
- **var_name:** name of the new column that will store the header names from the value_vars.
- **value_name:** name of the new column that will store the values from the value_vars.

```
report = report.melt(
  id_vars=["product"],
  value_vars=["quarter_1", "quarter_2", "quarter_3", "quarter_4"],
  var_name="quarter",
  value_name="sales",
)
```

For the above example,

- `id_vars=['product']` keeps the product column intact.
- `value_vars=['quarter_1', 'quarter_2', 'quarter_3', 'quarter_4']` means we're taking the data from these columns and reshaping it into two new columns.
- `var_name='quarter'` will create a new column named quarter, and each entry in this column will be the column name from where the sales data was taken (e.g., quarter_1, quarter_2, etc.).
- `value_name='sales'` will create a new column named sales, which will store the actual sales values.

## Join DataFrames

`pd.merge` is a powerful function in Pandas for combining DataFrames based on shared columns or indexes, similar to joins in SQL.

**Syntax:** `merged_df = pd.merge(left_df, right_df, how='inner', on='common_column')`

Where:

- **how:** The type of merge to perform (default is 'inner'). Other options include: `left`, `right`, `outer`.
- **on:** Column or index names to join on. Must be present in both DataFrames.

**Example:** `result_df = pd.merge(employee, bonus, on='empId', how='left')`

##
