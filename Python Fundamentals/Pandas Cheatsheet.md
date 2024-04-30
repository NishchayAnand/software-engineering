# Pandas Cheatsheet

Pandas is an open-source, python-based library used in **data manipulation** applications requiring high performance. It is useful in performing 5 major steps of data analysis:

- Load the data,
- Clean/manipulate it,
- prepare it,
- model it, and
- analyze the data.

---

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
