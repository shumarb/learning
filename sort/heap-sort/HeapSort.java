import java.util.Arrays;
import java.util.Random;

class HeapSort {
    
    private int[] formsArray() {
        Random myRandom = new Random();
        int arraySize = myRandom.nextInt(5, 12);
        int[] inputArray = new int[arraySize];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = myRandom.nextInt(-10000, 10000);
        }
        displaysLine();
        return inputArray;
    }

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Stores array before Heap Sort
    // Precon: Array formed has 5 - 12 elements
    // Postcon: Execute Heap Sort
    private int[] formsInitialArray(int[] inputArray) {
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
    private void displaysChange(int[] initialArray, int[] inputArray) {
        System.out.print("Change: [");
        for (int i = 0; i < initialArray.length - 1; i++) {
            System.out.print(initialArray[i] + " ");
        }
        System.out.print(initialArray[initialArray.length - 1] + "] -----------------> [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
        displaysLine();
    }

    // Swaps elements with one another
    // Precon: largest element != root
    // Postcon: Root is largest element
    private void swapsElements(int[] inputArray, int parentIndex, int largestIndex) {
        System.out.print("* inputArray before swap: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
        System.out.println("* swap: inputArray[" + parentIndex + "]: " 
                            + inputArray[parentIndex] + "  <----------------->  inputArray[" 
                            + largestIndex + "]: " + inputArray[largestIndex]
        );
        int temp = inputArray[parentIndex];
        inputArray[parentIndex] = inputArray[largestIndex];
        inputArray[largestIndex] = temp;
        System.out.print("* inputArray after swap: [");
        displaysArray(inputArray);
    }

    // Arrange the elements in the array in the form of a binary max heap
    // Precon: Heap Sort in-progress
    // Postcon: Execute next step of Heap Sort algorithm
    private void executesMaxHeapify(int[] inputArray, int numberOfElements, int parentIndex) {
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

        if (leftChildIndex < numberOfElements && rightChildIndex < numberOfElements) {
            System.out.println("* parent: " + inputArray[parentIndex] 
                            + " | leftChild: " + inputArray[leftChildIndex]
                            + " | rightChild: " + inputArray[rightChildIndex]
                            + " | largest: " + inputArray[largestIndex]
            );
        }
        displaysLine();

        // 2. If any of the children are larger than the parent, swap that child with the parent,
        // and MaxHeapify the the array based on the largest element found so far
        if (largestIndex != parentIndex) {
            System.out.println("* swap | parent:(index " + parentIndex
                                + ", " + inputArray[parentIndex]
                                + ") <-----------------> child: (index " + largestIndex
                                + ", " + inputArray[largestIndex]
                                + ")"
            );
            System.out.print("* inputArray before swap: [");
            displaysArray(inputArray);
            swapsElements(inputArray, parentIndex, largestIndex);
            executesMaxHeapify(inputArray, numberOfElements, largestIndex);
            displaysArray("* inputArray after swap: [", inputArray, true);
        }
    }

    // Executes Heap Sort
    // Precon: Array is unsorted
    // Postcon: Arrray is sorted in increasing order
    private void executesHeapSort(int[] inputArray) {
        // 1. Iterating from the last element to the left child of the root
        for (int i = inputArray.length - 1; i > 0; i--) {
            displaysArray("* heap sort at index " + i + " | inputArray so far: [", inputArray, false);

            // 1.1. Extract the root of the current max heap of elements
            // by replacing the root (maximum element) 
            // with the last element of the current max heap of elements
            // this ensures that the maximum element of the current iteration
            // is at it's final sorted position
            swapsElements(inputArray, i, 0);
            
            // 1.2  Max-heapify all elements before the current element
            // until the max heap is of size 1
            // At the end, the array is in sorted ascending order
            executesMaxHeapify(inputArray, i, 0);
        }
    }

    // Displays array without line
    // Precon: Nil
    // Postcon: Nil
    private void displaysArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    // Executes Max-Heapify
    // Precon: Array is unsorted
    // Postcon: Array sorted based on Max Heap
    private void executesMaxHeapify(int[] inputArray) {
        // 1. Max-Heapify the array
        // Iterate from the leaves to the root
        for (int i = inputArray.length - 1; i >= 0; i--) {
            executesMaxHeapify(inputArray, inputArray.length, i);
        }
        System.out.print("** Array after MaxHeapify: [");
        displaysArray(inputArray);
        displaysLine();
    }

    private void run() {
        int[] inputArray = formsArray();
        int[] initialArray = formsInitialArray(inputArray);
        displaysArray("Before Heap Sort: [", inputArray, true);
        executesMaxHeapify(inputArray);
        executesHeapSort(inputArray);
        displaysArray("After Heap Sort: [", inputArray, true);
        displaysChange(initialArray, inputArray);
    }
    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        obj.run();
    }
}
