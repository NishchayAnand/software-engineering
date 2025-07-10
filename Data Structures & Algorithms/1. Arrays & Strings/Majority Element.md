
Given an array `nums` of size `n`, return the majority element.

> **NOTE:** The majority element is the element that appears more than `⌊n / 2⌋`times.

```
Example 1

Input: nums = [3,2,3]
Output: 3
```

```
Example 2

Input: nums = [2,2,1,1,1,2,2]
Output: 2
```

---
### Metadata

**Link:** [Leetcode 169](https://leetcode.com/problems/majority-element/description/)

**Difficulty:** #Easy

**Recently Asked in Companies:** #Amazon `9`, #Google `8`, #Meta `8`, #Microsoft `5`, #Apple `21`, #Deloitte `2`, #Flipkart `2`.

---
### Assumptions

<span style="color:red;font-weight:bold;">Q. Will the majority element always exist in the input array?</span>
**A. Yes,** you can assume that a majority element will always be there.

---
### Approach - Frequency Map

Use a `HashMap` to create a frequency map of `nums`. While iterating over `nums`, update the frequency map and keep track of the element with the highest frequency.

**Algorithm**

```
- freqMap = new HashMap;
- maxFreq = -Infinity;
- majorityElement = -1;

- for num in nums:
	- newFreq = freqMap.get(nums) + 1;
	- if newFreq > maxFreq:
		- maxFreq = newFreq;
		- majorityElement = num;
	- freqMap.put(num, newFreq);

- return maxFreqElement;
```

**Time Complexity**

We are iterating over `nums` of length `n` once. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are using a frequency map to store the count of each element in `nums`. Hence, overall space complexity = `O(n)`.

**Java Implementation**

```
public int majorityElement(int[] nums) {
	Map<Integer, Integer> freqMap = new HashMap<>();
	int maxFreq = Integer.MIN_VALUE;
	int majorityElement = -1;

	for(int num: nums) {
		int newFreq = freqMap.getOrDefault(num, 0) + 1;
		if(newFreq > maxFreq) {
			maxFreq = newFreq;
			majorityElement = num;
		}
		freqMap.put(num, newFreq);
	}
	
	return majorityElement;
}
```

---
### Approach - Sorting

Sorting `nums` will make sure that the element at `index = n/2` always represent the majority element.

**Algorithm**

```
- nums = sorted(nums);
- return nums[n/2];
```

**Time Complexity**

Time complexity of sorting `nums` of length `n` is `O(nlogn)`. Hence, overall time complexity = `O(nlogn)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public int majorityElement(int[] nums) {
	int n = nums.length;
	Arrays.sort(nums);
	return nums[n/2];
}
```

---




