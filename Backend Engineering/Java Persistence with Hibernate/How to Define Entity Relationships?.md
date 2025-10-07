



---
### What is a Unidirectional Relationship?



**Use unidirectional when:**

| **Scenario**                                                         | **Why**                                          |
| -------------------------------------------------------------------- | ------------------------------------------------ |
| You only ever need to go one way (e.g., from Hotel → Location)       | Simpler and cleaner mapping.                     |
| You rarely access the reverse side (e.g., all Hotels in a Location). | No performance or design benefit.                |
| The dataset is large (e.g., thousands of Hotels per Location).       | Maintaining large lists in memory is costly.     |
| You’re working with DTOs or APIs that don’t expose nested data.      | Keeps serialization simple and avoids recursion. |

---
### What is a Bidirectional Relationship?

In relational databases, data is stored in tables with foreign keys, so to move from one entity to another, you’d usually write SQL joins.

But in object-oriented programming (OOP), we think in objects and references, not in tables.

**For example:**

```
hotel.getLocation();   // Hotel → Location
location.getHotels();  // Location → Hotels
```

You’re navigating objects in memory, not running manual SQL queries. Hibernate and JPA handle the database joins behind the scenes.

So bidirectional mapping lets you walk through your domain model like a connected graph of objects — just as you would in pure Java.

In JPA, a bidirectional relationship means both entities reference each other.

**Example — Hotel ↔ Location:**

```
// Hotel.java
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "location_id")
private Location location;
```

```
// Location.java
@OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
private List<Hotel> hotels = new ArrayList<>();
```

> <span style="color:red;font-weight:bold;">IMPORTANT: Use bidirectional only when you actually need to navigate both ways in your application logic.</span>

**Good use cases:**

| Scenario                                                          | Why bidirectional helps                                             |
| ----------------------------------------------------------------- | ------------------------------------------------------------------- |
| You frequently access all hotels within a location                | You can call location.getHotels() directly.                         |
| You need both sides for data consistency or cascading operations  | For example, saving a Location should also persist its Hotels.      |
| You want to express a strong logical association (parent ↔ child) | For example, Order ↔ OrderItem, Teacher ↔ Student.                  |
| You plan to use JPQL from both sides                              | e.g., SELECT l FROM Location l JOIN l.hotels h WHERE h.name = :name |

---
### Types of Relationships

`@OneToMany`:

`@ManyToOne`:

`@OneToOne`:

`@ManyToMany`:

---
### What is MappedBy attribute?


---
### What is Fetched attribute?


---
### What is @JoinColumn?

A JPA annotation used to define the foreign key column that joins two entities in a relationship.

**Example:**

```
public class Hotel {

	...

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location location;
	
}
```

---
### What is @JoinTable Annotation?

`@JoinTable` is a JPA annotation used to define a **third table (join table)** that manages the relationship between two entities.

It specifies:
- The **name** of the join table,
- The **foreign keys** that connect both sides of the relationship.

> **NOTE:** In relational databases, a **join table** is a table that holds **pairs of foreign keys** to represent associations between two entities.

---

