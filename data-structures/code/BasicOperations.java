import java.util.HashSet;
import java.util.Random;

public class BasicOperations {
    protected HashSet<Integer> set = new HashSet<> ();
    protected Random myRandom = new Random();

    protected void displaysLine() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    protected void displaysNewLine() {
        System.out.println();
    }

    protected void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }

    protected int formsData(boolean isDataPresent) {
        int data;
        if (set.isEmpty()) {
            throw new IllegalStateException("Set is empty, cannot generate data.");
        }
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

    protected void formsData() {
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

    protected void formsData(int numberOfElements) {
        // Note that myRandom.nextInt(x, y) generates numbers in bound [x, y)
        // Hence, to generate a number that is inclusive of both x and y: myRandom.nextInt(x, y + 1)
        int data = myRandom.nextInt(-100, 101);
        int order = myRandom.nextInt(1, 4);
        for (int i = 0; i < numberOfElements; i++) {
            if (order == 1) {
                set.add(data++);
            } else if (order == 2) {
                set.add(data--);
            } else {
                set.add(formsData(false));
            }
        }
    }

    protected void displaysMessage(String message, boolean isDisplayNewLine, boolean isDisplayLine) {
        System.out.println(message);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

}
