# Understanding Triggers in DBMS

Triggers in DBMS are procedural code automatically executed in response to certain events (e.g. INSERT, UPDATE, DELETE) on a specified table or view. 

They are used to enforce constraints, automate workflows, maintain data integrity, and respond to changes in the database.

Syntax:

```
CREATE TRIGGER trigger_name
{BEFORE | AFTER} {INSERT | UPDATE | DELETE}
ON table_name
FOR EACH ROW
BEGIN
   -- SQL statements to execute when the trigger is fired
END;
```