# ArrayList

## What is an ArrayList?
An `ArrayList` is a **linear and dynamic** data structure operating as a resizable array.

## Key Operations of an ArrayList
Operation                | Explanation
-------------------------| --------------------------------------------------------------------------------------------------------------
add(Element e)           | Add the specified element to end of the ArrayList
add(int index, Element e)| Add the specified element at specified index of the ArrayList
clear()                  | Remove all elements in the ArrayList
contains(Element e)      | Return true if the ArrayList contains specified element, else return false
get(int index)           | Retrieve element at position index. Note: Ensure 0 <= index < size of the ArrayList
isEmpty()                | Return true only if the ArrayList is empty, else return false
remove(int index)        | Remove the element at specified index of the ArrayList
set(int index, Element e)| Replace the current element at specified index of the ArrayList with specified element
size()                   | Obtain the number of elements in the ArrayList

## Instructions
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `ArrayList` folder by entering `cd data-structure/abstract-list/array-
list`.
6. Compile the program by entering `javac ArrayListExample.java`.
7. Run the program by entering `java ArrayListExample`.
8. The program creates an `ArrayList`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `ArrayList` and it's `key` operations, and demonstrates the application of these operations on the `ArrayList`.