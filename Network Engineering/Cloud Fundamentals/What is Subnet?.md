
A **subnet** (short for subnetwork) is a smaller, logical subdivision of a larger network.

In the context of **cloud (like AWS VPCs)** or traditional networking:

- A **network** is identified by an **IP address range** (for example, `10.0.0.0/16`).
- That large block of IP addresses can be split into **subnets**, each with its own smaller range (for example, `10.0.1.0/24` or `10.0.2.0/24`).

---
### Private Subnet

A **private subnet** does **not** have a route to the Internet Gateway.

---
### Public Subnet

A **public subnet** is a subnet that has a direct route to the **Internet Gateway (IGW)** of your VPC.

---
### Putting it Together

Imagine a **2-tier architecture** in AWS:

- **Public subnet (`10.0.1.0/24`)** → hosts web servers that serve traffic from the internet.
- **Private subnet (`10.0.2.0/24`)** → hosts a database that only the web servers can talk to, never exposed publicly.

This setup gives you **security (private subnet)** + **internet accessibility (public subnet)** while keeping the architecture organized.

---

