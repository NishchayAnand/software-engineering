# Understanding Aggregation

Aggregation represents a "has-a" relationship between objects. One class (the whole) contains a reference to another class (the part), but the part can still exist independently.

Example: Car and Engine

A car has-an engine, but the engine can potentially be used in other vehicles or for other purposes.

```
class Engine {
  private String type;

  public Engine(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}

class Car {
  private String model;
  private Engine engine;

  public Car(String model, Engine engine) {
    this.model = model;
    this.engine = engine;
  }

  public String getModel() {
    return model;
  }

  public Engine getEngine() {
    return engine;
  }
}

```
