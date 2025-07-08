# Understanding Adaptor Design Pattern

**DEFINITION: Converts the interface of a class into another interface the clients expect.**

The Adapter Pattern is a structural design pattern that allows incompatible interfaces to work together.

Imagine you have a client that can only interact with the old interface, even if a new and better interface is now available. You can use an `Adapter` to **wrap the new interface object into a class implementing the old interface**. This way, the adapter will delegate the client's requests to the wrapped new interface object.

> **NOTE:** The primary intent of an `Adapter` is to alter an interface so that it matches the one a client is expecting.

## Sample Code: Java

Suppose you have an old interface `OldInterface` and a new interface `NewInterface` and your task it to adapt the new interface to be compatible with the old interface.

```
public interface OldInterface {
    void oldRequest();
}

public interface NewInterface {
    void newRequest();
}

public class NewImplementation implements NewInterface {
    @Override
    public void newRequest() {
        System.out.println("New request implementation.");
    }
}

public class Adapter implements OldInterface {
    private NewInterface newInterface;

    public Adapter(NewInterface newInterface) {
        this.newInterface = newInterface;
    }

    @Override
    public void oldRequest() {
        newInterface.newRequest();
    }
}
```
