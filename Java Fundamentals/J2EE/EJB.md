# Understanding Enterprise JavaBeans (EJBs)

Many of the low-level APIs (e.g. JDBC, JTA, JAAS) essential for building robust enterprise applications are not ideal end-user APIs. Using them correctly requires a lot of boilerplate code and substantial developer efforts.

EJB specification aimed to address this challenge by providing a higher-level, component-based model for building enterprise applications. EJBs abstract away many of the complexities associated with low-level APIs, allowing developers to focus more on business logic and less on infrastructure concerns.

> **Business Logic:** The set of business-specific rules that help identify the structure and behavior of the business objects, along with the pre and post conditions that must be met when an object exposes its behavior to other objects in the system.

It offers 3 kinds of components: `Session Beans`, `Entity Beans`, and `Message-Driven Beans`, each providing specific functionalities catering to common enterprise needs.

## Session Beans

Session beans are a type of EJB component specifically designed to handle client-specific business logic within enterprise applications.

## Entity Beans

## Message-Driven Beans
