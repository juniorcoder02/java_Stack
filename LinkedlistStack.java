public class LinkedlistStack {

    // Define a Node class to represent each element in the stack
    static class Node {
        int data; // The value of the node
        Node next; // Pointer to the next node

        // Constructor to initialize a new node with the given data
        Node(int data) {
            this.data = data;
            this.next = null; // Next is set to null initially
        }
    }

    // Define a Stack class that uses the Node class to implement the stack
    static class Stack {
        // The head node represents the top of the stack
        static Node head = null;

        // Function to check if the stack is empty
        public static boolean isEmpty() {
            return head == null; // If head is null, the stack is empty
        }

        // Function to push (add) an element onto the stack
        public static void push(int data) {
            // Create a new node with the given data
            Node newNode = new Node(data);
            
            // If the stack is empty, set the head to the new node
            if (isEmpty()) {
                head = newNode;
                return;
            }

            // If the stack is not empty, point the new node to the current head
            newNode.next = head;

            // Update the head to the new node (newNode becomes the top of the stack)
            head = newNode;
        }

        // Function to pop (remove) the top element from the stack
        public static int pop() {
            // Check if the stack is empty
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // Return -1 if no element exists
            } else {
                // Store the top element's data
                int top = head.data;

                // Update the head to the next node (removing the current top)
                head = head.next;

                // Return the data of the removed node
                return top;
            }
        }

        // Function to peek (view) the top element of the stack without removing it
        public static int peek() {
            // Check if the stack is empty
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1; // Return -1 if no element exists
            } else {
                // Return the data of the top element (head node)
                return head.data;
            }
        }
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        // Create an instance of the Stack class
        Stack st = new Stack();

        // Push elements onto the stack
        st.push(1); // Push 1 onto the stack
        st.push(2); // Push 2 onto the stack
        st.push(3); // Push 3 onto the stack

        // Pop elements from the stack and print them
        while (!st.isEmpty()) {
            System.out.println(st.pop()); // Print and remove the top element
        }
    }
}
