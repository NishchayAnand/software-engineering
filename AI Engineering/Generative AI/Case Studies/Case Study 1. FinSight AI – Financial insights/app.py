import streamlit as st
import yfinance as yf
import pandas as pd
import matplotlib.pyplot as plt
from utils import getenv_str, around_date_window
from dip_detector import detect_dips
from news_fetcher import fetch_news_newsapi
from llm_explainer import explain_with_fallback

st.set_page_config(page_title="DipSense AI", page_icon="📉")
st.title("📉 DipSense AI — Stock Dip Analyzer")

ticker = st.text_input("Ticker", "AAPL")
start_date = st.date_input("Start date", value=pd.to_datetime("2024-01-01"))
end_date = st.date_input("End date", value=pd.to_datetime("2025-08-30"))
threshold = st.number_input("Dip threshold (%)", value=-5.0)

if st.button("Run Analysis"):
    data = yf.download(ticker, start=str(start_date), end=str(end_date))
    events = detect_dips(data, threshold_pct=threshold)

    fig, ax = plt.subplots()
    ax.plot(data.index, data["Close"])
    for ev in events:
        ax.scatter([ev.date], [ev.price_after], color="red")
        #ax.annotate(f"{ev.drop_pct:.1f}%", (ev.date, ev.price_after))
    st.pyplot(fig)

    for ev in events:
        #st.subheader(f"{ev.date.date()} — {ev.drop_pct:.2f}%")
        headlines = fetch_news_newsapi(ticker, *around_date_window(ev.date.to_pydatetime(), 2), getenv_str("NEWSAPI_KEY",""))
        st.markdown(explain_with_fallback(ticker, str(ev.date.date()), ev.drop_pct, ev.price_before, ev.price_after, headlines))

