1. To Run Springboot app execute spring-boot:run or mvn spring-boot:run
2. First JVM executes main class, which can be identified by annotation @SpringBootApplication
3. Main class must be public so that JVM can access and run it
4. once JVM runs the main class, Springboot scans all the packages for beans - (@Entity, @Repository, @Service, @Controller).
