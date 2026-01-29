
**Q1. What is Java Collections Framework?**

**A.**  A set of interfaces and classes designed to provide ready-to-use data structures for storing and processing group of objects efficiently.

---

**Q2. Explain the difference between `Iterable` and `Iterator`.**

`Iterable`:

- An interface that represents a collection of elements that can be iterated over.

```java
public interface Iterable<T> {
	Iterator<T> iterator;
}
```

- Implemented by all collection classes (`List`, `Set`, etc).
- Enables the enhanced **for-loop (for-each)**.
- Does not move through elements itself.

```java
List<String> names = List.of("Java", "Ruby", "Go");

for (String s: names) {
	System.out.println(s);
}
```

`Iterator`: 

- An interface that provides methods to traverse elements one by one.

```java
public interface Iterator<T> {
	boolean hasNext();
	T next();
	void remove();
}
```

- Used to iterate manually.
- Maintains **iteration state**.
- Works in one direction only.

```java
List<String> names = List.of("Java", "Ruby", "Go");

Iterator<String> it = list.iterator();
while(it.hasNext()) {
	System.out.println(it.next());
}
```

**Summary:**

`Iterable` exposes the `iterator()` method, and the returned `Iterator` maintains the iteration state.

---

**Q3. What is`Comparable` interface?**

- An interface in `java.lang`

```java
public interface Comparable<T> {
	int compareTo(T o);
}
```

- Implemented by the class itself.
- Defines a natural ordering inside the class.

```java
class Employee implements Comparable<Employee> {
	int id;
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int compareTo(Employee other) {
		return this.id - other.id; // ascending by id
	}
}
```

```java
Collections.sort(employeeList); // uses compareTo()
```

- Used when objects have a single, obvious way to be sorted.

---

**Q4. Explain the internal working of `Collections.sort(employeeList)`.** 

Java does roughly this internally:

```java
for(int i=0; i<employeeList.size(); i++) {
	for(int j=i+1; j<employeeList.size(); j++) {
		if( employeeList.get(i).compareTo(employeeList.get(j)) > 0 ) {
			swap(employeeList, i, j);
		}
	}
}
```

---

**Q5. What is`Comparator` interface?**

- An interface in `java.util`

```java
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

- Implemented as a **separate class or lambda** to define a custom ordering **outside** the main class.

```java
class Employee {
    int id;
    String name;
    double salary;
}
```

```java
class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.name.compareTo(e2.name);
    }
}
```

- Used when you need **multiple sorting strategies**

```java
Collections.sort(employeeList, new NameComparator());
```

<span style="color:green;font-weight:bold;">Key Insights:</span>

Now ask yourself:

- Sort by `id` → for DB writes
- Sort by `name` → for UI display
- Sort by `salary` → for reports
- Sort by `(salary desc, name asc)` → for HR dashboards

With `Comparable`, you get **ONLY ONE** `compareTo()`. This is the **core limitation** that `Comparator` solves.

<span style="color:green;font-weight:bold;">Common Use Cases:</span>

1. Sort integers in descending order

```java
Collections.sort(list, Comparator.reverseOrder);
```

2. Sort strings by length

```java
list.sort((a, b) -> a.length() - b.length());
```

3. Sort strings ignoring case

```java
list.sort(String::compareToIgnoreCase);
```

---

**Q6. Explain the difference between`Collections.sort()` <span style="color:indigo;font-weight:bold;">and</span> `List.sort()`.**

`List.sort()` is the modern, preferred way introduced in Java 8, while `Collections.sort()` is the older utility method.

| Method               | Introduced in |
| -------------------- | ------------- |
| `Collections.sort()` | Java 1.2      |
| `List.sort()`        | Java 8        |

Java 8 added **default methods** → allowed interfaces to evolve without breaking implementations.

---

**Q7. Build a custom sorting method that behaves like `Collections.sort()`.**

At a behavior level, `Collection.sort()`:

1. Sorts the list **in place**.
2. If a `Comparator` is provided, use it.
3. Else, use natural ordering (`Comparable`).

We’ll replicate **this behavior** (not Java’s internal TimSort).

```java
// Version 1: With Comparator
public static <T> void mySort(List<T> list, Comparator<? super T> comparator) {
	if (list == null || list.size <= 1) return;
	
	int n = list.size();
	
	for(int i=0; i<n-1; i++) {
		for(int j=i+1; j<n; j++) {
			T obj1 = list.get(i);
			T obj2 = list.get(j);
			
			int cmp;
			if(comparator != null) {
				cmp = comparator.compare(obj1, obj2);
			} else {
				// Use natural ordering
				Comparable<? super T> c1 = (Comparable<? super T>) obj1;
				cmp = c1.compareTo(obj2);
			}
			
			if(cmp > 0) {
				// swap
				list.set(i, obj2);
				list.set(j, obj1);
			}
		} 
	}
}
```

```java
// natural ordering only
public static void mySort(List<T> list) {
	mySort(list, null);
}
```

---

**Q8. Why does `Map` not extend `Collection`?**

**A.** Because `Map` store **key-value** pairs, not single elements.

---

**Q9. How `HashMap` lookup works internally?**

When you do:

```java
map.get(key);
```

Java does:

1. `hash(key)`
2. Find the **bucket index**
3. Traverse bucket (linked list / tree)
4. Match key using `equals()`

---

**Q10. What is `LinkedHashMap`**?

**A.** `LinkedHashMap` is a `HashMap` implementation that maintains a doubly-linked list of entries (along with a `HashTable`) to preserve insertion (default) or access order (optional), making it ideal for ordered maps and cache implementations like **LRU**.

**Key Insights:**

Each map entry stores **two extra references**:

```
before <-> current <-> after
```

So internally, every entry is:

```java
class Entry {
    K key;
    V value;
    Entry next;      // HashMap bucket chaining
    Entry before;    // LinkedHashMap order
    Entry after;     // LinkedHashMap order
}
```

This forms a **global doubly linked list** across all entries.

---

**Q11. How to implement LRU cache using `LinkedHashMap`?**

**LRU (Least Recently Used) Cache** is a fixed-size cache that **removes the least recently accessed item** when it runs out of space.

**Key Rules:**

1. Cache has a **maximum capacity**
2. `get(key)`:
    - If key exists → return value
    - Mark key as **most recently used**
3. `put(key, value)`:
    - Insert/update entry
    - If capacity exceeded → **evict least recently used**
- All operations must be **O(1)**

**Example:**

```
put(1) → [1]
put(2) → [1, 2]
put(3) → [1, 2, 3]
get(1) → [2, 3, 1]   // 1 is most recently used
put(4) → [3, 1, 4]   // 2 is evicted (least recently used)
```

**A.**

```java
class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private final int capacity;
	
	LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return size() > capacity;
	}
}
```

**Usage**

```java
LRUCache<Integer, String> cache = new LRUCache<>(3);
cache.put(1, "A");
cache.put(2, "B");
cache.put(3, "C");
cache.get(1);
cache.put(4, "D"); // evicts key 2
```

---

**Q12. What is `TreeMap`?**

**A.** `TreeMap` is a `Map` implementation that stores keys in a sorted order.

Order is based on:

1. Natural ordering (`Comparable`)
2. Custom ordering (`Comparator`)

**Key Insights:**

- Internally, `TreeMap` uses a **Red-Black Tree** (self-balancing BST).

|**Operation**|**Time**|
|---|---|
|get|O(log n)|
|put|O(log n)|
|remove|O(log n)|
|traversal|O(n)|

- No `null` keys. Tree needs to compare keys. `null` cannot be compared.

---

**Q13. What does `HashSet` works internally?**

**A.** `HashSet` is backed by a **`HashMap`** internally.

When you do:

```java
HashSet<String> set = new HashSet<>();
set.add("Java");
```

Java actually does something like:

```java
map.put("Java", PRESENT);
```

---

**Q14. How does `HashSet` ensure uniqueness?**

**A.** `HashSet` ensures uniqueness by first using `hashCode()` to locate a bucket and then uses `equals()` to check if an equal object already exists in that bucket.

**Key Rule:**

If two objects are equal according to `equals()`, they **MUST** have the same `hashCode()`.

---

**Q15. Can `HashSet` store `null` values?**

**A.** Yes, a `HashSet` can store one `null` value.

---

**Q16. What is `LinkedHashSet`?**

**A.** `LinkedHashSet` is a `Set` implementation that maintains insertion order while ensuring uniqueness.

**Key Insights:**

1. Allows one `null` value.

---

**Q17. How `LinkedHashSet` works internally?**

**A.** `LinkedHashSet` is internally backed by a `LinkedHashMap`.

---


**Q18. What is `TreeSet`?**

**A.** `TreeSet` is a `Set` implementation that stores elements in a sorted order and does not allow duplicates.

Order is based on:

1. Natural ordering (`Comparable`)
2. Custom ordering (`Comparator`)

Key Insights:

1. `TreeSet` is internally backed by `TreeMap`.
2. No `null` values allowed.

---



