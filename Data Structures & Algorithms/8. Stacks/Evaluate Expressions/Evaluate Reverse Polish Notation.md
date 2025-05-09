
Given an array of strings `tokens` that represents an arithmetic expression in **Reverse Polish Notation (RPN)**. Evaluate the expression and return the result as an **integer**.

> **NOTE:** In Reverse Polish Notation (RPN), **operators appear after their operands**, i.e., you first see the numbers, and then the operator that applies to them. For example, `[1,2,+]` represents expression `(1+2)`.

```
Example 1

Input: tokens = ["2","1","+","3","*"]

Output: 9

Explanation: ((2 + 1) * 3) = 9
```

> Link: [Leetcode 150](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

---
### Metadata

- **Difficulty:** Easy

- **Recently Asked in Companies:** #Amazon #Google #Microsoft 

---
### General Observations

- Are we expected to handle **invalid expressions** or **division by zero**?
- **No**, we can assume that the input is always well-formed.

- Can the input array: `tokens` contain **negative numbers**?
- **Yes**, the input can contain negative numbers.

- How should **integer division** be handled in this problem?
- Integer division should **truncate toward zero**, i.e., when dividing two integers, **discard the decimal part**.

---
### Basic Intuition

In Reverse Polish Notation (RPN), you process expressions in the exact order they appear, and **every operator applies to the last two operands or sub-expressions** you’ve seen. 

Since the operands might not be immediately used (an operator may come later), we need a data structure to **temporarily store** them until their corresponding operator is encountered.

---
### Brute Force Approach: Using Stack

We can use a **stack** to hold the most recent values at the top, ready for the next operator.

**Algorithm**

```
- stack = [];
- for each token in tokens:
	- if token is not an operator: stack.push(token);
	- if token is an operator: 
		- result = evaluate(stack.pop(), stack.pop(), token);
		- stack.push(result);
- return stack.pop();
```

**Time Complexity**

We are iterating over the `tokens` array of size `n`, evaluating the sub-expressions and performing push / pop operations on the stack. 

Evaluating the sub-expressions is a constant time operation. Similarly, pushing / popping elements from the stack are also constant time operations. 

Hence, overall time complexity = `O(n)`.

**Space Complexity**

A valid expression with `n` tokens contains `k` operands and `k-1` operators. Hence, total tokens  `n = 2k - 1 -> k = (n + 1) / 2`.

In the worst-case scenario, i.e., when the first `n/2` tokens in `tokens` array are numbers, the stack will store `k ~ n/2` elements simultaneously. 

Hence, overall space complexity = `O(n/2) ~ O(n)`.

---
### Java Implementation

```
public int evalRPN(String[] tokens) {

	Stack<Integer> stack = new Stack<>();

	for(String token: tokens) {
		if("+-/*".contains(token)) {
			int b = stack.pop(); // second operand
			int a = stack.pop(); // first operand
			int result = evaluate(a, b, token);
			stack.push(result);
		} else {
			stack.push(Integer.parseInt(token));
		}
	}

	return stack.pop();

}
```

```
private int evaluate(int a, int b, String op) {

	int result = -1;

	switch(op) {
		case "+":
			result = a + b;
			break;
		case "-":
			result = a - b;
			break;
		case "/":
			result = a / b;
			break;
		case "*":
			result = a * b;
			break;
	};

	return result;

}
```

---
