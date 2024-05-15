# Understanding Comparable Interface

A functional interface that provides a single method, `compareTo`, which can be used to compare the current object with another object of the same type.

Unlike the `Comparator` interface, it focuses on defining a natural ordering for the objects themselves.

> Natural ordering refers to the default sorting behavior defined within the class itself.

## How it's used?

A class defines its natural ordering by implementing the `Comparable` interface. The `compareTo` method within this interface specifies how objects of that class should be compared and ordered. For example,

```
class Person implements Comparable<Person> {
  private String name;
  private int age;

  // Getters and setters omitted for brevity

  @Override
  public int compareTo(Person other) {
    return this.age - other.getAge();
  }
}

// Usage
List<Person> people = new ArrayList<>();
// ... (add people to the list)

Collections.sort(people);

// Now people is sorted by name (ascending order) based on Person's compareTo
```

## Benefits:

- **Simplicity:** Easier to implement compared to creating a **custom comparator**, especially for basic sorting criteria based on a single property.
- **Readability:** Code can be more readable when the sorting logic is directly tied to the class definition.

## Key Examples:

- Sorting a list of strings sorts them alphabetically by default because the `String` class implements Comparable with a natural ordering based on character order.
- Sorting a list of numbers sorts them numerically (ascending or descending) because the corresponding number wrapper classes `(e.g., Integer, Double)` also implement Comparable.

## Comparison with Comparator:

- Natural ordering is defined within the class itself using Comparable.
- A Comparator provides a way to define an external sorting order independent of the object's natural order. You can use a comparator to sort objects based on any criteria, even if they don't implement Comparable.

## Key Points:

- Natural ordering is not mandatory. Classes can choose not to implement `Comparable` if they don't have a natural ordering or if you want more control over sorting with a **custom** `Comparator`.
- Natural ordering should be consistent with the equals method. If two objects are considered equal by equals, their compareTo method should also return zero.
