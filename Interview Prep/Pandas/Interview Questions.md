# Pandas Interview Questions

Q. Explain `merge` function.

The `merge` function in pandas is used to combine two DataFrames based on one or more common columns or indices. It is similar to SQL joins (like INNER JOIN, LEFT JOIN, etc.). 

Syntax:

```
dataframe.merge(right, how, on, left_on, right_on, ...)

- right   : A DataFrame to merge with (required). 
- how     : Specifies how to merge (optional, defaults to 'inner').
- on      : 
- left_on :
- right_on:
```