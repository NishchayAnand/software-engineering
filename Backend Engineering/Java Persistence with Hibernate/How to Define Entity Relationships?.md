



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

It tells Hibernate which side actually manages the join column. 

**Example:**

```
@Entity
public class Hold {
    @Id
    private UUID id;

    @OneToMany(mappedBy = "hold", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<HoldItem> items = new ArrayList<>();
}
```

This tells JPA that the **foreign key is owned by the other side** (`HoldItem`).

> **NOTE:** Without `mappedBy`, Hibernate would try to create an extra join table which you don’t want here.

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
### What is CascadeType.ALL?

Cascade means:

> “When I do something to the parent, automatically do it to the children.”

`CascadeType.ALL` includes all these operations:

- `PERSIST` → When you save a Hold, all HoldItems are saved automatically.
- `MERGE` → Updating the Hold will also update the HoldItems.
- `REMOVE` → Deleting the Hold will delete all its HoldItems.

**Example:**

```
Hold hold = new Hold();
hold.getItems().add(new HoldItem());
holdRepository.save(hold);
```

This will automatically persist both the `Hold` and its `HoldItems` in a single transaction, no need to save `HoldItem`separately.

---
