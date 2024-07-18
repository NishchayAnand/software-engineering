# Understanding Use Case Diagram

A Use Case Diagram is a visual representation of how users interact with a **system**. It's a way to capture the system's functionality from the user's perspective, focusing on what the system does rather than how it does it.

They use **actors (users or external systems)** and **use cases (actions users perform)** to depict **interactions (relationships)**.

> NOTE: Use Case Diagrams provide a high-level overview of the system's functionality, not the internal workings.

## Actors

- **Primary Actor:** Initiates the use of the system.
- **Secondary Actors:** Reactionary.

## Relationships

1. **Association:**

2. **Include:** When the base use case is executed, the include use case is executed as well. For example, `log in` will be a base use case and `verify password` would be be an include use case. Login cannot be completed without verifying the password.

3. **Extend:** When the base use case is executed, the extend use case may or may not be executed. The extend use case will only happen if certain criteria happens. For example, the `log in` will be a base use case and `display login error` will be a extend use case. Login error will only be displayed when the login use case fail.

4.**Generalization (inheritance):** For example, `make payement` will be a base use case and, `Pay from current account` and `Pay from savings account` will be the generalized use cases.
