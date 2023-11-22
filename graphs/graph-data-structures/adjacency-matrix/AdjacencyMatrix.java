import java.util.Random;

class AdjacencyMatrix {

    private int[][] adjacencyMatrix;
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

    // Randomly generates boolean value to confirm an update on current element
    // Precon: Formation of adjacency matrix ongoing
    // Postcon: Updates next element
    private boolean isFormData() {
        return myRandom.nextBoolean();
    }
    
    // Forms Adjacency Matrix
    // Precon: Adjacency Matrix not formed
    // Postcon: Adjacency Matrix with >= 2 elements formed
    private void formsAdjacencyMatrix() {
        displaysLine();
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(3, 7);
        System.out.println("Forming an adjacency matrix with " + numberOfElements + " elements.");
        System.out.println("All elements are initially zero. The following updates certain elements to be non-zero: ");
        displaysNewLine();
        adjacencyMatrix = new int[numberOfElements][numberOfElements];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix[i].length; j++) {
                if (isFormData() && i != j) {
                    int edgeWeight = myRandom.nextInt(-100, 101);
                    System.out.println(" * Update: Indices [" + i + "][" + j + "] & [" + j + "]" + i + "] = " + edgeWeight);
                    adjacencyMatrix[i][j] = edgeWeight;
                    adjacencyMatrix[j][i] = edgeWeight;
                }
            }
        }
        displaysLine();
    }
    
    // Displays letter corresponding to a row and a column
    // Precon: Display of Adjacency Matrix ongoing
    // Postcon: End of program
    private void displaysLetter(int number) {
        String letter = "";
        switch(number) {
            case 0: letter = "A"; break;
            case 1: letter = "B"; break;
            case 2: letter = "C"; break;
            case 3: letter = "D"; break;
            case 4: letter = "E"; break;
            case 5: letter = "F"; break;
            case 6: letter = "G"; break;
            default: letter = "";
        }
        System.out.print(letter + "\t");
    }
    
    // Displays Adjacency Matrix
    // Precon: Adjacency Matrix formed
    // Postcon: End of program
    private void displaysMatrix(int[][] matrix, String message) {
        System.out.println(message);
        displaysNewLine();
        System.out.print("\t\t");
        for (int m = 0; m < matrix.length; m++) {
            System.out.print(" ");
            displaysLetter(m);
            System.out.print("\t");
        }
        displaysNewLine();
        System.out.print("\t\t");
        for (int m = 0; m < matrix.length; m++) {
            System.out.print("___\t\t");
        }
        displaysNewLine();
        for (int i = 0; i < matrix.length; i++) {
            displaysNewLine();
            displaysLetter(i);
            System.out.print(" | ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print("\t" + matrix[i][j] + "\t");
            }
            displaysNewLine();
        }
        displaysLine();
    }
    

    private void run() {
        formsAdjacencyMatrix();
        displaysMatrix(adjacencyMatrix, "Adjacency Matrix:");
    }
    public static void main(String[] args) {
        AdjacencyMatrix obj = new AdjacencyMatrix();
        obj.run();
    }
}

