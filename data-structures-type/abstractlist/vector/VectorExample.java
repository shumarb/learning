import java.util.Random;
import java.util.Vector;

class VectorExample {

    private Random myRandom = new Random();
    private Vector <Integer> vector = new Vector <> ();
    
    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Forms Vector
    // Precon: Vector initialised and has 0 elements
    // Postcon: Vector has 5 - 12 elements
    private void insertElements() {
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 12);
        System.out.println("Creating an Vector with " + numberOfElements + " elements:");
        displaysNewLine();
        for (int i = 0; i < numberOfElements; i++) {
            int toAdd = myRandom.nextInt(-10, 10);
            System.out.println(" * Element #" + (i + 1) + ": " + toAdd);
            vector.add(i, toAdd);
        }
        displaysNewLine();
        displaysVector("Insertion of " + numberOfElements + " elements complete. ");
        displaysLine();
    }
    
    // Displays Vector
    // Precon: Vector has 5 - 12 elements
    // Postcon: Execute some operations on Vector
    private void displaysVector(String message) {
        System.out.println(message + "Vector: " + vector);
    }

    // Searches for element in Vector
    // Precon: Vector has 5 - 12 elements
    // Postcon: Search for maximum element
    private void searchesElement() {
        System.out.println("============ Search ============");
        displaysVector("");
        displaysNewLine();
        int key = myRandom.nextInt(-10, 10);
        if (vector.contains(key)) {
            System.out.println(key + " is in Vector");
        } else {
            System.out.println(key + " is not in Vector");
        }
        displaysLine();
    }

    // Searches for maximum element
    // Precon: Vector has 5 - 12 elements
    // Postcon: Search for minimum element
    private void searchesMaximum() {
        System.out.println("============ Search Maximum ============");
        displaysVector("");
        int maximumElement = vector.get(0);
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) > maximumElement) {
                maximumElement = vector.get(i);
            }
        }
        displaysNewLine();
        System.out.println("Maximum: " + maximumElement);
        displaysLine();
    }

    // Searches for minimum element
    // Precon: Vector has 5 - 12 elements
    // Postcon: Deletes element from Vector
    private void searchesMinimum() {
        System.out.println("============ Search Minimum ============");
        displaysVector("");
        int minimumElement = vector.get(0);
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) < minimumElement) {
                minimumElement = vector.get(i);
            }
        }
        displaysNewLine();
        System.out.println("Minimum: " + minimumElement);
        displaysLine();
    }

    // Displays key Vector operations
    // Precon: Vector of size >= 1 formed
    // Postcon: Apply some of these key operations on the Vector
    private void explainsVector() {
        displaysLine();
        System.out.println("=========== What is an Vector? ============");
        System.out.println("Vector is a resizable array");
        displaysNewLine();
        int i = 1;
        System.out.println("Key Vector operations: ");
        System.out.println(" " + i++ + ". add(Element e): Add element to end of the Vector");
        System.out.println(" " + i++ + ". add(int index, Element e): Add an element at specified index of the Vector");
        System.out.println(" " + i++ + ". clear(): Remove all elements in Vector");
        System.out.println(" " + i++ + ". contains(Element e): Return true if the Vector contains specified element, else return false");
        System.out.println(" " + i++ + ". get(int index): Retrieve  element at position index. Note: Ensure 0 <= index < size of the Vector");
        System.out.println(" " + i++ + ". isEmpty(): Return true if the Vector is empty, else return false");
        System.out.println(" " + i++ + ". remove(int index): Remove element at the specified index of the Vector");
        System.out.println(" " + i++ + ". set(int index, Element e): Replace current element at specified index of the Vector with specified element");
        System.out.println(" " + i + ". size(): Obtains number of elements in the Vector");
        displaysLine();
    }

    // Deletes element from Vector
    // Precon: Vector has 5 - 12 elements
    // Postcon: Nil
    private void deletesElement() {
        System.out.println("============ Deletion ============");
        displaysVector("Before deletion, ");
        displaysNewLine();

        int indexOfDeletion = myRandom.nextInt(0, vector.size() - 1);
        System.out.println(" * Deletion at index " + indexOfDeletion + ", which has element " + vector.get(indexOfDeletion));
        vector.remove(indexOfDeletion);
        displaysNewLine();

        displaysVector("After deletion, ");
        displaysLine();
    }

    private void run() {
        explainsVector();
        insertElements();
        searchesElement();
        searchesMaximum();
        searchesMinimum();
        deletesElement();
    }
    public static void main(String[] args) {
        VectorExample obj = new VectorExample();
        obj.run();
    }
}
