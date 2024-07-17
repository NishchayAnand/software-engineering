# Query 3: Average Processing Time Per Machine

**Problem Statement:** There is a factory that has several machines each running the same number of processes. `Activity(machine_id, process_id, activity_type, timestamp)` shows the details of the processes running by each machine in a factory. Write a solution to find the average processing time of each machine.

- the combination of **{machine_id, process_id, activity_type}** act as the primary key.
- activity_type is an ENUM (category) of type: `start` and `stop`.

## General Observations

1. We may need to modify the table such that we have the `start` and `end` timestamp for each **{machine_id, process_id}** combination.

## Algorithm

1. Perform a self-join on the `Activity` table to create a Cartesian product of the table with itself: `SELECT * FROM Activity a1 JOIN Activity a2`. This allows us to compare each record in a1 with each record in a2.

2. Use join condition: `ON a1.machine_id = a2.machine_id AND a1.process_id = a2.process_id` as the join condition and filter condition: `WHERE a1.activity_type = 'start' and a2.activity_type = 'end'` to get the start timestamp and end timestamp for each **{machine_id, process_id}** combination.

3. Replace `*` with `a1.machine_id, avg(a2.timestamp-a1.timestamp) as processing_time` and use `GROUP BY machine_id` to get the average processing time at the **machine_id** level.

## Queries

**Schema Definition:**

```
create table activity(machine_id int, process_id int, activity_type ENUM('start', 'end'), timestamp float);
```

**Main Query:**

```
select a1.machine_id, round(avg(a2.timestamp-a1.timestamp), 3) as processing_time
from activity a1 join activity a2
on a1.machine_id = a2.machine_id and a1.process_id = a2.process_id
where a1.activity_type = 'start' and a2.activity_type = 'end'
group by machine_id;
```
