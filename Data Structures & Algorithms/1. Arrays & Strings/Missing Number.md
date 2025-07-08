
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
- nums = sort(nums);
- for i in range: [0,n):
	- if i != nums[i]: return i;
- return n;
```

**Time Complexity**

Time complexity of:

- sorting `nums` of length `n` will be `O(nlog(n))`
- looping over sorted `nums` of length `n` will be `O(n)`

Hence, overall time complexity = `O(nlog(n))` + `O(n)` ~ `O(nlogn)`.

**Space Complexity**

We are not using any extra space. Hence, overall time complexity = `O(1)`.

**Java Implementation**

```
public int missingNumber(int[] nums) {
	Arrays.sort(nums);
	for(int i=0; i<nums.length; i++) {
		if(i != nums[i]) return i;
	}
	return nums.length;
}
```

---
### Approach - Sum Formula

Use the formula: `n * (n + 1) / 2` to find the sum, i.e., **expected total** of the first `n` natural numbers. Loop over of `nums` to compute the **actual total**. 

The **difference** between the **expected total** and **actual total** will give us the missing number.

**Algorithm**

```
- expected_total = (n * (n+1)) / 2;
- actual_total = sum(nums);
- return expected_total - actual_total;
```

**Time Complexity**

We are looping over `nums` of length `n` to find the `actual_total`. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public int missingNumber(int[] nums) {
	int n = nums.length;
	int expectedTotal = (n * (n+1)) / 2;
	int actualTotal = Arrays.stream(nums).sum();
	return expectedTotal - actualTotal;
}
```

---
### Approach - XOR

Since, `nums` contains `n` numbers and exactly one number is missing from the range `[0..n−1]`, we know that number `n` definitely replaces the missing number in `nums`. For example, in `nums = [3,0,1]`, number `n = 3` has replaced missing number `2`. 

<span style="color:green;font-weight:bold;background:beige;">If we initialize an integer  to number</span> `n` <span style="color:green;font-weight:bold;background:beige;">and XOR it with every index and value, we will be left with the missing number.</span> For example, in `nums = [3,0,1]`, `3^(0^3)^(1^0)^(2^1) = (3^3)^(2)^(1^1)^(0^0) = (0)^(2)^(0)^(0) = 2`.

> **XOR Properties:**
>
> 	- `a ^ a = 0`: XORing a number with itself gives 0. For example, `(2^2)^(1^1)^(0^0) = 0`.
> 
> 	- `a ^ 0 = a`: XORing a number with 0 gives the number back. For example, `3^(2^2)^(1^1)^(0^0) = 3`.
> 
> 	- XOR is commutative and associative, i.e., order doesn't matter. For example, `3^(2^1)^(1^0)^(0^2) = 3^(2^2)^(1^1)^(0^0) = 3`.

**Algorithm**

```
- result = n;
- for i in range [0,n):
	- result = result ^ i ^ nums[i];
- return result;
```

**Time Complexity**

We are looping over `nums` of length `n`. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public int missingNumber(int[] nums) {
	int result = nums.length;
	for(int i=0; i<nums.length; i++) result = result ^ i ^ nums[i];
	return result;
}
```

---









