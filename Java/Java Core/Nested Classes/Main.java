
class OuterClass {

    private int var1 = 1;

    class InnerClass {

        void display() {
            System.out.println(var1);
        }

    }

    static class StaticNestedClass {

        void display() {
            // System.out.println(var1); -> will give error: "Static methods cannot access
            // non-static fields"
        }
    }

}

public class Main {
    public static void main(String[] args) {

        OuterClass outerObject = new OuterClass();
        OuterClass.InnerClass innerObject = outerObject.new InnerClass();

        innerObject.display();

    }
}