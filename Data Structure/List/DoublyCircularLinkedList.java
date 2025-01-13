// Node class for Doubly Circular Linked List
class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyCircularLinkedList {
    Node head;

    // Insert at the beginning
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            head.prev = newNode;
            last.next = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node last = head.prev;
            last.next = newNode;
            newNode.prev = last;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Insert at a specific position (0-based index)
    public void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertAtBegin(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < position - 1; i++) {
            if (temp.next == head) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Delete at the beginning
    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node last = head.prev;
        head = head.next;
        head.prev = last;
        last.next = head;
    }

    // Delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node last = head.prev;
        last.prev.next = head;
        head.prev = last.prev;
    }

    // Delete at a specific position (0-based index)
    public void deleteAtPosition(int position) {
        if (position == 0) {
            deleteAtBegin();
            return;
        }

        Node temp = head;
        for (int i = 0; i < position; i++) {
            if (temp.next == head) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
    }

    // Search for a value in the list
    public boolean search(int value) {
        if (head == null) return false;

        Node temp = head;
        do {
            if (temp.data == value) return true;
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();

        // Insertions
        list.insertAtBegin(10);
        list.insertAtEnd(20);
        list.insertAtPosition(15, 1);

        System.out.println("List after insertions:");
        list.display();

        // Deletions
        list.deleteAtBegin();
        System.out.println("\nList after deleting at the beginning:");
        list.display();

        list.deleteAtEnd();
        System.out.println("\nList after deleting at the end:");
        list.display();

        list.deleteAtPosition(0);
        System.out.println("\nList after deleting at position 0:");
        list.display();

        // Searching
        System.out.println("\nSearching for 15:");
        System.out.println(list.search(15) ? "Found" : "Not Found");
    }
}
