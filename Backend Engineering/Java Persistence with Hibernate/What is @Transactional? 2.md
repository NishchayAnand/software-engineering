
`@Transactional` marks a transactional boundary: 

1. it opens a persistence context, 
2. manages commit/rollback, and 
3. ensures lazy associations can be fetched inside the same transaction (avoids `LazyInitializationException`).

Use it on service-layer methods that call repositories so you get consistent reads, automatic rollback on runtime exceptions, and optional optimizations (`readOnly = true)`.

> **IMPORTANT:** The ordering inside the same transaction is largely a matter of semantics/readability.

---

If the constraint violation is detected at the commit-time flush, the exception is thrown when the transaction is committing. That means:

- If you expect to handle it inside the same transactional method, it may be too late (transaction is rolling back).

- The exception will bubble out of the transactional boundary (e.g., to controller) as a `DataIntegrityViolationException` or wrapped in a `TransactionSystemException`.

---
### @Transactional(readOnly = true)

Use `@Transactional(readOnly = true)` for read-only service methods when you want the benefits of a transactional context (like an open persistence session for lazy loading) and potential optimizations from the persistence provider.

**Example:**

```
@Transactional(readOnly = true)
public List<Hotel> getHotelsByLocation(String city, String state, String country) {

	// Step 1: Find location Id for the specified location
	Location location = locationRepository
		.findFirstByCityIgnoreCaseAndStateIgnoreCaseAndCountryIgnoreCase(
			city, 
			state, 
			country
		)
		.orElse(null);

	if(location == null) return List.of();

	// Step 2: Find hotels in the specified location
	List<Hotel> hotels = location.getHotels();

	return hotels;

}
```

<span style="color:red;font-weight:bold;">If this method is not annotated with</span> `@Transactional`<span style="color:red;font-weight:bold;">, then by the time you call</span> `location.getHotels()`<span style="color:red;font-weight:bold;">, the Hibernate Session from the repository call is already closed.</span>

That means:

- The Location entity is detached.
- Lazy loading can’t occur.
- Hibernate throws: `org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: Location.hotels, could not initialize proxy - no Session`.

---
