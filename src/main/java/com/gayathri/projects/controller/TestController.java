package com.gayathri.projects.controller;

import com.gayathri.projects.service.CacheTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final CacheTestService cacheTestService;

    public TestController(CacheTestService cacheTestService) {
        this.cacheTestService = cacheTestService;
    }

    @GetMapping("/cache-test")
    public String testCache() {
        return cacheTestService.test();
    }
}
