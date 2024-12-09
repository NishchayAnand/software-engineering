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

---

Any groupby process involves the combination of the following 3 steps:

1. **Splitting the Original Object into Groups**:

2. Applying a function to each group:
3. Combining the results: 