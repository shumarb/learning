import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class MergeSort {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

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

    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysNewLine() {
        System.out.println();
    }
    
    private void displaysChange() {
        System.out.println("======= Merge Sort =======");
        displaysArray(" * Before:\t[", initialArray, false);
        displaysNewLine();
        displaysArray(" * After:\t[", inputArray, true);
    }

    private int formsData(boolean isDataInArray) {
        int data;
        if (isDataInArray) {
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
        initialArray = Arrays.copyOf(inputArray, inputArray.length);
        displaysLine();
    }

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
                // 1.2. i-th element of leftPartitionArray > j-th element of rightPartitionArray,
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

    private void mergeSort() {
        mergeSort(inputArray);
    }

    private void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        // 1. Obtain index of middle element (midIndex) of inputArray
        // Split inputArray into 2 arrays: leftPartitionArray and rightPartitionArray
        // leftPartitionArray comprises of elements 0 to midIndex of inputArray
        // rightPartitionArray comprises of elements from midIndex + 1 to lastArrayIterator of inputArray
        // Note: copyOfRange range is [from, to), meaning [from, to - 1]
        int midIndex = inputLength / 2;
        int[] leftPartitionArray = Arrays.copyOfRange(inputArray, 0, midIndex);
        int[] rightPartitionArray = Arrays.copyOfRange(inputArray, midIndex, inputLength);

        // 2. Execute Merge Sort on the left and right partitions
        mergeSort(leftPartitionArray);
        mergeSort(rightPartitionArray);

        // 3. Combine the sub-array,
        // and assign each element in the combined sub-array to
        // the corresponding index of the input array
        merge(inputArray, leftPartitionArray, rightPartitionArray);
    }

    private void run() {
        insertion();
        mergeSort();
        displaysChange();
    }
    public static void main(String[] args) {
        MergeSort obj = new MergeSort();
        obj.run();
    }
}
