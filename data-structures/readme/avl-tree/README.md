# AVL Tree

## What is an AVL Tree?
An `AVL Tree` is a **balanced** [Binary Search Tree](https://github.com/shumarb/learning/tree/main/data-structures/tree/binary-search-tree).
This means that the `balance factor` of every element in the `AVL Tree` is either `-1`, `0`, or `1`. The `balance factor` of an element is `height of it's left subtree - height of it's right subtree`.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download [AVLTree.java](https://github.com/shumarb/learning/tree/main/data-structures/code/AVLTree.java) and [BasicOperations.java](https://github.com/shumarb/learning/tree/main/data-structures/code/BasicOperations.java)
3. Open `terminal` and navigate to the location of these 2 files.
4. Compile both programs by entering `javac AVLTree.java` and `javac BasicOperations.java`.
5. Run the program by entering `java AVLTree`.
6. The program creates an `AVL Tree` with `5 to 12` elements. The elements are of type `integer` with a value between `-100 to 100`. You are advised to `draw` the `AVL tree` based on the `Pre-Order traversal (display order: leftchild - current element - rightchild)` that displays the element's information as `[element's data, element's height in the AVL Tree]`. The program demonstrates the `deletion`, `insertion`, and `search` operations on the `AVL Tree`.
