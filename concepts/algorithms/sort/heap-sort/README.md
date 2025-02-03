# Heap Sort

## Overview
Heap Sort is a **comparison-based, in-place, and unstable** sorting algorithm based on a `Binary Search Tree`.

Heap Sort works as follows:
1. `max-heapify` the `array/list` by rearranging the elements based on a `Binary Search Tree`, where `every element is greater than or equal to all of it's descendents`.
2. `extract` the root of the `Binary Search Tree` by `swapping` the `maximum` and `last` elements, `max-heapify` the remaining elements, and repeating until the `Binary Search Tree` is of size 1.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [HeapSort.java](https://github.com/shumarb/code/tree/main/algorithms/sort/HeapSort.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/BasicOperations.java).
3. Store both files in the same directory (e.g., Downloads) if they are in different directories.
4. Open a `terminal` and navigate to the directory in Step 3.
5. Compile the files using `javac BasicOperations.java HeapSort.java`.
6. Run the program by entering `java HeapSort`.
7. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-100 to 100`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
