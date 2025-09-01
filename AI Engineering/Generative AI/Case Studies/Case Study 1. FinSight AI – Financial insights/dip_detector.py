from dataclasses import dataclass
from typing import List, Optional
import pandas as pd
import numpy as np
import yfinance as yf

@dataclass
class DipEvent:
    date: pd.Timestamp
    drop_pct: float
    price_before: float
    price_after: float

def detect_dips(
    df: pd.DataFrame,
    price_col: str = "Close",
    threshold_pct: float = -5.0,
    min_gap_days: int = 1
) -> List[DipEvent]:
    if price_col not in df.columns:
        raise ValueError(f"price_col '{price_col}' not in DataFrame")
    s = df[price_col].astype(float)
    returns = s.pct_change() * 100.0
    dips_idx = returns[returns <= threshold_pct].index

    events: List[DipEvent] = []
    last_event_date: Optional[pd.Timestamp] = None

    for dt in dips_idx:
        if last_event_date is not None:
            if (dt - last_event_date).days < min_gap_days:
                continue
        prev = df.loc[df.index < dt, price_col].iloc[-1] if (df.index < dt).any() else np.nan
        cur = df.loc[dt, price_col]
        drop_pct = (cur/prev - 1.0) * 100.0
        events.append(DipEvent(date=dt, drop_pct=drop_pct, price_before=float(prev), price_after=float(cur)))
        last_event_date = dt

    return events

if __name__ == "__main__":
    df = yf.download("AAPL", start="2025-08-01", end="2025-08-30")
    events = detect_dips(df)
    print(events)
