// package Stack;

// Node class
class StackNode {
    int data;
    StackNode next;

    StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    private StackNode top; // Top of the stack
    private int size;      // Tracks the size of the stack

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1; // Return -1 to indicate the stack is empty
        }
        int poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }

    // Peek operation: Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1; // Return -1 to indicate the stack is empty
        }
        return top.data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        return size;
    }

    // Display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode temp = top;
        System.out.println("Stack elements (top to bottom):");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushing elements:");
        stack.display();

        // Peek the top element
        System.out.println("\nPeek top element: " + stack.peek());

        // Pop an element
        System.out.println("\nPopped element: " + stack.pop());
        System.out.println("Stack after popping an element:");
        stack.display();

        // Check if the stack is empty
        System.out.println("\nIs the stack empty? " + (stack.isEmpty() ? "Yes" : "No"));

        // Get the size of the stack
        System.out.println("Size of the stack: " + stack.size());

        // Pop all elements
        System.out.println("\nPopping all elements:");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        // Try popping from an empty stack
        System.out.println("\nTrying to pop from an empty stack:");
        stack.pop();
    }
}
