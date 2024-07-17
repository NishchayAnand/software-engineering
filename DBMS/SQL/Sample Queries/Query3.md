# Query 3: Average Processing Time Per Machine

**Problem Statement:** There is a factory that has several machines each running the same number of processes. `Activity(machine_id, process_id, activity_type, timestamp)` shows the details of the processes running by each machine in a factory. Write a solution to find the average processing time of each machine.

- the combination of **{machine_id, process_id, activity_type}** act as the primary key.
- activity_type is an ENUM (category) of type: `start` and `stop`.

## General Observations

1. We may need to modify the table such that we have the `start` and `end` timestamp for each **{machine_id, process_id}** combination.

## Queries

**Schema Definition:** `create table activity(machine_id int, process_id int, activity_type ENUM('start', 'end'), timestamp float)`.
