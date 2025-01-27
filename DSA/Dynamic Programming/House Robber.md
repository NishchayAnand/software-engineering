
Given an integer array **nums** of length **n** representing the amount of money stashed in n houses, return the maximum amount of money that can be robbed given that you cannot rob 2 adjacent houses.

Example: nums = [1,2,3,1], output = 4

## General Observations

- Explore **all possible combinations of selecting houses** and pick the combination which generates the maximum amount. 

- For any **kth** house, we have **2 choices**:

	- **Rob the kth house**: return the **amount stashed in the kth house** + the **maximum amount robbed from the previous k-2 houses**.

	 - **Not Rob the kth house**: return the **maximum amount robbed from the previous k-1 houses**.

## Recursive Algorithm

- **Function Definition**: 
	- **F(nums, n)** will explore all possible combinations of selecting the first n houses and return the maximum amount that can be robbed.

- **Recursive Steps**:
	- notRobAmount = F(nums, n-1); // not rob the nth house
	- robAmount = nums[n-1] + F(nums, n-2); // rob the nth house
	- return max(notRobAmount, robAmount);

- **Base Conditions**:
	- If n == 1: return nums[0]; // for a single house, only choice = rob the house
	- If n == 0: return 0; // no house available to be robbed

- **Space Complexity**: 
	- At most, n recursive calls can exist in the call stack.
	- Space Complexity: O(n).

- **Time Complexity**: 
	- Total combinations = 2^n.
	- Time Complexity = O(2^n).

## Optimisations:

- **Overlapping Subproblems**: 
	- Can use a cache (e.g. an array) to store the results of previously computed subproblems.
	- Since, we would only solve n unique subproblems, time complexity = O(n).

- **Call Stack Utilisation**:
	- The cache is filled while backtracking from n = [0, n]. 
	- Can use a loop to fill the cache using recursive steps.
	- No concerns of stack overflow.