// Node class for the Red-Black Tree
class RBTNode {
    int data;
    RBTNode parent;
    RBTNode left;
    RBTNode right;
    boolean isRed; // True if the node is red, false if black

    public RBTNode(int data) {
        this.data = data;
        this.isRed = true; // New nodes are always red initially
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}

// Red-Black Tree class
public class RedBlackTree {
    private RBTNode root;
    private final RBTNode TNULL; // Sentinel for leaves

    // Constructor
    public RedBlackTree() {
        TNULL = new RBTNode(0);
        TNULL.isRed = false; // TNULL is black
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Search method
    public RBTNode search(int key) {
        return searchTreeHelper(root, key);
    }

    private RBTNode searchTreeHelper(RBTNode node, int key) {
        if (node == TNULL || key == node.data) {
            return node;
        }
        if (key < node.data) {
            return searchTreeHelper(node.left, key);
        }
        return searchTreeHelper(node.right, key);
    }

    // Insert method
    public void insert(int key) {
        RBTNode node = new RBTNode(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.isRed = true;

        RBTNode parent = null;
        RBTNode current = root;

        while (current != TNULL) {
            parent = current;
            if (node.data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        node.parent = parent;
        if (parent == null) {
            root = node;
        } else if (node.data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        if (node.parent == null) {
            node.isRed = false;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        balanceInsert(node);
    }

    private void balanceInsert(RBTNode k) {
        RBTNode uncle;
        while (k.parent.isRed) {
            if (k.parent == k.parent.parent.right) {
                uncle = k.parent.parent.left;
                if (uncle.isRed) {
                    uncle.isRed = false;
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rotateRight(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rotateLeft(k.parent.parent);
                }
            } else {
                uncle = k.parent.parent.right;
                if (uncle.isRed) {
                    uncle.isRed = false;
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        rotateLeft(k);
                    }
                    k.parent.isRed = false;
                    k.parent.parent.isRed = true;
                    rotateRight(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.isRed = false;
    }

    // Rotate left
    private void rotateLeft(RBTNode x) {
        RBTNode y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotate right
    private void rotateRight(RBTNode x) {
        RBTNode y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    // Delete method
    public void delete(int data) {
        deleteNodeHelper(root, data);
    }

    private void deleteNodeHelper(RBTNode node, int key) {
        RBTNode z = TNULL;
        RBTNode x, y;
        while (node != TNULL) {
            if (node.data == key) {
                z = node;
            }
            if (node.data <= key) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        if (z == TNULL) {
            System.out.println("Couldn't find key in the tree");
            return;
        }

        y = z;
        boolean yOriginalColor = y.isRed;
        if (z.left == TNULL) {
            x = z.right;
            transplant(z, z.right);
        } else if (z.right == TNULL) {
            x = z.left;
            transplant(z, z.left);
        } else {
            y = minimum(z.right);
            yOriginalColor = y.isRed;
            x = y.right;
            if (y.parent == z) {
                x.parent = y;
            } else {
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.isRed = z.isRed;
        }
        if (!yOriginalColor) {
            balanceDelete(x);
        }
    }

    private void balanceDelete(RBTNode x) {
        RBTNode s;
        while (x != root && !x.isRed) {
            if (x == x.parent.left) {
                s = x.parent.right;
                if (s.isRed) {
                    s.isRed = false;
                    x.parent.isRed = true;
                    rotateLeft(x.parent);
                    s = x.parent.right;
                }
                if (!s.left.isRed && !s.right.isRed) {
                    s.isRed = true;
                    x = x.parent;
                } else {
                    if (!s.right.isRed) {
                        s.left.isRed = false;
                        s.isRed = true;
                        rotateRight(s);
                        s = x.parent.right;
                    }
                    s.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    s.right.isRed = false;
                    rotateLeft(x.parent);
                    x = root;
                }
            } else {
                s = x.parent.left;
                if (s.isRed) {
                    s.isRed = false;
                    x.parent.isRed = true;
                    rotateRight(x.parent);
                    s = x.parent.left;
                }
                if (!s.right.isRed && !s.left.isRed) {
                    s.isRed = true;
                    x = x.parent;
                } else {
                    if (!s.left.isRed) {
                        s.right.isRed = false;
                        s.isRed = true;
                        rotateLeft(s);
                        s = x.parent.left;
                    }
                    s.isRed = x.parent.isRed;
                    x.parent.isRed = false;
                    s.left.isRed = false;
                    rotateRight(x.parent);
                    x = root;
                }
            }
        }
        x.isRed = false;
    }

    private void transplant(RBTNode u, RBTNode v) {
        if (u.parent == null) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }

    private RBTNode minimum(RBTNode node) {
        while (node.left != TNULL) {
            node = node.left;
        }
        return node;
    }

    // Print tree (Inorder Traversal)
    public void printTree() {
        printHelper(this.root, "", true);
    }

    private void printHelper(RBTNode node, String indent, boolean last) {
        if (node != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String color = node.isRed ? "RED" : "BLACK";
            System.out.println(node.data + "(" + color + ")");
            printHelper(node.left, indent, false);
            printHelper(node.right, indent, true);
        }
    }

    // Main method
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(20);
        tree.insert(15);
        tree.insert(25);
        tree.insert(10);
        tree.insert(5);

        tree.printTree();

        System.out.println("\nAfter deleting 15:");
        tree.delete(15);
        tree.printTree();

        RBTNode result = tree.search(10);
        System.out.println("\nSearch 10: " + (result != null && result != tree.TNULL ? "Found" : "Not Found"));
    }
}
