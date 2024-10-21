# Not Boring Movies

**Given:** 

- `Cinema` Table: 
    - `id->int`: primary key, 
    - `movie->varchar`: name of a movie, 
    - `description->varchar`: genre of the movie, 
    - `rating->float`: 2 decimal places float in the range [0, 10]. 

<!--
 +----------------+----------+ 
| Column Name    | Type     |
+----------------+----------+
| id             | int      |
| movie          | varchar  |
| description    | varchar  |
| rating         | float    |
+----------------+----------+
-->


**Required Output**: Write an Oracle query to report the movies with an odd-numbered ID and a description that is not "boring".

## Solution

SELECT * FROM cinema 
WHERE MOD(id, 2) = 1 AND description != 'boring'
ORDER BY rating DESC;

