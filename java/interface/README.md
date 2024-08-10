# Interface

## Overview
An interface defines a contract that classes must adhere to. It lists methods that any class using the interface must implement.

## Importance
- **Defines a Contract**: Ensures that implementing classes adhere to a specific method structure.
- **Promotes Flexibility**: Allows different classes to implement the same set of methods, facilitating polymorphism.
- **Supports Multiple Inheritance**: Enables a class to implement multiple interfaces, overcoming the limitations of single inheritance.

## Implementation
- Interface: Contains method declarations without bodies. It can also include default methods with implementation and static methods.
- Implementing Class: Provides concrete implementations for all methods declared in the interface.

## Example
```java
interface Vehicle {
    void start();
    void end();
    void displayInformation();
}

class Car implements Vehicle {
    private String brand;
    private String model;
    private int year;

    Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("The car has started...");
    }

    @Override
    public void end() {
        System.out.println("The car has stopped.");
    }

    @Override
    public void displayInformation() {
        System.out.println("Brand: " + brand + " | Mode;" + model + " | Year: " + year);
    }
}

public class Runner {
    public static void main(String[] args) {
        Car myCar = new Car( "BMW", "iX M60", 2022);
        myCar.displayInformation();
        myCar.start();
        myCar.end();
    }
}
```
In the code above:
- Vehicle is an interface that defines a contract with method declarations (start(), end(), and displayInformation()) but does not provide method implementations.
- Car is a concrete class that implements the Vehicle interface. It provides specific implementations for all the methods declared in the interface.
myCar, an instance of Car, uses the methods start(), end(), and displayInformation() defined in the Vehicle interface, demonstrating how classes can fulfill the contract set by an interface and provide specific behavior.