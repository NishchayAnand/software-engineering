# Understandind Open-Closed Principle

- Classes should be resilient. This is good because it allows later for new features to be added to software without changing existing code. That idea is often formalized in the Open-Closed Principle.

- Open-Closed Principle: "Classes and methods should be open for extension, but closed for modification."

- The reasoning behind this is to avoid modifying existing code because client code depends on it, but to allow it to be extended because extensions are a necessary response to new requirements.

- Identify the aspects of your application that vary and separate them from what stays the same. Here's another way to think about this principle: "Take the parts that vary and encapsulate them, so that later you can alter or extend the parts that vary without affecting those that don't."

- While the OCP is often phrased as "Classes should be open for extension, but closed for modification," this principle also emphasizes identifying variability and isolating it from stable parts of the code. This allows for future changes to be implemented through extensions without modifying the core functionality.

EXTRA:

- Applying this principle is actually a combination of applying encapsulation and abstraction. The bahviour that stays the same is abstracted into a base class and locked for modification.
