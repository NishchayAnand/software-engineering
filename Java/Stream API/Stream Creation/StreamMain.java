import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String args[]) {

        // Create a stream from a list
        List<String> names = Arrays.asList("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
        Stream<String> streamFromList = names.stream();
        streamFromList.forEach(System.out::println);

    }
}