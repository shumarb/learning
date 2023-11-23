import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class InsertionSort {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

    // Randomly generate values for the Array
    // Precon: Array not created
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
                // because Insertion Sort sorts the elements in ascending order
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    // Stores array before Insertion Sort
    // Precon: Array with 5 to 12 elements formed
    // Postcon: Execute Insertion Sort
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

    // Displays array for checking
    // Precon: inputArray split into 2 arrays of near-equal/equal length
    // Postcon: Executes Insertion Sort
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

    // Displays array after Insertion Sort
    // Precon: Array sorted via Insertion Sort
    // Postcon: End of program
    private void displaysChange() {
        System.out.println("Insertion Sort:");
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false);
        displaysNewLine();
        displaysArray(" * After:\t[", inputArray, true);
    }

    // Executes Insertion Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Insertion Sort.
    private void insertionSort() {
        // 1. Start from 2nd element because comparison made
        // is based on all elements behind current element
        for (int i = 1; i < inputArray.length; i++) {
            int currentElement = inputArray[i];

            // j is iterator from first value to value before current value
            // Guaranteed j >= 0 because i >= 1
            int j = i - 1;
            
            // 2. While loop has 2 conditions
            // First condition is ensure loop stops at first element so that no array out of bounds exception thrown
            // Second condition is that there exists an element before current element 
            // that is > current element so that a swap can occur
            // While loop breaks if current index < 0 (hence first element reahed), 
            // or an current element <= currentElement
            while (j >= 0 && inputArray[j] > currentElement) {
                // 3. Shift element at index <= j to the right
                // Eg: Set element at index 2 to be element at index 1
                // Decrement j to proceed to element before j
                inputArray[j + 1] = inputArray[j--];
            } 
            inputArray[j + 1] = currentElement;
        }
    }

    private void run() {
        insertion();
        insertionSort();
        displaysChange();
    }
    public static void main(String[] args) {
        InsertionSort obj = new InsertionSort();
        obj.run();
    }
}
