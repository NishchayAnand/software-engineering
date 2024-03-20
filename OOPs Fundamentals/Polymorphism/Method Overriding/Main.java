
class Animal {
    public void makeSound() {
        System.out.println("Generic animal sound");
    }
}

class Dog extends Animal {
    @Override // Optional annotation to check for valid overriding
    public void makeSound() {
        System.out.println("Woof!");
    }

    public void bark() {
        System.out.println("Woof, Woof, Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.makeSound();

        Animal animal2 = new Cat();
        animal2.makeSound();

    }
}