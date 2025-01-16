public class QueueArrayBased {
    private int[] queue;   // Array to store queue elements
    private int front;     // Index of the front element
    private int rear;      // Index of the rear element
    private int size;      // Current size of the queue
    private int capacity;  // Current capacity of the queue

    // Constructor to initialize the queue
    public QueueArrayBased(int initialCapacity) {
        this.capacity = initialCapacity;
        queue = new int[initialCapacity];
        front = 0;       // Front starts at index 0
        rear = -1;       // Rear starts at -1, as the queue is empty
        size = 0;        // Initially, the queue is empty
    }

    // Enqueue operation: Adds an element to the rear of the queue
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow! Increasing queue size...");
            resize(); // Resize the queue array
        }
        rear = (rear + 1) % capacity; // Circular increment for rear
        queue[rear] = data;
        size++;
    }

    // Resize the queue when it overflows
    private void resize() {
        int newCapacity = capacity * 2; // Double the size of the queue
        int[] newQueue = new int[newCapacity];

        // Copy elements from the old queue to the new queue in correct order
        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % capacity];
        }

        queue = newQueue;  // Update the queue reference
        front = 0;         // Reset front to 0
        rear = size - 1;   // Reset rear to the last valid index
        capacity = newCapacity;
    }

    // Dequeue operation: Removes and returns the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return -1; // Return -1 to indicate the queue is empty
        }
        int data = queue[front];
        front = (front + 1) % capacity; // Circular increment for front
        size--;
        return data;
    }

    // Peek operation: Returns the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot peek.");
            return -1; // Return -1 to indicate the queue is empty
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the current size of the queue
    public int size() {
        return size;
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements (front to rear):");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueArrayBased queue = new QueueArrayBased(3); // Create a queue with an initial capacity of 3

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue after enqueuing elements:");
        queue.display();

        // Enqueue more elements to trigger resizing
        queue.enqueue(40); // This will trigger resizing
        queue.enqueue(50);

        System.out.println("\nQueue after enqueuing more elements (after resizing):");
        queue.display();

        // Dequeue an element from the queue
        System.out.println("\nDequeued element: " + queue.dequeue());
        System.out.println("Queue after dequeuing an element:");
        queue.display();

        // Peek the front element
        System.out.println("\nPeek front element: " + queue.peek());

        // Get the size of the queue
        System.out.println("\nSize of the queue: " + queue.size());
    }
}
