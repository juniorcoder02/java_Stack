import java.util.Stack;

class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();  // Stores numbers (repetition count)
        Stack<StringBuilder> stringStack = new Stack<>();  // Stores partial results
        StringBuilder currentString = new StringBuilder();  // Holds current decoded part
        int count = 0; // Stores the current number before encountering `[`
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the number for multi-digit cases (e.g., "10[a]")
                count = count * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the count and currentString to their stacks before processing new content
                countStack.push(count);
                stringStack.push(currentString);
                // Reset for new sequence
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                // When we encounter ']', we pop and decode the sequence
                int repeatTimes = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                
                // Repeat the currentString `repeatTimes` times and append to previous part
                while (repeatTimes-- > 0) {
                    decodedString.append(currentString);
                }
                // Assign the updated decoded string to `currentString`
                currentString = decodedString;
            } else {
                // Normal character, append to current string
                currentString.append(ch);
            }
        }
        
        return currentString.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(decodeString("2[cv]"));      // Output: "cvcv"
        System.out.println(decodeString("3[b2[v]]L")); // Output: "bvvbvvbvvL"
        System.out.println(decodeString("10[a]"));     // Output: "aaaaaaaaaa"
        System.out.println(decodeString("2[ab3[c]]")); // Output: "abcccabccc"
    }
}
