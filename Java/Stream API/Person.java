import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static List<Person> getDummyList() {
        Person person1 = new Person("Nishchay", 26);
        Person person2 = new Person("Vridhi", 19);

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);

        return persons;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
