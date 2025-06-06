data warehouse architecture and the four layers of source, staging, storage, and presentation common to many data warehouses.

---
## 1. Layer overview - data source

The first layer contains the data sources for the data warehouse.

The data source layer includes all of the different sources for the data warehouse. Data sources can include different data types, such as files and databases. Recall that this will also include transactional databases, which record the various transactions that happen in an organisation, such as the sale of an item to a customer or the hiring of a new employee.

---
## 2. Layer overview - data staging

Then, the data is extracted, transformed, and loaded through an ETL process. During this process, the ETL process stages data or temporarily places it in tables so it is ready to be used in later steps of the process.

In the data staging layer, the source systems' data is extracted, transformed, and cleaned before being loaded into the next layer. The staging layer includes the ETL process and a staging database that stores data temporarily during this step.

ETL, again, stands for extract, transform, and load. First, the process extracts the data from the source systems. Then transforms it by applying business rules, which clean the data and may include mathematical operations such as averaging different rows together. It uses staging tables here to store the results between the various transformations temporarily. The data in the source layer can have many different formats, even unstructured. Regardless of the format, to be valid input to the warehouse, the ETL system must be able to extract data that can be placed in rows and columns. An example is extracting the email address from an unstructured document like an email. The staging layer outputs data that is ready to be stored. The data can be loaded to the next layer in batches or all at once.

---
### 4. Layer overview - data storage

The next layer is data storage. Here the data is stored in the data warehouse. The data storage layer also includes any data marts used.

In the data storage layer, data pipelines store the staging results in the data warehouse and data marts. Depending on the design, data from the ETL process will be stored directly in the data warehouse and then into the data marts. In other designs, the opposite happens where data moves to the data marts first and then to the data warehouse.

---
### 5. Layer overview - data presentation

Finally, the information is made available to the end user in the data presentation layer. Business intelligence or other analysis tools connect to the warehouse and allow the end user to interact with the data.

In the presentation layer, users interact with the stored data. Queries are run in this layer to facilitate analysis. This layer includes BI or Business Intelligence tools, data mining tools, and direct user queries, some of which have graphical user interfaces to visualise query results. We will discuss this layer more in the next video.

---
