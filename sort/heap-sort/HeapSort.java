import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class HeapSort {

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

    private void displaysChange() {
        System.out.println("======= Heap Sort =======");
        displaysArray(" * Before:\t[", initialArray, false);
        displaysNewLine();
        displaysArray(" * After:\t[", inputArray, true);
    }

    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysNewLine() {
        System.out.println();
    }

    private int formsData(boolean isDataInBinaryMaxHeap) {
        int data;
        if (isDataInBinaryMaxHeap) {
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

    private void formsData() {
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

    private void heapSort() {
        maxHeapify();
        for (int i = inputArray.length - 1; i > 0; i--) {
            // 1. Extract the root of the current max heap of elements
            // by replacing the root (maximum element) 
            // with the last element of the current max heap of elements
            // this ensures that the maximum element of the current iteration
            // is at it's final sorted position
            swap(inputArray, i, 0);
            
            // 2.  Max-heapify all elements before the current element
            // until the max heap is of size 1
            // At the end, the array is in sorted ascending order
            maxHeapify(inputArray, i, 0);
        }
    }

    private void insertion() {
        displaysLine();
        System.out.println("======= Insertion =======");
        formsData();
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

    private void maxHeapify() {
        for (int i = inputArray.length - 1; i >= 0; i--) {
            maxHeapify(inputArray, inputArray.length, i);
        }
    }

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
            swap(inputArray, parentIndex, largestIndex);
            maxHeapify(inputArray, numberOfElements, largestIndex);
        }
    }

    private void swap(int[] inputArray, int parentIndex, int largestIndex) {
        int temp = inputArray[parentIndex];
        inputArray[parentIndex] = inputArray[largestIndex];
        inputArray[largestIndex] = temp;
    }
    
    private void run() {
        insertion();
        heapSort();
        displaysChange();
    }

    public static void main(String[] args) {
        HeapSort obj = new HeapSort();
        obj.run();
    }
}
