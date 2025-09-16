
A double or float in Java is stored as binary floating point (base-2). Many decimal fractions that look simple to us cannot be exactly represented in base-2.

Example:

- 0.1 in decimal is 1/10.
- In binary, 1/10 is a repeating fraction (like 1/3 in decimal).
- So 0.1 becomes something like:

```
0.00011001100110011... (repeating in binary)
```

When stored in a 64-bit double, it gets cut off (truncated), so you only get an approximation.

---

When you do arithmetic with approximations, the errors accumulate.

```
double d = 0.1 + 0.2;
System.out.println(d); 
// 0.30000000000000004
```

Humans expect exactly 0.3, but the computer gives a very close approximation (0.30000000000000004). This happens because neither 0.1 nor 0.2 can be exactly stored in binary floating point.

---

BigDecimal stores numbers in decimal (base-10) representation, not binary. For example, `new BigDecimal("0.1")` really is exactly `0.1`.

```
BigDecimal a = new BigDecimal("0.1");
BigDecimal b = new BigDecimal("0.2");
System.out.println(a.add(b)); 
// 0.3
```

---

