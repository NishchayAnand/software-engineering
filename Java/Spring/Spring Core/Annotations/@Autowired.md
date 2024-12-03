# Understanding @Autowired Annotation

The `@Autowired` annotation in Spring is used to automate the dependency injection process. It's a declarative way to instruct Spring to automatically resolve and inject a bean into a class. 

## How to Use

1. **Field Injection (Least Recommended)**: Field-injected dependencies are not final, meaning they can be modified after the object is created. This makes the class mutable, increasing the risk of unintended side effects during testing or debugging.

```
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

2. **Constructor Injection (Recommended Approach)**: Promotes immutability, easier to test, dependencies are explicit.

```
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

3. **Setter Injection**: Useful for optional or dynamically changing dependencies.

```
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

## How it Works

During the bean initialization process, Spring scans your application context. It identifies beans that match the type of the dependency. If there's a unique match, Spring injects that bean into your class.
