// Reference: https://www.youtube.com/watch?v=TbvhGcf6UJU&ab_channel=nptelhrd, https://www.geeksforgeeks.org/insertion-in-an-avl-tree/, https://www.baeldung.com/java-avl-trees
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
  
public class BinarySearchTree { 
  
    private HashSet <Integer> set = new HashSet <> ();
    private Node root; 
    private Random myRandom = new Random(); 

    private void displaysLine() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
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

    private void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    private void elementInformation(Node node) {
        displaysMessage(1, "[" + node.getsData() + ", h: " + node.getsHeight() + "]  ", false, false);
    }
    
    private void deletion() {
        displaysMessage(0, "======= Deletion =======", false, false);
        int key = formsData(true);
        root = deletion(root, key);
        set.remove(key);
        displaysMessage(0, "Delete: " + key, true, false);
        updatesHeight(root, "updates height of elements in left and right subtrees");
        traversal();
    }

    private Node deletion(Node node, int key) {
        if (node == null) {
            return node;
        } else if (key < node.getsData()) {
            node.setsLeftChild(deletion(node.getsLeftChild(), key));
        } else if (key > node.getsData()) {
            node.setsRightChild(deletion(node.getsRightChild(), key));
        } else {
            Node temp = null;
            if (!node.hasLeftChild() || !node.hasRightChild()) {
                temp = (temp == node.getsLeftChild()) ? node.getsRightChild() : node.getsLeftChild();

                // Deleting a leaf
                if (temp == null) {
                    temp = node;

                    // Node deleted
                    node = null;
                } else {
                    // Deleting element with 1 child
                    node = temp;
                }
            } else {
                // Deleting element with 2 children
                // Get in-order successor (smallest element in right subtree)
                temp = searchMinimum(node.getsRightChild());

                // Set current node's value to be that of it's successor
                node.setsData(temp.getsData());

                // Delete in-order successor
                node.setsRightChild(deletion(node.getsRightChild(), node.getsData()));
            }
        }
        
        // If tree has only 1 element, then return
        if (node == null) {
            return node;
        }

        updatesHeight(node, "increase");
        return node;
    }

    private int formsData(boolean isDataInBinarySearchTree) {
        int data;
        if (isDataInBinarySearchTree) {
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

    private void formsData() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = myRandom.nextInt(-100, 101);
        int order = myRandom.nextInt(1, 4);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 1) {
                set.add(data++);
            } else if (order == 2) {
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    private int getsHeight(Node node) { 
        return (node == null) ? -1 : node.getsHeight();
    }

    private void insertion() {
        displaysLine();
        displaysMessage(0, "======= Insertion =======", false, false);
        formsData();
        displaysMessage(0, "Forming Binary Search Tree with " + set.size() + " elements:", true, false);
        for (int data: set) {
            displaysMessage(0, " * Insert: " + data, true, false);
            root = insertion(root, data);
        }
        // Binary Search Tree formed but value of each element's height may not be 1 less
        // than it's parent, so update to ensure it is correct.
        updatesHeight(root, "updates height of elements in left and right subtrees");
        traversal();
        displaysLine();
    }

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

    private void search() {
        displaysMessage(0, "======= Search =======", false, false);
        Node node;
        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> searchPath = new ArrayList <> ();
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            displaysMessage(1, "Search: " + key + "\t| ", false, false);
            node = search(root, "binary search", key, searchPath);
            if (node != null) {
                displaysMessage(1, key + " is in the AVL Tree", false, false);
            } else {
                displaysMessage(1, key + " is not in the AVL Tree", false, false);
            }
            searchPath(searchPath);
            displaysNewLine();
        }

        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> searchPath = new ArrayList <> ();
            if (i == 0) {
                node = search(root, "searches minimum", Integer.MIN_VALUE, searchPath);
                displaysMessage(1, "Minimum: " + node.getsData(), false, false);
            } else {
                displaysNewLine();
                node = search(root, "searches maximum", Integer.MAX_VALUE, searchPath);
                displaysMessage(1, "Maximum: " + node.getsData(), false, false);
            }
            searchPath(searchPath);
        }
        displaysLine();
    }

    private Node search(Node node, String searchOperation, int key, ArrayList <Integer> searchPath) {
        if (node == null) {
            return node;
        }

        searchPath.add(node.getsData());

        if (key == node.getsData()) {
            return node;
        } else if (key < node.getsData()) {
            if (node.hasLeftChild()) {
                return search(node.getsLeftChild(), searchOperation, key, searchPath);
            } else {
                if (searchOperation.equals("searches minimum")) {
                    return node;
                }
            }
        } else if (key > node.getsData()) {
            if (node.hasRightChild()) {
                return search(node.getsRightChild(), searchOperation, key, searchPath);
            } else {
                if (searchOperation.equals("searches maximum")) {
                    return node;
                }
            } 
        }

        return null;
    }

    private Node searchMinimum(Node node) {
        if (node == null || !node.hasLeftChild()) {
            return node;
        }
        return searchMinimum(node.getsLeftChild());
    }

    private void searchPath(ArrayList <Integer> searchPath) {
        displaysMessage(1, "\t| Search Path: ", false, false);
        for (int i = 0; i < searchPath.size() - 1; i++) {
            System.out.print(searchPath.get(i) + " ---> ");
        }
        displaysMessage(0, Integer.toString(searchPath.get(searchPath.size() - 1)), false, false);
    }

    private void traversal(Node node, String traversalOrder) {
        if (node == null) {
            return;
        } else if (traversalOrder.equals("in-order")) {
            traversal(node.getsLeftChild(), traversalOrder);
            elementInformation(node);
            traversal(node.getsRightChild(), traversalOrder);
        } else if (traversalOrder.equals("pre-order")) {
            elementInformation(node);
            traversal(node.getsLeftChild(), traversalOrder);
            traversal(node.getsRightChild(), traversalOrder);
        } else {
            traversal(node.getsLeftChild(), traversalOrder);
            traversal(node.getsRightChild(), traversalOrder);
            elementInformation(node);
        }
    }

    private void traversal() {
        displaysMessage(0, "Binary Search Tree:", true, false);
        displaysMessage(1, " * In-order:\t", false, false);
        traversal(root, "in-order");
        displaysTwoNewLines();
        displaysMessage(1, " * Pre-order:\t", false, false);
        traversal(root, "pre-order");
        displaysTwoNewLines();
        displaysMessage(1, " * Post-order:\t", false, false);
        traversal(root, "post-order");
        displaysMessage(1, "", true, true);
    }

    private void updatesHeight(Node node, String operation) {
        if (node == null) {
            return;
        } else if (operation.equals("increase")) {
            node.setsHeight(1 + Math.max(getsHeight(node.getsLeftChild()), getsHeight(node.getsRightChild())));
        } else if (operation.equals("updates height of elements in left and right subtrees")) {
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

    private void run() {
        insertion();
        search();
        deletion();
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

    public void setsData(int data) {
        this.data = data;
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
