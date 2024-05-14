import java.util.*;

class Person {
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
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

}

class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return person1.getAge() - person2.getAge(); // can also use -> Integer.compare(person1.getAge(),
                                                    // person2.getAge());
    }

}

public class ComparatorMain {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();
        list.add(new Person("Nishu", 26));
        list.add(new Person("Vridhi", 19));
        System.out.println("Original List: " + list);

        // Using object of a AgeComparator class for sorting list of persons based on
        // their age.
        Collections.sort(list, new AgeComparator());
        // System.out.println("Sorted List: " + list);

        // Using lambda expression to implement comparator interface
        Collections.sort(list, (Person person1, Person person2) -> person1.getAge() - person2.getAge());
        System.out.println("Sorted List: " + list);

    }
}
