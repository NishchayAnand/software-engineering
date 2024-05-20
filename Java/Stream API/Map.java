import java.util.List;

public class Map {

    public static void main(String[] args) {

        List<Person> persons = Person.getDummyList();

        persons.stream()
                .map(person -> person.getName())
                .forEach(System.out::println);
    }

}
