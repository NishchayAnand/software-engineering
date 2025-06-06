
Link: [Leetcode 25](https://leetcode.com/problems/reverse-nodes-in-k-group/description/)

---
### Problem Statement

Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.

**Example**

**Input:** `head = [1,2,3,4,5], k = 2`

**Output:** `[2,1,4,3,5]`

![](https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg)


---
### Metadata

**Difficulty:** #Hard

**Recently Asked in Companies:**

- **0 - 3 months**: #Google `9`, #Amazon `5`, #Microsoft `3`, #Bloomberg `2`

- **0 - 6 months**: #Meta `2`, #TikTok `2`, #Salesforce `2`

- **6 months ago**: #Adobe `9`, #Snowflake `8`, #Apple `5`, #Walmart `5`, #Tesla `4`, #Infosys `2`, #De-Shaw `2`

---
### General Observations

- <span style="color:red;">What is the range of </span> `k` <span style="color:red;">?</span>
- `k` is a positive integer and is less than or equal to the length of the linked list. <span style="color:purple;">This mean, there will always be at least one element in the linked list.</span>

- <span style="color:red;">What to do with the left over elements in case the number of nodes are not a multiple of</span> `k`?
- If the number of nodes is not a multiple of `k`then left-out nodes, in the end, **should remain as it is**.

- <span style="color:red;">Can we modify the values in the list's nodes?</span>
- **No,** you may not alter the values in the list's nodes, only nodes themselves may be changed.

---
### Basic Intuition

The problem statement mentions that if there are **`< k nodes`** left in the linked list, then we don't have to reverse them. <span style="color:green;">This implies that we first need to <strong>count k nodes</strong> before we get on with our reversal.</span>

---
### Recursive Approach

After reversing the first `k` nodes, the remaining list is itself a smaller linked list that can be processed recursively in the same way.

**Algorithm**

```
Hypotheses: 

F(head, k) will reverse the nodes of the list starting at head in k groups and return the head of the modified list. 
```

```
Recursive Steps:

Step 1: Reverse the first k nodes
- prev = null;
- curr = head;
- loop from i = [0, k) to iterate over the first k nodes:
	- nextTemp = curr.next;
	- curr.next = prev;
	- prev = curr;
	- curr = nextTemp;

Step 2: Recurse on the remaining list and connect
- head.next = F(curr, k);

Step 3: Return the new head of this segment
- return prev;
```

```
Base Conditions:

Condition 1: Check if there are at least k nodes to reverse
- ptr = head, count = 0;
- while count < k and ptr is not null:
	- count++;
	- ptr = ptr.next;
- if count < k: return head;
```

**Time Complexity**

We are performing two traversals of the list overall. One for counting, and the next, for reversals. Hence, overall time complexity = `O(n)`.

**Space Complexity**

The call stack will `n/k` recursive calls simultaneously. Hence, overall space complexity = `O(n/k)`.

**Java Implementation**

```
public ListNode reverseKGroup(ListNode head, int k) {

	// Base Conditions:

	// Condition 1: check if there are at least k nodes to reverse
	ListNode ptr = head;
	int count = 0;
	while(count < k && ptr != null) {
		count++;
		ptr = ptr.next;
	}
	if(count < k) return head;

	// Recursive Steps:

	// Step 1: reverse the first k nodes
	ListNode prev = null;
	ListNode curr = head;
	for(int i=0; i<k; i++) {
		ListNode nextTemp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = nextTemp;
	}

	// Step 2: recurse the remaining list and connect
	head.next = reverseKGroup(curr, k);

	// Step 3: return the new head of the modified list
	return prev;

}
```

---
### Iterative Approach




