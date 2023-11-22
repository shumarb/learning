# Graphs

This folder contains my summary of graph concepts.

## What is a Graph?
A `Graph` is a set of `vertices` such that some pairs of the `vertices` are connected to each other by an `edge`, which are `weighted/unweighted`, and `directed/undirected`.
           
Concept           
----------------------------------------------------------------------------------------------------|
[Graph Data Structures](https://github.com/shumarb/learning/tree/main/graphs/graph-data-structures)

## Graph Terminologies
Terminology                     | Explanation
--------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------
Bipartite Graph                 | `Undirected` graph such that the vertices can be partitioned into two sets so that there are no edges between members of the same set
Complete Graph                  | A graph with N vertices and <sub>N</sub>C<sub>2</sub> edges
Connected Graph                 | There exists >= 1 path for any pair of vertices in the graph
Sub Graph                       | Subset of vertices and their connecting edges of their original graph 
Dense Graph                     | A graph with many edges
Directed Acyclic Graph (`DAG`)  | Directed graph with no cycle
Sparse Graph                    | A graph with limited edges
Tree                            | Connected graph such that `total number of edges` = `total number of vertices - 1`
Component                       | A group of vertices in an `undirected` graph that can visit one another via a path
In-Degree                       | Number of edges `entering` a vertex
Out-Degree                      | Number of edges `leaving` a vertex
Cycle                           | A path that start and ends at the same vertex with no repeated vertex in between the path
Path                            | A sequence of vertices connected by a sequence of edges
Path Length/Cost                | Number of edges in a path for an `unweighted` graph, and the sum of edge weight of a path for a `weighted` graph
V                               | Number of vertices in a graph
E                               | Number of edges in a graph

## How to use this folder
1. If you have not cloned this repository on your local machine, follow the [instructions](https://github.com/shumarb/learning#how-to-use-this-repository).
2. Ensure that your local machine configured with a `Java Development Kit (JDK) version 8 or later`.
3. Open `terminal`.
4. Navigate to the `graphs` folder by entering `cd graphs`.
5. Navigate to the `concept` you are interested in by entering the directory of the folder/subfolder (Example: `cd graph-data-structures`).
