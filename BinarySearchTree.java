import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Definition of Node for Binary Search Tree
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {

    // To insert data in BST, returns the root of the tree
    Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data); // Empty tree, create new node
        }
        if (data <= root.data) {
            root.left = insert(root.left, data); // Insert in left subtree
        } else {
            root.right = insert(root.right, data); // Insert in right subtree
        }
        return root;
    }

    // To search an element in BST, returns true if element is found
    boolean search(Node root, int searchData) {
        if (root == null) {
            return false; // Not found
        } else if (root.data == searchData) {
            return true; // Found
        } else if (searchData < root.data) {
            return search(root.left, searchData); // Search in left subtree
        } else {
            return search(root.right, searchData); // Search in right subtree
        }
    }

    // Function to find the minimum value node in a tree
    Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Function to delete a node from the BST
    Node delete(Node root, int data) {
        if (root == null) {
            return root; // Tree is empty
        }
        if (data < root.data) {
            root.left = delete(root.left, data); // Traverse to left
        } else if (data > root.data) {
            root.right = delete(root.right, data); // Traverse to right
        } else {
            // Node to be deleted found

            // Case 1: No child
            if (root.left == null && root.right == null) {
                root = null;
            }
            // Case 2: One child
            else if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            }
            // Case 3: Two children
            else {
                Node temp = findMin(root.right); // Find inorder successor
                root.data = temp.data; // Replace data
                root.right = delete(root.right, temp.data); // Delete successor
            }
        }
        return root;
    }

    // Breadth-First Search (Level-order Traversal)
    void bfs(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // Depth-First Search - Iterative using Stack
    void dfsIterative(Node root) {
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.data + " ");

            // Push right child first to process left child first
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    // Depth-First Search - Recursive (Preorder Traversal)
    void dfsRecursive(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        dfsRecursive(node.left);
        dfsRecursive(node.right);
    }


    // In-order traversal: Left, Root, Right
    void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Pre-order traversal: Root, Left, Right
    void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Post-order traversal: Left, Right, Root
    void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = null; // Creating an empty tree

        // Insert nodes into BST
        root = bst.insert(root, 15);
        root = bst.insert(root, 10);
        root = bst.insert(root, 20);
        root = bst.insert(root, 25);
        root = bst.insert(root, 8);
        root = bst.insert(root, 12);

        Scanner scanner = new Scanner(System.in);

        // Search a number in BST
        System.out.println("Enter number to be searched:");
        int number = scanner.nextInt();
        if (bst.search(root, number)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }

         // Perform BFS
         System.out.print("Breadth-First Search (BFS): ");
         bst.bfs(root);
         System.out.println();
 
         // Perform DFS Iterative
         System.out.print("Depth-First Search (DFS) - Iterative: ");
         bst.dfsIterative(root);
         System.out.println();
 
         // Perform DFS Recursive
         System.out.print("Depth-First Search (DFS) - Recursive: ");
         bst.dfsRecursive(root);
         System.out.println();

         
        // Delete a number from BST
        System.out.println("Enter number to be deleted:");
        number = scanner.nextInt();
        root = bst.delete(root, number);

        // Perform Traversals
        System.out.print("In-order Traversal: ");
        bst.inOrder(root);
        System.out.println();

        System.out.print("Pre-order Traversal: ");
        bst.preOrder(root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        bst.postOrder(root);
        System.out.println();

        scanner.close();
    }
}
