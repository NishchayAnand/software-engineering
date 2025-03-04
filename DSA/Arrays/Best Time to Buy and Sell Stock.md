## Problem Statement

Given an array `prices` where `prices[i]` represents the price of a given stock on the i<sup>th</sup> day, return the maximum profit one can make by doing a single transaction. 

NOTE: If you cannot make any profit, return `0`.

---
## Basic Intuition

The problem involves exploring all pairs of prices  `(prices[i], prices[j]) where i<=j & prices[i] <= prices[j]` and keeping track of the maximum profit (`prices[j] - prices[i]`).

---
## Brute Force Approach - Nested Loop

Use a nested loop `[i, j]` to iterate over all valid pairs of prices and keep track of the maximum profit.

#### Algorithm

- let `maxProfit = 0`; 
- loop from `i = [0, n)` to iterate over all buying days:
	- loop from `j = [i, n)` to iterate over all selling days considering the stock is bought on the i<sup>th</sup> day:
		- `maxProfit = max(maxProfit, prices[j] - prices[i])`;
-  return `maxProfit`;

#### Time Complexity Analysis

We will explore all n<sup>2</sup> pairs. Thus, total time complexity is O(n<sup>2</sup>).

#### Space Complexity Analysis

No extra space has been used. Thus, total space complexity is O(1).

#### Redundant Operations

If we decide to sell on the j<sup>th</sup> day, we don't need need to explore all days in the range [0:j] where we can buy the stock. 

We should be able to generate the maximum profit by selling at prices[j] if we buy at the minimum prices[i] in the range [0:j].

---
## Sliding Window Approach - Greedy











