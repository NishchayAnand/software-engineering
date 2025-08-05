
You are given the heads of two sorted linked lists `list1` and `list2`. Merge the two lists into one **sorted** list and return the head of the merged linked list.

**Example**

```
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
```

![](https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg)

---
### Metadata

**Link:** [Leetcode 21](https://leetcode.com/problems/merge-two-sorted-lists/description/)

**Difficulty:** #Easy 

**Asked by Companies in 2025:** #Flipkart #Amazon #Microsoft #Samsung #MakeMyTrip #Oracle #Zoho #Accolite

---
### General Observations

When merging two sorted linked lists, you may need to deal with the **`head`** node differently from the rest. To avoid writing special logic for the first node, you can create a **`dummy`** node and use it as a <span style="color:green;font-weight:bold;background:beige;">placeholder to point to the head of the result list</span>.

This way, you can build the merged list uniformly using a **`tail`** pointer, and finally return **`dummy.next`** as the head of the result list.

---
### Approach: Two Pointers

Use two pointers: **`current1`** and **`current2`** to iterate over both lists **simultaneously**, and always <span style="color:green;font-weight:bold;background:beige;">pick the smaller of the two current nodes</span> to add to the **`tail`** the result list.

**Algorithm**

```
Step 1: Create a dummy node 

- dummy = ListNode(0);
- tail = dummy;
```

```
Step 2: Iterate over both lists simultaneously and prepare the result list

- current1 = list1 and current2 = list2;
- while current1 exists and current2 exists:
	- if current1.val <= current2.val:
		- tail.next = current1;
		- current1 = current1.next;
	- else:
		- tail.next = current2;
		- current2 = current2.next;
	- tail = tail.next;
```

```
Step 3: Append unvisited nodes from list1 or list2 to the tail of result list

- if current1 exists:
	- tail.next = current1;
- else if current2 exists:
	- tail.next = current2;
```

```
Step 4: Return the head of the result list

- return dummy.next;
```

**Time Complexity**

We are iterating over both lists once. Hence, overall time complexity = **`O(m+n)`**, where **`m`** and **`n`** represent the size of **`list1`** and **`list2`** respectively.

**Space Complexity**

Except for the **`dummy`** node, we are not using any extra space. Hence, overall space complexity = **`O(1)`**.

**Java Implementation**

```
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

	// Step 1: Create a dummy node
	ListNode dummy = new ListNode(-1);
	ListNode tail = dummy;

	// Step 2: Iterate over both lists simultaneously to create the result list
	ListNode current1 = list1, current2 = list2;
	while(current1 != null && current2 != null) {
		if(current1.val <= current2.val) {
			tail.next = current1;
			current1 = current1.next;
		} else {
			tail.next = current2;
			current2 = current2.next;
		}
		tail = tail.next;
	}

	// Step 3: Append unvisited nodes from list1 or list2 to tail of result list
	if(current1 != null) tail.next = current1;
	if(current2 != null) tail.next = current2;

	// Step 4: Return the head of the result list
	return dummy.next;

}
```

---