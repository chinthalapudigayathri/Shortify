package com.gayathri.projects;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-test.properties",
        properties = {
                "redis.enabled=false",
                "spring.redis.enabled=false"
        }
)
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                classes = com.gayathri.projects.config.RedisStandaloneConfig.class
        )
})
public class ShortifyTest {

    @Test
    void contextLoads() {
    }
}
