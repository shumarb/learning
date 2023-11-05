import java.util.Random;

class AVLTree {

    private static final Random myRandom = new Random();
    private Node root;

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

    // Forms AVL Tree
    // Precon: No AVL Tree formed
    // Postcon: AVL Tree with 5 - 12 elements formed
    // TODO: Rotation
    private void formsAVLTree() {
        int numberOfElements = myRandom.nextInt(5, 12);
        displaysLine();
        System.out.println("Forming an AVL Tree with " + numberOfElements + " elements.");
        displaysNewLine();
        for (int i = 0; i < numberOfElements; i++) {
            Node incomingNode = new Node(myRandom.nextInt(-10, 10));
            if (i == 0) {
                root = incomingNode;
                System.out.println(" * root: " + root.getsData());
            } else {
                System.out.print(" * inserting: " + incomingNode.getsData());
                insertElement(root, incomingNode);
                System.out.println(" | parent: " + incomingNode.getsParent().getsData());
            }
        }
        displaysNewLine();
        displaysLine();
    }

    // Insert element into AVL Tree
    // Precon: AVL Tree creation in progress
    // Postcon: Insert next element into AVL Tree
    private void insertElement(Node currentNode, Node incomingNode) {
        if (incomingNode.getsData() > currentNode.getsData()) {
            if (currentNode.hasRightChild()) {
                insertElement(currentNode.getsRightChild(), incomingNode);
            } else {
                currentNode.setsRightChild(incomingNode);
                incomingNode.setsParent(currentNode);
                incomingNode.setsHeight();
            }
        } else {
            if (currentNode.hasLeftChild()) {
                insertElement(currentNode.getsLeftChild(), incomingNode);
            } else {
                currentNode.setsLeftChild(incomingNode);
                incomingNode.setsParent(currentNode);
                incomingNode.setsHeight();
            }
        }
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
            System.out.print("[" + currentNode.getsData() + ", height: " + currentNode.getsHeight() + "]   ");
            if (currentNode.hasRightChild()) {
                displaysAVLTree(currentNode.getsRightChild(), traversalOrder);
            }
        }

        // Pre-order traversal
        if (traversalOrder == 1) {
            System.out.print("[" + currentNode.getsData() + ", height: " + currentNode.getsHeight() + "]  ");
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
            System.out.print("[" + currentNode.getsData() + ", height: " + currentNode.getsHeight() + "]   ");
        }
    }

    // Displays the AVL Tree based on traversal type
    // Precon: There is >= 1 element in the AVL Tree
    // Postcon: Checks for an element in the AVL Tree
    private void displaysAVLTree() {
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
            displaysAVLTree(root, i);
        }
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
    private int data;
    private int height;
    private Node leftChild;
    private Node parent;
    private Node rightChild;

    public Node(int data) {
        this.data = data;
        this.height = 0;
        this.leftChild = null;
        this.parent = null;
        this.rightChild = null;
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

    public int getsData() {
        return this.data;
    }

    public int getsHeight() {
        return this.height;
    }

    public int getsParentHeight() {
        return this.parent.getsHeight();
    }

    public int getsLeftSubtreeHeight() {
        if (this.hasLeftChild()) {
            return this.getsLeftChild().height;
        }
        return 0;
    }

    public int getsRightSubtreeHeight() {
        if (this.hasRightChild()) {
            return this.getsRightChild().height;
        }
        return 0;
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

    public void setsLeftChild(Node incomingNode) {
        this.leftChild = incomingNode;
    }

    public void setsParent(Node parentNode) {
        this.parent = parentNode;
    }

    public void setsHeight() {
        this.height = this.parent.getsHeight() + 1;
    }

    public void setsRightChild(Node incomingNode) {
        this.rightChild = incomingNode;
    }
}
