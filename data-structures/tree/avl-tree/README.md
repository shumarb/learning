# AVL Tree

## What is an AVL Tree?
An `AVL Tree` is a **balanced** [Binary Search Tree](https://github.com/shumarb/learning/tree/main/data-structures/tree/binary-search-tree).
This means that the `balance factor` of every element in the `AVL Tree` is either `-1`, `0`, or `1`. The `balance factor` of an element is `height of it's left subtree - height of it's right subtree`.

## How to use this folder
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `avl-tree` folder by entering `cd data-structure/tree/avl-tree`.
6. Compile the program by entering `javac AVLTree.java`.
7. Run the program by entering `java AVLTree`.
8. The program creates an `AVL Tree` with `5 to 12` elements. The elements are of type `integer` with a value between `-100 to 100`. You are advised to `draw` the `AVL tree` based on the `Pre-Order traversal (display order: leftchild - current element - rightchild)` that displays the element's information as `[element's data, element's height in the AVL Tree]`. The program demonstrates the `deletion`, `insertion`, and `search` operations on the `AVL Tree`.