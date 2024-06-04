# Understanding Spring JDBC

Spring provided implementations of DataSource interface:

## DriverManagerDataSource

- Provides a basic way to configure a JDBC connection using properties like URL, username, and password.
- It leverages the underlying Java `DriverManager` class to establish connections to the database.
- Unlike more advanced `DataSource` implementations, `DriverManagerDataSource` doesn't manage a pool of connections. It creates a new connection for each request, which can be inefficient, especially in high-traffic applications.

> **NOTE:** Due to the lack of connection pooling, `DriverManagerDataSource` is generally not recommended for production environments or applications with significant database interaction.
