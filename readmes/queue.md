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

## Types
| Type                       | Explanation                                                                                                            |
|----------------------------|------------------------------------------------------------------------------------------------------------------------|
| Simple Queue               | Elements are inserted at the rear and removed from the front, following the `FIFO` principle.                          |
| Deque (Double Ended Queue) | Elements can be added or removed from `both` ends of the queue.                                                        |
| Circular Queue             | The last element is connected back to the first element, hence forming a circle.                                       |
| Priority Queue (Heap)      | Each element has a priority, and elements with a higher priority are dequeued before elements with a lower priority.   |
| Affinity Queue             | Every element has an `affinity` & is placed with elements sharing the same `affinity`; otherwise placed at the rear.   |

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [QueueExample.java](https://github.com/shumarb/code/tree/main/data-structures/QueueExample.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/support/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a terminal and navigate to the directory in Step 3.
5. Compile the files using `javac QueueExample.java BasicOperations.java`.
6. Run the program by entering `java QueueExample`.
7. The program creates a `Queue`. The elements are of type `integer`, and the number of elements range from `5 to 12`. The program provides a brief explanation of a `Queue` and it's `key` operations, and demonstrates the application of these operations on the `Queue`.

## References
1. Grokking Data Structures & Algorithms for Coding Interviews by Design Gurus. Accessed from: https://www.designgurus.io/course/grokking-data-structures-for-coding-interviews.