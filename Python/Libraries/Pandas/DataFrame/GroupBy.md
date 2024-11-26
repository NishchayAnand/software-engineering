# Understanding GroupBy in Pandas DataFrame

Can be used for performing **aggregations** and **transformations** on data based on one or more columns.

It follows a two-step process:

## Splitting

The DataFrame is divided into groups based on the specified columns. These columns are often referred to as the **grouping key(s)**. Each group contains rows that share the same values for the grouping key(s).

**Syntax:** `groups = df.groupby(['grouping_key_column'])`

## Applying

A function is applied to each group independently. Common functions include: `mean`, `sum`, `count`, `min`, `max`, `filter`, `transform`, `agg` etc.

**Syntax:** `grouped_df = groups.count()`
