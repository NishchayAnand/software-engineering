# Understanding Sharding

Horizontal Scaling, also known as **Sharding**, is the practice of adding more servers.

Sharding separates large databases into smaller, more easily managed parts called **shards**. Each shard shares the same schema, though the actual data on each shard is unique to the shard.

User data is allocated to a database server based on user ID. Anytime you access data, a hash function is used to find the corresponding shard.

The most important factor to consider when implementing a sharding strategy is the choice of the sharding key. **Sharding key (a.k.a partition key)** consists of one or more columns that determine how data is distributed. A Sharding key allows us to retrieve and modify data efficiently by routing database queries to the correct database. When choosing a sharding key, one of the most important criteria is to choose a key that can evenly distribute data.

## Complexities with Sharding

- **Join:** Once a database has been sharded across multiple servers, it is hard to perform join operations across database shards. A common workaround is to de-normalize the database so that queries can be performed in a single table.
