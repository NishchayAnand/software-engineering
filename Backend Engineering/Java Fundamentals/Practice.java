import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    private int age;
    private String name;
    private long salary;

    public Employee(int age, String name, long salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "[age = " + age + ", name = " + name + ", salary = " + salary;
    }
}

public class Practice {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(25, "Nishchay", 50000));
        employees.add(new Employee(27, "Mohit", 100000));

        System.out.println(employees);

        // Custom Sorting before Java 8
        List<Employee> sortedEmployees = Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getAge() - e2.getAge(); // -ve -> e1 first, +ve -> e2 first
            }
        });

    }
    
}
