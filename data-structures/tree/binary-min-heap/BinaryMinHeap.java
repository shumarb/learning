import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class BinaryMinHeap {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

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
            displaysNewLine();
            displaysLine();
        }
    }

    // Displays array before and after min-heapify
    // Precon: Array has been Min Heapified
    // Postcon: End of program
    private void displaysChange() {
        System.out.println("Min-heapify:");
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false);
        displaysTwoNewLines();
        displaysArray(" * After:\t[", inputArray, true);
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

    // Displays Two New Lines
    // Precon: Nil
    // Postcon: Nil
    private void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    // Forms Binary Min Heap
    // Precon: No Binary Min Heap created
    // Postcon: Binary Min Heap of N elements created
    private void insertion() {
        displaysLine();
        System.out.println("======= Insertion =======");
        formsData();
        inputArray = new int[set.size()];
        System.out.println("Forming a Binary Min Heap with " + inputArray.length + " elements:");
        displaysNewLine();
        int i = 0;
        for (int data: set) {
            System.out.println(" * inserting " + data);
            inputArray[i++] = data;
        }
        initialArray = storesInitialArray();
        displaysNewLine();
        minHeapify();
        displaysChange();
    }

    // Forms data set to insert into the Binary Min Heap
    // Precon: Nil
    // Postcon: Nil
    private void formsData() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = formsData(false);
        int order = myRandom.nextInt(0, 2);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 0) {
                // Descending order of number to be inserted into the Binary Min Heap
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    // Forms data in relation to elements in the Binary Min Heap
    // Precon: Nil
    // Postcon: Nil
    private int formsData(boolean isDataPresent) {
        int data;
        if (isDataPresent) {
            // Generates data based on element in the Binary Min Heap
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!set.contains(data));
        } else {
            // Generates data based on element not in the Binary Min Heap
            do {
                data = myRandom.nextInt(-100, 101);
            } while (set.contains(data));
        }
        return data;
    } 

    // Forms initial array based on input array before min-heapify
    // Precon: initialArray unitialised
    // Postcon: initialArray formed is the inputArray before min-heapify
    private int[] storesInitialArray() {
        return Arrays.copyOf(inputArray, inputArray.length);
    }    

    // Swaps elements
    // Precon: Root != smallest element
    // Postcon: Root == smallest element encounter so far
    private void swap(int[] inputArray, int smallestElementIndex, int currentIndex) {
        int temp = inputArray[currentIndex];
        inputArray[currentIndex] = inputArray[smallestElementIndex];
        inputArray[smallestElementIndex] = temp;
    }

    // Min-heapify the elements
    // Precon: Elements are currently unsorted in array
    // Postcon: Elements are arranged in array such that it forms a binary Min Heap
    private void minHeapify() {
        // 1. minHeapify the array
        // Iterate from the lowest-level leaf to the root
        for (int i = inputArray.length - 1; i >= 0; i--) {
            minHeapify(inputArray, i);
        }
    }

    // Min-heapify the eleemnts based on the current index
    // Precon: min-heapify in-progress
    // Postcon: Proceed to next element
    private void minHeapify(int[] inputArray, int currentIndex) {
        // 1. Check if child < parent
        // First part of condition ensures no array out of bounds by confirming this is a check on a non-leaf element
        int parentIndex = currentIndex;
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        
        if (leftChildIndex < inputArray.length && inputArray[leftChildIndex] < inputArray[parentIndex]) {
            parentIndex = leftChildIndex;
        }
        if (rightChildIndex < inputArray.length && inputArray[rightChildIndex] < inputArray[parentIndex]) {
            parentIndex = rightChildIndex;
        }

        // 2. If a child > parent, swap the elements
        // and min-heapify subtree is either the left or right child of the parent elmenet
        if (parentIndex != currentIndex) {
            swap(inputArray, currentIndex, parentIndex);
            minHeapify(inputArray, parentIndex);
        }
    }

    // Searches for an element
    // Precon: Elements arranged based on Min Heap
    // Postcon: End of program
    private void search() {
        System.out.println("======== Search ========");
        displaysArray("Array:\t[", inputArray, false);
        displaysTwoNewLines();
        for (int i = 0; i < 2; i++) {
            int key;
            boolean isKeyFound = false;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }
            for (int j = 0; j < inputArray.length; j++) {
                if (inputArray[j] == key) {
                    isKeyFound = true;
                    break;
                }
            }
            if (isKeyFound) {
                System.out.println(" * " + key + " is in the Binary Min Heap");
            } else {
                System.out.println(" * " + key + " is not in the Binary Min Heap");
            }
            displaysNewLine();
        }

        int maximum = inputArray[0];
        int minimum = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
            }
        }
        System.out.println(" * Maximum: " + maximum);
        displaysNewLine();
        System.out.println(" * Minimum: " + minimum);
        displaysLine();
    }

    // Deletes an element from the Binary Min Heap
    // Precon: Search method executed on Binary Min Heap
    // Postcon: Nil
    private void deletion() {
        System.out.println("======== Deletion ========");
        int indexOfDeletion = myRandom.nextInt(0, inputArray.length);
        System.out.println("Deletion at index " + indexOfDeletion + ": " + inputArray[indexOfDeletion]);
        displaysNewLine();
        displaysArray(" * Before:\t[", inputArray, false);
        displaysTwoNewLines();
        inputArray = deletion(indexOfDeletion);
        displaysArray(" * After:\t[", inputArray, false);
        displaysTwoNewLines();
        initialArray = storesInitialArray();
        minHeapify();
        displaysChange();
    }

    // Deletes an element from the array
    // Precon: Search of array complete
    // Postcon: End of program
    private int[] deletion(int indexOfDeletion) {
        set.remove(inputArray[indexOfDeletion]);
        int[] updatedArray = new int[inputArray.length - 1];
        int j = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != indexOfDeletion) {
                updatedArray[j++] = inputArray[i];
            }
        }
        return updatedArray;
    }

    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) {
        BinaryMinHeap obj = new BinaryMinHeap();
        obj.run();
    }
}
