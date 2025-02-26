# Binary Search

## Overview
Binary Search is an efficient search algorithm that checks whether element is available in a `data structure (array or list)` by disregarding elements greater than or less than the element to search for.

## Procedure
1. Ensure the `data structure (array or list)` is `sorted`, and the element to search be denoted as `key`.
2. Check the `middle element` of the data structure.
3. If the `middle element == key`, the `key` exists in the data structure.
4. If the `middle element < key`, disregard `all elements <= middle element`.
5. If the `middle element > key`, disregard `all elements >= middle element`.
6. Repeat steps `2 to 5` until either the `key` is found or all elements have been discarded (meaning the `key` does not exist).

The time complexity is **O(log<sub>2</sub>_N_)**,
because the portion of the `data structure (array or list)`
that could contain the element is repeatedly `divided` into half
until it is of size `1`.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [BinarySearch.java](https://github.com/shumarb/code/blob/main/algorithms/BinarySearch.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/algorithms/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a `terminal` and navigate to the directory in Step 3.
5. Compile the files using `javac BasicOperations.java BinarySearch.java`.
6. Run the program by entering `java BinarySearch`.
7. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and both the `key (number to find)` and the value of the elements range from `-10 to 10`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
