Redis Notes:

1. Redis is an in-memory data store used as a cache, database, and message broker.
2. Data is stored in Key -> Value Ex: "user:1" → "{name: Gayathri, role: developer}"
3. It is super fast for caching, Client -> Springboot Application -> Redis Cache -> DB
4. To integrate Redis caching in your project , add the following in pom.xml
   <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-redis</artifactId>
   </dependency>
5. In your main class add this annotation @EnableCaching
6. Add the following in application.properties
   spring.redis.host=localhost
   spring.redis.port=6379
   spring.redis.database=0
   spring.cache.type=redis
7. Add a RedisTemplateConfig class and RedisTemplateService class
8. In your project use Spring Cache like this @Cacheable(value = "urlCache", key = "#shortUrl")
9. To run Redis from docker execute the following commands
   docker --version
To check docker engine: docker ps
Run Redis using Docker: docker run -d --name redis -p 6379:6379 redis
Execute this docker exec -it redis redis-cli
and enter PING, it must return PONG
After this go to url http://localhost:8080/cache-test and hit it twice. You must see "Method wecuted" only once, if younsee it twice redis caching is not working
If you see Method executed once, execute the following in terminal KEYS *
You must see somethig like testCache::SimpleKey []
10. to stop redis execute:docker stop redis
11. To start redis execute: docker start redis
12. To remove redis container execute: docker rm -f redis
13. To clear Redis data execute: docker exec -it redis redis-cli FLUSHALL

