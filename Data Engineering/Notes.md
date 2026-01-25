# Undertanding DBMS

Scaling databases gets a lot easier once you learn these 10 techniques:  
  
1. 𝐈𝐧𝐝𝐞𝐱𝐢𝐧𝐠: Speed up read queries by creating indexes on frequently accessed columns.  
  
2. 𝐕𝐞𝐫𝐭𝐢𝐜𝐚𝐥 𝐒𝐜𝐚𝐥𝐢𝐧𝐠: Add more CPU, RAM, or storage to the database server to handle higher workloads.  
  
3. 𝐂𝐚𝐜𝐡𝐢𝐧𝐠: Use in-memory stores like Redis to serve hot data faster and reduce DB load.  
  
4. 𝐒𝐡𝐚𝐫𝐝𝐢𝐧𝐠: Split the database into smaller, independent shards and distribute them across servers for horizontal scaling.  
  
5. 𝐑𝐞𝐩𝐥𝐢𝐜𝐚𝐭𝐢𝐨𝐧: Create multiple copies (replicas) of the database across different servers to balance read traffic and improve availability.  
  
6. 𝐐𝐮𝐞𝐫𝐲 𝐎𝐩𝐭𝐢𝐦𝐢𝐳𝐚𝐭𝐢𝐨𝐧: Fine-tune SQL queries, eliminate expensive operations, and leverage indexes effectively to improve execution speed.  
  
7. 𝐂𝐨𝐧𝐧𝐞𝐜𝐭𝐢𝐨𝐧 𝐏𝐨𝐨𝐥𝐢𝐧𝐠: Reduce the overhead of opening/closing database connections by reusing existing ones.  
  
8. 𝐕𝐞𝐫𝐭𝐢𝐜𝐚𝐥 𝐏𝐚𝐫𝐭𝐢𝐭𝐢𝐨𝐧𝐢𝐧𝐠: Split large tables into smaller, more manageable partitions, each containing a subset of the columns from the original table.  
  
9. 𝐃𝐞𝐧𝐨𝐫𝐦𝐚𝐥𝐢𝐳𝐚𝐭𝐢𝐨𝐧: Store data in a redundant but structured format to minimize complex joins and speed up read-heavy workloads.  
  
10. 𝐌𝐚𝐭𝐞𝐫𝐢𝐚𝐥𝐢𝐳𝐞𝐝 𝐕𝐢𝐞𝐰𝐬: Pre-compute and store results of complex queries as separate tables to avoid expensive recalculation.


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
