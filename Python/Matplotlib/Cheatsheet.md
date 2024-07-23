# Matplotlib Cheatsheet

Matplotlib is designed to generate static, interactive, and animated visualizations in Python. It provides a **MATLAB** like interface for plotting.

## Basic Components

- `Figure`: The top-level container that holds all the elements of a plot. Use `fig = plt.figure()` to create a figure with default size.

- `Axes`: The central plotting area within a **Figure**. It's where you'll actually plot your data, add labels, titles, legends, etc. Use `ax = fig.add_subplot(rows, cols, index)` to add a subplot in an existing figure object.

## Common Plot Types

1. **Line Plot:** Useful for displaying trends over time. Sample Syntax: `plt.plot(x, y)`

2. **Scatter Plot:** Useful for showing the relationship between two variables. Sample Syntax: `plt.scatter(x, y)`

3.
