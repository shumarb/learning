import java.util.HashSet;
import java.util.Random;

class Array {
    private int[] inputArray;
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
        HashSet <Integer> uniqueSet = new HashSet <> ();
        inputArray = new int[numberOfElements];
        for (int i = 0; i < inputArray.length; i++) {
            int toAdd = myRandom.nextInt(-10, 10);
            while (uniqueSet.contains(toAdd)) {
                toAdd = myRandom.nextInt(-10, 10);
            }
            uniqueSet.add(toAdd);
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

    // Searches for an element using binary search
    // Precon: Array has 5 - 12 elements
    // Postcon: Searches for maximum element
    private void search() {
        System.out.println("============ Search ============");
        displaysArray();
        displaysNewLine();
        boolean isKeyFound = false;
        int key = myRandom.nextInt(-10, 10);
        System.out.println("Linear Search on Array to find: " + key);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(" * current element: " + inputArray[i]);
            if (key == inputArray[i]) {
                System.out.println(" | Found!");
                isKeyFound = true;
                break;
            } else {
                displaysNewLine();
            }
        }
        if (isKeyFound) {
            System.out.println(key + " is in array");
        } else {
            System.out.println(key + " is not in array");
        }
        displaysNewLine();

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
        System.out.println(" * Maximum: " + maximum);
        displaysNewLine();
        System.out.println(" * Miniimum: " + minimum);
        displaysLine();
    }

    private void run() {
        insertion();
        search();
    }

    public static void main(String[] args) {
        Array obj = new Array();
        obj.run();
    }
}
