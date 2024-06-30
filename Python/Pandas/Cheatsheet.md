# Pandas Cheatsheet

## Create a DataFrame

### From a dictionary

```
my_dict = {"Name": ["Nishchay", "Vridhi", "Archie"], "Age": [26, 19, 1]}
df = pd.DataFrame(my_dict)
```

### From a 2D list

```
student_data = [
  [1, 15],
  [2, 11],
  [3, 11],
  [4, 20]
]
df = pd.DataFrame(student_data)
```

## Set Custom Column Names (columns)

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

`shape`: Returns the dimensions of the DataFrame or Series in the form of a tuple (rows, columns). **Sample Syntax:** `df.shape`.

```
print(df.shape)
```

## Display First 3 Rows

`head`: Returns the first n rows. If n is omitted, it defaults to returning the first 5 rows. **Sample Syntax:** `df.head(n)`.

```
#print(df.head(3))
```

## Select Data

`loc`: One of the primary ways to select data from a DataFrame. It is label-based, which means you have to specify the name of the rows or columns to select data. **Sample Syntax:** `filtered_df = df.loc[df["Age"]>20]`.

```
filtered_df = df.loc[df["Age"]>20]
print(filtered_df)
```

## Create a New Column

```
employees["bonus"] = employees["salary]*2
```

## Drop Duplicate Rows

`drop_duplicates`: Its purpose is to drop duplicate rows. You can specify the criteria based on which the rows are considered duplicates.

**Sample Syntax:** `customers.drop_duplicates(subset='email', keep='first', inplace=True)`

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

`dropna`: Used to remove missing values. **Sample Syntax:** `DataFrame.dropna(axis=0, subset=None, inplace=False)`

- **axis:** If axis=0 (default), it drops rows which contain missing values, and if axis=1, it drops columns which contain missing value.
- **subset:** Labels along the other axis to consider. For example, if you are dropping rows, these would be a list of columns to include. This is particularly useful when you only want to consider NA values in certain columns.
- **inplace:** A boolean which makes the changes in dataframe itself if True.

## Rename a Column

`rename`
