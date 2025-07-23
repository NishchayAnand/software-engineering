
Given the `head` of a linked list, remove the `nth` node from the end of the list and return its head.

**Example**

```
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
```

![remove-nth-node](remove_nth_node.jpg)

---
### Metadata

**Link:** [Leetcode 19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)

**Difficulty:** #Medium 

**Recently Asked in Companies:** #Meta `14`, #Google `10`, #Amazon  `4`, #Microsoft `2`, #Apple `2`

---
### General Observations

- `n` will always be less than or equal to the number of nodes in the list.
- We don't know the number of nodes in the list.
- Number of nodes will always be greater than `0`.

---
### Approach 1: Count Number of Elements

The **`nth` node from the end** is the same as the **`(length - n + 1)th` node from the beginning** of the list.

```
Example 1:

	Input: head -> 1 -> 2 -> 3 -> 4 -> 5, n = 2

	Output: head -> 1 -> 2 -> 3 -> 5

	Explanation:
		- 2nd node from the end = (5 - 2 + 1) = 4th node from the beginning.
		- Point 3rd node's next pointer to 4th node's next pointer.

Example 2:

	Input: head -> 1 -> 2 -> 3 -> 4 -> 5, n = 1

	Output: head -> 1 -> 2 -> 3 -> 4

	Explanation:
		- 1st node from the end = (5 - 1 + 1) = 5th node from the beginning.
		- Point 4th node's next pointer to 5th node's next pointer.

Example 3:

	Input: head -> 1 -> 2 -> 3 -> 4 -> 5, n = 5

	Output: head -> 2 -> 3 -> 4 -> 5

	Explanation:
		- 5th node from the end = (5 - 5 + 1) = 1st node from the beginning.
		- Point head node's next pointer to 1st node's next pointer.

Example 4:

	Input: head -> 1, n = 1

	Output: head -> null

	Explanation:
		- 1st node from the end = (1-1+1) = 1st node from the beginning.
		- Point head node's next pointer to 1st node's next pointer.
```

**Algorithm**

Traverse the linked list to count the number of nodes: **`length`**. Again traverse the list to reach the  **`(length-n)th`** and point **`(length-n)th`** node's next pointer to **`(length-n+1)th`** node's next pointer.

```
// Step 1: Count number of nodes


// Step 2: Calculate count - n

// Step 3: 
```

**Time Complexity**

**Space Complexity**

**Java Implementation**

```
public ListNode removeNthFromEnd(ListNode head, int n) {}
```

---
### Approach 2: Two Pointers



