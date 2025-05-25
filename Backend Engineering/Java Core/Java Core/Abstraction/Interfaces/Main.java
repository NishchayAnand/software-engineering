interface Shape {
    // Constants
    double PI = 3.14159;

    // Method signature
    double calculateArea();

    // Static Method
    static void StaticMethod() {
        System.out.println("This is a static method.");
    }

    // Default Method
    default void DefaultMethod() {
        System.out.println("This is the default method defined in the Shape interface");
    }
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

    /*
     * @Override
     * public void DefaultMethod() {
     * System.out.
     * println("This is the overridden default method defined in the implementing class Circle."
     * );
     * }
     */

}

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Circle(3);
        System.out.println("Area of circle = " + rectangle.calculateArea());

        // Calling shape interface's default method
        rectangle.DefaultMethod();

        // Calling Shape interface's static method
        Shape.StaticMethod();

    }
}
