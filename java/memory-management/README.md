# Memory Management

## Overview
Java memory management involves the organisation of memory into different areas and automatic memory management of memory allocation and deallocation.
This includes a **Stack**, **Heap**, and **Garbage Collection**.

## Components
- Stack Memory
  - Purpose: Stores method call frames, local variables, and method call information.
  - Characteristics:
    - LIFO (Last In, First Out) structure.
    - Memory is automatically allocated and deallocated as methods are called and return.
    - Limited Size: Fixed size per thread, leading to stack overflow if exceeded.

- Heap Memory
  - Purpose: Stores dynamically allocated objects and class instances.
  - Characteristics:
    - **Dynamic Size**: Grows and shrinks as objects are created and garbage collected.
    - Objects remain in memory until they are no longer referenced and are eligible for garbage collection.
    - **Garbage Collection**: Automatic process that reclaims memory used by unreferenced objects.

- Garbage Collection
  - Purpose: Automatically manages memory by reclaiming unused objects to free up heap space.
  - Characteristics:
    - Mark-and-Sweep Algorithm: Identifies and removes unreachable objects.
    - Generational Collection: Segments heap into generations (Young, Old) to optimize collection performance.
    - Minor vs. Major GC: Minor GC handles young generation; Major GC (Full GC) handles both young and old generations.

Implementation
- Stack Memory Management
  - Managed by the Java Virtual Machine (JVM), with automatic allocation and deallocation.

- Heap Memory Management
  - Managed by the JVM, with objects allocated on the heap and cleaned up by the garbage collector.

- Garbage Collection
  - **Automatic**: The JVM periodically runs garbage collection to manage memory.
  - **Tuning**: JVM options allow configuration of garbage collection behavior to optimize performance.

## Example
```java
public class MemoryManagementDemo {
    public static void main(String[] args) {
        // Stack memory example
        int localVar = 10; // Allocated on the stack

        // Heap memory example
        Person person = new Person("John", 25); // Allocated on the heap

        // Person object is eligible for garbage collection when no longer referenced
        person = null; // Object is now eligible for garbage collection
    }
}

class Person {
    private String name;
    private int age;
  
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```
In the MemoryManagementDemo class:
- The localVar `variable` is stored on the `stack` and is automatically managed.
- The Person `object` is allocated on the `heap`.
- Once person is set to `null`, the Person object is eligible for `garbage collection` if no other references exist.

This design ensures efficient memory use and automatic management, reducing the risk of memory leaks and optimizing performance.
