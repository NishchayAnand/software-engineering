import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {

        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> greaterThanThree = num -> num > 3;
        Predicate<Integer> isEvenAndGreaterThanThree = isEven.and(greaterThanThree);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(isEvenAndGreaterThanThree)
                .forEach(System.out::println);

    }

}
