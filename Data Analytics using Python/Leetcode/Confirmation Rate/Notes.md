# Confirmation Rate

Given a `Signups` table that contains information about the signup time for different users, and a `Confirmations` table that tracks confirmation requests by users, write a solution to find the confirmation rate of each user (return the result table in any order).

**NOTE:** The confirmation rate of a user is the **number of 'confirmed' messages divided by the total number of requested confirmation messages**. The confirmation rate of a user that did not request any confirmation messages is 0. Round the confirmation rate to two decimal places.

```
Input: 

Signups DataFrame:
+---------+---------------------+
| user_id | time_stamp          |
+---------+---------------------+
| 3       | 2020-03-21 10:16:13 |
| 7       | 2020-01-04 13:57:59 |
| 2       | 2020-07-29 23:09:44 |
| 6       | 2020-12-09 10:39:37 |
+---------+---------------------+

Confirmations DataFrame:
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

## General Observations

- The `time_stamp` column in the `signups` DataFrame is irrelevant for the problem. 

- To get the `confirmation_rate` for each user, we need to have the `total_requests_count` and `confirmed_requests_count` for each user.

## Algorithm


1. **Aggregate (count)** the `total_requests_count` and `confirmed_requests_count` for each user.

    ```
    total_requests_count = confirmations.groupby('user_id').size().reset_index(name = 'total_requests_count')
    
    confirmed_requests_count = confirmations[confirmations['action'] == 'confirmed'].groupby('user_id').size().reset_index(name = 'confirmed_requests_count')

    requests_count_details = pd.merge(total_requests_count, confirmed_requests_count, how = 'left', on = 'user_id')
    ```

2. **Merge the `signups` and `requests_count_details` DataFrames (LEFT JOIN)** to ensure that all users from the `signups` table are included, even if they don't have any entries in the `confirmations` table.

    ```
    result = pd.merge(signups[['user_id']], requests_count_details, how = 'left', on = 'user_id').fillna(0)
    ```

3. **Calculate** the `confirmation_rate` for each user.

    ```
    result['confirmation_rate'] = result['confirmed_count'] / result['total_requests']
    result['confirmation_rate'] = result['confirmation_rate'].fillna(0).round(2)
    ```
 