
Given the `head` of a sorted linked list, delete all duplicates such that each element appears only once and return the head of the modified linked list.

**Example**

```
Input: head = [1,1,2]
Output: [1,2]
```

![](https://assets.leetcode.com/uploads/2021/01/04/list1.jpg)

---
### Metadata

**Link:** [Leetcode 83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/)

**Difficulty:** #Easy 

**Recently Asked in Companies:** #Amazon #Myntra #Adobe #Visa #Oracle 

---
### Approach: Eliminate Adjacent Duplicates

In a sorted linked list, all duplicate nodes are adjacent to each other.

```
Example 1

	Input:  head = 1 -> 1 -> 2 -> null

	Output: head = 1 -> 2 -> null

	Explanation:

		- 1st node and 2nd node have the same value. Hence, eliminate the 2nd              node by pointing 1st node's next pointer to 2nd node's next pointer. 


Example 2

	Input:  head = 1 -> 1 -> 2 -> 3 -> 3 -> null
	
	Output: head = 1 -> 2 -> 3 -> null

	Explanation:

		- 1st node and 2nd node have the same value. Hence, eliminate the 2nd              node by pointing 1st node's next pointer to 2nd node's next pointer.

		- 4th node and 5th node have the same value. Hence, eliminate the 5th              node by pointing 4th node's next pointer to 5th node's next pointer.

```

> **NOTE:** In this approach, the first node is never deleted.

**Algorithm**

Use a single pointer called **`current`** that starts at the **`head`** of the linked list.

Iterate over the linked list, and at each step, compare the value of the **`current`** node with **`current.next`** node. If the values are the same, skip the next node by updating **`current.next`** to point to **`current.next.next`**, else, simply move the **`current`** pointer forward.

```
- current = head;
- while current exists and current.next exists:
	- if current.val == current.next:
		- current.next = current.next.next;
	- else:
		- current = current.next;
- return head;
```

**Time Complexity**

We are iterating over the linked list once. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public ListNode deleteDuplicates(ListNode head) {
	ListNode current = head;
	while(current != null && current.next != null) {
		if(current.val == current.next.val) {
			current.next = current.next.next;
		} else {
			current = current.next;
		}
	}
	return head;
}
```

---

