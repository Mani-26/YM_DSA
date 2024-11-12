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

public class TriePrefixSearch {
    static TrieNode root;

    public TriePrefixSearch() {
        root = new TrieNode();
    }

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

    public static void main(String[] args) {
        TriePrefixSearch t = new TriePrefixSearch();
        t.insert("hello");
        t.insert("catch");
        t.insert("cat");
        System.out.println(t.search("cat"));
        System.out.println(t.search("code"));
        System.out.println(t.startsWith("hell"));
    }
}
