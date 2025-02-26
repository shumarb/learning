# AVL Tree

## What is an AVL Tree?
An `AVL Tree` is a **balanced** [Binary Search Tree](https://github.com/shumarb/learning/tree/main/data-structures/tree/binary-search-tree).
This means that the `balance factor` of every element in the `AVL Tree` is either `-1`, `0`, or `1`. The `balance factor` of an element is `height of it's left subtree - height of it's right subtree`.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [AVLTree.java](https://github.com/shumarb/code/tree/main/data-structures/AVLTree.java), [BasicOperations.java](https://github.com/shumarb/code/tree/main/support/BasicOperations.java), and [Node.java](https://github.com/shumarb/code/tree/main/data-structures/Node.java).
3. Store all three files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a terminal and navigate to the directory in Step 3.
5. Compile the files using `javac AVLTree.java BasicOperations.java Node.java`.
6. Run the program by entering `java AVLTree`.
7. The program creates an `AVL Tree` with `5 to 12` elements. The elements are of type `integer` with a value between `-100 to 100`. You are advised to `draw` the `AVL tree` based on the `Pre-Order traversal (display order: leftchild - current element - rightchild)` that displays the element's information as `[element's data, element's height in the AVL Tree]`. The program demonstrates the `deletion`, `insertion`, and `search` operations on the `AVL Tree`.
