# Stack

## What is a Stack?
A `Stack` is a **linear and dynamic** data structure operating on a **Last In, First Out (LIFO)** principle.

## Key Operations of Stack
Operation                | Explanation
-------------------------| --------------------------------------------------------------------------------------------------------------
peek()                   | Retrieves, but does not remove, object/element at top of the stack
pop()                    | Removes the object at the top of the stack
push(Element e)          | Pushes object/element into top of the stack
clear()                  | Removes all object/elements in stack
isEmpty()                | Returns true only if stack is empty, else return false
search(Element e)        | Returns 1-based position where object/object/element is on the stack, else return -1 if object not in stack
size()                   | Obtains number of object/elements in stack
get(int index)           | Retrieves object/element at position index. Note: Ensure 0 <= index < size of stack
contains(Element e)      | Returns true if stack contains specified object/object/element, else return false

## Instructions
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `stack` folder by entering `cd data-structure/abstract-list/stack`.
6. Compile the program by entering `javac StackExample.java`.
7. Run the program by entering `java StackExample`.
8. The program creates a `stack`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `stack` and it's `key` operations, and demonstrates the application of these operations on the `stack`.