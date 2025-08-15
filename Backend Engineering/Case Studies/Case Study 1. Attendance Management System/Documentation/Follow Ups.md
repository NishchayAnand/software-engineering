
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

`201 Created` is reserved for cases where **a new resource is created on the server**, such as creating a new student, class, or attendance record entity that is independently retrievable via its own URI.

In most attendance marking scenarios, you’re **updating an existing resource** (the class’s attendance list) rather than creating a new top-level entity. Therefore:

- **HTTP 200 OK** → if the update succeeds.
- **HTTP 204 No Content** → if you don’t need to send back a message body.

You’d use **`201 Created`** only if your system treats each attendance submission as a **new resource** with its own unique identifier/URL (e.g., `/attendance/{attendanceId}`).

I can give you both **design options** for this if you want to handle it either way.

---

It's better to store **attendance records as a separate entity** rather than embedding them inside the **`Class`** object. 

While storing attendance within `Class` object keeps everything in one place, it tightly couples responsibilities and makes the class harder to manage. Let the **`Class`** object focus only on class metadata and enrolled students. 

This aligns with the **Single Responsibility Principle** and makes the system easier to extend for features like reporting or persistence later.

---
