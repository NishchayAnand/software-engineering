# Understanding Snowflake

Snowflake enables data storage, processing, and analytic solutions that are faster, easier to use, and far more flexible than traditional offerings. Snowflake combines a completely new SQL query engine with an innovative architecture natively designed for the cloud.

Snowflake’s architecture is a hybrid of traditional **shared-disk** and **shared-nothing** database architectures. Similar to shared-disk architectures, Snowflake uses a central data repository for persisted data that is accessible from all compute nodes in the platform. But similar to shared-nothing architectures, Snowflake processes queries using **MPP (massively parallel processing) compute clusters** where each node in the cluster stores a portion of the entire data set locally.

Snowflake’s unique architecture consists of three key layers:

## Database Storage

**When data is loaded into Snowflake, it re-organizes that data into its _internal optimized_, _compressed_, and _columnar format_ and store it in cloud storage.**

Many databases are using different methods such as **compression** to increase the speed and efficiency to retrieve and store data. One of the methods of compression is called `GZIP` (even used by Snowflake). The process has been known to shrink files by a large percentage (in some cases even greater than 90%), resulting in faster access to information (given that the retrieval process could read smaller files).

> NOTE: `GZIP` is a compression file format and software used by many companies to store their data.

Another process databases are using to increase speed and efficiency to retrieve and store data is using a **columnar format** (as opposed to row format). A row format is the way we usually read data, i.e., from left to right, one row at a time. In this method, all rows and fields are read to return results. In a columnar based format, the data is stored by columns, and we can assume that every column is stored as an independent file, and an ID is created for each one of the values within each file. We can use same IDs to only retrieve the data needed from the other fields (columns), instead of grabbing all the data and then filtering afterwards.

**Given that we naturally read data in a row format, Snowflake stores and represents data using tables and views organized into schemas.**

Snowflake allows the loading of structured and semi-structured data. Structured data is a representation of rows and columns. Semi-structured data is not originally structured or represented in rows and columns. However, Snowflake is able to transform the semi-structured data into relational databases. Different semi-structured file formats supported by Snowflake includes: `JSON`, `Parquet`, `XML`, etc.

> NOTE: SQL, or Structured Query Language is the way that we interact with any of the tables in Snowflake. This is regardless of files, whether structured or semi-structured data.

## Query Processing

The **query processing layer** is also known as the **compute layer**. The compute layer is the processing layer of information and data. Snowflake uses **virtual warehouses** to access storage files and execute queries. A virual warehouse is one or more clusters of compute resources used to process data or perform other operations.

> NOTE: Each virtual warehouse is an independent compute cluster that does not share compute resources with other virtual warehouses.

Snoflake uses data warehouses for data loading and analysis. Some companies use multiple data warehouses to separate the process of loading data and analyzing data or for development and production environments. By using this architecture, the process are separated and are not competing for any resources to perform simultaneous operations.

There are many sizes of virtual warehouses: `X-Small`, `Small`, `Medium`, `Large`, `X-Large`, and so on. The size of the virtual warehouse determines the number of serves on each cluster in the warehouse. Going from one size of the virtual warehouse to the next doubles the number of servers available in the selected virtual warehouse.

Virtual warehouses can be created and managed either by the web interface or via SQL. Virtual warehouses can add or auto-suspend, as well as auto-resume. **Auto-suspend** can be set up based on the time after inactivity and **auto-resume** starts when a request is made to the virtual warehouse.

When a request is sent to a virtual warehouse for either loading or retrieving data for analysis, the warehouse starts using the available resources given its computing power. If the requests are greater than what the virtual warehouse can handle, a queue is created for all new requests and they are processed in the order that those requests were received.

Within Snowflake, there are two ways to scale up or down compute resources. One of the ways is by choosing the size of the virtual warehouse. Another way that is available to the enterprise edition is by using **multi-cluster warehousing**. In this option, when the volume of the requests or load increases, the virtual warehouse will start using additional cluster of servers to auto-manage the load.

Given that data is stored in selected service cloud providers, `Google Cloud Provider`, `Amazon Web Services` or `Microsoft Azure`, the data storage can be assessed by one or more virtual warehouses. The warehouses share the same data storage, and as soon as one object or data is updated, the data is updated to all of the virtual warehouses.

## Cloud Services

The **services layer** coordinates and manages the entire system. It **authenticate users**, **manages sessions**, **secures data**, and **performs query compilation and optimization**. The services layer also manages virtual warehouses, coordinates their storage, updates, and access, ensuring that once a transaction is complete, all of the virtual warehouses see the latest version of the data with no impact on availability or performance.

A key component of the services layer is the **metadata store**, which powers a number of unique features of Snowflake including **zero-copy cloning**, **time travel**, and **data sharing**.

### Zero-copy Cloning

Some companies create a copy of the production databases into development databases to perform development tasks in order to later validate and push changes to the production environment. Given that storage is one of the costs of using Snowflake, if a prodcution table or schema is duplicated, there will be a cost to pay for the storage of both environments, making this a costly process.

Snowflake has a different approach. Instead of duplicating production environments, Snowflake creates what is called **zero-copy cloning**. Zero-copy cloning does not duplicate data or tables. It retains the same connection to the production environment, and as development tasks are created and processed such as updating and creating new records, it stores that additional information or records within the zero-copy cloning environment. Those changes are not pushed to the production environment, however after testing, the changes from the zero-copy cloning data can be easily pushed to production. This approach reduces cost, as no copy was creared from the production tables and the only cost incurred is the one from the records or updated records produced by the zero-copy cloning process.

### Time Travel

We all know that mistakes happen and that some of those mistakes can be the deletion of records from a table or even dropping an entire table, etc. Many traditional databases do not have recovery options as a default. For companies that do not have a recovery plan, the process of doing a full backup can be consuming and costly.

Snowflake uses **time travel**. Time travel is having the ability to query data from the past as well as to restore data to a specific period of time.

Snowflake does not make an entire copy of the tables in time travel, but only what is needed to restore data to a specific date or time.

### Data Sharing

Data sharing is the process of making data available to other companies or organizations. This process does not duplicate data and does not use traditional process where people have to receive data and store it in their own databases.

## Workflow of Snowflake

1. Once a user is authenicated to access Snowflake and a virtual warehouse is selected to perform the operations, a query can be submitted to retrieve data.
2. When a query is submitted, the services layer checks for permissions and access of the user, and once those are validated, it creates an optimized data plan and gather the information requested from the query and sends the execution plan to the virtual warehouse, which then the virtual warehoue allocates resources to perform the operations an sends the requests to the storage layer to get the needed data.
3. Once the data is retrieved and processed, it is then sent back to the user.

## EXTRA

Snowflake is not a transactional database. It is not designed for transactional system with lots of updates and inserts with small amount of data.

If your application is analytical application, you could use Snowflake for the analytical part.
