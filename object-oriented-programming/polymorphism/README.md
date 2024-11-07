# Polymorphism

## Overview
Polymorphism is a concept of allowing objects of different classes to be regarded as objects of a common superclass.
Polymorphism can be classified into two types: **Runtime Polymorphism**, and **Compile-Time Polymorphism**.

| Aspect      | Runtime Polymorphism                                      | Compile-time Polymorphism                                            |
|-------------|-----------------------------------------------------------|----------------------------------------------------------------------|
| Definition  | Method resolution being determined at **runtime**.        | Method resolution being determined at **compile** time.              |
| Example     | Method overloading.                                       | Method overriding.                                                   |
| Comparison  | Slower as methods are resolved at runtime.                | Faster as methods are resolved at compile time.                      |
| Key Feature | Multiple methods with same name but different signatures. | Same method signature with different implementations across classes. |

## Importance
- **Flexibility**: Allows different classes to be treated through a common interface, enhancing code adaptability.
- **Code Reusability**: Enables the use of a single interface to work with various object types, reducing code duplication.
- **Maintainability**: Simplifies code management by allowing updates to be applied through polymorphic behavior.

## Implementation
- **Method Overriding**: Subclasses provide specific implementations of methods declared in their superclass.
- **Interface**: Multiple classes can implement the same interface, providing their own versions of the methods.

## Example
Polymorphism via **Method Overriding**:
```java
class Animal {
    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Runner {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        myDog.makeSound();
        myCat.makeSound();
    }
}
```
Polymorphism via **Interface Implementation**:
```java
interface Animal() {
    void makeSound();
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Runner {
    public static void main(String[] args) {
        Animal myCat = new Cat();
        Animal myDog = new Dog();
        myCat.makeSound();
        myDog.makeSound();
    }
}
```
In both codes:
- Dog and Cat classes override the makeSound() method from the Animal class.
- The myDog and myCat, both referenced as Animal, call their respective makeSound() methods, demonstrating polymorphism by producing class-specific outputs.
