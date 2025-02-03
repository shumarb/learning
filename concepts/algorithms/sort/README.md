# Sort

## Overview
The following illustrates a comparison of different sorting techniques:

| Sort Technique                                                                                 | Worst-case Time Complexity | Space Complexity | In-place? | Stable? |
|------------------------------------------------------------------------------------------------|----------------------------|------------------|-----------|---------|
| [Heap Sort](https://github.com/shumarb/learning/tree/main/algorithms/sort/heap-sort)           | O(_N_ log<sub>2</sub>_N_)  | O(1)             | Yes       | No      |
| [Merge Sort](https://github.com/shumarb/learning/tree/main/algorithms/sort/merge-sort)         | O(_N_ log<sub>2</sub>_N_)  | O(_N_)           | No        | Yes     |
| [Bubble Sort](https://github.com/shumarb/learning/tree/main/algorithms/sort/bubble-sort)       | O($N^2$)                   | O(1)             | Yes       | Yes     |
| [Insertion Sort](https://github.com/shumarb/learning/tree/main/algorithms/sort/insertion-sort) | O($N^2$)                   | O(1)             | Yes       | Yes     |
| [Quick Sort](https://github.com/shumarb/learning/tree/main/algorithms/sort/quick-sort)         | O($N^2$)                   | O(1)             | Yes       | No      |
| [Selection Sort](https://github.com/shumarb/learning/tree/main/algorithms/sort/selection-sort) | O($N^2$)                   | O(1)             | Yes       | No      |

In-place sort: A sorting algorithm is an **in-place** sort if it requires only a **constant amount of time O(1) of extra space** during the sorting process.

Stable sort: A sorting algorithm is **stable** if the **relative order of elements with the same key value is preserved** by the algorithm.
