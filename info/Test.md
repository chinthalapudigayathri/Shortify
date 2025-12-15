1. Test folder is always under src/main under project root directory
2. Add this to pom.xml
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-test</artifactId>
   <scope>test</scope>
   </dependency>
3. Unit testing means testing the smallest testable part of your code (a unit) to make sure it works correctly by itself.
4. In java a unit means a method or a class
5. JUnit is a testing framework for Java. It provides @Test assertions like assertequal and test runners
6. Junit runs the test, check the assertions and tells you pass/fail
7. Mockito on other hand Pretend this dependency behaves like this
8. Junit and mockito together works at the same time not seperately
9. First We need to write main tets class which is same as main class
10. And that starts with @SpringBootTest , This is a Spring Boot context test. It Starts the entire Spring ApplicationContext and loads
11. It just Verifies the application can start without crashing. If any bean fails to initialize, this test will fail.
12. Next we write service test class it is a Mockito test class by Junit 5
13. We create mock objects, injects dependencies and tests with assertions
14. It has @ExtendWith(MockitoExtension.class) is a Junit5 way to integrate mock tests before class
15. Classes here cannot be public, it's ok even if they are but normally they need not be public
16. We have to first run test using mvn clean test
