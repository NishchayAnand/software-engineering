
A **subnet** (short for subnetwork) is a logical subdivision of a larger IP network.

When you create a network, you start with a **block of IP addresses** (like `10.0.0.0/16`). A subnet is a smaller slice of that block (e.g., `10.0.1.0/24`) that groups devices together. The **subnet mask** or **CIDR notation** (`/N`) tells you how big the subnet is and how many devices it can contain.

**Example:**

```
- VPC: 10.0.0.0/16 (65,536 IPs total)  
- Subnet 1: 10.0.1.0/24 → 256 addresses (for web servers)
- Subnet 2: 10.0.2.0/24 → 256 addresses (for databases)
```

---
### Private Subnet

---
### Public Subnet

