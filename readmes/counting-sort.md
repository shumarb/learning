# Counting Sort

## Overview
Counting Sort is an integer sorting algorithm that counts the occurrences of each distinct element in an `input` array,
and uses this frequency information to determine the final positions of the elements in the sorted array.

## Procedure
1. Create an `integerFrequency` array, where the `index` represents the possible values in the `input` array, and its corresponding `element` represents the number of times the value appears in the array..
2. Identify the maximum absolute value in the array so that negative values can be populated in the `integerFrequency` array.
3. Iterate through the `input` array, and for each element, increase its corresponding value in the `integerFrequency`.
4. Iterate through the `integerFrequency` array, and for each `index` with a non-zero count, place the `index` value (corresponding to the element) into the `sorted array` by the `number of times` indicated by the `frequency` at that `index`.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [CountingSort.java](https://github.com/shumarb/code/blob/main/algorithms/CountingSort.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/support/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a `terminal` and navigate to the directory in Step 3.
5. Compile the files using `javac BasicOperations.java HeapSort.java`.
6. Run the program by entering `java HeapSort`.
7. The program creates an array randomly. The elements are of type `integer`. The number of elements ranges from `5 to 12`, and the value elements range from `-100 to 100`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
