# HashMap

## What is a HashMap?
A `HashMap` is a **linear and dynamic** data structure operating that uses a `hash function` to efficiently map keys to values.

According to [VisuAlgo](https://visualgo.net/en/hashtable), in order to implement efficient `hashing`, the `hash function` has to be fast to compute, uses as minimum slots out of the size of the `HashMap` as possible, scatter the keys into different base addresses as uniformly as possible ∈ [0..M-1] for a `HashMap` of size M, and experience as minimum collisions as possible.

## Key Operations of an HashMap
Operation                | Explanation
-------------------------| --------------------------------------------------------------------------------------------------------------
add(Element e)           | Add the element to end of the HashMap
add(int index, Element e)| Add the element at specified index of the HashMap
clear()                  | Remove all the elements in the HashMap
contains(Element e)      | Return true if the HashMap contains the specified element, else return false
get(int index)           | Retrieve the element at the specified index. Note: Ensure 0 <= index < size of the HashMap
isEmpty()                | Return true if the HashMap is empty, else return false
remove(int index)        | Remove the element at specified index of the HashMap
set(int index, Element e)| Replace the current element at specified index of the HashMap with the specified element
size()                   | Obtain the number of elements in HashMap

## How to use this folder
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `HashMap` folder by entering `cd data-structure/abstract-map/hashmap`.
6. Compile the program by entering `javac HashMapExample.java`.
7. Run the program by entering `java HashMapExample`.
8. The program creates an `HashMap`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `HashMap` and it's `key` operations, and demonstrates the application of these operations on the `HashMap`.
