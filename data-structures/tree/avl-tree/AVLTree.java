import java.util.HashSet;
import java.util.Random;
  
public class AVLTree { 
  
    private HashSet <Integer> set = new HashSet <> ();
    private Node root; 
    private Random myRandom = new Random();

    private int getsHeight(Node node) { 
        return (node == null) ? -1 : node.getsHeight();
    } 

    private int getsBalanceFactor(Node node) { 
        return (node == null) ? 0 : getsHeight(node.getsLeftChild()) - getsHeight(node.getsRightChild()); 
    }

    private void displaysLine() {
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysNewLine() {
        System.out.println();
    }

    private void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
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

    private int formsData(boolean isDataInAVLTree) {
        int data;
        if (isDataInAVLTree) {
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

    private void insertion() {
        displaysLine();
        System.out.println("======= Insertion =======");
        formsData();
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
        displaysAVLTree();
    }

    /**
     * References: 
     * https://www.geeksforgeeks.org/insertion-in-an-avl-tree/
     * https://www.baeldung.com/java-avl-trees
     */ 
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
    
    /**
     * Reference: 
     * https://www.youtube.com/watch?v=TbvhGcf6UJU&ab_channel=nptelhrd, 
     * https://github.com/geekific-official/geekific-youtube/blob/main/tree-implementations/avl-tree/src/main/java/com/youtube/geekific/AVLTree.java#L94
     */
    private Node rebalancesAVLTree(Node node) {
        if (node == null) {
            return root;
        }

        int balanceFactor = getsBalanceFactor(node);

        // Left-Left imbalance ==> Right rotation
        if (balanceFactor > 1 && getsBalanceFactor(node.getsLeftChild()) >= 0) {
            return rightRotation(node);
        }

        // Left-Right imbalance ==> Left-Right rotation
        if (balanceFactor > 1 && getsBalanceFactor(node.getsLeftChild()) < 0) {
            node.setsLeftChild(leftRotation(node.getsLeftChild()));
            return rightRotation(node);
        }

        // Right-Right imbalance ==> Left rotation
        if (balanceFactor < -1 && getsBalanceFactor(node.getsRightChild()) <= 0) {
            return leftRotation(node);
        }

        // Right-Left imbalance ==> Right-Left rotation
        if (balanceFactor < -1 && getsBalanceFactor(node.getsRightChild()) > 0) {
            node.setsRightChild(rightRotation(node.getsRightChild()));
            return leftRotation(node);
        }

        return node;
    }

    private Node rightRotation(Node node) { 
        if (node == null) {
            return node;
        }

        Node leftChild = node.getsLeftChild(); 
        Node centerNode = leftChild.getsRightChild();
  
        // node > centerNode > leftChild
        leftChild.setsRightChild(node);
        node.setsLeftChild(centerNode);
  
        updatesHeight(node, "increase");
        updatesHeight(leftChild, "increase");
        
        // Return new root
        return leftChild; 
    } 
  
    private Node leftRotation(Node node) { 
        if (node == null) {
            return node;
        }

        Node rightChild = node.getsRightChild(); 
        Node centerNode = rightChild.getsLeftChild();
  
        // Left rotation 
        // node < centerNode < rightChild
        rightChild.setsLeftChild(node);
        node.setsRightChild(centerNode);
  
        updatesHeight(node, "increase");
        updatesHeight(rightChild, "increase");
  
        // Return new root
        return rightChild; 
    } 

    private Node searchMinimum(Node node) {
        if (node == null || !node.hasLeftChild()) {
            return node;
        }
        return searchMinimum(node.getsLeftChild());
    }

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

    private void displaysElementInformation(Node node) {
        System.out.print("[" + node.getsData() + ", h: " + node.getsHeight() + "]  ");
    }

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

    private void search() {
        System.out.println("======= Search =======");
        Node node;
        for (int i = 0; i < 2; i++) {
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
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

    private Node search(Node node, String searchOperation, int key) {
        if (node == null) {
            return node;
        }
        
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

    private void deletion() {
        System.out.println("======= Deletion =======");
        int key = formsData(true);
        root = deletion(root, key);
        set.remove(key);
        System.out.println("Deleted: " + key);
        updatesHeight(root, "updates height of elements in left and right subtrees");
        displaysNewLine();
        displaysAVLTree();
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

        return rebalancesAVLTree(node);
    }

    private void run() {
        insertion();
        search();
        deletion();
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
