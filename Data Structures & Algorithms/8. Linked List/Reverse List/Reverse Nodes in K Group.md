
Link: [Leetcode 25](https://leetcode.com/problems/reverse-nodes-in-k-group/description/)

---
### Problem Statement

Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.

**Example**

**Input:** `head = [1,2,3,4,5], k = 2`

**Output:** `[2,1,4,3,5]`

![](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg)


---
### Metadata

**Difficulty:** #Hard

**Recently Asked in Companies:**

- **0 - 3 months**: #Google `9`, #Amazon `5`, #Microsoft `3`, #Bloomberg `2`

- **0 - 6 months**: #Meta `2`, #TikTok `2`, #Salesforce `2`

- **6 months ago**: #Adobe `9`, #Snowflake `8`, #Apple `5`, #Walmart `5`, #Tesla `4`, #Infosys `2`, #De-Shaw `2`

---
### General Observations

- <span style="color:red;">What is the range of </span> `k` <span style="color:red;">?</span>
- `k` is a positive integer and is less than or equal to the length of the linked list. <span style="color:purple;">This mean, there will always be at least one element in the linked list.</span>

- <span style="color:red;">What to do with the left over elements in case the number of nodes are not a multiple of</span> `k`?
- If the number of nodes is not a multiple of `k`then left-out nodes, in the end, **should remain as it is**.

- <span style="color:red;">Can we modify the values in the list's nodes?</span>
- **No,** you may not alter the values in the list's nodes, only nodes themselves may be changed.

---
### Basic Intuition

The problem statement also mentions that if there are `< k nodes` left in the linked list, then we don't have to reverse them. This implies that we first need to `count k nodes` before we get on with our reversal.

---
### Approach


**Algorithm**

**Time Complexity**

at least two traversals of the list overall. One for counting, and the next, for reversals.



