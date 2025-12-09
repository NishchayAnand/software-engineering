
RDS Free Tier gives you **750 hours per month of _ONE_ t2.micro or db.t3.micro instance**. These 750 hours equal **one instance running full-time**. If you run **two instances**, you will _split_ the 750 hours — and you’ll **start getting charged** for the extra hours.

**Example:**

| Instances Running | Total hours used     | Free Tier covers | You pay for              |
| ----------------- | -------------------- | ---------------- | ------------------------ |
| 1 instance        | 720 hrs              | 720 hrs          | 0 hrs                    |
| 2 instances       | 720 + 720 = 1440 hrs | 750 hrs          | **690 hrs** (chargeable) |

---
### What is a DB instance?

A DB instance is an isolated database environment running in the cloud. It is the basic building block of Amazon RDS. 

A DB instance can contain multiple user-created databases, and can be accessed using the same client tools and applications you might use to access a standalone database instance.