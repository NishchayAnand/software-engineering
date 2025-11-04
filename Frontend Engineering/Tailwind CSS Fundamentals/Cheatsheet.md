
---

**`max-w-sm`:** sets the **maximum width** of an element to a predefined small size:  `24rem = 384px`.

> It means the element’s width can grow normally up to `384px`, but **not beyond that**, even if there’s more space available.  If the screen size is smaller, the element will shrink below 384px to fit the screen.

---

**`min-h-screen`:** ensures the content area has at least the height of the viewport: `100vh` <span style="color:red;"><strong>(floor limit)</strong></span>.

---

**`flex-grow`**: defines how much a flex item should grow relative to the other items when there’s extra space in the flex container.

- flex-grow: 0 → item will not grow (default).
- flex-grow: 1 → item will grow to take up remaining free space (shares equally with others that also have flex-grow: 1).
- Larger numbers (like flex-grow: 2) mean the item gets twice as much free space compared to an item with flex-grow: 1.

Tailwind gives you utility classes that map directly to flex-grow:

|Class|CSS Equivalent|Meaning|
|---|---|---|
|grow|flex-grow: 1;|Item grows to fill available space.|
|grow-0|flex-grow: 0;|Item does not grow.|
|grow-[n]|flex-grow: n;|(Arbitrary value) Grow factor = n.|

---

**`mx-auto`**: It horizontally centers a block-level element inside its parent, but only if the element has a defined width (w-).

The auto margin tells the browser: `"Take up all leftover horizontal space, and split it equally on the left and right.”`

---

**`inset-0`:**  A shorthand utility that sets all four inset properties (top, right, bottom, left) to 0.

**Equivalent CSS**

```
inset-0 {
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}
```

It’s most often used with absolute or fixed positioning to make an element cover its entire parent (or the screen).

**Example 1: Full overlay inside parent**

```
<div class="relative w-64 h-64 bg-gray-200">
  <div class="absolute inset-0 bg-black bg-opacity-50"></div>
</div>
```

The overlay `div` stretches to cover the entire gray parent box.

---

`fixed`: 

---

`box-border`:

---

`justify-center`:

---

`items-center`:

---

`flex`:

---

`max-w-*`:

---

`overflow-y-auto`: controls **vertical scrolling behavior** of an element.

> means: “Show a vertical scrollbar _only if_ the content overflows the element’s height.”

**Behavior**

- If the content **fits** inside the element → ✅ No scrollbar appears.
- If the content **overflows vertically** → 🧭 A vertical scrollbar appears automatically.

---
