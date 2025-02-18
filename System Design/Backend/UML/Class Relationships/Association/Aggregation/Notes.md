# Understanding Aggregation

Aggregation represents a "has-a" relationship between objects. One class (the whole) contains a reference to another class (the part), but the part can still exist independently.

**Example: Department and Employee**

Consider a Department class and an Employee class. A department "has" employees, but employees can exist independently of the department.

```
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void listEmployees() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            System.out.println("Employee: " + employee.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John");
        Employee emp2 = new Employee("Jane");

        Department dept = new Department("HR");
        dept.addEmployee(emp1);
        dept.addEmployee(emp2);

        dept.listEmployees();
    }
}
```
