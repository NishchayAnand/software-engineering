# Interface Segregation Principle

The Interface Segregation Principle (ISP) states that **clients should not be forced to depend on interfaces (methods) they do not use**.

> **NOTE:** Build tools often offer incremental build options, which only compile affected files, improving build times.

> **CRUX:** Depending on something that carries baggage that you don't need can cause you trouble you didn't expect.

---

Statically typed language like Java force programmers to create declaration that users must import. It is these included declarations in source code dependencies that force recompilation and redeployment.

Imagine a class `ServiceA` written in Java containing 3 methods: `methodA`, `methodB` and `methodC`. Suppose the client `UserA` only needs to interact with `methodA` of `ServiceA`. However, the source code of `UserA` will inadvertently depend on `methodB` and `methodC`, even though it doesn't call them. This dependence means that a change to the source code of `methodB` will force `UserA` to be recompiled and deployed, even though nothing that it cared about has actaully changed.

In dynamically typed languages like Python, such declarations don't exist in source code (`?`). Instead, they are inferred at runtime. Thus there are no source code dependencies to force recompilation and redeployment.

Method existence and validity are checked at runtime.

---

Says that "You should define fine-grained interfaces specific to the client that is going to use them. This means that it's better to have many smaller interfaces than fewer bigger interfaces."

By following this principle, you prevent bloated interfaces that define methods for multiple responsibilities, and respecting it helps us also to observe the Single Responsiblity Principle.

Classes which implement small interfaces will be less likely to accumulate multiple responsibilties.

**Maximized Cohesion:** The measure of how strong the methods and data of a class belong together: interdependence within a class.

**Minimized Coupling:** The meaure of how strongly different classes depend on one another: interdependence between classes.

Closely related to the concept of coupling. When two or more details are intermixed in the same class, it introduces tight coulping between these details. If the details change at different times due to different reasons, it's likely to cause problems in the future.
