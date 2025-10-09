
With the ETL process, the data is transformed as it moves from the inputs to the warehouse. This process requires organisations to use a cloud-based service or purchase the software and computer servers to run it themselves. <span style="color: green; font-weight: bold;">Overall the ETL process requires a separate system from the data warehouse to perform the transformations as the data moves.</span>

A couple of pros of using an ETL process come about because the process only delivers cleaned and transformed data to the warehouse. 

- First, ETL tends to have lower data storage costs than ELT because it only keeps copies of the transformed data. 
- Secondly, meeting compliance security standards on PII or personally identifiable information is more manageable. We can omit PII data in the source systems before loading it into the warehouse, so sensitive data will never make it into our data warehouse, and many ETL tools are certified to meet government PII security standards.

However, there are a couple of cons to using an ETL process:

- First, we do not store the original data from the input sources during the transformation process. Therefore, any errors or changes to the transformation logic mean pulling the data from the source systems again. It can be challenging to find the time to pull large batches of data from the systems without slowing them down. 
- Additionally, there are costs related to the ETL's separate computer system.