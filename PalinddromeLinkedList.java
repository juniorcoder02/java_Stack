import java.util.Stack;

class PalindromeLinkedList {
    // Node class representing a single node in the linked list
    static class Node {
        char data; // Character data in the node
        Node next; // Pointer to the next node

        // Constructor to initialize a new node
        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Function to check if a linked list is a palindrome.
     * Approach: Uses a stack to store the elements and then compares them.
     * Time Complexity: O(N)
     * Space Complexity: O(N) (Due to Stack usage)
     */
    static boolean isPalindrome(Node head) {
        Stack<Character> stack = new Stack<>(); // Stack to store characters
        Node temp = head;

        // Step 1: Traverse the linked list and push each character onto the stack
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        // Step 2: Reset temp pointer to the head
        temp = head;

        // Step 3: Compare elements from stack with the linked list
        while (temp != null) {
            if (temp.data != stack.pop()) { // If characters do not match, return false
                return false;
            }
            temp = temp.next;
        }

        return true; // If all characters matched, it's a palindrome
    }

    // Main function to test the palindrome function
    public static void main(String[] args) {
        // Creating a sample linked list: A -> B -> C -> B -> A
        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');

        // Check if the linked list is a palindrome
        if (isPalindrome(head)) {
            System.out.println("Yes, It is a Palindrome");
        } else {
            System.out.println("No, It is not a Palindrome");
        }
    }
}
