import java.util.Stack;

public class ValidParentheses {

    /**
     * Approach:
     * - Use a Stack to keep track of opening brackets ('(', '{', '[').
     * - Traverse through the string character by character.
     * - Push opening brackets onto the stack.
     * - When encountering a closing bracket, check the stack:
     *   - If the stack is empty, the string is invalid (no matching opening bracket).
     *   - If the top of the stack contains a matching opening bracket, pop it.
     *   - Otherwise, the string is invalid.
     * - After traversing the string, check if the stack is empty:
     *   - If empty, the string is valid (all brackets matched).
     *   - Otherwise, the string is invalid.
     *
     * Time Complexity: O(n), where n is the length of the string.
     * - Each character is pushed and popped from the stack at most once.
     *
     * Space Complexity: O(n), in the worst case when all characters are opening brackets.
     */

    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>(); // Stack to store opening brackets.

        // Traverse each character in the string.
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // If the character is an opening bracket, push it onto the stack.
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If the stack is empty, no matching opening bracket exists.
                if (stack.isEmpty()) {
                    return false;
                }

                // Check if the top of the stack matches the current closing bracket.
                char top = stack.peek();
                if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                    stack.pop(); // Pop the matching opening bracket.
                } else {
                    return false; // Mismatch found.
                }
            }
        }

        // If the stack is empty, all brackets were matched correctly.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "[{()}]"; // Example input string with valid brackets.
        System.out.println(isValid(str)); // Output: true
    }
}
