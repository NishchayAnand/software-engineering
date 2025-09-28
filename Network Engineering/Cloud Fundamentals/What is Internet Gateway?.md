
An **Internet Gateway (IGW)** is a **managed networking component** in a cloud VPC (like AWS) that allows communication **between resources in your VPC and the public internet**.

Think of it as the **main door** that connects your private virtual network to the outside world.

---
### Key Points

- Each VPC can have **only one IGW** attached at a time.
- Without an IGW, even if your subnet has public IPs, those resources **cannot connect to the internet**.

---
### Analogy

If your **VPC is a house**, subnets are the **rooms**, and the **Internet Gateway is the front door**.

- If a room (subnet) has a door to the outside (a route to IGW + public IP), people can come and go.
- If it doesn’t, it’s private and isolated.

---
