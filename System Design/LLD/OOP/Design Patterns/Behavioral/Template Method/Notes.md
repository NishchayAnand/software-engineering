# Template Method Pattern

**DEFINITION: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. Template method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.**

A template method serves as a template for an algorithm. In the template, each step of the algorithm is represented by a method. Some methods will be handled by the class holding the template method whereas others will be left for the subclasses to handle. The methods that need to be supplied by subclass are declared abstract.

The template method pattern hides away all boilerplate code and allows the developer to concentrate solely on business logic.

When we've got code duplication, that's a good sign we need to clean up the design.

One or more steps are defined to be abstract and implemented by a subclass. This ensures the algorithm's structure stays unchanged, while subclasses provide some part of the implementation.

The template method is usually declared `final` to prevent subclasses from reworking the sequence of steps in the algorithm.

A hook is a method that is declared in the abstract class, but only given an empty or default implementation. This gives subclasses the ability to **"hook into"** the algorithm, if they wish (a subclass is free to ignore the hook).

> **NOTE:** Use hooks when part of the algorithm is optional. With hooks, a subclass may choose to implement that hook, but it doesn't have to.

It's a good thing to keep the number of abtract methods small in your template method. Sometimes you can do this by not making the steps of your algorithm too ganular. But it's obviously a tradeoff: **the less granularity, the less flexibility**.

## Real World Example

This pattern shows up so often because it's a great design tool for creating frameworks, where the framework controls how something gets done, but leaves you (the person using the framework) to specify your own details about what is actually happening at each step of the framework's algorithm.

Servlets are based on template method pattern. `Sort()` method of Java `Arrays` class is based on Template Method Pattern.

**The `sort()` template method in Arrays gives us the algorithm, but you need to tell it how to compare ducks, which you do by implementing the `compareTo()` method.**

> NOTE: The primitive sort operation, for e.g. merge sort uses compareTo method to compare two objects.

- `Sort() -> mergeSort() -> ((Comparable)obj1).compareTo((Comparable)obj2) -> type of obj1 and obj2 must implement the Comparable interface.`

## EXTRA

- Encapsulate Algorithms

- It defines the steps of an algorithm, allowing subclasses to provide the implementation for one or more steps.

- Methods have body that specify a sequence of statements or steps. You can think of methods as templates that outline a series of instructions to execute. However, in some cases, you may not know how to implement some steps where you may want to define a generic template, leaving some steps as abtract methods so other classes than supply an implementation.

- The intent of a template method is to implement an algorithm, leaving the definition of some operations or steps to a concrete subclass. Each concrete subclass must provide an implementation of the undefined steps of the template method's algorithm.

- NOTE: It's a good idea to minimise the number of abstract methods by not making the steps too granular, but it's obviously a tradeoff. The less granularity, the less flexibility.

- Abstract methods can be replaced with hook. Hooks are optional. Abtract class may provide a default implementation.

- NOTE: The template method pattern is an alternative to the strategy pattern. The intention of both is similar, but uses inheritance and other composition.

- The template method pattern uses inheritance to change part of an algorithm and the strategy pattern uses composition uses composition to change the entire algorithm.
