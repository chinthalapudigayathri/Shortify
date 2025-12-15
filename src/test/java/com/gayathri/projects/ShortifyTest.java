package com.gayathri.projects;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

/* This is a Spring Boot context test. It Starts the entire Spring ApplicationContext and loads
* All @Component, @Service, @Repository, @Controller , all auto configurations and beans. It Applies test properties
* Verifies the application can start without crashing. If any bean fails to initialize, this test will fail.
 */

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties",
        properties = {
                "redis.enabled=false",
                "spring.redis.enabled=false"
        }
)

public class ShortifyTest {

    @Test
    void contextLoads() {
    }
}
