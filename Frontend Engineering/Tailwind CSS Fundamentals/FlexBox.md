
To place an element at the **bottom** of a flexbox container, you have a few options depending on the layout you want:

### Use `margin-top: auto`

This is the simplest way when the container is a column flexbox:

```
<div class="flex flex-col h-64 border">
  <div>Top Content</div>
  <div class="mt-auto">Bottom Content</div>
</div>
```

- `flex flex-col` → makes items stack vertically.
- `mt-auto` → pushes the element down as far as possible inside the flex container.

---
