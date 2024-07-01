import pandas as pd
import numpy as np
import os
from io import BytesIO

def relation(*args, col_types=None):

    if (len(args)==1 and 
        isinstance(args[0], dict) and 
        col_types is None):
        # First Definition: relation(dict)
        return pd.DataFrame(args[0])
    
    elif (len(args)==1 and 
          isinstance(args[0], dict) and 
          isinstance(col_types, list)):
        # Second Definition: relation(dict, col_types)
        return pd.DataFrame(args[0]).astype(col_types)
    
    elif (len(args)==2 and 
          isinstance(args[0], list) and 
          isinstance(args[1], list) and 
          all(isinstance(elem, list) for elem in args[1]) and 
          col_types is None):
        # Third Definition: relation(col_names, Col_data)
        return pd.DataFrame(np.transpose(args[1]), columns=args[0])
    
    elif (len(args)==2 and 
          isinstance(args[0], list) and 
          isinstance(args[1], list) and 
          all(isinstance(elem, list) for elem in args[1]) and
          isinstance(col_types, list)):
        # Fourth Definition: relation(col_name, col_data, col_types)
        return pd.DataFrame(np.transpose(args[1]), columns=args[0]).astype(col_types)
    
    else:
        raise ValueError("Invalid arguments.")
    
def xlread(file_name, **kwargs):

    if not kwargs:
        # First Definition: xlread('example.xlsx')
        return pd.read_excel(file_name)
    
    elif 'sheet_name' in kwargs:
            # Second Definition: 1. xlread('example.com', sheet_name='sheet1')
            #                    2. xlread('example.com', sheet_name=['sheet1', 'sheet2'])
            return pd.read_excel(file_name, sheet_name=kwargs.sheet_name)

def xlwrite(df, file_name=None):

    if file_name is None:

        # Step 1: Create a BytesIO buffer object to hold the Excel file data in memory temporarily.
        buffer = BytesIO()

        # Step 2: Write DataFrame to the buffer
        df.to_excel(buffer, index=False)

        # Step 3: Open a temporary Excel file in write binary mode and write the buffer content to it. 
        with open('book.xlsx', 'wb') as f:
            f.write(buffer.getvalue())

        # Step 4: Open the temporary file with the default application associated with Excel files on your system.
        os.startfile('book.xlsx')

    else:
        df.to_excel(file_name, index=False)

