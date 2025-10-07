
In relational databases, a **join table** is a table that holds **pairs of foreign keys** to represent associations between two entities.

---
### Why We Need a Join Table?

In a **many-to-many** relationship, neither table can have a single foreign key column to represent the relationship, because both sides can contain multiple references.

So we use an **intermediate table** — a “join table”.

Example in SQL:

```
CREATE TABLE student_course (
  student_id BIGINT REFERENCES student(id),
  course_id BIGINT REFERENCES course(id)
);
```