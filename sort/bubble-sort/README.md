# Bubble Sort

## Overview
Bubble Sort is a **comparison-based, in-place, and stable** sorting algorithm that works by repeatedly swapping the adjacent elements if both these elements are in the wrong order.

The Bubble Sort algorithm comprises of a nested loop. The outer loop iterates from the first element to the penultimate element of the array, and the inner loop iterates from the second element to the last element of the array. 
Hence, each loop iterates through `N - 1` elements.
Therefore, the Time Complexity is O((N - 1) * (N - 1)) = O($N^2$ - 2N + 1) = O($N^2$).

Bubble Sort has a time Complexity of `O(1)`.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Copy the [BubbleSort.java](https://github.com/shumarb/learning/blob/main/sort/bubble-sort/BubbleSort.java) code.
3. Open up `terminal`.
4. Enter `vi BubbleSort.java`
4. Paste the code in Step `2`.
5. Compile the program by entering `javac BubbleSort.java`.
6. Run the program by entering `java BubbleSort`.
7. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-100 to 100`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
