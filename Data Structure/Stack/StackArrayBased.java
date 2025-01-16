// package Stack;

public class StackArrayBased {
    private int[] stack;   // Array to store stack elements
    private int top;       // Tracks the top of the stack
    private int capacity;  // Current capacity of the stack

    // Constructor to initialize the stack
    public StackArrayBased(int initialCapacity) {
        this.capacity = initialCapacity;
        stack = new int[initialCapacity];
        top = -1; // Indicates an empty stack
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow! Increasing stack size...");
            resize(); // Resize the stack array
        }
        stack[++top] = data;
    }

    // Resize the stack when it overflows
    private void resize() {
        int newCapacity = capacity * 2; // Double the size of the stack
        int[] newStack = new int[newCapacity];

        // Copy elements from the old stack to the new stack
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;  // Update the stack reference
        capacity = newCapacity;
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop.");
            return -1; // Return -1 to indicate the stack is empty
        }
        return stack[top--];
    }

    // Peek operation: Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return -1; // Return -1 to indicate the stack is empty
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the current size of the stack
    public int size() {
        return top + 1;
    }

    // Display the stack elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.println("Stack elements (top to bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    public static void main(String[] args) {
        StackArrayBased stack = new StackArrayBased(3); // Create a stack with an initial capacity of 3

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack after pushing elements:");
        stack.display();

        // Push more elements to trigger resizing
        stack.push(40); // This will trigger resizing
        stack.push(50);

        System.out.println("\nStack after pushing more elements (after resizing):");
        stack.display();

        // Pop an element from the stack
        System.out.println("\nPopped element: " + stack.pop());
        System.out.println("Stack after popping an element:");
        stack.display();

        // Peek the top element
        System.out.println("\nPeek top element: " + stack.peek());

        // Get the size of the stack
        System.out.println("\nSize of the stack: " + stack.size());
    }
}
