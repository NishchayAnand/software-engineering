import java.util.Arrays;
import java.util.List;

public class Filter {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
        names.stream()
                .filter(str -> str.length() > 5)
                .forEach(System.out::println);

    }

}
