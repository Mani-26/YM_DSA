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
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

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
    }
}