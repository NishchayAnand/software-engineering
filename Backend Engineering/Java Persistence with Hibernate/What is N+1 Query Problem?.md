
The N+1 query problem happens when:

- You fetch a list of entities (say, all Hotels). → 1 query=
- Then, for each hotel, Hibernate lazily fetches its Location separately. → N more queries

**Example:**

```
List<Hotel> hotels = hotelRepository.findAll(); 

for (Hotel h : hotels) {
    System.out.println(h.getLocation().getCity());  // triggers another query per hotel!
}
```

<span style="color:red;">If you have 100 hotels, that’s 1 (main query) + 100 (locations) = 101 queries</span> 😱

---
### Solution: Use JOIN FETCH in JPQL

You can tell Hibernate: “Fetch the related Location eagerly in the same query.”

```
@Query("SELECT h FROM Hotel h JOIN FETCH h.location")
List<Hotel> findAllWithLocation()
```

Now Hibernate executes **just one query** that joins both tables:

```
SELECT h.*, l.*
FROM hotel h
JOIN location l ON h.location_id = l.id;
```

So both Hotel and its associated Location are fetched together, eliminating the N+1 problem ✅

---


