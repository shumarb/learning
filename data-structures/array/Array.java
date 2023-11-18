import java.util.HashSet;
import java.util.Random;

class Array {
    private int[] inputArray;
    // HashSet used only to generate unique numbers
    HashSet <Integer> set = new HashSet <> ();
    private Random myRandom = new Random();

    // Inserts elements into array
    // Precon: InputArray unitialised
    // Postcon: InputArray initialised with >= 1 element
    private void insertion() {
        displaysLine();
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 13);
        System.out.println("Creating an Array with " + numberOfElements + " elements:");
        displaysNewLine();
        
        // HashSet used only to generate unique numbers
        inputArray = new int[numberOfElements];
        for (int i = 0; i < inputArray.length; i++) {
            int toAdd = myRandom.nextInt(-10, 10);
            while (set.contains(toAdd)) {
                toAdd = myRandom.nextInt(-10, 10);
            }
            set.add(toAdd);
            System.out.println(" * Element #" + (i + 1) + ": " + toAdd);
            inputArray[i] = toAdd;
        }

        displaysNewLine();
        displaysArray();
        displaysLine();
    }

    // Displays line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Displays array
    // Precon: Nil
    // Postcon: Nil
    private void displaysArray() {
        System.out.print("Array: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    // Forms data in relation to elements in the Array
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataInArray) {
        int data;
        if (isDataInArray) {
            // Generates data based on element in the Array
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            // Generates data based on element not in the Array
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    } 
    

    // Searches for an element using linear search
    // Precon: Array has 5 - 12 elements
    // Postcon: Searches for maximum element
    private void search() {
        System.out.println("============ Search ============");
        displaysArray();
        displaysNewLine();

        for (int i = 0; i < 2; i++) {
            boolean isKeyFound = false;
            int key;
            if (i == 0) {
                // Finds element in the Array
                key = formsData(true);
            } else {
                // Finds element not in the Array
                 key = formsData(false);
            }
            System.out.println("Linear Search on Array to find: " + key);
            for (int j = 0; j < inputArray.length; j++) {
                if (key == inputArray[j]) {
                    isKeyFound = true;
                    break;
                }
            }
            if (isKeyFound) {
                System.out.println(key + " is in array");
            } else {
                System.out.println(key + " is not in array");
            }
            displaysNewLine();
        }

        int maximum = inputArray[0];
        int minimum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
            }
            if (inputArray[i] < minimum) {
                minimum = inputArray[i];
            }
        }
        System.out.println("Maximum: " + maximum);
        displaysNewLine();
        System.out.println("Miniimum: " + minimum);
        displaysLine();
    }

    // Deletes an element from the array
    // Precon: Search of array complete
    // Postcon: End of program
    private void deletion() {
        System.out.println("============ Deletion ============");
        System.out.print("Before deletion: ");
        displaysArray();
        displaysNewLine();
        int indexOfDeletion = myRandom.nextInt(0, inputArray.length);
        System.out.println(" * Deletion at index " + indexOfDeletion + ", which is element " + inputArray[indexOfDeletion]);
        inputArray = deletion(indexOfDeletion);
        displaysNewLine();
        System.out.print("After deletion: ");
        displaysArray();
        displaysLine();
    }

    // Deletes an element from the array
    // Precon: Search of array complete
    // Postcon: End of program
    private int[] deletion(int indexOfDeletion) {
        int[] updatedArray = new int[inputArray.length - 1];
        int j = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != indexOfDeletion) {
                updatedArray[j++] = inputArray[i];
            }
        }
        return updatedArray;
    }

    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) {
        Array obj = new Array();
        obj.run();
    }
}
