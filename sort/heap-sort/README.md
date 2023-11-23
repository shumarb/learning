# Heap Sort

## What is Heap Sort
Heap Sort is a **comparison-based, in-place, and unstable** sorting algorithm based on a `Binary Search Tree`.

## How does Heap Sort work
1. `max-heapify` the `array/list` by rearranging the elements based on creating a `Binary Search Tree`, where `every element is >= all of it's descendents`.

2. `extract` the root of the `Binary Search Tree` by `swapping` the `maximum` and `last` elements, `max-heapify` the remaining elements, and repeating until the `Binary Search Tree` is of size 1.

## Worst-case Time Complexity
**O(_N_ log<sub>2</sub>_N_)**.

1. `Max-heapify` the `array/list`. Each element requires a time complexity of O(log<sub>2</sub>_N_). Hence, `max-heapifying` N elements requires a time complexity of O(_N_ log<sub>2</sub>_N_).

2. `Extracting` the root and swapping it with the last element requires a time complexity of O(_N_), and `max-heapifying` the remaining `(N - 1)` elements until the `Binary Search Tree` is of size 1 requires a time complexity of O((N - 1)log<sub>2</sub>_N_) = (Nlog<sub>2</sub>_N_).

Therefore, the worst-case Time Complexity is O(_N_ log<sub>2</sub>_N_) + O(_N_) + O(_N_ log<sub>2</sub>_N_) = O(2Nlog<sub>2</sub>_N_ + N) = O(_N_ log<sub>2</sub>_N_).

## Space Complexity
**O(1)**.

A constant amount of time of extra space is required.

## How to use this folder
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Open up `terminal`.
3. Navigate to this directory by entering `cd heap-sort`.
4. Compile the program by entering `javac HeapSort.java`.
5. Run the program by entering `java HeapSort`.
6. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-100 to 100`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
