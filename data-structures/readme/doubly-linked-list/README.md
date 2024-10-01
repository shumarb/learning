# Doubly Linked List

## Overview
An `Doubly Linked List` is a **linear and dynamic** data structure where each element has a pointer to it's `previous` element and a pointer to it's `next` element. 

## Key Operations
| Operation                 | Explanation                                                                                     |
|---------------------------|-------------------------------------------------------------------------------------------------|
| add(Element e)            | Add the specified element to end of the Doubly Linked List                                      |
| add(int index, Element e) | Add the specified element at specified index of the Doubly Linked List                          |
| clear()                   | Remove all elements in the Doubly Linked List                                                   |
| contains(Element e)       | Return true if the Doubly Linked List contains specified element, else return false             |
| get(int index)            | Retrieve element at position index. Note: Ensure 0 <= index < size of the Doubly Linked List    |
| isEmpty()                 | Return true only if the Doubly Linked List is empty, else return false                          |
| remove(int index)         | Remove the element at specified index of the Doubly Linked List                                 |
| set(int index, Element e) | Replace the current element at specified index of the Doubly Linked List with specified element |
| size()                    | Obtain the number of elements in the Doubly Linked List                                         |

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download [QueueExample.java](https://github.com/shumarb/learning/tree/main/data-structures/code/DoublyLinkedList.java) and [BasicOperations.java](https://github.com/shumarb/learning/tree/main/data-structures/code/BasicOperations.java)
3. Open `terminal` and navigate to the location of these 2 files.
4. Compile both programs by entering `javac DoublyLinkedList.java` and `javac BasicOperations.java`.
7. Run the program by entering `java DoublyLinkedList`.
8. The program creates an `Doubly Linked List`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Doubly Linked List` and it's `key` operations, and demonstrates the application of these operations on the `Doubly Linked List`.