
The system consists of three primary services (APIs):

---
### Data Flow

---
### Network Protocol - REST vs GraphQL

When different clients (e.g., browser, mobile) need different content from same API, we often need to share extra data which may be relevant or one client but not for the other.

GraphQL allows us to fetch different set of fields from a single endpoint. 

should be selected based on the type of queries. 

---
### Shortening Service

Handles user requests to create short URLs.

```
public String shortenUrl(String longUrl) {

	// Check if URL already exists in DB
	UrlMapping existing = urlMappingRepository.findByLongUrl(longUrl); 
	if (existing != null) return existing.getShortUrl(); 
	
	// Call Encoding Service to generate uniqueID 
	String shortId =encodingService.generateShortId(); 
	
	// Create Short URL 
	String shortUrl = "https://tinyurl.com/" + shortId; 
	
	// Save mapping 
	urlRepository.save(new UrlMapping(shortId, longUrl)); 
	
	return shortUrl;
	
}
```

---
### Encoding Service (Internal)

The service must implement a functionality that could encode every incoming long URL to a **unique short ID**.

Using a **hash function (e.g., SHA-256) to encode long URLs** can lead to **collisions** if multiple people try to encode the same long URL. To avoid such collisions, we can use a **unique ID generator** to assign a unique numeric ID to each incoming long URL.

<span style="color : red"><strong>Assumption:</strong> Considering that the system processes an average of <strong>10 million URL generation requests per day</strong> and is expected to operate for <strong>10 years</strong>, the total number of URLs generated over its lifetime would be: <strong>10 million × 365 days × 10 years = 36.5 billion ≈ 40 billion URLs</strong>.</span>

The service must be capable of generating **40 billion unique short IDs** without collisions.

<span style="color : red"><strong>Assumption:</strong> Each short ID consists of characters from <strong>[0-9, a-z, A-Z]</strong>, containing 10 + 26 + 26 = 62 possible characters. Considering 62<sup>6</sup> = 56 Billion, a <strong>6-character long Base-62 ID</strong> must be enough to accommodate all URL shortening requests over the system's lifetime.</span>

<span style="color : LightSkyBlue">Q. How to generate 6 character long unique Base-62 IDs in a distributed system?</span>

<span style="color : green">The service can act as a <strong>centralised authority</strong> responsible for generating <strong>unique, sequentially increasing IDs</strong> and then converting those numeric IDs into a <strong>Base-62 encoded string</strong>.</span>

```
public String generateShortId() {
    long id = counter.getAndIncrement(); // Get the next sequential ID
    return toBase62(id);
}
```

<span style="color : LightSkyBlue">Using a single <strong>centralised ID generator</strong> can become a bottleneck under high traffic.</span>

<span style="color : LightSkyBlue">We can use <strong>multiple ID generators</strong> with unique ID prefixes (e.g., timestamp + machine ID + counter) to allow horizontal scaling. However, adding extra components (like machine ID and timestamp) increases the <strong>length of the short ID</strong>, which may reduce the compactness of the shortened URLs.</span>

<span style="color : green">To eliminate this, we can use a coordination service (e.g., ZooKeeper) to pre-allocate <strong>ID ranges</strong> to each machine (e.g., Machine 1 → 1 to 1M, Machine 2 → 1M+1 to 2M, etc.). This ensures each machine generates IDs from its assigned range <strong>without conflicts</strong>.</span>

---
### Redirection Service 

Resolves short URLs to their original long URLs.

```
public String getLongUrl(String shortId) {
    return urlMappingRepository.findById(shortId).getLongUrl()
}
```

> **NOTE:** The redirection service can implement **caching (Redis)** to optimise performance and reduce database lookups.

---
