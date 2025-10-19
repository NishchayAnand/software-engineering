
---
**`merge(key, value, remappingFunction)`**

The method signature:

```
V merge(K key, V value, BiFunction<V, V, V> remappingFunction)
```

**Meaning:**

> “Insert `(key, value)` into the map, **but** if the key already exists, use the `remappingFunction` to decide which value to keep.”

**Explanation:**

If `hotelId` is already in the map, say with an old value `oldRate`, then:

```
(a, b) -> a.compareTo(b) <= 0 ? a : b
```

is called, where:

- `a` = **old value** (existing rate)
- `b` = **new value** (incoming `avgRate`)

The expression:

```
a.compareTo(b) <= 0 ? a : b
```

means:

> If the existing value `a` ≤ new value `b`, keep the smaller one (`a`); otherwise, replace it with the new value (`b`).

---
