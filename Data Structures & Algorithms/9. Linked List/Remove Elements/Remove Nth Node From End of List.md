
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

	Input: head = 1 -> 2 -> 3 -> 4 -> 5, n = 2

	Output: head = 1 -> 2 -> 3 -> 5

	Explanation:
		- 2nd node from the end = (5 - 2 + 1) = 4th node from the beginning.
		- Point 3rd node's next pointer to 4th node's next pointer.

Example 2:

	Input: head = 1 -> 2 -> 3 -> 4 -> 5, n = 1

	Output: head = 1 -> 2 -> 3 -> 4

	Explanation:
		- 1st node from the end = (5 - 1 + 1) = 5th node from the beginning.
		- Point 4th node's next pointer to 5th node's next pointer.

Example 3:

	Input: head = 1 -> 2 -> 3 -> 4 -> 5, n = 5

	Output: head = 2 -> 3 -> 4 -> 5

	Explanation:
		- 5th node from the end = (5 - 5 + 1) = 1st node from the beginning.
		- Point head node's next pointer to 1st node's next pointer.

Example 4:

	Input: head = 1, n = 1

	Output: head = null

	Explanation:
		- 1st node from the end = (1-1+1) = 1st node from the beginning.
		- Point head node's next pointer to 1st node's next pointer.
```

**Algorithm**

```
Step 1: Count number of nodes

- int length = 0;
- curr = head;
- while curr != null, i.e., linked list contains unvisited nodes:
	- length++ to increase count of visited nodes;
	- curr = curr.next to move to the next unvisited node;
```

```
Step 2: Handle edge case, i.e., if we want to remove the first element

- if length == n:
	- return head.next;
```

```
Step 3: Iterate to (length-n)th node

- prev = head;
- for i in range[0,length-n):
	- prev = prev.next;
```

```
Step 4: Remove the (length-n+1)th node and return the head

- prev.next = prev.next.next;
```

```
Step 5: Return the head of the modified linked list

- return head;
```

**Time Complexity**

We are iterating over the linked list twice, once for counting and second time for removal. Hence, overall time complexity = `O(2*n)` ~ `O(n)`.

**Space Complexity**

We aren't using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public ListNode removeNthFromEnd(ListNode head, int n) {

	// Step 1: Count number of nodes
	int length = 0;
	ListNode curr = head;
	while(curr != null) {
		length++;
		curr = curr.next;
	}

	// Step 2: Append dummy node at the start to handle edge cases
	ListNode dummy = new ListNode(0);
	dummy.next = head;

	// Step 3: Iterate to the (length-n)th node
	ListNode prev = dummy;
	for(int i=0; i<length-n; i++) {
		prev = prev.next;
	}

	// Step 4: Remove the (length-n+1)th node
	prev.next = prev.next.next;

	return dummy.next;

}
```

> **NOTE:** Using a **dummy node** helps you handle edge cases (like removing the head) gracefully without writing special `if`conditions.

---
### Approach 2: Two Pointers

Use two pointer: `fast` and `slow`, initially pointing to the `dummy` node. 

If we move the `fast` pointer `n+1` steps ahead of the `slow` pointer, then by the time `fast` reaches the end of the list, `slow` will be at the **node just before** the one we want to remove.

```
Example 1:

	Input: dummy -> 1 -> 2 -> 3 -> 4 -> 5, n = 2

	Output: dummy -> 1 -> 2 -> 3 -> 5

	Explanation:

		- Point slow pointer to the dummy node and fast pointer to (n+1)th node            = 3rd node from the dummy node.

		- Jump slow and fast pointer by 3 steps such that fast points to null              and slow points to the 3rd node, just before the 4th node that ought             to be removed. 

Example 2:

	Input: dummy -> 1 -> 2 -> 3 -> 4 -> 5, n = 1

	Output: dummy -> 1 -> 2 -> 3 -> 4

	Explanation:

		- Point slow pointer to the dummy node and fast pointer to (n+1)th node            = 2nd node from the dummy node.

		- Jump slow and fast pointer by 3 steps such fast points to null and               slow points to the 4th node, just before the 5th node that ought to be           removed.

Example 3:

	Input: dummy -> 1 -> 2 -> 3 -> 4 -> 5, n = 5

	Output: dummy -> 2 -> 3 -> 4 -> 5

	Explanation:

		- Point slow pointer to the dummy node and fast pointer to (n+1)th node            = null.

		- Since, fast pointer already points to null, slow points to the dummy             node, just before the 1st node that ought to be removed.

Example 4:

	Input: dummy -> 1, n = 1

	Output: dummy -> null

	Explanation:

		- Point slow pointer to the dummy node and fast pointer to (n+1)th node            = null.

		- Since, fast pointer already points to null, slow points to the dummy             node, just before the 1st node that ought to be removed.

```

**Algorithm**

```
Step 1: Create a dummy node and append it at the start of the list

- dummy = ListNode(0);
- dummy.next = head;
```
	
```
Step 2: Initialise the fast and slow pointer

- fast = dummy;
- slow = dummy;
```

```
Step 3: Move the fast pointer (n + 1) steps ahead

- for i in range: [0, n+1):
	- fast = fast.next;
```

```
Step 4: Move both fast and slow together one step at a time until fast = null

- while fast != null, i.e., there are unvisited nodes in the list:
	- fast = fast.next;
	- slow = slow.next;
```

```
Step 5: Remove the target node

- slow.next = slow.next.next;
```

```
Step 6: Return the head of the modified linked list

return dummy.next;
```

**Time Complexity**

We are only iterating the linked list once. Hence, overall time complexity = `O(n)`.

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

**Java Implementation**

```
public ListNode removeNthFromEnd(ListNode head, int n) {

	// Step 1: Append dummy node at the start to handle edge cases
	ListNode dummy = new ListNode(0);
	dummy.next = head;

	// Step 2: Initialize the fast and slow pointer
	ListNode fast = dummy;
	ListNode slow = dummy;

	// Step 3: Move fast pointer to the (n+1)th node from the dummy node
	for(int i=0; i<=n; i++) {
		fast = fast.next;
	}

	// Step 4: Move both fast and slow together by 1 step till fast becomes null
	while(fast != null) {
		fast = fast.next;
		slow = slow.next;
	}

	// Step 5: Remove the target node
	slow.next = slow.next.next;

	// Step 6: Return the head of the modified linked list
	return dummy.next;

}
```

---



