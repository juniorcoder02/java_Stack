import java.util.Stack;

public class PushAtTheBottom {

    /**
     * Push a value at the bottom of the stack using recursion.
     * Time complexity: O(n) - where 'n' is the number of elements in the stack.
     *
     * @param s    The stack where the value will be inserted.
     * @param data The value to be inserted at the bottom.
     */
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // Base case: If the stack is empty, push the value and return
        if (s.isEmpty()) {
            s.push(data); // Insert the value at the bottom
            return;       // End the recursion
        }

        // Recursive case: Remove the top element and process the rest of the stack
        int top = s.pop();          // Temporarily store the top element
        pushAtBottom(s, data);      // Recursively call the function to reach the bottom
        s.push(top);                // Push the stored element back onto the stack
    }

    public static void main(String[] args) {
        // Create a stack and push elements into it
        Stack<Integer> s = new Stack<>();
        s.push(1); // Stack: [1]
        s.push(2); // Stack: [1, 2]
        s.push(3); // Stack: [1, 2, 3]

        // Call the pushAtBottom function to insert 4 at the bottom of the stack
        pushAtBottom(s, 4); // Final stack after operation: [4, 1, 2, 3]

        // Pop and print elements from the stack to verify the order
        while (!s.isEmpty()) {
            System.out.println(s.pop()); // Output: 3, 2, 1, 4 (top to bottom)
        }
    }
}
