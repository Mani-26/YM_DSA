// package Queue;

// Node class
class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Queue {
    private QueueNode front; // Front of the queue
    private QueueNode rear;  // Rear of the queue
    private int size;        // Tracks the size of the queue

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Enqueue operation: Adds an element to the rear of the queue
    public void enqueue(int data) {
        QueueNode newNode = new QueueNode(data);

        if (rear == null) { // If the queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue operation: Removes and returns the front element of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1; // Return -1 to indicate the queue is empty
        }

        int dequeuedData = front.data;
        front = front.next;

        // If the queue becomes empty after dequeue, reset rear to null
        if (front == null) {
            rear = null;
        }
        size--;
        return dequeuedData;
    }

    // Peek operation: Returns the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek.");
            return -1; // Return -1 to indicate the queue is empty
        }
        return front.data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }

    // Display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        QueueNode temp = front;
        System.out.println("Queue elements (front to rear):");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue after enqueuing elements:");
        queue.display();

        // Peek the front element
        System.out.println("\nPeek front element: " + queue.peek());

        // Dequeue an element
        System.out.println("\nDequeued element: " + queue.dequeue());
        System.out.println("Queue after dequeuing an element:");
        queue.display();

        // Check if the queue is empty
        System.out.println("\nIs the queue empty? " + (queue.isEmpty() ? "Yes" : "No"));

        // Get the size of the queue
        System.out.println("Size of the queue: " + queue.size());

        // Dequeue all elements
        System.out.println("\nDequeuing all elements:");
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        // Try dequeuing from an empty queue
        System.out.println("\nTrying to dequeue from an empty queue:");
        queue.dequeue();
    }
}
