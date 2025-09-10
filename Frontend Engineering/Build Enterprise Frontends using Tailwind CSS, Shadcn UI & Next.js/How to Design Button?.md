
---
### Create Button using basic HTML and CSS


---
### Create Button using Shadcn

With shadcn, the `Button` is just a styled wrapper.

If action **navigates to another page/route** → use **`Link`** (styled as a button with `asChild`).

- `asChild` tells the `Button` to render its child directly (instead of a `<button>`).
- So when you put `<Link />` inside, the underlying element becomes an `<a>` styled like a button.

```
<Button variant="default" asChild>
  <Link href="/signin">Sign In</Link>
</Button>
```

If action **submits a form or triggers client-side logic** → use **`Button`** directly.

```
<Button variant="outline">Button</Button>
```

---
### How to change the color?


To make all default buttons black, update the primary color variable in your theme. In your `globals.css` or theme configuration:

```
:root {
  --primary: 0, 0%, 0%; /* HSL for black */
  --primary-foreground: 0, 0%, 100%; /* HSL for white text */
}
```

---
### How to change the size?

The size of a **Shadcn button** can be changed by using the built-in `size` prop.

---
