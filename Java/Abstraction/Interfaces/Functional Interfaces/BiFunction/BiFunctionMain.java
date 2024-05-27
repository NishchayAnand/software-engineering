import java.util.function.BiFunction;
import java.util.stream.Stream;

public class BiFunctionMain {

    public static void main(String[] args) {

        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);
        numbers.map(n -> multiply.apply(n, 2)).forEach(System.out::println);

    }

}
