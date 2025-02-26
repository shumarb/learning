# Depth-First Search

## Overview
`Depth-First Search (DFS)`
is a graph traversal algorithm
that explores all nodes in a graph by systematically visiting as far as possible a branch before backtracking
and exploring unexplored branches.

A `Stack` is used due to its `Last In First Out (LIFO) principle`.
This ensures a branch is traversed in the deepest possible way before backtracking.

## Procedure
1. Identify the source vertex, which is the vertex to execute the `Depth First Search`. 
2. Create a boolean `visited` array to track whether a vertex has been visited.
3. Initialise an empty stack and push the `source` vertex from `Step 1` onto it.
4. While the `stack` is not empty:
   1. Pop the `top` vertex from the stack.
   2. Mark the `top` vertex as `visited`.
   3. Process the `top` vertex (eg: Display it).
   4. Get all of its `adjacent` vertices (i.e.: all vertices connected to the `top` vertex).
   5. Push every unvisited `adjacent` onto the `stack`.
5. Repeat Step 4 until the stack is empty.
6. All reachable vertices from the `source` vertex has been visited.

## Instructions
1. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
2. Download these Java source files in the [Code](https://github.com/shumarb/code/tree/main) repository: [DepthFirstSearch.java](https://github.com/shumarb/code/blob/main/data-structures/AdjacencyList.java), and [BasicOperations.java](https://github.com/shumarb/code/tree/main/BasicOperations.java).
3. Store both files in the same directory (e.g. Downloads) if they are in different directories.
4. Open a `terminal` and navigate to the directory in Step 3.
5. Compile the files using `javac DepthFirstSearch.java BasicOperations.java`.
6. Run the program by entering `java DepthFirstSearch`.
7. The program creates an `Adjacency List` comprising `3 to 7` vertices, and each vertex is denoted by a `letter`. The `weight` of the edges are between `-100 to 100`.
8. A `Depth First Search` is executed in Vertex `A`.
