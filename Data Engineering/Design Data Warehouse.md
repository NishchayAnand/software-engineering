
At a high level, the first step is the planning phase, where the team begins to plan how to design the data warehouse to satisfy the organisation's needs. Next is the implementation phase, where the team builds the data warehouse. Finally, in the support and maintenance phase, the team trains end users and maintain the warehouse.

---
### 1. Planning - business requirements

In the planning phase, there are different sub-stages. The first is requirements gathering. The goal here is to understand the organisation's needs. Who and how will they use the data warehouse? 

To support this task, meet Christina, a **data analyst**, and Alex, a **Data Scientist**. Christina works closely with others in the business, and her analysis helps with decision-making. Alex's ML models automate decision-making and improve business processes. Christina and Alex are **closer to the business and know their final goals and requirements best**.

---
### 2. Planning - data modelling

Data modelling is next. It is planning based on business requirements on how the team transforms data from different input sources and integrates it into our data warehouse. Crucial is that the team understands and links the relevant data sets. 

To support this stage, meet Stacy and Derrick. Stacy is a **data engineer** and is skilled at creating data pipelines. Derrick is a transactional **database admin**. <span style="color:red;font-weight:bold;">Data engineers and admins plan data pipelines from the database systems to the warehouse.</span> Also, Christina and Alex use their business knowledge to support this stage by helping ensure the data model accurately represents the organisation.

> **NOTE:** Data pipelines are automatic end-to-end processes that collect, modify, and deliver data.

---
### 3. Implementation - ETL Design & Development

Within the implementation phase, the team designs the ETL process. This step is about designing and building the data pipelines that extract, transform, and load data from the different sources into the data warehouse. **Stacy (Data Engineer) is responsible for creating the pipelines, but she coordinates with Derrick (Database Admin) to extract data from the source systems**.

---
### 4. Implementation - BI Application Development

After the team loads the data into the warehouse, they work on BI application development. In this step, they set up BI or business intelligence tools to interact with the data warehouse and create reports needed by the organisation. BI tools are often how many users interact with the data warehouse. Some standard BI tools include Tableau, Power BI, or Google's Looker. At this point, **Christina (Data Analyst)** and **Alex (Data Scientist)** consult on the setup of the BI application.

---
### 5. Support / Maintenance - Maintenance

During the support and maintenance phase, the team can update the warehouse table designs or make other necessary changes. **Stacy (Data Engineer)** makes these changes if required.

---
### 6. Support / Maintenance - Test & Deploy

After this step, we get to testing and deployment. First, **Christina (Data Analyst)** and **Alex (Data Scientist)** test the system to confirm their business requirements are met. Afterward, **Stacy (Data Engineer)** will deploy and make the warehouse available to the organisation. After deployment, any significant changes will follow the same steps starting back at the planning phase.

---
