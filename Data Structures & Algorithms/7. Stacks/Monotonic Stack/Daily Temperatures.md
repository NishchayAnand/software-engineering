
Link: [Leetcode 739](https://leetcode.com/problems/daily-temperatures/)

---
### Problem Statement

Given an array of integers: `temperatures` represents the daily temperatures, return an array: `answer` such that `answer[i]` is the **number of days you have to wait after the `ith` day** to get a warmer temperature. 

If there is no future day for which this is possible, keep `answer[i] == 0` instead.

---
### Metadata

**Difficulty:** #Medium

**Recently Asked in Companies:**

- **0 - 3 months:** #Amazon `11`, #Microsoft `5`, #Google `4`

- **0 - 6 months:** #Meta `3`, #Swiggy `2`, #Intuit `2`

- **6 months ago**: #Apple `11`, #Adobe `6`, #Uber `5`, #Walmart `4`, #JP-Morgan `3`, #Goldman-Sachs `3`, #Visa `3`

---
### General Observations

- <span style="color:red;">Can we have duplicate elements in input array?</span>
- **Yes**, the `temperatures` array can contain **duplicate elements**.

---
### Basic Intuition

<span style="color:green;">The next warmer temperature after the</span> `ith` <span style="color:green">day is equivalent to the <span style="color:red;background:#FAEBD7;font-weight:bold">next greater element</span> that appears after it (to its right) in the</span> `temperatures` <span style="color:green">array</span>.

```
Example 1

Input: temperatures = [73,74,75,71,69,72,76,73]
					    0  1  2  3  4  5  6  7 → indices

Output: [1,1,4,2,1,1,0,0]

Explanation:
	- For 73 → next greater element is 74 → number of days to wait → 1 - 0 = 1
	- For 74 → next greater element is 75 → number of days to wait → 2 - 1 = 1
	- For 75 → next greater element is 76 → number of days to wait → 6 - 2 = 4
	- For 71 → next greater element is 72 → number of days to wait → 5 - 3 = 2
	- For 69 → next greater element is 72 → number of days to wait → 5 - 4 = 1
	- For 72 → next greater element is 76 → number of days to wait → 6 - 5 = 1
	- For 76 → no next greater element    → number of days to wait → 0
	- For 73 → no next greater element    → number of days to wait → 0
```

---
### Brute Force Approach - Using Nested Loops

Use nested loops `[i,j]` to iterate over each element at `ith` index in the `temperatures` array and explore all elements to its right (`j > i`) to find the first `temperatures[j] > temperatures[i]`.

**Algorithm**

```
- output = [0] * n;
- for i in range [0, n):
	- for j in range [i+1, n):
		- if temperatures[j] > temperatures[i]:
			- output[i] = j - i;
- return output;
```

**Time Complexity**

In the worst-case scenario, i.e., when the `temperatures` array is sorted in descending (decreasing) order, the number of operations performed will be of the order `n²`. Hence, overall time complexity = **`O(n²)`** 

**Space Complexity**

No extra space is used by the algorithm. Hence, overall space complexity = `O(1)`.

---
### Time-Based Optimisation

For every element in `temperatures`, we primarily want to find the <span style="color:red;background:#FAEBD7;font-weight:bold">first greater element</span> to its **right**. Doing this by scanning right for each element takes **`O(n²)`** time. 

**Key Observation:** <span style="color:green;">Every element can serve as the potential <span style="color:red;background:#FAEBD7;font-weight:bold">next greater element</span> for all  smaller elements that appear <strong>before it</strong> in the array.</span>

**Intuition:** As we iterate over `temperatures` array, we can use a data structure to efficiently track of the indexes of the unresolved elements waiting for a greater value to appear. <span style="color:green;">When we encounter an element <strong>greater than</strong> the <strong>most recent unresolved element</strong>, we know we've found the <strong>next greater element</strong> for that <strong>top value</strong>. We can <strong>pop</strong> and map it accordingly, repeating this process until the top value is no longer smaller.</span>

---
### Optimized Approach - Using Stack

Use a **Stack** to temporarily **store** the **indexes of the unresolved elements waiting to find their next greater element**. 

> At any point in time, the stack only holds indexes of unresolved elements arranged in **descending (decreasing) order**, each waiting for a <span style="color:red;background:#FAEBD7;font-weight:bold">next greater element</span> that hasn't appeared yet.

**Algorithm**

```
- stack = [];
- output = [0] * n;
- for i in range [0, n):
	- while(stack is not empty and temperatures[i] > temperatures[stack.top()]):
		- index = stack.pop();
		- output[index] = i - index;
	- stack.push(i);
- return output;
```

**Time Complexity**

Each element in `temperatures` array will be processed at most twice. Hence, overall time complexity = **`O(n)`**.

**Space Complexity**

In the worst-case scenario, i.e., when the `temperatures` array is sorted in descending (decreasing) order, the stack will hold `n` elements simultaneously. Hence, overall space complexity = **`O(n)`**.

---
### Java Implementation

```
public int[] dailyTemperatures(int[] temperatures) {

	int n = temperatures.length;
	int[] output = new int[n];

	Stack<Integer> stack = new Stack<>();
	for(int i=0; i<n; i++) {
		while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
			int index = stack.pop();
			output[index] = i - index;
		}
		stack.push(i);
	}

	return output;

}
```

---
