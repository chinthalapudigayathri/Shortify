

1. To Run Springboot app execute spring-boot:run or mvn spring-boot:run
2. First JVM executes main class, which can be identified by annotation @SpringBootApplication
3. Main class must be public so that JVM can access and run it
4. once JVM runs the main class, Springboot scans all the packages for beans - (@Entity, @Repository, @Service, @Controller) and executes them one by one
5. Once the definition hits, it reaches controller -> service -> repository ->model
6. We create Repository To tell Spring that this is data access layer, which has data access objects to interact with Database
7. We create an interface instead of class so that we only give the blueprint of the methods instead of implementation
8. We extend our interface with JPARepository which is also an interface(Spring Data Interface) which has all CRUD operations
9. This helps us avoid Boilerplate Code(repetitve code) there by making our code look clean
10. We pass Entity class and primary key as arguments to tell the repository what table to interact with
11. Next up we create few custom methods such that it help Spring Data JPA to create queries automatically
12. we pass fields declared in Entity class to give column name for Spring Data JPA
13. And then we create Data Transfer Object layer(DTO) to pass data objects from one layer to other layer
14. Here names of fields can be different from Entity and Repository layer as this is not directly interacting with DB
15. we can connect these columns seperately with @Mapper while mapping
16. Redis is used to caching and temporary and fast data access, we create a Redis service layer to interact with db
17. Client -> Springboot -> Redis -> DB
18. If we do not assign any access modifier for a class then it is called default access. Default access is package private which means only classes in that same package can access that class
19. Every method in an interface is an abstract method by default unless specifically defined with access modifiers
20. A class always implements an interface
21. All methods in an interface are by default abstract methods unless specifically declared as public etc
22. @Autowired - Spring scans to all the beans based on its component once it sees @autowired , it tells spring to inject Spring data JPA instances there
23. @Override tells spring that this method is meant to override a method from superclass
24. @Cacheable tells spring that result of this method call should be cached
25. A custom Exception class always extends RuntimeException class
26. Your repository method names must match the Java field names in the entity
27. Add docker compose file to configure elastic search kibana logging
28. After adding configurations run this in terminal" docker compose up -d
29. After that verify in http://localhost:9200  should show Elasticsearch info and verify http://localhost:5601 it should show kibana ui
