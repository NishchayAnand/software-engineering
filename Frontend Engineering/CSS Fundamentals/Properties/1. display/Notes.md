# Understanding CSS display property

The CSS `display` property allows you to **control the layout of an HTML element**, i.e., how it is is displayed on the screen and how it interacts with other elements in the document flow.

Some common values of the `display` property include:

- **inline:**

  - Only **occupy the space bounded by the content**.
  - Allow other elements to sit alongside them.
  - Can't have set width/height.
  - Margins/padding might only affect the left and right, not top and bottom.
  - Examples include `<span>`, `<a>`, `<strong>`, etc.

- **block:**

  - **Take up the full width available**.
  - Start on a new line.
  - Can have margins, padding, and width/height properties.
  - Examples include `<div>`, `<p>`, `<h1>` to `<h6>`, etc.

- **inline-block:**

  - Only occupy the space bounded by the content.
  - Allow other elements to sit beside them.
  - **Can have set width/height and margins/padding (just like block elements).**

- **none:**

  - Do not appear on the screen.
  - Do not take up any space.
  - **Often used for hiding elements.**

- **flex:**

  - A **_one-dimensional layout model_** that provides an efficient way to align and distribute space among items (`flex items`) in a container (`flex container`).

- **grid:**
  - A **_two-dimensional layout model_** that provides an efficient way to arrange elements in rows and columns within a container.
