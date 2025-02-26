# Breadth-First Search

## Overview
`Breadth-First Search (BFS)` is a graph traversal algorithm that explores a graph's vertices `level-by-level`.
It works from a source vertex and moves outward to visit all vertices at the `same distance` from the source before moving on to vertices at the next level.

A `Queue` is used due to its `First In First Out (FIFO) principle`.
This ensures all vertices are processed `level-by-level`.

## Procedure
1. Identify the `source` vertex, which is the vertex to execute the `Breadth First Search`.
2. Create a boolean `visited` array to track whether a vertex has been visited.
3. Initialise an empty `queue` and offer the `source` vertex from `Step 1` onto it.
4. While the `queue` is not empty:
    1. Poll the `top` vertex.
    2. Mark the `top` vertex as `visited`.
    3. Process the `top` vertex (eg: Display it).
    4. Get all of its `adjacent` vertices (i.e.: all vertices connected to the `top` vertex).
    5. Offer every unvisited `adjacent` onto the `queue`.
5. Repeat Step 4 until the `queue` is empty.
6. All vertices from the `source` vertex has been visited `level-by-level`.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [BreadthFirstSearch.java](https://github.com/shumarb/code/blob/main/algorithms/BreadthFirstSearch.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/support/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a `terminal` and navigate to the directory in Step 3.
5. Compile the files using `javac BreadthFirstSearch.java BasicOperations.java`.
6. Run the program by entering `java BreadthFirstSearch`.
7. The program creates an `Adjacency List` comprising `3 to 7` vertices, and each vertex is denoted by a `letter`. The `weight` of the edges are between `-100 to 100`.
8. A `Breadth First Search` is executed in Vertex `A`.
