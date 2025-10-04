
Optional was designed to avoid `null`.

Use Optional to represent "value may be absent" explicitly instead of returning null. 

**Benefits:** avoids `NullPointerException`, forces callers to handle the empty case (map/orElse/orElseThrow), fits JPA conventions (`findById` returns `Optional`), and makes code intention clear.



