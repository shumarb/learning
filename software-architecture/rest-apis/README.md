# REST APIs

## Overview
REST (Representation State Transfer) is an architectural style for designing networked applications.
It uses a stateless, client-server communication tool, primary over HTTP (Hypertext Transfer Protocol), to enable interaction with resources represented by URLs.

## Importance
- **Simplicity**: Uses standard HTTP methods (**GET**, **POST**, **PUT**, **DELETE**).
- **Statelessness**: Each API call is independent and the server does not store client context.
- **Resource-oriented**: Emphasises resources (data) rather than actions.

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
