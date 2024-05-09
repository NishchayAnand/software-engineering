# Understanding Factory Method Design Pattern

- There is more to making objects than just using the new operator. Instantiation is an activity that shouldn't be done in public, because it can lead to coupling problems.

- If we have large large number of objects to create, this method can become a nightmare to maintain. The solution is to create a hierarchy of factory classes, defining a supertype, usually an abstract class and then create **simple factory** class for each object type. This is the idea behind Factory Method Pattern.

```
Sample Code: Factory Method Pattern as a specialization of the `Template` Design Pattern.

public abstract class VehicleFactory {
    public Vehicle configureVehicle(String type, String color) {
        Vehicle v = create(type);
        .
        .
        .
        v.setColor(color);
        v.build();
        .
        .
        .
        return v;
    }

    public abstract Vehicle create(String type); // --> The subclasses would only have to implement this method.
}

```

> NOTE: When you see new, think "concrete".

- Dependency Inversion Principle.
