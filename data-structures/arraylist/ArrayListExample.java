import java.util.ArrayList;
import java.util.Random;

class ArrayListExample {

    private ArrayList <Integer> arrayList = new ArrayList<>();
    private Random myRandom = new Random();
    
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

    // Forms ArrayList
    // Precon: ArrayList initialised and has 0 elements
    // Postcon: ArrayList has 5 - 12 elements
    private void insertElements() {
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 12);
        System.out.println("Creating an ArrayList with " + numberOfElements + " elements:");
        displaysNewLine();
        for (int i = 0; i < numberOfElements; i++) {
            int toAdd = myRandom.nextInt(-10, 10);
            System.out.println(" * Element #" + (i + 1) + ": " + toAdd);
            arrayList.add(i, toAdd);
        }
        displaysNewLine();
        displaysArrayList("Insertion of " + numberOfElements + " elements complete. ");
        displaysLine();
    }
    
    // Displays ArrayList
    // Precon: ArrayList has 5 - 12 elements
    // Postcon: Execute some operations on ArrayList
    private void displaysArrayList(String message) {
        System.out.println(message + "ArrayList: " + arrayList);
    }

    // Searches for element in ArrayList
    // Precon: ArrayList has 5 - 12 elements
    // Postcon: Search for maximum element
    private void searchesElement() {
        System.out.println("============ Search ============");
        displaysArrayList("");
        displaysNewLine();
        int key = myRandom.nextInt(-10, 10);
        if (arrayList.contains(key)) {
            System.out.println(key + " is in ArrayList");
        } else {
            System.out.println(key + " is not in ArrayList");
        }
        displaysLine();
    }

    // Searches for maximum element
    // Precon: ArrayList has 5 - 12 elements
    // Postcon: Search for minimum element
    private void searchesMaximum() {
        System.out.println("============ Search Maximum ============");
        displaysArrayList("");
        int maximumElement = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > maximumElement) {
                maximumElement = arrayList.get(i);
            }
        }
        displaysNewLine();
        System.out.println("Maximum: " + maximumElement);
        displaysLine();
    }

    // Searches for minimum element
    // Precon: ArrayList has 5 - 12 elements
    // Postcon: Deletes element from ArrayList
    private void searchesMinimum() {
        System.out.println("============ Search Minimum ============");
        displaysArrayList("");
        int minimumElement = arrayList.get(0);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) < minimumElement) {
                minimumElement = arrayList.get(i);
            }
        }
        displaysNewLine();
        System.out.println("Minimum: " + minimumElement);
        displaysLine();
    }

    // Displays key ArrayList operations
    // Precon: ArrayList of size >= 1 formed
    // Postcon: Apply some of these key operations on the ArrayList
    private void explainsArrayList() {
        displaysLine();
        System.out.println("=========== What is an ArrayList? ============");
        System.out.println("ArrayList is a resizable array");
        displaysNewLine();

        int i = 1;
        System.out.println("Key ArrayList operations: ");
        System.out.println(" " + i++ + ". add(Element e): Add the specified element to end of the ArrayList");
        System.out.println(" " + i++ + ". add(int index, Element e): Add the specified element at the specified index of ArrayList");
        System.out.println(" " + i++ + ". clear(): Remove all elements in the ArrayList");
        System.out.println(" " + i++ + ". contains(Element e): Return true if the ArrayList contains specified element, else return false");
        System.out.println(" " + i++ + ". get(int index): Retrieve the element at the specified index of the ArrayList. Note: Ensure 0 <= index < size of the ArrayList");
        System.out.println(" " + i++ + ". isEmpty(): Return true if the ArrayList is empty, else return false");
        System.out.println(" " + i++ + ". remove(int index): Remove the element at specified index of the ArrayList");
        System.out.println(" " + i++ + ". set(int index, Element e): Replace the current element at the specified index of ArrayList with the specified element");
        System.out.println(" " + i + ". size(): Obtain number of the elements in the ArrayList");
        displaysLine();
    }

    // Deletes element from ArrayList
    // Precon: ArrayList has 5 - 12 elements
    // Postcon: Nil
    private void deletesElement() {
        System.out.println("============ Deletion ============");
        displaysArrayList("Before deletion, ");
        displaysNewLine();

        int indexOfDeletion = myRandom.nextInt(0, arrayList.size() - 1);
        System.out.println(" * Deletion at index " + indexOfDeletion + ", which has element " + arrayList.get(indexOfDeletion));
        arrayList.remove(indexOfDeletion);
        displaysNewLine();

        displaysArrayList("After deletion, ");
        displaysLine();
    }

    private void run() {
        explainsArrayList();
        insertElements();
        searchesElement();
        searchesMaximum();
        searchesMinimum();
        deletesElement();
    }
    public static void main(String[] args) {
        ArrayListExample obj = new ArrayListExample();
        obj.run();
    }
}
