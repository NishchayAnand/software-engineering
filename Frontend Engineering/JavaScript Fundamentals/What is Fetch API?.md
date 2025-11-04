
- Native: Available in modern browsers by default (no extra installation).
    
- Promise-based: Returns a Promise for network requests.
    
- Basic syntax: Simple for straightforward requests.
    
- Response handling: You must explicitly call .json() or .text() on the response.
    
- Error handling: Only rejects on network failure; HTTP errors like 404 or 500 don’t throw automatically—you need to check response.ok.
    
- No request cancellation: Uses AbortController (extra setup).
    
- Limited support: Older browsers need polyfills.
    
- Default JSON handling: No automatic transform; you handle it manually.

```
fetch("https://api.example.com/data")
  .then(response => {
    if (!response.ok) throw new Error("Network error");
    return response.json();
  })
  .then(data => console.log(data))
  .catch(err => console.error(err));
```

