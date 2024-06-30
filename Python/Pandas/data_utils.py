import pandas as pd
import numpy as np

def relation(headers, data):
    data = np.transpose(data)
    rel = pd.DataFrame(data, columns=headers)
    return rel