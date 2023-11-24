import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class QueueExample {
    
    private Queue <Integer> myQueue = new LinkedList <> ();
    private Random myRandom = new Random();

    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
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

    private void displaysQueue(String message, boolean isDisplayNewLine, boolean isDisplayTwoNewLines, boolean isDisplayLine) {
        System.out.print(message + "Queue: " + myQueue);
        if (isDisplayNewLine) {
            displaysNewLine();
        }
        if (isDisplayTwoNewLines) {
            displaysTwoNewLines();
        }
        if (isDisplayLine) {
            displaysLine();
        }
    }

    private void displaysTwoNewLines() {
        System.out.println();
        System.out.println();
    }
    
    private void explanation() {
        displaysLine();
        displaysMessage("=========== Explanation ============", false, false);
        displaysMessage("Queue is a linear and dynamic data structure that operates on a FIFO principle: First In First Out", true, false);
        displaysMessage("Key Queue operations based on Java API: ", true, false);
        displaysMessage(" * offer(element E): Insert element into the queue, or return null if queue is empty, without violating capacity restrictions", true, false);
        displaysMessage(" * peek(): Retrieve, but does not remove, the head of queue, or return null if queue is empty", true, false);
        displaysMessage(" * poll(): Retrieve and remove (dequeuing) the head of queue, or return null if queue is empty", true, false);
        displaysMessage(" * isEmpty(): Return true if no element in the queue", true, false);
        displaysMessage(" * clear(): Remove all the elements in the queue", true, false);
        displaysMessage(" * size(): Return the total number of elements in the queue", false, true);
    }

    private int formsData(boolean isDataInQueue) {
        int data;
        if (isDataInQueue) {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (!myQueue.contains(data));
        } else {
            do {
                data = myRandom.nextInt(-100, 101);
            } while (myQueue.contains(data));
        }
        return data;
    } 
    
    private void insertion() {
        displaysMessage("=========== Insertion ============", false, false);
        int numberOfElements = myRandom.nextInt(5, 12);
        System.out.println("Forming a Queue with " + numberOfElements + " elements:");
        displaysNewLine();
        for (int i = 0; i < numberOfElements; i++) {
            int data = formsData(false);
            System.out.println(" * Inserting " + data);
            myQueue.offer(data);
        }
        displaysNewLine();
        displaysQueue("", true, false, true);
    }

    private void operations() {
        displaysMessage("=========== Operations ============", false, false);
        displaysQueue("", false, true, false);
        int key;

        displaysMessage((" * size(): " + myQueue.size()).toString(), true, false);
        displaysMessage((" * peek(): " + myQueue.peek()).toString(), true, false);

        key = formsData(true);
        displaysMessage((" * contains(" + key + "): " + myQueue.contains(key)).toString(), true, false);

        key = formsData(false);
        displaysMessage((" * contains(" + key + "): " + myQueue.contains(key)).toString(), true, false);

        myQueue.poll();
        displaysMessage((" * poll()\t| Queue: " + myQueue).toString(), true, false);

        int data = formsData(false);
        myQueue.offer(data);
        displaysMessage((" * offer(" + data + ")\t| Queue: " + myQueue).toString(), false, true);
    }

    private void search() {
        displaysMessage("=========== Search ============", false, false);
        displaysQueue("", true, false, false);
        int[] queueArray = new int[myQueue.size()];
        int i = 0;
        while (!myQueue.isEmpty()) {
            queueArray[i++] = myQueue.poll();
        }
        int maximum = 0;
        int minimum = 0;
        for (i = 0; i < queueArray.length; i++) {
            if (queueArray[i] > maximum) {
                maximum = queueArray[i];
            }
            if (queueArray[i] < minimum) {
                minimum = queueArray[i];
            }
        }
        displaysNewLine();
        displaysMessage((" * Maximum: " + maximum).toString(), true, false);
        displaysMessage((" * Minimum: " + minimum).toString(), false, true);
    }

    private void run() {
        explanation();
        insertion();
        operations();
        search();
    }

    public static void main(String[] args) {
        QueueExample obj = new QueueExample();
        obj.run();
    }
}
