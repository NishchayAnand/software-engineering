
Optional was designed to avoid `null`.

Use Optional to represent "value may be absent" explicitly instead of returning null. 

**Benefits:** avoids `NullPointerException`, forces callers to handle the empty case (map/orElse/orElseThrow), fits JPA conventions (`findById` returns `Optional`), and makes code intention clear.

---
### **What is `Optional.map()`?**

`map()` applies a function to the value inside the `Optional` and returns a **new Optional** containing the transformed value.

---
### **What is `Optional.orElse()`?**

`orElse()` provides a **default value** to return if the `Optional` is **empty**.

It helps you **avoid `NullPointerException`** by ensuring that your code always has a valid value — either the one inside the `Optional`, or the default you specify.

---

