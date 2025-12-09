
A **CIDR block** defines the _range of IP addresses_ that your VPC can use.

---
### So what does **10.0.0.0/16** mean?

It defines the private IP address range:

```
10.0.0.0 → 10.0.255.255
```

**It contains** **65,536 total IP addresses**.

Reason:

- `/16` → first 16 bits are fixed (network portion)
- remaining 16 bits (host portion) give:  
    `2^16 = 65,536` IPs

So your VPC has **enough IPs to create many subnets, instances, databases, load balancers, containers**, etc.

---
### Why 10.x.x.x?

Because **10.x.x.x** is part of the **private IP ranges** (RFC1918):

```
10.0.0.0 – 10.255.255.255    (large block)
172.16.0.0 – 172.31.255.255  (medium)
192.168.0.0 – 192.168.255.255 (small/home networks)
```

AWS recommends starting with a large private range so you can divide it into subnets.

---
### Example subnetting inside 10.0.0.0/16

|Subnet|CIDR|Type|
|---|---|---|
|10.0.1.0/24|Public|For load balancer, bastion|
|10.0.2.0/24|Public|For NAT gateway|
|10.0.3.0/24|Private|For EC2/ECS services|
|10.0.4.0/24|Private|For databases (RDS)|

Each `/24` has **256 IPs**, plenty for typical use.

---
