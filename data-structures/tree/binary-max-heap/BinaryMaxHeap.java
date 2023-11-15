import java.util.Arrays;
import java.util.Random;

public class BinaryMaxHeap {

    Random myRandom = new Random();

    // Displays Elements
    // Precon: List of unsorted N elements formed
    // Postcon: Nil
    private void displaysArray(String sentence, int[] inputArray, boolean isDisplaysLine) {
        System.out.print(sentence);
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + ", ");
        }
        System.out.print(inputArray[inputArray.length - 1] + "]");
        if (isDisplaysLine) {
            System.out.println();
            displaysLine();
        }
    }

    // Displays array before and after Max-Heapify
    // Precon: Array has been max heapified
    // Postcon: End of program
    private void displaysChange(int[] inputArray, int[] initialArray) {
        displaysLine();
        System.out.println("Max-Heapify | " + inputArray.length + " elements:");
        displaysArray("Before: [", initialArray, false);
        System.out.println();
        displaysArray("After: [", inputArray, true);
    }

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays New Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }

    // Forms Binary Max Heap
    // Precon: No Binary Max Heap created
    // Postcon: Binary Max Heap of N elements created
    private int[] insertion() {
        int[] inputArray = new int[myRandom.nextInt(5, 12)];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = myRandom.nextInt(-10000, 10000);
        }
        displaysLine();
        return inputArray;
    }

    // Forms initial array based on input array before Max-Heapify
    // Precon: initialArray unitialised
    // Postcon: initialArray formed is the inputArray before Max-Heapify
    private int[] formsInitialArray(int[] inputArray) {
        return Arrays.copyOf(inputArray, inputArray.length);
    }    

    // Swaps elements
    // Precon: Root != Largest element
    // Postcon: Root == Largest element encounter so far
    private void swapsElements(int[] inputArray, int largestElementIndex, int currentIndex) {
        int temp = inputArray[currentIndex];
        inputArray[currentIndex] = inputArray[largestElementIndex];
        inputArray[largestElementIndex] = temp;
    }

    // Max-Heapify the elements
    // Precon: Elements are currently unsorted in array
    // Postcon: Elements are arranged in array such that it forms a binary max heap
    private void executesMaxHeapify(int[] inputArray) {
        // 1. MaxHeapify the array
        // Iterate from the lowest-level leaf to the root
        for (int i = inputArray.length - 1; i >= 0; i--) {
            executesMaxHeapify(inputArray, i);
        }
    }

    // Max-Heapify the eleemnts based on the current index
    // Precon: Max-Heapify in-progress
    // Postcon: Proceed to next element
    private void executesMaxHeapify(int[] inputArray, int currentIndex) {
        // 1. Check if child > parent
        // First part of condition ensures no array out of bounds by confirming this is a check on a non-leaf element
        int parentIndex = currentIndex;
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        displaysArray("* now executing max-heapify | inputArray so far: [", inputArray, false);
        System.out.println();
        
        if (leftChildIndex < inputArray.length && inputArray[leftChildIndex] > inputArray[parentIndex]) {
            parentIndex = leftChildIndex;
            System.out.println("* current: (index , " + currentIndex 
                                + ", " + inputArray[currentIndex]
                                + ") | leftChild: (index " + leftChildIndex 
                                + ", " + inputArray[leftChildIndex]
                                + ") | largest: (index " + parentIndex 
                                + ", " + inputArray[parentIndex]
                                + ")"
            );
        }
        if (rightChildIndex < inputArray.length && inputArray[rightChildIndex] > inputArray[parentIndex]) {
            parentIndex = rightChildIndex;
            System.out.println("* current: (index , " + currentIndex
                                + ", " + inputArray[currentIndex]
                                + ") | rightChild: (index " + rightChildIndex 
                                + ", " + inputArray[rightChildIndex]
                                + ") | largest: (index " + parentIndex 
                                + ", " + inputArray[parentIndex]
                                + ")"
            );
        }

        // 2. If a child > parent, swap the elements
        // and max-heapify subtree where either the left child or right child element
        // which after the swap is <= it's parent, is the root of the subtree
        if (parentIndex != currentIndex) {
            System.out.println("* to swap | current: (index " + currentIndex 
                                + ", " + inputArray[currentIndex]
                                + ") <-----------------------> largest: (index " + parentIndex 
                                + ", " + inputArray[parentIndex]
                                + ")"
            );
            swapsElements(inputArray, currentIndex, parentIndex);
            displaysArray("** swap done, inputArray so far: [", inputArray, false);
            System.out.println();
            System.out.println("** after swap, max-heapify subtree with root: (index " + parentIndex 
                                + ", " + inputArray[parentIndex] 
                                + ")"
            );
            displaysLine();
            executesMaxHeapify(inputArray, parentIndex);
        }
    }

    // Searches for maximum element
    // Precon: Elements arranged based on a Max Heap
    // Postcon: Finds minimum element
    private void searchesMaximum(int[] inputArray) {
        System.out.println("======== Searches Maximum ========");
        displaysArray("* inputArray: [", inputArray, false);
        displaysNewLine();
        System.out.println("* maximum element: " + inputArray[0]);
        displaysLine();
    }

    // Searches for minimum element
    // Precon: Elements arranged based on Max Heap
    // Postcon: Searches for element
    private void searchesMinimum(int[] inputArray) {
        System.out.println("======== Searches Minimum ========");
        displaysArray("* inputArray: [", inputArray, false);
        displaysNewLine();
        int minimumElement = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 2; i >= 0; i--) {
            if (inputArray[i] < minimumElement) {
                minimumElement = inputArray[i];
            }
        }
        System.out.println("* minimum element: " + minimumElement);
        displaysLine();
    }

    // Searches for an element
    // Precon: Elements arranged based on Max Heap
    // Postcon: End of program
    private void search(int[] inputArray) {
        System.out.println("======== Searches Element ========");
        displaysArray("* inputArray: [", inputArray, false);
        displaysNewLine();
        boolean isFound = false;
        int key = myRandom.nextInt(-10, 10);
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == key) {
                isFound = true;
                break;
            }
        }
        if (isFound) {
            System.out.println("* key: " + key + " | is in the Binary Max Heap");
        } else {
            System.out.println("* key: " + key + " | is not in the Binary Max Heap");
        }
        displaysLine();
    }

    private void run() {
        int[] inputArray = insertion();
        int[] initialArray = formsInitialArray(inputArray);
        executesMaxHeapify(inputArray);
        displaysChange(inputArray, initialArray);
        searchesMaximum(inputArray);
        searchesMinimum(inputArray);
        search(inputArray);
    }

    public static void main(String[] args) {
        BinaryMaxHeap obj = new BinaryMaxHeap();
        obj.run();
    }
}
