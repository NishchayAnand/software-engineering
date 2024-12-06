
use demo;

CREATE TABLE student (
	student_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    age INT NOT NULL
);

INSERT INTO student (name, age)
VALUES
    ('Alice', 20),
    ('Bob', 22),
    ('Charlie', 19),
    ('Diana', 21),
    ('Ethan', 23);
    
SELECT * FROM student;

CREATE TABLE subject (
	subject_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100) UNIQUE
);

INSERT INTO subject (title)
VALUES
	('English'),
    ('Hindi'),
    ('Physics'),
    ('Mathematics');
    
CREATE TABLE enrollment (
	student_id INT,
    subject_id INT,
    FOREIGN KEY (student_id) REFERENCES student (student_id) ON DELETE CASCADE,
    FOREIGN KEY (subject_id) REFERENCES subject (subject_id)
);

INSERT INTO enrollment (student_id, subject_id) 
VALUES 
	(1,1),
    (1,3),
    (1,4),
    (2,3),
    (2,4),
    (4,4);
    
# DELETE FROM enrollment where student_id = 1 and subject_id = 2;
    
# INNER JOIN: Fetch enrollment details in understandable format, i.e., student name and the title of the subject he/she is enrolled.

SELECT student.name, subject.title
FROM student
JOIN enrollment ON student.student_id = enrollment.student_id
JOIN subject ON enrollment.subject_id = subject.subject_id;

# LEFT OUTER JOIN: Get number of enrollments in each subject. The query should return 0 for subject with no entry in enrollment table.

SELECT subject_id, COUNT(student_id) AS enrollment_count
FROM enrollment
GROUP BY subject_id;

SELECT s.title, count(e.student_id) AS enrollment_count
FROM subject s
JOIN enrollment e
ON s.subject_id = e.subject_id
GROUP BY s.subject_id;

SELECT s.title, count(e.student_id) AS enrollment_count
FROM subject s
LEFT JOIN enrollment e
ON s.subject_id = e.subject_id
GROUP BY s.subject_id;

# CROSS JOIN: Generate a view where each student is enrolled in all subjects (e.g. all students enrolled to all subjects offered in a semester).

SELECT name, title
FROM student
CROSS JOIN subject;
















