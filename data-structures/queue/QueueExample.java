import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class QueueExample {
    
    private Random myRandom = new Random();
    
    // Forms queue of N values from user
    // Precon: N > 0
    // Postcon: Queue of N values formed
    private Queue <Integer> formsQueue() {
        displaysLine();
        Queue <Integer> myQueue = new LinkedList <> ();
        for (int i = 0; i < myRandom.nextInt(5, 12); i++) {
            myQueue.offer(myRandom.nextInt(-1000, 1000));
        }
        return myQueue;
    }

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }
    
    // Displays key queue operations
    // Precon: myQueue has N values entered from user
    // Postcon: Execute these operations on queue
    private void displaysKeyQueueOperations(Queue <Integer> myQueue) {
        int i = 1;
        System.out.println("Queue: " + myQueue);
        displaysLine();
        System.out.println("Queue operates on FIFO principle: First In First Out.");
        System.out.println("Queue operations to remember: ");
        System.out.println(i++ + ". offer(element E): Inserts element into queue, or return null if queue is empty, without violating capacity restrictions");
        System.out.println(i++ + ". peek(): Retrieves, but does not remove, the head of queue, or return null if queue is empty");
        System.out.println(i++ + ". poll(): Retrieves and removes (dequeuing) head of queue, or return null if queue is empty");
        System.out.println(i++ + ". isEmpty(): Return true if no element in queue");
        System.out.println(i++ + ". clear(): Removes all elements in queue");
        System.out.println(i + ". size(): Returns number of elements in queue");
        displaysLine();
    }

    // Executes some operations on queue
    // Precon: Method displaying key operations of queue displayed
    // Postcon: End of program
    private void executesKeyQueueOperations(Queue <Integer> myQueue) {
        int numberToFind = myRandom.nextInt(-1000, 1000);
        System.out.println("Queue: " + myQueue);
        System.out.println("Apply some of operations on queue:");
        System.out.println("* peek(): Top element in queue ----------> " + myQueue.peek());
        System.out.println("* poll(): To remove ----------> " + myQueue.poll() + " | After poll(), queue: " + myQueue);
        System.out.println("* contains(Element e): Does queue contain " + numberToFind 
                            + "? ----------> " + myQueue.contains(numberToFind)
                            + " | myQueue: " + myQueue);
        System.out.println("* size(): Number of elements in myQueue ----------> " + myQueue.size() + " | myQueue: " + myQueue);
        displaysLine();
    }

    private void run() {
        Queue <Integer> myQueue = formsQueue();
        displaysKeyQueueOperations(myQueue);
        executesKeyQueueOperations(myQueue);
    }

    public static void main(String[] args) {
        QueueExample obj = new QueueExample();
        obj.run();
    }
}
