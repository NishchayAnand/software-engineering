
Q. What is **Amazon IAM**?

**Amazon Identity and Access Management (IAM)** is an **AWS** service that allows you to **manage access to AWS resources for users, groups, and applications**.

At the core, it's a **distributed system** that involves multiple components working together to handle **authentication**, **authorization** and **policy evaluation** services.

---

Q. Explain the low-level workflow of an IAM authorization requests.

1. **User/API Initiates a Request:** The request is signed using **AWS signature version 4**. This signature is included in the request for validation by AWS. 

2. **Authentication**: The request reaches the authentication subsystem which validates credentials against stored values. 

3. **Policy Evaluation**: IAM retrieves all policies associated with the user, group, or role.

4. **Authorization**: The policy engine evaluates the request and returns **Allow** or **Deny**. If denied, a details error (e.g., missing permissions) is returned. 

5. **Action**: If allowed, the request proceeds to the AWS service for execution.

> **NOTE:** All API calls, authentication requests and policy changes are logged in Amazon CloudTrail for auditing and monitoring.

---

Q. What is **Amazon CloudWatch**?

**Amazon CloudWatch** is a **monitoring and observability service** that can provide insights into the performance, operational health, and resource utilisation of your systems in real time.

At the core, it's a distributed system that involves multiple components working together to monitor, collect, store, analyse, and visualise metrics, logs, and events from AWS resources, applications and on-premises servers. 

> NOTE: AWS services (e.g., EC2, RDS, Lambda) automatically emits metrics and logs to CloudWatch. 

---

Q. What is **AWS CloudWatch Logs Insights**?

**AWS CloudWatch Logs Insights** allows us to query logs streamed from AWS resources, applications, or on-premises servers for troubleshooting and analysis.

---

Q. What is **Amazon SNS**?

**Simple Notification Service (SNS)** is a **messaging service** that enables **publish/subscribe messaging** for distributed systems. 

---

Q. What is **AWS CLI**?

The **AWS Command Line Interface (AWS CLI)** is an open source tool that enables you to start running commands that implement functionality equivalent to that provided by the browser-based AWS Management Console from the command prompt in your terminal program.

---

Q. What is **Amazon EC2**?

**Amazon Elastic Compute Cloud (EC2)** is a web service that allows users to run virtual servers, called instances, in the cloud. It is highly scalable, flexible, and enables you to deploy applications quickly without the need to invest in physical hardware.

---

Q. What is **Amazon Elastic Beanstalk**?

**Amazon Elastic Beanstalk** is a service for deploying and scaling web applications and services. 

You simply upload your application, and Elastic Beanstalk automatically handles the details of capacity provisioning (creating and configuring the AWS resources needed to run your code), load balancing, scaling, and application health monitoring.

**Advantage**: We don't need to worry about availability, scalability and monitoring. 

**Disadvantages**: Ideal for working with a monolithic application. Doesn't work quite well with microservices architecture.

> NOTE: There is no additional charge for Elastic Beanstalk. You pay only for the underlying AWS resources that your application consumes.

---

Q. What is **Amazon ECR**?

Amazon Elastic Container Registry (ECR) is an AWS managed container image registry service.

---

Q. What is **Amazon ECS**?

Amazon ECS (Elastic Container Service) is a fully managed container orchestration service that automatically schedules and manages containers across a cluster of EC2 instances. 

---

Q. What is **Amazon EKS**?

Amazon Elastic Kubernetes Service (Amazon EKS) is a fully managed Kubernetes service that enables you to run Kubernetes seamlessly in both AWS Cloud and on-premises data centers. 

---

Q. What is **AWS Fargate**?

AWS Fargate is a technology that you can use with Amazon ECS to run containers without having to manage servers or clusters of Amazon EC2 instances. 

---

Q. What is **AWS Lambda**?

AWS Lambda is a serverless compute service that lets you run code without provisioning or managing servers. 

> NOTE: Any applications with variable traffic or that can scale to zero are great candidates for AWS Lambda. 

---

Q. What is **Amazon EBS)**?

**Amazon Elastic Block Store (EBS)** Used to create an Harddisk.

---

Q. What is **Amazon Elastic File Store (EFS)**?

---

Q. What is **Amazon S3**? 

 Simple Storage Service is a block storage service
 
---

Q. What is **RDS**?

Amazon Relational Database Service (Amazon RDS) is a web service that makes it easier to set up, operate, and scale a relational database in the AWS Cloud.

---

Q. What is **Amazon Aurora?**

Amazon Aurora is a relational database management system (RDBMS) offered as part of Amazon Relational Database Service (RDS). It provides performance and availability of commercial-grade databases at one-tenth the cost.

> NOTE: Aurora can deliver up to five times the throughput of MySQL and up to three times the throughput of PostgreSQL without requiring changes to most of your existing applications.

---

Q. What is **Amazon CloudFront**?

CDN

---

Q. What is **Amazon API Gateway**?

---

Q. What is **ELB**?

**Amazon Elastic Load Balancer (ELB)** 

---

Q. What is **Amazon SQS**?

---

Q. What is **Amazon CodeDeploy**?

---

Q. What is Amazon CDK?

**Cloud Development Kit (CDK)**

---

Q. What is **Amazon Pay**?

---

Q. What is **AWS Certificate Manager**?

---







