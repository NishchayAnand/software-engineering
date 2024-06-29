# Understanding DataFrame in Pandas

A DataFrame is a two-dimensional, size-mutable, labeled data structure with columns and rows. It's designed to handle tabular data similar to spreadsheets or SQL tables, making it a powerful tool for data analysis and manipulation in Python.

Here's a sample code to create a DataFrame.

```
import pandas as pd

data = {'Name': ['Alice', 'Bob', 'Charlie'], 'Age': [25, 30, 22]}
df = pd.DataFrame(data)
print(df)
```

## Key characteristics:

1. Each row has a unique index (often used as row labels), and each column has a name. This allows you to access and manipulate data by labels or positions.

2. Can hold columns of different data types (e.g. integers, strings, floats).

## Key Parameters:

- `columns`:

## Key Attributes:

An attribute refers to a property or characteristic of an object that helps describe the object's state or its meta-information.

- `shape`: Returns the dimensions of the DataFrame or Series in the form of a tuple (rows, columns).

- `loc`: One of the primary ways to select data from a DataFrame. It is label-based, which means you have to specify the name of the rows or columns to select data.

## Key Methods:

- `head`: Returns the first n rows. If n is omitted, it defaults to returning the first 5 rows.
