# Undertanding DBMS

2 use cases **(access patterns)** of DBMS: `Online Transaction Processing` and `Online Analytic Processing`

## Online Transaction Processing

Records are inserted or updated based on the user’s input.

- **Main read pattern**: Small number of records per query, fetched by key.
- **Main write pattern**: Random-access, low-latency writes from user input.
- **Primarily used by**: End user/customer, via web application.
- **What data represents**: Latest state of data (current point in time).
- **Dataset size**: Gigabytes to terabytes.

## Online Analytic Processing

An analytic query needs to scan over a huge number of records, only reading a few columns per record, and calculates aggregate statistics (such as count, sum, or average) rather than returning the raw data to the user.

- **Main read pattern**: Aggregate over large number of records.
- **Main write pattern**: Bulk import (ETL) or event stream.
- **Primarily used by**: Internal analyst, for decision support.
- **What data represents**: History of events that happened over time.
- **Dataset size**: Terabytes to petabytes.
