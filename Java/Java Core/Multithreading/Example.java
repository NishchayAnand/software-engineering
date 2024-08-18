
public class Example {

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String args[]) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                factorial(10);
            }
        }).start();

        factorial(12);
    }

}
