# Understanding Template Design Pattern

- Encapsulate Algorithms

- It defines the steps of an algorithm, allowing subclasses to provide the implementation for one or more steps.

- Methods have body that specify a sequence of statements or steps. You can think of methods as templates that outline a series of instructions to execute. However, in some cases, you may not know how to implement some steps where you may want to define a generic template, leaving some steps as abtract methods so other classes than supply an implementation.

- The intent of a template method is to implement an algorithm, leaving the definition of some operations or steps to a concrete subclass. Each concrete subclass must provide an implementation of the undefined steps of the template method's algorithm.

- NOTE: It's a good idea to minimise the number of abstract methods by not making the steps too granular, but it's obviously a tradeoff. The less granularity, the less flexibility.

- Abstract methods can be replaced with hook. Hooks are optional. Abtract class may provide a default implementation.

- NOTE: The template method pattern is an alternative to the strategy pattern. The intention of both is similar, but uses inheritance and other composition.

- The template method pattern uses inheritance to change part of an algorithm and the strategy pattern uses composition uses composition to change the entire algorithm.

- Servlets are based on template design pattern.
