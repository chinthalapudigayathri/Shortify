# Shortify

Shortify is a full-stack URL shortening application designed with scalability, performance, and observability in mind. The project demonstrates real-world backend, frontend, cloud, containerization, caching, and centralized logging practices using modern technologies.

---

## Project Overview

Shortify allows users to convert long URLs into short, shareable links and efficiently redirect users. The system is built using a cloud-ready and microservice-friendly architecture with a strong focus on performance, reliability, and monitoring.

---

## Technology Stack

### Backend

* Spring Boot – REST API development
* Hibernate / JPA – ORM for database interaction
* PostgreSQL – Relational database
* Redis – Caching layer to improve performance and reduce database load
* Maven – Build and dependency management
* JUnit & Mockito – Unit and integration testing
* IntelliJ IDEA – Development environment

### Frontend

* Angular – Frontend framework for building responsive user interfaces
* AWS S3 – Hosting for the static Angular frontend

### Logging and Monitoring

* Elasticsearch – Centralized log storage and search
* Kibana – Log visualization and analysis
* Filebeat – Log shipping from application to Elasticsearch

### DevOps and Cloud

* Docker – Containerization of the backend application
* Kubernetes – Container orchestration and scalability
* AWS EC2 – Hosting the Spring Boot backend service

---

## Architecture Highlights

* RESTful APIs implemented using Spring Boot
* Redis-based caching to minimize database access and improve response times
* Centralized logging using the ELK stack (Elasticsearch, Filebeat, Kibana)
* Dockerized backend for consistent and repeatable deployments
* Kubernetes for orchestration, scaling, and service management
* Cloud deployment leveraging AWS EC2 and S3

---

## Testing

* JUnit is used for writing unit and integration tests
* Mockito is used for mocking dependencies and isolating business logic

---

## Deployment Flow

1. Backend application is built using Maven
2. Docker image is created for the Spring Boot application
3. Docker containers are managed and deployed using Kubernetes
4. Backend service is hosted on AWS EC2
5. Frontend Angular application is built and hosted on AWS S3
6. Application logs are collected by Filebeat
7. Logs are stored in Elasticsearch and visualized using Kibana

---

## Repository Structure (High Level)

```
shortify/
├── backend/        # Spring Boot application
├── frontend/       # Angular application
├── docker/         # Docker-related configuration
├── k8s/            # Kubernetes manifests
├── logs/           # Application logs
└── README.md
```

---

## Author

Developed by Gayathri as a full-stack, cloud-native application project.

---

## License

This project is intended for learning and demonstration purposes.
