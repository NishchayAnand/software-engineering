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

- Each row has a unique index (often used as row labels), and each column has a name. This allows you to access and manipulate data by labels or positions.

- Can hold columns of different data types (e.g. integers, strings, floats).
