import java.util.Arrays;
import java.util.Random;

public class BinaryMinHeap {

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

    // Displays array before and after min-heapify
    // Precon: Array has been Min Heapified
    // Postcon: End of program
    private void displaysChange(int[] inputArray, int[] initialArray) {
        displaysLine();
        System.out.println("min-heapify | " + inputArray.length + " elements:");
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

    // Forms Binary Min Heap
    // Precon: No Binary Min Heap created
    // Postcon: Binary Min Heap of N elements created
    private int[] insertElements() {
        int[] inputArray = new int[myRandom.nextInt(5, 12)];
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = myRandom.nextInt(-10, 10);
        }
        displaysLine();
        return inputArray;
    }

    // Forms initial array based on input array before min-heapify
    // Precon: initialArray unitialised
    // Postcon: initialArray formed is the inputArray before min-heapify
    private int[] formsInitialArray(int[] inputArray) {
        return Arrays.copyOf(inputArray, inputArray.length);
    }    

    // Swaps elements
    // Precon: Root != smallest element
    // Postcon: Root == smallest element encounter so far
    private void swapsElements(int[] inputArray, int smallestElementIndex, int currentIndex) {
        int temp = inputArray[currentIndex];
        inputArray[currentIndex] = inputArray[smallestElementIndex];
        inputArray[smallestElementIndex] = temp;
    }

    // Min-heapify the elements
    // Precon: Elements are currently unsorted in array
    // Postcon: Elements are arranged in array such that it forms a binary Min Heap
    private void executesMinHeapify(int[] inputArray) {
        // 1. minHeapify the array
        // Iterate from the lowest-level leaf to the root
        for (int i = inputArray.length - 1; i >= 0; i--) {
            executesMinHeapify(inputArray, i);
        }
    }

    // Min-heapify the eleemnts based on the current index
    // Precon: min-heapify in-progress
    // Postcon: Proceed to next element
    private void executesMinHeapify(int[] inputArray, int currentIndex) {
        // 1. Check if child < parent
        // First part of condition ensures no array out of bounds by confirming this is a check on a non-leaf element
        int parentIndex = currentIndex;
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        displaysArray("* now executing min-heapify | inputArray so far: [", inputArray, false);
        System.out.println();
        
        if (leftChildIndex < inputArray.length && inputArray[leftChildIndex] < inputArray[parentIndex]) {
            parentIndex = leftChildIndex;
            System.out.println("* current: (index , " + currentIndex 
                                + ", " + inputArray[currentIndex]
                                + ") | leftChild: (index " + leftChildIndex 
                                + ", " + inputArray[leftChildIndex]
                                + ") | smallest: (index " + parentIndex 
                                + ", " + inputArray[parentIndex]
                                + ")"
            );
        }
        if (rightChildIndex < inputArray.length && inputArray[rightChildIndex] < inputArray[parentIndex]) {
            parentIndex = rightChildIndex;
            System.out.println("* current: (index , " + currentIndex 
                                + ", " + inputArray[currentIndex]
                                + ") | rightChild: (index " + rightChildIndex 
                                + ", " + inputArray[rightChildIndex]
                                + ") | smallest: (index " + parentIndex 
                                + ", " + inputArray[parentIndex]
                                + ")"
            );
        }

        // 2. If a child > parent, swap the elements
        // and min-heapify subtree is either the left or right child of the parent elmenet
        if (parentIndex != currentIndex) {
            System.out.println("* to swap | current: (index " + currentIndex 
                                + ", " + inputArray[currentIndex]
                                + ") <-----------------------> smallest: (index " + parentIndex 
                                + ", " + inputArray[parentIndex]
                                + ")"
            );
            swapsElements(inputArray, currentIndex, parentIndex);
            displaysArray("** swap done, inputArray so far: [", inputArray, false);
            System.out.println();
            System.out.println("** after swap, min-heapify subtree with root: (index " + parentIndex 
                                + ", " + inputArray[parentIndex] 
                                + ")"
            );
            displaysLine();
            executesMinHeapify(inputArray, parentIndex);
        }
    }

    // Searches for maximum element
    // Precon: Elements arranged based on a Max Heap
    // Postcon: Finds minimum element
    private void searchesMinimum(int[] inputArray) {
        System.out.println("======== Searches Maximum ========");
        displaysArray("* inputArray: [", inputArray, false);
        displaysNewLine();
        System.out.println("* maximum element: " + inputArray[0]);
        displaysLine();
    }

    // Searches for minimum element
    // Precon: Elements arranged based on Max Heap
    // Postcon: Searches for element
    private void searchesMaximum(int[] inputArray) {
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
    private void searchesElement(int[] inputArray) {
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
        int[] inputArray = insertElements();
        int[] initialArray = formsInitialArray(inputArray);
        executesMinHeapify(inputArray);
        displaysChange(inputArray, initialArray);
        searchesMaximum(inputArray);
        searchesMinimum(inputArray);
        searchesElement(inputArray);
    }

    public static void main(String[] args) {
        BinaryMinHeap obj = new BinaryMinHeap();
        obj.run();
    }
}
