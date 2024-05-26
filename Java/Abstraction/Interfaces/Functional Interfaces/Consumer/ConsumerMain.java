
import java.util.function.Consumer;;

public class ConsumerMain {

    public static void main(String[] args) {

        // Consumer to convert to uppercase
        Consumer<String> toUpper = str -> System.out.println(str.toUpperCase());

        // Consumer to print length
        Consumer<String> printLength = str -> System.out.println(str.length());

        // Combine the consumers using andThen (uppercase then print length)
        Consumer<String> chainedConsumer = toUpper.andThen(printLength);

        // Apply the chained consumer
        chainedConsumer.accept("Nishchay");

    }

}
