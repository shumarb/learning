# Sort

This repository contains sorting techniques that I implemented on my own.
Sort Technique | Worst-case Time Complexity | Space Complexity | In-place? | Stable?
------------------| ---------------------------| ---------------- | ----------| -------
[Merge Sort](https://github.com/shumarb/notes-and-code/tree/main/sort/merge-sort)                | O(Nlog<sub>2</sub>N)  | O(N) | No  | Yes
[Bubble Sort](https://github.com/shumarb/notes-and-code/tree/main/sort/bubble-sort)              | O($N^2$)              | O(1) | Yes | Yes
[Insertion Sort](https://github.com/shumarb/notes-and-code/tree/main/sort/insertion-sort)        | O($N^2$)              | O(1) | Yes | Yes
[Quick Sort](https://github.com/shumarb/notes-and-code/tree/main/sort/quick-sort)                | O($N^2$)              | O(1) | Yes | No
[Selection Sort](https://github.com/shumarb/notes-and-code/tree/main/sort/selection-sort)        | O($N^2$)              | O(1) | Yes | No

In-place sort: A sorting algorithm is an **in-place** sort if it requires only a **constant amount of time O(1) of extra space** during the sorting process.

Stable sort: A sorting algorithm is **stable** if the **relative order of elements with the same key value is preserved** by the algorithm.

## How to use this folder
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/online-learning/tree/main/notes-and-code).
2. Open `terminal`.
3. Navigate to a folder containing the `sorting technique` you are interested in. (Example: `cd selection-sort`).
4. Compile the Java code by entering `javac sort-technique.java`. (Example: `javac SelectionSort.java`).
5. Run the program by entering `java sort-technique`. (Example: `javac SelectionSort`).
6. The program creates an array randomly. This is to validate the correctness of the algorithm in all-possible cases. The elements are of type `integer`. The number of elements range from `5 to 12`, and the value elements range from `-1000 to 1000`. The program displays the array before the sort, the steps of the sort technique that occur during the iteration of the array, the array after the sort, and a side-by-side comparison of the array before and after the sort.
