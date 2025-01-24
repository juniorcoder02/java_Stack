import java.util.Stack;
public class CollectionsStack {
    public static void main(String[] args) {
        // Create a stack using the Stack class from the Java Collections framework
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(1); // Push 1 onto the stack
        stack.push(2); // Push 2 onto the stack
        stack.push(3); // Push 3 onto the stack

        // Pop elements from the stack and print them
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // Print and remove the top element
        }
    }
}
