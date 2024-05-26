import java.util.Arrays;
import java.util.List;

public class MapMain {

    public static void main(String[] args) {

        List<String> nameList = Arrays.asList("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
        nameList.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);
    }

}
