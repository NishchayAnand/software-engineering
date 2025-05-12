
Given an expression `expr`  parenthesis, check if the expression contains any duplicate (redundant) parentheses. 

> **NOTE:** A set of parentheses is duplicate if multiple parentheses surrounds the same sub-expression.

```
Example 1

Input: (a+b)+((c+d))

Output: true

Explanation: The sub-expression 'c+d' is surrounded by two parentheses. Hence the expression contains duplicate parenthesis. 

Example 2

Input: ((a+b) + c)

Output: false

Explanation: No sub-expressions are surrounded by multiple (redundant) parentheses.

```

> **Link:** [Naukri - Coding Ninjas](http://codingninjas.com/codestudio/problems/duplicate-parenthesis_2663296?leftPanelTab=1)

---
### Metadata

- **Difficulty Level:** Medium

- **Asked in Companies:** #Morgan-Stanley

---
### General Observations

- **Can the given expression: `expr` be unbalanced?**
- **No**, the given expression: `expr` will always be balanced, i.e., the number of opening brackets would match the number of closing brackets.

- **Can the given expression: `expr` contain invalid sub-expressions like: `(a)`, `(+a)` or `()`?**
- **No***, every sub-expression in the given expression: `expr` will be valid, i.e., will contain an operator (e.g., `+`, `-`, `*`, `/`)  and two operands.

---
### Basic Intuition

<span style="color:green;">A pair of opening-closing parentheses that encloses <strong>no operator</strong> is likely a duplicate</span>. While iterating over **each closing bracket** in expression: `expr`, we need a way to track if there exist a sub-expression between the **most recent unclosed opening bracket** and the the **current closing bracket**.

---
### Approach - Using Stack

A **stack** is a Last-In-First-Out (LIFO) data structure where the last thing you put in is the first thing you take out.

We can use a **stack** to keep track of what's **inside** each pair of opening and closing parentheses **in the correct order**. This allows us to **process the enclosed sub-expression whenever we encounter a closing bracket**.

**Algorithm**

```
- stack = [];

- loop over each character 'ch' in 'expr': 

	- if ch != ')': stack.push(ch);

	- if ch == ')':

		// process the enclosed sub-expression
		- subexp_ch_count = 0;
		- while stack.top() != '(': 
			- subexp_ch_count++;
			- stack.pop();

		// no enclosed sub-expression to process
		- if subexp_ch_count == 0: return true; 

		// remove the opening bracket for the processed sub-expression
		- stack.pop();

// no redundant pair of parentheses found
- return false;
```

**Space Complexity**

In the worst-case scenario, i.e, when the given expression contains a single sub-expression, the stack will hold `n` characters simultaneously. Hence, overall space complexity = `O(n)`. 

**Time Complexity**

We are iterating over the input expression `expr` of size `n` and pushing / popping characters from the stack. Pushing and popping elements from a stack is a constant time operation. Hence, overall time complexity = `O(n)`.

---
### Java Implementation

```
public static boolean duplicateParanthesis(String expr) {

	Stack<Character> stack = new Stack<>();

	for(char ch: expr.toCharArray) {
		if(ch != ')') {
			stack.push(ch);
		} else {
			// process the enclosed sub-expression
			int subExpChrCount = 0;
			while(stack.peek() != '(') {
				subExpChrCount++;
				stack.pop();
			}

			// if no sub-expression found
			if(subExpChrCount == 0) return true;
			
			// remove the opening parentheses of the processed sub-expression
			stack.pop();
		}
	}

	// no redundant pair of parentheses found
	return false;

}
```

---

