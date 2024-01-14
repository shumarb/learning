# Merge Sort

## What is Merge Sort
Merge Sort is a **comparison-based, and stable** sorting algorithm divide-and-conquer sorting algorithm that works by recursively dividing an array in smaller arrays, sorting each subarray, and merging these sorted smaller arrays together to form the sorted array.

## Worst-case Time Complexity
**O(_N_ log<sub>2</sub>_N_)**.

The Merge Sort algorithm can be expressed as a recurrence relation: `T(N) = 2T(N/2) + O(_N_)`. 

The array of size N is divided into smaller arrays with a maximum of log<sub>2</sub>_N_ parts until a smaller array of size 1 is formed for each array.

The merging steps invole combining N arrays of size 1 to form a sorted array of size N.

## Space Complexity
**O(_N_)**.

An array of N elements is divided to form N arrays of size 1 before the merge.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Open up `terminal`.
3. Navigate to this directory by entering `cd merge-sort`.
4. Compile the program by entering `javac MergeSort.java`.
5. Run the program by entering `java MergeSort`.
6. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-100 to 100`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
