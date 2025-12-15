
Theme variables are special CSS variables defined using the `@theme` directive that influence which utility classes exist in your project.

For example, you can add a new color to your project by defining a theme variable like `--color-mint-500`:

```
@theme { 
	--color-mint-500: oklch(0.72 0.11 178);
}
```

Now you can use utility classes like `bg-mint-500`, `text-mint-500`, or `fill-mint-500` in your HTML:

```
<div class="bg-mint-500"> 
	<!-- ... -->
</div>
```

---
### Why `@theme` instead of `:root`?

Theme variables aren't just CSS variables, they also instruct Tailwind to create new utility classes that you can use in your HTML.

Since they do more than regular CSS variables, Tailwind uses special syntax so that defining theme variables is always explicit. Theme variables are also required to be defined top-level and not nested under other selectors or media queries, and using a special syntax makes it possible to enforce that.

Defining regular CSS variables with `:root` can still be useful in Tailwind projects when you want to define a variable that isn't meant to be connected to a utility class. Use `@theme` when you want a design token to map directly to a utility class, and use `:root` for defining regular CSS variables that shouldn't have corresponding utility classes.

---
### Theme variable namespaces

Theme variables are defined in _namespaces_ and each namespace corresponds to one or more utility class or variant APIs.

Defining new theme variables in these namespaces will make new corresponding utilities and variants available in your project:

|Namespace|Utility classes|
|---|---|
|`--color-*`|Color utilities like `bg-red-500`, `text-sky-300`, and many more|
|`--font-*`|Font family utilities like `font-sans`|
|`--text-*`|Font size utilities like `text-xl`|
|`--font-weight-*`|Font weight utilities like `font-bold`|
|`--tracking-*`|Letter spacing utilities like `tracking-wide`|
|`--leading-*`|Line height utilities like `leading-tight`|
|`--breakpoint-*`|Responsive breakpoint variants like `sm:*`|
|`--container-*`|Container query variants like `@sm:*` and size utilities like `max-w-md`|
|`--spacing-*`|Spacing and sizing utilities like `px-4`, `max-h-16`, and many more|
|`--radius-*`|Border radius utilities like `rounded-sm`|
|`--shadow-*`|Box shadow utilities like `shadow-md`|
|`--inset-shadow-*`|Inset box shadow utilities like `inset-shadow-xs`|
|`--drop-shadow-*`|Drop shadow filter utilities like `drop-shadow-md`|
|`--blur-*`|Blur filter utilities like `blur-md`|
|`--perspective-*`|Perspective utilities like `perspective-near`|
|`--aspect-*`|Aspect ratio utilities like `aspect-video`|
|`--ease-*`|Transition timing function utilities like `ease-out`|
|`--animate-*`|Animation utilities like `animate-spin`|

---
