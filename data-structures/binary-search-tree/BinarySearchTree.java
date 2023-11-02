import java.util.Random;

public class BinarySearchTree {
    private static final String currentElementString = " ** current element: ";
    private Random myRandom = new Random();

    // Displays Message
    // Precon: Nil
    // Postcon: Nil
    private void displaysMessage(String sentence) {
        System.out.println(sentence);
    }

    // Forms BinarySearchTree
    // Precon: No BinarySearchTree formed
    // Postcon: BinarySearchTree of size >= 1 formed
    private int insertElements(Node rootNode) {
        displaysLine();
        displaysMessage("======= Insertion =======");
        System.out.println("* root: " + rootNode.getsData());
        int numberOfNodesToAdd = myRandom.nextInt(5, 12);
        for (int i = 0; i < numberOfNodesToAdd; i++) {
            Node incomingNode = new Node(myRandom.nextInt(-10, 10));
            System.out.println("* to add: " + incomingNode.getsData());
            insertElements(rootNode, incomingNode);
        }
        displaysLine();
        return numberOfNodesToAdd + 1;
    }

    // Inserts node into BinarySearchTree
    // Precon: BinarySearchTree has 5 - 12 elements
    // Postcon: Node inserted into BinarySearchTree
    private void insertElements(Node currentNode, Node incomingNode) {
        if (incomingNode.getsData() <= currentNode.getsData()) {
            if (currentNode.hasLeftChild()) {
                insertElements(currentNode.getsLeftChild(), incomingNode);
            } else {
                currentNode.setsLeftChild(incomingNode);
            }
        } else {
            if (currentNode.hasRightChild()) {
                insertElements(currentNode.getsRightChild(), incomingNode);
            } else {
                currentNode.setsRightChild(incomingNode);
            }
        }
    }

    // Forms root
    // Precon: BinarySearchTree has 0 nodes
    // Postcon: BinarySearchTree has 1 node
    private Node formsRoot() {
        return new Node(myRandom.nextInt(10));
    }

    // Displays new line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Display line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
    }
    
    // Displays number of elements in BinarySearchTree
    // Precon: BinarySearchTree is correctly filled
    // Postcon: Displays elements in BinarySearchTree
    private void displaysNumberOfNodes(int numberOfNodes) {
        displaysMessage("======= Traversal =======");
        System.out.println("Binary Search Tree of " + numberOfNodes + " nodes");
        displaysNewLine();
    }

    // Checks if an element contains a certain data
    // Precon: Data to check is in BinarySearchTree
    // Postcon: Data to check is in BinarySearchTree
    private boolean isContainKey(Node currentNode, int key) {
        System.out.print(currentElementString + currentNode.getsData());
        if (key == currentNode.getsData()) {
            System.out.println(" | Found!");
            return true;
        }

        if (key > currentNode.getsData() && currentNode.hasRightChild()) {
            System.out.println(" | going to rightChild: " + currentNode.getsRightChild().getsData());
            return isContainKey(currentNode.getsRightChild(), key);
        }

        if (key < currentNode.getsData() && currentNode.hasLeftChild()) {
            System.out.println(" | going to leftChild: " + currentNode.getsLeftChild().getsData());
            return isContainKey(currentNode.getsLeftChild(), key);
        }

        System.out.println(" | this element has no children | end of search");
        return false;
    }

    // Checks if an element contains a certain data
    // Precon: Data to check is in BinarySearchTree
    // Postcon: Data to check is in BinarySearchTree
    private void searchesKey(Node rootNode) {
        displaysNewLine();
        displaysLine();
        displaysMessage("======= Search =======");
        int key = myRandom.nextInt(1, 10);
        System.out.println("* Is " + key + " in the BinarySearchTree? Traverse from the root...");
        displaysNewLine();
        if (isContainKey(rootNode, key)) {
            displaysNewLine();
            System.out.println("* " + key + " is in BinarySearchTree");
        } else {
            displaysNewLine();
            System.out.println("* " + key + " is not in BinarySearchTree");
        }
        displaysLine();
    }

    // Displays Binary Search Tree using in-order traversal
    // Precon: BinarySearchTree formed is correct
    // Postcon: End of program
    private void displaysBinarySearchTree(Node currentNode, int traversalOrder) {
        // In-order traversal
        if (traversalOrder == 0) {
            if (currentNode.hasLeftChild()) {
                displaysBinarySearchTree(currentNode.getsLeftChild(), traversalOrder);
            }
            System.out.print(currentNode.getsData() + "  ");
            if (currentNode.hasRightChild()) {
                displaysBinarySearchTree(currentNode.getsRightChild(), traversalOrder);
            }
        }

        // Pre-order traversal
        if (traversalOrder == 1) {
            System.out.print(currentNode.getsData() + "  ");
            if (currentNode.hasLeftChild()) {
                displaysBinarySearchTree(currentNode.getsLeftChild(), traversalOrder);
            }
            if (currentNode.hasRightChild()) {
                displaysBinarySearchTree(currentNode.getsRightChild(), traversalOrder);
            }
        }

        // Post-order traversal
        if (traversalOrder == 2) {
            if (currentNode.hasLeftChild()) {
                displaysBinarySearchTree(currentNode.getsLeftChild(), traversalOrder);
            }
            if (currentNode.hasRightChild()) {
                displaysBinarySearchTree(currentNode.getsRightChild(), traversalOrder);
            }
            System.out.print(currentNode.getsData() + "  ");
        }
    }

    // Displays BinarySearchTree based on traversal type
    // Precon: There is >= 1 element in BinarySearchTree
    // Postcon: Checks for data
    private void displaysBinarySearchTree(Node rootNode) {
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print(" * In-order traversal:\t\t");
            } else if (i == 1) {
                displaysNewLine();
                System.out.print(" * Pre-order traversal:\t\t");
            } else {
                displaysNewLine();
                System.out.print(" * Post-order traversal:\t");
            }
            displaysBinarySearchTree(rootNode, i);
        }
    }

    // Searches for minimium element in the Binary Search Tree
    // Precon: BinarySearchTree has 5 - 12 elements
    // Postcon: Searches for maximum element
    private void searchesMinimum(Node currentNode) {
        if (currentNode != null) {
            System.out.print(currentElementString + currentNode.getsData());
            if (currentNode.hasLeftChild()) {
                System.out.println(" | going to leftChild: " + currentNode.getsLeftChild().getsData());
                searchesMinimum(currentNode.getsLeftChild());
            } else {
                // Currently at left-most element. This is the minumum element
                System.out.println(" | this element has no leftChild | end of search");
                displaysNewLine();
                System.out.println("* Minimum Element: " + currentNode.getsData());
                displaysLine();
            }
        }
    }

    // Searches for maximum element in the Binary Search Tree
    // Precon: BinarySearchTree has 5 - 12 elements
    // Postcon: Searches for maximum element
    private void searchesMaximum(Node currentNode) {
        if (currentNode != null) {
            System.out.print(currentElementString + currentNode.getsData());
            if (currentNode.hasRightChild()) {
                System.out.println(" | going to rightChild: " + currentNode.getsRightChild().getsData());
                searchesMaximum(currentNode.getsRightChild());
            } else {
                // Currently at right-most element. This is the maximum element
                System.out.println(" | this element has no righChild | end of search");
                displaysNewLine();
                System.out.println("* Maximum Element: " + currentNode.getsData());
                displaysLine();
            }
        }
    }

    private void run() {
        Node rootNode = formsRoot();
        int numberOfNodes = insertElements(rootNode);
        displaysNumberOfNodes(numberOfNodes);
        displaysBinarySearchTree(rootNode);
        searchesKey(rootNode);
        displaysMessage("======= Search Minimum Element =======");
        searchesMinimum(rootNode);
        displaysMessage("======= Search Maximum Element =======");
        searchesMaximum(rootNode);
    }
    public static void main(String[] args) {
        BinarySearchTree obj = new BinarySearchTree();
        obj.run();
    }
}

class Node {
    private int data;
    private Node leftChild;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public int getsData() {
        return this.data;
    }

    public Node getsLeftChild() {
        return this.leftChild;
    }

    public Node getsRightChild() {
        return this.rightChild;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public void setsLeftChild(Node incomingNode) {
        this.leftChild = incomingNode;
    }

    public void setsRightChild(Node incomingNode) {
        this.rightChild = incomingNode;
    }
}
