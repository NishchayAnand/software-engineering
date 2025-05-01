## Problem Statement

- Given an integer array nums of length n where nums[i] represent the length of maximum jump you can make from the ith index, return true if you can reach the last index, or false otherwise.

- Example: nums = [2,3,1,1,4], output = true

## General Observations

- From any **ith** index, we can make a jump of [1 | 2 | … | nums[i]], i.e., we have **nums[i] choices**.

- **Recursive Intuition:** Explore **all possible combinations of jump lengths** starting from i = 0 and check if any combination can take you to i = n-1.

- **Recursive Approach:**

	- **Hypothesis:**
		- **F(nums, start_index)** will return true if there exists a combination of jump lengths starting from **index = start_index** that will take you to **index = n-1**, or false otherwise.
	
	- **Recursive Steps:**
		- maxJumpIndex = min( start_index+nums[start_index], nums.length-1 );
		- for next_index = [start_index+1, maxJumpIndex]:
			- If F(nums, next_index): return true;
		 - return false;
	
	- **Base Conditions:**
		- If start_index == n-1: return true; // reached the last index
	
	- **Space Complexity:**
		- At most, n-1 recursive calls will exist in the call stack simultaneously. 
		- Hence, space complexity = O(n).
		
	- **Time Complexity:**
		- Exponent, i.e., O(k^n).
	
	- **Optimisations:**
	
		- **Overlapping Subproblems:** 
			- We can use a cache (an array) to store the results of previously computed sub-problems. 
			- Using caching, we only need to solve n unique sub-problems.
			- Hence, time complexity = O(k*n).
	
		- **Call Stack Utilisation:**
			- The cache is filled while backtracking from n = [n-1, 0]. 
			- Can use a loop to fill the cache using recursive steps.
			- No concerns of stack overflow.

- **Greedy Intuition:** Consider 3 indices: **[start_index, mid_index, end_index]** such that there exist a path between **mid_index** and **end_index**. If **start_index + nums[start_index] >= mid_index**, then we can reach mid_index and ultimately **end_index** from the **start_index** (**no need to explore every possible path from start_index**).

![Alt Text](jump_game_greedy.jpg)

- **Greedy Approach:**

	- **Algorithm:**
		- last_good_index = nums.length - 1;   
		- loop from i = [last_good_index-1, 0]:                 
		- if i + nums[i] >= last_good_index: 
			- last_good_index = i; // Update the last index that can reach the end index
		- return last_good_index == 0;
	
	- **Time Complexity:** O(n).
	
	- **Space Complexity:** O(1).