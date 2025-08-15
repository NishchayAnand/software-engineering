
In a **simple Attendance Management System**, it’s perfectly fine for each `Class` object to store its own list (or map) of students, because the scope is limited:

- Queries are mostly class-focused (e.g., “Who attended in Class 10A today?”).
- You don’t usually need to join data across multiple classes.

But for a **larger Student Management System** where you might need queries like:

- “List all the classes a student is currently enrolled in”
- “Get all attendance records for a student across multiple subjects/classes”
- “Show all teachers teaching a given student”

It becomes much cleaner and **more scalable** to:

1. **Have a dedicated `StudentService`** that stores all students in a `studentMap` keyed by enrollment number (or another unique ID).
2. Maintain **relationships** between `Student` and `ClassRoom` in a way that allows bidirectional queries.

---

The **Attendance Management System (AMS)** can be designed using a **Layered Architecture**. This approach organizes the system into **distinct layers (Controller–Service–Repository)**, allowing each layer to focus on a single responsibility.

Additionally, we can leverage **Object-Oriented Programming (OOP) principles** to model real-world entities such as **`Teacher`**, **`SchoolClass`**, and **`Student`** as objects, encapsulating both their data and behaviors. This makes the system more intuitive by aligning the software design closely with real-world scenarios.

Let's discuss each component, explaining how the **Layered Architecture** and **OOP design** shape their implementation.

<span style="color:red;">(talk about data transfer objects - explain the importance of DTO objects as well)</span>