from datautils import relation, xlwrite, xlread
import pandas as pd

data = {
    "Name": ["Nishchay", "Vridhi"],
    "Age": [26, 19],
}

rel_dict = relation(data)
#print(rel_dict)

rel = relation(["Name", "Age"], [["Nishchay", "Vridhi"], [26,29]])
#print(rel)

#xlwrite(rel)

#xlwrite(rel, 'example.xlsx')

df = xlread('example.xlsx')
print(df)







