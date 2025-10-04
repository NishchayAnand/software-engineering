
Often, you’ll see `@Id` used along with one of these annotations to automatically generate primary key values:

|Annotation|Description|
|---|---|
|@GeneratedValue|Automatically generates the primary key value.|
|@GeneratedValue(strategy = GenerationType.IDENTITY)|Uses the database’s auto-increment feature.|
|@GeneratedValue(strategy = GenerationType.SEQUENCE)|Uses a database sequence.|
|@GeneratedValue(strategy = GenerationType.AUTO)|Lets JPA decide the best strategy.|

**Example:**

When you use:

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

JPA (through Hibernate) tells PostgreSQL to auto-generate the ID using its built-in mechanism — typically a serial or identity column.

> **NOTE:** Generated IDs (IDENTITY, SEQUENCE) are usually assigned by the DB — you need a null to represent "not assigned yet". `Long` can be null.

In PostgreSQL, that means your table will look like this:

```
CREATE TABLE product (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    price NUMERIC
);
```

The keyword `BIGSERIAL` automatically creates and links a sequence for ID generation, just like `AUTO_INCREMENT` in MySQL.

---
### Custom Sequence

If you want to use a custom sequence, PostgreSQL supports that too:

```
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
@SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 1)
private Long id;
```

`allocationSize=1` gives strictly sequential IDs (fewer gaps) but higher DB traffic.

**Advantages:**

If you insert many rows (bulk/batch inserts), tuning the sequence allocationSize (Hibernate’s prefetch / pool size) reduces round-trips to the DB and improves throughput.

With a larger allocationSize you reduce calls to `nextval()` — good for high QPS.

**Disadvantages:**

Larger allocationSize means possible gaps (unused preallocated ids if the app restarts). Not a problem for most apps, but important if you expect strictly consecutive IDs.



---
