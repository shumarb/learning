import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class BinaryMaxHeap {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] initialArray;
    private int[] inputArray;
    private Random myRandom = new Random();

    private void deletion() {
        displaysMessage("======== Deletion ========", false, false);
        int indexOfDeletion = myRandom.nextInt(0, inputArray.length);
        displaysMessage("Deletion at index " + indexOfDeletion + ": " + inputArray[indexOfDeletion], true, false);
        displaysArray(" * Before:\t[", inputArray, false, true);
        inputArray = deletion(indexOfDeletion);
        displaysArray(" * After:\t[", inputArray, false, true);
        initialArray = storesInitialArray();
        maxHeapify();
        displaysChange();
    }

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

    private void displaysArray(String sentence, int[] array, boolean isDisplaysLine, boolean isDisplayTwoLines) {
        System.out.print(sentence);
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] + "]");
        if (isDisplaysLine) {
            displaysNewLine();
            displaysLine();
        }
        if (isDisplayTwoLines) {
            displaysTwoNewLines();
        }
    }

    private void displaysChange() {
        displaysNewLine();
        displaysArray(" * Before:\t[", initialArray, false, true);
        displaysArray(" * After:\t[", inputArray, true, false);
    }

    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysMessage(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        System.out.println(message);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }
    
    private void displaysNewLine() {
        System.out.println();
    }

    private void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    private void formsData() {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = formsData(false);
        int order = myRandom.nextInt(0, 2);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 0) {
                set.add(data++);
            } else {
                set.add(formsData(false));
            }
        }
    }

    private int formsData(boolean isDataPresent) {
        int data;
        if (isDataPresent) {
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

    private void insertion() {
        displaysLine();
        displaysMessage("======= Insertion =======", false, false);
        formsData();
        inputArray = new int[set.size()];
        displaysMessage("Forming a Binary Max Heap with " + inputArray.length + " elements:", true, false);
        int i = 0;
        for (int data: set) {
            displaysMessage(" * Inserting " + data, true, false);
            inputArray[i++] = data;
        }
        initialArray = storesInitialArray();
        maxHeapify();
        displaysChange();
    }

    private void maxHeapify() {
        displaysMessage("Max-Heapify:", false, false);
        for (int i = inputArray.length - 1; i >= 0; i--) {
            maxHeapify(inputArray, i);
        }
    }

    private void maxHeapify(int[] inputArray, int currentIndex) {
        // 1. Check if child > parent
        // First part of condition ensures no array out of bounds by confirming this is a check on a non-leaf element
        int parentIndex = currentIndex;
        int leftChildIndex = (2 * currentIndex) + 1;
        int rightChildIndex = (2 * currentIndex) + 2;
        
        if (leftChildIndex < inputArray.length && inputArray[leftChildIndex] > inputArray[parentIndex]) {
            parentIndex = leftChildIndex;
        }
        if (rightChildIndex < inputArray.length && inputArray[rightChildIndex] > inputArray[parentIndex]) {
            parentIndex = rightChildIndex;
        }

        // 2. If a child > parent, swap the elements
        // and max-heapify subtree where either the left child or right child element
        // which after the swap is <= it's parent, is the root of the subtree
        if (parentIndex != currentIndex) {
            swap(inputArray, currentIndex, parentIndex);
            maxHeapify(inputArray, parentIndex);
        }
    }

    private void search() {
        displaysMessage("======== Search ========", false, false);
        displaysArray("Array:\t[", inputArray, false, true);
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
                displaysMessage(" * " + key + " is in the Binary Max Heap", true, false);
            } else {
                displaysMessage(" * " + key + " is not in the Binary Max Heap", true, false);
            }
        }

        int maximum = inputArray[0];
        int minimum = inputArray[0];
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] < minimum) {
                minimum = inputArray[i];
            }
        }
        displaysMessage(" * Maximum: " + maximum, true, false);
        displaysMessage(" * Minimum: " + minimum, false, true);
    }

    private int[] storesInitialArray() {
        return Arrays.copyOf(inputArray, inputArray.length);
    }

    private void swap(int[] inputArray, int largestElementIndex, int currentIndex) {
        int temp = inputArray[currentIndex];
        inputArray[currentIndex] = inputArray[largestElementIndex];
        inputArray[largestElementIndex] = temp;
    }

    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) {
        BinaryMaxHeap obj = new BinaryMaxHeap();
        obj.run();
    }
}
