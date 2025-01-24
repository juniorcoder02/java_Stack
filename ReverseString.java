import java.util.Stack;

public class ReverseString {

    /**
     * Reverses a given string using a stack.
     * 
     * @param str The input string to be reversed.
     * @return The reversed string.
     */
    public static String reverseString(String str) {
        // Create a stack to hold characters of the string
        Stack<Character> s = new Stack<>();

        // Push each character of the string onto the stack
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx)); // Push the character at the current index
            idx++;                   // Move to the next character
        }

        // Use a StringBuilder to construct the reversed string
        StringBuilder sb = new StringBuilder("");

        // Pop characters from the stack and append them to the StringBuilder
        while (!s.isEmpty()) {
            char current = s.pop();  // Remove the top character from the stack
            sb.append(current);      // Append the character to the result
        }

        // Convert the StringBuilder to a String and return it
        return sb.toString();
    }

    public static void main(String[] args) {
        // Input string
        String str = "Hello";

        // Call the reverseString function to reverse the string
        String result = reverseString(str);

        // Print the reversed string
        System.out.println(result); // Output: "olleH"
    }
}
