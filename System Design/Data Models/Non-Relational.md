# Understanding Non-Relational Databases

Non-Relational databases are also called `NoSQL` databases (e.g. `Cassandra`, `Amazon Dynamo DB`). They might be the right choice if your requirement involves:

## Super-Low Latency

**Your application requires super-low lacency.** Can be easily scaled. `Why??`

## Unstructured Data

**Your data is unstructured,** or you do not have any relational data. You only need to serialize and deserialize data (e.g. JSON, XML, YAML).

## Large Dataset

You need to store a massive amount of data.

Transaction management mechanisms are employed by **SQL databases** to maintain data integrity and database consistency. Managing simultaneous transactions across multiple nodes in a distributed database environment would likely create additional complexity and resource usage which could impact both data integrity and possibly overall database performance. If horizontal scaling were to be utilized, these issues would be a possibility.

## Defining Relationships: Embedding Documents

**One-to-one and one-to-many relationships**: This involves directly including related data within a single document.
