import java.util.Random;

class Array {

    private Random myRandom = new Random();

    // Inserts elements into array
    // Precon: InputArray unitialised
    // Postcon: InputArray initialised with >= 1 element
    private int[] insertsElements() {
        displaysLine();
        System.out.println("============ Insertion ============");
        int numberOfElements = myRandom.nextInt(5, 12);
        int[] inputArray = new int[numberOfElements];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = myRandom.nextInt(-10, 10);
        }
        displaysElements(inputArray);
        displaysLine();
        return inputArray;
    }

    // Displays line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------");
    }
    // Displays array
    // Precon: Nil
    // Postcon: Nil
    private void displaysElements(int[] inputArray) {
        System.out.print("* Array: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    // Searches for an element using binary search
    // Precon: Array has 5 - 12 elements
    // Postcon: Searches for maximum element
    private void searchesElement(int[] inputArray) {
        System.out.println("============ Search ============");
        displaysElements(inputArray);
        boolean isKeyFound = false;
        int key = myRandom.nextInt(-10, 10);
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(" * key: " + key + " | current element: " + inputArray[i]);
            if (key == inputArray[i]) {
                System.out.println(" | Found!");
                isKeyFound = true;
                break;
            } else {
                System.out.println();
            }
        }

        if (isKeyFound) {
            System.out.println(key + " is in array");
        } else {
            System.out.println(key + " is not in array");
        }
        displaysLine();
    }

    // Searches for maximum element
    // Precon: Array has 5 - 12 elements
    // Postcon: Searches for minimum element
    private void searchesMaximum(int[] inputArray) {
        System.out.println("============ Search Maximum ============");
        displaysElements(inputArray);
        int maximum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            System.out.print(" * maximum so far: " + maximum + " | current element: " + inputArray[i]);
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
                System.out.println(" | new maximum: " + maximum);
            } else {
                System.out.println();
            }
        }
        System.out.println("Maximum: " + maximum);
        displaysLine();
    }

    // Searches for minimum element
    // Precon: Array has 5 - 12 elements
    // Postcon: Searches for minimum element
    private void searchesMinimum(int[] inputArray) {
        System.out.println("============ Search Minimum ============");
        displaysElements(inputArray);
        int minumum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            System.out.print(" * minumum so far: " + minumum + " | current element: " + inputArray[i]);
            if (inputArray[i] < minumum) {
                minumum = inputArray[i];
                System.out.println(" | new minumum: " + minumum);
            } else {
                System.out.println();
            }
        }
        System.out.println("Minimum: " + minumum);
        displaysLine();
    }

    private void run() {
        int[] inputArray = insertsElements();
        searchesElement(inputArray);
        searchesMaximum(inputArray);
        searchesMinimum(inputArray);
    }

    public static void main(String[] args) {
        Array obj = new Array();
        obj.run();
    }
}
