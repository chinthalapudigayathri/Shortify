Notes on Docker

1. Docker is basically a platform that packages applications , libraries, runtime configurations etc everything into containers and run them
2. Example instead of installing redis directly we install docker and run redis instantly
3. To check docker is installed or not execute the following in terminal docker --version
4. To check if Docker Engine is running or not execute the following in Terminal docker ps
5. Docker can run redis,postgres etc instantly without having to install everything
6. A Docker file is a text file which has instructions on how to create a docker Image
7. A docker image is basically a template or a blueprint used to create Docker containers
8. Containers are where all these applications runs instantantly.
9. Add the following in your project to generate docker file automatically
10. Add this in pom.xml
    <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
11. Run mvn spring-boot:build-image
12. To see how to run redis from docker check redis.md file
13. If docker Desktop is not opening execute the following one by one
    taskkill /F /IM "Docker Desktop.exe"
    taskkill /F /IM dockerd.exe
    taskkill /F /IM com.docker.backend.exe
14. To see how to configure Kubernetes using Docker check Kubernetes.md
15. For Kibana logging check Kibana.md
