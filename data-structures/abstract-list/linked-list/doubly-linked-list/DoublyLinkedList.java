import java.util.LinkedList;
import java.util.Random;

class DoublyLinkedList {

    private Random myRandom = new Random();
    private LinkedList <Integer> doublyLList = new LinkedList <> ();

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Forms Doubly Linked List
    // Precon: Doubly Linked List unitialised
    // Postcon: Doubly Linked List of size >= 1 formed
    private void formsDoublyLList() {
        System.out.println("============ Insertion ============");
        int totalElements = myRandom.nextInt(5, 12);
        System.out.println("Creating Doubly Linked List with " + totalElements + " elements:");
        displaysNewLine();
        for (int i = 0; i < totalElements; i++) {
            int toAdd = myRandom.nextInt(-10, 10);
            System.out.println(" * inserting " + toAdd);
            doublyLList.add(toAdd);
        }
        displaysNewLine();
        System.out.println("Doubly Linked List: " + doublyLList);
        displaysLine();
    }

    // Displays key Doubly Linked List operations
    // Precon: Doubly Linked List of size >= 1 formed
    // Postcon: Apply some of these key operations on the Doubly Linked List
    private void explainsDoublyLinkedList() {
        displaysLine();
        System.out.println("=========== What is a Doubly Linked List? ============");
        System.out.println("A Doubly Linked List is a linked list where each element pointers to both it's previous node and next nodes.");
        displaysNewLine();

        int i = 1;
        System.out.println("Key Doubly Linked List operations using the Java Linked List API: ");
        System.out.println(" " + i++ + ". add(Element e): Add the specified element to end of the Doubly Linked List");
        System.out.println(" " + i++ + ". add(int index, Element e): Add the specified element at the specified index of Doubly Linked List");
        System.out.println(" " + i++ + ". clear(): Remove all elements in the Doubly Linked List");
        System.out.println(" " + i++ + ". contains(Element e): Return true if the Doubly Linked List contains specified element, else return false");
        System.out.println(" " + i++ + ". get(int index): Retrieve the element at the specified index of the Doubly Linked List. Note: Ensure 0 <= index < size of the Doubly Linked List");
        System.out.println(" " + i++ + ". isEmpty(): Return true if the Doubly Linked List is empty, else return false");
        System.out.println(" " + i++ + ". peekFirst(): Retrieve, but not remove, the first element of the Doubly Linked List");
        System.out.println(" " + i++ + ". peekLast(): Retrieve, but not remove, the last element of the Doubly Linked List");
        System.out.println(" " + i++ + ". pollFirst(): Rremove the first element of the Doubly Linked List");
        System.out.println(" " + i++ + ". pollLast(): Remove the last element of the Doubly Linked List");
        System.out.println(" " + i++ + ". remove(int index): Remove the element at specified index of the Doubly Linked List");
        System.out.println(" " + i++ + ". set(int index, Element e): Replace the current element at the specified index of Doubly Linked List with the specified element");
        System.out.println(" " + i + ". size(): Obtain number of the elements in the Doubly Linked List");
        displaysLine();
    }

    // Executes some operations on operations on Doubly Linked List
    // Precon: Method displaying key operations of Doubly Linked List displayed
    // Postcon: End of program
    private void executesKeyDoublyLinkedListOperations() {
        int numberToFind = myRandom.nextInt(-10, 10);
        System.out.println("Apply some of operations on Doubly Linked List: " + doublyLList);
        displaysNewLine();
        System.out.println(" * peek(): Head of Doubly Linked List ----------> " + doublyLList.peek());
        System.out.println(" * isEmpty(): Is the Doubly Linked List empty? ----------> " + doublyLList.isEmpty());
        System.out.println(" * poll(): Remove the top element in Doubly Linked List ----------> " + doublyLList.poll() + " | After poll(), doublyLList: " + doublyLList);
        System.out.println(" * peek(): Top element in Doubly Linked List ----------> " + doublyLList.peek());
        System.out.println(" * contains(Element e): Does Doubly Linked List contain " +  numberToFind 
                            + "? --------------> " + doublyLList.contains(numberToFind)
        );
        System.out.println(" * size(): Number of elements in Doubly Linked List ----------> " + doublyLList.size());
        displaysLine();
    }

    private void run() {
        explainsDoublyLinkedList();
        formsDoublyLList();
        executesKeyDoublyLinkedListOperations();
    }

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.run();
    }
}
