
Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

**Link:** [Leetcode 268](https://leetcode.com/problems/missing-number/description/) 

**Difficulty:** #Easy 

**Recently Asked in Companies:** #Amazon `11`, #Google `7`, #Meta `2`, #Apple `2`, #Microsoft `2`, #Goldman-Sachs `2`, #Adobe `11`, #Uber  `3`. 

---
### General Observations

- Is it possible for the input array to be empty?
- **No**, the input array will never be empty (i.e., `n ≥ 1`).

- Can we assume the input array is sorted?
- **No**, the array is not guaranteed to be sorted.

---
### Intuition

There are `n+1` numbers in the range: `[0,n]`. 

Since, `nums` is supposed to contain only `n` numbers from the range: `[0,n]`, there will be exactly one number from the range: `[0,n]` missing in `nums`.

**Example 1**

```
Input: nums = [3,0,1]

Output: 2

Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```

---
### Brute Force Approach - Sort the Input Array

<span style="color:green;">An ordered array (sorted in ascending order) containing numbers in the range:</span> `[0,n]` <span style="color:green;">must satisfy the condition</span> `nums[i] == i` <span style="color:green;">for all valid indices.</span>

Since one number is missing in `nums` from the range `[0, n]`, after sorting `nums` in ascending order, there will be exactly one index `i` where `nums[i] != i`. That index `i` will be the missing number.

> **NOTE:** If all indices satisfy `nums[i] == i`, then the missing number must be `n` (i.e., the last number in the range).

**Algorithm**

```

```

**Time Complexity**

**Space Complexity**

**Java Implementation**

```

```

---
### Approach - Sum Difference

**Algorithm**

```

```

**Time Complexity**

**Space Complexity**

---
### Approach - XOR

**Algorithm**

```

```

**Time Complexity**

**Space Complexity**

**Java Implementation**

```

```

---









