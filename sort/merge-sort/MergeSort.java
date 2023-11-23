import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class MergeSort {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

    // Randomly generate values for array
    // Precon: Array not created
    // Postcon: Array containing randomly-generated values created
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
                // because merge sort sorts the elements in ascending order
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    // Executes Merge Sort on inputArray
    // Precon: inputArray containing values user entered in order user entered has been created
    // Postcon: Values of inputArray are in increasing order after sorted via Merge Sort.
    private void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        // 1. No need to do Merge Sort on array wth 1 element or empty array
        if (inputLength < 2) {
            return;
        }

        // 2. Obtain index of middle element (midIndex) of inputArray
        // Split inputArray into 2 arrays: leftPartitionArray and rightPartitionArray
        // leftPartitionArray comprises of elements 0 to midIndex of inputArray
        // rightPartitionArray comprises of elements from midIndex + 1 to lastArrayIterator of inputArray
        // Note: copyOfRange range is [from, to), meaning [from, to - 1]
        int midIndex = inputLength / 2;
        int[] leftPartitionArray = Arrays.copyOfRange(inputArray, 0, midIndex);
        int[] rightPartitionArray = Arrays.copyOfRange(inputArray, midIndex, inputLength);

        // 3. Execute Merge Sort on the left and right partitions
        mergeSort(leftPartitionArray);
        mergeSort(rightPartitionArray);

        // 4. Combine the sub-array,
        // and assign each element in the combined sub-array to
        // the corresponding index of the input array
        merge(inputArray, leftPartitionArray, rightPartitionArray);
    }

    // Executes merge of values in array
    // Precon: Values of array are sorted but not in inputArray
    // Post: Displays inputArray after Merge Sort
    private void merge(int[] inputArray, int[] leftPartitionArray, int[] rightPartitionArray) {
        int inputArrayIterator = 0;                                 
        int leftPartitionArrayIterator = 0;                         
        int leftPartitionArraySize = leftPartitionArray.length;
        int rightPartitionArrayIterator = 0;                        
        int rightPartitionArraySize = rightPartitionArray.length;

        while (leftPartitionArrayIterator < leftPartitionArraySize && rightPartitionArrayIterator < rightPartitionArraySize) {
            // 1. Compare i-th element of leftPartitionArray with j-th element of rightPartitionArray
            if (leftPartitionArray[leftPartitionArrayIterator] <= rightPartitionArray[rightPartitionArrayIterator]) {
                // 1.1. i-th element of leftPartitionArray <= j-th element of rightPartitionArray,
                // so add i-th element of leftPartitionArray to k-th index of inputArray
                // and increment both iterators to refer to next element
                inputArray[inputArrayIterator++] = leftPartitionArray[leftPartitionArrayIterator++];
            } else {
                // 1.2. j-th element of rightPartitionArray < j-th element of rightPartitionArray,
                // so add j-th element of rightPartitionArray to k-th index of inputArray
                // and increment both iterators to refer to next element
                inputArray[inputArrayIterator++] = rightPartitionArray[rightPartitionArrayIterator++];
            }
        }

        // 2. At this point, it is possible that >= 1 element from at most one of the arrays
        // was not added to inputArray at correct index,
        // so add these elements into inputArray at correct index if it has not been done
        while (leftPartitionArrayIterator < leftPartitionArraySize) {
            inputArray[inputArrayIterator++] = leftPartitionArray[leftPartitionArrayIterator++];
        }
        while (rightPartitionArrayIterator < rightPartitionArraySize) {
            inputArray[inputArrayIterator++] = rightPartitionArray[rightPartitionArrayIterator++];
        }
    }

    // Displays array after Merge Sort
    // Precon: Array sorted via Merge Sort
    // Postcon: End of program
    private void displaysChange() {
        System.out.println("Merge Sort:");
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false);
        displaysNewLine();
        displaysArray(" * After:\t[", inputArray, true);
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

    // Copies inputArray into another array
    // Precon: Initial values of inputArray not stored in ordered form another array
    // Post Initial values of inputArray stored in ordered form another array
    private int[] storesInitialArray() {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    // Displays array before Merge Sort with line at the end
    // Precon: Array is unsorted
    // Postcon: Executes Merge Sort
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
        mergeSort(inputArray);
        displaysChange();
    }
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        obj.run();
    }
}
