
// Abstract Class as a blueprint for shapes
abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Placeholder (abstract method) for calculating area
    public abstract double calculateArea();
}

// Class implementing the interface
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        super("Rectangle");
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Rectangle(3, 4);
        System.out.println("Area of rectangle = " + circle.calculateArea());
    }
}
