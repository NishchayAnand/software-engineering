
Link: [Leetcode 901](https://leetcode.com/problems/online-stock-span/description/)

---
### Problem Statement

**Design an algorithm** that **collects daily price quotes for some stock** and **returns the span** of that stock's price for the current day.

> The **span** of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

<span style="color:green;">Implement the</span> `StockSpanner` <span style="color:green;">class:</span>

- `StockSpanner()` <span style="color:green;">Initializes the object of the class.</span>
- `int next(int price)` <span style="color:green;">Returns the <strong>span</strong> of the stock's price given that today's price is</span> `price`.

```
Example 1

Input:
	["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
	[[], [100], [80], [60], [70], [60], [75], [85]]

Output:
	[null, 1, 1, 1, 2, 1, 4, 6]

Explanation
	StockSpanner stockSpanner = new StockSpanner();
	stockSpanner.next(100); // return 1
	stockSpanner.next(80);  // return 1
	stockSpanner.next(60);  // return 1
	stockSpanner.next(70);  // return 2
	stockSpanner.next(60);  // return 1
	stockSpanner.next(75);  // return 4
	stockSpanner.next(85);  // return 6
```

---
### Metadata

**Difficulty:** #Medium 

**Recently Asked in Companies:**

- **0 - 3 months:** #Google `3`, #Microsoft `2`, #Amazon `2`, 

- **0 - 6 months:** #Bloomberg `2`, #Adobe `3`, #Meta `2`, #Apple `2`, 

---
### High-Level Design

<span style="color:green;">To design the</span> `StockSpanner` <span style="color:green">class, we need a way to <strong>store </strong>and <strong>compute the span of each stock price</strong> efficiently.</span>

---
### General Observations

- <span style="color:red;">What will be today's stock span if <strong>today is the first day</strong> and the stock price is 2?</span>
- The stock span is always **at least 1** (since today counts).

- <span style="color:red;">What will be today's stock span if <strong>all previous day prices are less than or equal</strong> to today's price?</span>
- The stock span would simply be the count of all **previous days + today**.

---
### Basic Intuition

The stock span for the `ith` day is equivalent to the difference between the current day (`i`) and the **nearest previous day with a greater stock price**, a.k.a., <span style="color:red;background:#FAEBD7;font-weight:bold">nearest greater element (NGE) to the left</span>.

```
Example 1

Input: [100, 80, 60, 70, 60, 75, 85]
		  0   1   2   3   4   5   6

Output: [1, 1, 1, 2, 1, 4, 6]

Explanation:
	- For 100 → no NGE to left exists → stock span = 1
	- For 80  → NGE to left is 100    → stock span is 1 - 0 = 1
	- For 60  → NGE to left is 80     → stock span is 2 - 1 = 1
	- For 70  → NGE to left is 80     → stock span is 3 - 1 = 2
	- For 60  → NGE to left is 70     → stock span is 4 - 3 = 1
	- For 75  → NGE to left is 80     → stock span is 5 - 1 = 4
	- For 85  → NGE to left is 100    → stock span is 6 - 0 = 6
```

---
### Brute-Force Approach

**Use a list to store all previous prices** and, for each new price, **use a loop to iterate backward** through the list until we find a price greater than the current one.

**Algorithm**

```
- prices = []; // instance variable

- function next(price):

	- prices.append(price); // store today's price in list

	// find the next greater element to the left of today's price
	- n = prices.length;
	- for i in range [n-2, 0, -1]:
		- if prices[i] > price: return (n-1) - i;	
```

**Time Complexity**

In the worst-case scenario, i.e., when the elements are inserted in the list in ascending (increasing) order, each `next(price)` query will perform `n` operations. 

Considering, there are `n` total `next(price)` calls, the worst-case time complexity is: **`O(n²)`**.

**Space Complexity**

We are using a list to store all previous stock prices. Considering, there are `n` total `next(price)` calls, the space complexity is: **`O(n)`**.

---
### Redundant Operations

For each `next(price)` query, we are iterating over all the precious prices (from **right-to-left**) to find the **nearest greater element**.

<span style="color:green;">When we call</span> `next(75)`<span style="color:green;">, it returns</span> `4`<span style="color:green;">. This tells us that it took</span> `4` <span style="color:green;">days to find a price greater than</span> `75`<span style="color:green;">. When we call</span> `next(85)`<span style="color:green;">, <strong>we can use this information to our advantage</strong> - if it took</span> `4` <span style="color:green;">days to find a price greater than</span> `75`<span style="color:green;">, then it will definitely take at least</span> `4 + 1 = 5` <span style="color:green;">days to find a price greater than</span> `85`<span style="color:green;">.</span>

<span style="color:green;font-weight:bold;background:beige;">If we save the stock span for</span> `75`<span style="color:green;font-weight:bold;background:beige;">, we can use it to save time on the call to</span> `next(85)`<span style="color:green;">.</span>

![stack-insight](online-stock-span-1.png)

---
### Optimisation

**Key Observation:** <span style="color:green;font-weight:bold;background:beige">Prices that are smaller or equal to the current price can't influence future spans, i.e., they'll never be the next greater for any upcoming price.</span>

We can use a data structure to store both the stock prices and their span such that when we encounter a new price, we **pop off all smaller or equal prices**, combine their spans, and store the new price with the total span.

---
### Stack-Based Approach

<span style="color:green;">We can use a <strong>stack</strong> to store both the stock prices and their span, efficiently popping and accumulating spans of smaller or equal prices. This ensures the stack always maintains a <strong>monotonically decreasing order</strong> of prices, each one having a potential to be the nearest greater to the left for a future incoming price.</span>

**Algorithm**

```
- stack = []; // instance variable

- function next(price):
	- span = 1;
	- while (stack is not empty) and (stack.top().price <= price):
		- span += stack.pop().span;
	- stack.push([price, span]);
	- return span;	
```

**Time Complexity**

Even though there is a while loop in `next`, that while loop can only run `n` times total across the entire algorithm.

If one call to `next`takes a long time because the while loop runs many times, then the other calls to `next` won't take as long because their while loops can't run as long.

If you average out the time it takes for `next` to run across `n` calls, its time complexity works out to be `O(1)`. This is called **amortised analysis**. 

**Space Complexity**

In the worst case scenario, i.e., when all the stock prices are in descending (decreasing) order, the stack will hold `n` elements simultaneously. Hence, overall space complexity = `O(n)`.

---
### Java Implementation

```
class StockSpanner {

	Stack<int[]> stack;

	public StockSpanner() {
		stack = new Stack<>();
	}

	public int next(int price) {
		int span = 1;
		while(!stack.isEmpty() && stack.peek()[0] <= price) {
			span += stack.pop()[1];
		}
		stack.push(new int[]{price, span});
		return span;
	}

}
```

> **NOTE:** <span style="color:gray;">Monotonic stack problems can be really hard to wrap your head around initially, but it gets a lot easier with practice. If you are having trouble understanding, look at the code and try walking through the example test case</span> (`[100, 80, 60, 70, 60, 75, 85]`) <span style="color:gray;">line by line using paper.</span>

---