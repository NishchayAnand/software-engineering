# Understanding Comparator Interface

A functional interface that provides a way to define a custom sorting order for objects that don't have a natural ordering themselves.

## What is Does?

Defines a single abstract method called `compare`. This method takes two objects of the same type (T) as arguments and returns an integer value based on the comparison:

- **Positive integer:** The first object is considered greater than the second.
- **Zero:** The objects are considered equal.
- **Negative integer:** The first object is considered less than the second.

## How it's used?

You create a class that implements the `Comparator` interface, overriding the compare method to define your specific sorting criteria. Sorting methods like `Arrays.sort()` or `Collections.sort()` can use the objects of these custom comparator classes to determine the order in which the objects should be arranged. For example,

```
class Person {
  private String name;
  private int age;

  // Getters and setters omitted for brevity
}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getAge() - p2.getAge(); // can also use -> Integer.compare(person1.getAge(), person2.getAge());
    }

}

// Usage
List<Person> people = new ArrayList<>();
// ... (add people to the list)

Collections.sort(people, new AgeComparator());
```

Instead of creating a separate class that implements Comparator, you can define the comparison logic directly within a `lambda expression`. For example,

```
List<Person> people = new ArrayList<>();
// ... (add people to the list)

// Sorting by age (ascending order) with lambda
Collections.sort(people, (Person p1, Person p2) -> p1.getAge() - p2.getAge());
```

## Comparison with Comparable:

- **Separates the sorting logic from the class being sorted,** allowing you to sort collections based on any property of the objects, not just the ones they use for their natural ordering (defined by `Comparable`). This gives you much more control over the sorting criteria.

## Key Points:

Java provides some pre-defined comparators for common types like `String` and `Integer`. You can use these directly or create your own for more complex sorting needs.
