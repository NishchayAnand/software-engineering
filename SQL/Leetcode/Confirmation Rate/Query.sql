
use demo;

# Signups Table

CREATE TABLE signups (
	user_id INT PRIMARY KEY,
    time_stamp DATETIME
);

INSERT INTO signups (user_id, time_stamp) 
VALUES
	('3', '2020-03-21 10:16:13'),
	('7', '2020-01-04 13:57:59'),
	('2', '2020-07-29 23:09:44'),
	('6', '2020-12-09 10:39:37');
 
# Confirmations Table 
CREATE TABLE confirmations (
	user_id INT,
    time_stamp DATETIME,
    action ENUM('timeout', 'confirmed'),
    PRIMARY KEY (user_id, time_stamp),
    FOREIGN KEY (user_id) REFERENCES signups (user_id) ON DELETE CASCADE
);

INSERT INTO confirmations (user_id, time_stamp, action) 
VALUES
	('3', '2021-01-06 03:30:46', 'timeout'),
	('3', '2021-07-14 14:00:00', 'timeout'),
	('7', '2021-06-12 11:57:29', 'confirmed'),
	('7', '2021-06-13 12:58:28', 'confirmed'),
	('7', '2021-06-14 13:59:27', 'confirmed'),
	('2', '2021-01-22 00:00:00', 'confirmed'),
	('2', '2021-02-28 23:59:59', 'timeout');
    
# Step 1: Perform LEFT OUTER JOIN between Signups and Confirmations tables
SELECT 
	s.user_id, 
    c.time_stamp, 
    c.action
FROM 
	signups s 
LEFT JOIN 
	confirmations c 
ON s.user_id = c.user_id;

# Step 2: Count the total_requests_count and confirmed_requests_count for each user.
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
    
# Step 3: Calculate confirmation_rate.

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


    
    