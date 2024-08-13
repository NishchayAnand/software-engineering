# OOPs Cheatsheet

- `Encapsulation`: bundling data and methods into single unit -> two key aspects -> (1) data protection: shield internal data from direct external access (access modifiers) -> (2) Information hiding: hide internal complexities (implementation details) from external code.

- `Coupling`: interdependence between classes -> good to have low coupling.

- `Cohesion`: interdependence between elements within a class -> good to have high cohesion.

- `Single Responsibility Principle`: S in SOLID Principles -> A module should have only one reason to change -> promotes high cohesion.

- `Facade Pattern`: provide simplified interface to a subsystem -> core idea: keep number of interactions between classes to a minimum (low coupling).

- `Composition`: represent association between two classes -> models a "has-a" relationship -> represent part-whole hierarchy -> lifetime of the composed objects (part) is tied to the lifetime of the composite object (whole) -> each part object is typically owned by only one whole object.

- `Aggregation`: represents association between two classes -> models a "has-a" relationship -> represents part-whole hierarhy -> part can exist independently of the whole -> lifetime of the part is not tied to the whole -> multiple whole parts may contain references to the same part object.

- `Open-Close Principle`: O in SOLID Principles. A software artifact should be open for extension but closed for modification -> identify areas that can change and encapsulate them -> behavior that stays the same is abstracted into a base class and locked for modification -> divide system into components and arrange those components into a dependency hierarchy that protects the higher-level components from the lower-level components.

- `Decorator Pattern`:

- `Strategy Pattern`:
