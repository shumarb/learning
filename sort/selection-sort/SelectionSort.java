import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

class SelectionSort {

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
        System.out.println("======= Selection Sort =======");
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
                // because Selection Sort sorts the elements in ascending order
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

    private void selectionSort() {
        for (int startIndex = 0; startIndex < inputArray.length - 1; startIndex++) {
            boolean isSorted = true;
            for (int nextIndex = startIndex + 1; nextIndex < inputArray.length; nextIndex++) {
                if (inputArray[nextIndex] < inputArray[startIndex]) {
                    isSorted = false;
                    swap(inputArray, nextIndex, startIndex);
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    private void swap(int[] inputArray, int firstIndex, int secondIndex) {
        int temp = inputArray[firstIndex];
        inputArray[firstIndex] = inputArray[secondIndex];
        inputArray[secondIndex] = temp; 
    }

    private void run() {
        insertion();
        selectionSort();
        displaysChange();
    }
    public static void main(String[] args) {
        SelectionSort obj = new SelectionSort();
        obj.run();
    }
}
