
### **Redundant Computations in the Brute Force Approach**

The brute force approach for finding the **minimum window substring** involves **checking all possible substrings**, leading to several **inefficiencies and redundant computations**:

---

### **🔹 1. Checking Overlapping Substrings Repeatedly**

- Suppose we have found a valid substring `s[i, j]` that contains all characters of `t`.
- Instead of stopping or optimising, the brute force approach **still considers all substrings that start at `i` and end at `j+1, j+2, ...`**, even though these will be longer and thus **not minimal**.

✅ **Optimisation Insight:**

- Once a valid substring is found, there's **no need to extend it further**, as it won’t be the shortest.

---
### **🔹 2. Recomputing Character Frequencies for Every Substring**

- The brute force method **recomputes the character count** for each new substring from scratch.
- For example, when checking substrings starting from `s[i]`, the algorithm **builds a frequency map from the beginning** for every new `j`, even though there is a large overlap with `s[i, j-1]`.

✅ **Optimisation Insight:**

- Use a **sliding window** with a frequency map to maintain counts dynamically, avoiding repeated recalculations.