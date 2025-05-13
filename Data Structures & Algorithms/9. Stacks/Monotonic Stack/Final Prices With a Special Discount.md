
> Link: [Leetcode 1475](https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/)

---
### Problem Statement

You are given an integer array `prices` where `prices[i]` is the price of the `ith` item in a shop.

There is a special discount for items in the shop. If you buy the `ith` item, then you will receive a discount equivalent to `prices[j]` where `j` is the minimum index such that `j > i`and `prices[j] <= prices[i]`. Otherwise, you will not receive any discount at all.

Return an integer array `answer` where `answer[i]` is the final price you will pay for the `ith` item of the shop, considering the special discount.

---
### Metadata

**Difficulty:** #Easy 

**Recently Asked in Companies:** #Google `3`, #Microsoft `4`, #Meta `2`, #Amazon `2`

---
### Basic Intuition

The special discount on each item is equivalent to the <span style="color:red;background:#FAEBD7;font-weight:bold">next smaller or equal price</span> that appears after it (to its right) in the `prices` array.

```
Example 1

Input: prices = [8,4,6,2,3]

Output: [4,2,4,2,3]

Explanation: 
	- For 8 → next smaller element is 4 → the final price is 8 - 4 = 4
	- For 4 → next smaller element is 2 → the final price is 4 - 2 = 2
	- For 6 → next smaller element is 2 → the final price is 6 - 2 = 4
	- For 2 → no next smaller element   → the final price is 2
	- For 3 → no next smaller element   → the final price is 3
```

---
### Brute Force Approach - Using Nested Loops

Use **nested loops**: `[i,j]` to iterate over each item at index: `i` and explore all items to its right (`j > i`) to find the first `prices[j] <= prices[i]`.

**Algorithm**

```
answer = prices.clone();
- for i in range [0, n-2]:
	- for j in range [i+1, n-1]:
		- prices[j] <= prices[i]: answer[i] = answer[i] - prices[j];
- return answer;
```

**Time Complexity**

In the worst-case scenario, i.e., when the `prices` array is sorted in ascending (increasing) order, none of the items will have a smaller or equally priced item to its right. As a result, <span style="color:green;">for each item</span> **`i`**<span style="color:green;">, we may end up scanning up to</span> **`n - i - 1`** <span style="color:green;">items to its right before concluding that no discount applies.</span>

Since, total operations performed in the worst-case scenario will be of the order **`n²`**, overall time complexity = **`O(n²)`** 

**Space Complexity**

No extra space is utilised. Hence, overall space complexity = `O(1)`.

---
### Optimisations



---
### Optimised Approach - Using Stack

---
### Java Implementation

---
