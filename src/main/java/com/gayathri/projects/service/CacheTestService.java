package com.gayathri.projects.service;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheTestService {

    @Cacheable("testCache")
    public String test() {
        System.out.println("METHOD EXECUTED");
        return "HELLO";
    }
}
