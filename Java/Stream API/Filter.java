import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {

        List<Person> persons = Person.getDummyList();

        Stream<Person> strm = persons.stream();

        Stream<Person> filtered = strm.filter(person -> person.getAge() > 20);

        // forEach method using method references.
        filtered.forEach(System.out::println);

    }

}
