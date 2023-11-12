// Reference: https://www.youtube.com/watch?v=TbvhGcf6UJU&ab_channel=nptelhrd, https://www.geeksforgeeks.org/insertion-in-an-avl-tree/, https://www.baeldung.com/java-avl-trees
import java.util.HashSet;
import java.util.Random;
  
public class BinarySearchTree { 
  
    private HashSet <Integer> set = new HashSet <> ();
    private Node root; 
    private Random myRandom = new Random();

    // Gets height of a node
    // Precon: Nil
    // Postcon: Nil
    private int getsHeight(Node node) { 
        return (node == null) ? -1 : node.getsHeight();
    } 

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

    // Displays two new Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    // Displays element information
    // Precon: All elements inserted into Binary Search Tree
    // Postcon: Nil
    private void displaysElementInformation(Node node) {
        System.out.print("[" + node.getsData()
                        + ", h: " + node.getsHeight()
                        + "]  "
        );
    }

    // Updates height of node
    // Precon: Node inserted into Binary Search Tree
    // Postcon: Rotate Binary Search Tree if required
    private void updatesHeight(Node node, String operation) {
        if (node == null) {
            return;
        }
        if (operation.equals("increase")) {
            node.setsHeight(1 + Math.max(getsHeight(node.getsLeftChild()), getsHeight(node.getsRightChild())));
        }
        if (operation.equals("updates height of elements in left and right subtrees")) {
            if (node.hasLeftChild()) {
                node.getsLeftChild().setsHeight(node.getsHeight() - 1);
                updatesHeight(node.getsLeftChild(), "updates height of elements in left and right subtrees");
            }
            if (node.hasRightChild()) {
                node.getsRightChild().setsHeight(node.getsHeight() - 1);
                updatesHeight(node.getsRightChild(), "updates height of elements in left and right subtrees");
            }
        }
    }

    // Forms data set to insert into Binary Search Tree
    // Precon: Nil
    // Postcon: Nil
    private void formsSet() {
        int data = myRandom.nextInt(-10, 10);
        int order = myRandom.nextInt(1, 3);
        for (int i = 0; i < myRandom.nextInt(8, 12); i++) {
            if (order == 1) {
                // Ascending order of number to be inserted into the Binary Search Tree
                set.add(data++);
            } else if (order == 2) {
                // Descending order of number to be inserted into the Binary Search Tree
                set.add(data--);
            } else {
                while (set.contains(data)) {
                    data = myRandom.nextInt(-10, 10);
                }
                set.add(data);
            }
        }
    }

    private void formsBinarySearchTree() {
        displaysLine();
        System.out.println("======= Insertion =======");
        formsSet();
        System.out.println("Forming Binary Search Tree with " + set.size() + " elements:");
        displaysNewLine();
        for (int data: set) {
            System.out.println(" * inserting " + data);
            root = insertion(root, data);
        }
        // Binary Search Tree formed but value of each element's height may not be 1 less
        // than it's parent, so update to ensure it is correct.
        updatesHeight(root, "updates height of elements in left and right subtrees");
        displaysNewLine();
        displaysLine();
    }

    // Insert an element into Binary Search Tree
    // Precon: Binary Search Tree with specified number of elements not formed
    // Postcon: Binary Search Tree with specified number of elements formed
    private Node insertion(Node node, int data) { 
        if (node == null) {
            return new Node(data);
        } else if (data < node.getsData()) {
            node.setsLeftChild(insertion(node.getsLeftChild(), data));
        } else {
            node.setsRightChild(insertion(node.getsRightChild(), data)); 
        } 
        updatesHeight(node, "increase");
        return node;
    } 

    // Displays Binary Search Tree
    // Precon: All elements inserted into Binary Search Tree
    // Postcon: Nil
    private void displaysBinarySearchTree(Node node, String traversalOrder) {
        if (node == null) {
            return;
        } else if (traversalOrder.equals("in-order")) {
            displaysBinarySearchTree(node.getsLeftChild(), traversalOrder);
            displaysElementInformation(node);
            displaysBinarySearchTree(node.getsRightChild(), traversalOrder);
        } else if (traversalOrder.equals("pre-order")) {
            displaysElementInformation(node);
            displaysBinarySearchTree(node.getsLeftChild(), traversalOrder);
            displaysBinarySearchTree(node.getsRightChild(), traversalOrder);
        } else {
            displaysBinarySearchTree(node.getsLeftChild(), traversalOrder);
            displaysBinarySearchTree(node.getsRightChild(), traversalOrder);
            displaysElementInformation(node);
        }
    }

    // Displays Binary Search Tree
    // Precon: Binary Search Tree is formed
    // Postcon: Nil
    private void displaysBinarySearchTree() {
        System.out.println("======= Traversal =======");
        System.out.println("Displaying Binary Search Tree of " + set.size() + " elements:");
        displaysNewLine();
        System.out.print(" * In-order:\t");
        displaysBinarySearchTree(root, "in-order");
        displaysTwoNewLines();
        System.out.print(" * Pre-order:\t");
        displaysBinarySearchTree(root, "pre-order");
        displaysTwoNewLines();
        System.out.print(" * Post-order:\t");
        displaysBinarySearchTree(root, "post-order");
        displaysNewLine();
        displaysLine();
    }

    // Searches for element in Binary Search Tree
    // Precon: Binary Search Tree formed
    // Postcon: Nil
    private void searchesBinarySearchTree() {
        System.out.println("======= Search =======");
        Node node;

        int key = myRandom.nextInt(-10, 10);
        System.out.println("Search for " + key + " | Starting from the root of the Binary Search Tree...");
        node = search(root, "binary search", key);
        if (node == null) {
            System.out.println(key + " is not in the Binary Search Tree");
        } else {
            System.out.println(key + " is in the Binary Search Tree");
        }
        displaysTwoNewLines();

        System.out.println("Search for minimum element | Starting from the root of the Binary Search Tree...");
        node = search(root, "searches minimum", 0);
        System.out.println("Minimum element: " + node.getsData());
        displaysTwoNewLines();
        
        System.out.println("Search for maximum element | Starting from the root of the Binary Search Tree...");
        node = search(root, "searches maximum", 0);
        System.out.println("Maximum element: " + node.getsData());
        displaysLine();
    }

    // Searches for maximum or minimum element
    // Precon: Binary Search Tree formed
    // Postcon: Nil
    private Node search(Node node, String searchOperation, int key) {
        if (searchOperation.equals("searches minimum")) {
            System.out.print(" * current element: " + node.getsData());
            if (node.hasLeftChild()) {
                System.out.println(" | going to left child of " + node.getsData());
                return search(node.getsLeftChild(), searchOperation, key);
            } else {
                System.out.println(" | " + node.getsData() + " has no left child, so the search ends here");
                displaysNewLine();
                return node;
            }
        } else if (searchOperation.equals("searches maximum")) {
            System.out.print(" * current element: " + node.getsData());
            if (node.hasRightChild()) {
                System.out.println(" | going to right child of " + node.getsData());
                return search(node.getsRightChild(), searchOperation, key);
            } else {
                System.out.println(" | " + node.getsData() + " has no right child, so the search ends here");
                displaysNewLine();
                return node;
            }
        } else if (searchOperation.equals("binary search")) {
            System.out.print(" * current element: " + node.getsData());
            if (key == node.getsData()) {
                System.out.print(" | Found!");
                displaysTwoNewLines();
                return node;
            } else if (key > node.getsData()) {
                if (node.hasRightChild()) {
                    System.out.println(" | " + key + " > " + node.getsData() + ", so go to right child of " + node.getsData());
                    return search(node.getsRightChild(), searchOperation, key);
                } else {
                    System.out.println(" | " + node.getsData() + " has no right child, so the search ends here");
                    displaysNewLine();
                }
            } else {
                if (node.hasLeftChild()) {
                    System.out.println(" | " + key + " < " + node.getsData() + ", so go to left child of " + node.getsData());
                    return search(node.getsLeftChild(), searchOperation, key);
                } else {
                    System.out.println(" | " + node.getsData() + " has no left child, so the search ends here");
                    displaysNewLine();
                }
            }
        }

        return null;
    }
    
    private void run() {
        formsBinarySearchTree();
        displaysBinarySearchTree();
        searchesBinarySearchTree();
    }

    public static void main(String[] args) { 
        BinarySearchTree obj = new BinarySearchTree();
        obj.run();
    } 
} 

class Node { 
    private int data;
    private int height;
    private Node leftChild;
    private Node rightChild; 
  
    public Node(int data) { 
        this.data = data; 
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
    
    public Node getsLeftChild() {
        return this.leftChild;
    }

    public Node getsRightChild() {
        return this.rightChild;
    }

    public void setsHeight(int height) {
        this.height = height;
    }

    public void setsLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setsRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }
} 