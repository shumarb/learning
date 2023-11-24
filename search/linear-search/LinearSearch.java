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
        displaysLine();
    }
    
    private void linearSearch() {
        System.out.println("======= Linear Search =======");
        displaysArray();
        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> elementsCheckedSet = new ArrayList <> ();
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                key = formsData(false);
            }

            boolean isKeyFound = false;
            for (int j = 0; j < inputArray.length; j++) {
                elementsCheckedSet.add(inputArray[j]);
                if (inputArray[j] == key) {
                    isKeyFound = true;
                    break;
                }
            }

            displaysNewLine();
            if (isKeyFound) {
                System.out.print(" * " + key + " found, ");
            } else {
                System.out.print(" * " + key + " not found, ");
            }
            System.out.println("elements checked: " + elementsCheckedSet);
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