
Data modeling refers to how we organise data in a database into tables and how to relate those tables if we want to join them.

When it comes to data modeling, the **star** and **snowflake** schemas are two common approaches for a warehouse using the **bottom-up Kimball approach**.

> **NOTE:** Schema means to plan or model.

**Star** and **Snowflake** schemas are models for organising our data. These data models denormalise organisational data into **dimensions** and **fact tables**.

---
### Fact Table

A fact table consists of <span style="color:green;font-weight:bold;">measurements</span> or metrics about an organisational process. These are known as facts. Each row within the table captures a measurement or metric about one process transaction.

<span style="color:green;font-weight:bold;">Example</span>

A fact table used within the **Apple music service** to track **artist albums** might include columns like ArtistID, GenreID, SongLength, and UnitPrice.

Fact tables contain measurements and metrics, which this table has in **song length**, and **unit price**. In addition, the **artist** and **genre ids** can be used to **join dimensional tables to provide more details about the song length or unit prices.**

---
### Dimension Table

Dimension tables contain attributes and <span style="color:green;font-weight:bold;">characteristics</span> that describe the data in the fact table. These characteristics are called dimensions.

---
### Star Schema

A star schema is an organisational structure that uses a single fact table and one or more dimensional tables. The central table, surrounded by dimensional tables, somewhat resembles a star. 

The relatively few joins needed for a star schema make queries fast and easy to use by organisational users.

---
### Snowflake Schema

A snowflake schema is similar to a star schema. However, <span style="color:green;font-weight:bold">at least one of the dimensional tables does not directly join the fact table and must be joined through another dimensional table.</span>

---
### Steps to Design Data Model

**Step 1 - Select the organisational process**

Select an organisational process for which we want to create a data model, such as invoice and billing, product quality monitoring, and marketing.

**Step 2 - Declare the grain**

The grain here means the level of data stored in the fact table. It's not required, but it advised that it is the lowest level possible. Essentially, a level where you cannot split the data any further. 

For example, if we were building a warehouse for a music service, we should choose the grain level to be individual songs versus a full album from a band. If we were tracking shipping data, we should store the individual line items on a shipment versus the overall shipment. This will allow organisational users to analyse the data to ask questions like `Which song is the most popular?` or `Which products were delayed the most in shipping?`. 

> **NOTE:** Organisational users may be unable to answer the questions they have if we choose the wrong grain here, making the info and data warehouse less valuable or useless to them in extreme circumstances.

**Step 3 - Identify the dimensions**

Choose the dimensions that apply to each fact table row. Overall, we want to add a rich set of dimensions representing as many characteristics as possible of the fact table data. 

A data model may have a unique set of dimensions, but there are some that are typically used. For example, tracking the year, month, and the quarter is typical for any process that involves time. Likewise, tracking the address, state, and country is common for any process involving location. Also, it is standard to include the dimensions of name and email address for any process involving users. 

Answering the question, `How do organisational users describe the data that results from the business process?` helps in this step. Also, <span style="color:red;">it would be valuable for us to have feedback from analysts and other users who often work with the data.</span>

**Step 4 - Identify the facts**

Identify the numeric facts that will populate each fact table row. 

Examples of possible facts for a fact table for a **music service** include the **total number of plays** or **sales revenue for a song**. However, if we were creating a fact table for a **ride-sharing service**, examples of possible facts are the **distance traveled** or **the time needed**. These facts capture a measurement or metric of the process. 

Having members of the organisation answer the question `What are we answering?` will help us identify numerical facts to include. 

> **NOTE:** Recall the purpose of the data warehouse is for reporting and analysis of the organisational process. We will need to decide on the vital numerical measures to store to answer likely questions about the process later.

---









