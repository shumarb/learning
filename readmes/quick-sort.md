# Quick Sort

## Overview
Quick Sort is a **comparison-based, in-place,
and unstable** `divide-and-conquer` sorting algorithm that works by selecting an element as a pivot,
forming two partitions
by shifting all elements smaller and larger than the pivot to the left and right of the pivot respectively,
and recursively sorts these two partitions.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [QuickSort.java](https://github.com/shumarb/code/blob/main/algorithms/QuickSort.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a `terminal` and navigate to the directory in Step 3.
5. Compile the files using `javac BasicOperations.java QuickSort.java`.
6. Run the program by entering `java QuickSort`.
7. The program creates an array randomly. The elements are of type `integer`. The number of elements ranges from `5 to 12`, and the value elements range from `-100 to 100`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
