
import java.util.Random;
import java.util.Stack;

public class StackExample {

    private Random myRandom = new Random();
    // Forms stack from values user enters
    // Precon: no stack formed
    // Postcon: Stack of size >= 1 formed
    private Stack <Integer> formsStack() {
        displaysLine();
        Stack <Integer> myStack = new Stack <>();
        for (int i = 0; i < myRandom.nextInt(5, 12); i++) {
            myStack.push(myRandom.nextInt(-1000, 1000));
        }
        return myStack;
    }

    // Displays Line
    // Precon: Nil
    // Postcon: Nil
    private void displaysLine() {
        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
    }

    // Displays key stack operations
    // Precon: Stack of size >= 1 formed
    // Postcon: Apply some of these key operations on the stack
    private void displaysKeyStackOperations(Stack <Integer> myStack) {
        int i = 1;
        System.out.println("Stack: " + myStack);
        displaysLine();
        System.out.println("Stack operates on LIFO principle: Last In First Out.");
        System.out.println("Key stack operations: ");
        System.out.println(i++ + ". push(Element e): Pushes object/element into top of the stack");
        System.out.println(i++ + ". peek(): Retrieves, but does not remove, object/element at top of the stack");
        System.out.println(i++ + ". pop(): Removes the object at the top of the stack");
        System.out.println(i++ + ". isEmpty(): Returns true only if stack is empty, else return false");
        System.out.println(i++ + ". search(Element e): Returns 1-based position where object/object/element is on the stack, else return -1 if object not in stack");
        System.out.println(i++ + ". clear(): Removes all object/elements in stack");
        System.out.println(i++ + ". size(): Obtains number of object/elements in stack");
        System.out.println(i++ + ". get(int index): Retrieves object/element at position index. Note: Ensure index <= size of stack");
        System.out.println(i + ". contains(Element e): Returns true if stack contains specified object/object/element, else return false");
        displaysLine();
    }

    // Executes some operations on operations on stack
    // Precon: Method displaying key operations of stack displayed
    // Postcon: End of program
    private void executesKeyStackOperations(Stack <Integer> myStack) {
        int numberToFind = myRandom.nextInt(-1000, 1000);
        System.out.println("Apply some of operations on stack:");
        System.out.println("myStack: " + myStack);
        System.out.println("* peek(): Element at top of stack ----------> " + myStack.peek());
        System.out.println("* isEmpty(): Is the stack empty? ----------> " + myStack.isEmpty());
        System.out.println("* pop(): Removes top element in stack ----------> " + myStack.pop() + " | After pop(), myStack: " + myStack);
        System.out.println("* peek(): Top element in stack ----------> " + myStack.peek() + " | myStack: " + myStack);
        System.out.println("* contains(Element e): Does stack contain " +  numberToFind 
                            + "? --------------> " + myStack.contains(numberToFind) 
                            + " | myStack: " + myStack);
        System.out.println("* size(): Number of elements in stack ----------> " + myStack.size() + " | myStack: " + myStack);
        displaysLine();
    }
    
    private void run() {
        Stack <Integer> myStack = formsStack();
        displaysKeyStackOperations(myStack);
        executesKeyStackOperations(myStack);
    }
    public static void main(String[] args) {
        StackExample obj = new StackExample();
        obj.run();
    }
}
