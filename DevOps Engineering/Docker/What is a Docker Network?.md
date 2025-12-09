
A **docker network** is a **virtual network** that allows containers to:

✅ Talk to each other  
✅ Expose services to the host  
✅ Be isolated from other containers  
✅ Have their own IP addresses and DNS

Think of it as:

> **A private WiFi network for your containers**.

---
### Types of Docker Networks (Very Important)

**bridge** (MOST USED – default): This is what **docker-compose uses by default**

- Private internal network
- Containers can talk to each other
- Host can access via exposed ports
- DNS-based service discovery works

**host** (No isolation): Container shares the **host’s network directly**

- No virtual networking
- Same IP as host
- Faster but insecure
- Ports can clash

---
### Docker DNS (This is the Magic)

In a **user-defined bridge network**, Docker runs an **internal DNS server**.

So if you define:

```
services:
  hotel-service:
  booking-service:
```

Docker automatically resolves:

```
hotel-service → 172.18.0.4
booking-service → 172.18.0.5
```

So booking-service can call:

```
http://hotel-service:8080 ✅
```

---
### What does `127.0.0.1` actually mean?

`127.0.0.1` = **localhost** = **this machine only**

Inside a container:

- `127.0.0.1` means **that container itself**
- It does **NOT** mean:
    - Your laptop
    - Another container
    - Another EC2 instance

So if your Spring Boot app is bound to:

```
server:
  address: 127.0.0.1
  port: 8081
```

Then ONLY this will work:

```
curl http://localhost:8081   ✅ (from inside same container)
```

But this will FAIL:

```
curl http://service-b:8081   ❌ (from another container)
```

Because the app is **not listening on the container’s network interface**, only on its internal loopback.

---
