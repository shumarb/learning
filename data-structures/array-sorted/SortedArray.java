import java.util.Arrays;
import java.util.Random;

class SortedArray {

    Random myRandom = new Random();

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
        Arrays.sort(inputArray);
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
    // Precon: Array has >= 1 element
    // Postcon: Searches for maximum element
    private void searchesElement(int[] inputArray) {
        System.out.println("============ Search ============");
        displaysElements(inputArray);
        boolean isKeyFound = false;
        int highIndex = inputArray.length - 1;
        int key = myRandom.nextInt(-10, 10);
        int lowIndex = 0;
        int midIndex;

        while (lowIndex <= highIndex) {
            midIndex = (lowIndex + highIndex) / 2;
            System.out.print(" * key: " + key + " | current element: " + inputArray[midIndex] + " | ");
            if (inputArray[midIndex] == key) {
                System.out.println("Found!");
                isKeyFound = true;
                break;
            }

            if (inputArray[midIndex] < key) {
                System.out.println("disregard all elements <= " + inputArray[midIndex]);
                lowIndex = midIndex + 1;
            }

            if (inputArray[midIndex] > key) {
                System.out.println("disregard all elements >= " + inputArray[midIndex]);
                highIndex = midIndex - 1;
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
    // Precon: Array has >= 1 element
    // Postcon: Searches for minimum element
    private void searchesMaximum(int[] inputArray) {
        System.out.println("============ Search Maximum ============");
        displaysElements(inputArray);
        System.out.println("Maximum: " + inputArray[inputArray.length - 1]);
        displaysLine();
    }

    // Searches for minimum element
    // Precon: Array has >= 1 element
    // Postcon: Searches for minimum element
    private void searchesMinimum(int[] inputArray) {
        System.out.println("============ Search Minimum ============");
        displaysElements(inputArray);
        System.out.println("Minimum: " + inputArray[0]);
        displaysLine();
    }

    private void run() {
        int[] inputArray = insertsElements();
        searchesElement(inputArray);
        searchesMaximum(inputArray);
        searchesMinimum(inputArray);
    }

    public static void main(String[] args) {
        SortedArray obj = new SortedArray();
        obj.run();
    }
}
