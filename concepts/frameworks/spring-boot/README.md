# Spring Boot

## Overview
Spring Boot is a framework that simplifies the development of Java-based applications. 
It provides a set of tools and conventions to streamline setup, configuration, and deployment, allowing developers to build production-ready applications quickly and with minimal boilerplate code.

## Importance
- Simplified Setup: Reduces the complexity of configuration and setup with its convention-over-configuration approach.
- Inversion of Control (IoC): Manages dependencies and object creation through dependency injection, promoting loose coupling.
- Embedded Containers: Includes embedded servers (e.g. Tomcat) for running applications without needing a separate web server setup.
- Auto-Configuration: Automatically configures components based on the project’s dependencies, reducing the need for manual configuration.
- Production-Ready Features: Provides built-in features like metrics, health checks, and application monitoring to ease the deployment and maintenance of applications.

## Implementation
### Key Annotations
- @Service: Marks a class as a service provider, typically containing business logic.
- @Controller: Marks a class as a Spring MVC controller, handling web requests and returning views.
- @Repository: Marks a class as a Data Access Object (DAO), managing database interactions.
- @Entity: Defines a class as an entity that maps to a database table.

### Request Mappings
- @GetMapping: Maps HTTP GET requests to a method.
- @PostMapping: Maps HTTP POST requests to a method.
- @PutMapping: Maps HTTP PUT requests to a method.
- @DeleteMapping: Maps HTTP DELETE requests to a method.
