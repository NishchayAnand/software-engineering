
The ELT process extracts data from the sources and loads full copies of that data into the data warehouse. Then the resources and software of the data warehouse are used to transform the data. Afterward, the transformed data is then used as usual for the data warehouse. 

Some pros of the ELT process are:

- No need for a separate computer system for the transformation process. 
- Additionally, we can rerun the transformation process without impacting the source systems. 
- Finally, it is often used for near real-time situations because the amount of time needed to load the data is not connected to the complexity of the transformations in the ELT process. 

However, cons include the need for more storage to hold the copies of the original data. Also, additional considerations are needed to comply with the security standards if the data sources contain PII data.

The ELT process works well for near real-time data processing requirements because complex data transformations do not slow down the data movement process.

<span style="color:green;font-weight:bold;">Example</span>

You work for an electrical utility, and many of your customers have smart meters that send near real-time updates of power consumption. You are looking to implement a data warehouse to collect this data to analyse customer demand and enrich it or add information about current weather conditions and electrical plant operations. 

You are still determining the transformation integration steps, which may need to be updated. Finally, the organisation wants to use a cloud service to help process a large amount of data. Considering all these factors, you decide to use an **ELT** process for the data warehouse.