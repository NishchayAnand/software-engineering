
A firewall is a security system—software, hardware, or both—that monitors and controls network traffic based on a set of rules. Its main job is to protect your system or network from unauthorized access, attacks, or data leaks.

---
### In Cloud (AWS)

Firewalls appear as:

- Security Groups (instance-level firewall)
- NACLs (subnet-level firewall)
- WAF (Web Application Firewall that protects websites)

| Feature         | Security Group  | NACL                    | WAF                   |
| --------------- | --------------- | ----------------------- | --------------------- |
| Layer           | Instance-level  | Subnet-level            | Application-level     |
| Stateful        | ✅ Yes           | ❌ No                    | N/A (rules-based)     |
| Controls        | Ports, IPs      | Ports, IPs              | HTTP/HTTPS content    |
| Blocks attacks? | No              | Limited                 | Yes (SQLi, XSS, bots) |
| Common use      | Protect EC2/RDS | Extra subnet protection | Protect websites/APIs |

---
### How a Firewall Works Internally?

A firewall works like a **checkpoint** for data entering or leaving a network. Internally, it does three main things:

<span style="color:green;font-weight:bold;">Packet Inspection (Check every data packet)</span>

Every piece of data traveling on a network is broken into **packets**.

For each packet, the firewall looks at:

- **Source IP** (where it's coming from)
- **Destination IP** (where it's going)
- **Source port**
- **Destination port**
- **Protocol** (TCP, UDP, ICMP)
- **Packet flags** (SYN, ACK, etc.)

This is called **packet filtering**.

🔥 Example rule:

```
Allow incoming traffic:
From: 10.0.0.5
To: 10.0.1.4
Port: 443
Protocol: TCP
```

Any packet that **doesn’t match** is blocked.

<span style="color:green;font-weight:bold;">Stateful Inspection (Track connections)</span>

Modern firewalls are **stateful**, meaning they maintain a **state table**.

> NOTE: State table is a record of **active, ongoing connections**.

Example entry:

```
ClientIP: 192.168.1.10
ServerIP: 34.120.20.8
Protocol: TCP
State: ESTABLISHED
```

<span style="color:green;font-weight:bold;">Rule Matching (Apply rules in order)</span>

The firewall has a **rule list**, usually processed top to bottom.

Example:

```
1. Allow port 443 from internal network
2. Allow port 22 only from admin IP
3. Deny all other traffic
```

The firewall checks each packet **against rules in order** and applies the first match.

<span style="color:green;font-weight:bold;">Deep Packet Inspection (Advanced firewalls)</span>

Next-Generation Firewalls (NGFW) do more:

- Inspect packet **content**, not just headers
- Detect malware, SQL injection, XSS
- Identify apps (e.g., WhatsApp, YouTube)
- Apply policies: allow/block/throttle

This is why NGFWs are used for modern security.

<span style="color:green;font-weight:bold;">Logging & Monitoring</span>

Every significant event is logged:

- Blocked packets
- Allowed traffic
- Suspicious patterns
- Intrusion attempts

Admins analyze this for security threats.

---
