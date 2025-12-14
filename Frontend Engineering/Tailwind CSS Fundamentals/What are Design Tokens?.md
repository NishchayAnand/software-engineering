
Design tokens are named, reusable values that represent the visual design decisions of a product. They are the single source of truth for how your UI looks.

> Instead of hard-coding `#0f172a`, `16px`, or `Inter` everywhere, you give them meaningful names like `primary`, `spacing-md`, `font-sans`.

---
### Without design tokens (❌ bad)

```
.card {
  background: #0f172a;
  padding: 16px;
  border-radius: 8px;
}
```

Problems:

- Hard to change globally
- No meaning
- Designers & developers don’t share a language

---
### With design tokens (✅ good)

```
.card {
  background: var(--color-background);
  padding: var(--spacing-md);
  border-radius: var(--radius-md);
}
```

Now:

- One change updates the entire app
- Tokens express intent, not raw values

---
