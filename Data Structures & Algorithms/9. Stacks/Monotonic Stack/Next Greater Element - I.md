
> Link: [Leetcode 496](https://leetcode.com/problems/next-greater-element-i/)

---
### Problem Statement

Given two **distinct integer arrays** `nums1`and `nums2`, where `nums1` is a subset of `nums2`. 

For each `0 <= i < nums1.length`, find the index `j` such that `nums1[i] == nums2[j]` and determine the <span style="color:red;background:#FAEBD7;font-weight:bold">next greater element</span> of `nums2[j]` in `nums2`. If there is no next greater element, return `-1`.

> **NOTE:** The **next greater element** of some element `x` in an array is the **first greater** element that is **to the right** of `x` in the same array.

```
Example 1

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]

Output: [-1,3,-1]

Explanation:
	- For 4 in nums1 → no greater element after 4 in nums2 → -1
	- For 1 in nums1 → next greater in nums2 is 3
	- For 2 in nums1 → no greater element → -1
```

---
### Metadata

**Difficulty:** #Easy 

**Recently Asked in Companies**: #Amazon `6`, #Meta `4`, #Microsoft `4`, #Google `2`, #Swiggy `3`, #Adobe `4`, #Flipkart `3`, #Uber `2` #Morgan-Stanley `2` 

---
### Brute Force Approach - Using Nested Loops

Use **nested loops** to iterate over each integer in `nums1` array, find the current element in `nums2` array, and then linearly search **to the right** in `nums2` to find the <span style="color:red;background:#FAEBD7;font-weight:bold">first greater element</span>.

**Algorithm**

```
n = nums1.length;
m = nums2.length;
result = [-1] * n;

- for i in range: [0, n):
	- current = nums1[i];

	- j = 0;
	- while j < m: 
		- if current == nums2[j]: break; // found current element in nums2
		- j++;

	- for k in range: [j+1, m): 
		- if current < nums2[k]: // found FGE to the right
			- result[i] = nums2[k];
			- break;

- return result;
```

**Time Complexity**

For each `current` element in `nums1` of length `n`, we are iterating over `nums2` of length `m` to find the first greater element to the right of `current` in `nums2`. Hence, overall time complexity = `O(n²)`.

**Space Complexity**

We are not using any extra memory to compute the `result`. Hence, overall space complexity = `O(1)`.

---
### Optimisation

For every element in `nums2`, we want to find the **first greater element** to its **right**. Doing this by scanning right for each element takes **O(n²)** time. 

To optimize, we can **pre-process `nums2`** to find the next greater element for each of its element in a **single left-to-right pass**. 

<span style="color:green;">We can iterate over</span> `nums2` <span style="color:green;">and use a data structure to temporarily store the <strong>unresolved elements (i.e., those still waiting to find their next greater element)</strong>. This ensures that at any point in time, the data structure only holds elements in <strong>decreasing order</strong>, each waiting for a next greater number that hasn't appeared yet.</span>

<span style="color:green;">When we encounter an element <strong>greater than</strong> the <strong>most recent unresolved element</strong>, we know we've found the <strong>next greater element</strong> for that <strong>top value</strong>. We can <strong>pop</strong> and map it accordingly, repeating this process until the top value is no longer smaller.</span>

---
### Optimised Approach - Using Stack

Use a **stack** to temporarily keep track of the **unresolved elements** as we pre-process `nums2`.

**Algorithm**

```
- int n = nums1.length;
- result = [0] * n;

- NGE = get_next_greater_element(nums2);
- for i in range [0, n):
	- result[i] = NGE[nums1[i]];

- return result;
```

```
- function get_next_greater_element(nums2):
	- NGE = {}; // map to store each <element, NGE> pair
	- stack = [];
	
	- for num in nums2:
		- while (stack contains unresolved elements) and num > stack.top():
			- element = stack.pop();
			- NGE[element] = num;
		- stack.push(num);
	
	- while stack contains unresolved elements:
		- element = stack.pop();
		- NGE[element] = -1;

	- return NGE;
```

**Time Complexity**

We are iterating over `nums1` of length `n` to populate the resultant array. Pre-processing `nums2` of length `m` ensures that each element is processed at most twice. Hence, overall time complexity = `O(n+m)`.

**Space Complexity**

In the worst-case scenario, i.e., when the entire `nums2` array is sorted in decreasing order, the stack will hold `m` elements simultaneously. The map will store the NGE of all `m` elements in `nums2`. Hence, overall space complexity = `O(m)`.

---
### Java Implementation

```
public int[] nextGreaterElement(int[] nums1, int[] nums2) {

	int n = nums1.length;
	int[] result = new int[n];

	Map<Integer, Integer> NGE = getNextGreaterElement(nums2);
	for(int i=0; i<n; i++) {
		result[i] = NGE.get(nums1[i]);
	}

	return result;

}
```

```
public Map<Integer, Integer> getNextGreaterElement(int[] nums2) {

	Map<Integer, Integer> NGE = new HashMap<>();
	Stack<Integer> stack = new Stack<>();

	for(int num: nums2) {
		while(!stack.isEmpty() && num > stack.peek()) {
			int el = stack.pop();
			NGE.put(el, num);
		}
		stack.push(num);
	}

	while(!stack.isEmpty()) {
		int el = stack.pop();
		NGE.put(el, -1);
	}

	return NGE;

}
```

---





