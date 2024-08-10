# Java Cheatsheet

- `Stack Memory`: part of RAM -> stores temporary variables created by each function -> allocated during compile-time.

- `Heap Memory`: part of RAM -> supports dynamic memory allocation -> allocated during runtime.

- `Instance Variables`: associated with specific object -> lifetime tied to lifetime of object.

- `Local Variables`: declared within a method or block of code -> temporary variables needed only during the execution of the method or block.

- `Encapsulation`: bundling data and methods into single unit -> two key aspects -> (1) data protection: shield internal data from direct external access (access modifiers) -> (2) Information hiding: hide internal complexities (implementation details) from external code.

- `Coupling`: interdependence between classes -> good to have low coupling.

- `Cohesion`: interdependence between elements within a class -> good to have high cohesion.

- `Single Responsibility Principle`: S in SOLID Principles -> A module should have only one reason to change -> promotes high cohesion.

- `Facade Pattern`: provide simplified interface to a subsystem -> core idea: keep number of interactions between classes to a minimum (low coupling).
