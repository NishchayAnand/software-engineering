
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

```
Example 2

Input: prices = [10,1,1,6] -> contains duplicate

Output: [9,0,1,6]

Explanation: 
	- For 10 → next smaller element is 1 → the final price is 10 - 1 = 9
	- For  1 → next smaller element is 1 → the final price is 1 - 1 = 0
	- For  1 → no next smaller element   → the final price is 1
	- For  6 → no next smaller element   → the final price is 6
```

---
### Brute Force Approach - Using Nested Loops

Use **nested loops**: `[i,j]` to iterate over each item at index: `i` and explore all items to its right (`j > i`) to find the first `prices[j] <= prices[i]`.

**Algorithm**

```
- answer = [] * n;
- for i in range [0, n):
	- answer[i] = prices[i];
	- for j in range [i+1, n):
		- prices[j] <= prices[i]: answer[i] = answer[i] - prices[j];
- return answer;
```

**Time Complexity**

In the worst-case scenario, i.e., when the `prices` array is sorted in ascending (increasing) order, none of the items will have a smaller or equally priced item to its right. As a result, <span style="color:green;">for each item</span> **`i`**<span style="color:green;">, we may end up scanning up to</span> **`n - i - 1`** <span style="color:green;">items to its right before concluding that no discount applies.</span>

Since, total operations performed in the worst-case scenario will be of the order **`n²`**, overall time complexity = **`O(n²)`** 

**Space Complexity**

No extra space is utilised. Hence, overall space complexity = **`O(1)`**.

---
### Optimisation

For every element in `prices`, we primarily want to find the <span style="color:red;background:#FAEBD7;font-weight:bold">first smaller element</span> to its **right**. Doing this by scanning right for each element takes **O(n²)** time. 

**Key Observation:** <span style="color:green;">Every element can serve as the <span style="color:red;background:#FAEBD7;font-weight:bold">next smaller element</span> for all the greater elements that appear <strong>before it</strong> in the array.</span> 

**Intuition:** As we iterate over `prices` array, we can use a data structure to efficiently track the unresolved elements waiting for a smaller value to appear. <span style="color:green;">When we encounter an element <strong>smaller than</strong> the <strong>most recent unresolved element</strong>, we know we've found the <strong>next smaller element</strong> for that <strong>top value</strong>. We can <strong>pop</strong> and map it accordingly, repeating this process until the top value is no longer smaller.</span>

This allows us to **pre-process** `prices` to find the <span style="color:red;background:#FAEBD7;font-weight:bold">next smaller element</span> for each of its element in a **single left-to-right pass**. 

---
### Optimised Approach - Using Stack

<span style="color:green;">Use a <strong>Stack</strong> to temporarily store the index of the <strong>unresolved elements (i.e., those still waiting to find their next smaller element)</strong>. This ensures that at any point in time, the stack only holds indexes of elements arranged in <strong>increasing order</strong>, each waiting for a next smaller number that hasn't appeared yet.</span>

> <span style="color:red;font-weight:bold">IMPORTANT: Need to store index in stack since input array contains duplicate integers. (revisit this)</span>

**Algorithm**

```
- answer = [] * n;
- NSE = get_next_smaller_element(prices);

- for i in range [0, n):
	- answer[i] = prices[i];
	- discount = NSE[i];
	- if discount != -1: answer[i] = answer[i] - discount;

- return answer;
```

```
function get_next_smaller_element(prices):
	- NSE = [] * n;
	- stack = [];

	- for i in range [0,n):
		- while stack is not empty and prices[stack.top()] >= prices[i]:
			- index = stack.pop();
			- NSE[index] = prices[i];
		- stack.push(i);

	- while stack is not empty:
		- index = stack.pop();
		- NSE[index] = -1;

	- return NSE;
```

**Time Complexity**

We are iterating over the `prices` array of length `n` to populate the `answer` array. 

Pre-processing `prices` to get the next smaller element for all `n` element ensures that each element is processed at most twice. 

Hence, overall time complexity = `O(n)`.

**Space Complexity**

The `NSE` map will store the next smaller element of all `n` elements.

In the worst-case scenario, i.e., when the `prices` array is sorted in ascending (increasing) order, the stack will hold at most `n` elements simulataneously. 

Hence, overall space complexity = `O(n)`.

---
### Java Implementation

```
public int[] finalPrices(int[] prices) {

	int n = prices.length;
	int[] answer = new int[n];

	int[] NSE = getNextSmallerElement(prices);
	for(int i=0; i<n; i++) {
		answer[i] = prices[i];
		int discount = NSE[i];
		if(discount != -1) answer[i] -= discount;
	}

	return answer;

}
```

```
private int[] getNextSmallerElement(int[] prices) {

	int n = prices.length;
	int[] NSE = new int[n];

	Stack<Integer> stack = new Stack<>();
	for(int i=0; i<n; i++) {
		while(!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
			int index = stack.pop();
			NSE[index] = prices[i];
		}
		stack.push(i);
	}

	while(!stack.isEmpty()) {
		int index = stack.pop();
		NSE[index] = -1;
	}

	return NSE;
	
}
```

---
