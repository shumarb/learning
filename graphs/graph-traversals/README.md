# Graph Traversals

## Overview
The following are `graph traversal` techniques:

Graph Traversal Technique  | Definition
---------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
Breadth-first Search (BFS) | For every **source** vertex, visit all vertices on the same level before proceeding to the next vertex.
Depth-first Search (DFS)   | For every **source** vertex, visit a vertex and explore this vertex's path until a dead-end is reached before visiting the next unvisited vertex.

To keep track of the unvisited vertices, **BFS** uses a [Queue](https://github.com/shumarb/learning/tree/main/data-structures/abstract-list/queue), while **DFS** uses a [Stack](https://github.com/shumarb/learning/tree/main/data-structures/abstract-list/stack).

## Instructions
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the location where the repository is cloned.
5. Navigate to the `graph-traversals` folder by entering `cd graphs/graph-traversals`.
6. Compile the program by entering `javac GraphTraversals.java`.
7. Run the program by entering `java GraphTraversals`.
8.  The program creates an `Adjacency List` comprising of `3 to 7` vertices, and each vertex is denoted by a `letter`. The `weight` of the edges are betewen `-100 to 100`. The program displays the `Adjacency Matrix`, from which you can draw the `undirected and weighted graph`.
9. A **source** vertex is randomly selected, and the result of executing a **BFS** and **DFS** graph traversals from this vertex is displayed.