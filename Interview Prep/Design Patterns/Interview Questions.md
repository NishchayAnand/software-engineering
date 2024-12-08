# Design Patterns Interview Questions

Q. Explain Factory Pattern. 

The Factory Design Pattern is a creational design pattern that **provides a way to create objects without specifying the exact class of object that will be created**. It abstracts the instantiation logic and allows the code to depend on an interface or abstract class rather than a concrete class, supporting polymorphism and dependency injection. 

---

Q. Explain the difference between Simple Factory and Factory Method design patterns.

1. **Simple Factory**: Encapsulates the creation logic in a single method or class. Adding a new type of object involves modifying the factory, violating the Open/Closed Principle (OCP).

   ```
   public class EntityManagerFactory {

        public static EntityManager getEntityManager() {
            return new EntityManager();
        }

    }
   ```

2. **Factory Method**: Provides an interface for creating objects and uses inheritance to delegate the instantiation logic to subclasses. Adding a new type of object only involves creating a new subclass without modifying existing code, adhering to OCP.

   ```
    public interface EntityManagerFactory {
        public EntityManager getEntityManager();
    }

   public class HibernateEntityManagerFactory implements EntityManagerFactory {
        public EntityManager getEntityManager() {
            return  new HibernateEntityManager();
        }
    }

    public class OpenJPAEntityManagerFactory implements EntityManagerFactory {
        public EntityManager getEntityManager() {
            return  new OpenJPAEntityManager();
        }
    }
   ```

---