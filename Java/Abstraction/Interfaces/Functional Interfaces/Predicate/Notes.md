# Understanding Predicate Functional Interface

- It contains a single abstract method called `test` that takes an object as a parameter and returns a **boolean**.

```
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
    ... (contains a bunch of default methods such as 'and', 'or', 'negate' to peform basic operations such as AND, OR, NEGATE on 2 or more predicates).
}
```

```
Predicate<Person> p = person -> person.getAge() > 20;
```

```
Predicate<Integer> p1 = person -> i -> i>20;
Predicate<Integer> p1 = person -> i -> i<30;
Predicate<Integer> p = p1.and(p2);
```

## Sample Examples:

- Take a list of strings, filter few of them out and add he filtered elements to another list:

```
Stream<String> stream = Stream.of("one", "two", "three", "four");
Predicate<String> p1 = Predicate.isEqual("two");
Predicate<String> p2 = Predicate.isEqual("three");
List<String> list = new ArrayList<>();
stream
    .peek(System.out::println);
    .filter(p1.or(p2));
    .forEach(list::add);
```
