
![partition-array](merge-two-sorted-array.png)

![requirement](requirement.png)
![left-search-space](search-left-space.png)
![right-search-spacew](search-right-space.png)

---

**Where `right = m - 1` Fails:** `nums1 = [1, 2] nums2 = [3, 4, 5, 6]`

Here, the optimal partition is taking **all 2 elements from `nums1`** on the left — i.e., `i = 2` — and the rest from `nums2`. But if `right = 1`, your binary search will **never try `i = 2`**, and you'll **miss the correct partition**.

---
