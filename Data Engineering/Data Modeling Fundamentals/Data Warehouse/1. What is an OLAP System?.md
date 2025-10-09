
OLAP stands for **Online Analytical Processing**. It is a tool for performing multidimensional analysis at high speeds on large volumes of data from a data warehouse, data mart, or some other centralised data store.

<span style="color:red;font-weight:bold;">OLAP systems are designed to support data analysis. Data scientists and analysts typically work with OLAP systems.</span>

At the core of the OLAP system is the OLAP data cube, a multidimensional database that makes it possible to process and analyse multiple data dimensions faster than a traditional relational database.

To provide more context, imagine we are interested in the organisation's sales by **region**, **year**, and **product**. If we picture a cube, the cube's different edges, or **height**, **width**, and **length**, will represent one of these dimensions. 

![olap-data-cube](olap-system-cube.png)


We will have the total sales for those dimensions where these edges intersect. The data cube can drill down or aggregate the total sales by each dimension. In this example, the dimensions are region, year, and product, and total sales is the value that is aggregated or disaggregated based on the selected dimensions. 

> **NOTE:** Data cubes that have more than three dimensions are called hypercubes. 

