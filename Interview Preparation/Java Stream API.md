
<span style="color:indigo;font-weight:bold;">Q1. Explain the difference between collection and a stream.</span>

A `Collection` is a data structure that stores objects, while a `Stream` is a pipeline that processes objects from a source in a functional and lazy manner.

---

<span style="color:indigo;font-weight:bold;">Q2. Explain LAZY execution in Java streams.</span>

Nothing gets executed until a terminal operation is called.

```java
Stream<Integer> stream = numbers.stream()
	// takes predicate functional interface - inputs object, returns boolean
	.filter(n -> {
		System.out.println("Filtering " + n);
		return n % 2 == 0; 
	});

// Terminal Operation
stream.forEach(System.out::println);
```

---

<span style="color:indigo;font-weight:bold;">Q3. How to convert an array to stream?</span>

An array of non-primitive objects can be converted to stream using `Arrays.stream()` or `Stream.of`.

```java
String[] names = {"Java", "Ruby", "Go"};

// Option 1
Stream<String> stream1 = Arrays.stream(names);

// Option 2
Stream<String> stream2 = Stream.of(names);
```

Primitive arrays do not produce `Stream<Object>` directly.

```java
int[] numbers = {1,2,3,4,5};

IntStream intStream = Arrays.stream(numbers);
// IntStream lets you process sequences of integers functionally without boxing (int -> Integer)

Stream<Integer> stream = intStream.boxed();
```

---

<span style="color:indigo;font-weight:bold;">Q4. Write a program to find the lowest and greatest number in an array of numbers.</span>

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        
        int[] numbers = {1,2,3,4,5};
        
        int maxValue = Arrays.stream(numbers)
            .max()
            .getAsInt();
            
        int minValue = Arrays.stream(numbers)
            .min()
            .getAsInt();
            
        System.out.println("Greatest Value: " + maxValue);
        System.out.println("Lowest Value: " + minValue);
        
    }
}
```

<span style="color:indigo;font-weight:bold;">Follow Up: What modifications are required in case the input is</span> `List<Integer>`<span style="color:indigo;font-weight:bold;">.</span>

- **Option 1:** Convert `Stream<Integer>` to `IntStream`.

```java
int maxValue = numbers.stream()
	.mapToInt(Integer::intValue)
	.max()
	.getAsInt();

int minValue = numbers.stream()
	.mapToInt(Integer::intValue)
	.min()
	.getAsInt();
```

- **Option 2:** Use `max` / `min` with `Comparator`.

```java
int maxValue = numbers.stream()
	.max((a, b) -> a.compareTo(b))
	.getAsInt();
	
int minValue = numbers.stream()
	.min((a, b) -> a.compareTo(b))
	.getAsInt();
```

---

<span style="color:indigo;font-weight:bold;">Q5. Given a</span> `List<Integer>`<span style="color:indigo;font-weight:bold;">, find the first repeated element using Stream API.</span>

```
Example 1:

Input: numbers = [10, 20, 30, 20, 40, 10]
Output: 20
```

<span style="color:green;">A.</span>

```java
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Main {
    public static void main(String[] args) {
        
        List<Integer> numbers = List.of(1,2,3,2,5,6);
        
        Set<Integer> seen = new HashSet<>();
        
        int firstDuplicate = numbers.stream()
            .filter(n -> !seen.add(n))
            .findFirst()
            .orElseThrow();
            
        System.out.println("First Duplicate: " + firstDuplicate);
        
    }
}
```

---

<span style="color:indigo;font-weight:bold;">Q6. Given a list of integers, find the second highest element using Stream API.</span>

```
Example 1:

Input: numbers = [1,2,3,4,5]
Output: 4
```

<span style="color:green;">A.</span>

```java
import java.util.List;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        
        List<Integer> numbers = List.of(1,2,3,2,5,6);
        
        int secondHighest = numbers.stream()
            .distinct() // intermediate operation
            .sorted(Comparator.reverseOrder()) // intermediate operation
            .skip(1) // intermediate operation
            .findFirst() // terminal operation, returns Optional<Integer>
            .get(); // extracts the value from Optional<Integer>
            
        System.out.println("Second Highest: " + secondHighest);
        
    }
}
```

---

<span style="color:indigo;font-weight:bold;">Q7. Given a list of Employee objects, perform the following tasks using Stream API.</span>

1. <span style="color:indigo;font-weight:bold;">For each department, collect the list of employee names</span>
2. <span style="color:indigo;font-weight:bold;">For each department, calculate the average salary</span>

```java
class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    // constructor, getters, setters
}
```

<span style="color:indigo;font-weight:bold;">Example 1:</span>

```java
Input: 

List<Employee> employees = List.of(
	    new Employee(1, "Alice", "IT", 80000),
	    new Employee(2, "Bob", "HR", 50000),
	    new Employee(3, "Charlie", "IT", 90000),
	    new Employee(4, "David", "HR", 60000),
	    new Employee(5, "Eve", "Finance", 70000)
);

Output:

// Group employees by department -> names
{
	"IT": ["Alice", "Charlie"],
	"HR": ["Bob", "David"],
	"Finance": ["Eve"]
}

// Average salary per department
{
	"IT": 85000,
	"HR": 55000,
	"Finance": 70000
}
```

<span style="color:green;">A.</span>

1. For each department, collect the list of employee names

```java
Map<String, List<String>> employeesByDept = employees.stream()
    .collect(Collectors.groupingBy(
        Employee::getDepartment, 
        Collectors.mapping(Employee::getName,
	        Collectors.toList())
    ));
```

2. For each department, calculate the average salary

```java
Map<String, Double> avgSalaryByDept = employees.stream()
	.collect(Collectors.groupingBy(
		Employee::getDepartment,
		Collectors.averagingDouble(Employee::getSalary)
	));
```

---
