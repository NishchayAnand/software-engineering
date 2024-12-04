
create table employee (
	id int primary key,
    name varchar(50) not null,
    department varchar(50),
    managerId int
);

insert into employee (id, name, department, managerId) values 
	(1, "Nishchay", "A", 4), 
    (2, "Vridhi", "A", 4),
    (3, "Veenu", "B", 4),
    (4, "Rajiv", "D", null);

SELECT 
    m.name
FROM 
	Employee e 
JOIN 
	Employee m 
ON
	e.managerId = m.id
GROUP BY
	e.managerId
HAVING 
	count(e.id) >= 3;


