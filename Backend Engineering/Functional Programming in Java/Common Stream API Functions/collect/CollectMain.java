import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class CollectMain {

    public static void main(String[] args) {

        Stream<String> names = Stream.of("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");

        // Using a collector to collect strings into a list
        List<Integer> nameLength = names.map(n -> n.length()).collect(Collectors.toList());

        nameLength.stream().forEach(System.out::println);

    }

}
