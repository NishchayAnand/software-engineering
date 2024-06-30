import pandas as pd 

# Create a DataFrame from a dictionary.
my_dict = {"Name": ["Nischay", "Vridhi", "Archie"], "Age": [26, 19, 1]}
df = pd.DataFrame(my_dict)
#print(df)

# Create a DataFrame from a 2D list containing the IDs and ages of some students.
student_data = [
  [1, 15],
  [2, 11],
  [3, 11],
  [4, 20]
]
student_df = pd.DataFrame(student_data)
#print(student_df) # the resultant DataFrame will have headers labeled as 0 and 1.

# Set custom column names using columns parameter
column_names = ["student_id", "age"]
student_df_with_column_names = pd.DataFrame(student_data, columns=column_names)
#print(student_df_with_column_names)

# Get dimensions of using shape attribute
#print(student_df_with_column_names.shape)

# Display first 3 rows
#print(student_df_with_column_names.head(3))

# Display students with age > 20
filtered_df = df.loc[df["Age"]>20]
#print(filtered_df)
