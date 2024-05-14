class Calculator {

    // functional interface.
    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {

        Calculator cal = new Calculator();

        IntegerMath addition = (a, b) -> a + b;
        IntegerMath subtraction = (a, b) -> a - b;

        System.out.println("20+2=" + cal.operateBinary(20, 2, addition));
        System.out.println("40-20=" + cal.operateBinary(40, 20, subtraction));

    }

}