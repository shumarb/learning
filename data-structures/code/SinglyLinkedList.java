import java.util.HashSet;
import java.util.Random;

class SinglyLinkedList {
    // HashSet used only to generate unique numbers
    private HashSet <Integer> set = new HashSet <> ();
    private Node head;
    private Random myRandom = new Random();
    
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysMessage(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        if (messageType == 0) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private void displaysNewLine() {
        System.out.println();
    }

    private int formsData(boolean isDataInSinglyLinkedList) {
        int data;
        if (isDataInSinglyLinkedList) {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    } 

    private Node findsLastNode(Node currentNode) {
        if (currentNode.isLastNode()) {
            return currentNode;
        }

        return findsLastNode(currentNode.getsNextNode());
    }

    private Node getsElement(int index) {
        int count = 1;
        Node currentNode = head.getsNextNode();
        while (currentNode != null) {
            if (count++ == index) {
                break;
            }
            currentNode = currentNode.getsNextNode();
        }
        return currentNode;
    }

    private void deletion() {
        displaysMessage(0, "============ Deletion ============", false, false);
        int numberOfElements = 0;
        Node currentNode = head.getsNextNode();
        while (currentNode != null) {
            numberOfElements++;
            currentNode = currentNode.getsNextNode();
        }

        int indexOfDeletion = myRandom.nextInt(1, numberOfElements);
        displaysMessage(0, "Delete element #" + indexOfDeletion + ": " + getsElement(indexOfDeletion).getsData(), true, false);
        traversal(" * Before:\t", true, false);
        
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
        traversal(" * After:\t", false, true);
    }

    private void insertion() {
        displaysLine();
        displaysMessage(0, "============ Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        displaysMessage(0, "Forming a Singly Linked List with " + numberOfElements + " elements:", true, false);
        for (int i = 0; i < numberOfElements; i++) {
            int data = formsData(false);
            set.add(data);
            Node incomingNode = new Node(data);
            displaysMessage(0, " * Insert: " + incomingNode.getsData(), true, false);
            if (head == null) {
                head = new Node(-1);
                head.setsNextNode(incomingNode);
            } else {
                Node lastNode = findsLastNode(head.getsNextNode());
                lastNode.setsNextNode(incomingNode);
            }
        }
        traversal("Singly Linked List:\t", false, true);
    }

    private void search() {
        displaysMessage(0, "============ Search ============", false, false);
        traversal("Singly Linked List:\t", true, false);
        int key = formsData(false);
        Node currentNode;
        for (int i = 0; i < 2; i++) {
            boolean isKeyFound = false;
            currentNode = head.getsNextNode();
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            currentNode = head.getsNextNode();
            while (currentNode != null) {
                if (currentNode.getsData() == key) {
                    isKeyFound = true;
                    break;
                }
                currentNode = currentNode.getsNextNode();
            }

            if (isKeyFound) {
                displaysMessage(0, " * " + key + " is in Singly Linked List", true, false);
            } else {
                displaysMessage(0, " * " + key + " is not in Singly Linked List", true, false);
            }
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
        displaysMessage(0, " * Maximum: " + maximum, true, false);
        displaysMessage(0, " * Minimum: " + minimum, false, true);
    }

    private void traversal(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        Node currentNode = head.getsNextNode();
        displaysMessage(1, message + "HEAD ---> ", false, false);
        while (currentNode != null) {
            displaysMessage(1, Integer.toString(currentNode.getsData()), false, false);
            if (currentNode.isLastNode()) {
                break;
            }
            displaysMessage(1, " ---> ", false, false);
            currentNode = currentNode.getsNextNode();
        }
        displaysNewLine();
        if (isDisplayNewLine) {
            displaysNewLine(); 
        }
        if (isDisplayLine) {
            displaysLine();
        }
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
