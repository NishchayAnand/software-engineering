# Query 5: Students and Examinations

use test;

# Create Students Table

create table Students(
student_id int primary key,
student_name varchar(100));

insert into Students(student_id, student_name)
values (1,'Alice'), (2, 'Bob'), (13, 'John'), (6, 'Alex');

select * from Students;

# Create Subjects Table

create table Subjects(subject_name varchar(150) primary key);

insert into Subjects(subject_name) values ('Math'), ('Physics'), ('Programming');

## Create Examinations Table

create table Examinations(
	student_id int,
    subject_name varchar(150),
    foreign key (student_id) references Students(student_id),
    foreign key (subject_name) references Subjects(subject_name));
    
insert into Examinations(student_id, subject_name) 
values (1, 'Math'),
	(1, 'Physics'),
    (1, 'Programming'),
    (2, 'Programming'),
    (1, 'Physics'),
    (1, 'Math'),
    (13, 'Math'),
    (13, 'Physics'),
    (13, 'Programming'),
    (2, 'Math'),
    (1, 'Math');
    
select * from Examinations;

## Query 1
SELECT 
    v1.student_id, 
    v1.student_name, 
    v1.subject_name, 
    ifnull(v2.attended_exams, 0) as attended_exams 
FROM
    (SELECT 
        st.student_id, 
        st.student_name, 
        su.subject_name 
    FROM 
        Students st CROSS JOIN Subjects su
    ) AS v1 
LEFT JOIN 
    (SELECT 
        student_id, 
        subject_name, 
        count(*) as attended_exams 
    FROM 
        Examinations
    GROUP BY 
        student_id, subject_name
    ) AS v2
ON 
    v1.student_id = v2.student_id AND v1.subject_name = v2.subject_name
ORDER BY 
    v1.student_id, v1.subject_name;
   
## Optimized Query
SELECT 
    st.student_id, 
    st.student_name, 
    su.subject_name, 
    count(e.student_id) as attended_exams 
FROM
	Students st 
CROSS JOIN Subjects su
LEFT JOIN Examinations e ON e.student_id = st.student_id AND e.subject_name = su.subject_name
GROUP BY 
	st.student_id, su.subject_name
ORDER BY 
    st.student_id, su.subject_name;

## Restructed Optimized Query
SELECT * 
FROM Students st CROSS JOIN Subjects su
LEFT JOIN Examinations e ON e.student_id = st.student_id AND e.subject_name = su.subject_name
GROUP BY st.student_id, su.subject_name
ORDER BY st.student_id, su.subject_name;
