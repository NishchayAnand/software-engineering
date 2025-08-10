# Understanding Enum

A special data type that represents a fixed set of constants. For example, enums are perfect for representing days of the week.

```
public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}
```

## How Fields, Constructors, and Methods Work in Enums

1. **Fields**: Enums can have fields (instance variables) to store additional data for each constant. These fields must be `final` if they are meant to be immutable.

2. **Constructors**: Enums can have constructors, but these are always `private` (implicitly or explicitly) since enums cannot be instantiated directly. The constructor is used to set the values of the fields when each constant is created.

3. **Methods**: Enums can define methods to add specific behaviors for each constant. This allows each constant to act somewhat like an object with unique properties and actions.


```
public enum SeatType {

    NORMAL(250),
    PREMIUM(400),
    VIP(550);

    private final int price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
```
