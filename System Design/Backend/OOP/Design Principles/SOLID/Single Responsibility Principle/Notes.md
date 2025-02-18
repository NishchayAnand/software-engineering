# Understanding Single Responsibility Principle (SRP)

The Single Responsibility Principle (SRP) states that **"A class should have only one reason to change."** This means each class should be designed to handle a specific set of functionalities that are closely related.

SRP promotes high `cohesion` within a class. This means all the methods and properties within a class should work together towards its single responsibility. Methods that seem out of place might indicate a violation of SRP.

> **Cohesion:** Measures how well the elements (methods and data) within a class are related and work together towards a single purpose. Remember Cohesion as "degree of interdependence of elements within a class."

**Identifying different responsibilities** in a class is a crucial step in applying the Single Responsibility Principle (SRP). Here's how you can approach it:

- **Analyze Class Behavior:** Start by examining the methods provided by the class. What kind of actions do they perform? Are they all related to a single concept or functionality?

- **Break Down Functionality:** Categorize the methods based on the tasks they accomplish. Look for natural groupings that represent distinct functionalities.

- **Identify the "Why" Behind Changes:** Consider why the class might need to change in the future. Would changes be driven by modifications to the user interface, data storage mechanisms, or internal calculations? If a single class change could be triggered by multiple reasons, it might have multiple responsibilities.

**Here's a simple example in Java demonstrating Single Responsibility Principle:**

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

- `OrderCalculator` **class:** This class would take an `Order` object and calculate the total price with taxes. If we need to change how the tax is calculated, for example, incorporate different taxes based on order quantities, we only modify the OrderCalculator class.

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

## EXTRA

**A module should have one, and only one, reason to change.** Software systems are changed to satisfy users and stakeholders. Those **users and stakeholders** are the **"reason to change"** that the principle is talking about.

There will likely be more than one user or stakeholder who wants the system changed in the same way. Instead, we're really referring to a group of one or more people who require that change. We'll refer to that group as an `actor`.

```
Employee (class)
  + calculatePay() -> used by the accounting department, which reports to the CFO.
  + reportHours()  -> used by the human resources department, which reports to the COO.
  + save()         -> used by the database administrators (DBAs), who reports to the CTO.
```

By putting the source code for the above three methods into a single Employee class, the developers have coupled each of these actors to the others. This coupling can cause the actions of the CFO's team to affect something that the COO's team depend on.

For example, suppose that the `calculatePay()` and `reportHours()` method share a common algorithm for calculating non-overtime hours: `regularHours()`. Now suppose that the CFO's team decides that the way non-overtime hours are calculated needs to be tweaked. In contrast, the COO's team does not want that particular tweat because they use non-overtime hours for a different purpose.

A developer is tasked to make the change, and sees the convenient `regularHours()` function called by the `calculatePay()` method. Unfortunately, that developer does not notice that the function is also used by the `reportHours()` function.

The developer makes the required changes and carefully tests it. The CFO's team validates that the new function works as desired, and the system is deployed.

Of course, the COO's team doesn't know that this is happening. The HR personnel continue to use the reports generated by the `reportHours()` function, but now they contain incorrect numbers. Eventually the problem is discovered, and the COO is livid because the bad data has cost his budget millions of dollars.

**SRP says to separate the code that different actors depend on.**

The most obvious way to solve the problem is to **separate the data from the functions (separation of concerns principle).** Create three classes that share access to `EmployeeData`, which is a simple data structure with no methods.

```
interface HoursCalculator {
    int calculateRegularHours(Employee employee);
}

class DefaultHoursCalculator implements HoursCalculator {
    @Override
    public int calculateRegularHours(Employee employee) {
        // Default implementation of calculating regular hours
        return employee.getRegularHours();
    }
}

class Employee {
    private int regularHours;
    // ... other employee attributes

    public int getRegularHours() {
        return regularHours;
    }
    // ... other employee methods
}

class PayrollCalculator {
    private final HoursCalculator hoursCalculator;

    public PayrollCalculator(HoursCalculator hoursCalculator) {
        this.hoursCalculator = hoursCalculator;
    }

    public double calculatePay(Employee employee) {
        int regularHours = hoursCalculator.calculateRegularHours(employee);
        // ... calculate pay based on regular hours
        return calculatedPay;
    }
}

class TimeTracker {
    private final HoursCalculator hoursCalculator;

    public TimeTracker(HoursCalculator hoursCalculator) {
        this.hoursCalculator = hoursCalculator;
    }

    public void reportHours(Employee employee) {
        int regularHours = hoursCalculator.calculateRegularHours(employee);
        // ... report hours based on regular hours
    }
}

class EmployeeDataRepository {
    // Methods for saving and retrieving employee data
}
```

The downside of this solution is that developers (clients) now have three classes that they have to instantiate and track. A common solution to this dilemma is to use **FACADE PATTERN**.

```
public class EmployeeFacade {
    private final PayrollCalculator payrollCalculator;
    private final TimeTracker timeTracker;
    private final EmployeeDataRepository employeeDataRepository;

    public EmployeeFacade() {
        // Dependency injection or creation of components here
        payrollCalculator = new PayrollCalculator(new DefaultHoursCalculator());
        timeTracker = new TimeTracker(new DefaultHoursCalculator());
        employeeDataRepository = new EmployeeDataRepository();
    }

    public double calculatePay(Employee employee) {
        return payrollCalculator.calculatePay(employee);
    }

    public void reportHours(Employee employee) {
        timeTracker.reportHours(employee);
    }

    public void saveEmployee(Employee employee) {
        employeeDataRepository.saveEmployee(employee);
    }
}
```
