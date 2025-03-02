# Vector

## Overview
A `Vector` is a **linear and dynamic** data structure operating as a resizable array.

## Key Operations
| Operation                 | Explanation                                                                               |
|---------------------------|-------------------------------------------------------------------------------------------|
| add(Element e)            | Add the element to end of the Vector                                                      |
| add(int index, Element e) | Add the element at specified index of the Vector                                          |
| clear()                   | Remove all the elements in the Vector                                                     |
| contains(Element e)       | Return true if the Vector contains the specified element, else return false               |
| get(int index)            | Retrieve the element at the specified index. Note: Ensure 0 <= index < size of the Vector |
| isEmpty()                 | Return true if the Vector is empty, else return false                                     |
| remove(int index)         | Remove the element at specified index of the Vector                                       |
| set(int index, Element e) | Replace the current element at specified index of the Vector with the specified element   |
| size()                    | Obtain the number of elements in Vector                                                   |

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [VectorExample.java](https://github.com/shumarb/code/tree/main/data-structures/VectorExample.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/support/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a terminal and navigate to the directory in Step 3.
5. Compile the files using `javac VectorExample.java BasicOperations.java`.
6. Run the program by entering `java VectorExample`.
7. The program creates an `Vector`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Vector` and it's `key` operations, and demonstrates the application of these operations on the `Vector`.
