import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String args[]) {

        // Create a stream from a list.
        System.out.println("Stream using list:");
        List<String> names = Arrays.asList("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
        Stream<String> streamFromList = names.stream();
        streamFromList.forEach(System.out::println);

        // Create stream from an array.
        System.out.println("Stream using array:");
        String[] namesArray = { "Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie" };
        Stream<String> streamFromArray = Arrays.stream(namesArray);
        streamFromArray.forEach(System.out::println);

        // Create a stream from individual values
        System.out.println("Stream using value:");
        Stream<String> streamFromValues = Stream.of("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
        streamFromValues.forEach(System.out::println);

    }
}