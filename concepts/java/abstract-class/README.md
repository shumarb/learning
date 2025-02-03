# Abstract Class

## Overview
An `abstract class` is a class that cannot be instantiated on its own is designed as a base class for other classes.

## Importance
- **Provides a Template**: Defines a common base with abstract methods that the derived classes must implement.
- **Promotes Code Reuse**: Allows shared code to be placed in the abstract class whilst forcing subclasses to provide specific implementations.
- **Supports Partial Implementation**: Can have both abstract methods (methods without body) and concrete methods (methods with body), offering 
flexibility in defining base functionalities.

## Implementation
Abstract classes work as follows:
1. An `abstract class` is created using the `abstract` keyword next to the name of the class. It contains one or more of the following:
   - `Abstract` methods (The `abstract` keyword is next to the method name, and it has no body). This method is implemented by its `child class`. 
   - `Concrete` methods with implementation (Can be overriden by `child` class).
   - `Constructors`.
   - `Static` and `Instance` variables.
2. Concrete Subclass: Extends the abstract class and implements all abstract methods.

## Example
```java
// Abstract class
abstract class Vehicle {
  protected String brand;
  protected String model;
  protected int year;

  Vehicle(String brand, String model, int year) {
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  // Abstract method
  abstract void welcome();

  // Concrete method
  void displayInformation() {
    System.out.println("Brand: " + brand + " | Model: " + model + " | Year: " + year);
  }
}

// Concrete class
class Car extends Vehicle {
  Car(String brand, String model, int year) {
    super(brand, model, year);
  }

  // Abstract method implemented by the concrete class
  @Override
  void welcome() {
    System.out.println("Welcome!");
  }
}

public class Runner {
  public static void main(String[] args) {
    Vehicle myCar = new Car("BMW", "iX M60", 2022);
    myCar.displayInformation();
    myCar.welcome();
  }
}
```
In the code above:
- Vehicle is an abstract class that defines a common template with both an abstract method (welcome()) and a concrete method (displayInformation()).
- Car is a concrete subclass of Vehicle that provides an implementation for the abstract method welcome() while inheriting the displayInformation() method from Vehicle.
- myCar, an instance of Car but referenced as Vehicle, can call both the inherited displayInformation() method and the overridden welcome() method.
