
Link: [Leetcode 735](https://leetcode.com/problems/asteroid-collision/description/)

---
### Problem Statement

We are given an array: `asteroids` of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the **absolute value represents its size**, and the **sign represents its direction (positive meaning right, negative meaning left)**. Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. **If two asteroids meet, the smaller one will explode. If both are the same size, both will explode**. Two asteroids moving in the same direction will never meet.

---
### Metadata

**Difficulty:** #Medium

**Recently Asked in Companies:**

- **0 - 3 months:** #Amazon `12`, #Dream11 `4`, #Google `3`, #Goldman-Sachs `2`, #Nvidia `2`, #PayPal `2`, #OpenAI `2`

- **0 - 6 months:** #Meta `5`, #Microsoft `4`, #PhonePe `2`

- **6 months ago:** #Oracle `15`, #TikTok `13`, #Apple `9`, #Flipkart `8`, #Adobe `8`, #Uber `4`

---
### Basic Intuition

Collisions happen when a **right-moving asteroid** meets a **left-moving asteroid**. 

<span style="color:green;">We need a data structure to keep track of the <strong>right-moving asteroids</strong> in the correct order so that when a <strong>left-moving asteroid</strong> is encountered, we can efficiently <strong>resolve collisions</strong> by comparing it with all the <strong>unresolved right-moving asteroids</strong>.</span>

---
### General Observations

---
### Brute Force Approach 

---
### Optimisations

---
### Optimised Approach

---
### Java Implementation

---


