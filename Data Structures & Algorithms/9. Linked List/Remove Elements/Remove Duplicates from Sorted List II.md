
Given the `head` of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the head of the modified list.

**Example**

```
Input: head = [1,2,3,3,4,4,5]
Output: [1,2,5]
```

![](https://assets.leetcode.com/uploads/2021/01/04/linkedlist1.jpg)

---
### Metadata

**Link:** [Leetcode 82](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/)

**Difficulty:** #Medium 

**Recently Asked in Companies:** #Amazon 

---
### General Observations

Since we’re allowed to modify the **`head`** of the linked list, we can simplify edge case handling, especially when the initial nodes are duplicates, by prepending a **`dummy`** node at the start of the list. 

This ensures a consistent structure, even if the first few elements need to be removed.

---
### Approach: Two Pointers
 
Use two pointers: **`previous`**, which initially points to a **`dummy`** node added before the **`head`**, and **`current`**, which starts at the **`head`** of the list.

As we iterate over the linked list:

- <span style="color:green;font-weight:bold;background:beige;">If the</span> **`current`** <span style="color:green;font-weight:bold;background:beige;">node begins a sequence of duplicate values (i.e., its value is equal to the next node's value), continue moving</span> **`current`** <span style="color:green;font-weight:bold;background:beige;">forward until we skip all nodes with that duplicate value</span>. Once all duplicates are bypassed, we adjust **`previous.next`** to point to the node after the duplicate sequence. 

- If the **`current`** node is unique (i.e., not followed by a duplicate), both **`previous`** and **`current`** pointers are simply advanced one step forward.

**Dry Run**

```
Example 1

	Input: dummy -> 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5 -> null

	Output: head = 1 -> 2 -> 5 -> null

	Explanation:

		- Iteration 1: 
			- previous = dummy, current = 1, current.next = 2 → Not a duplicate. 
			- Move both previous and current forward.
    
		- Iteration 2: 
			- previous = 1, current = 2, current.next = 3 → Not a duplicate.
			- Move both previous and current forward.

		- Iteration 3: 
			- previous = 2, current = 3, current.next = 3 → Duplicate found.
			- Move current forward until current.val != 3 → current = 4.         
			- Set previous.next = current (4).

		- Iteration 4:
			- previous = 2, current = 4, current.next = 4 → Duplicate found. 
		    - Move current forward until current.val != 5 → current = 5.  
		    - Set previous.next = current (5).

		- Iteration 5:
			- previous = 2, current = 5, current.next = null.  
		    - Move previous and current forward.
```

```
Example 2

	Input: dummy -> 1 -> 1 -> 3 -> 4 -> 4 -> null

	Output: head = 3 -> null

	Explanation:

		- Iteration 1: 
			- previous = dummy, current = 1, current.next = 1 → Duplicate found. 
			- Move current forward until current.val != 1 → current = 3.
			- Set previous.next = current (3).
    
		- Iteration 2: 
			- previous = dummy, current = 3, current.next = 4 → Not a duplicate.
			- Move both previous and current forward.

		- Iteration 3: 
			- previous = 3, current = 4, current.next = 4 → Duplicate found.
			- Move current forward until current exists and current.val != 4                   → current = null.               
			- Set previous.next = current (null).
```

**Algorithm**

```

```

**Time Complexity**

**Space Complexity**

**Java Implementation**

```

```

---


