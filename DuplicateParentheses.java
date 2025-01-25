import java.util.*;

public class DuplicateParentheses {

    /**
     * Approach:
     * - Use a Stack to keep track of characters in the expression.
     * - Traverse the string character by character.
     * - If a closing parenthesis ')' is encountered:
     *   - Pop elements from the stack until an opening parenthesis '(' is found.
     *   - Count the number of characters popped.
     *   - If fewer than 1 character is popped, it means there are duplicate parentheses.
     * - Otherwise, push the current character onto the stack.
     * - After traversal, if no duplicate parentheses are found, return false.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * - Each character is pushed and popped from the stack at most once.
     *
     * Space Complexity: O(n), in the worst case when all characters are pushed onto the stack.
     */

    public static boolean checkDuplicateParentheses(String str) {
        Stack<Character> stack = new Stack<>(); // Stack to store characters.

        // Traverse each character in the string.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If the character is a closing parenthesis.
            if (ch == ')') {
                int count = 0;

                // Pop elements until an opening parenthesis is found.
                while (!stack.isEmpty() && stack.peek() != '(') {
                    count++;
                    stack.pop();
                }

                // If fewer than 1 character was inside the parentheses, it's a duplicate.
                if (count < 1) {
                    return true;
                } else {
                    stack.pop(); // Pop the opening parenthesis.
                }
            } else {
                stack.push(ch); // Push current character onto the stack.
            }
        }

        // If no duplicates found, return false.
        return false;
    }

    public static void main(String[] args) {
        String str1 = "((a+b))"; // Example input with duplicate parentheses, should return true.
        String str2 = "(a-b)";   // Example input without duplicate parentheses, should return false.

        System.out.println(checkDuplicateParentheses(str1)); // Output: true
        System.out.println(checkDuplicateParentheses(str2)); // Output: false
    }
}
