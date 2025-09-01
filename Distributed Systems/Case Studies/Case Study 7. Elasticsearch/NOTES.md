
- Elasticsearch is **not ideal for highly dynamic inventory** (rooms left, prices) because:
    
    - Updates happen **very frequently** (every booking/cancellation).
        
    - Elasticsearch is optimized for **read-heavy workloads**, not rapid writes.
        
- If you keep pushing real-time room availability into ES, you risk **indexing lag** or **stale results**.