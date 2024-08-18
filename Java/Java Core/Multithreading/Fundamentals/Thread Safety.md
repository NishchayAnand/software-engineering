# Understanding Thread Safety

Race conditions can occur when multiple threads share the same mutable variable without coordinating what they’re doing. There are basically four ways to make variable access safe in shared-memory concurrency:

1. **Confinement**: Don’t share variables or data between threads.

2. **Immutability**: Make the shared variables unreassignable or the shared data immutable.

3. **Threadsafe data type**: Encapsulate the shared data in an existing threadsafe data type that does the coordination for you.

4. **Synchronization**: Use synchronization to keep the threads from accessing shared variables or data at the same time. Synchronization is what you need to build your own threadsafe data type.

A data type or method is threadsafe if it behaves correctly when used from multiple threads, regardless of how those threads are executed, and **without demanding additional coordination from the calling code**.

> **NOTE:** "Without additional coordination" means that the data type can’t put preconditions on its caller related to timing, like **"you can't call get() while set() is in progress."**

## Confinement

**Shared mutable state** is the root cause of a race condition. Confinement solves it by not sharing the mutable state.

Local variables are always thread confined. A local variable is stored in the stack, and each thread has its own stack. There may be multiple invocations of a method running at a time (in different threads or even at different levels of a single thread’s stack, if the method is recursive), but each of those invocations has its own private copy of the variable, so the variable itself is confined.

Unlike local variables, static variables are not automatically thread confined.

> **NOTE:** If you have static variables in your program, then you have to make an argument that only one thread will ever use them, and you have to document that fact clearly. Better, you should eliminate the static variables entirely.

## Immutability

Immutability tackles the shared-mutable-state cause of a race condition and solves it simply by making the shared state not mutable.

**A variable declared `final` is unreassignable, and is safe to access from multiple threads.** You can only read the variable, not write it. Be careful, because this safety applies only to the variable itself. The object the variable points to can still be mutated.

In order to be confident that an immutable data type is threadsafe, we need to make sure:

1. no mutator methods
2. all fields are private and final

## Using ThreadSafe Data Types

Our third major strategy for achieving thread safety is to store shared mutable data in existing threadsafe data types. For example, A `StringBuffer` is like a String, but can be modified. String buffers are safe for use by multiple threads. The methods are synchronized where necessary so that all the operations on any particular instance behave as if they occur in some serial order that is consistent with the order of the method calls made by each of the individual threads involved.

> NOTE: Threadsafe data types usually incur a performance penalty compared to an unsafe type.

```
/** MyString is an immutable data type representing a string of characters. */
public class MyString {
    private final char[] a;
    // Thread safety argument:
    //    This class is threadsafe because it's immutable:
    //    - a is final
    //    - a points to a mutable char array, but that array is encapsulated
    //      in this object, not shared with any other object or exposed to a
    //      client, and is never mutated
}
```

## Links

1. https://web.mit.edu/6.031/www/sp19/classes/20-thread-safety/
