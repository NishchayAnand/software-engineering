
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place and return the new length of the array.

> **NOTE:**  The order of the elements can be changed. It doesn't matter what you leave beyond the new length.

**Link:** [Leetcode 27](https://leetcode.com/problems/remove-element/) 

**Difficulty:** #Easy 

**Recently Asked in Companies:** #Google `10`, #Amazon `5`, #Microsoft `2`, #Meta `5`, #Adobe `21` #Apple `18`, #Uber `15`.

---
### General Observations

Consider the number of elements in `nums` which are not equal to `val` be `k`, we need to change the array `nums` such that the first `k` elements of `nums`contain the elements which are not equal to `val`.

> **NOTE:** The remaining elements of `nums` are not important as well as the size of `nums`.

**Example 1:**

```
Input: nums = [3,2,2,3], val = 3

Output: 2, nums = [2,2,_,_]

Explanation: Your function should return k = 2, with the first two elements of nums being 2. It does not matter what you leave beyond the returned k.
```

---
### Approach - Index Shifting

While iterating over `nums`, whenever we encounter an element equal to `val`, shift all the subsequent elements one position to the left to overwrite it. After shifting, reduce the effective array length by `1`, since one occurrence of `val` has been removed.

> **NOTE:** If a shift happens, we **don’t increment the index** immediately because the new element at that index needs to be checked again.

**Algorithm**

```
- index = 0, n = nums.length;
- while index < n:
	- if nums[index] == val:
		- for i in range [index, n-1): nums[i] = nums[i+1];
		- n = n - 1;
	- else:
		- index = index + 1;
- return n;
```

**Time Complexity**

In the worst-case scenario, i.e., when all elements in `nums` equal to `val`, for each index, we shift all remaining elements left by one. Hence, overall time complexity = `O(n²)`

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public int removeElement(int[] nums, int val) {
	int index = 0, n = nums.length;
	while(index < n) {
		if(nums[index] == val) {
			for(int i = index; i< n-1; i++) nums[i] = nums[i+1];
			n--;
		} else {
			index++;
		}
	}
	return n;
}
```

---
### Approach - Fast and Slow Pointer

We can use two pointers:
- `fast` to scan every element of the `nums` array.
- `slow` to track the position where the next non-`val` element should be written.

> **NOTE:** At the end, `slow` will represent the **new length** of the modified `nums` array.

**Algorithm**

```
- slow = 0; // tracks the position where next non-val element should be written
- for fast in range [0, n):
	- if nums[fast] != val:
		- nums[slow] = nums[fast];
		- slow++;
- return slow;
```

**Time Complexity**

We are iterating over each element in `nums` once. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public int removeElement(int[] nums, int val) {
	int slow = 0; // tracks position where next non-val element should be written
	for(int fast = 0; fast < nums.length; fast++) {
		if(nums[fast] != val) {
			nums[slow] = nums[fast];
			slow++;
		}
	}
	return slow;
}
```

---
