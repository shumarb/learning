import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class LinearSearch {

    private HashSet <Integer> set = new HashSet <> ();
    private int[] inputArray;
    private Random myRandom = new Random();

    private void displaysArray() {
        System.out.print("Array: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    private void displaysLine() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysMessage(int messageType, String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        if (messageType == 0) {
            System.out.println(message);
        } else {
            System.out.print(message);
        }
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

    private void formsData() {
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
        displaysMessage(0, "======= Insertion =======", false, false);
        formsData();
        inputArray = new int[set.size()];displaysMessage(0, "Forming an array with " + inputArray.length + " elements:", true, false);
        int i = 0;
        for (int data: set) {
            displaysMessage(0, " * Insert: " + data, true, false);
            inputArray[i++] = data;
        }
        displaysArray();
        displaysLine();
    }
    
    private void linearSearch() {
        displaysMessage(0, "======= Linear Search =======", false, false);
        displaysArray();
        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> elementsCheckedList = new ArrayList <> ();
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }

            boolean isKeyFound = false;
            for (int j = 0; j < inputArray.length; j++) {
                elementsCheckedList.add(inputArray[j]);
                if (inputArray[j] == key) {
                    isKeyFound = true;
                    break;
                }
            }

            displaysNewLine();
            if (isKeyFound) {
                displaysMessage(1, " * " + key + " is in the array\t\t| ", false, false);
            } else {
                displaysMessage(1, " * " + key + " is not in the array\t| ", false, false);
            }
            displaysMessage(0, "Elements checked: " + elementsCheckedList, false, false);
        }
        displaysLine();
    }

    private void run() {
        insertion();
        linearSearch();

    }
    public static void main(String[] args) {
        LinearSearch obj = new LinearSearch();
        obj.run();
    }
}