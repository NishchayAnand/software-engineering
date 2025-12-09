
Inbound and outbound rules are part of **Security Groups** and **Network ACLs (NACLs)** in AWS.  
They control _traffic flow_ into and out of your AWS resources (EC2, RDS, ECS tasks, etc.)

Think of them as **firewalls** that protect your infrastructure.

---
### Inbound Rules

These define **what traffic is allowed _into_** your resource.

Example inbound rules:

| Type       | Port | Source           | Meaning                                         |
| ---------- | ---- | ---------------- | ----------------------------------------------- |
| HTTP       | 80   | 0.0.0.0/0        | Allow anyone on the internet to access your app |
| HTTPS      | 443  | 0.0.0.0/0        | Allow global HTTPS traffic                      |
| Custom TCP | 5432 | SG of app server | Allow only app service to access database       |
| SSH        | 22   | Your IP          | Only you can SSH into EC2                       |
**If no inbound rule allows traffic, nothing can enter.**

---
### Outbound Rules

These define **what traffic your instance is allowed to send OUT**.
	
Example outbound rules:

|Port|Destination|Meaning|
|---|---|---|
|ALL|0.0.0.0/0|Instance can reach internet (typical default)|
|3306|DB subnet|EC2 can talk to MySQL database|
|443|API endpoints|EC2/ECS can call external APIs, Razorpay, etc.|

**If an outbound rule blocks a destination, your instance cannot reach it.**

---

