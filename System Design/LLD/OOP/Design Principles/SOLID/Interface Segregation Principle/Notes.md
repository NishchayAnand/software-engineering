# Interface Segregation Principle

The Interface Segregation Principle (ISP) states that **clients should not be forced to depend on interfaces (methods) they do not use**. The idea is to define fine-grained interfaces specific to the client that is going to use them.

By following this principle, you prevent bloated interfaces that define methods for multiple responsibilities, and respecting it helps us also to observe the **Single Responsiblity Principle**.

## Benefits

**Maximized Cohesion:** Cohesion is the measure of how strong the methods and data of a class belong together **(interdependence within a class)**.

**Minimized Coupling:** Coupling is the meaure of how strongly different classes depend on one another **(interdependence between classes)**.

> **CRUX:** Depending on something that carries baggage that you don't need can cause you trouble you didn't expect.

## EXTRA (Needs Validation)

Statically typed language like Java force programmers to create declaration that users must import. It is these included declarations in source code dependencies that force recompilation and redeployment.

Imagine a class `ServiceA` written in Java containing 3 methods: `methodA`, `methodB` and `methodC`. Suppose the client `UserA` only needs to interact with `methodA` of `ServiceA`. However, the source code of `UserA` will inadvertently depend on `methodB` and `methodC`, even though it doesn't call them. This dependence means that a change to the source code of `methodB` will force `UserA` to be recompiled and deployed, even though nothing that it cared about has actually changed.

In dynamically typed languages like Python, such declarations don't exist in source code. Instead, they are inferred at runtime. Thus there are no source code dependencies to force recompilation and redeployment.

Method existence and validity are checked at runtime.

> **NOTE:** Build tools often offer incremental build options, which only compile affected files, improving build times.

---
