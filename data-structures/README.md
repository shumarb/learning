# Data Structures

This folder contains my summary of structures.

The following illustrates the worst-case time complexity for operations on each of the `N` elements (where `N >= 1`) in each data structure:

Data Structure           | Insertion               | Deletion                | Search                   | Search Maximum            | Search Minimum
------------------------ | ----------------------- | ----------------------- | -----------------------  | -----------------------   | -----------------------
[Array](https://github.com/shumarb/notes-and-code/tree/main/data-structures/array) | O(1) | O(_N_) | O(_N_) | O(_N_) | O(_N_)
[ArrayList](https://github.com/shumarb/notes-and-code/tree/main/data-structures/abstractlist/arraylist) / [Vector](https://github.com/shumarb/notes-and-code/tree/main/data-structures/abstractlist/vector) | O(1) | O(1) | O(_N_) | O(_N_) | O(_N_)
[Binary Max Heap](https://github.com/shumarb/notes-and-code/tree/main/data-structures/tree/binary-max-heap) | O(log<sub>2</sub>_N_) | O(log<sub>2</sub>_N_) | O(_N_) | O(1) | O(_N_)
[Binary Min Heap](https://github.com/shumarb/notes-and-code/tree/main/data-structures/tree/binary-min-heap) | O(log<sub>2</sub>_N_) | O(log<sub>2</sub>_N_) | O(_N_)  | O(_N_) | O(1)
[Binary Search Tree](https://github.com/shumarb/notes-and-code/tree/main/data-structures/tree/binary-search-tree) | O(_N_) | O(_N_) | O(_N_) | O(_N_) | O(_N_)
[Linked List (Doubly)](https://github.com/shumarb/notes-and-code/tree/main/data-structures/abstractlist/linkedlist/doubly-linked-list) | O(1) | O(1) | O(_N_) | O(_N_) | O(_N_)
[Linked List (Singly)](https://github.com/shumarb/notes-and-code/tree/main/data-structures/abstractlist/linkedlist/singly-linked-list) | O(_N_) | O(_N_) | O(_N_) | O(_N_) | O(_N_)
[Queue](https://github.com/shumarb/notes-and-code/tree/main/data-structures/abstractlist/queue) | O(1) | O(1) | O(_N_) | O(_N_) | O(_N_)   
[Stack](https://github.com/shumarb/notes-and-code/tree/main/data-structures/abstractlist/stack) | O(1) | O(1) | O(_N_) | O(_N_) | O(_N_)

## How to use this folder
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/notes-and-code#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to a `data-structure-type` folder by entering `cd data-structure`.
5. Navigate to the `data-structure` you are interested in by entering the directory of the folder/subfolder (Example: `cd array`, `cd abstractlist/queue`).
