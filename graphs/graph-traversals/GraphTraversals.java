import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

class GraphTraversals {
    
    private List <ArrayList <IntegerPair>> adjacencyList = new ArrayList <ArrayList <IntegerPair>> ();
    private List <String> verticesList = new ArrayList <> ();
    private Random myRandom = new Random();
    private int sourceVertexNumber;

    private void displaysAdjacencyList() {
        System.out.println("Adjacency List: ");
        for (int i = 0; i < adjacencyList.size(); i++) {
            displaysNewLine();
            System.out.print(" * Vertex " + getsVertex(i) + " | ");
            ArrayList <IntegerPair> neighboursList = adjacencyList.get(i);
            for (int j = 0; j < neighboursList.size(); j++) {
                IntegerPair currentIntegerPair = neighboursList.get(j);
                System.out.print("[" + currentIntegerPair.getsEndVertex() + ", W: " + currentIntegerPair.getsWeight() + "]");
                if (j != neighboursList.size() - 1) {
                    System.out.print(", ");
                }
                if (j == neighboursList.size() - 1) {
                    displaysNewLine();
                }
            }
        }
        displaysLine();
    }

    private void displaysLine() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysNewLine() {
        System.out.println();
    }

    private ArrayList <String> formsPossibleNeighboursList(String currentVertex) {
        ArrayList <String> availableVerticesList = new ArrayList <> ();
        for (int i = 0; i < verticesList.size(); i++) {
            if (!getsVertex(i).equals(currentVertex)) {
                availableVerticesList.add(getsVertex(i));
            }
        }
        return availableVerticesList;
    }

    private IntegerPair getsIntegerPair(ArrayList <IntegerPair> adjList, String neighbour) {
        for (int i = 0; i < adjList.size(); i++) {
            IntegerPair currentIntegerPair = adjList.get(i);
            if (currentIntegerPair.getsEndVertex().equals(neighbour)) {
                return currentIntegerPair;
            }
        }
        return null;
    }

    private String getsVertex(int vertexNumber) {
        String vertex = "";
        switch(vertexNumber) {
            case 0: 
                vertex = "A"; 
                break;
            case 1: 
                vertex = "B"; 
                break;
            case 2: 
                vertex = "C";
                break;
            case 3: 
                vertex = "D"; 
                break;
            case 4: 
                vertex = "E"; 
                break;
            case 5: 
                vertex = "F"; 
                break;
            case 6: 
                vertex = "G"; 
                break;
        }
        return vertex;
    }

    private int getsVertex(String vertexName) {
        int vertexNumber = 0;
        switch(vertexName) {
            case "A": 
                vertexNumber = 0;
                break;
            case "B": 
                vertexNumber = 1; 
                break;
            case "C": 
                vertexNumber = 2; 
                break;
            case "D": 
                vertexNumber = 3; 
                break;
            case "E": 
                vertexNumber = 4; 
                break;
            case "F": 
                vertexNumber = 5; 
                break;
            case "G": 
                vertexNumber = 6; 
                break;
        }
        return vertexNumber;
    }

    private void insertion() {
        displaysLine();
        System.out.println("======= Insertion =======");
        int numberOfVertices = myRandom.nextInt(3, 7);
        for (int i = 0; i < numberOfVertices; i++) {
            verticesList.add(getsVertex(i));
        }
        System.out.println("Forming an Adjacency List with " + numberOfVertices + " vertices: " + verticesList);
        displaysNewLine();
        for (int i = 0; i < verticesList.size(); i++) {
            String currentVertex = getsVertex(i);
            ArrayList <String> possibleNeighboursList = formsPossibleNeighboursList(currentVertex);
            ArrayList <IntegerPair> neighboursList = new ArrayList <> ();
            System.out.println(" * Vertex " + currentVertex + " | Possible neighbours: " + possibleNeighboursList);
            for (int j = 0; j < possibleNeighboursList.size(); j++) {
                int weight = myRandom.nextInt(-100, 101);
                IntegerPair incomingIntegerPair = new IntegerPair(possibleNeighboursList.get(j), weight);
                neighboursList.add(incomingIntegerPair);
                Collections.sort(possibleNeighboursList);
            }
            adjacencyList.add(i, neighboursList);
            if (i != verticesList.size() - 1) {
                displaysNewLine();
            }
        }
        updatesAdjacencyList();
        displaysLine();
    }

    private boolean isContainNeighbour(ArrayList <IntegerPair> neighbourAdjList, String neighbour) {
        for (int i = 0; i < neighbourAdjList.size(); i++) {
            IntegerPair currPair = neighbourAdjList.get(i);
            if (currPair.getsEndVertex().equals(neighbour)) {
                return true;
            }
        }
        return false;
    }

    private void updatesAdjacencyList() {
        // 1. If 2 vertices are connected to one another by an edge,
        // ensure each vertex is in the other vertex's adjacency list
        for (int i = 0; i < adjacencyList.size(); i++) {
            String currentVertex = getsVertex(i);
            ArrayList <IntegerPair> currentVertexAdjList = adjacencyList.get(i);
            for (int j = 0; j < currentVertexAdjList.size(); j++) {
                IntegerPair currPair = currentVertexAdjList.get(j);
                String neighbourVertex = currPair.getsEndVertex();
                int weight = currPair.getsWeight();
                if (!isContainNeighbour(adjacencyList.get(getsVertex(neighbourVertex)), currentVertex)) {
                    adjacencyList.get(getsVertex(neighbourVertex)).add(new IntegerPair(currentVertex, weight));
                }
            }
        }

        // 2. If 2 vertices are connected to one another by an edge,
        // ensure the weight of the edge connecting the vertices to each other is the same
        for (int i = 0; i < adjacencyList.size(); i++) {
            String currentVertex = getsVertex(i);
            ArrayList <IntegerPair> currentVertexAdjList = adjacencyList.get(i);
            for (int j = 0; j < currentVertexAdjList.size(); j++) {
                IntegerPair currPair = currentVertexAdjList.get(j);
                IntegerPair toCheckPair = getsIntegerPair(adjacencyList.get(getsVertex(currPair.getsEndVertex())), currentVertex);
                if (toCheckPair.getsWeight() != currPair.getsWeight()) {
                    toCheckPair.setsWeight(currPair.getsWeight());
                }
            }
        }

        for (int i = 0; i < adjacencyList.size(); i++) {
            Collections.sort(adjacencyList.get(i));
        }
    }

    private void depthFirstSearch() {
        boolean[] isVisited = new boolean[adjacencyList.size()];
        Stack <String> adjacentVerticesStack = new Stack <> ();

        // Add start vertex to stack and mark it as visited
        adjacentVerticesStack.push(getsVertex(sourceVertexNumber));
        isVisited[sourceVertexNumber] = true;
        
        System.out.print(" * Depth-first Search: ");
        
        // Pop out elements from stack for DFS
        while (!isAllVisited(isVisited)) {
            int currentVertex = getsVertex(adjacentVerticesStack.peek());
            System.out.print(getsVertex(currentVertex) + " ");
            isVisited[currentVertex] = true;
            adjacentVerticesStack.pop();
            ArrayList <IntegerPair> currentVertexAdjacencyList = adjacencyList.get(currentVertex);
            for (int i = 0; i < currentVertexAdjacencyList.size(); i++) {
                String adjacentVertex = currentVertexAdjacencyList.get(i).getsEndVertex();
                int adjacentVertexNumber = getsVertex(adjacentVertex);
                if (!isVisited[adjacentVertexNumber]) {
                    adjacentVerticesStack.push(adjacentVertex);
                }
            }
        }
        displaysNewLine();
    }

    private boolean isAllVisited(boolean[] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i]) {
                return false;
            }
        }
        return true;
    }

    private void breadthFirstSearch() {
        boolean[] isVisited = new boolean[adjacencyList.size()];
        Queue <String> adjacentVerticesQueue= new LinkedList <> ();

        // Add first vertex to stack and mark it as visited
        adjacentVerticesQueue.offer(getsVertex(sourceVertexNumber));
        isVisited[sourceVertexNumber] = true;
        
        System.out.print(" * Breadth-first Search: ");
        
        // Pop out elements from stack for DFS
        while (!isAllVisited(isVisited)) {
            int currentVertex = getsVertex(adjacentVerticesQueue.peek());
            System.out.print(getsVertex(currentVertex) + " ");
            isVisited[currentVertex] = true;
            adjacentVerticesQueue.poll();
            ArrayList <IntegerPair> currentVertexAdjacencyList = adjacencyList.get(currentVertex);
            for (int i = 0; i < currentVertexAdjacencyList.size(); i++) {
                String adjacentVertex = currentVertexAdjacencyList.get(i).getsEndVertex();
                int adjacentVertexNumber = getsVertex(adjacentVertex);
                if (!isVisited[adjacentVertexNumber]) {
                    adjacentVerticesQueue.offer(adjacentVertex);
                }
            }
        }
        displaysNewLine();
        displaysLine();
    }
    
    private void graphTraversals() {
        System.out.println("======= Graph Traversals =======");
        sourceVertexNumber = myRandom.nextInt(0, adjacencyList.size());
        System.out.println("Source Vertex: " + getsVertex(sourceVertexNumber));
        displaysNewLine();
        depthFirstSearch();
        displaysNewLine();
        breadthFirstSearch();
    }

    private void run() {
        insertion();
        displaysAdjacencyList();
        graphTraversals();
    }

    public static void main(String[] args) {
        GraphTraversals obj = new GraphTraversals();
        obj.run();
    }
}

class IntegerPair implements Comparable <IntegerPair> {
    private int weight;
    private String endVertex;

    public IntegerPair(String endVertex, int weight) {
        this.weight = weight;
        this.endVertex = endVertex;
    }

    public int compareTo(IntegerPair incomingIntegerPair) {
        if (this.getsEndVertex().compareTo(incomingIntegerPair.getsEndVertex()) < 0) {
            return -1;
        } else if (this.getsEndVertex().compareTo(incomingIntegerPair.getsEndVertex()) > 0) {
            return 1;
        } else {
            if (this.getsWeight() - incomingIntegerPair.getsWeight() < 0) {
                return -1;
            } else if (this.getsWeight() - incomingIntegerPair.getsWeight() > 0) {
                return 1;
            }
            return 0;
        }
    }

    public int getsWeight() {
        return this.weight;
    }

    public String getsEndVertex() {
        return this.endVertex;
    }

    public void setsWeight(int weight) {
        this.weight = weight;
    }
}
