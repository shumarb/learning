import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class QueueExample {
    
    private Queue <Integer> myQueue = new LinkedList <> ();
    private Random myRandom = new Random();

    // Forms queue of N values from user
    // Precon: N > 0
    // Postcon: Queue of N values formed
    private void formsQueue() {
        displaysLine();
        for (int i = 0; i < myRandom.nextInt(5, 12); i++) {
            myQueue.offer(myRandom.nextInt(-1000, 1000));
        }
    }

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays new line
    // Precon: Nil
    // Postcon: Nil
    private void displaysNewLine() {
        System.out.println();
    }
    
    // Displays key queue operations
    // Precon: myQueue has N values entered from user
    // Postcon: Execute these operations on queue
    private void explainsQueue() {
        displaysLine();
        System.out.println("=========== What is a Queue? ============");
        System.out.println("Queue is a data structure operating on a FIFO principle: First In First Out.");
        displaysNewLine();

        int i = 1;
        System.out.println("Key Queue operations: ");
        System.out.println(" " + i++ + ". offer(element E): Insert element into the queue, or return null if queue is empty, without violating capacity restrictions");
        System.out.println(" " + i++ + ". peek(): Retrieve, but does not remove, the head of queue, or return null if queue is empty");
        System.out.println(" " + i++ + ". poll(): Retrieve and remove (dequeuing) the head of queue, or return null if queue is empty");
        System.out.println(" " + i++ + ". isEmpty(): Return true if no element in the queue");
        System.out.println(" " + i++ + ". clear(): Remove all the elements in the queue");
        System.out.println(" " + i + ". size(): Return the total number of elements in the queue");
        displaysLine();
    }

    // Executes some operations on queue
    // Precon: Method displaying key operations of queue displayed
    // Postcon: End of program
    private void executesKeyQueueOperations() {
        int numberToFind = myRandom.nextInt(-1000, 1000);
        System.out.println("Queue: " + myQueue);
        displaysNewLine();
        System.out.println("Apply some key operations on queue:");
        System.out.println(" * peek(): Top element in the queue ----------> " + myQueue.peek());
        System.out.println(" * poll(): To remove ----------> " + myQueue.poll() + " | After poll(), queue: " + myQueue);
        System.out.println(" * contains(Element e): Does queue contain " + numberToFind 
                            + "? ----------> " + myQueue.contains(numberToFind)
        );
        System.out.println(" * size(): Number of elements in myQueue ----------> " + myQueue.size());
        displaysLine();
    }

    private void run() {
        formsQueue();
        explainsQueue();
        executesKeyQueueOperations();
    }

    public static void main(String[] args) {
        QueueExample obj = new QueueExample();
        obj.run();
    }
}
