# Understanding Method Overloading

Method overloading is a feature that lets you define multiple methods within a class that share the **same name**, as long as the **arguments** they take **are different**. The difference can be in the number of arguments, the data types of the arguments, or both.

> Method Overloading promotes the **"One Name, Different Behaviors"** philosophy behind polymorphism.

Here’s an example to illustrate method overloading in Java:

```
class Calculator {

  public int add(int a, int b) {
    return a + b;
  }

  // Different number of arguments
  public int add(int a, int b, int c) {
    return a + b + c;
  }

  // Different data types of the arguments
  public double add(double a, double b) {
    return a + b;
  }

  // Both
  public double add(double a, double b, int c) {
    return a + b + c;
  }

}
```

Here are some things to consider about method overloading in Java:

- **Return type:** Unlike argument lists, the return type of overloaded methods can be the same or different. Method overloading focuses on differentiating methods based on their arguments.

- **Static or Compile-time Polymorphism:** Method overloading is an example of compile-time polymorphism. The compiler determines which overloaded method to call based on the arguments provided at the time of the call.
