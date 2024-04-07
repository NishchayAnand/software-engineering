# Understanding Single Responsibility Principle

The Single Responsibility Principle (SRP) states that **"A class should have only one reason to change."** This means each class should be designed to handle a specific set of functionalities that are closely related.

SRP promotes high `cohesion` within a class. This means all the methods and properties within a class should work together towards its single responsibility. Methods that seem out of place might indicate a violation of SRP.

> **Cohesion:** Measures how well the elements (methods and data) within a class are related and work together towards a single purpose. Remember Cohesion as "degree of interdependence of elements within a class."

**Identifying different responsibilities** in a class is a crucial step in applying the Single Responsibility Principle (SRP). Here's how you can approach it:

- **Analyze Class Behavior:** Start by examining the methods provided by the class. What kind of actions do they perform? Are they all related to a single concept or functionality?

- **Break Down Functionality:** Categorize the methods based on the tasks they accomplish. Look for natural groupings that represent distinct functionalities.

- **Identify the "Why" Behind Changes:** Consider why the class might need to change in the future. Would changes be driven by modifications to the user interface, data storage mechanisms, or internal calculations? If a single class change could be triggered by multiple reasons, it might have multiple responsibilities.

**Here's an example:**

Imagine a class named `Order` that handles:

- Adding or removing items from the order
- Calculating the total price (including taxes)
- Saving the order details to a database

```
public class Order {

  private List<Item> items;
  private double subtotal;
  private double taxRate;

  public Order(List<Item> items, double taxRate) {
    this.items = items;
    this.taxRate = taxRate;
  }

  public void addItem(Item item) {
    items.add(item);
    calculateSubtotal();
  }

  public void removeItem(Item item) {
    items.remove(item);
    calculateSubtotal();
  }

  public double calculateTotal() {
    return subtotal * (1 + taxRate);
  }

  private void calculateSubtotal() {
    subtotal = 0;
    for (Item item : items) {
      subtotal += item.getPrice();
    }
  }

  // Methods for saving order to database (not shown for brevity)
}
```

While these tasks seem related to `Order`, they represent different functionalities. Following SRP, you could split this into three separate classes:

- `Order` **class:**: This class would focus solely on representing the order itself. It might have methods to calculate the subtotal (without tax) and add/remove items.

```
// Order class (represents the order itself)
public class Order {

  private List<Item> items;
  private double subtotal;

  public Order(List<Item> items) {
    this.items = items;
  }

  public List<Item> getItems() {
    return items;
  }

  public void addItem(Item item) {
    items.add(item);
    calculateSubtotal();
  }

  public void removeItem(Item item) {
    items.remove(item);
    calculateSubtotal();
  }

  private void calculateSubtotal() {
    subtotal = 0;
    for (Item item : items) {
      subtotal += item.getPrice();
    }
  }

  public double getSubtotal() {
    return subtotal;
  }
}
```

- `OrderCalculator` **class:** This class would take an `Order` object and calculate the total price with taxes. If we need to change how the tax is calculated, we only modify the OrderCalculator class.

```
// OrderCalculator class (calculates total price)
public class OrderCalculator {

  public static double calculateTotal(Order order, double taxRate) {

    return order.getSubtotal() * (1 + taxRate);
  }
}

```

- `OrderPersistence` **class:** This class would handle saving the order details to a database.

```
// OrderPersistence class (saves order to database - not shown for brevity)
```

> **_NOTE:_** Remember **Single Responsibility Principle** as **"one class, one responsibility."**
