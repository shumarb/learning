import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class HeapSort {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

    // Displays Line
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

    // Stores array before Heap Sort
    // Precon: Array with 5 to 12 elements formed
    // Postcon: Execute Heap Sort
    private int[] storesInitialArray() {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    // Displays array before Heap Sort with line at the end
    // Precon: Array is unsorted
    // Postcon: Executes Heap Sort
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

    // Displays array after Heap Sort
    // Precon: Array sorted via Heap Sort
    // Postcon: End of program
    private void displaysChange() {
        System.out.println("Heap Sort:");
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false);
        displaysNewLine();
        displaysArray(" * After:\t[", inputArray, true);
    }

    // Swaps elements with one another
    // Precon: largest element != root
    // Postcon: Root is largest element
    private void swapElements(int[] inputArray, int parentIndex, int largestIndex) {
        int temp = inputArray[parentIndex];
        inputArray[parentIndex] = inputArray[largestIndex];
        inputArray[largestIndex] = temp;
    }

    // Arrange the elements in the array in the form of a binary max heap
    // Precon: Heap Sort in-progress
    // Postcon: Execute next step of Heap Sort algorithm
    private void maxHeapify(int[] inputArray, int numberOfElements, int parentIndex) {
        int largestIndex = parentIndex;   
        int leftChildIndex = (2 * parentIndex) + 1;        
        int rightChildIndex = (2 * parentIndex) + 2;  
        
        // 1. Finds largest value between a parent and its children
        // First part of expression is to ensure no array out of bounds exception thrown
        if (leftChildIndex < numberOfElements && inputArray[leftChildIndex] > inputArray[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < numberOfElements && inputArray[rightChildIndex] > inputArray[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        // 2. If any of the children are larger than the parent, swap that child with the parent,
        // and MaxHeapify the the array based on the largest element found so far
        if (largestIndex != parentIndex) {
            swapElements(inputArray, parentIndex, largestIndex);
            maxHeapify(inputArray, numberOfElements, largestIndex);
        }
    }

    // Executes Heap Sort
    // Precon: Array is unsorted
    // Postcon: Arrray is sorted in increasing order
    private void heapSort() {
        // 1. Iterating from the last element to the left child of the root
        for (int i = inputArray.length - 1; i > 0; i--) {

            // 1.1. Extract the root of the current max heap of elements
            // by replacing the root (maximum element) 
            // with the last element of the current max heap of elements
            // this ensures that the maximum element of the current iteration
            // is at it's final sorted position
            swapElements(inputArray, i, 0);
            
            // 1.2  Max-heapify all elements before the current element
            // until the max heap is of size 1
            // At the end, the array is in sorted ascending order
            maxHeapify(inputArray, i, 0);
        }
    }

    // Executes Max-Heapify
    // Precon: Array is unsorted
    // Postcon: Array sorted based on Max Heap
    private void maxHeapify() {
        // 1. Max-Heapify the array
        // Iterate from the leaves to the root
        for (int i = inputArray.length - 1; i >= 0; i--) {
            maxHeapify(inputArray, inputArray.length, i);
        }
    }

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

    // Forms data in relation to elements in the Binary Max Heap
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataInBinaryMaxHeap) {
        int data;
        if (isDataInBinaryMaxHeap) {
            // Generates data based on element in the Binary Max Heap
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            // Generates data based on element not in the Binary Max Heap
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    } 

    // Forms data set to insert into the Binary Max Heap
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
                // because heap sort sorts the elements in ascending order
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    private void run() {
        insertion();
        maxHeapify();
        heapSort();
        displaysChange();
    }
    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        obj.run();
    }
}
