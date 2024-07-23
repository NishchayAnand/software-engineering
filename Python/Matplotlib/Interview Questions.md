# Matplotlib Interview Questions

**Q. Why `plt.plot` doesn't explicitly require creating Figure and Axes?**

Matplotlib creates a default Figure and Axes for you when you call `plt.plot` for the first time. This default behavior makes it easy to get started with plotting. However, for more complex visualizations or when you need granular control over your plots, explicitly creating axes is recommended.
