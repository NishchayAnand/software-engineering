interface Shape {
    // Constants
    double PI = 3.14159;

    // Method signature
    double calculateArea();
}

// Class implementing the interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Circle(3);
        System.out.println("Area of circle = " + rectangle.calculateArea());
    }
}
