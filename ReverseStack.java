import java.util.Stack;

public class ReverseStack {

    /*
    ===================================================
    Concepts Used:
    1. Recursion:
       - Recursion is used to reverse the stack by breaking the problem
         into smaller subproblems (removing the top element and reversing
         the rest of the stack).

    2. Auxiliary Function (pushAtBottom):
       - An auxiliary function is used to insert an element at the bottom
         of the stack after all elements are popped recursively.

    Time Complexity:
    - `reverseStack`:
       * For each element, we recursively call `pushAtBottom`, which itself
         takes O(n) time in the worst case (n = stack size).
       * Total time complexity: O(n^2) for reversing the stack.
    - `printStack`: O(n).

    Space Complexity:
    - The recursion stack takes O(n) space for `reverseStack` as it
      stores up to `n` recursive calls at a time.

    Steps to Solve:
    1. Use recursion to remove the top element of the stack and reverse
       the remaining stack.
    2. Once the stack is empty, start adding the elements back, but at
       the bottom instead of the top using `pushAtBottom`.
    3. The final result is the reversed stack.

    ===================================================
    */

    // Function to push an element to the bottom of the stack
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            // Base case: If the stack is empty, push the element directly
            stack.push(data);
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively push the data at the bottom
        pushAtBottom(stack, data);

        // Step 3: Push the top element back after recursion completes
        stack.push(top);
    }

    // Function to reverse the stack using recursion
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            // Base case: If the stack is empty, return
            return;
        }

        // Step 1: Pop the top element
        int top = stack.pop();

        // Step 2: Recursively reverse the remaining stack
        reverseStack(stack);

        // Step 3: Push the popped element at the bottom
        pushAtBottom(stack, top);
    }

    // Function to print the stack
    public static void printStack(Stack<Integer> stack) {
        // Iterate through the stack and print elements
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a stack and push elements into it
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Original Stack: ");
        printStack(stack); // Print the original stack

        // Reverse the stack
        reverseStack(stack);

        System.out.print("Reversed Stack: ");
        printStack(stack); // Print the reversed stack

        /*
        ===================================================
        Dry Run Example:

        Original Stack: [1, 2, 3]
        Recursion Steps:
        - reverseStack([1, 2, 3]) -> top = 3, reverseStack([1, 2])
        - reverseStack([1, 2]) -> top = 2, reverseStack([1])
        - reverseStack([1]) -> top = 1, reverseStack([])
        - Base case: stack is empty, return.

        Reconstructing Stack:
        - pushAtBottom([], 1) -> [1]
        - pushAtBottom([1], 2) -> [2, 1]
        - pushAtBottom([2, 1], 3) -> [3, 2, 1]

        Output:
        Original Stack: 1 2 3 
        Reversed Stack: 3 2 1 
        ===================================================
        */
    }
}
