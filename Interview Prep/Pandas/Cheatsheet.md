# Pandas Cheatsheet

### SELF JOIN on Employee DataFrame using MERGE() to link managerId with manager name

```
merged = pd.merge(employee, 
                  employee, 
                  how='left',
                  left_on='managerId', 
                  right_on='id', 
                  suffixes=('_employee', '_manager'))
```