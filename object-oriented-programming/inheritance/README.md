# Inheritance

## Overview
Inheritance is the concept of allowing classes to inherit attributes and functions from another class.

## Importance
- **Promotes Code Reuse**: Code duplication is reduced because a class inherits attributes and functions from another class.
- **Establishes Hierarchy**: A clear relationship between two or more classes is established, improving code understandability.
- **Enhances Maintainability**: Updates to the parent class automatically apply to its child classes.

## Implementation
- **Parent class**: Defines common attributes and methods.
- **Child class**: Inherits from the base class and can extend or override its functionality.

## Example
Here is an example of inheritance:
```java
class Animal {
    protected int numberOfEyes = 2;
    
    protected void eat() {
        System.out.println("I am eating.");
    }
    
    protected void getNumberOfEyes() {
        System.out.println("I have " + numberOfEyes + " eyes.");
    }
}

class Cat extends Animal {
    private String species = "cat";
    
    public void meow() {
        System.out.println("I am meowing.");
    }
    
    public void getSpecies() {
        System.out.println("I am a " + species);
    }
}

public class Runner {
    public static void main(String[] args) {
        Cat myCat = new Cat();
        myCat.getNumberOfEyes();
        myCat.eat();
        myCat.meow();
        myCat.getSpecies();
    }
}
```
In this code:
- The Cat class inherits from the Animal class. This means Cat inherits the numberOfEyes attribute and the eat() and getNumberOfEyes() methods from Animal, showcasing the is-a relationship where a Cat is a type of Animal.
- Through inheritance, myCat (an instance of Cat) can access the inherited getNumberOfEyes() and eat() methods, demonstrating how subclass objects can use the functionality defined in the superclass.
- The Cat class adds its own methods (meow() and getSpecies()) that are specific to the Cat class, extending the functionality of Animal. This shows how inheritance allows a subclass to build upon the existing functionality of its superclass.
- The Cat class reuses the Animal class's methods and fields, avoiding code duplication. The Runner class demonstrates this by creating a Cat object and using inherited methods along with Cat-specific methods.
