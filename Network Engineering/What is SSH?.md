
**SSH (Secure Shell)** is a _secure network protocol_ that lets you connect to another computer or server over the internet **safely and remotely**.

SSH encrypts all communication using strong cryptography.

This means:

- No one can read your password
- No one can see the data you send
- No one can see the commands you run

Even if someone captures the network traffic, it will be useless because it's encrypted.

---
### What is SSH Tunneling?

SSH tunneling (also called SSH port forwarding) is a technique where you create a **secure encrypted tunnel** between your machine and a remote server using SSH.

It allows you to access **private resources** (like RDS, Redis, internal APIs, admin dashboards) that are **NOT publicly accessible**.

---
### Why do we need SSH tunneling?

Because AWS RDS or other cloud resources often run in **private subnets** and **cannot be accessed publicly** for security reasons.

SSH tunneling solves this by routing your traffic over an encrypted SSH connection through a bastion host (EC2 machine).

**Example:**

```
localhost:5432  →  EC2 (tunnel)  →  RDS:5432
```

---
### How SSH tunneling is used with AWS RDS?

You usually have:

- **EC2 in public subnet** → can be accessed via SSH
- **RDS in private subnet** → cannot be accessed directly

So you create the tunnel:

```
ssh -i key.pem -L 5432:<rds-endpoint>:5432 ec2-user@<ec2-public-ip>
```

**Meaning:**

- Your local port `5432` is forwarded
- To the RDS port `5432`
- Through the EC2 machine

---

