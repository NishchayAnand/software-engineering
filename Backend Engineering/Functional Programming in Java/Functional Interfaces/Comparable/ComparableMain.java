import java.lang.Comparable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {

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

    @Override
    public int compareTo(Person other) {
        return this.age - other.getAge();
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}

public class ComparableMain {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        Person p1 = new Person("Nishchay", 26);
        list.add(p1);
        Person p2 = new Person("Vridhi", 19);
        list.add(p2);
        System.out.println("Original List:" + list);

        Collections.sort(list);
        System.out.println("Sorted List:" + list);

    }

}
