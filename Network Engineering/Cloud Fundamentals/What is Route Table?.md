
A **route table** is a set of rules that tells your network **where to send traffic**. 

Every **subnet** in a VPC must be associated with a route table. The route table determines how network packets leaving that subnet are forwarded (e.g., to another subnet, to the internet, to a VPN, etc.).

> **NOTE:** Think of it as the **GPS for your data**: it decides the “next hop” for any packet based on the destination IP.

---
### Key Points

Route tables enable you to create complex networking architectures that include public subnets, private subnets, VPN-only subnets, and isolated subnets. They allow granular control over which subnets or devices communicate with each other and how external connectivity is managed.

When a device receives a packet, it checks the destination IP and refers to its routing table to determine the best route; if none is available, it uses the default route.
