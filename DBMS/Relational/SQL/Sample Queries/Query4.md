# Query 4: Employees Bonus

**Problem Statement:** Given tables: `Employee(empId, name, supervisor, salary)` and `Bonus(emp_id, bonus)`, write a query to report the name and bonus amount of employees whose bonus is less than 1000.

## General Observations

- `emp_id` act as primary key in `Employee` and foreign key in `Bonus`.

## Algorithm

1. Performing a **left join** operation between `Employee` and `Bonus` will bring the required columns `name` and `bonus` adjacent to each other.

## Queries

select name, bonus
from employee e left join bonus b
on e.empId = b.empId
where bonus < 1000 or bonus is null

> **NOTE:** When you use a WHERE clause, any rows with NULL values in the specified column will not be included in the result set unless you explicitly handle the NULL values.
