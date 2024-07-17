# Query 2: Find all dates' Id with higher temperatures compared to its previous dates (yesterday).

**Given:** Table `Weather(id, recordDate, temperature)` which contains information about the temperature on a certain day.

> NOTE: `recordDate` contains **unique** dates.

**Algorithm:**

1. Perform a self-join on the `Weather` table to create a Cartesian product of the table with itself: `SELECT w1.id FROM Weather w1 JOIN Weather w2`. This allows us to compare each record in w1 with each record in w2.

2. Use `DATEDIFF(w1.recordDate, w2.recordDate) = 1` as the join condition to find pairs of records where the `recordDate` differs by exactly one day.

3. Use `WHERE w1.temperature > w2.temperature` to filter the records where the temperature on a day (represented by a record in w1) is greater than the temperature on the previous day (represented by a record in w2).
