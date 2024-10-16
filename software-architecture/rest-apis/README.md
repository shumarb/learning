# REST APIs

## Overview
`REST API` (Representational State Transfer Application Programming Interface) is a software architectural style that facilitates communication between a `client` and `server` via a `HTTP` (HyperText Transfer Protocol).
The client sends a request to the server, and the server processes the request and returns a response, typically using standard HTTP methods like GET, POST, PUT, and DELETE to perform operations on resources.

## Key Terms
- **Client**: The entity sending requests to the server.
- **Server**: The system processing requests from the client and sending responses to the client.
- **Request**: A message sent by the client to the server seeking data or an action.
- **Response**: A message sent from the server to the client containing the result of the request.
- **Resource**: A data object that can be accessed or manipulated via a REST API.

## Importance
- **Simplicity**: Easy to understand and implement using standard HTTP methods (**GET**, **POST**, **PUT**, **DELETE**).
- **Statelessness**: Each request is independent, with no session information stored in the server, facilitating scalability.
- **Scalability**: Statelessness allows requests to be handled independently, enabling easy scaling by distributing requests across multiple servers. 
- **Flexibility**: Supports multiple data formats (eg: JSON, XML) and works across across multiple environment (web, mobile).
- **Interoperability**: Works over HTTP, making it compatible with various programming languages (eg: Java, Python) across multiple platforms (eg: Linux, macOS).

## Implementation
- **Resources**: Represent entities in your application (e.g., users, products) identified by URIs (Uniform Resource Identifiers). 
- **HTTP Methods**:
  - GET: Retrieve data from the server.
  - POST: Create a new resource on the server.
  - PUT: Update an existing resource on the server.
  - DELETE: Remove a resource from the server.

## Example
```java
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private List<User> users = new ArrayList<>();

    // GET: Retrieve all users
    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    // POST: Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    // PUT: Update an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        users.set(id, user);
        return user;
    }

    // DELETE: Remove a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        users.remove(id);
    }
}

// User model
class User {
    private String name;
    private int age;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```
In the code above:
- UserController manages the user resources and handles HTTP requests. It has methods for each HTTP operation: retrieving all users, creating a new user, updating an existing user, and deleting a user. 
- **GET** requests return a list of users.
- **POST** requests add a new user to the list.
- **PUT** requests update a user based on their ID.
- **DELETE** requests remove a user from the list.
