# DBMS Interview Questions

**Q. When to use Relational and when to use Non-relational?**

A Relational database should be used where we have well-defined, predictable data, where transactions are important to us, where we find value in keeping the relationships between our tables.

A Non-Relational database should be used where we have unstructured information, where pure performance is more important than ACID transactions and where we may need to scale quickly.

---

**Q. What do you mean by "No Schema"?**

No Schema means that arbitrary keys and values can be added to a document, and when reading, clients have no guarantees as to what fields the documents may contain.

---

**Q. What do you mean by Schemaless?**

Document databases are sometimes called _schemaless_, but that's misleading, as the code that reads the data usually assumes some kind of structure. There is an implicit schema, but it is not enforced by the database.

A more accurate term is _schema-on-read_ (the structure of the data is implicit, and only interpreted when the data is read), in contrast with _schema-on-write_ (the traditional approach of relational databases, where the schema is explicit and the database ensures all written data conforms to it).

> **NOTE:** Schema-on-read is similar to dynamic (runtime) type checking in programming languages, whereas schema-on-write is similar to static (compile-time) checking.
