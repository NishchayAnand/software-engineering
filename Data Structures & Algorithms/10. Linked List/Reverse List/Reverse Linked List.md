
Link: [Leetcode 206](https://leetcode.com/problems/reverse-linked-list/description/)

---
### Problem Statement

Given the `head` of a singly linked list, reverse the list, and **return the reversed list**.

**Example**

![reverse-linked-list](https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg)

---
### Metadata

**Difficulty:** #Easy 

**Recently Asked in Companies:**

- **0 - 3 months**: #Google `8`, #Microsoft `7`, #Bloomberg `4`, #Visa `4`, #Meta `3`, #Amazon `3`, #Apple `2`, #Oracle `2`, #Luxoft `2`

- **0 - 6 months:** #TikTok `4`

- **6 months ago**: #Adobe `22`, #Uber `4`, #Goldman-Sachs `3`, #Siemens `3`

---
### Recursive Intuition

**Key Observation:** A linked list is made up of nodes, where <span style="color:red;font-weight:bold;background:beige">each node points to the rest of the list.</span> So it’s naturally structured like this: `head → rest_of_list`.

**Intuition:** Reversing a list starting at node `head` is **the same problem** as reversing the list starting at `head.next`.

---
### Recursive Approach

Reverse the rest of the list, then fix the link from the current node.

![reverse-linked-list-recursive](reverse-linked-list-recursive.png)

**Hypotheses**

`F(head)` will reverse the linked list starting from `head.next` and return the new `head` of that reversed list.

**Recursive Steps**

```
new_head = F(head.next);
head.next.next = head;
head.next = null;
return new_head;
```

**Base Conditions**

```
if head.next == null: return head;
```

**Time Complexity**

For a linked list of `n` nodes, you make `n` recursive calls. In each call, we are performing **constant work (pointer updates)**. Hence, overall time complexity = `O(n)`.

**Space Complexity**

For a linked list of `n` nodes, the call stack will hold `n` recursive calls simultaneously. Hence, overall space complexity = `O(n)`.

---
### Java Implementation

```
public ListNode reverseList(ListNode head) {

	// base conditions
	if(head == null || head.next == null) return head;

	// recursive steps
	ListNode newHead = reverseList(head.next);
	head.next.next = head;
	head.next = null;

	return newHead;

}
```

---

---
### Iterative Intuition

In a singly linked list, each node only knows about the next one, so to reverse the list, you need to go through each node and carefully redirect its `next` pointer to the node that came before it.

![reverse-linked-list](reverse-linked-list.png)

---
### Iterative Approach

Iterate through the linked list and use three pointers: `prev`, `curr`, and `next` (to temporarily store the next node) to reverse the direction of each `curr` node’s `next` pointer.

**Algorithm**

```
- prev = null;
- curr = head;

- if curr == null: return null; // edge case
- if curr.next == null: return head; // edge case

- while curr is not null:
	- next = curr.next;
	- curr.next = prev;
	- prev = curr;
	- curr = next;

- return head = prev;
```

**Time Complexity**

We are iterating over all the elements in the list. Considering the list contains `n` element, overall time complexity = `O(n)`. 

**Space Complexity**

We are not using any extra space. Hence, overall space complexity = `O(1)`.

---
### Java Implementation

```
public ListNode reverseList(ListNode head) {

	// edge cases
	if(head == null || head.next == null) return head;

	ListNode prev = null;
	ListNode curr = head;
	while(curr != null) {
		ListNode next = curr.next;
		curr.next = prev;
		prev = curr;
		curr = next;
	}

	return head = prev;

}
```

---
### Intuitive Iterative Approach 

take the next element and add to the front.


---
### Follow-Up Questions

- **In what cases would a linked list be preferred over an array in designing a backend system?**

- **Would reversing a linked list ever be useful in data pipeline or message queue implementations?**

- **How do you typically test and validate core logic like this in your codebase?**

---
