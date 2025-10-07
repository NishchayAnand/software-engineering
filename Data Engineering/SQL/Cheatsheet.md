# SQL Cheatsheet

### Define FOREIGN KEY While Creating a Table

```
CREATE TABLE Employees (
    emp_id INT PRIMARY KEY,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
```

### Delete a Row from a Table

```
DELETE FROM students
WHERE student_id = 2;
```

### Handle NULL Values using COALESCE

```
SELECT 
    first_name, 
    COALESCE(middle_name, 'No Middle Name') AS middle_name, 
    last_name
FROM student;
```

---

Insert the room type only if the hotel doesn’t already have a room type with the same (case-insensitive) name.

```
INSERT INTO public.room_types (hotel_id, name, description, capacity, beds)
SELECT 1, 'Standard Room', 'Comfortable room with essential amenities', 2, 1
WHERE NOT EXISTS (
  SELECT 1 FROM public.room_types r WHERE r.hotel_id = 1 AND lower(r.name) = lower('Standard Room')
);
```

---
