
class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    // Different number of arguments
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Different data types of the arguments
    public double add(double a, double b) {
        return a + b;
    }

    // Both
    public double add(double a, double b, int c) {
        return a + b + c;
    }

}

public class Main {

    public static void main(String[] args) {

        Calculator cal = new Calculator();

        System.out.println(cal.add(1, 2, 3));

    }
}