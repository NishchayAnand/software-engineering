import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class BinaryOperatorMain {

    public static void main(String[] args) {

        BinaryOperator<Integer> multiply = (a, b) -> a * b;

        System.out.println(multiply.apply(2, 3));

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);

        numbers.map(n -> multiply.apply(n, 2)).forEach(System.out::println);
    }

}
