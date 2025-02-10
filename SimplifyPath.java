import java.util.Stack;

class SimplifyPath {
    
    // Function to simplify the given absolute Unix-style path
    public static String simplifyPath(String path) {
        // Step 1: Create a stack to store valid directory names
        Stack<String> stack = new Stack<>();
        
        // Step 2: Split the path by "/" to get each part
        String[] parts = path.split("/");

        // Step 3: Process each part of the split path
        for (String part : parts) {
            if (part.equals("..")) {
                // ".." means go up one directory, so pop from the stack if it's not empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.equals("") && !part.equals(".")) {
                // Ignore empty strings (extra slashes) and "." (current directory)
                // Push valid directory names onto the stack
                stack.push(part);
            }
        }

        // Step 4: Construct the simplified path from the stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If the stack is empty, return root "/"
        return result.length() == 0 ? "/" : result.toString();
    }

    // Driver code to test the function
    public static void main(String[] args) {
        // Test cases
        System.out.println(simplifyPath("/apnacollege/"));    // Output: "/apnacollege"
        System.out.println(simplifyPath("/a/.."));           // Output: "/"
        System.out.println(simplifyPath("/a/b/../c/./d//")); // Output: "/a/c/d"
        System.out.println(simplifyPath("//////a//b//c///")); // Output: "/a/b/c"
        System.out.println(simplifyPath("/../"));            // Output: "/"
    }
}

