
In an HTTP response, the **Location** header is used to indicate the URL to which the client should be redirected. This header is commonly associated with responses that have status codes related to redirection, such as:

1. **301 (Moved Permanently):** The resource has been permanently moved to a new URL specified in the Location header.
2. **302 (Found):** The resource is temporarily located at a different URL.
3. **303 (See Other):** The client should retrieve the resource from another URL using a GET request.
4. **307 (Temporary Redirect) & 308 (Permanent Redirect):** These are stricter forms of 302 and 301, respectively, ensuring the HTTP method remains unchanged during the redirect.

**Example:**

```
HTTP/1.1 302 Found
Location: https://www.newwebsite.com/newpage
```

In this case, the client (like a browser) will automatically navigate to https://www.newwebsite.com/newpage.

> **NOTE:** The **Location** header can also be used in responses to a POST request to indicate the URL where the newly created resource can be accessed (commonly with status code **201 Created**).

---


  

