import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

class Array {
    private int[] inputArray;
    private HashSet <Integer> set = new HashSet <> ();
    private Random myRandom = new Random();

    private void deletion() {
        System.out.println("============ Deletion ============");
        System.out.print("Before deletion: ");
        displaysArray();
        displaysNewLine();
        int indexOfDeletion = myRandom.nextInt(0, inputArray.length);
        System.out.println(" * Deletion at index " + indexOfDeletion + ": " + inputArray[indexOfDeletion]);
        inputArray = deletion(indexOfDeletion);
        displaysNewLine();
        System.out.print("After deletion: ");
        displaysArray();
        displaysLine();
    }

    private int[] deletion(int indexOfDeletion) {
        int[] updatedArray = new int[inputArray.length - 1];
        int j = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (i != indexOfDeletion) {
                updatedArray[j++] = inputArray[i];
            }
        }
        return updatedArray;
    }

    private void displaysArray() {
        System.out.print("Array: [");
        for (int i = 0; i < inputArray.length - 1; i++) {
            System.out.print(inputArray[i] + " ");
        }
        System.out.println(inputArray[inputArray.length - 1] + "]");
    }

    private void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    private void displaysNewLine() {
        System.out.println();
    }

    private int formsData(boolean isDataInSinglyLinkedList) {
        int data;
        if (isDataInSinglyLinkedList) {
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
        int data = myRandom.nextInt(-100, 101);
        int order = myRandom.nextInt(1, 4);
        for (int i = 0; i < myRandom.nextInt(5, 13); i++) {
            if (order == 1) {
                set.add(data++);
            } else if (order == 2) {
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    private void insertion() {
        displaysLine();
        System.out.println("============ Insertion ============");
        formsData();
        inputArray = new int[set.size()];
        System.out.println("Forming an Array with " + inputArray.length + " elements:");
        displaysNewLine();
        int i = 0;
        for (int data: set) {
            System.out.println(" * inserting " + data);
            inputArray[i++] = data;
        }
        displaysNewLine();
        displaysArray();
        displaysLine();
    }
    
    private void search() {
        System.out.println("============ Search ============");
        displaysArray();

        for (int i = 0; i < 2; i++) {
            ArrayList <Integer> elementsChecked = new ArrayList <> ();
            boolean isKeyFound = false;
            int key;
            if (i == 0) {
                key = formsData(true);
            } else {
                 key = formsData(false);
            }
            for (int j = 0; j < inputArray.length; j++) {
                elementsChecked.add(inputArray[j]);
                if (key == inputArray[j]) {
                    isKeyFound = true;
                    break;
                }
            }
            displaysNewLine();
            if (isKeyFound) {
                System.out.print(" * " + key + " is in array");
            } else {
                System.out.print(" * " + key + " is not in array");
            }
            System.out.println(", number of checks: " + elementsChecked.size() + ", elements checked: " + elementsChecked);
        }
        displaysNewLine();

        int maximum = inputArray[0];
        int minimum = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maximum) {
                maximum = inputArray[i];
            }
            if (inputArray[i] < minimum) {
                minimum = inputArray[i];
            }
        }
        System.out.println(" * " + "Maximum: " + maximum);
        displaysNewLine();
        System.out.println(" * " + "Miniimum: " + minimum);
        displaysLine();
    }

    private void run() {
        insertion();
        search();
        deletion();
    }

    public static void main(String[] args) {
        Array obj = new Array();
        obj.run();
    }
}
