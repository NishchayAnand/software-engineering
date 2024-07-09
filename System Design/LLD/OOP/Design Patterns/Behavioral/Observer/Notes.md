# Understanding Observer Design Pattern

**You don't want to miss out when something interesting happens, do you?** Observer Design Pattern keeps your objects in the know when something they care about happens.

## Definition

**The observer Pattern** defines a **one-to-many dependency** between a set of objects. When the state of one object changes, all of its dependencies are notified.

## Publishers + Subscribers = Observer Pattern

The publishers are called `SUBJECT` and the subscribers are called `OBSERVERS`.

The `SUBJECT` and `OBSERVERS` define the **one-to-many relationship** where **EACH** `SUBJECT` can have **MANY** `OBSERVERS`.

The `SUBJECT` object manages some important data. When data in the `SUBJECT` changes, the `OBSERVERS` are notified. New data values are then communicated to the `OBSERVERS` in some form.

## How to implement Observer Pattern?

There are a few different ways to implement the Observer pattern, but most revolve around a **class design that includes Subject and Observer interfaces**.

## Advantages

- Leads to a cleaner OO design than allowing many objects to control the same data.
