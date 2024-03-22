
// Abstract class as a blueprint for shapes
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

// Concrete class implementing Shape (Circle)
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle"); // Call superclass constructor to set name
        this.radius = radius;
    }

    // Fills in the blueprint's placeholder with a specific calculation
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(3);
        System.out.println("Area of circle = " + circle.calculateArea());
    }
}