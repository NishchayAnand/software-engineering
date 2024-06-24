# Understanding Flexbox Layout in CSS

Flexbox (Flexible Box Layout) is a **_one-dimensional layout model_** that provides an efficient way to align and distribute space among items (`flex items`) in a container (`flex container`).

The main idea behind flex layout is to give container the ability to alter its items to best fill the available space, allowing us to create responsive layouts that adapt to different screen sizes and orientations.

## Flexbox Properties

1. `display: flex`: This defines the flex container.

2. `justify-content`: Helps in distributing the extra free space leftover between items along the main axis. For example, `justify-content: space-between` will position the first item at the start and the last item at the end of the container, with even spacing between the remaining items.

3. `align-items`: Defines the default behavior for how flex items are laid out along the **cross axis** on the current line. For example, `align-items` will center the items along the cross axis.
