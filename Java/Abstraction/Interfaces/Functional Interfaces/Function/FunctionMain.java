import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");

        Function<String, Integer> size = name -> name.length();

        names.stream()
                .map(size)
                .forEach(System.out::println);
    }

}
