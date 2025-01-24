import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3}; // Input array
        Stack<Integer> s = new Stack<>(); // Stack to store indices of array elements
        int[] nextGreater = new int[arr.length]; // Array to store results (Next Greater Elements)

        /*
        ===================================================
        Concepts Used:
        1. Monotonic Stack:
           - The stack maintains indices of array elements in a way 
             that we can efficiently find the next greater element.
           - In this case, the stack is monotonic (decreasing).

        2. Reverse Traversal:
           - To find the next greater element to the right, we traverse
             the array from right to left so that we can use the stack
             effectively.

        Time Complexity:
        - Outer loop: O(n) for n elements in the array.
        - Inner loop: Each element is pushed and popped once, O(n).
        - Total Time Complexity: O(n).

        Space Complexity:
        - O(n) for the stack to store indices.

        Steps to Solve:
        1. Traverse the array from right to left.
        2. Use a stack to keep track of the indices of elements.
        3. Pop elements from the stack if they are smaller or equal to
           the current element (as they cannot be the next greater element).
        4. If the stack is empty after popping, there is no greater element,
           so set the result to -1. Otherwise, the top of the stack gives
           the next greater element.
        5. Push the current element's index onto the stack for future comparisons.
        6. After processing all elements, the result array contains the next 
           greater elements for all indices.

        ===================================================
        */

        // Traverse the array from right to left
        for (int i = arr.length - 1; i >= 0; i--) {
            // Remove all elements smaller than or equal to the current element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop(); // These elements cannot be the next greater for arr[i]
            }

            // If the stack is empty, there is no greater element
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                // Top of the stack gives the next greater element
                nextGreater[i] = arr[s.peek()];
            }

            // Push the current element's index onto the stack
            s.push(i);
        }

        // Print the result array
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }

        /*
        ===================================================
        Variations of This Problem:
        
        1. Next Greater to the Left:
           - Traverse the array from left to right.
           - Use the same logic but maintain a stack of elements seen so far.

        2. Next Smaller to the Right:
           - Change the comparison in the while loop to `>=` instead of `<=`.
           - This finds the next smaller element to the right.

        3. Next Smaller to the Left:
           - Combine logic from "Next Greater to the Left" and 
             "Next Smaller to the Right".

        Example Logic for Next Smaller to the Right:
           while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
               s.pop(); // Remove elements larger than or equal to the current element
           }

           if (s.isEmpty()) {
               nextSmaller[i] = -1; // No smaller element
           } else {
               nextSmaller[i] = arr[s.peek()]; // Top of the stack is the next smaller element
           }

        ===================================================
        */
    }
}
