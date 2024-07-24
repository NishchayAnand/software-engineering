# Query 5: Students and Examinations

**Problem Statement:** Given tables: `Students(student_id pk, student_name): stores the ID and name of each student in the school`, `Subjects(subject_name pk): stores all the subjects taught in the school` and `Examinations(student_id Students_fk, subject_name Subjects_fk): stores the examination details of students`, write a solution to find the number of times each student attended each exam.

> **NOTE:** Each student from the `Students` table takes every course from the `Subjects` table. The result table should contain all students and all subjects.

## General Observations

- `Examinations` table tells us which **student (student_id)** gave which **subject (subject_name)** exam. A student can give exam of a subject multiple times, i.e., the `Examinations` table can contain duplicate rows.

## Algorithm

1. Perform `CROSS JOIN` between `Students` and `Subjects` table to create all possible combinations of students and subjects.
2. Perform `COUNT(*)` on `Examinations` to aggregate the number of times each student gave the same subject exam. 3. 3. Perform `LEFT JOIN` between 2 views obtained from step 1 and 2.
