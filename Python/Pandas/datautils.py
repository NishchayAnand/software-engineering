import pandas as pd
import numpy as np

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
    

