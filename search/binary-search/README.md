# Binary Search

## What is Binary Search
Binary Search is an efficient search algorithm that checks whether element is available in a `data structure (array or list)` by disregarding elements greater than or less than the key.

## How Binary Search Works
1. Ensure the `data structure (array or list)` is `searched`, and the element to search be denoted as `key`.
2. Check the `middle` element of the data structure.
3. If the `middle element == key`, the key exists in the data structure.
3. If the `middle element < key`, disregard `all elements <= middle element`, which is the `left half` of the data structure.
4. If the `middle element > key`, disregard `all elements >= middle element`, which is the `right half` of the data structure.
5. Repeat steps `2 to 5` until either the key is found or all elements have been discarded (meaning the key does not exist).

## Worst-case Time Complexity
**O(log<sub>2</sub>N)**.

This is because the portion of the list that could contain the element is repeatedly `divided` into half until it is of size `1`.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK) version 8 or later`.
2. Open up `terminal`.
3. Navigate to this directory by entering `cd binary-search`.
4. Compile the program by entering `javac BinarySearch.java`.
5. Run the program by entering `java BinarySearch`.
6. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and both the `key (number to find)` and the value of the elements range from `-10 to 10`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.