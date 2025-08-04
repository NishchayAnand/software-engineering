
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

As we iterate over the linked list, <span style="color:green;font-weight:bold;background:beige;">if the</span> **`current`** <span style="color:green;font-weight:bold;background:beige;">node begins a sequence of duplicate values (i.e., its value is equal to the next node's value), continue moving</span> **`current`** <span style="color:green;font-weight:bold;background:beige;">forward until we skip all nodes with that duplicate value</span>. Once all duplicates are bypassed, we can adjust  **`previous.next`** to point to the node after the duplicate sequence.

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
			- Move current forward till current.val == current.next.val.        
			- Set previous-(2).next = current-(3).next-(4).
			- Move current forward.

		- Iteration 4:
			- previous = 2, current = 4, current.next = 4 → Duplicate found. 
		    - Move current forward till current.val == current.next.val.  
		    - Set previous-(2).next = current-(4).next-(5).
		    - Move current forward.

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
			- Move current forward till current.val == current.next.val.
			- Set previous (dummy).next = current-(1).next-(3).
			- Move current forward.
    
		- Iteration 2: 
			- previous = dummy, current = 3, current.next = 4 → Not a duplicate.
			- Move both previous and current forward.

		- Iteration 3: 
			- previous = 3, current = 4, current.next = 4 → Duplicate found.
			- Move current forward till current.next exists and current.val ==                 current.next.val.
			- Set previous-(3).next = current-(4).next-(null).
			- Move current forward.
```

**Algorithm**

```
Step 1: Append a dummy node at the start of the linked list.

- dummy = ListNode(0);
- dummy.next = head;
```

```
Step 2: Initialise the previous and current pointers

- previous = dummy;
- current = head;
```

```
Step 3: Iterate over the linked list and remove all duplicate nodes

- while current exists:
	- if current.next exists and current.val == current.next.val, current marks        the start of a duplicate sequence:
		- while current.next exists and current.val == current.next.val:
			- current = current.next;
		- previous.next = current.next;
	- else:
		- previous = previous.next;
	- current = current.next;
```

```
Step 4: Return the head of the modified linked list

- return dummy.next;
```

**Time Complexity**

We are iterating over each node of the linked list once. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public ListNode deleteDuplicates(ListNode head) {

	// Step 1: Check base conditions to avoid extra computations
	if(head == null || head.next == null) return head;

	// Step 2: Append a dummy node at the start of the linked list
	ListNode dummy = new ListNode(0);
	dummy.next = head;

	// Step 3: Initialise the previous and current pointers
	ListNode previous = dummy;
	ListNode current = head;

	// Step 4: Iterate over the linked list and remove all duplicate nodes
	while(current != null) {
		// if current node marks the start of a duplicate sequence
		if(current.next != null && current.val == current.next.val) {
			while(current.next != null && current.val == current.next.val) {
				current = current.next;
			}
			previous.next = current.next;
		} else {
			previous = previous.next;
		}
		current = current.next;
	}

	// Step 5: Return the head of modified linked list
	return dummy.next;

}
```

---


