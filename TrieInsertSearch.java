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

public class TrieInsertSearch {
    static TrieNode root;

    public TrieInsertSearch(){
        root=new TrieNode();
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
    public static void main(String[] args) {
        TrieInsertSearch t = new TrieInsertSearch();
        t.insert("hello");
        t.insert("catch");
        t.insert("cat");
        System.out.println(t.search("cat"));
        System.out.println(t.search("code"));
    }
}