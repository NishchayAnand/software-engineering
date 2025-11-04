
`encodeURIComponent()` is a built-in **JavaScript function** that encodes (or escapes) a string so it can be **safely used inside a URL**, particularly in a **query parameter**.

---
### Why do we need it?

URLs can only contain a limited set of characters safely. Certain characters have _special meanings_ in URLs. 

For example:

| Character | Meaning in URL          |
| --------- | ----------------------- |
| `?`       | Starts query string     |
| `&`       | Separates query params  |
| `=`       | Separates key and value |
| `/`       | Path separator          |
| `#`       | Fragment (anchor)       |

If you pass a user-input value like this:

```
const city = "New York";
const url = `https://example.com/search?city=${city}`;
```

You’ll get:

```
https://example.com/search?city=New York
```

❌ This is invalid because of the space — the browser will interpret it incorrectly or break it into multiple parts.

---
### Using `encodeURIComponent`

```
const city = "New York";
const url = `https://example.com/search?city=${encodeURIComponent(city)}`;
```

**Output:**

```
https://example.com/search?city=New%20York
```

✅ Now this is a **valid URL**.  
When the server receives it, it automatically decodes `%20` back into a space.

---
