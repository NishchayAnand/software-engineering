
When you give an element `position: relative`, two things happen:

1. **It stays in the normal document flow** (unlike `absolute`, which removes the element from flow).
2. You can move it relative to **its own normal position** using `top`, `right`, `bottom`, `left`.

> **NOTE:** Without offsets (`top`, `left`, etc.), a `relative` element looks the same as `static` (default).

**Example**

```
.element {
  position: relative;
  top: 20px;
  left: 10px;
}
```

This moves the element **20px down** and **10px right** from where it would normally be. The original space it occupied is still preserved (other elements don’t shift into its place).

