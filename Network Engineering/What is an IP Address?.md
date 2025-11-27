
A computer network is defined by a **block of IP addresses**. This block is written in **CIDR notation** (Classless Inter-Domain Routing), like `10.0.0.0/16`.

An **IP address** (Internet Protocol address) is a **unique identifier** assigned to a device on a network that uses the Internet Protocol (IP) to communicate.

---
### What is IPv4?

IPv4 addresses are **32-bit binary numbers**. For human readability, we split those 32 bits into **4 groups of 8 bits** (called **octets**).

Each octet is written in **decimal (0–255)**, separated by dots. So `a.b.c.d` = 8 bits + 8 bits + 8 bits + 8 bits = **32 bits total**.

**Example:**

```
10.0.0.0  = 00001010.00000000.00000000.00000000
```

---
### What is CIDR notation?

A CIDR block has **two parts**:

1. **Base IP address** → starting point
2. **Prefix length** (e.g., `/24`) → how many bits are fixed for the network

Example:

```
192.168.1.0/24
```

- `192.168.1` = network portion
- `/24` = first **24 bits** identify the network
- Last **8 bits** are for hosts → 2⁸ = **256 IPs**

---
### Limitations of IPv4

IPv4 addresses are 32-bit numbers, which allow for about 4.3 billion unique combinations. While that initially seemed sufficient, a significant portion of these addresses was reserved for private networks, multicast, and other special uses, reducing the pool of usable public addresses. 

With the rapid growth of the internet, driven by billions of computers, smartphones, and IoT devices, the available IPv4 space was quickly depleted. As a result, the world faced a shortage of unique IPv4 addresses, making it impossible to assign a globally unique public IP to every device.

---
### What is NAT?

To delay running out of IPv4 addresses, engineers introduced **NAT (Network Address Translation).

**How NAT works:**

- A **router** (at your home or company) has **one public IPv4 address**.
- Inside the private network, devices use **private IPs** (e.g., `192.168.x.x`).
- When a device sends traffic to the internet, NAT translates the **private IP** into the **router’s public IP**, and keeps a mapping table.
- When responses come back, NAT knows which internal device to forward to.

**Example:**

```
- Laptop: 192.168.1.2  
- Phone: 192.168.1.3   
- Router’s public IP: 203.0.113.25 

Both devices appear to the internet as 203.0.113.25, distinguished by different port numbers.
```

---
### What is IPv6?

NAT helped, but it was just a **patch**. The true solution is **IPv6**.

IPv6 has **128 bits** → **2¹²⁸ addresses** (~3.4 × 10³⁸). That’s enough for every grain of sand on Earth to have its own IP.

> **NOTE:** Every device can get a **unique, public, routable IP** — no NAT needed.

---
### Timeline Summary

1. **IPv4 designed (1980s)**: 4.3B addresses seemed infinite.
2. **Internet explodes (1990s–2000s)**: addresses running out.
3. **NAT widely adopted**: one public IP shared by many devices.
4. **IPv6 standardized (1998)**: enormous address space to future-proof the internet.
5. **Today (2025)**: IPv6 adoption is growing, but IPv4 + NAT is still dominant in many places.

---

