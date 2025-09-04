import os
from datetime import datetime, timedelta
from typing import Optional
from dotenv import load_dotenv

load_dotenv()

def getenv_str(name: str, default: Optional[str]=None) -> Optional[str]:
    v = os.getenv(name)
    return v if v not in (None, "") else default

def around_date_window(date: datetime, days: int = 2):
    start = (date - timedelta(days=days)).strftime("%Y-%m-%d")
    end = (date + timedelta(days=days)).strftime("%Y-%m-%d")
    return start, end
