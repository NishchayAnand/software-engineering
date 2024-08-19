
public class Singleton {

    private static Singleton obj = null;

    private Singleton() {
        System.out.println("Creating an object of Singleton class");
    }

    public static Singleton getInstance() {
        if (obj == null) {
            obj = new Singleton();
        }
        return obj;
    }
}