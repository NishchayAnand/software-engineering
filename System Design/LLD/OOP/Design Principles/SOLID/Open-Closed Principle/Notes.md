# Understandind Open-Closed Principle

**DEFINITION: A software artifact should be open for extension but closed for modification.** The goal is to allow classes to be easily extended to incorporate new behavior without modifying existing code.

> **NOTE:** Usually, you can't make every part of your design follow the open-close principle. Following the open-close principle usually introduces new levels of abstraction, which adds complexity to our code. You want to **concentrate on those areas that are most likely to change** in your designs and apply the principles there.

## EXTRA

Classes should be resilient. This is good because it allows later for new features to be added to software without changing existing code. That idea is often formalized in the Open-Closed Principle.

Open-Closed Principle: "Classes and methods should be open for extension, but closed for modification."

The reasoning behind this is to avoid modifying existing code because client code depends on it, but to allow it to be extended because extensions are a necessary response to new requirements.

Identify the aspects of your application that vary and separate them from what stays the same. Here's another way to think about this principle: "Take the parts that vary and encapsulate them, so that later you can alter or extend the parts that vary without affecting those that don't."

While the OCP is often phrased as "Classes should be open for extension, but closed for modification," this principle also emphasizes identifying variability and isolating it from stable parts of the code. This allows for future changes to be implemented through extensions without modifying the core functionality.

Applying this principle is actually a combination of applying encapsulation and abstraction. The behaviour that stays the same is abstracted into a base class and locked for modification.

Properly separating the things that change for different things (the `Single Responsibility Principle`), and then organizing the dependencies between those things properly (`Dependency Inversion Principle`).

The OCP is one of the driving forces behind the architecture of systems. The goal is to make the system easy to extend without incurring a high impact of change. This goal is accompanished by **dividing the system into components, and arranging those components into a dependency hierarchy that protects the higher-level components from changes in lower-level components.**

`Dependency Inversion Principle` supports `Open-Close Principle` by facilitating extension through new abstractions.

## Design Patterns Supporting OCP

1. `Decorator Pattern`:
2. `Strategy Pattern`:
