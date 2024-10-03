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
2. Download [ArrayList.java](https://github.com/shumarb/learning/tree/main/data-structures/code/ArrayListExample.java) and [BasicOperations.java](https://github.com/shumarb/learning/tree/main/data-structures/code/BasicOperations.java) 
3. Open `terminal` and navigate to the location of these 2 files.
4. Compile both programs by entering `javac ArrayListExample.java` and `javac BasicOperations.java`.
5. Run the program by entering `java ArrayListExample`.
6. The program creates an `ArrayList`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `ArrayList` and it's `key` operations, and demonstrates the application of these operations on the `ArrayList`.