import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

class HashMapExample {
    private HashMap <String, Integer> hMap = new HashMap <> ();
    private HashSet <Integer> uniqueNumbers = new HashSet <> ();
    private HashSet <String> uniqueStrings = new HashSet <> ();
    private Random myRandom = new Random();

    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysNewLine() {
        System.out.println();
    }

    private void formsData() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = myRandom.nextInt(-100, 101);
        int order = myRandom.nextInt(1, 4);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 1) {
                uniqueNumbers.add(data++);
            } else if (order == 2) {
                uniqueNumbers.add(data--);
            } else {
                uniqueNumbers.add(formsData(false));
            }
        }
    }

    private int formsData(boolean isDataPresent) {
        int data;
        if (isDataPresent) {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!uniqueNumbers.contains(data));
        } else {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (uniqueNumbers.contains(data));
        }
        return data;
    } 
    
    private void explanation() {
        displaysLine();
        System.out.println("=========== What is a HashMap? ============");
        System.out.println("HashMap is a data structure that stores key-value mappings based on a hash function.");
        displaysNewLine();
        int i = 1;
        System.out.println("Key HashMap operations based on the Java API: ");
        displaysNewLine();
        System.out.println(" * put(K key, V value): Stores the key-value mapping into the HashMap");
        System.out.println(" * remove(K key, V value): Removes the key-value mapping from the HashMap");
        System.out.println(" * replace(K key, V oldValue, V newValue): Replaces the value of a key-value mapping if the key is mapped to the specified value in the HashMap");
        System.out.println(" * get(K key): Returns the value that the specified key is mapped to, or return null if the HashMap contains no mapping for this key");
        System.out.println(" * keySet(): Returns a set view of the mappings in the HashMap");
        System.out.println(" * containsValue(V value): Returns true if the specified value is associated with >= 1 key-value mapping in the HashMap");
        System.out.println(" * containKey(K key): Returns true if the HashMap contains a mapping for the specified key.");
        System.out.println(" * clear(): Remove all elements in HashMap");
        System.out.println(" * isEmpty(): Return true if the HashMap is empty, else return false");
        System.out.println(" * values(): Returns a Collection view of the values contained in the HashMap");
        System.out.println(" " + i + ". size(): Obtains number of key-value mappings in the HashMap");
        displaysLine();
    }

    private void displaysHashMap() {
        System.out.println("HashMap: " + hMap);
    }

    private void insertion() {
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 13);
        System.out.println("Forming a HashMap with " + numberOfElements + " elements:");
        displaysNewLine();
        formsData();
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

    private void operations() {
        System.out.println("============ Operations ============");
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

    private void search() {
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

    private void deletion() {
        System.out.println("============ Deletion ============");
        System.out.print("Before: ");
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
        System.out.print("After: ");
        displaysHashMap();
        displaysLine();
    }
    
    private void run() {
        explanation();
        insertion();
        operations();
        search();
        deletion();
    }
    public static void main(String[] args) {
        HashMapExample obj = new HashMapExample();
        obj.run();
    }
}
