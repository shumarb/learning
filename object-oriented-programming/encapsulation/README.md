# Encapsulation

## Overview
Encapsulation is an Object-oriented programming principle that `bundles` data (attributes) and methods (functions) within a class,
`hiding` the internal state, and `controlling` access and modification of data through an encapsulated interface.

## Importance
- Data Protection: Restricts direct access to internal data to prevent unauthorized access.
- Modularity: Enhances code organisation and maintenance by grouping data and methods.

## Implementation
- Access Modifiers
  - **public**: Grants access to any part of the program.
  - **private**: Restricts access to the class itself.
  - **protected**: Allows access within the same package and subclasses.
  - **default** (no declaration of access modifier): Accessible only within the same package.
- Encapsulated Interface
  - **Getters**: Provides controlled access private attributes.
  - **Setters**: Allows controlled modification of private attributes.
  - **Functionality**: Classes expose functionality through public methods, hiding internal implementation details and data.
- Classes expose functionality through public methods, hiding internal implementation details and data.
- Class Design 
  - **Modularity**: Classes are designed to manage their own state and behavior, promoting separation of concerns.
  - **Information Hiding**: Internal details are hidden, exposing only necessary operations to the outside world.

## Example

```java
public class Account {
    // Attributes
    private String username;
    private String password;
  
    // Getters
    public String getUsername() {
        return username;
    }  
  
    public String getPassword() {
        return password;
    }
  
    // Setters
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String setPassword(String password) {
        this.password = password;
    }
}
```

In the `Account` class,
- The `username` and `password` attributes are private to prevent direct access from outside the class.
- The `encapsulated interface` are the `getters`, which provide read-only access to these attributes, and the `setters`, which allow modification of these attributes.
- This design encapsulates the class's state and behavior, promoting data protection and modularity.
 