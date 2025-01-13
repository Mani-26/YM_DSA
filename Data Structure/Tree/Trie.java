class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean end;

    public TrieNode() {
        end = false;
        for (int i = 0; i < 26; i++) {
            child[i] = null;
        }
    }
}

public class Trie {
    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                current.child[index] = new TrieNode();
            }
            current = current.child[index];
        }
        current.end = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }
        return current.end;
    }

    // Check if a prefix exists in the trie
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.child[index] == null) {
                return false;
            }
            current = current.child[index];
        }
        return true;
    }

    // Helper function to check if a node is empty
    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Remove a word from the trie
    public TrieNode remove(TrieNode node, String word, int depth) {
        if (node == null) {
            return null;
        }

        if (depth == word.length()) {
            if (node.end) {
                node.end = false;
            }

            if (isEmpty(node)) {
                node = null;
            }
            return node;
        }

        int index = word.charAt(depth) - 'a';
        node.child[index] = remove(node.child[index], word, depth + 1);

        if (isEmpty(node) && !node.end) {
            node = null;
        }

        return node;
    }

    // Print all words stored in the trie
    public void printWords(TrieNode node, StringBuilder prefix) {
        if (node == null) {
            return;
        }

        if (node.end) {
            System.out.println(prefix.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                prefix.append((char) (i + 'a'));
                printWords(node.child[i], prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("catch");
        trie.insert("cat");
        trie.insert("code");

        System.out.println("Search 'cat': " + trie.search("cat"));
        System.out.println("Search 'code': " + trie.search("code"));
        System.out.println("Starts with 'hell': " + trie.startsWith("hell"));

        System.out.println("\nWords in the Trie:");
        trie.printWords(root, new StringBuilder());

        System.out.println("\nRemoving 'catch'...");
        trie.remove(root, "catch", 0);

        System.out.println("Search 'catch': " + trie.search("catch"));

        System.out.println("\nWords in the Trie after deletion:");
        trie.printWords(root, new StringBuilder());
    }
}
