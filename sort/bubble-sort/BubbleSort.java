
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class BubbleSort {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

    // Insert elements into array
    // Precon: No array formed
    // Postcon: Array with 5 to 12 elements formed
    private void insertion() {
        displaysLine();
        System.out.println("======= Insertion =======");
        formsSet();
        inputArray = new int[set.size()];
        System.out.println("Forming an array with " + inputArray.length + " elements:");
        displaysNewLine();
        int i = 0;
        for (int data: set) {
            System.out.println(" * inserting " + data);
            inputArray[i++] = data;
        }
        initialArray = storesInitialArray();
        displaysNewLine();
    }

    // Forms data set to insert into the Array
    // Precon: Nil
    // Postcon: Nil
    private void formsSet() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = formsData(false);
        int order = myRandom.nextInt(0, 2);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 0) {
                // Descending order of number to be inserted into the Array
                // because Bubble Sort sorts the elements in ascending order
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    // Forms data in relation to elements in the Array
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataInBinaryMaxHeap) {
        int data;
        if (isDataInBinaryMaxHeap) {
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

    // Stores array before Bubble Sort
    // Precon: Array with 5 to 12 elements formed
    // Postcon: Execute Bubble Sort
    private int[] storesInitialArray() {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    // Displays line for easier readibility
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Swaps elements in array with one another
    // Precon: Bubble Sort in progress
    // Postcon: Continue Bubble Sort
    private void swapElements(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp; 
    }

    // Executes Bubble Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Bubble Sort
    private void bubbleSort() {
        boolean isArraySorted = false;
        while (!isArraySorted) {
            isArraySorted = true;
            for (int i = 0; i < inputArray.length - 1; i++) {
                if (inputArray[i] > inputArray[i + 1]) {
                    // A swap is required, so array is not sorted so far
                    isArraySorted = false;
                    swapElements(inputArray, i, i + 1);
                }
            }
        }
    }

    // Displays array after Bubble Sort
    // Precon: Array sorted via Bubble Sort
    // Postcon: End of program
    private void displaysChange() {
        System.out.println("Bubble Sort:");
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false);
        displaysNewLine();
        displaysArray(" * After:\t[", inputArray, true);
    }

    // Displays array
    // Precon: Array is unsorted
    // Postcon: Executes Bubble Sort
    private void displaysArray(String sentence, int[] inputArray, boolean isDisplaysLine) {
        System.out.print(sentence);
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
        if (isDisplaysLine) {
            displaysLine();
        }
    }

    private void run() {
        insertion();
        bubbleSort();
        displaysChange();
    }
    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        obj.run();
    }
}
