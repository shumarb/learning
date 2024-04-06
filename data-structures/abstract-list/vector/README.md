# Vector

## Overview
A `Vector` is a **linear and dynamic** data structure operating as a resizable array.

## Key Operations of an Vector
Operation                | Explanation
-------------------------| --------------------------------------------------------------------------------------------------------------
add(Element e)           | Add the element to end of the Vector
add(int index, Element e)| Add the element at specified index of the Vector
clear()                  | Remove all the elements in the Vector
contains(Element e)      | Return true if the Vector contains the specified element, else return false
get(int index)           | Retrieve the element at the specified index. Note: Ensure 0 <= index < size of the Vector
isEmpty()                | Return true if the Vector is empty, else return false
remove(int index)        | Remove the element at specified index of the Vector
set(int index, Element e)| Replace the current element at specified index of the Vector with the specified element
size()                   | Obtain the number of elements in Vector

## Instructions
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `Vector` folder by entering `cd data-structure/abstract-list/vector`.
6. Compile the program by entering `javac VectorExample.java`.
7. Run the program by entering `java VectorExample`.
8. The program creates an `Vector`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Vector` and it's `key` operations, and demonstrates the application of these operations on the `Vector`.