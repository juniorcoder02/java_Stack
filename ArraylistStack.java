import java.util.ArrayList;

public class ArraylistStack {

    // Define a stack class using an ArrayList
    public static class stack {
        // Use an ArrayList to store the stack elements
        ArrayList<Integer> stack = new ArrayList<>();

        // Check if the stack is empty
        public boolean isEmpty() {
            // If the size of the stack is 0, it's empty
            return stack.size() == 0;
        }

        // Push function to add an element to the stack
        public void push(int data) {
            // Add the element to the end of the ArrayList
            stack.add(data);
        }

        // Pop function to remove the top element from the stack
        public int pop() {
            // If the stack is empty, print a message and return -1
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            } else {
                // Get the last element of the ArrayList (top of the stack)
                int top = stack.get(stack.size() - 1);
                // Remove the last element by its index
                stack.remove(stack.size() - 1);
                // Return the removed element
                return top;
            }
        }

        // Peek function to view the top element of the stack without removing it
        public int peek() {
            // If the stack is empty, print a message and return -1
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            } else {
                // Return the last element of the ArrayList (top of the stack)
                return stack.get(stack.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the stack class
        stack st = new stack();

        // Push elements onto the stack
        st.push(1); // Push 1 onto the stack
        st.push(2); // Push 2 onto the stack
        st.push(3); // Push 3 onto the stack

        // Pop elements from the stack and print them
        while (!st.isEmpty()) {
            System.out.println(st.pop()); // Print and remove the top element
        }
    }
}
