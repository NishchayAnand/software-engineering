
---
### Redundant Computations

Given `nums = [2, 3, 1, 2, 4, 3]` and `target = 7`:

| **Start Index (`i`)** | **Expanding `j` (Right Pointer)** | **Subarray** | **Computed Sum**                                |
| --------------------- | --------------------------------- | ------------ | ----------------------------------------------- |
| `i = 0`               | `j = 0`                           | `[2]`        | `2`                                             |
| `i = 0`               | `j = 1`                           | `[2,3]`      | `2 + 3 = 5`                                     |
| `i = 0`               | `j = 2`                           | `[2,3,1]`    | `2 + 3 + 1 = 6`                                 |
| `i = 0`               | `j = 3`                           | `[2,3,1,2]`  | `2 + 3 + 1 + 2 = 8` **(valid subarray found)**  |
| `i = 1`               | `j = 1`                           | `[3]`        | `3` **(Restarted sum computation!)**            |
| `i = 1`               | `j = 2`                           | `[3,1]`      | `3 + 1 = 4`                                     |
| `i = 1`               | `j = 3`                           | `[3,1,2]`    | `3 + 1 + 2 = 6`                                 |
| `i = 1`               | `j = 4`                           | `[3,1,2,4]`  | `3 + 1 + 2 + 4 = 10` **(valid subarray found)** |

- When moving from `i = 0` to `i = 1`, we **completely discard** the sum computed for `[2,3,1,2]`.
- Instead of **removing just `2`** from `sum = 8`, we **recalculate everything from scratch** for `[3,1,2,4]`.
- The subarray `[3,1,2]` (sum `6`) gets **recomputed**, even though we already calculated it before!

This happens for **every `i`**, leading to an **O(N²) complexity**.

---