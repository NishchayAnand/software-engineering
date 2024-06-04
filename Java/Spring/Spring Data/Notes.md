# Understanding Spring Data JPA

Spring Data provides support for interacting with repositories.

The central interface astracting the Spring Data repository is named exactly `Repository<T, ID>`.

The purpose of the query methods from the repositories is to retrieve information from the database. Spring Data provides a **query builder mechanism** that will create the bahavior of the repository methods based on their names.

The `Java Persistence Query Language (JPQL)` is a platform independent object-oriented query language part of JPA.

---

Java Persistence API (JPA) - An API that helps to standarize the Java Persistence world.

- `ApplicationContext ctx = ClassPathXmlApplicationContext("datasources-beans.xml");` creates a container forming the beans from the datasource xml file.

- The JPA defines an `EntityManager` interface, which is basically the heart of API. It is similar to Hibernate's `Session`, forming the core of the application to perform database operations.

> NOTE: Create `persistence.xml` file under a folder named `META-INF`.

A domain object is also known as a persistence entity.

---

- JPA stands for Java Persistance API. JPA focused on object-relational mapping or commonly referred to as just an ORM design principle.

- Originally, it was part of the J2EE specification, but was later extracted out to be available just on its own.

- Java Persistance Frameworks like JDBC have a tendency to focus more on the database side of things. They tend to have some bad object-oriented development practices.

- JPA specification focused on good OO design.

- It helps remove a lot of boiler-plate code, helping developers build objects and bridge that gap between our relational database and our object-oriented code.

- Spring Data JPA is a framework to help eliminate boilerplate code with regards to the DAO layer.

- Example Code:

```
public Car findCar(String id) {
    return getEntityManager().find(Car.class, id);
}
```

- `spring-boot-starter-data-jpa`: library containing all the functionality related to spring data jpa.

- **persistence.xml:** We need this file to configure database connections when dealing with plain JPA. Spring has removed its dependency on our application. Hence, if you are using Spring, you no longer need to have this file in your application. Hurray!

## Simple JPA code :

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

## Simple Spring Data JPA code:

```
@Transactional
public void createRegistration(Registration reg) {
    registrationRepository.save(reg);
}
```

We can use **orm.xml** files or Hiberate's **hbm.xml** files to work with JPA. However, the industry trend is develop through annotations.

## JPA Annotations

### @Entity:

- Declares the object as an entity and how the database should be aware of it.
- Part of **javax.persistence.Entity** library.
- Class-level annotation.

### @Table:

- Describes more specific details about the database, for example, the name or the schema.

### @Id:

- Identifier attribute for a very simple primary key type.
- Property-level annotation.

### @GeneratedValue:

- Used in conjunction with Id.
- Property-level annotation.
- There are 4 options to choose for GeneratedValue:
  - `IDENTITY`: used to specify an identity column in the database. The auto-incrementing column in a database is an example of identity column.
  - `AUTO`: Defaults to **IDENTITY** if available.
  - `SEQUENCE`: Works with a sequence if that database supports it.
  - `TABLE`: Uses an identity table and column to ensure uniqueness.

### @Column

- JPA usually maps fields to columns with the same name. `@Column` lets you specify a different column name in the database.
- Overrides JPA's default mapping behavior, which typically uses field names for column names (e.g., `@Column(name = "user_name")` for a field named **userName**).
- Also, allows us to define column characteristics such as `length`, `nullable`, `unique` and `precision`.

### @OneToMany

- Used to define **one-to-many** relationship between an **object** and a **list of objects.**
- Signifies that a single instance of an entity (owning side) can be associated with multiple instances of another entity (inverse side).
- Placed on a collection-valued field (e.g., List, Set) within the owning entity class.
- **Cascade Operations (Optional):** The cascade attribute allows you to define operations (e.g., PERSIST, DELETE) that should be cascaded to the associated entities when performing operations on the owning entity.
- **mappedBy (Bidirectional Relationships):** If the relationship is bidirectional (i.e., the inverse side also has a reference to the owning entity), use the `mappedBy` attribute to specify the field name in the inverse side entity that maps back to the owning entity.

```
@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
private List<Course> courses = new ArrayList<>();
```

### @ManyToOne

- It is the counterpart to @OneToMany and is used to define a many-to-one relationship between entities.
- Represents a scenario where multiple entities (many side) can be associated with a single entity (one side) in a JPA application.
- **Foreign Key Relationships:** Establishes a foreign key association between tables in the underlying database.

```
@ManyToOne  // Inverse side of the relationship
private Customer customer;
```

### SAMPLE CODE:

```
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "FULL_NAME", nullable = false, length = 50)
    private String name;
    private int age;

    ...

}
```

## Java Persistence Query Language (JPQL)

- Centered around objects.
- `Query q = em.createQuery("select r from registration");`: will query the object of `Registration` class.

## Spring Annotations

### @PersistenceContext

- Used to inject EntityManager which is used to perist things through Hibernate to our database.

### @Service

- Specifies the location of the business logic.
- It happens to be location from where we start our transactions.

### @Repository

- Represent the Repository tier.

### @Transactional

- Specifies the beginning of our transaction. Ideally, it should start at your service layer. However, if we just doing an update against one table, it is implied that it's in a transaction because it's just one commit. It's when it spans multiple tables that you need to start and stop a transaction.

### SAMPLE CODE

```
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional // will bind the save method in a transaction
    public User save(User user) {
        em.persist(user);
        return user;
    }

}
```
