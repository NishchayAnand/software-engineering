
public class SingletonNotThreadSafe {

    private static SingletonNotThreadSafe obj = null;
    // invariant: there should never be more than one Singleton object created

    private SingletonNotThreadSafe() {
        System.out.println("created a Singleton object");
    }

    // factory method that returns the sole Singleton object, creating it if it
    // doesn't exist
    public static SingletonNotThreadSafe getInstance() {
        if (obj == null) {
            obj = new SingletonNotThreadSafe();
            // Java doesn't guarantee that the assignment to obj in one thread will be
            // immediately visible in other threads
        }
        return obj;
    }

}
