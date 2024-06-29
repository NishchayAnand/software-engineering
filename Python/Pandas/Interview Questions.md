# Pandas Library Interview Questions

**Q. What is a Pandas DataFrame?**

A dataframe is a `2D mutable` and `tabular` structure for representing data labelled with axes - rows and columns.

The syntax for creating a basic dataframe:

```
import pandas as pd
df = pd.DataFrame(data,
                  index -> optional argument for row labels,
                  columns -> optional argument for column labels,
                  dtype -> optional argument to define data type of each column)
```

---

**Q. How can we combine two DataFrames horizontally?**

We can use the \_append() method of
