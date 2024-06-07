# Understanding Spring Framework

Spring Framework is a popular open-source framework for building enterprise applications in Java.

The first version of Spring, released in October 2002, was introduced as a lightweight alternative to J2EE. It provided a simpler and more flexible approach to enterprise Java development.

## Problems with J2EE that Spring solved

The Spring Framework addressed several key issues and limitations associated with J2EE. Here are some of the main problems with J2EE that Spring effectively solved:

### Heavyweight Container

**EJB followed an all-or-nothing approach, where developers must adopt the entire EJB framework rather than selectively choosing components or features. This made the EJB container heavyweight and less flexible.**

Spring introduced a more lightweight and modular ecosystem, splitting each concern into separate sub-frameworks (e.g., `Spring MVC` for web applications, `Spring Data` for data access). Spring's architecture allowed developers to pick and choose the specific services they needed for their application, significantly reducing the overhead and complexity associated with the traditional J2EE container.

### Verbose Deployment Descriptors

**With J2EE, the developers had to learn and manage separate configuration mechanisms for both web and EJB components.**

Spring took a different approach by promoting a unified configuration for everything. Once you learned the basic configuration style, you could be able to apply it in many areas. Resources, middle tier objects, and web components, all could be set up using the same bean configuration mechanism. You could combine your entire configuration in one single bean definition file or split it by application modules or layers. There is no need for diverse configuration files in a variety of formats, spread out across the application.

### Increased Boilerplate Code Due to Container-Generated Classes

**Each EJB required creating a `component` interface, a `home` interface, and a `bean implementation` class. The EJB container would generated the additional classes required to handle functionalities like _lifecycle management_ during deployment. This resulted in multiple source files per EJB, making the overall codebase larger and harder to maintain.**

## Restrictive Programming Model

**EJBs, being coarse-grained components, typically relied on multiple fine-grained objects for their working However, the EJB container didn't provide any built-in support for managing the lifecycle or dependencies of these fine-grained objects.**

The Spring AOP framework provides AOP support for method interception on any class managed by a Spring lightweight container. It supports easy proxying of beans (dynamic proxies) in a bean factory, seamlessly weaving in interceptors and other advice at runtime. The main use of the Spring AOP framework is to provide declarative enterprise services for POJOs.

Declarative enterprise services can be provided to POJOs using AOP, thus taking one of the best features of EJB and applying it without most of the complexity of EJB.

One reason that AOP is a more attractive proposition to deliver such services than EJB is that it imposes fewer requirements on the objects to which it adds enterprise services. For example, they don't usually need to depend on a particular API such as the EJB API.

Dependency Injection flavor of Inversion of Control for configuring managed objects: An approach in which the container takes responsibility for configuring application objects running within it, "without the need for lookups in application code".

With Spring, objects express their dependencies on collaborators through ordinary Java JavaBean properties or constructor arguments, leaving the IoC container to resolve them at runtime, eliminating any need for tedious-to-implement and hard-to-test lookups in application code.
