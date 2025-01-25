import java.util.Stack;

public class MaxAreaInHistogram {

    /**
     * Approach:
     * - Use two auxiliary arrays to store indices of the next smaller element to the right and to the left for each bar in the histogram.
     * - Traverse the histogram to fill these arrays using a Stack to maintain indices.
     * - Calculate the maximum area for each bar using the formula:
     *   area = height of the bar * width (where width is the difference between indices from the arrays).
     * - Keep track of the maximum area encountered.
     *
     * Time Complexity: O(n), where n is the number of bars in the histogram.
     * - Each element is pushed and popped from the stack at most once.
     *
     * Space Complexity: O(n), for the stack and the auxiliary arrays.
     */

    public static void maxArea(int[] arr) {
        int maxArea = 0;
        int[] nextSmallerRight = new int[arr.length];
        int[] nextSmallerLeft = new int[arr.length];

        // Calculate next smaller to the right
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmallerRight[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }

        // Calculate next smaller to the left
        stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextSmallerLeft[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Calculate the maximum area
        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currentArea = height * width;
            maxArea = Math.max(currentArea, maxArea);
        }

        System.out.println("Maximum area of histogram is: " + maxArea);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 }; // Example input: heights in histogram
        maxArea(arr); // Output: Maximum area of histogram is 10
    }
}
