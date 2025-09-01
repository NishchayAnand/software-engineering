import requests
from typing import List, Dict

def fetch_news_newsapi(query: str, start_date: str, end_date: str, api_key: str, page_size: int = 10) -> List[Dict]:
    if not api_key:
        return []
    url = "https://newsapi.org/v2/everything"
    params = {
        "q": query,
        "from": start_date,
        "to": end_date,
        "sortBy": "relevancy",
        "language": "en",
        "pageSize": page_size,
    }
    headers = {"X-Api-Key": api_key}
    r = requests.get(url, params=params, headers=headers, timeout=15)
    if r.status_code != 200:
        return []
    data = r.json()
    articles = data.get("articles", [])
    return [{
        "title": a.get("title"),
        "source": (a.get("source") or {}).get("name"),
        "publishedAt": a.get("publishedAt"),
        "url": a.get("url"),
        "description": a.get("description"),
    } for a in articles]
