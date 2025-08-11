# Understanding Testing Spring Boot Applications

Testing is required to make sure the software meets the requirements, responds correctly to inputs **(input validation)**, performs within acceptable time **(performance test)**, can be installed and run **(deployment test)** and achieves the results for the stakeholders.

## Types of Tests

1. **Smoke and Sanity Testing:** Tests if the software will run even in a basic form.
2. **Continuous Testing:** Testing runs in every iteration.
3. **Regression Testing:** When we add new code or alter existing code, we want to make sure that the other code keeps on working.
4. **Performance Testing:** Tests the time it takes to run the software.
5. **Acceptance Testing:** Used to check if the stakeholders are happy with the software.

## Testing Levels

1. **Unit Test:** Smallest building blocks. Every class in the programming code has a companion unit test class. The test is isolates from the other class by **mocking** the method call.
2. **Integration Test:** Test a class with all the dependencies.
3. **System Test:** Tests the complete system, including hardware, operating system, web service, and so on.

## Test Libraries

Junit is the defactor standard for all the testing libraries in the Java world. Other libraries include: `Spring Test`, `AssertJ`, `Mockito`, etc.
