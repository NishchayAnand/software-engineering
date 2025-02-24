### Problem Statement

Given a string `s`, find the length of the longest substring without duplicate characters.

Example: For s = `abcabcbb`, the answer is `abc`, with the length of 3.

## General Observations

- Explore all possible substrings and find the longest one which contains only unique  characters.

- **Brute Force Approach:** 
    
	- Use a nested loop `[i, j]` to explore the longest possible substrings containing unique characters starting from each character `s[i]` and keep track of the longest one.
    
	- **Algorithm:**
		1. **Initialise** `maxLength = 0` to store the longest substring length;
		2. **Loop** from `i = [0, n-1]` to iterate through each character `s[i]`:
			- **Initialise** `currLength = 0` to store the length of the longest substring starting at `s[i]`.
			- **Loop** from `j = [i, n-1]` to expand the substring starting from `s[j=i]` one character at a time:
				- **If** `s[j]` has already been seen, i.e., duplicate: break the `jth` inner loop;
				- **Otherwise**, increment `currLength` by 1;
			- **Update** `maxLength` if `currLength` is longer.
		3. **Return** `maxLength` after checking all possible substrings.  

	- **Time Complexity Analysis:**
		- Outer loop runs **n** times.
		- In worst-case scenario (all unique characters), the inner loop runs **n** times.
		- Adding elements to a hash set is constant time operation.
		- Thus, total time complexity is **O(n<sup>2</sup>)**. 

	- **Space Complexity Analysis:**
		- In worst-case scenario (all unique characters), the hash set will store **n** elements.
		- Thus, total space complexity is **O(n)**.

	```
	public int lengthOfLongestSubstring(String s) {
	
		// Step 1: Initialise
		int n = s.length();
		int maxLength = 0;
			
		// Step 2: Try all possible starting points
		for(int i=0; i<n; i++) {
		
			int currLength = 0;
			Set<Character> set = new HashSet<>();
				
			for(int j=i; j<n; j++) {
				if(set.contains(s.charAt(j))) break;
				set.add(s.charAt(j));
				currLength++;	
			}
				
			maxLength = Math.max(maxLength, currLength);
			
		}
			
		return maxLength;
		
	}
	```
