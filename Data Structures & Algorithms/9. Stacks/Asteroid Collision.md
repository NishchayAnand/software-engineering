
Link: [Leetcode 735](https://leetcode.com/problems/asteroid-collision/description/)

---
### Problem Statement

We are given an array: `asteroids` of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the **absolute value represents its size**, and the **sign represents its direction (positive meaning right, negative meaning left)**. Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. **If two asteroids meet, the smaller one will explode. If both are the same size, both will explode**. Two asteroids moving in the same direction will never meet.

---
### Metadata

**Difficulty:** #Medium

**Recently Asked in Companies:**

- **0 - 3 months:** #Amazon `12`, #Dream11 `4`, #Google `3`, #Goldman-Sachs `2`, #Nvidia `2`, #PayPal `2`, #OpenAI `2`

- **0 - 6 months:** #Meta `5`, #Microsoft `4`, #PhonePe `2`

- **6 months ago:** #Oracle `15`, #TikTok `13`, #Apple `9`, #Flipkart `8`, #Adobe `8`, #Uber `4`

---
### General Observations

- <span style="color:red;font-weight:bold">Can multiple collisions happen as a result of one asteroid?</span>
- **Yes**, if a **left-moving asteroid** is **larger in size** than each **right-moving asteroid** it encounters, it will **destroy them one by one** and continue moving.

- <span style="color:red;font-weight:bold">Can the size of an asteroid be zero?</span>
- **No**.

---
### Basic Intuition

A collision only happens when a **right-moving asteroid** (`+`) meets a **left-moving asteroid** (`-`). 

<span style="color:green;">We need a data structure to keep track of the <strong>right-moving asteroids</strong> in the correct relative order so that when a <strong>left-moving asteroid</strong> is encountered, we can efficiently <strong>resolve collisions</strong> by comparing it with all the <strong>unresolved right-moving asteroids</strong>.</span>

```
Example 1

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.

Example 4

Input: asteroids = [-10,2,-5]
Output: [-10, -5]
Explanation: The 2 and -5 collide resulting in -5. The -10 and -5 never collide.
```

---
### Approach - Using Stack

We can use a **Stack** to keep track of the **unresolved asteroids** in the correct relative order as we process the list.

**Algorithm**

```
- stack = [];
- for each asteroid in asteroids:

	- isAlive = true;

Step 1: handle collisions when right-moving asteroid meets a left-moving asteroid.

	- while !stack.isEmpty() and stack.top() > 0 and asteroid < 0:

Condition 1: current left-moving asteroid is larger in size than the last seen right-moving asteroid

		- if absolute value of stack.top() < absolute value of asteroid:
			- stack.pop();

Condition 2: size of the current left-moving asteroid is equal to the last seen right-moving asteroid

		- if absolute value of stack.top() = absolute value of asteroid:
			- stack.pop();
			- isAlive = false;
			- break;

Condition 3: current left-moving asteroid is smaller in size than the last seen right-moving asteroid

		- if absolute value of stack.top() > absolute value of asteroid:
			- isAlive = false;
			- break;

	- if isAlive == true: stack.push(asteroid);

Step 2: populate the final resultant array with the left-over asteroids in stack

- m = stack.length();
- output = [] * m;
- for i in range [m-1, 0]:
	- output[i] = stack.pop();

Step 3: return the resultant array

- return output;
```

**Time Complexity**

Each element in `asteroids` array will be processed at most twice. Hence, overall time complexity = **`O(n)`**.

**Space Complexity**

In the worst-case scenario, i.e., when all elements in `asteroids` array are either positive (`+`) or negative (`-`), the stack will hold `n` elements simultaneously. Hence, overall space complexity = **`O(n)`**. 

---
### Java Implementation

```
public int[] asteroidCollision(int[] asteroids) {

	Stack<Integer> stack = new Stack<>();

	for (int asteroid: asteroids) {

		boolean isAlive = true;
		while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {

			int top = stack.peek();

			if (top < Math.abs(asteroid)) stack.pop();
			
			else if (top == Math.abs(asteroid)) {
				stack.pop();
				isAlive = false;
				break;
			}
			
			else {
				isAlive = false;
				break;
			}

		}

		if (isAlive) stack.push(asteroid);

	}

	int size = stack.size();
	int[] result = new int[size];
	for(int i = size-1; i>=0; i--) result[i] = stack.pop();

	return result;

}
```

---


