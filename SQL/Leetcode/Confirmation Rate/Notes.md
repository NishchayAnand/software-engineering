# Confirmation Rate

Given a `Signups` table that contains information about the signup time for different users, and a `Confirmations` table that tracks confirmation requests by users, write a solution to find the confirmation rate of each user (return the result table in any order).

**NOTE:** The confirmation rate of a user is the **number of 'confirmed' messages divided by the total number of requested confirmation messages**. The confirmation rate of a user that did not request any confirmation messages is 0. Round the confirmation rate to two decimal places.

```
Input: 

Signups table:
+---------+---------------------+
| user_id | time_stamp          |
+---------+---------------------+
| 3       | 2020-03-21 10:16:13 |
| 7       | 2020-01-04 13:57:59 |
| 2       | 2020-07-29 23:09:44 |
| 6       | 2020-12-09 10:39:37 |
+---------+---------------------+

Confirmations table:
+---------+---------------------+-----------+
| user_id | time_stamp          | action    |
+---------+---------------------+-----------+
| 3       | 2021-01-06 03:30:46 | timeout   |
| 3       | 2021-07-14 14:00:00 | timeout   |
| 7       | 2021-06-12 11:57:29 | confirmed |
| 7       | 2021-06-13 12:58:28 | confirmed |
| 7       | 2021-06-14 13:59:27 | confirmed |
| 2       | 2021-01-22 00:00:00 | confirmed |
| 2       | 2021-02-28 23:59:59 | timeout   |
+---------+---------------------+-----------+

Output: 
+---------+-------------------+
| user_id | confirmation_rate |
+---------+-------------------+
| 6       | 0.00              |
| 3       | 0.00              |
| 7       | 1.00              |
| 2       | 0.50              |
+---------+-------------------+
```

**Here:**
- `user_id` in `confirmations` table is a foreign key (reference column) to the `Signups` table.
- (`user_id`, `time_stamp`) is the primary key for `confirmations` table.
- `action` in `confirmations` table is an **ENUM (category)** of the type ('confirmed', 'timeout').

## General Observations

- time_stamp column `signups` table is irrelevant for our problem. 

## Algorithm

- perform left join between `signups` and `confirmations` table.

- create a view containing user_id and total_confirmation_messages_count for each user.

- create a view containing user_id and confirmed_confirmation_messages_count for each user.

- join the above created views and get the result containing user_id and confirmation_rate for each user. 