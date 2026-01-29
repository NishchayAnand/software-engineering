
**Q1. Explain the thread lifecycle.**

A thread starts in the `NEW` state, moves to `RUNNABLE` after `start()`, where it may be running or ready. 

It can enter `BLOCKED` when waiting for a lock, `WAITING` or `TIMED_WAITING` when paused explicitly, and finally reaches `TERMINATED` when execution completes. 

**State Transition Summary**

|**Action**|**From**|**To**|
|---|---|---|
|new Thread()|—|NEW|
|start()|NEW|RUNNABLE|
|Scheduler picks|RUNNABLE|(running)|
|Lock unavailable|RUNNABLE|BLOCKED|
|wait()|RUNNABLE|WAITING|
|sleep()|RUNNABLE|TIMED_WAITING|
|notify()|WAITING|RUNNABLE|
|run() ends|RUNNABLE|TERMINATED|

---

**Q. What is `ConcurrentHashMap`?**

**A.** `ConcurrentHashMap` is a thread-safe `Map` implementation that allows multiple threads to read and write concurrently without locking the entire map.

---

**Q. How `ConcurrentHashMap` works internally?**

**A.** 

- Reads -> Lock-free

```java
map.get(key); // no lock
```

- Writes -> Bucket-level locking. Other threads can modify other buckets simultaneously.

```java
map.put(key, value); // locks only one bucket
```

---

**Q. You are given the below code snippet.**

```java
Map<Integer, String> map = new ConcurrentHashMap<>();

Runnable writer = () -> {
	for (int i = 0; i < 5; i++) {
		map.put(i, "Value - " + i);
	} 
};

Runnable reader = () -> {
	for (int i=0; i<5; i++) {
		System.out.println(map.get(i));
	}
};

new Thread(writer).start();
new Thread(reader).start();
```

**One of the execution printed all `null` values. Explain the issue and suggest a possible fix.**

```
null
null
null
null
null
```

**A.** There is no guarantee which thread runs first. Possible execution order:

```
Reader runs first → map is empty → map.get(i) returns null
Writer runs later → values are inserted
```

Use `Thread.join()` to ensure `writer` finishes before `reader` starts.

```java
Thread writerThread = new Thread(writer);
Thread readerThread = new Thread(reader);

writerThread.start();
try {
	// main thread waits while writerThread finishes execution
	writerThread.join();
} catch (InterruptedException e) {
	System.out.println("Main thread was interrupted while waiting");
}
readerThread.start();
```

---

**Q. Explain the problem with the below code when working in multithreaded environment. Suggest a fix to resolve that issue.**

```java
if( !map.containsKey(k) ) {
	map.put(k, v);
}
```

**A.** The code represent the very common **"insert only if missing"** use case and can lead to race condition in a multithreaded environment.

**Assume:**

- `map` is a `ConcurrentHashMap`.
- Two threads: **Thread A** and **Thread B** both execute this code at the same time.

**Timeline (Race Condition)**:

- Step 1: Thread A checks

```java
map.containsKey(k) // returns false
```

- Step 2: Context switch happens
- Step 3: Thread B checks

```java
map.containsKey(k) // also returns false
```

- Step 4: Thread B inserts

```java
map.put(k, v);
```

- Step 5: Context switch again
- Step 6: Thread A inserts

```java
map.put(k, v);
```

Both threads executed `put()` violating the "insert only if absent" logic. This is called the **check-then-act** race condition.

This exact bug is one of the main reasons Java 8 added `putIfAbsent` method. This turned the multi-step unsafe logic into single-step atomic operation.

```java
map.putIfAbsent(k, v);
```

---

**Q. How `putIfAbsent()` works internally?**

When you call:

```java
map.putIfAbsent(key, value);
```

Internally, `ConcurrentHashMap` does roughly this:

1. **Locate the bucket** using the key's hash
2. **Lock only the bucket** (not the whole map)
3. Check if the key exists
4. If absent -> insert value
5. Release the lock

Other threads:

- Can still read freely
- Can write to **other buckets** at the same time

---

**Q. Explain the problem with the below code when working in multithreaded environment. Suggest a fix to resolve that issue.**

```java
List<String> list = map.get(key); // ConcurrentHashMap
if (list == null) {
	list = new ArrayList<>();
	map.put(key, list);
}
list.add(value);
```

**A.** The code represents the very common **"lazy initialization"** use case and can lead to race condition in a multithreaded environment.

Assume:

- `map` is a `ConcurrentHashMap`.
- Two threads: **Thread A** and **Thread B** both execute this code at the same time.

**Timeline (Race Condition)**:

- Step 1: Thread A checks

```java
map.get(k) // returns null
```

- Step 2: Context switch happens
- Step 3: Thread B checks

```java
map.get(k) // also returns null
```

- Step 4: Thread B creates ArrayList, puts into `map` and adds a value

```java
list = new ArrayList<>();
map.put(key, list);

list.add(value);
```

- Step 5: Context switch again
- Step 6: Thread A re-creates ArrayList, puts into `map` and adds another value.

```java
list = new ArrayList<>();
map.put(key, list);

list.add(value);
```

Both threads executed `put()` violating the "insert only if absent" logic. This is called the **check-then-act** race condition.

This exact bug is one of the main reasons Java 8 added `computeIfAbsent` method. This turned the multi-step unsafe logic into single-step atomic operation.

```java
map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
```

The lambda `k -> new ArrayList<>()` is executed only if the key is missing. This prevents multiple threads from creating multiple lists.

---

**Q. Explain the problem with the below code when working in multithreaded environment. Suggest a fix to resolve that issue.**

```java
Integer val = map.get(k);
map.put(k, val == null ? 1 : val + 1);
```

A. `get()` and `put()` are two separate operations. Two threads can interleave between them, leading to **check-then-act** race condition.

We can use `compute()` method introduced in Java 8 to turn this multi-step logic in a single-step atomic operation.

```java
map.compute(key, (k, v) -> v == null ? 1 : val + 1 );
```

---

**Q. Explain the difference between `map.compute()` and `map.computeIfAbsent()`.**

**A.** 

`compute()`:

- Always recomputes the value for a key, whether the key exists or not.

```java
map.compute(key, (k, oldValue) -> newValue);

// Example
map.compute("A", (k, v) -> v == null ? 1 : v + 1);

// Intialize if absent
// Increment if present
```

`computeIfAbsent`


---

**Q. Explain the difference between Fail-Fast and Fail-Safe.**

**A.** **Fail-Fast** and **Fail-Safe** describe how iterators behave when a collection is modified during iteration.

**Fail-Fast Iterators:** 

- A fail-fast iterator immediately throws a `ConcurrentModificationException` if the collection is structurally modified while iterating (except through the iterator's own `remove()` method). 
- Common examples include: `ArrayList`, `HashMap`, `HashSet`, `LinkedList`.

```java
List<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);

Iterator<Integer> it = list.iterator();
while(it.hasNext()) {
	Integer val = it.next();
	if (val == 1) {
		list.add(3); // ❌ Structural modification
	}
}
```

**Fail-Safe Iterators**:

- A fail-safe iterator does not throw an exception if the collection is modified during iteration.
- Iterates over a **copy (snapshot)** of the collection.
- Common examples include: `CopyOnWriteArrayList`, `CopyOnWriteArraySet`, `ConcurrentHashMap`.

---

**Q. Explain the output of the below code.**

```java
List<Integer> list = new CopyOnWriteArrayList<>();
list.add(1);
list.add(2);

for (Integer val : list) {
	System.out.println(val);
    if (val == 1) list.add(3); // ✅ Safe
}
```

**A.** When the for-each loop starts, the iterator takes a **snapshot copy** of the list.

**Output (Initial snapshot):**

```
[1, 2]
```

---






