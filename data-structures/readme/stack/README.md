# Stack

## Overview
A `Stack` is a **linear and dynamic** data structure operating on a **Last In, First Out (LIFO)** principle.

## Key Operations
| Operation           | Explanation                                                                                                 |
|---------------------|-------------------------------------------------------------------------------------------------------------|
| peek()              | Retrieves, but does not remove, object/element at top of the stack                                          |
| pop()               | Removes the object at the top of the stack                                                                  |
| push(Element e)     | Pushes object/element into top of the stack                                                                 |
| clear()             | Removes all object/elements in stack                                                                        |
| isEmpty()           | Returns true only if stack is empty, else return false                                                      |
| search(Element e)   | Returns 1-based position where object/object/element is on the stack, else return -1 if object not in stack |
| size()              | Obtains number of object/elements in stack                                                                  |
| get(int index)      | Retrieves object/element at position index. Note: Ensure 0 <= index < size of stack                         |
| contains(Element e) | Returns true if stack contains specified object/object/element, else return false                           |

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download [QueueExample.java](https://github.com/shumarb/learning/tree/main/data-structures/code/StackExample.java) and [BasicOperations.java](https://github.com/shumarb/learning/tree/main/data-structures/code/BasicOperations.java)
3. Open `terminal` and navigate to the location of these 2 files.
4. Compile both programs by entering `javac StackExample.java` and `javac BasicOperations.java`.
7. Run the program by entering `java StackExample`.
8. The program creates a `stack`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `stack` and it's `key` operations, and demonstrates the application of these operations on the `stack`.