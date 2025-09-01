def format_headlines(headlines):
    if not headlines:
        return "- No headlines fetched."
    return "\n".join([f"- {h.get('title')} ({h.get('source')})" for h in headlines[:5]])

def explain_with_fallback(ticker, date, drop_pct, price_before, price_after, headlines):
    return f"""
On {date}, {ticker} dropped {drop_pct:.2f}% (from {price_before:.2f} to {price_after:.2f}).
Possible reasons include:
- Company-specific events
- Sector trends
- Market-wide movements

Headlines:
{format_headlines(headlines)}
"""
