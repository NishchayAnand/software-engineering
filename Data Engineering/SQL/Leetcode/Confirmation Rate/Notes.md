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

- The `time_stamp` column in the `signups` table is irrelevant for the problem. 

- To get the `confirmation_rate` for each user, we need to have the `total_requests_count` and `confirmed_requests_count` for each user.

## Algorithm

1. **Join the `signups` and `confirmations` tables** to ensure that all users from the `signups` table are included, even if they don't have any entries in the `confirmations` table.

    ```
    SELECT 
        s.user_id, 
        c.time_stamp, 
        c.action 
    FROM 
        signups s 
    LEFT JOIN 
        confirmations c 
    ON 
        s.user_id = c.user_id;
    ```

2. **Aggregate (count)** the `total_requests_count` and `confirmed_requests_count` for each user.

    ```
    SELECT 
	    s.user_id,
        COUNT(c.action) AS total_requests_count,
        SUM(CASE
			    WHEN c.action = 'confirmed' THEN 1
                ELSE 0
		    END) AS confirmed_requests_count
    FROM 
	    signups s
    LEFT JOIN 
	    confirmations c
    ON 
	    s.user_id = c.user_id
    GROUP BY
	    s.user_id;
    ```

3. **Calculate** the `confirmation_rate` for each user.

    ```
    WITH confirmation_counts AS (
	    SELECT 
		    s.user_id,
		    COUNT(c.action) AS total_requests_count,
		    SUM(CASE
			    WHEN c.action = 'confirmed' THEN 1
                ELSE 0
		    END) AS confirmed_requests_count
	    FROM 
		    signups s
	    LEFT JOIN 
		    confirmations c
	    ON 
		    s.user_id = c.user_id
	    GROUP BY
		    s.user_id
    )
    SELECT
	    user_id,
        ROUND(
		    CASE
			    WHEN total_requests_count = 0 THEN 0
                ELSE confirmed_requests_count * 1.0 / total_requests_count
		    END,
            2
	    ) AS confirmation_rate
    FROM 
	    confirmation_counts;
    ```
 