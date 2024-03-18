
// Superclass (Parent Class)
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Generic Animal Sound");
    }

}

// Subclass (Child Class) inheriting from Animal
class Dog extends Animal {

    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    // Override inherited method (specialization)
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Tom");
        animal.makeSound();

        Dog dog = new Dog("Duffy", "Labrador");
        dog.makeSound();

    }
}