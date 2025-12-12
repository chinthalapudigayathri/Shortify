package com.gayathri.projects.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/* Declare service layer with annotation @Service*/


@Service
public class RedisService{

    /* We use Redis here for cacching and temporary/fast access data storage
    *  client -> Spring Boot -> Redis(Cache) -> DB
    * here we are using @Autowired annotation for Dependency Injection meaning instead of we creating our own objects Spring creates objects for us
    * Without that we have manually write code for that like RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    * by using @Autowired Spring automatically creates and injects those objects while cmiple time
     */
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /* Method to save short url and map it to long url*/
    public void save(String key, String value)
    {
        redisTemplate.opsForValue().set(key,value);
    }

    /*method to get long url*/
    public String get(String key)
    {
        return (String) redisTemplate.opsForValue().get(key);
    }
}

