// Node class
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    // Insert at the beginning
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
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
            if (temp == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at the beginning
    public void deleteAtBegin() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;
    }

    // Delete at the end
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete at a specific position (0-based index)
    public void deleteAtPosition(int position) {
        if (position == 0) {
            deleteAtBegin();
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search for a value in the list
    public boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert at beginning, end, and specific positions
        list.insertAtBegin(10);
        list.insertAtEnd(20);
        list.insertAtPosition(15, 1); // Insert 15 at index 1

        System.out.println("List after insertions:");
        list.display();

        // Delete at beginning, end, and specific positions
        list.deleteAtBegin();
        System.out.println("\nList after deleting at the beginning:");
        list.display();

        list.deleteAtEnd();
        System.out.println("\nList after deleting at the end:");
        list.display();

        list.deleteAtPosition(0); // Delete at index 0
        System.out.println("\nList after deleting at position 0:");
        list.display();

        // Searching for a value
        System.out.println("\nSearching for 15:");
        System.out.println(list.search(15) ? "Found" : "Not Found");
    }
}
