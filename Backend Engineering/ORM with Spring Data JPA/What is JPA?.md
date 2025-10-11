
Java Persistence API (JPA) - An API that helps to standardise the Java Persistence world.

- `ApplicationContext ctx = ClassPathXmlApplicationContext("datasources-beans.xml");` creates a container forming the beans from the datasource xml file.

- The JPA defines an `EntityManager` interface, which is basically the heart of API. It is similar to Hibernate's `Session`, forming the core of the application to perform database operations.

> NOTE: Create `persistence.xml` file under a folder named `META-INF`.

A domain object is also known as a persistence entity.

- JPA stands for Java Persistance API. JPA focused on object-relational mapping or commonly referred to as just an ORM design principle.

- Originally, it was part of the J2EE specification, but was later extracted out to be available just on its own.

- Java Persistance Frameworks like JDBC have a tendency to focus more on the database side of things. They tend to have some bad object-oriented development practices.

- JPA specification focused on good OO design.

 It helps remove a lot of boiler-plate code, helping developers build objects and bridge that gap between our relational database and our object-oriented code.

- Spring Data JPA is a framework to help eliminate boilerplate code with regards to the DAO layer.

- Example Code:

```
public Car findCar(String id) {
    return getEntityManager().find(Car.class, id);
}
```

---
### Simple JPA code

```
EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUNIT");
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

Registration reg = new Registration("Bob", "Builder", "bobthebuilder@pluralsight.com");

em.persist(reg);
em.getTransaction().commit();
em.close();
emf.close();
```

---
