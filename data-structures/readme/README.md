# Queue

## Overview
A `Queue` is a **linear and dynamic** data structure operating on a **First In, First Out (FIFO)** principle.

## Key Operations
Operation                | Explanation
-------------------------| --------------------------------------------------------------------------------------------------------------
peek()                   | Retrieve, but does not remove, the element at top of the `Queue`
poll()                   | Remove the element at the top of the `Queue`
offer(Element e)         | Add the element to the top of the `Queue`
clear()                  | Remove all the elements in the `Queue`
isEmpty()                | Return true only if the `Queue` is empty, else return false
search(Element e)        | Return 1-based position of the element in the `Queue`, else return `-1` if the element is not in the `Queue`
size()                   | Obtain the total number of elements in the `Queue`
get(int index)           | Retrieve the element at specified `index`. Note: Ensure index < size of the `Queue`
contains(Element e)      | Return true if the `Queue` contains specified element, else return false

## Instructions
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `queue` folder by entering `cd data-structure/abstract-list/queue`.
6. Compile the program by entering `javac QueueExample.java`.
7. Run the program by entering `java QueueExample`.
8. The program creates a `Queue`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Queue` and it's `key` operations, and demonstrates the application of these operations on the `Queue`.