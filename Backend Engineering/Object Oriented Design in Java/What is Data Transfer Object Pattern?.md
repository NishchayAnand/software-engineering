
The **Data Transfer Object Pattern** is part of the **Enterprise Application Architecture patterns** (popularized by Martin Fowler).

A **DTO** (Data Transfer Object) is a **simple Java object** used to carry data between different layers of an application (e.g., from the controller to the service layer) **without exposing internal domain models**.

---
### Purpose of the pattern

**Problem:** When transferring data between layers (like backend → frontend or service → controller) or across network boundaries (e.g., REST API), you often don’t want to send entire domain objects because:

- They may contain unnecessary fields.
- They may expose sensitive data.
- They might have lazy-loaded relationships that cause extra DB queries.
- <span style="color:green'font-weight:bold;background:beige;">They might be hard to serialize.</span>

**Solution:** Create a **separate, flat, serializable object** that only contains the required data, and use it as a **data carrier**.

---
### Core Characteristics

- **No business logic** – DTOs are “dumb” objects.
- **Serializable** – Can easily be turned into JSON/XML for transfer.
- **Purpose-built** – One DTO per specific API or UI requirement is common.

---
