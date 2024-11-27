// Node class
class AVLNode {
    int val;
    int height;
    AVLNode left, right;

    AVLNode(int val) {
        this.val = val;
        height = 1;
    }
}

// AVL Tree class
public class AVLTree {
    public AVLNode root;

    // Get the height of a node
    public int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    // Calculate the balance factor
    public int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Right rotate subtree rooted with y
    public AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate subtree rooted with x
    public AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a val into the AVL tree
    public AVLNode insert(AVLNode node, int val) {
        // Perform normal BST insertion
        if (node == null)
            return new AVLNode(val);

        if (val < node.val)
            node.left = insert(node.left, val);
        else if (val > node.val)
            node.right = insert(node.right, val);
        else
            return node; // Duplicate vals not allowed

        // Update the height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor
        int balance = getBalance(node);

        // If the node becomes unbalanced, there are 4 cases:

        // Left Left Case
        if (balance > 1 && val < node.left.val)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && val > node.right.val)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && val > node.left.val) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && val < node.right.val) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Public method to insert a val
    public void insert(int val) {
        root = insert(root, val);
    }

    // Delete a node
    public AVLNode deleteNode(AVLNode root, int key) {
        // Perform standard BST delete
        if (root == null)
            return root;

        if (key < root.val)
            root.left = deleteNode(root.left, key);
        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                AVLNode temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    root = null;
                } else {
                    // One child case
                    root = temp;
                }
            } else {
                // Node with two children: Get the inorder successor
                AVLNode temp = minValueNode(root.right);

                // Copy the inorder successor's value to this node
                root.val = temp.val;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.val);
            }
        }

        // If the tree has only one node, return it
        if (root == null)
            return root;

        // Update height of the current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor
        int balance = getBalance(root);

        // Balance the node if it has become unbalanced
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Public method to delete a key
    public void delete(int key) {
        root = deleteNode(root, key);
    }

    // Get the node with the smallest value (used in deletion)
    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    // Search for a value
    public boolean search(int key) {
        return searchNode(root, key) != null;
    }

    private AVLNode searchNode(AVLNode node, int key) {
        if (node == null || node.val == key)
            return node;

        if (key < node.val)
            return searchNode(node.left, key);

        return searchNode(node.right, key);
    }

    // Preorder traversal
    public void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Wrapper for preorder traversal
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    // Inorder traversal
    public void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    // Wrapper for inorder traversal
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        // Smaple input -> 30, 20, 40, 10, 25, 35, 50, 5
        // Insert elements
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        // Print preorder traversal
        System.out.println("Preorder traversal of AVL tree:");
        tree.preOrder();

        // Print inorder traversal
        System.out.println("Inorder traversal of AVL tree:");
        tree.inOrder();

        // Delete an element
        System.out.println("Deleting 40...");
        tree.delete(40);

        // Print traversals after deletion
        System.out.println("Preorder traversal after deletion:");
        tree.preOrder();

        System.out.println("Inorder traversal after deletion:");
        tree.inOrder();

        // Search for elements
        System.out.println("Searching for 50: " + tree.search(50));
        System.out.println("Searching for 40: " + tree.search(40));
    }
}
