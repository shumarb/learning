# Queue

## What is a Queue?
A `Queue` is a **linear and dynamic** data structure operating on a **First In, First Out (FIFO)** principle.

## Key Operations of Queue
Operation                | Explanation
-------------------------| --------------------------------------------------------------------------------------------------------------
peek()                   | Retrieves, but does not remove, element at top of the `Queue`
pop()                    | Removes the element at the top of the `Queue`
push(Element e)          | Pushes element into top of the `Queue`
clear()                  | Removes all elements in the `Queue`
isEmpty()                | Returns true only if the `Queue` is empty, else return false
search(Element e)        | Returns 1-based position of the element in the `Queue`, else return `-1` if the element is not in the `Queue`
size()                   | Obtains number of object/elements in the `Queue`
get(int index)           | Retrieves element at specified `index`. Note: Ensure index < size of the `Queue`
contains(Element e)      | Returns true if the `Queue` contains specified element, else return false

## How to use this folder
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/notes-and-code#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `queue` folder by entering `cd data-structure/queue`.
6. Compile the program by entering `javac QueueExample.java`.
7. Run the program by entering `java QueueExample`.
8. The program creates a `Queue`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Queue` and it's `key` operations, and demonstrates the application of these operations on the `Queue`.
