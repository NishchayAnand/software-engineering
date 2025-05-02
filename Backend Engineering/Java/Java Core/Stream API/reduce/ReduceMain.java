import java.util.stream.Stream;
import java.util.function.BinaryOperator;

public class ReduceMain {

    public static void main(String[] args) {

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        int total = numbers.reduce(0, sum); // Here, 0 serves as the identity or initial value for the reduction
                                            // operation.

        System.out.println("Total: " + total);

    }

}
