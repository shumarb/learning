import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class EdgeList {
    
    private ArrayList <IntegerTriple> edgeList = new ArrayList <> ();
    private ArrayList <String> verticesList = new ArrayList <> ();
    private Random myRandom = new Random();

    // Displays line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Randomly generates boolean value
    // Precon: Formation of adjacency matrix ongoing
    // Postcon: Updates next vertex
    private boolean isFormData() {
        return myRandom.nextBoolean();
    }

    // Forms set of vertices for graph 
    // Precon: Formation of edge list ongoing
    // Postcon: Set of vertices for graph formed
    private String getsVertex(int vertexNumber) {
        String vertex = "";
        switch(vertexNumber) {
            case 0: vertex = "A"; break;
            case 1: vertex = "B"; break;
            case 2: vertex = "C"; break;
            case 3: vertex = "D"; break;
            case 4: vertex = "E"; break;
            case 5: vertex = "F"; break;
            case 6: vertex = "G"; break;
            default: vertex = "";
        }
        return vertex;
    }

    // Forms available vertices for current vertex to be connected to by an edge
    // Precon: Formation of EdgeList ongoing
    // Postcon: Forms next EdgeList object
    private ArrayList <String> formsPossibleNeighboursList(String currentVertex) {
        ArrayList <String> availableVerticesList = new ArrayList <> ();
        for (int i = 0; i < verticesList.size(); i++) {
            if (!getsVertex(i).equals(currentVertex)) {
                availableVerticesList.add(getsVertex(i));
            }
        }
        return availableVerticesList;
    }

    // Forms Edge List
    // Precon: Edge List not formed
    // Postcon: Edge List with >= 3 vertices formed
    private void formsEdgeList() {
        displaysLine();
        int numberOfVertices = myRandom.nextInt(3, 7);
        for (int i = 0; i < numberOfVertices; i++) {
            verticesList.add(getsVertex(i));
        }
        System.out.println("Forming an EdgeList with " + numberOfVertices + " vertices: " + verticesList);
        displaysNewLine();

        for (int i = 0; i < verticesList.size(); i++) {
            String startVertex = getsVertex(i);
            ArrayList <String> possibleNeighboursList = formsPossibleNeighboursList(startVertex);
            System.out.println(" * Vertex: " + startVertex + " | Available Vertices for Pairing: " + possibleNeighboursList);
            ArrayList <String> selectedNeighbours = new ArrayList <> ();
            for (int j = 0; j < possibleNeighboursList.size(); j++) {
                if (isFormData()) {
                    String endVertex;
                    do {
                        endVertex = possibleNeighboursList.get(myRandom.nextInt(0, possibleNeighboursList.size()));
                    } while (selectedNeighbours.contains(endVertex));
                    selectedNeighbours.add(endVertex);
                    if (isEligibleIntegerTriple(startVertex, endVertex)) {
                        IntegerTriple incomingIntegerTriple = new IntegerTriple(myRandom.nextInt(-100, 101), startVertex, endVertex);
                        System.out.println("  ** Inserting [" + incomingIntegerTriple.getsStartVertex() 
                                            + " --- " + incomingIntegerTriple.getsEndVertex() 
                                            + " | W: " + incomingIntegerTriple.getsWeight()
                                            + "]"
                        ); 
                        edgeList.add(incomingIntegerTriple);
                    }
                }
            }
            if (i != verticesList.size() - 1) {
                displaysNewLine();
            }
        }
        Collections.sort(edgeList);
        displaysLine();
    }

    // Checks EdgeList to ensure incoming IntegerTriple object can be added
    // Precon: Insertion of IntegerTriple object into EdgeList ongoing
    // Postcon: Instantiate an IntegerTriple object
    private boolean isEligibleIntegerTriple(String startVertex, String endVertex) {
        for (int i = 0; i < edgeList.size(); i++) {
            IntegerTriple currentIntegerTriple = edgeList.get(i);
            if ((currentIntegerTriple.getsStartVertex().equals(startVertex) 
                    && currentIntegerTriple.getsEndVertex().equals(endVertex))
                || (currentIntegerTriple.getsStartVertex().equals(endVertex) 
                    && currentIntegerTriple.getsEndVertex().equals(startVertex))) {
                        return false;
            }
        }
        return true;
    } 

    // Displays Edge List
    // Precon: Edge List with >= 3 vertices formed
    // Postcon: Nil
    private void displaysEdgeList() {
        System.out.println("EdgeList: ");
        displaysNewLine();
        for (int i = 0; i < edgeList.size() - 1; i++) {
            IntegerTriple currentIntegerTriple = edgeList.get(i);
            System.out.println(" * [" + currentIntegerTriple.getsStartVertex() + 
                               " ---- " + currentIntegerTriple.getsEndVertex() + 
                               " | W: " + currentIntegerTriple.getsWeight() + 
                               "]");
            displaysNewLine();
        }
        IntegerTriple lastIntegerTriple = edgeList.get(edgeList.size() - 1);
        System.out.println(" * [" + lastIntegerTriple.getsStartVertex() + 
                           " ---- " + lastIntegerTriple.getsEndVertex() + 
                           " | W: " + lastIntegerTriple.getsWeight() + "]");
        displaysLine();
    }

    private void run() {
        formsEdgeList();
        displaysEdgeList();
    }
    public static void main(String[] args) {
        EdgeList obj = new EdgeList();
        obj.run();
    }
}

class IntegerTriple implements Comparable <IntegerTriple> {
    private int weight;
    private String endVertex;
    private String startVertex;

    public IntegerTriple(int weight, String startVertex, String endVertex) {
        this.endVertex = endVertex;
        this.startVertex = startVertex;
        this.weight = weight;
    }

    public int compareTo(IntegerTriple newIntegerTriple) {
        if (this.getsWeight() < newIntegerTriple.getsWeight()) {
            return -1;
        } else if (this.getsWeight() > newIntegerTriple.getsWeight()) {
            return 1;
        } else {
            if (this.getsStartVertex().compareTo(newIntegerTriple.getsStartVertex()) < 0) {
                return -1;
            } else if (this.getsStartVertex().compareTo(newIntegerTriple.getsStartVertex()) > 0) {
                return 1;
            } else {
                if (this.getsEndVertex().compareTo(newIntegerTriple.getsEndVertex()) < 0) {
                    return -1;
                } else if (this.getsEndVertex().compareTo(newIntegerTriple.getsEndVertex()) > 0) {
                    return 1;
                }
                return 0;
            }  
        }
    }
    
    public int getsWeight() {
        return this.weight;
    }

    public String getsEndVertex() {
        return this.endVertex;
    }

    public String getsStartVertex() {
        return this.startVertex;
    }
}
