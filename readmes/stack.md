# Stack

## Overview
A `Stack` is a **linear and dynamic** data structure operating on a **Last In,
First Out (LIFO)** principle, where the most-recent element added is the first one to be removed.

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
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [StackExample.java](https://github.com/shumarb/code/tree/main/data-structures/StackExample.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/support/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a terminal and navigate to the directory in Step 3.
5. Compile the files using `javac StackExample.java BasicOperations.java`.
6. Run the program by entering `java StackExample`.
7. The program creates a `stack`. The elements are of type `integer`, and the number of elements ranges from `5 to 12`. The program provides a brief explanation of a `stack` and it's `key` operations, and demonstrates the application of these operations on the `stack`.
