
Both Fetch and Axios return Promises, so you can use async/await with either. The difference shows up in error handling and response parsing.

----
### Using Fetch with async/await

```
async function getData() {
  try {
    const response = await fetch("https://api.example.com/data");

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();  // must explicitly parse
    console.log(data);
  } catch (error) {
    console.error("Fetch error:", error);
  }
}
```

Key things:

- Must manually check response.ok (otherwise 404/500 won’t throw).
- Must explicitly call .json() (or .text() / .blob()).

---
### Using Axios with async/await

```
import axios from "axios";

async function getData() {
  try {
    const response = await axios.get("https://api.example.com/data");
    console.log(response.data);  // auto-parsed JSON
  } catch (error) {
    if (error.response) {
      // Server responded with a non-2xx status
      console.error("Axios error:", error.response.status, error.response.data);
    } else {
      // Network error or something else
      console.error("Axios error:", error.message);
    }
  }
}
```

- Axios automatically rejects for 4xx/5xx → no need for response.ok.
- **JSON is auto-parsed into response.data.**
- Error object is richer (error.response, error.request, etc.).

---
