# Understanding Grid Layout in CSS

A **_two-dimensional layout model_** that provides an efficient way to arrange elements in rows and columns within a container.

By default, CSS Grid uses a single column, and will create rows as needed, based on the number of children. This is known as an **implicit grid**, since we aren't explicitly defining any structure.

> **NOTE:** Implicit grids are dynamic, i.e., rows will be added and removed based on the number of children. Each child gets its own row.

## grid-template-columns

Used to define the structure and sizing of the columns within a grid container. It specifies the number of columns, their minimum width, and any potential gaps between them.

Sample Code:

```
.grid-container {
  display: grid;
  grid-template-columns: 1fr 200px; /* Define two columns */
}
```

In the above example, we have defined a grid layout with two columns, where:

- **first column** takes up `1fr` of the space, meaning it will be flexible and adjust its width based on the remaining space.
- **second column** has a fixed width of `200px`.

> **NOTE:** Multiple `fr` values define how the remaining space is proportionally divided among the columns. For instance, grid-template-columns: 1fr 2fr creates two columns: the first takes one-third of the space, and the second takes two-thirds.
