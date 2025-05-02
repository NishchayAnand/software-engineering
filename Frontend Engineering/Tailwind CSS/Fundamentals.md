
 **Q. What are the default responsive breakpoints in Tailwind CSS?**

| **Breakpoint** | **Min Width** | **Common Devices**     | **Media Query**            |
| -------------- | ------------- | ---------------------- | -------------------------- |
| `sm`           | 640px         | Small tablets          | `@media (width >= 640px)`  |
| `md`           | 768px         | Tablets                | `@media (width >= 768px)`  |
| `lg`           | 1024px        | Laptops                | `@media (width >= 1024px)` |
| `xl`           | 1280px        | Desktops               | `@media (width >= 1280px)` |
| `2xl`          | 1536px        | Large screens/monitors | `@media (width >= 1536px)` |

> **NOTE:** These breakpoints can be customised in your `tailwind.config.js` file.

---

**Q. In a web application built using TailwindCSS, you notice that on pages with very little content, the footer appears awkwardly halfway up the screen instead of sticking at the bottom. How would you fix this issue using Tailwind utilities? Explain your approach.**

The issue happens because the content doesn’t naturally fill the viewport height. To fix this, apply the `min-h-screen` class to the container (like the `<main>` tag or `<div>` wrapping the page content). This ensures the content area has at least the height of the viewport (`100vh`), pushing the footer to the bottom even when there's little content.

```
<div className="min-h-screen flex flex-col">
  <main className="flex-grow">
    {/* Page Content */}
  </main>
  <footer>
    {/* Footer */}
  </footer>
</div>
```

---

**Q. In a responsive web layout, how would you make sure that a footer always sticks to the bottom of the page, even when the main content is very short, without using absolute positioning?**

- Wrap everything in a `flex flex-col min-h-screen` container.
- Set `flex-grow` on the `<main>` so it expands and fills available space.
- Footer remains naturally at the bottom without needing absolute or fixed positioning.

```
<div class="flex flex-col min-h-screen">
  <main class="flex-grow">
    <!-- Main content -->
  </main>
  <footer class="bg-gray-200 p-4">
    <!-- Footer content -->
  </footer>
</div>
```

---

