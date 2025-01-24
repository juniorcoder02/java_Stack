import java.util.Stack;

public class StockSpanProblem {

    // Function to calculate span values of all stocks
    public static void stockSpan(int[] stocks, int[] span) {
        /*
        ===================================================
        Concepts Used:
        1. Monotonic Stack:
           - The stack is used to keep track of indices of stock prices.
           - It maintains a decreasing order of stock prices to help 
             calculate the span efficiently.

        2. Stock Span:
           - The stock span of a day is defined as the number of consecutive
             days before that day, including the current day, for which 
             the stock price was less than or equal to the current price.

        Time Complexity:
        - Outer loop: O(n) for traversing all elements.
        - Inner loop: Each element is pushed and popped from the stack once, O(n).
        - Total Time Complexity: O(n).

        Space Complexity:
        - O(n) for the stack to store indices.

        Steps to Solve:
        1. For the first day, the span is always 1 (no previous days to compare).
        2. Traverse the array from left to right:
           a) Use the stack to remove all indices of prices smaller than 
              the current price.
           b) If the stack becomes empty, all previous prices are smaller, 
              so the span is the current index + 1.
           c) Otherwise, the span is the difference between the current index
              and the index of the last higher price (top of the stack).
        3. Push the current index onto the stack for future comparisons.

        ===================================================
        */

        Stack<Integer> s = new Stack<>(); // Stack to store indices of stock prices
        span[0] = 1; // The span for the first stock is always 1
        s.push(0); // Push the index of the first stock onto the stack

        // Traverse the stock prices from the second day onward
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            // Remove indices of all prices smaller than or equal to the current price
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            // Calculate span for the current day
            if (s.isEmpty()) {
                // If the stack is empty, all previous prices are smaller
                span[i] = i + 1;
            } else {
                // Otherwise, calculate span as the difference between current 
                // index and the index of the last higher price
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            // Push the current index onto the stack
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {100, 80, 60, 70, 60, 85, 100}; // Input array of stock prices
        int[] span = new int[stocks.length]; // Array to store span results

        // Call the function to calculate spans
        stockSpan(stocks, span);

        // Print the result array
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }

        /*
        ===================================================
        Example Dry Run:

        Input: {100, 80, 60, 70, 60, 85, 100}
        Span Calculation:
        Day 0: Span = 1 (No previous prices)
        Day 1: Span = 1 (80 < 100)
        Day 2: Span = 1 (60 < 80)
        Day 3: Span = 2 (70 > 60, but < 80)
        Day 4: Span = 1 (60 < 70)
        Day 5: Span = 5 (85 > all previous)
        Day 6: Span = 7 (100 > all previous)

        Output: 1 1 1 2 1 5 7

        ===================================================
        Variations of This Problem:
        1. Stock Span for Decreasing Prices:
           - Reverse the condition to find the longest decreasing span.
        2. Maximum Profit by Buying/Selling:
           - Use similar logic to calculate the maximum profit by storing 
             minimum and maximum prices dynamically.

        ===================================================
        */
    }
}
