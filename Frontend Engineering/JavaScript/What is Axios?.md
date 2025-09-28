
- Extra dependency: Needs installation (npm install axios).
    
- Browser + Node.js: Works both client-side and server-side.
    
- Automatic JSON parsing: Response data is automatically transformed to JSON (if applicable).
    
- Error handling: Automatically rejects promises for HTTP error statuses (4xx, 5xx).
    
- Request cancellation: Supports cancellation via CancelToken (and AbortController in v1+).
    
- Interceptors: Lets you hook into requests/responses for logging, auth headers, retries, etc.
    
- Request/response transformation: Easier to customize payloads.
    
- Wide adoption: Rich ecosystem and community support.

```
import axios from "axios";

axios.get("https://api.example.com/data")
  .then(response => console.log(response.data))
  .catch(error => console.error(error));
```

