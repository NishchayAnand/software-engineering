# Query 2: Find all dates' Id with higher temperatures compared to its previous dates (yesterday).

**Given:** Table `Weather(id, recordDate, temperature)` which contains information about the temperature on a certain day.

> NOTE: `recordDate` contains **unique** dates.

**Algorithm:**

1. Performing a self-join on the `Weather` table will create a Cartesian product of the table with itself: `SELECT w1.id FROM Weather w1 JOIN Weather w2`.

2. We then use the `DATEDIFF` function to restrict these pairs to only include consecutive days. Lastly, we filter these pairs of consecutive days further to only include pairs where the temperature is higher on the second day. The resulting ids represent the days where the temperature was higher than the previous day.
