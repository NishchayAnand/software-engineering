# Unique ID Generator 

Design a unique ID generator in distributed systems. 

## Traditional Databases

Use primary key with auto-increment feature. However, auto_increment does not work in a distributed environment.

---
## Requirements

Contains only certain numeric values.

The ids should fit into 64 bit. 

Should generate 10,000 ids per second. 

Generated Ids should be ordered by date. 



