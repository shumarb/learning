import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

class HashMapExample {
    private HashMap <String, Integer> hMap = new HashMap <> ();
    // HashSet used only to generate unique values for the HashMap
    private HashSet <Integer> uniqueNumbers = new HashSet <> ();
    private HashSet <String> uniqueStrings = new HashSet <> ();
    private Random myRandom = new Random();

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
                uniqueNumbers.add(data++);
            } else if (order == 2) {
                // Descending order of number to be inserted into AVL tree
                uniqueNumbers.add(data--);
            } else {
                uniqueNumbers.add(formsData(false));
            }
        }
    }

    // Forms data in relation to elements in the HashMap
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataInHashMap) {
        int data;
        if (isDataInHashMap) {
            // Generates data based on element in the AVL Tree
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!uniqueNumbers.contains(data));
        } else {
            // Generates data based on element not in the AVL Tree
            do {
                data = myRandom.nextInt(-100, 101);
            } while (uniqueNumbers.contains(data));
        }
        return data;
    } 
    
    // Displays key HashMap operations
    // Precon: HashMap of size >= 1 formed
    // Postcon: Apply some of these key operations on the HashMap
    private void explainsHashMap() {
        displaysLine();
        System.out.println("=========== What is a HashMap? ============");
        System.out.println("HashMap is a data structure that stores key-value mappings based on a hash function.");
        displaysNewLine();
        int i = 1;
        System.out.println("Key HashMap operations: ");
        displaysNewLine();
        System.out.println(" " + i++ + ". put(K key, V value): Stores the key-value mapping into the HashMap");
        System.out.println(" " + i++ + ". remove(K key, V value): Removes the key-value mapping from the HashMap");
        System.out.println(" " + i++ + ". replace(K key, V oldValue, V newValue): Replaces the value of a key-value mapping if the key is mapped to the specified value in the HashMap");
        System.out.println(" " + i++ + ". get(K key): Returns the value that the specified key is mapped to, or return null if the HashMap contains no mapping for this key");
        System.out.println(" " + i++ + ". keySet(): Returns a set view of the mappings in the HashMap");
        System.out.println(" " + i++ + ". containsValue(V value): Returns true if the specified value is associated with >= 1 key-value mapping in the HashMap");
        System.out.println(" " + i++ + ". containKey(K key): Returns true if the HashMap contains a mapping for the specified key.");
        System.out.println(" " + i++ + ". clear(): Remove all elements in HashMap");
        System.out.println(" " + i++ + ". isEmpty(): Return true if the HashMap is empty, else return false");
        System.out.println(" " + i++ + ". values(): Returns a Collection view of the values contained in the HashMap");
        System.out.println(" " + i + ". size(): Obtains number of key-value mappings in the HashMap");
        displaysLine();
    }

    // Displays HashMap
    // Precon: Nil
    // Postcon: Nil
    private void displaysHashMap() {
        System.out.println("HashMap: " + hMap);
    }

    // Forms HashMap
    // Precon: Nil
    // Postcon: Nil
    private void formsHashMap() {
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 13);
        System.out.println("Forming a HashMap with " + numberOfElements + " elements:");
        displaysNewLine();
        formsSet();
        String alphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < numberOfElements; i++) {
            StringBuilder name = new StringBuilder();
            do {
                for (int j = 0; j < 5; j++) {
                    name.append(alphabeticString.charAt(myRandom.nextInt(alphabeticString.length())));
                }    
            } while (uniqueStrings.contains(name.toString()));
            uniqueStrings.add(name.toString());

            int data;
            do {
                data  = myRandom.nextInt(-100, 101);
            } while (uniqueNumbers.contains(data));

            System.out.println(" * Inserting element #" + (i + 1) + ": [" + name + ", " + data + "]");
            hMap.put(name.toString(), data);  
        }
        displaysNewLine();
        displaysHashMap();
        displaysLine();
    }

    private void executeHashMapOperations() {
        System.out.println("============ HashMap Operations ============");
        displaysHashMap();
        displaysNewLine();
        System.out.println("Apply some key operations on HashMap:");
        String alphabeticString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder name = new StringBuilder();
        for (int j = 0; j < 5; j++) {
            name.append(alphabeticString.charAt(myRandom.nextInt(alphabeticString.length())));
        }
        System.out.println(" * containsKey(K key): Does HashMap contain " + name + "? ----------> " + hMap.containsKey(name.toString()));
        int value = myRandom.nextInt(-10, 10);
        System.out.println(" * containsValue(V value): Does HashMap contain " + value + "? ----------> " + hMap.containsValue(value));
        System.out.println(" * isEmpty() ----------> " + hMap.isEmpty());
        System.out.println(" * size() ----------> " + hMap.size());
        System.out.println(" * keySet() ----------> " + hMap.keySet());
        System.out.println(" * values() ----------> " + hMap.values());
        displaysLine();
    }

    // Searches a HashMap
    // Precon: Nil
    // Postcon: Nil
    private void searchesHashMap() {
        System.out.println("============ Search ============");
        displaysHashMap();
        displaysNewLine();
        int maximum = Integer.MIN_VALUE;
        int minimum = Integer.MAX_VALUE;
        String maximumKey = "";
        String minimumKey = "";
        for (Map.Entry <String, Integer> hMapEntries: hMap.entrySet()) {
            if (hMapEntries.getValue() > maximum) {
                maximum = hMapEntries.getValue();
                maximumKey = hMapEntries.getKey();
            }
            if (hMapEntries.getValue() < minimum) {
                minimum = hMapEntries.getValue();
                minimumKey = hMapEntries.getKey();
            }
        }
        System.out.println(" * Maximum: " + maximum + " | Key: " + maximumKey);
        displaysNewLine();
        System.out.println(" * Minimum: " + minimum + " | Key: " + minimumKey);
        displaysLine();
    }

    // Deletes element from HashMap
    // Precon: Search in HashMap executed
    // Postcon: End of program
    private void deletioninHashMap() {
        System.out.println("============ Deletion ============");
        System.out.print("Before deletion | ");
        displaysHashMap();
        int indexToDelete = myRandom.nextInt(0, hMap.size());
        int i = 0;
        String keyToDelete = "";
        for (Map.Entry <String, Integer> hMapEntries: hMap.entrySet()) {
            keyToDelete = hMapEntries.getKey();
            if (i++ == indexToDelete) {
                break;
            }
        }
        displaysNewLine();
        System.out.println(" * Deleting: [" + keyToDelete + ", " + hMap.get(keyToDelete) + "]");
        hMap.remove(keyToDelete);
        displaysNewLine();
        System.out.print("After deletion | ");
        displaysHashMap();
        displaysLine();
    }
    
    private void run() {
        explainsHashMap();
        formsHashMap();
        executeHashMapOperations();
        searchesHashMap();
        deletioninHashMap();
    }
    public static void main(String[] args) {
        HashMapExample obj = new HashMapExample();
        obj.run();
    }
}
