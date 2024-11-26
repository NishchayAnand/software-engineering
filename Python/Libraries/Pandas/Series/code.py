import pandas as pd

# Create Series from a list
data = [1,2,3,4,5,6]
list_to_series = pd.Series(data)
# print(list_to_series)

# Create Series with labels
labels = ["one", "two", "three", "four", "five", "six"]
series_with_labels = pd.Series(data, index=labels)
print(series_with_labels["six"])

# Multiply each element of a Series by a constant.
print(list_to_series*2)

