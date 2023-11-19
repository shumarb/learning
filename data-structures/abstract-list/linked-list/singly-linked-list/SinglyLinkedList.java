import java.util.HashSet;
import java.util.Random;

class SinglyLinkedList {
    // HashSet used only to generate unique numbers
    private HashSet <Integer> set = new HashSet <> ();
    private Node head;
    private Random myRandom = new Random();
    
    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Forms data in relation to elements in the Array
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataInSinglyLinkedList) {
        int data;
        if (isDataInSinglyLinkedList) {
            // Generates data based on element in the Singly Linked List
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            // Generates data based on element not in the Singly Linked List
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    } 

    // Finds last node in Singly Linked List
    // Precon: Formation of Singly Linked List ongoing
    // Postcon: Insert new node into Singly Linked List
    private Node findsLastNode(Node currentNode) {
        if (currentNode.isLastNode()) {
            return currentNode;
        }

        return findsLastNode(currentNode.getsNextNode());
    }

    // Forms Singly Linked List
    // Precon: Singly Linked List not formed
    // Postcon: Singly Linked List containing 5 to 12 elements formed
    private void insertion() {
        displaysLine();
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 12);
        System.out.println("Forming a Singly Linked List with " + numberOfElements + " elements:");
        displaysNewLine();
        for (int i = 0; i < numberOfElements; i++) {
            int data = formsData(false);
            set.add(data);
            Node incomingNode = new Node(data);
            System.out.println(" * Inserting " + incomingNode.getsData());
            if (head == null) {
                head = new Node(-1);
                head.setsNextNode(incomingNode);
            } else {
                Node lastNode = findsLastNode(head.getsNextNode());
                lastNode.setsNextNode(incomingNode);
            }
        }
        displaysNewLine();
        displaysSinglyLinkedList(true);
    }

    // Displays Singly Linked List
    // Precon: Singly Linked List with 5 - 12 elements formed
    // Postcon: Search for element in Singly Linked List
    private void displaysSinglyLinkedList(boolean isDisplayLine) {
        Node currentNode = head.getsNextNode();
        System.out.print("Singly Linked List: HEAD ---> ");
        while (currentNode != null) {
            System.out.print(currentNode.getsData());
            if (currentNode.isLastNode()) {
                break;
            }
            System.out.print(" ---> ");
            currentNode = currentNode.getsNextNode();
        }
        displaysNewLine();
        if (isDisplayLine) {
            displaysLine();
        }
    }

    // Searches for element in Singly Linked List
    // Precon: Singly Linked List of with 5 - 12 elements formed
    // Postcon: Searches for minimum element
    private void search() {
        System.out.println("============ Search ============");
        displaysSinglyLinkedList(false);
        displaysNewLine();
        int key = formsData(false);
        Node currentNode;
        for (int i = 0; i < 2; i++) {
            boolean isFound = false;
            currentNode = head.getsNextNode();
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                if (currentNode.getsData() == key) {
                    isFound = true;
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }

            if (isFound) {
                System.out.println(" * " + key + " is in Singly Linked List");
            } else {
                System.out.println(" * " + key + " is not in Singly Linked List");
            }
            displaysNewLine();
        }

        currentNode = head.getsNextNode();
        int maximum = currentNode.getsData();
        int minimum = currentNode.getsData();
        while (currentNode != null) {
            if (currentNode.getsData() > maximum) {
                maximum = currentNode.getsData();
            }
            if (currentNode.getsData() < minimum) {
                minimum = currentNode.getsData();
            }
            currentNode = currentNode.getsNextNode();
        }
        System.out.println(" * Maximum: " + maximum);
        displaysNewLine();
        System.out.println(" * Minimum: " + minimum);
        displaysLine();
    }

    // Deletes element from Singly Linked List
    // Precon: Singly Linked List has 5 - 12 elements
    // Postcon: End of Program
    private void deletion() {
        System.out.println("============ Deletion ============");
        int numberOfElements = 0;
        Node currentNode = head.getsNextNode();
        while (currentNode != null) {
            numberOfElements++;
            currentNode = currentNode.getsNextNode();
        }

        int indexOfDeletion = myRandom.nextInt(1, numberOfElements);
        System.out.print("Before deletion, ");
        displaysSinglyLinkedList(false);
        displaysNewLine();
        System.out.println("* Delete element #" + indexOfDeletion);
        displaysNewLine();
        // 1. Delete first element
        if (indexOfDeletion == 1) {
            Node newFirstNode = head.getsNextNode().getsNextNode();
            Node toRemoveNode = head.getsNextNode();
            toRemoveNode.setsNextNode(null);
            head.setsNextNode(newFirstNode);
        } else if (indexOfDeletion == numberOfElements) {
            // 2. Delete last element
            int currentIndex = 0;
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                currentIndex++;
                if (currentIndex == (indexOfDeletion - 1)) {
                    currentNode.setsNextNode(null);
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }
        } else {
            // 3. Delete element between first and last elements
            int currentIndex = 0;
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                currentIndex++;
                if (currentIndex == (indexOfDeletion - 1)) {
                    Node toRemoveNode = currentNode.getsNextNode();
                    Node newNextNode = toRemoveNode.getsNextNode();
                    currentNode.setsNextNode(newNextNode);
                    toRemoveNode.setsNextNode(null);
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }
        }
        System.out.print("After deletion, ");
        displaysSinglyLinkedList(true);
    }

    private void run() {
        insertion();
        search();
        deletion();
    }
    public static void main(String[] args) {
        SinglyLinkedList obj = new SinglyLinkedList();
        obj.run();
    }
}

class Node {
    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
    }

    public boolean hasNextNode() {
        return this.nextNode != null;
    }

    public boolean isLastNode() {
        return this.nextNode == null;
    }

    public int getsData() {
        return this.data;
    }

    public Node getsNextNode() {
        return this.nextNode;
    }

    public void setsNextNode(Node incomingNode) {
        this.nextNode = incomingNode;
    }
}
