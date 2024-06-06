# Understanding Spring Core

Spring core is the foundational part of Spring that includes the foundational capabilities.

Spring core is the core which holds all the frameworks together.

One of these features is the **Spring Context.** Spring Context is the fundamental capability of the Spring framework that enables Spring to manage instances of your app.

Also, as part of the Spring Core, you find the **Spring Aspects** functionality. Aspects help Spring intercept and manipulate methods you define in your app.

---

Spring works on the principle: _inversion of control (IOC)_. When using this principle, instead of allowing the app to control the execution, we give control to the Spring Framework. Through configurations, we instruct the framework on how to manage the code we write, which defines the logic of our app.

The IoC container glues Spring components and components of your application to the framework together.

Spring can control instances added to its IoC container, and one of the things it can do is intecept methods that represent the behavior of these instances. This capability is called **_aspecting the method._ Spring AOP** is the most common ways the framework interacts with what your app does.
