# Heap Sort

## What is Heap Sort
Heap Sort is a **comparison-based, in-place, and unstable** sorting algorithm based on a `binary max heap`.

## How does Heap Sort work
1. `max-heapify` the `array/list` by rearranging the elements based on creating a `binary max heap`, where `every element is >= all of it's descendents`.

2. `extract` the root of the `binary max heap` by `swapping` the `maximum` element with the `last` element of the `array/list`, then `max-heapify` the remaining elements. Repeat until the `binary max heap` is of size 1.

## Worst-case Time Complexity
**O(Nlog<sub>2</sub>N)**.

1. `Max-heapify` the `array/list`. Each element requires a time complexity of `O(log<sub>2</sub>N)`. Hence, `max-heapifying` N elements requires a time complexity of `O(Nlog<sub>2</sub>N)`.

2. `Extracting` the root and swapping it with the last element requires a time complexity of `O(N)`, and `Max-heapifying` the remaining `(N - 1)` elements until the `binary max heap` is of size 1 requires a time complexity of `O((N - 1)log<sub>2</sub>N)` = `O(Nlog<sub>2</sub>N)`.

Therefore, the worst-case Time Complexity is O(Nlog<sub>2</sub>N) + O(N) + O(Nlog<sub>2</sub>N) = O(2Nlog<sub>2</sub>N + N) = `O(Nlog<sub>2</sub>N)`.

## Space Complexity
**O(1)**.

A constant amount of time of extra space is required.

## How to use this folder
1. Ensure that your local machine contains a `Java Development Kit (JDK) version 8 or later`.
2. Open up `terminal`.
3. Navigate to this directory by entering `cd heap-sort`.
4. Compile the program by entering `javac HeapSort.java`.
5. Run the program by entering `java HeapSort`.
6. The program creates an array randomly. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-10000 to 10000`. The program displays the array before the sort, the relevant steps during the sort, the array after the sort, and the side-by-side comparison of the array before and after the sort.
