
Given an integer `columnNumber`, return its corresponding column title as it appears in an Excel sheet.

**Example**

```
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
```

---
### Intuition

In Excel, columns are labeled alphabetically from A to Z, then continuing with AA, AB, etc., after Z. This sequence creates a pattern similar to base-26 numeral system, except that it doesn't contain a zero and it starts from A (1) rather than zero (0).

In this pattern, `A` corresponds to 1, `B` to 2, and so on up to `Z` which corresponds to 26. Then, the sequence continues with two-letter combinations such as `AA` for 27, `AB` for 28, and so on. Unlike our decimal system, where the digit '0' represents zero and serves as a place-holder, there is no 'zero' character in the Excel column titles.

```
1 = (index of A) * pow(26,0)
```

```
701 = 26x26 + 25 = (index of Z) * pow(26,1) + (index of Y) * pow(26,0)
```

```
2002 = 2x26x26 + 25x26 + 0x26
```

---
### Approach - Using Iteration

---
### Approach - Using Recursion


---







