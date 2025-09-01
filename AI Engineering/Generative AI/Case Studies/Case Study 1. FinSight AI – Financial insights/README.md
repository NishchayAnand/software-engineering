
FinSight AI detects significant price dips in a stock time series and explains *why* they may have happened by retrieving news around each dip and summarizing with an LLM.

---
### Features

- Pulls historical prices for any ticker (via `yfinance`).
- Detects dips using a % change threshold or rolling-band logic.
- Fetches news near the dip date (NewsAPI, optional).
- Generates Gen-AI explanations (OpenAI **optional**—can use any LLM provider).
- Streamlit UI with chart + annotated dips + expandable context.
- Exports a JSON report of dips and explanations.
