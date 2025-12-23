
Flexbox spec says:

> `min-width: auto` = content’s intrinsic width

By default, **flex items have `min-width: auto`**, which means:

> “I refuse to be smaller than my content.”

So if a child contains:

- long text
- code
- URLs
- inputs

…it will **overflow its container**, even when the parent has limited width.

So even if you use:

- `flex-1`
- `flex-auto`
- `overflow-hidden`

…it **still won’t shrink** unless you explicitly allow it with `min-w-0`.

