# Understanding Nested Classes

The Java programming language **allows you to define a class within another class**. Such a class is called a nested class and is illustrated here:

```
class OuterClass {
    ...
    class NestedClass {
        ...
    }
}
```

> NOTE: Outer classes can only be declared public or package private, whereas, nested classes can be declared private, public or protected.

## Why use Nested Classes?

Compelling reasons for using nested classes include the following:

- **It is a way of logically grouping classes that are only used in one place:** If a class is useful to only one other class, then it is logical to embed it in that class and keep the two together. Nesting such "helper classes" makes their package more streamlined.

- **It increases encapsulation:** Consider two top-level classes, A and B, where B needs access to members of A that would otherwise be declared private. By hiding class B within class A, A's members can be declared private and B can access them. In addition, B itself can be hidden from the outside world.

- **It can lead to more readable and maintainable code:** Nesting small classes within top-level classes places the code closer to where it is used.

## Types of Nested Classes

Nested classes are divided into two categories:

- **non-static (a.k.a inner classes)**
- **static**

## What are Inner Classes?

As with instance methods and variables, an inner class is associated with an instance of its enclosing class and has direct access to that object's methods and fields.

> NOTE: Because an inner class is associated with an instance, it cannot define any static members itself.

Objects that are instances of an inner class exist within an instance of the outer class.

An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.

To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:

```
OuterClass outerObject = new OuterClass();
OuterClass.InnerClass innerObject = outerObject.new InnerClass();
```

There are two special kinds of inner classes: `local classes` and `anonymous classes`.

## What are Static Nested Classes?

As with class methods and variables, a static nested class is associated with its outer class. And like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class: it can use them only through an object reference.

A static nested class interacts with the instance members of its outer class (and other classes) just like any other top-level class. In effect, a static nested class is behaviorally a top-level class that has been nested in another top-level class for packaging convenience.

You instantiate a static nested class the same way as a top-level class:

```
StaticNestedClass staticNestedObject = new StaticNestedClass();
```

Note that a static nested class interacts with the instance members of its outer class just like any other top-level class. The static nested class StaticNestedClass can't directly access outerField because it's an instance variable of the enclosing class, OuterClass.

### Shadowing

If a declaration of a type (such as a member variable or a parameter name) in a particular scope (such as an inner class or a method definition) has the same name as another declaration in the enclosing scope, then the declaration shadows the declaration of the enclosing scope. You cannot refer to a shadowed declaration by its name alone. The following example, ShadowTest, demonstrates this:

```
public class ShadowTest {

    public int x = 0;

    class FirstLevel {

        public int x = 1;

        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
    }

}
```

The following is the output of this example:

x = 23
this.x = 1
ShadowTest.this.x = 0

> NOTE: keyword this represents the enclosing scope. Refer to member variables that enclose larger scopes by the class name to which they belong.

---

Links:

- https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
