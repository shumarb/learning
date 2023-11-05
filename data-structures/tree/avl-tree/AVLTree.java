import java.util.Random;

class AVLTree {

    private static final Random myRandom = new Random();
    private Node root;

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Forms AVL Tree
    // Precon: No AVL Tree formed
    // Postcon: AVL Tree with 5 - 12 elements formed
    private void formsAVLTree() {
        int numberOfElements = myRandom.nextInt(4, 7);
        displaysLine();
        System.out.println("Forming an AVL Tree with " + numberOfElements + " elements:");
        displaysNewLine();
        for (int i = 0; i < numberOfElements; i++) {
            Node incomingNode = new Node(myRandom.nextInt(-10, 10));
            if (i == 0) {
                root = incomingNode;
                System.out.println(" * root: " + root.getsData());
            } else {
                System.out.print(" * inserting: " + incomingNode.getsData());
                String insertionOrder = insertElement(root, incomingNode, "");

                // TODO: Rebalance based on insertion order
                
                System.out.print(" | parent: " + incomingNode.getsParent().getsData());
                System.out.println(" | insertionOrder: " + insertionOrder);
            }
            displaysNewLine();
        }
        displaysLine();
    }

    // Retrieves height of subtree of current element
    // Precon: Update of Balance Factor of current element ongoing
    // Postcon: Retrieves height of parent of current element
    private int retrievesHeightOfSubtree(Node currentNode) {
        if (currentNode == null) {
            return 0;
        }

        if (currentNode.hasLeftChild() && !currentNode.hasRightChild()) {
            return 1 + retrievesHeightOfSubtree(currentNode.getsLeftChild());
        }

        if (currentNode.hasRightChild() && !currentNode.hasLeftChild()) {
            return 1 + retrievesHeightOfSubtree(currentNode.getsRightChild());
        }

        if (currentNode.hasLeftChild() && currentNode.hasRightChild()) {
            return 2 + retrievesHeightOfSubtree(currentNode.getsLeftChild()) + retrievesHeightOfSubtree(currentNode.getsRightChild());
        }

        return 0;
    }

    // Updates balance factor of current element
    // Precon: Element inserted into AVL Tree
    // Postcon: Insert next element into AVL Tree
    private void updatesBalanceFactor(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        int leftSubtreeHeight = Math.max(0, retrievesHeightOfSubtree(currentNode));
        int rightSubtreeHeight = Math.max(0, retrievesHeightOfSubtree(currentNode));
        currentNode.setsBalanceFactor(leftSubtreeHeight, rightSubtreeHeight);
        updatesBalanceFactor(currentNode.getsLeftChild());
        updatesBalanceFactor(currentNode.getsRightChild());
    }

    // Insert element into AVL Tree
    // Precon: AVL Tree creation in progress
    // Postcon: Insert next element into AVL Tree
    private String insertElement(Node currentNode, Node incomingNode, String insertionOrder) {
        if (incomingNode.getsData() > currentNode.getsData()) {
            insertionOrder = insertionOrder.concat("R");
            currentNode.increasesNumRightSubtreeElements();
            if (currentNode.hasRightChild()) {
                return insertElement(currentNode.getsRightChild(), incomingNode, insertionOrder);
            } else {
                currentNode.setsRightChild(incomingNode);
                incomingNode.setsParent(currentNode);
                incomingNode.setsLevel();

                // TODO: Update balance factor of incomingNode & it's direct ancestors to root
                updatesBalanceFactor(root);
            }
        } else {
            insertionOrder = insertionOrder.concat("L");
            currentNode.increasesNumLeftSubtreeElements();
            if (currentNode.hasLeftChild()) {
                return insertElement(currentNode.getsLeftChild(), incomingNode, insertionOrder);
            } else {
                currentNode.setsLeftChild(incomingNode);
                incomingNode.setsParent(currentNode);
                incomingNode.setsLevel();

                // TODO: Update balance factor of incomingNode & it's direct ancestors to root
                updatesBalanceFactor(root);
            }
        }
        return insertionOrder;
    }

    // Display information of element
    // Precon: Display of AVL Tree ongoing
    // Postcon: Nil
    private void displaysElementInformation(Node currentNode) {
        System.out.print("[" + currentNode.getsData() 
                        + ", Level: " + currentNode.getsLevel() 
                        + ", BF: " + currentNode.getsBalanceFactor() 
                        + "]  "
        );
    }

    // Displays AVL Tree using in-order traversal
    // Precon: AVL Tree formed is correct
    // Postcon: Searches for element in the AVL Tree
    private void displaysAVLTree(Node currentNode, int traversalOrder) {
        // In-order traversal
        if (traversalOrder == 0) {
            if (currentNode.hasLeftChild()) {
                displaysAVLTree(currentNode.getsLeftChild(), traversalOrder);
            }
            displaysElementInformation(currentNode);
            if (currentNode.hasRightChild()) {
                displaysAVLTree(currentNode.getsRightChild(), traversalOrder);
            }
        }

        // Pre-order traversal
        if (traversalOrder == 1) {
            displaysElementInformation(currentNode);
            if (currentNode.hasLeftChild()) {
                displaysAVLTree(currentNode.getsLeftChild(), traversalOrder);
            }
            if (currentNode.hasRightChild()) {
                displaysAVLTree(currentNode.getsRightChild(), traversalOrder);
            }
        }

        // Post-order traversal
        if (traversalOrder == 2) {
            if (currentNode.hasLeftChild()) {
                displaysAVLTree(currentNode.getsLeftChild(), traversalOrder);
            }
            if (currentNode.hasRightChild()) {
                displaysAVLTree(currentNode.getsRightChild(), traversalOrder);
            }
            displaysElementInformation(currentNode);
        }
    }

    // Displays the AVL Tree based on traversal type
    // Precon: There is >= 1 element in the AVL Tree
    // Postcon: Checks for an element in the AVL Tree
    private void displaysAVLTree() {
        System.out.println("Displaying AVL Tree:");
        displaysNewLine();
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                System.out.print(" * In-order traversal:\t\t");
            } else if (i == 1) {
                displaysNewLine();
                displaysNewLine();
                System.out.print(" * Pre-order traversal:\t\t");
            } else {
                displaysNewLine();
                displaysNewLine();
                System.out.print(" * Post-order traversal:\t");
            }
            displaysAVLTree(root, i);
        }
        displaysNewLine();
        displaysNewLine();
        displaysLine();
    }

    private void run() {
        formsAVLTree();
        displaysAVLTree();
    }
    public static void main(String[] args) {
        AVLTree obj = new AVLTree();
        obj.run();
    }
}

class Node {
    private int balanceFactor;
    private int data;
    private int level;
    private int numLeftSubtreeElements;
    private int numRightSubtreeElements;
    private Node leftChild;
    private Node parent;
    private Node rightChild;

    public Node(int data) {
        this.balanceFactor = 0;
        this.data = data;
        this.level = 0;
        this.leftChild = null;
        this.numLeftSubtreeElements = 0;
        this.parent = null;
        this.rightChild = null;
        this.numRightSubtreeElements = 0;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public int getsBalanceFactor() {
        return this.balanceFactor;
        // return this.numLeftSubtreeElements - this.numRightSubtreeElements;
    }

    public int getsData() {
        return this.data;
    }

    public int getsLevel() {
        return this.level;
    }

    public int getsParentLevel() {
        return this.parent.getsLevel();
    }

    public int getsNumLeftSubtreeElements() {
        return this.numLeftSubtreeElements;
    }

    public int getsNumRightSubtreeElements() {
        return this.numRightSubtreeElements;
    }

    public Node getsLeftChild() {
        return this.leftChild;
    }

    public Node getsParent() {
        return this.parent;
    }

    public Node getsRightChild() {
        return this.rightChild;
    }

    public void decreasesNumLeftSubtreeElements() {
        this.numLeftSubtreeElements--;
    }

    public void decreasesNumRightSubtreeElements() {
        this.numRightSubtreeElements--;
    }

    public void increasesNumLeftSubtreeElements() {
        this.numLeftSubtreeElements++;
    }

    public void increasesNumRightSubtreeElements() {
        this.numRightSubtreeElements++;
    }

    public void setsBalanceFactor(int leftSubtreeHeight, int rightSubtreeHeight) {
        this.balanceFactor = leftSubtreeHeight - rightSubtreeHeight;
    }

    public void setsLevel() {
        this.level = this.parent.getsLevel() + 1;
    }

    public void setsLeftChild(Node incomingNode) {
        this.leftChild = incomingNode;
    }

    public void setsParent(Node parentNode) {
        this.parent = parentNode;
    }

    public void setsRightChild(Node incomingNode) {
        this.rightChild = incomingNode;
    }
}
