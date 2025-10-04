
JPQL (Java Persistence Query Language) is an object-oriented query language defined by JPA (Java Persistence API). It’s similar to SQL, but instead of querying tables and columns, you query entities and their fields.

**Select Example:**

```
@Query("SELECT u FROM User u WHERE u.age > :age")
List<User> findUsersOlderThan(@Param("age") int age);
```

**Join Example:**

```
@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.name = :name")
List<Order> findOrdersByCustomerName(@Param("name") String name);
```

**Aggregate Example:**

```
@Query("SELECT AVG(u.age) FROM User u")
Double findAverageAge();
```

---
### Advantages

**Easy to Maintain:** If your table names or column names change but entity field names remain the same, no query updates needed.

---
### Disadvantages

1. **Limited database-specific features:** You can’t use vendor-specific SQL features like LIMIT, ILIKE, JSONB functions (PostgreSQL), etc.

2. **No compile-time validation:** JPQL syntax errors are caught only at runtime.

3. **Steeper learning curve**: For complex mappings (inheritance, joins), JPQL can become confusing.

---
