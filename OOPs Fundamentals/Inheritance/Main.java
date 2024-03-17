
// Superclass (Parent Class)
class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

// Subclass (Child Class) inheriting from Animal
class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is barking");
    }

    // Override inherited method (specialization)
    @Override
    public void eat() {
        System.out.println("Dog is eating kibble");
    }
}

public class Main {

    public static void main(String[] args) {

    }
}