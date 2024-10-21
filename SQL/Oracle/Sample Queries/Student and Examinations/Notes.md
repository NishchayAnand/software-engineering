# Students and Examinations

**Problem Statement:** Given tables: `Students(student_id -> pk, student_name)`: stores the ID and name of each student in the school, `Subjects(subject_name -> pk)`: stores all the subjects taught in the school and `Examinations(student_id -> Students_fk, subject_name -> Subjects_fk)`: stores the examination details of students, write a solution to find the number of times each student attended each exam.

> **NOTE:** Each student from the `Students` table takes every course from the `Subjects` table. The result table should contain all students and all subjects.

## General Observations

- `Examinations` table tells us which **student (student_id)** gave which **subject (subject_name)** exam. A student can give exam of a subject multiple times, i.e., the `Examinations` table can contain duplicate rows.

## Algorithm

1. Perform `CROSS JOIN` between `Students` and `Subjects` to generate a temporary result set containing all possible combinations of students and subjects (Cartesian Product).

2. Perform `LEFT JOIN` between `Examinations` and the result set obtained from step 1 **based on** the `student_id` and `subject_name` columns. The generated result set will include all rows from the Cartesian Product, and rows from `Examinations` where there is no match will have **NULL** values for `Examinations` columns.

3. Select `COUNT(Examinations.student_id)` from the result set obtained from step 2 to get the count of how many exams each student attended for each subject.

## Query

**SELECT** st.student_id, st.student_name, su.subject_name, count(e.student_id) as attended_exams
FROM Students st **CROSS JOIN** Subjects su
**LEFT JOIN** Examinations e ON e.student_id = st.student_id AND e.subject_name = su.subject_name
**GROUP BY** st.student_id, su.subject_name
**ORDER BY** st.student_id, su.subject_name;
