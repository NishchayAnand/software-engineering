
The modern and recommended way to work with dates and times in Java is via the **`java.time`** API (introduced in **Java 8**).

Here’s a breakdown:

|Class|Purpose|Example|
|---|---|---|
|`LocalDate`|Date without time (e.g., `2025-08-14`)|`LocalDate.now()`|
|`LocalTime`|Time without date (e.g., `11:45:30`)|`LocalTime.now()`|
|`LocalDateTime`|Date and time without timezone|`LocalDateTime.now()`|
|`ZonedDateTime`|Date, time, and timezone|`ZonedDateTime.now()`|
|`Instant`|A point in time (timestamp)|`Instant.now()`|
|`Duration`|Time-based amount (e.g., 2 hours)|`Duration.between(t1, t2)`|
|`Period`|Date-based amount (e.g., 3 days)|`Period.between(d1, d2)`|

---