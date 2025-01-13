// Node class for Singly Circular Linked List
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyCircularLinkedList {
    Node head;

    // Insert at the beginning
    public void insertAtBegin(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newNode.next = head;
            temp.next = newNode;
            head = newNode;
        }
    }

    // Insert at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
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
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
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

        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    // Delete at a specific position (0-based index)
    public void deleteAtPosition(int position) {
        if (position == 0) {
            deleteAtBegin();
            return;
        }

        Node temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp.next == head) {
                System.out.println("Position out of bounds.");
                return;
            }
            temp = temp.next;
        }

        if (temp.next == head) {
            System.out.println("Position out of bounds.");
            return;
        }

        temp.next = temp.next.next;
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
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        SinglyCircularLinkedList list = new SinglyCircularLinkedList();

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
