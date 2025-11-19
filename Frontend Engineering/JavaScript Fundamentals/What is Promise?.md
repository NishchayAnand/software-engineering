
---

The function you pass to `new Promise((resolve, reject) => {...})` is called the executor function. It gets two callbacks:

- **resolve(value?)** → when `resolve()` is called, the `Promise` transitions from pending → fulfilled.
- **reject(error)** → mark the `Promise` as rejected.

The `Promise` starts in the **pending** state and can go to **fulfilled** or **rejected**, exactly once.

---

<span style="color:red;">Q. Explain the working of below mentioned code.</span>

```
const loadRazorpay = () => new Promise<void>((resolve, reject) => {
	if ((window as any).Razorpay) return resolve();
	const script = document.createElement("script");
	script.src = "https://checkout.razorpay.com/v1/checkout.js";
	script.async = true;
	script.onload = () => resolve();
	script.onerror = () => reject(new Error("Failed to load Razorpay checkout
																	 script"));	
	document.body.appendChild(script);
});

await loadRazorpay();
```

So the timeline is:

1. Promise created → pending.
2. Script is added to DOM, browser starts fetching it.
3. Later:
    
    - If successful → `script.onload` runs → `resolve()` → Promise becomes fulfilled.
    - If failed → `script.onerror` runs → `reject(error)` → Promise becomes rejected.

Any `await loadRazorpay()` or `loadRazorpay().then(...).catch(...)` will react at this point.

---


