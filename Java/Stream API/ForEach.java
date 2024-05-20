import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;

public class ForEach {

    public static void main(String[] args) {

        List<Person> persons = Person.getDummyList();

        Stream<Person> strm = persons.stream();

        // forEach Method using lambda expression.
        strm.forEach(person -> System.out.println(person));

    }

}