
To create a **full screen size container** using Tailwind CSS, you can use utility classes that make an element span the entire width and height of the viewport.

---
## How to Make a Full Screen Container

- Use `w-screen` to make the container's width equal to the full width of the viewport.
- Use `h-screen` to make the container's height equal to the full height of the viewport.

```
<div class="w-screen h-screen bg-gray-200">
  <!-- Content here fills the full browser window -->
</div>
```

This will create a container that fills 100% of the viewport's width and height.[](https://v3.tailwindcss.com/docs/container)

---
## Notes for Full Height Containers

- `h-screen` sets the height to the viewport height (100vh).

- <span style="color:green;font-weight:bold;background:beige;">If you want the container to take the full height of the screen minus some fixed element height (like a header), you can use custom height with CSS calc,</span> e.g., `h-[calc(100vh-64px)]`to subtract the header height.[](https://www.reddit.com/r/tailwindcss/comments/v7jarp/how_do_i_make_the_height_of_a_div_the_height_of/)
    
- For full height layouts with flexible content (e.g., navbar height is unknown), you can use flexbox utilities: set the parent to `flex flex-col min-h-screen` and the main content to `flex-grow` to fill remaining space.