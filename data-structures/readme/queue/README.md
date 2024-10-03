# Queue

## Overview
A `Queue` is a **linear and dynamic** data structure operating on a **First In, First Out (FIFO)** principle.

## Key Operations
| Operation           | Explanation                                                                                                  |
|---------------------|--------------------------------------------------------------------------------------------------------------|
| peek()              | Retrieve, but does not remove, the element at top of the `Queue`                                             |
| poll()              | Remove the element at the top of the `Queue`                                                                 |
| offer(Element e)    | Add the element to the top of the `Queue`                                                                    |
| clear()             | Remove all the elements in the `Queue`                                                                       |
| isEmpty()           | Return true only if the `Queue` is empty, else return false                                                  |
| search(Element e)   | Return 1-based position of the element in the `Queue`, else return `-1` if the element is not in the `Queue` |
| size()              | Obtain the total number of elements in the `Queue`                                                           |
| get(int index)      | Retrieve the element at specified `index`. Note: Ensure index < size of the `Queue`                          |
| contains(Element e) | Return true if the `Queue` contains specified element, else return false                                     |

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download [QueueExample.java](https://github.com/shumarb/learning/tree/main/data-structures/code/QueueExample.java) and [BasicOperations.java](https://github.com/shumarb/learning/tree/main/data-structures/code/BasicOperations.java)
3. Open `terminal` and navigate to the location of these 2 files.
4. Compile both programs by entering `javac QueueExample.java` and `javac BasicOperations.java`.
5. Run the program by entering `java QueueExample`.
6. The program creates a `Queue`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Queue` and it's `key` operations, and demonstrates the application of these operations on the `Queue`.
