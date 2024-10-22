# ArrayList

## Overview
An `ArrayList` is a **linear and dynamic** data structure operating as a resizable array.

## Key Operations of an ArrayList
| Operation                 | Explanation                                                                            |
|---------------------------|----------------------------------------------------------------------------------------|
| add(Element e)            | Add the specified element to end of the ArrayList                                      |
| add(int index, Element e) | Add the specified element at specified index of the ArrayList                          |
| clear()                   | Remove all elements in the ArrayList                                                   |
| contains(Element e)       | Return true if the ArrayList contains specified element, else return false             |
| get(int index)            | Retrieve element at position index. Note: Ensure 0 <= index < size of the ArrayList    |
| isEmpty()                 | Return true only if the ArrayList is empty, else return false                          |
| remove(int index)         | Remove the element at specified index of the ArrayList                                 |
| set(int index, Element e) | Replace the current element at specified index of the ArrayList with specified element |
| size()                    | Obtain the number of elements in the ArrayList                                         |

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [ArrayListExample.java](https://github.com/shumarb/code/tree/main/code/data-structures/ArrayListExample.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/code/BasicOperations.java).
3. Store both files in the same directory (e.g., Downloads) if they are in different directories.
4. Open a terminal and navigate to the directory in Step 3.
5. Compile the files using `javac ArrayListExample.java BasicOperations.java`.
6. Run the program by entering `java ArrayListExample`.
7. The program creates an `ArrayList`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `ArrayList` and it's `key` operations, and demonstrates the application of these operations on the `ArrayList`.
