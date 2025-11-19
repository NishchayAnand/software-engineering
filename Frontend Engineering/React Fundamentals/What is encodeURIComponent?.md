
It's a built-in JavaScript function that **safely encodes text** so it can be used inside a URL.

Think of it like:  
**“Turn any messy text (spaces, ?, &, =) into URL-safe characters.”**

---
### Do we need to decode `encodeURIComponent` on the API side?

**Most of the time → NO.**  
Your backend framework **automatically decodes URL parameters** for you.

```
const city = "New York";
const url = `/search?city=${encodeURIComponent(city)}`;
```

Spring automatically decodes:

```
@GetMapping("/search")
public String search(@RequestParam String city) {
    System.out.println(city); // "New York"
}
```

---
