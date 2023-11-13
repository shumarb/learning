import java.util.HashSet;
import java.util.Random;
  
public class AVLTree { 
  
    private HashSet <Integer> set = new HashSet <> ();
    private Node root; 
    private Random myRandom = new Random();

    // Gets height of a node
    // Precon: Nil
    // Postcon: Nil
    private int getsHeight(Node node) { 
        return (node == null) ? -1 : node.getsHeight();
    } 
  
    // Computes balance factor of an element
    // Precon: Rebalancing of element ongoing
    // Postcon: AVL Tree maintained 
    private int getsBalanceFactor(Node node) { 
        return (node == null) ? 0 : getsHeight(node.getsLeftChild()) - getsHeight(node.getsRightChild()); 
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

    // Updates height of node
    // Precon: Node inserted into AVL Tree
    // Postcon: Rotate AVL Tree if required
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

    // Forms data set to insert into AVL Tree
    // Precon: Nil
    // Postcon: Nil
    private void formsSet() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = myRandom.nextInt(-100, 101);
        int order = myRandom.nextInt(1, 4);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 1) {
                // Ascending order of number to be inserted into AVL tree
                set.add(data++);
            } else if (order == 2) {
                // Descending order of number to be inserted into AVL tree
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    // Forms data in relation to elements in AVL Tree
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataInAVLTree) {
        int data;
        if (isDataInAVLTree) {
            // Generates data based on element in the AVL Tree
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            // Generates data based on element not in the AVL Tree
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    } 

    private void formsAVLTree() {
        displaysLine();
        System.out.println("======= Insertion =======");
        formsSet();
        System.out.println("Forming AVL Tree with " + set.size() + " elements:");
        displaysNewLine();
        for (int data: set) {
            System.out.println(" * inserting " + data);
            root = insertion(root, data);
        }
        // AVL Tree may have a child is > 1 level below it's parent
        // Eg: element 5 is at level 3, but it's left child 4 is at level 1 and not level 2.
        // Hence, this update ensures every child is 1 level below it's parent.
        updatesHeight(root, "updates height of elements in left and right subtrees");
        displaysNewLine();
    }

    // Insert an element into AVL Tree
    // Precon: AVL Tree with specified number of elements not formed
    // Postcon: AVL Tree with specified number of elements formed
    // Reference: https://www.geeksforgeeks.org/insertion-in-an-avl-tree/, https://www.baeldung.com/java-avl-trees
    private Node insertion(Node node, int data) { 
        if (node == null) {
            return new Node(data);
        } else if (data < node.getsData()) {
            node.setsLeftChild(insertion(node.getsLeftChild(), data));
        } else if (data > node.getsData()) {
            node.setsRightChild(insertion(node.getsRightChild(), data)); 
        } 
        updatesHeight(node, "increase");
        return rebalancesAVLTree(node);
    } 
    
    // Rebalances AVL Tree
    // Precon: Element inserted into AVL Tree
    // Postcon: Insert next element into AVL Tree
    // Reference: https://www.youtube.com/watch?v=TbvhGcf6UJU&ab_channel=nptelhrd, https://github.com/geekific-official/geekific-youtube/blob/main/tree-implementations/avl-tree/src/main/java/com/youtube/geekific/AVLTree.java#L94
    private Node rebalancesAVLTree(Node node) {
        if (node == null) {
            return root;
        }

        // 3. Obtain balance factor of current node and rebalance if required
        int balanceFactor = getsBalanceFactor(node);

        // 3.1. Left-Left imbalance ==> Right rotation
        if (balanceFactor > 1 && getsBalanceFactor(node.getsLeftChild()) >= 0) {
            return rightRotation(node);
        }

        // 3.2. Left-Right imbalance ==> Left0Right rotation
        if (balanceFactor > 1 && getsBalanceFactor(node.getsLeftChild()) < 0) {
            node.setsLeftChild(leftRotation(node.getsLeftChild()));
            return rightRotation(node);
        }

        // 3.3. Right-Right imbalance ==> Left rotation
        if (balanceFactor < -1 && getsBalanceFactor(node.getsRightChild()) <= 0) {
            return leftRotation(node);
        }

        // 3.4. Right-Left imbalance ==> Right-Left rotation
        if (balanceFactor < -1 && getsBalanceFactor(node.getsRightChild()) > 0) {
            node.setsRightChild(rightRotation(node.getsRightChild()));
            return leftRotation(node);
        }

        return node;
    }
    // Right Rotation
    // Precon: Balance factor of node is < -1
    // Postcon: Nil
    private Node rightRotation(Node node) { 
        // 1. Obtain node's predecessor
        // Predecessor is the largest element smaller than the element
        // Hence, a predecessor is the largest element in the element's left subtree
        Node leftChild = node.getsLeftChild(); 
        Node predecessor = leftChild.getsRightChild();
  
        // 2. Right rotation
        // Note that node > leftChild > predecessor
        leftChild.setsRightChild(node);
        node.setsLeftChild(predecessor);
  
        // 3. Update heights 
        updatesHeight(node, "increase");
        updatesHeight(leftChild, "increase");
        
        // 4. Return new root
        return leftChild; 
    } 
  
    // Left Rotation
    // Precon: Balance factor of node is > 1
    // Postcon: Nil
    private Node leftRotation(Node node) { 
        // 1. Obtain node's successor
        // Successor is the smallest element greater than the element
        // Hence, a successor is the smallest element in the element's right subtree 
        Node rightChild = node.getsRightChild(); 
        Node successor = rightChild.getsLeftChild();
  
        // 2. Left rotation 
        // Note that node < rightChild < successor
        rightChild.setsLeftChild(node);
        node.setsRightChild(successor);
  
        // 3. Update heights 
        updatesHeight(node, "increase");
        updatesHeight(rightChild, "increase");
  
        // 4. Return new root
        return rightChild; 
    } 


    // Finds minimum of a subtree
    // Precon: Nil
    // Postcon: Nil
    private Node searchMinimum(Node node) {
        if (node == null || !node.hasLeftChild()) {
            return node;
        }
        return searchMinimum(node.getsLeftChild());
    }

    // Displays AVL Tree
    // Precon: All elements inserted into AVL Tree
    // Postcon: Nil
    private void displaysAVLTree(Node node, String traversalOrder) {
        if (node == null) {
            return;
        } else if (traversalOrder.equals("in-order")) {
            displaysAVLTree(node.getsLeftChild(), traversalOrder);
            displaysElementInformation(node);
            displaysAVLTree(node.getsRightChild(), traversalOrder);
        } else if (traversalOrder.equals("pre-order")) {
            displaysElementInformation(node);
            displaysAVLTree(node.getsLeftChild(), traversalOrder);
            displaysAVLTree(node.getsRightChild(), traversalOrder);
        } else if (traversalOrder.equals("post-order")) {
            displaysAVLTree(node.getsLeftChild(), traversalOrder);
            displaysAVLTree(node.getsRightChild(), traversalOrder);
            displaysElementInformation(node);
        }
    }

    // Displays element information
    // Precon: All elements inserted into AVL Tree
    // Postcon: Nil
    private void displaysElementInformation(Node node) {
        System.out.print("[" + node.getsData() + ", h: " + node.getsHeight() + "]  ");
    }

    // Displays AVL Tree
    // Precon: AVL Tree is formed
    // Postcon: Nil
    private void displaysAVLTree() {
        System.out.println("Displaying AVL Tree of " + set.size() + " elements:");
        displaysNewLine();
        System.out.print(" * In-order:\t");
        displaysAVLTree(root, "in-order");
        displaysTwoNewLines();
        System.out.print(" * Pre-order:\t");
        displaysAVLTree(root, "pre-order");
        displaysTwoNewLines();
        System.out.print(" * Post-order:\t");
        displaysAVLTree(root, "post-order");
        displaysNewLine();
        displaysLine();
    }

    // Searches for element in AVL Tree
    // Precon: AVL Tree formed
    // Postcon: Nil
    private void searchesAVLTree() {
        System.out.println("======= Search =======");
        Node node;
        for (int i = 0; i < 2; i++) {
            int key;
            if (i == 0) {
                // Find existing element in AVL Tree
                key = formsData(true);
            } else {
                // Find non-existent element in AVL Tree
                key = formsData(false);
            }
            System.out.println("Search: " + key + " | Starting from the root of the AVL Tree...");
            node = search(root, "binary search", key);
            if (node != null) {
                System.out.println(node.getsData() + " is in the AVL Tree");
            } else {
                System.out.println(key + " is not in the AVL Tree");
            }
            displaysTwoNewLines();
        }

        System.out.println("Search for minimum element | Starting from the root of the AVL Tree...");
        node = search(root, "searches minimum", Integer.MIN_VALUE);
        System.out.println("Minimum element: " + node.getsData());
        displaysTwoNewLines();
        
        System.out.println("Search for maximum element | Starting from the root of the AVL Tree...");
        node = search(root, "searches maximum", Integer.MAX_VALUE);
        System.out.println("Maximum element: " + node.getsData());
        displaysLine();
    }

    // Searches for maximum or minimum element
    // Precon: AVL Tree formed
    // Postcon: Nil
    private Node search(Node node, String searchOperation, int key) {
        // searchOperation: binary search, searches maximum, searches minimum
        System.out.print(" * current element: " + node.getsData());
        if (key == node.getsData()) {
            System.out.println(" | Found!");
            return node;
        } else if (key < node.getsData()) {
            if (searchOperation.equals("binary search")) {
                System.out.print(" | " + key + " < " + node.getsData());
            }
            if (node.hasLeftChild()) {
                System.out.println(" | go to left child of " + node.getsData() + ", which is " + node.getsLeftChild().getsData());
                return search(node.getsLeftChild(), searchOperation, key);
            } else {
                System.out.println(" | " + node.getsData() + " has no left child, so the search ends here");
                if (searchOperation.equals("searches minimum")) {
                    return node;
                }
            }
        } else if (key > node.getsData()) {
            if (searchOperation.equals("binary search")) {
                System.out.print(" | " + key + " > " + node.getsData());
            }
            if (node.hasRightChild()) {
                System.out.println(" | go to right child of " + node.getsData() + ", which is " + node.getsRightChild().getsData());
                return search(node.getsRightChild(), searchOperation, key);
            } else {
                System.out.println(" | " + node.getsData() + " has no right child, so the search ends here");
                if (searchOperation.equals("searches maximum")) {
                    return node;
                }
            } 
        }

        return null;
    }

    // Deletes an element from the AVL Tree
    // Precon: AVL Tree formed
    // Postcon: Nil
    private void deletionInAVLTree() {
        System.out.println("======= Deletion =======");
        int key = formsData(true);
        root = deletion(root, key);
        set.remove(key);
        System.out.println("Deleted: " + key);
        updatesHeight(root, "updates height of elements in left and right subtrees");
        displaysNewLine();
    }

    // Deletion of element from AVL Tree
    // Precon: Element is in AVL Tree
    // Postcon: Element deleted from AVL Tree
    private Node deletion(Node node, int key) {
        // 1. Finds key to be deleted by traversing from the root
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

        // 2. Updates height of current node
        updatesHeight(node, "increase");

        return rebalancesAVLTree(node);
    }

    private void run() {
        formsAVLTree();
        displaysAVLTree();
        searchesAVLTree();
        deletionInAVLTree();
        displaysAVLTree();
    }

    public static void main(String[] args) { 
        AVLTree tree = new AVLTree();
        tree.run();
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

    public boolean isLeaf() {
        return !this.hasLeftChild() && !this.hasRightChild();
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