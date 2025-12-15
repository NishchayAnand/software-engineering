
Create semantic tokens in `globals.css`:

```
:root {
  /* Base colors */
  --background: 0 0% 100%;
  --foreground: 222.2 84% 4.9%;

  /* Surfaces */
  --card: 0 0% 100%;
  --card-foreground: 222.2 84% 4.9%;

  /* Borders & inputs */
  --border: 214.3 31.8% 91.4%;
  --input: 214.3 31.8% 91.4%;

  /* Accent & states */
  --primary: 222.2 47.4% 11.2%;
  --primary-foreground: 210 40% 98%;

  --muted: 210 40% 96.1%;
  --muted-foreground: 215.4 16.3% 46.9%;
}
```

Dark mode override:

```
.dark {
  --background: 240 10% 3.9%;
  --foreground: 210 40% 98%;

  --card: 240 10% 6%;
  --card-foreground: 210 40% 98%;

  --border: 240 4% 20%;
  --input: 240 4% 20%;

  --primary: 210 40% 98%;
  --primary-foreground: 222.2 47.4% 11.2%;
}
```

> 🔑 **Rule**: Tokens describe purpose, not color (`background`, not `gray-900`).

---

