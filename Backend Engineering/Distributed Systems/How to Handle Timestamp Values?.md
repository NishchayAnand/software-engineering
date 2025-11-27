
---
### What is Instant?

`Instant` represents a **single point on the timeline**, always in **UTC**.

```
2025-02-18T09:15:30Z
```

- “Z” == **Zulu/UTC**
- No offset
- No timezone
- No ambiguity
- It is _absolute_.

exact timestamp in UTC, machine-friendly

---
### OffsetDateTime

```
2025-02-18T14:45:00+05:30
```

This says:

- Local time: 2:45 PM
- Offset: +05:30
- Equivalent Instant: `2025-02-18T09:15Z`

timestamp + offset, human-friendly. Humans prefer reading this because it shows the local wall clock time _with context_.


---
### Use **`Instant`** when:

- You store timestamps in DB for backend logic.
- You compare timestamps.
- You calculate durations and expiries.
- You send timestamps between microservices.
- You don’t care about local timezone — just the moment.

**Payments, bookings, holds, expiries → use `Instant`.**

---
### Use **`OffsetDateTime`** when:

- You want to show the user the local time + offset.
- You want to preserve the original offset (important when users are global).
- You log events in a way humans can read.

Example: Storing when the user _saw_ a screen or submitted a form.

---
# Real-world example in your booking system

### Hold expiry time

→ use **Instant**

Because expiry needs accurate comparisons across services:

```
expiresAt: Instant
```

Payment service, reservation service — everyone compares the same UTC clock.

### Reservation confirmation timestamp

→ use **Instant**  
It’s a backend event.

---

### Showing booking time to customer

→ format the Instant into an `OffsetDateTime` based on customer timezone  
or  
convert to `ZonedDateTime`.

---

# ⭐ Database mapping

- Postgres `TIMESTAMPTZ` maps cleanly to **Instant** (recommended).
- It also maps to `OffsetDateTime`, but `Instant` avoids accidental timezone shifts.

Most distributed systems use:

```
DB: TIMESTAMPTZ  --> Java: Instant
```

---
### Memory trick
	
If the timestamp is meant for **machines**, use **Instant**.  
If it's meant for **humans**, use **OffsetDateTime**.

| Feature                       | `Instant` | `OffsetDateTime`     |
| ----------------------------- | --------- | -------------------- |
| Contains time?                | Yes       | Yes                  |
| Contains offset?              | ❌ No      | ✔️ Yes               |
| Always UTC?                   | ✔️ Yes    | ❌ No                 |
| Human-readable?               | Meh       | Yes                  |
| Best for DB storage           | ✔️ Yes    | Okay                 |
| Best for logs/UI              | Sometimes | ✔️ Yes               |
| Best for comparing timestamps | ✔️ Yes    | Okay but unnecessary |

---
