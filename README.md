# Spring initialization 
The aim of this PoC is to better understand the order in which things gets initialized in
a spring boot application.
The application has
- a InitializationApplication SpringBootApplication
- a RuntimeBean Component
- a InitializationApplicationTests SpringBootTest
- a TestBean Bean declared in the TestConfiguration

# Run the tests by executing
```
mvn test 
```

# Outcome
By checking the logs we can see that the initialization order is as follows:

## Run tests
Test class
- initialization methods
- @BeforeAll method
- constructor
## spring application config loading
Runtime component 
- static initialization methods
- constructor
- @PostConstruct method
## spring test config loading
Test component 
- static initialization methods
- constructor
- @PostConstruct method
## test execution
Test class
- @PostConstruct method
- @BeforeEach method
- @AfterEach method
## if @DirtiesContext & spring context needs reloading
_(Note that no static methods are called during context reloading)_

Runtime component
- constructor
- @PostConstruct method

Test component
- constructor
- @PostConstruct method

Test class
- @PostConstruct method
- @BeforeEach method
- @AfterEach method
